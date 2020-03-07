package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.DecisionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DecisionInfoService {


    int deleteByPrimaryKey(Long decisionUuid);

    int insert(DecisionInfo record);

    int insertSelective(DecisionInfo record);

    DecisionInfo selectByPrimaryKey(Long decisionUuid);

    int updateByPrimaryKeySelective(DecisionInfo record);

    int updateByPrimaryKey(DecisionInfo record);

    List<DecisionInfo> selectByDecisionId(@Param("decisionId")Long decisionId);

    int deleteByDecisionId(@Param("decisionId")Long decisionId);
}




