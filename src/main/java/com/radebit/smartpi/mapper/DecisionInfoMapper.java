package com.radebit.smartpi.mapper;

import com.radebit.smartpi.model.po.DecisionInfo;

public interface DecisionInfoMapper {
    int deleteByPrimaryKey(Long decisionUuid);

    int insert(DecisionInfo record);

    int insertSelective(DecisionInfo record);

    DecisionInfo selectByPrimaryKey(Long decisionUuid);

    int updateByPrimaryKeySelective(DecisionInfo record);

    int updateByPrimaryKey(DecisionInfo record);
}