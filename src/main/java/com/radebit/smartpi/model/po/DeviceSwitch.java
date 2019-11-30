package com.radebit.smartpi.model.po;


import java.io.Serializable;

public class DeviceSwitch implements Serializable {

  private Integer deviceId;
  private Integer water1;
  private Integer water2;
  private Integer water3;
  private Integer heat;
  private Integer fan;
  private Integer humidifier;
  private Integer red;
  private Integer blue;
  private Integer green;
  private Integer yellow;
  private Integer illumination;
  private Integer ultraviolet;


  public Integer getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }


  public Integer getWater1() {
    return water1;
  }

  public void setWater1(Integer water1) {
    this.water1 = water1;
  }


  public Integer getWater2() {
    return water2;
  }

  public void setWater2(Integer water2) {
    this.water2 = water2;
  }


  public Integer getWater3() {
    return water3;
  }

  public void setWater3(Integer water3) {
    this.water3 = water3;
  }


  public Integer getHeat() {
    return heat;
  }

  public void setHeat(Integer heat) {
    this.heat = heat;
  }


  public Integer getFan() {
    return fan;
  }

  public void setFan(Integer fan) {
    this.fan = fan;
  }


  public Integer getHumidifier() {
    return humidifier;
  }

  public void setHumidifier(Integer humidifier) {
    this.humidifier = humidifier;
  }


  public Integer getRed() {
    return red;
  }

  public void setRed(Integer red) {
    this.red = red;
  }


  public Integer getBlue() {
    return blue;
  }

  public void setBlue(Integer blue) {
    this.blue = blue;
  }


  public Integer getGreen() {
    return green;
  }

  public void setGreen(Integer green) {
    this.green = green;
  }


  public Integer getYellow() {
    return yellow;
  }

  public void setYellow(Integer yellow) {
    this.yellow = yellow;
  }


  public Integer getIllumination() {
    return illumination;
  }

  public void setIllumination(Integer illumination) {
    this.illumination = illumination;
  }


  public Integer getUltraviolet() {
    return ultraviolet;
  }

  public void setUltraviolet(Integer ultraviolet) {
    this.ultraviolet = ultraviolet;
  }

}
