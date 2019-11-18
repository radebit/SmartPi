package com.radebit.smartpi.service.impl;

import com.radebit.smartpi.mapper.GroupMapper;
import com.radebit.smartpi.model.po.Group;
import com.radebit.smartpi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-18 10:44
 * 说明：
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<Group> findAll() {
        return groupMapper.findAll();
    }

    @Override
    public Group findGroupById(int id) {
        return groupMapper.findGroupById(id);
    }

    @Override
    public Integer update(Group group) {
        return groupMapper.update(group);
    }

    @Override
    public Integer delete(int id) {
        return groupMapper.delete(id);
    }

    @Override
    public Integer add(Group group) {
        return groupMapper.add(group);
    }
}
