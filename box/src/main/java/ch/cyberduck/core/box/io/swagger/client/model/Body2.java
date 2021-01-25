/*
 * Box Platform API
 * [Box Platform](https://box.dev) provides functionality to provide access to content stored within [Box](https://box.com). It provides endpoints for basic manipulation of files and folders, management of users within an enterprise, as well as more complex topics such as legal holds and retention policies.
 *
 * OpenAPI spec version: 2.0.0
 * Contact: devrel@box.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.box.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.box.io.swagger.client.model.File;
import ch.cyberduck.core.box.io.swagger.client.model.FilesfileIdcontentAttributes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Body2
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class Body2 {
  @JsonProperty("attributes")
  private FilesfileIdcontentAttributes attributes = null;

  @JsonProperty("file")
  private File file = null;

  public Body2 attributes(FilesfileIdcontentAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(required = true, description = "")
  public FilesfileIdcontentAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(FilesfileIdcontentAttributes attributes) {
    this.attributes = attributes;
  }

  public Body2 file(File file) {
    this.file = file;
    return this;
  }

   /**
   * The content of the file to upload to Box.  &lt;Message warning&gt;    The &#x60;attributes&#x60; part of the body must come **before** the   &#x60;file&#x60; part. Requests that do not follow this format when   uploading the file will receive a HTTP &#x60;400&#x60; error with a   &#x60;metadata_after_file_contents&#x60; error code.  &lt;/Message&gt;
   * @return file
  **/
  @Schema(required = true, description = "The content of the file to upload to Box.  <Message warning>    The `attributes` part of the body must come **before** the   `file` part. Requests that do not follow this format when   uploading the file will receive a HTTP `400` error with a   `metadata_after_file_contents` error code.  </Message>")
  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body2 body2 = (Body2) o;
    return Objects.equals(this.attributes, body2.attributes) &&
        Objects.equals(this.file, body2.file);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, Objects.hashCode(file));
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body2 {\n");
    
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
