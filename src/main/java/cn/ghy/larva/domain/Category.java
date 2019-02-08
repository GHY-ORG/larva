package cn.ghy.larva.domain;

/**
 * @author Ziyang
 */
public class Category {
  private Long categoryId;

  private String categoryName;

  private String categoryDescription;

  private Long parentCategory;

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCategoryDescription() {
    return categoryDescription;
  }

  public void setCategoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
  }

  public Long getParentCategory() {
    return parentCategory;
  }

  public void setParentCategory(Long parentCategory) {
    this.parentCategory = parentCategory;
  }
}