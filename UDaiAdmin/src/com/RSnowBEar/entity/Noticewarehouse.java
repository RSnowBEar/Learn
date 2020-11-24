package com.RSnowBEar.entity;

public class Noticewarehouse {

  private Long noticeId;
  private Long type;
  private String title;
  private String content;

  public Noticewarehouse() {
  }

  public Noticewarehouse(Long noticeId) {
    this.noticeId = noticeId;
  }

  public Noticewarehouse(Long type, String title, String content) {
    this.type = type;
    this.title = title;
    this.content = content;
  }

  public Noticewarehouse(Long noticeId, Long type, String title, String content) {
    this.noticeId = noticeId;
    this.type = type;
    this.title = title;
    this.content = content;
  }

  public Long getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(Long noticeId) {
    this.noticeId = noticeId;
  }


  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
