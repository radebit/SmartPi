package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.Group;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-18 10:26
 * 说明：
 */
public interface GroupService {

    List<Group> findAll();

    Group findGroupById(int id);

    Integer update(Group group);

    Integer delete(int id);

    Integer add(Group group);
}
