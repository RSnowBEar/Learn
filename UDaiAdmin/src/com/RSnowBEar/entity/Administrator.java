package com.RSnowBEar.entity;


public class Administrator {

  private Long adminId;   //管理员编号
  private String adminName;   //管理员用户名
  private String adminPassword;   //密码
  private Integer pid;   //组ID
  private String iconRelativePath;  //头像相对路径
  private String iconRealPath;  //头像绝对路径

  public Administrator() { }

  public Administrator(Long adminId) {
    this.adminId = adminId;
  }

  public Administrator(String adminName, String adminPassword, Integer pid) {
    this.adminName = adminName;
    this.adminPassword = adminPassword;
    this.pid = pid;
  }

  public Administrator(String adminName, String adminPassword) {
    this.adminName = adminName;
    this.adminPassword = adminPassword;
  }

  @Override
  public String toString() {
    return "Administrator{" +
            "adminId=" + adminId +
            ", adminName='" + adminName + '\'' +
            ", adminPassword='" + adminPassword + '\'' +
            ", pid=" + pid +
            ", iconRelativePath='" + iconRelativePath + '\'' +
            ", iconRealPath='" + iconRealPath + '\'' +
            '}';
  }

  public Long getAdminId() {
    return adminId;
  }

  public void setAdminId(Long adminId) {
    this.adminId = adminId;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }


  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }


  public String getIconRelativePath() {
    return iconRelativePath;
  }

  public void setIconRelativePath(String iconRelativePath) {
    this.iconRelativePath = iconRelativePath;
  }


  public String getIconRealPath() {
    return iconRealPath;
  }

  public void setIconRealPath(String iconRealPath) {
    this.iconRealPath = iconRealPath;
  }

}
