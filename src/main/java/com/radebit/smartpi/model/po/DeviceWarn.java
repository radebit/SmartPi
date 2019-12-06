package com.radebit.smartpi.model.po;


import java.io.Serializable;

public class DeviceWarn implements Serializable {

  private Integer id;
  private Integer deviceId;
  private java.sql.Timestamp warnTime;
  private String content;
  private String solution;
  private Integer isHandle;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }


  public java.sql.Timestamp getWarnTime() {
    return warnTime;
  }

  public void setWarnTime(java.sql.Timestamp warnTime) {
    this.warnTime = warnTime;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getSolution() {
    return solution;
  }

  public void setSolution(String solution) {
    this.solution = solution;
  }


  public Integer getIsHandle() {
    return isHandle;
  }

  public void setIsHandle(Integer isHandle) {
    this.isHandle = isHandle;
  }

}
