package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.DecisionGroup;

import java.util.List;

public interface DecisionGroupService {


    int deleteByPrimaryKey(Long groupId);

    int insert(DecisionGroup record);

    int insertSelective(DecisionGroup record);

    DecisionGroup selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(DecisionGroup record);

    int updateByPrimaryKey(DecisionGroup record);

    List<DecisionGroup> selectByAll(DecisionGroup decisionGroup);
}

