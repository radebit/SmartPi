package com.radebit.smartpi.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.radebit.smartpi.mapper.UserMapper;
import com.radebit.smartpi.model.po.User;
import com.radebit.smartpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Rade
 * @Date 2019-11-15 19:11
 * 说明：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        String relPassword = userMapper.findUserByUsername(username).getPassword();
        String md5Password = SecureUtil.md5(password);
        if (relPassword == null){
            return false;
        }
        return relPassword.equals(md5Password);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public Integer delete(int id) {
        return userMapper.delete(id);
    }

    @Override
    public Integer add(User user) {
        return userMapper.add(user);
    }
}
