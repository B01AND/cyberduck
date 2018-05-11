/*
 * DRACOON
 * Version 4.4.0 - built at: 2017-12-04 04:14:43, API server: https://demo.dracoon.com/api/v4
 *
 * OpenAPI spec version: 4.4.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import ch.cyberduck.core.sds.io.swagger.client.model.ConflictNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * BulkErrorInfos
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-03T10:55:56.129+02:00")
public class BulkErrorInfos {
  @JsonProperty("conflictNodes")
  private List<ConflictNode> conflictNodes = null;

  public BulkErrorInfos conflictNodes(List<ConflictNode> conflictNodes) {
    this.conflictNodes = conflictNodes;
    return this;
  }

  public BulkErrorInfos addConflictNodesItem(ConflictNode conflictNodesItem) {
    if (this.conflictNodes == null) {
      this.conflictNodes = new ArrayList<ConflictNode>();
    }
    this.conflictNodes.add(conflictNodesItem);
    return this;
  }

   /**
   * Get conflictNodes
   * @return conflictNodes
  **/
  @ApiModelProperty(value = "")
  public List<ConflictNode> getConflictNodes() {
    return conflictNodes;
  }

  public void setConflictNodes(List<ConflictNode> conflictNodes) {
    this.conflictNodes = conflictNodes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkErrorInfos bulkErrorInfos = (BulkErrorInfos) o;
    return Objects.equals(this.conflictNodes, bulkErrorInfos.conflictNodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conflictNodes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkErrorInfos {\n");
    
    sb.append("    conflictNodes: ").append(toIndentedString(conflictNodes)).append("\n");
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
