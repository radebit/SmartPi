package com.radebit.smartpi.model.po;


import java.io.Serializable;

public class Device implements Serializable {

  private Integer id;
  private String name;
  private Integer groupId;
  private Integer ascription;
  private Integer star;
  private String ip;
  private Integer autoControl;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp lastOnlineTime;
  private String remark;
  private String coverImg;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer group) {
    this.groupId = group;
  }


  public Integer getAscription() {
    return ascription;
  }

  public void setAscription(Integer ascription) {
    this.ascription = ascription;
  }


  public Integer getStar() {
    return star;
  }

  public void setStar(Integer star) {
    this.star = star;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public Integer getAutoControl() {
    return autoControl;
  }

  public void setAutoControl(Integer autoControl) {
    this.autoControl = autoControl;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getLastOnlineTime() {
    return lastOnlineTime;
  }

  public void setLastOnlineTime(java.sql.Timestamp lastOnlineTime) {
    this.lastOnlineTime = lastOnlineTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getCoverImg() {
    return coverImg;
  }

  public void setCoverImg(String coverImg) {
    this.coverImg = coverImg;
  }

}
