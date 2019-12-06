package com.radebit.smartpi.model.vo;

import java.io.Serializable;

/**
 * @Author Rade
 * @Date 2019-12-06 14:12
 * 说明：
 */
public class DeviceWarnVO implements Serializable {
    private Integer id;
    private String warnTime;
    private Integer deviceId;
    private String deviceName;
    private Integer deviceGroupId;
    private String  deviceGroupName;
    private String content;
    private String solution;
    private Integer isHandle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(String warnTime) {
        this.warnTime = warnTime;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDeviceGroupId() {
        return deviceGroupId;
    }

    public void setDeviceGroupId(Integer deviceGroupId) {
        this.deviceGroupId = deviceGroupId;
    }

    public String getDeviceGroupName() {
        return deviceGroupName;
    }

    public void setDeviceGroupName(String deviceGroupName) {
        this.deviceGroupName = deviceGroupName;
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
