package com.RSnowBEar.entity;


public class Videos {

  private Long videoId;
  private String title;
  private String videoRelativePath;
  private String videoRealPath;
  private String imgRelaticePath;
  private String imgRealPath;

  public Videos() {
  }

  public Videos(Long videoId) {
    this.videoId = videoId;
  }

  public Videos(String title, String videoRelativePath, String videoRealPath, String imgRelaticePath, String imgRealPath) {
    this.title = title;
    this.videoRelativePath = videoRelativePath;
    this.videoRealPath = videoRealPath;
    this.imgRelaticePath = imgRelaticePath;
    this.imgRealPath = imgRealPath;
  }

  public Videos(String title, String videoRelativePath, String videoRealPath) {
    this.title = title;
    this.videoRelativePath = videoRelativePath;
    this.videoRealPath = videoRealPath;
  }

  public Long getVideoId() {
    return videoId;
  }

  public void setVideoId(Long videoId) {
    this.videoId = videoId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getVideoRelativePath() {
    return videoRelativePath;
  }

  public void setVideoRelativePath(String videoRelativePath) {
    this.videoRelativePath = videoRelativePath;
  }


  public String getVideoRealPath() {
    return videoRealPath;
  }

  public void setVideoRealPath(String videoRealPath) {
    this.videoRealPath = videoRealPath;
  }


  public String getImgRelaticePath() {
    return imgRelaticePath;
  }

  public void setImgRelaticePath(String imgRelaticePath) {
    this.imgRelaticePath = imgRelaticePath;
  }


  public String getImgRealPath() {
    return imgRealPath;
  }

  public void setImgRealPath(String imgRealPath) {
    this.imgRealPath = imgRealPath;
  }

}
