package com.radebit.smartpi.mapper;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.radebit.smartpi.model.po.DecisionInfo;

public interface DecisionInfoMapper {
    int deleteByPrimaryKey(Long decisionUuid);

    int insert(DecisionInfo record);

    int insertSelective(DecisionInfo record);

    DecisionInfo selectByPrimaryKey(Long decisionUuid);

    int updateByPrimaryKeySelective(DecisionInfo record);

    int updateByPrimaryKey(DecisionInfo record);

    List<DecisionInfo> selectByDecisionId(@Param("decisionId")Long decisionId);

    List<DecisionInfo> selectByAll(DecisionInfo decisionInfo);

    int deleteByDecisionId(@Param("decisionId")Long decisionId);

}