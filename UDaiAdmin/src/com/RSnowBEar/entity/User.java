package com.RSnowBEar.entity;

public class User {

  private Long userId;  //用户编号
  private String phone; //手机号
  private String loginPassword;   //登陆密码
  private String payPassword;   //支付密码
  private Integer gander;   //性别
  private java.sql.Date birthday;   //生日
  private String nickName;    //昵称
  private Double balance;   //余额
  private Integer integral;   //积分
  private Integer memberLevel;  //会员等级
  private String iconRelativePath;  //头像相对路径
  private String iconRealPath;  //头像绝对路径


  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", phone='" + phone + '\'' +
            ", loginPassword='" + loginPassword + '\'' +
            ", payPassword='" + payPassword + '\'' +
            ", gander=" + gander +
            ", birthday=" + birthday +
            ", nickName='" + nickName + '\'' +
            ", balance=" + balance +
            ", integral=" + integral +
            ", memberLevel=" + memberLevel +
            ", iconRelativePath='" + iconRelativePath + '\'' +
            ", iconRealPath='" + iconRealPath + '\'' +
            '}';
  }

  public User() {}

  public User(Long userId) {
    this.userId = userId;
  }

  public User(String phone, String loginPassword) {
    this.phone = phone;
    this.loginPassword = loginPassword;
    this.nickName = phone;
  }



  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }


  public String getPayPassword() {
    return payPassword;
  }

  public void setPayPassword(String payPassword) {
    this.payPassword = payPassword;
  }


  public Integer getGander() {
    return gander;
  }

  public void setGander(Integer gander) {
    this.gander = gander;
  }


  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }


  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }


  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }


  public Integer getIntegral() {
    return integral;
  }

  public void setIntegral(Integer integral) {
    this.integral = integral;
  }


  public Integer getMemberLevel() {
    return memberLevel;
  }

  public void setMemberLevel(Integer memberLevel) {
    this.memberLevel = memberLevel;
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
