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
 * Body28
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class Body28 {
  @JsonProperty("folder_id")
  private String folderId = null;

  /**
   * The scope of the targeted metadata template. This template will need to already have an instance applied to the targeted folder.
   */
  public enum ScopeEnum {
    GLOBAL("global"),
    ENTERPRISE("enterprise");

    private String value;

    ScopeEnum(String value) {
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
    public static ScopeEnum fromValue(String text) {
      for (ScopeEnum b : ScopeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("scope")
  private ScopeEnum scope = null;

  @JsonProperty("templateKey")
  private String templateKey = null;

  public Body28 folderId(String folderId) {
    this.folderId = folderId;
    return this;
  }

   /**
   * The ID of the folder to apply the policy to. This folder will need to already have an instance of the targeted metadata template applied to it.
   * @return folderId
  **/
  @Schema(example = "1234567", required = true, description = "The ID of the folder to apply the policy to. This folder will need to already have an instance of the targeted metadata template applied to it.")
  public String getFolderId() {
    return folderId;
  }

  public void setFolderId(String folderId) {
    this.folderId = folderId;
  }

  public Body28 scope(ScopeEnum scope) {
    this.scope = scope;
    return this;
  }

   /**
   * The scope of the targeted metadata template. This template will need to already have an instance applied to the targeted folder.
   * @return scope
  **/
  @Schema(example = "enterprise", required = true, description = "The scope of the targeted metadata template. This template will need to already have an instance applied to the targeted folder.")
  public ScopeEnum getScope() {
    return scope;
  }

  public void setScope(ScopeEnum scope) {
    this.scope = scope;
  }

  public Body28 templateKey(String templateKey) {
    this.templateKey = templateKey;
    return this;
  }

   /**
   * The key of the targeted metadata template. This template will need to already have an instance applied to the targeted folder.  In many cases the template key is automatically derived of its display name, for example &#x60;Contract Template&#x60; would become &#x60;contractTemplate&#x60;. In some cases the creator of the template will have provided its own template key.  Please [list the templates for an enterprise][list], or get all instances on a [file][file] or [folder][folder] to inspect a template&#x27;s key.  [list]: e://get-metadata-templates-enterprise [file]: e://get-files-id-metadata [folder]: e://get-folders-id-metadata
   * @return templateKey
  **/
  @Schema(example = "productInfo", required = true, description = "The key of the targeted metadata template. This template will need to already have an instance applied to the targeted folder.  In many cases the template key is automatically derived of its display name, for example `Contract Template` would become `contractTemplate`. In some cases the creator of the template will have provided its own template key.  Please [list the templates for an enterprise][list], or get all instances on a [file][file] or [folder][folder] to inspect a template's key.  [list]: e://get-metadata-templates-enterprise [file]: e://get-files-id-metadata [folder]: e://get-folders-id-metadata")
  public String getTemplateKey() {
    return templateKey;
  }

  public void setTemplateKey(String templateKey) {
    this.templateKey = templateKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body28 body28 = (Body28) o;
    return Objects.equals(this.folderId, body28.folderId) &&
        Objects.equals(this.scope, body28.scope) &&
        Objects.equals(this.templateKey, body28.templateKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(folderId, scope, templateKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body28 {\n");
    
    sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    templateKey: ").append(toIndentedString(templateKey)).append("\n");
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
