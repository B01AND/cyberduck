/*
 * DRACOON
 * REST Web Services for DRACOON<br>Version: 4.20.1  - built at: 2020-04-05 23:00:17<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a>
 *
 * OpenAPI spec version: 4.20.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.sds.io.swagger.client.model.S3FileUploadPart;
import ch.cyberduck.core.sds.io.swagger.client.model.UserFileKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Request model for completing a S3 file upload
 */
@ApiModel(description = "Request model for completing a S3 file upload")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-08T17:57:49.759+02:00")
public class CompleteS3ShareUploadRequest {
  @JsonProperty("parts")
  private List<S3FileUploadPart> parts = new ArrayList<>();

  @JsonProperty("userFileKeyList")
  private List<UserFileKey> userFileKeyList = null;

  public CompleteS3ShareUploadRequest parts(List<S3FileUploadPart> parts) {
    this.parts = parts;
    return this;
  }

  public CompleteS3ShareUploadRequest addPartsItem(S3FileUploadPart partsItem) {
    this.parts.add(partsItem);
    return this;
  }

   /**
   * List of S3 file upload parts
   * @return parts
  **/
  @ApiModelProperty(required = true, value = "List of S3 file upload parts")
  public List<S3FileUploadPart> getParts() {
    return parts;
  }

  public void setParts(List<S3FileUploadPart> parts) {
    this.parts = parts;
  }

  public CompleteS3ShareUploadRequest userFileKeyList(List<UserFileKey> userFileKeyList) {
    this.userFileKeyList = userFileKeyList;
    return this;
  }

  public CompleteS3ShareUploadRequest addUserFileKeyListItem(UserFileKey userFileKeyListItem) {
    if (this.userFileKeyList == null) {
      this.userFileKeyList = new ArrayList<>();
    }
    this.userFileKeyList.add(userFileKeyListItem);
    return this;
  }

   /**
   * List of user file keys
   * @return userFileKeyList
  **/
  @ApiModelProperty(value = "List of user file keys")
  public List<UserFileKey> getUserFileKeyList() {
    return userFileKeyList;
  }

  public void setUserFileKeyList(List<UserFileKey> userFileKeyList) {
    this.userFileKeyList = userFileKeyList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteS3ShareUploadRequest completeS3ShareUploadRequest = (CompleteS3ShareUploadRequest) o;
    return Objects.equals(this.parts, completeS3ShareUploadRequest.parts) &&
        Objects.equals(this.userFileKeyList, completeS3ShareUploadRequest.userFileKeyList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parts, userFileKeyList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteS3ShareUploadRequest {\n");
    
    sb.append("    parts: ").append(toIndentedString(parts)).append("\n");
    sb.append("    userFileKeyList: ").append(toIndentedString(userFileKeyList)).append("\n");
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
