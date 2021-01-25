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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * The storage policy to assign to the user or enterprise
 */
@Schema(description = "The storage policy to assign to the user or enterprise")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class StoragePolicyAssignmentsStoragePolicy {
  /**
   * The type to assign.
   */
  public enum TypeEnum {
    POLICY("storage_policy");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("id")
  private String id = null;

  public StoragePolicyAssignmentsStoragePolicy type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type to assign.
   * @return type
  **/
  @Schema(example = "storage_policy", required = true, description = "The type to assign.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public StoragePolicyAssignmentsStoragePolicy id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the storage policy to assign.
   * @return id
  **/
  @Schema(example = "1434325", required = true, description = "The ID of the storage policy to assign.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoragePolicyAssignmentsStoragePolicy storagePolicyAssignmentsStoragePolicy = (StoragePolicyAssignmentsStoragePolicy) o;
    return Objects.equals(this.type, storagePolicyAssignmentsStoragePolicy.type) &&
        Objects.equals(this.id, storagePolicyAssignmentsStoragePolicy.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoragePolicyAssignmentsStoragePolicy {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
