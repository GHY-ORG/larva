package cn.ghy.larva.domain;

import java.util.Date;

/**
 * @author Ziyang
 */
public class File {
  private Long fileId;

  private String fileName;

  private String fileType;

  private Long fileSize;

  private String localUrl;

  private String visitUrl;

  private Long userId;

  private Date createTime;

  private Date modifiedTime;

  private String description;

  public Long getFileId() {
    return fileId;
  }

  public void setFileId(Long fileId) {
    this.fileId = fileId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public Long getFileSize() {
    return fileSize;
  }

  public void setFileSize(Long fileSize) {
    this.fileSize = fileSize;
  }

  public String getLocalUrl() {
    return localUrl;
  }

  public void setLocalUrl(String localUrl) {
    this.localUrl = localUrl;
  }

  public String getVisitUrl() {
    return visitUrl;
  }

  public void setVisitUrl(String visitUrl) {
    this.visitUrl = visitUrl;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}