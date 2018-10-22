package cn.ghy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Ziyang
 * @Email meetziyang@gmail.com
 * @description 文件 前端控制器
 * @since 2018/10/2 17:54
 */
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 用户Id
   */
  @TableId(value = "uid", type = IdType.AUTO)
  private Integer uid;

  /**
   * 用户名
   */
  @NotNull
  @Size(min = 3, max = 20)
  private String userName;
  /**
   * 真实姓名
   */
  @NotNull
  @Size(min = 2, max = 15)
  private String realName;
  /**
   * 电子邮箱
   */
  @NotNull
  @Email
  private String email;
  /**
   * 密码
   */

  @NotNull
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$")
  private String password;
  /**
   * 头像地址
   */
  @NotNull
  @Pattern(regexp = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)")
  private String avatar;
  /**
   * 创建时间
   */
  @Past
  private LocalDateTime createTime;
  /**
   * 上次修改时间
   */
  @Past
  private LocalDateTime modifiedTime;
  /**
   * 是否可用
   */
  private Integer isEnabled;
  /**
   * 是否逻辑删除
   */
  @TableLogic
  private Integer isDeleted;

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public LocalDateTime getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(LocalDateTime modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public Integer getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(Integer isEnabled) {
    this.isEnabled = isEnabled;
  }

  public Integer getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

  @Override
  public String toString() {
    return "User{" +
        "uid=" + uid +
        ", userName=" + userName +
        ", realName=" + realName +
        ", email=" + email +
        ", password=" + password +
        ", avatar=" + avatar +
        ", createTime=" + createTime +
        ", modifiedTime=" + modifiedTime +
        ", isEnabled=" + isEnabled +
        ", isDeleted=" + isDeleted +
        "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(uid, user.uid) &&
        Objects.equals(userName, user.userName) &&
        Objects.equals(realName, user.realName) &&
        Objects.equals(email, user.email) &&
        Objects.equals(password, user.password) &&
        Objects.equals(avatar, user.avatar) &&
        Objects.equals(createTime, user.createTime) &&
        Objects.equals(modifiedTime, user.modifiedTime) &&
        Objects.equals(isEnabled, user.isEnabled) &&
        Objects.equals(isDeleted, user.isDeleted);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(uid, userName, realName, email, password, avatar, createTime, modifiedTime, isEnabled,
            isDeleted);
  }
}
