package ch.cyberduck.core.transfer.upload;

import ch.cyberduck.core.DisabledProgressListener;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.NullLocal;
import ch.cyberduck.core.NullSession;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.TestProtocol;
import ch.cyberduck.core.features.AttributesFinder;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.core.transfer.symlink.DisabledUploadSymlinkResolver;

import org.junit.Test;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

public class RenameFilterTest {

    @Test
    public void testPrepare() throws Exception {
        RenameFilter f = new RenameFilter(new DisabledUploadSymlinkResolver(), new NullSession(new Host(new TestProtocol())));
        final Path t = new Path("t", EnumSet.of(Path.Type.file));
        f.prepare(t, new NullLocal("t"), new TransferStatus(), new DisabledProgressListener());
        assertNotSame("t", t.getName());
    }

    @Test
    public void testDirectoryUpload() throws Exception {
        final Path directory = new Path("/t", EnumSet.of(Path.Type.directory));
        final Path file = new Path(directory, "f", EnumSet.of(Path.Type.file));
        final AtomicBoolean found = new AtomicBoolean();
        final AtomicBoolean moved = new AtomicBoolean();
        final AttributesFinder attributes = new AttributesFinder() {
            @Override
            public PathAttributes find(final Path file, final ListProgressListener listener) {
                return new PathAttributes();
            }
        };
        final Find find = new Find() {
            @Override
            public boolean find(final Path f, final ListProgressListener listener) {
                if(f.equals(directory)) {
                    found.set(true);
                    return true;
                }
                return false;
            }
        };
        final NullSession session = new NullSession(new Host(new TestProtocol()));
        final RenameFilter f = new RenameFilter(new DisabledUploadSymlinkResolver(), session);
        f.withFinder(find).withAttributes(attributes);
        final TransferStatus directoryStatus = f.prepare(directory, new NullLocal("t"), new TransferStatus().exists(true), new DisabledProgressListener());
        assertTrue(found.get());
        assertNotNull(directoryStatus.getRename());
        assertNull(directoryStatus.getRename().local);
        assertNotNull(directoryStatus.getRename().remote);
        final TransferStatus fileStatus = f.prepare(file, new NullLocal("t/f"), directoryStatus, new DisabledProgressListener());
        assertNotNull(fileStatus.getRename());
        assertNull(fileStatus.getRename().local);
        assertNotNull(fileStatus.getRename().remote);
        assertEquals(new Path("/t-1/f", EnumSet.of(Path.Type.file)), fileStatus.getRename().remote);
    }
}
