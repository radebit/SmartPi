package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.User;

/**
 * @Author Rade
 * @Date 2019-11-15 19:11
 * 说明：用户业务接口
 */

public interface UserService {

    User findUserById(int id);

    User findUserByUsername(String username);

    User findUserByPhone(String phone);

    boolean checkLogin(String username,String password);

    Integer update(User user);

    Integer delete(int id);

    Integer add(User user);
}
