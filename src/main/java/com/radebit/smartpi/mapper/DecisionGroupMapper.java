package com.radebit.smartpi.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.radebit.smartpi.model.po.DecisionGroup;

public interface DecisionGroupMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(DecisionGroup record);

    int insertSelective(DecisionGroup record);

    DecisionGroup selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(DecisionGroup record);

    int updateByPrimaryKey(DecisionGroup record);

    List<DecisionGroup> selectByAll(DecisionGroup decisionGroup);

}