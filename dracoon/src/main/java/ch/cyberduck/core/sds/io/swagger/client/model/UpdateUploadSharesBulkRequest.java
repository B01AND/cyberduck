/*
 * DRACOON API
 * REST Web Services for DRACOON<br>built at: 1970-01-01 00:00:00.000<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.28.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.sds.io.swagger.client.model.ObjectExpiration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Request model for updating a list of Download Shares
 */
@Schema(description = "Request model for updating a list of Download Shares")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T23:34:01.480829+02:00[Europe/Paris]")
public class UpdateUploadSharesBulkRequest {
  @JsonProperty("expiration")
  private ObjectExpiration expiration = null;

  @JsonProperty("showCreatorName")
  private Boolean showCreatorName = null;

  @JsonProperty("showCreatorUsername")
  private Boolean showCreatorUsername = null;

  @JsonProperty("showUploadedFiles")
  private Boolean showUploadedFiles = null;

  @JsonProperty("maxSlots")
  private Integer maxSlots = null;

  @JsonProperty("resetMaxSlots")
  private Boolean resetMaxSlots = null;

  @JsonProperty("maxSize")
  private Long maxSize = null;

  @JsonProperty("resetMaxSize")
  private Boolean resetMaxSize = null;

  @JsonProperty("filesExpiryPeriod")
  private Integer filesExpiryPeriod = null;

  @JsonProperty("resetFilesExpiryPeriod")
  private Boolean resetFilesExpiryPeriod = null;

  @JsonProperty("objectIds")
  private List<Long> objectIds = new ArrayList<>();

  public UpdateUploadSharesBulkRequest expiration(ObjectExpiration expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Get expiration
   * @return expiration
  **/
  @Schema(description = "")
  public ObjectExpiration getExpiration() {
    return expiration;
  }

  public void setExpiration(ObjectExpiration expiration) {
    this.expiration = expiration;
  }

  public UpdateUploadSharesBulkRequest showCreatorName(Boolean showCreatorName) {
    this.showCreatorName = showCreatorName;
    return this;
  }

   /**
   * Show creator first and last name.
   * @return showCreatorName
  **/
  @Schema(description = "Show creator first and last name.")
  public Boolean isShowCreatorName() {
    return showCreatorName;
  }

  public void setShowCreatorName(Boolean showCreatorName) {
    this.showCreatorName = showCreatorName;
  }

  public UpdateUploadSharesBulkRequest showCreatorUsername(Boolean showCreatorUsername) {
    this.showCreatorUsername = showCreatorUsername;
    return this;
  }

   /**
   * Show creator email address.
   * @return showCreatorUsername
  **/
  @Schema(description = "Show creator email address.")
  public Boolean isShowCreatorUsername() {
    return showCreatorUsername;
  }

  public void setShowCreatorUsername(Boolean showCreatorUsername) {
    this.showCreatorUsername = showCreatorUsername;
  }

  public UpdateUploadSharesBulkRequest showUploadedFiles(Boolean showUploadedFiles) {
    this.showUploadedFiles = showUploadedFiles;
    return this;
  }

   /**
   * Allow display of already uploaded files
   * @return showUploadedFiles
  **/
  @Schema(description = "Allow display of already uploaded files")
  public Boolean isShowUploadedFiles() {
    return showUploadedFiles;
  }

  public void setShowUploadedFiles(Boolean showUploadedFiles) {
    this.showUploadedFiles = showUploadedFiles;
  }

  public UpdateUploadSharesBulkRequest maxSlots(Integer maxSlots) {
    this.maxSlots = maxSlots;
    return this;
  }

   /**
   * Maximal amount of files to upload
   * @return maxSlots
  **/
  @Schema(description = "Maximal amount of files to upload")
  public Integer getMaxSlots() {
    return maxSlots;
  }

  public void setMaxSlots(Integer maxSlots) {
    this.maxSlots = maxSlots;
  }

  public UpdateUploadSharesBulkRequest resetMaxSlots(Boolean resetMaxSlots) {
    this.resetMaxSlots = resetMaxSlots;
    return this;
  }

   /**
   * Set &#x27;true&#x27; to reset &#x27;maxSlots&#x27; for Upload Share
   * @return resetMaxSlots
  **/
  @Schema(description = "Set 'true' to reset 'maxSlots' for Upload Share")
  public Boolean isResetMaxSlots() {
    return resetMaxSlots;
  }

  public void setResetMaxSlots(Boolean resetMaxSlots) {
    this.resetMaxSlots = resetMaxSlots;
  }

  public UpdateUploadSharesBulkRequest maxSize(Long maxSize) {
    this.maxSize = maxSize;
    return this;
  }

   /**
   * Maximal total size of uploaded files (in bytes)
   * @return maxSize
  **/
  @Schema(description = "Maximal total size of uploaded files (in bytes)")
  public Long getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(Long maxSize) {
    this.maxSize = maxSize;
  }

  public UpdateUploadSharesBulkRequest resetMaxSize(Boolean resetMaxSize) {
    this.resetMaxSize = resetMaxSize;
    return this;
  }

   /**
   * Set &#x27;true&#x27; to reset &#x27;maxSize&#x27; for Upload Share
   * @return resetMaxSize
  **/
  @Schema(description = "Set 'true' to reset 'maxSize' for Upload Share")
  public Boolean isResetMaxSize() {
    return resetMaxSize;
  }

  public void setResetMaxSize(Boolean resetMaxSize) {
    this.resetMaxSize = resetMaxSize;
  }

  public UpdateUploadSharesBulkRequest filesExpiryPeriod(Integer filesExpiryPeriod) {
    this.filesExpiryPeriod = filesExpiryPeriod;
    return this;
  }

   /**
   * Number of days after which uploaded files expire
   * @return filesExpiryPeriod
  **/
  @Schema(description = "Number of days after which uploaded files expire")
  public Integer getFilesExpiryPeriod() {
    return filesExpiryPeriod;
  }

  public void setFilesExpiryPeriod(Integer filesExpiryPeriod) {
    this.filesExpiryPeriod = filesExpiryPeriod;
  }

  public UpdateUploadSharesBulkRequest resetFilesExpiryPeriod(Boolean resetFilesExpiryPeriod) {
    this.resetFilesExpiryPeriod = resetFilesExpiryPeriod;
    return this;
  }

   /**
   * Set &#x27;true&#x27; to reset &#x27;filesExpiryPeriod&#x27; for Upload Share
   * @return resetFilesExpiryPeriod
  **/
  @Schema(description = "Set 'true' to reset 'filesExpiryPeriod' for Upload Share")
  public Boolean isResetFilesExpiryPeriod() {
    return resetFilesExpiryPeriod;
  }

  public void setResetFilesExpiryPeriod(Boolean resetFilesExpiryPeriod) {
    this.resetFilesExpiryPeriod = resetFilesExpiryPeriod;
  }

  public UpdateUploadSharesBulkRequest objectIds(List<Long> objectIds) {
    this.objectIds = objectIds;
    return this;
  }

  public UpdateUploadSharesBulkRequest addObjectIdsItem(Long objectIdsItem) {
    this.objectIds.add(objectIdsItem);
    return this;
  }

   /**
   * List of ids
   * @return objectIds
  **/
  @Schema(required = true, description = "List of ids")
  public List<Long> getObjectIds() {
    return objectIds;
  }

  public void setObjectIds(List<Long> objectIds) {
    this.objectIds = objectIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUploadSharesBulkRequest updateUploadSharesBulkRequest = (UpdateUploadSharesBulkRequest) o;
    return Objects.equals(this.expiration, updateUploadSharesBulkRequest.expiration) &&
        Objects.equals(this.showCreatorName, updateUploadSharesBulkRequest.showCreatorName) &&
        Objects.equals(this.showCreatorUsername, updateUploadSharesBulkRequest.showCreatorUsername) &&
        Objects.equals(this.showUploadedFiles, updateUploadSharesBulkRequest.showUploadedFiles) &&
        Objects.equals(this.maxSlots, updateUploadSharesBulkRequest.maxSlots) &&
        Objects.equals(this.resetMaxSlots, updateUploadSharesBulkRequest.resetMaxSlots) &&
        Objects.equals(this.maxSize, updateUploadSharesBulkRequest.maxSize) &&
        Objects.equals(this.resetMaxSize, updateUploadSharesBulkRequest.resetMaxSize) &&
        Objects.equals(this.filesExpiryPeriod, updateUploadSharesBulkRequest.filesExpiryPeriod) &&
        Objects.equals(this.resetFilesExpiryPeriod, updateUploadSharesBulkRequest.resetFilesExpiryPeriod) &&
        Objects.equals(this.objectIds, updateUploadSharesBulkRequest.objectIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expiration, showCreatorName, showCreatorUsername, showUploadedFiles, maxSlots, resetMaxSlots, maxSize, resetMaxSize, filesExpiryPeriod, resetFilesExpiryPeriod, objectIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUploadSharesBulkRequest {\n");
    
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    showCreatorName: ").append(toIndentedString(showCreatorName)).append("\n");
    sb.append("    showCreatorUsername: ").append(toIndentedString(showCreatorUsername)).append("\n");
    sb.append("    showUploadedFiles: ").append(toIndentedString(showUploadedFiles)).append("\n");
    sb.append("    maxSlots: ").append(toIndentedString(maxSlots)).append("\n");
    sb.append("    resetMaxSlots: ").append(toIndentedString(resetMaxSlots)).append("\n");
    sb.append("    maxSize: ").append(toIndentedString(maxSize)).append("\n");
    sb.append("    resetMaxSize: ").append(toIndentedString(resetMaxSize)).append("\n");
    sb.append("    filesExpiryPeriod: ").append(toIndentedString(filesExpiryPeriod)).append("\n");
    sb.append("    resetFilesExpiryPeriod: ").append(toIndentedString(resetFilesExpiryPeriod)).append("\n");
    sb.append("    objectIds: ").append(toIndentedString(objectIds)).append("\n");
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