package cn.ghy.larva.domain;

/**
 * @author Ziyang
 */
public class Role {
  private Long roleId;

  private String roleName;

  private Integer roleStatus;

  private String description;

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Integer getRoleStatus() {
    return roleStatus;
  }

  public void setRoleStatus(Integer roleStatus) {
    this.roleStatus = roleStatus;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}