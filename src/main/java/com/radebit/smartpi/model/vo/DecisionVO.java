package com.radebit.smartpi.model.vo;

import com.radebit.smartpi.model.po.DecisionInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Rade
 * @date 2020/3/7 4:39 下午
 * @url https://blog.radebit.com
 * 说明：
 */
public class DecisionVO implements Serializable {
    /**
     * 决策id
     */
    private Long decisionId;

    /**
     * 决策名称
     */
    private String decisionName;

    /**
     * 决策分组id
     */
    private String decisionGroupId;

    /**
     * 决策分组名称
     */
    private String decisionGroupName;

    /**
     * 决策状态(0-正常,1-禁用)
     */
    private String state;

    /**
     * 创建者
     */
    private String founder;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
    private Date createTime;

    private List<DecisionInfo> decisionInfoList;

    public Long getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(Long decisionId) {
        this.decisionId = decisionId;
    }

    public String getDecisionName() {
        return decisionName;
    }

    public void setDecisionName(String decisionName) {
        this.decisionName = decisionName;
    }

    public String getDecisionGroupId() {
        return decisionGroupId;
    }

    public void setDecisionGroupId(String decisionGroupId) {
        this.decisionGroupId = decisionGroupId;
    }

    public String getDecisionGroupName() {
        return decisionGroupName;
    }

    public void setDecisionGroupName(String decisionGroupName) {
        this.decisionGroupName = decisionGroupName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<DecisionInfo> getDecisionInfoList() {
        return decisionInfoList;
    }

    public void setDecisionInfoList(List<DecisionInfo> decisionInfoList) {
        this.decisionInfoList = decisionInfoList;
    }
}
