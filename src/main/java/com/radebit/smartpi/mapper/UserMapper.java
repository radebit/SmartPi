package com.radebit.smartpi.mapper;

import com.radebit.smartpi.model.po.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author Rade
 * @Date 2019-11-15 15:39
 * 说明：
 */
public interface UserMapper {

    /**
     * 通过ID查找用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findUserById(int id);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User findUserByUsername(String username);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @UpdateProvider(type = com.radebit.smartpi.provider.UpdateProvider.class,method = "updateUser")
    Integer update(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{id}")
    Integer delete(int id);

    @Insert("INSERT INTO `smartpi`.`user`(`username`, `password`, `email`, `phone`, `gender`) VALUES (#{username}, #{password}, #{email}, #{phone}, #{gender});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer add(User user);

}
