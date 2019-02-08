package cn.ghy.larva.domain;

import javax.validation.constraints.NotBlank;

/**
 * @author Ziyang
 */
public class Meta {
  @NotBlank
  private String metaKey;

  private String metaValue;

  public String getMetaKey() {
    return metaKey;
  }

  public void setMetaKey(String metaKey) {
    this.metaKey = metaKey;
  }

  public String getMetaValue() {
    return metaValue;
  }

  public void setMetaValue(String metaValue) {
    this.metaValue = metaValue;
  }
}