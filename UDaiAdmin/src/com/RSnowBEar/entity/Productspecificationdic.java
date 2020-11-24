package com.RSnowBEar.entity;


public class Productspecificationdic {

  private Long specificationDicId;    //规格字典ID
  private String specificationDicName;    //规格名
  private Long categoryID;
  private Long pid;   //父ID

  @Override
  public String toString() {
    return "Productspecificationdic{" +
            "specificationDicId=" + specificationDicId +
            ", specificationDicName='" + specificationDicName + '\'' +
            ", categoryID=" + categoryID +
            ", pid=" + pid +
            '}';
  }

  public Productspecificationdic() {
  }

  public Productspecificationdic(String specificationDicName, Long categoryID) {
    this.specificationDicName = specificationDicName;
    this.categoryID = categoryID;
  }

  public Productspecificationdic(Long specificationDicId, String specificationDicName, Long categoryID, Long pid) {
    this.specificationDicId = specificationDicId;
    this.specificationDicName = specificationDicName;
    this.categoryID = categoryID;
    this.pid = pid;
  }

  public Productspecificationdic(Long specificationDicId) {
    this.specificationDicId = specificationDicId;
  }

  public Productspecificationdic(Long specificationDicId, String specificationDicName, Long pid) {
    this.specificationDicId = specificationDicId;
    this.specificationDicName = specificationDicName;
    this.pid = pid;
  }

  public Long getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(Long categoryID) {
    this.categoryID = categoryID;
  }

  public Long getSpecificationDicId() {
    return specificationDicId;
  }

  public void setSpecificationDicId(Long specificationDicId) {
    this.specificationDicId = specificationDicId;
  }


  public String getSpecificationDicName() {
    return specificationDicName;
  }

  public void setSpecificationDicName(String specificationDicName) {
    this.specificationDicName = specificationDicName;
  }


  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

}
