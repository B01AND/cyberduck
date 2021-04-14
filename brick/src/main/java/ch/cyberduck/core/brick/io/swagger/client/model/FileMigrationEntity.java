/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Show File Migration
 */
@Schema(description = "Show File Migration")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class FileMigrationEntity {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("dest_path")
  private String destPath = null;

  @JsonProperty("files_moved")
  private Integer filesMoved = null;

  @JsonProperty("files_total")
  private Integer filesTotal = null;

  /**
   * The type of operation
   */
  public enum OperationEnum {
    DELETE("delete"),
    MOVE("move"),
    COPY("copy");

    private String value;

    OperationEnum(String value) {
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
    public static OperationEnum fromValue(String text) {
      for (OperationEnum b : OperationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("operation")
  private OperationEnum operation = null;

  @JsonProperty("region")
  private String region = null;

  /**
   * Status
   */
  public enum StatusEnum {
    PENDING("pending"),
    COUNTING("counting"),
    PROCESSING("processing"),
    COMPLETE("complete"),
    PROCESSING_SUBFOLDERS("processing_subfolders"),
    FINISHING("finishing"),
    CREATING_DEST_FOLDER("creating_dest_folder"),
    WAITING_FOR_OTHER_JOBS("waiting_for_other_jobs"),
    WAITING_FOR_ALL_FILES("waiting_for_all_files"),
    WAITING_FOR_PENDING_SUBFOLDERS("waiting_for_pending_subfolders"),
    WAITING_FOR_ALL_SUBFOLDERS("waiting_for_all_subfolders"),
    FAILED("failed"),
    WAITING_FOR_ENQUEUED_OPERATIONS("waiting_for_enqueued_operations"),
    PROCESSING_DEFERRED_FOLDERS("processing_deferred_folders"),
    PROCESSING_RECURSIVELY("processing_recursively");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("status")
  private StatusEnum status = null;

  public FileMigrationEntity id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * File migration ID
   * @return id
  **/
  @Schema(example = "1", description = "File migration ID")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public FileMigrationEntity path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Source path
   * @return path
  **/
  @Schema(example = "MyFolder", description = "Source path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public FileMigrationEntity destPath(String destPath) {
    this.destPath = destPath;
    return this;
  }

   /**
   * Destination path
   * @return destPath
  **/
  @Schema(example = "MyFolder", description = "Destination path")
  public String getDestPath() {
    return destPath;
  }

  public void setDestPath(String destPath) {
    this.destPath = destPath;
  }

  public FileMigrationEntity filesMoved(Integer filesMoved) {
    this.filesMoved = filesMoved;
    return this;
  }

   /**
   * Number of files processed
   * @return filesMoved
  **/
  @Schema(example = "1", description = "Number of files processed")
  public Integer getFilesMoved() {
    return filesMoved;
  }

  public void setFilesMoved(Integer filesMoved) {
    this.filesMoved = filesMoved;
  }

  public FileMigrationEntity filesTotal(Integer filesTotal) {
    this.filesTotal = filesTotal;
    return this;
  }

   /**
   * Total number of files to process
   * @return filesTotal
  **/
  @Schema(example = "1", description = "Total number of files to process")
  public Integer getFilesTotal() {
    return filesTotal;
  }

  public void setFilesTotal(Integer filesTotal) {
    this.filesTotal = filesTotal;
  }

  public FileMigrationEntity operation(OperationEnum operation) {
    this.operation = operation;
    return this;
  }

   /**
   * The type of operation
   * @return operation
  **/
  @Schema(example = "move", description = "The type of operation")
  public OperationEnum getOperation() {
    return operation;
  }

  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }

  public FileMigrationEntity region(String region) {
    this.region = region;
    return this;
  }

   /**
   * Region
   * @return region
  **/
  @Schema(example = "USA", description = "Region")
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public FileMigrationEntity status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Status
   * @return status
  **/
  @Schema(example = "complete", description = "Status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileMigrationEntity fileMigrationEntity = (FileMigrationEntity) o;
    return Objects.equals(this.id, fileMigrationEntity.id) &&
        Objects.equals(this.path, fileMigrationEntity.path) &&
        Objects.equals(this.destPath, fileMigrationEntity.destPath) &&
        Objects.equals(this.filesMoved, fileMigrationEntity.filesMoved) &&
        Objects.equals(this.filesTotal, fileMigrationEntity.filesTotal) &&
        Objects.equals(this.operation, fileMigrationEntity.operation) &&
        Objects.equals(this.region, fileMigrationEntity.region) &&
        Objects.equals(this.status, fileMigrationEntity.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, path, destPath, filesMoved, filesTotal, operation, region, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileMigrationEntity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    destPath: ").append(toIndentedString(destPath)).append("\n");
    sb.append("    filesMoved: ").append(toIndentedString(filesMoved)).append("\n");
    sb.append("    filesTotal: ").append(toIndentedString(filesTotal)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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