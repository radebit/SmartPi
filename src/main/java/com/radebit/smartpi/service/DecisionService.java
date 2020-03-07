package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.Decision;

import java.util.List;

public interface DecisionService {


    int deleteByPrimaryKey(Long decisionId);

    int insert(Decision record);

    int insertSelective(Decision record);

    Decision selectByPrimaryKey(Long decisionId);

    int updateByPrimaryKeySelective(Decision record);

    int updateByPrimaryKey(Decision record);

    List<Decision> selectByAll(Decision decision);
}

