package com.radebit.smartpi.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author Rade
 * @Date 2019-11-18 21:00
 * 说明：设备视图层对象
 */
public class DeviceVO implements Serializable {
    private Integer id;
    private String name;
    private Integer groupId;
    private String groupName;
    private Integer ascriptionId;
    private String ascriptionName;
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

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAscriptionId() {
        return ascriptionId;
    }

    public void setAscriptionId(Integer ascriptionId) {
        this.ascriptionId = ascriptionId;
    }

    public String getAscriptionName() {
        return ascriptionName;
    }

    public void setAscriptionName(String ascriptionName) {
        this.ascriptionName = ascriptionName;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(Timestamp lastOnlineTime) {
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
