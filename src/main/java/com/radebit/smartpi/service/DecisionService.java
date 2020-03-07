package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.Decision;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DecisionService {


    int deleteByPrimaryKey(Long decisionId);

    int insert(Decision record);

    int insertSelective(Decision record);

    Decision selectByPrimaryKey(Long decisionId);

    int updateByPrimaryKeySelective(Decision record);

    int updateByPrimaryKey(Decision record);

    List<Decision> selectByAll(Decision decision);

    List<Decision> selectByDecisionGroup(@Param("decisionGroup")String decisionGroup);

    Integer countByDecisionGroup(@Param("decisionGroup")String decisionGroup);
}



