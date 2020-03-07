package com.radebit.smartpi.model.po;

import java.util.Date;

public class DecisionInfo {
    /**
     * 决策uuid
     */
    private Long decisionUuid;

    /**
     * 决策id
     */
    private Long decisionId;

    /**
     * 开始执行时间
     */
    private Date startTime;

    /**
     * 结束执行时间
     */
    private Date endTime;

    /**
     * 空气温度
     */
    private String airTemp;

    /**
     * 空气湿度
     */
    private String airHumidity;

    /**
     * 土壤湿度
     */
    private String soilMoisture;

    /**
     * 二氧化碳浓度
     */
    private String co2;

    /**
     * 含氮量
     */
    private String nContent;

    /**
     * 含磷量
     */
    private String pContent;

    /**
     * 含钾量
     */
    private String kContent;

    /**
     * 土壤肥力
     */
    private String soilFertility;

    /**
     * 土壤PH值
     */
    private String ph;

    /**
     * 光照强度
     */
    private String illumination;

    /**
     * 红光光照强度
     */
    private String red;

    /**
     * 蓝光光照强度
     */
    private String blue;

    /**
     * 绿光光照强度
     */
    private String green;

    /**
     * 黄光光照强度
     */
    private String yellow;

    public Long getDecisionUuid() {
        return decisionUuid;
    }

    public void setDecisionUuid(Long decisionUuid) {
        this.decisionUuid = decisionUuid;
    }

    public Long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(Long decisionId) {
        this.decisionId = decisionId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getSoilFertility() {
        return soilFertility;
    }

    public void setSoilFertility(String soilFertility) {
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

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getBlue() {
        return blue;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public String getGreen() {
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public String getYellow() {
        return yellow;
    }

    public void setYellow(String yellow) {
        this.yellow = yellow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", decisionUuid=").append(decisionUuid);
        sb.append(", decisionId=").append(decisionId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", airTemp=").append(airTemp);
        sb.append(", airHumidity=").append(airHumidity);
        sb.append(", soilMoisture=").append(soilMoisture);
        sb.append(", co2=").append(co2);
        sb.append(", nContent=").append(nContent);
        sb.append(", pContent=").append(pContent);
        sb.append(", kContent=").append(kContent);
        sb.append(", soilFertility=").append(soilFertility);
        sb.append(", ph=").append(ph);
        sb.append(", illumination=").append(illumination);
        sb.append(", red=").append(red);
        sb.append(", blue=").append(blue);
        sb.append(", green=").append(green);
        sb.append(", yellow=").append(yellow);
        sb.append("]");
        return sb.toString();
    }
}