package com.RSnowBEar.entity;


public class Productcategorydic {

  private long categoryId;    //类别ID
  private String categoryName;    //类别名
  private long pid;   //父ID

  public Productcategorydic() {
  }

  public Productcategorydic(long categoryId) {
    this.categoryId = categoryId;
  }

  public Productcategorydic(long categoryId, String categoryName, long pid) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.pid = pid;
  }

  public Productcategorydic(String categoryName) {
    this.categoryName = categoryName;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }

}
