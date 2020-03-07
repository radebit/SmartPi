package com.radebit.smartpi.model.po;

import java.util.Date;

public class Decision {
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
    private String decisionGroup;

    /**
     * 决策状态(0-正常,1-禁用)
     */
    private String state;

    /**
     * 创建者
     */
    private Long founder;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
    private Date createTime;

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

    public String getDecisionGroup() {
        return decisionGroup;
    }

    public void setDecisionGroup(String decisionGroup) {
        this.decisionGroup = decisionGroup;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getFounder() {
        return founder;
    }

    public void setFounder(Long founder) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", decisionId=").append(decisionId);
        sb.append(", decisionName=").append(decisionName);
        sb.append(", decisionGroup=").append(decisionGroup);
        sb.append(", state=").append(state);
        sb.append(", founder=").append(founder);
        sb.append(", remarks=").append(remarks);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}