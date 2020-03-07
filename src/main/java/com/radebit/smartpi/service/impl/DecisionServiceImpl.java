package com.radebit.smartpi.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.radebit.smartpi.model.po.Decision;
import com.radebit.smartpi.mapper.DecisionMapper;
import com.radebit.smartpi.service.DecisionService;

import java.util.List;

@Service
public class DecisionServiceImpl implements DecisionService {

    @Resource
    private DecisionMapper decisionMapper;

    @Override
    public int deleteByPrimaryKey(Long decisionId) {
        return decisionMapper.deleteByPrimaryKey(decisionId);
    }

    @Override
    public int insert(Decision record) {
        return decisionMapper.insert(record);
    }

    @Override
    public int insertSelective(Decision record) {
        return decisionMapper.insertSelective(record);
    }

    @Override
    public Decision selectByPrimaryKey(Long decisionId) {
        return decisionMapper.selectByPrimaryKey(decisionId);
    }

    @Override
    public int updateByPrimaryKeySelective(Decision record) {
        return decisionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Decision record) {
        return decisionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Decision> selectByAll(Decision decision) {
        return decisionMapper.selectByAll(decision);
    }

}

