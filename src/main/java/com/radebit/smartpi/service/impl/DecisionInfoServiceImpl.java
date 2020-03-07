package com.radebit.smartpi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.radebit.smartpi.mapper.DecisionInfoMapper;
import com.radebit.smartpi.model.po.DecisionInfo;
import com.radebit.smartpi.service.DecisionInfoService;

import java.util.List;

@Service
public class DecisionInfoServiceImpl implements DecisionInfoService {

    @Resource
    private DecisionInfoMapper decisionInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long decisionUuid) {
        return decisionInfoMapper.deleteByPrimaryKey(decisionUuid);
    }

    @Override
    public int insert(DecisionInfo record) {
        return decisionInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(DecisionInfo record) {
        return decisionInfoMapper.insertSelective(record);
    }

    @Override
    public DecisionInfo selectByPrimaryKey(Long decisionUuid) {
        return decisionInfoMapper.selectByPrimaryKey(decisionUuid);
    }

    @Override
    public int updateByPrimaryKeySelective(DecisionInfo record) {
        return decisionInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DecisionInfo record) {
        return decisionInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<DecisionInfo> selectByDecisionId(Long decisionId) {
        return decisionInfoMapper.selectByDecisionId(decisionId);
    }

    @Override
    public int deleteByDecisionId(Long decisionId) {
        return decisionInfoMapper.deleteByDecisionId(decisionId);
    }

}




