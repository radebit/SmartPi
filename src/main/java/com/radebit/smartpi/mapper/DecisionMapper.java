package com.radebit.smartpi.mapper;
import org.apache.ibatis.annotations.Param;

import com.radebit.smartpi.model.po.Decision;import java.util.List;

public interface DecisionMapper {
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