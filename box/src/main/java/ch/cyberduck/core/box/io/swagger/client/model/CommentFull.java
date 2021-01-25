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
import ch.cyberduck.core.box.io.swagger.client.model.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * Comments are messages created on files. Comments can be made independently or created as responses to other comments
 */
@Schema(description = "Comments are messages created on files. Comments can be made independently or created as responses to other comments")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class CommentFull extends Comment {
  @JsonProperty("tagged_message")
  private String taggedMessage = null;

  public CommentFull taggedMessage(String taggedMessage) {
    this.taggedMessage = taggedMessage;
    return this;
  }

   /**
   * The string representing the comment text with @mentions included. @mention format is @[id:username] where &#x60;id&#x60; is user&#x27;s Box ID and &#x60;username&#x60; is their display name.
   * @return taggedMessage
  **/
  @Schema(example = "@[1234567:Aaron Levie] these tigers are cool!", description = "The string representing the comment text with @mentions included. @mention format is @[id:username] where `id` is user's Box ID and `username` is their display name.")
  public String getTaggedMessage() {
    return taggedMessage;
  }

  public void setTaggedMessage(String taggedMessage) {
    this.taggedMessage = taggedMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentFull commentFull = (CommentFull) o;
    return Objects.equals(this.taggedMessage, commentFull.taggedMessage) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taggedMessage, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentFull {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    taggedMessage: ").append(toIndentedString(taggedMessage)).append("\n");
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
