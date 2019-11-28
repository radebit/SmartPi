package com.radebit.smartpi.model.vo;

import java.io.Serializable;

/**
 * @Author Rade
 * @Date 2019-11-28 14:15
 * 说明：
 */
public class DeviceRecordVO implements Serializable {

    private Long id;
    private Integer deviceId;
    private String recordTime;
    private String airTemp;
    private String airHumidity;
    private String soilMoisture;
    private String co2;
    private String nContent;
    private String pContent;
    private String kContent;
    private Integer soilFertility;
    private String ph;
    private String illumination;
    private String airQuality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(String airTemp) {
        this.airTemp = airTemp;
    }

    public String getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(String airHumidity) {
        this.airHumidity = airHumidity;
    }

    public String getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(String soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public String getkContent() {
        return kContent;
    }

    public void setkContent(String kContent) {
        this.kContent = kContent;
    }

    public Integer getSoilFertility() {
        return soilFertility;
    }

    public void setSoilFertility(Integer soilFertility) {
        this.soilFertility = soilFertility;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getIllumination() {
        return illumination;
    }

    public void setIllumination(String illumination) {
        this.illumination = illumination;
    }

    public String getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(String airQuality) {
        this.airQuality = airQuality;
    }
}
