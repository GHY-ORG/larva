package cn.ghy.larva.domain;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Ziyang
 */
public class User {
  @ApiModelProperty(name = "Uid")
  private Long userId;

  @ApiModelProperty(name = "用户名", notes = "用户名长度大于等于2且小于等于50", example = "鲁迅", required = true)
  @NotBlank
  @Size(min = 2, max = 50)
  private String userName;

  @ApiModelProperty(name = "用户密码", notes = "密码长度大于等于6且至少包含数字、字母、符号中的任意两种", example = "A1234567", required = true)
  @NotBlank
  @Pattern(regexp = "^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{6,}$")
  private String password;

  @ApiModelProperty(name = "真实姓名", notes = "真实姓名长度大于等于2且小于等于15", example = "周树人", required = true)
  @NotBlank
  @Size(min = 2, max = 15)
  private String realName;

  @ApiModelProperty(name = "用户邮箱", notes = "用户邮箱唯一", example = "example@ghy.cn", required = true)
  @NotBlank
  @Email
  private String userEmail;

  @ApiModelProperty(name = "用户状态", notes = "标记用户状态（如：未启用，注销，过期等）", example = "1", allowableValues = "0 | 1 | 2 | ...")
  private Integer userStatus;

  @ApiModelProperty(name = "用户创建时间", example = "2019-02-05T16:08:51.325Z")
  @Past
  private Date createTime;

  @ApiModelProperty(name = "用户上次修改信息时间", example = "2019-02-05T16:08:51.325Z")
  @Past
  private Date modifiedTime;

  @ApiModelProperty(name = "用户元字段")
  private List<Meta> metas;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
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

  public List<Meta> getMetas() {
    return metas;
  }

  public void setMetas(List<Meta> metas) {
    this.metas = metas;
  }
}