package com.RSnowBEar.entity;


public class Productspecificationvalues {

  private long specificationId;   //规格值ID
  private long specificationDicId;  //规格字典ID
  private String specificationName;   //规格值

  public Productspecificationvalues() {
  }

  @Override
  public String toString() {
    return "Productspecificationvalues{" +
            "specificationId=" + specificationId +
            ", specificationDicId=" + specificationDicId +
            ", specificationName='" + specificationName + '\'' +
            '}';
  }

  public Productspecificationvalues(long specificationId) {
    this.specificationId = specificationId;
  }

  public Productspecificationvalues(long specificationDicId, String specificationName) {
    this.specificationDicId = specificationDicId;
    this.specificationName = specificationName;
  }

  public Productspecificationvalues(long specificationId, long specificationDicId, String specificationName) {
    this.specificationId = specificationId;
    this.specificationDicId = specificationDicId;
    this.specificationName = specificationName;
  }

  public long getSpecificationId() {
    return specificationId;
  }

  public void setSpecificationId(long specificationId) {
    this.specificationId = specificationId;
  }


  public long getSpecificationDicId() {
    return specificationDicId;
  }

  public void setSpecificationDicId(long specificationDicId) {
    this.specificationDicId = specificationDicId;
  }


  public String getSpecificationName() {
    return specificationName;
  }

  public void setSpecificationName(String specificationName) {
    this.specificationName = specificationName;
  }

}
