package cn.ghy.larva.domain;

import java.util.Date;
import java.util.List;

/**
 * @author Ziyang
 */
public class Post {
  private Long postId;

  private Long userId;

  private Integer postType;

  private Integer postRank;

  private Integer postStatus;

  private Date createTime;

  private Date modifiedTime;

  private String postTitle;

  private String postContent;

  private Category category;

  private List<Meta> metas;

  private List<Tag> tags;

  public Long getPostId() {
    return postId;
  }

  public void setPostId(Long postId) {
    this.postId = postId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getPostType() {
    return postType;
  }

  public void setPostType(Integer postType) {
    this.postType = postType;
  }

  public Integer getPostRank() {
    return postRank;
  }

  public void setPostRank(Integer postRank) {
    this.postRank = postRank;
  }

  public Integer getPostStatus() {
    return postStatus;
  }

  public void setPostStatus(Integer postStatus) {
    this.postStatus = postStatus;
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

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }

  public String getPostContent() {
    return postContent;
  }

  public void setPostContent(String postContent) {
    this.postContent = postContent;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<Meta> getMetas() {
    return metas;
  }

  public void setMetas(List<Meta> metas) {
    this.metas = metas;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }
}