package com.radebit.smartpi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.radebit.smartpi.model.po.DecisionGroup;
import com.radebit.smartpi.mapper.DecisionGroupMapper;
import com.radebit.smartpi.service.DecisionGroupService;

import java.util.List;

@Service
public class DecisionGroupServiceImpl implements DecisionGroupService {

    @Resource
    private DecisionGroupMapper decisionGroupMapper;

    @Override
    public int deleteByPrimaryKey(Long groupId) {
        return decisionGroupMapper.deleteByPrimaryKey(groupId);
    }

    @Override
    public int insert(DecisionGroup record) {
        return decisionGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(DecisionGroup record) {
        return decisionGroupMapper.insertSelective(record);
    }

    @Override
    public DecisionGroup selectByPrimaryKey(Long groupId) {
        return decisionGroupMapper.selectByPrimaryKey(groupId);
    }

    @Override
    public int updateByPrimaryKeySelective(DecisionGroup record) {
        return decisionGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DecisionGroup record) {
        return decisionGroupMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<DecisionGroup> selectByAll(DecisionGroup decisionGroup) {
        return decisionGroupMapper.selectByAll(decisionGroup);
    }

}

