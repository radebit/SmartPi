package com.radebit.smartpi.mapper;

import com.radebit.smartpi.model.po.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-18 10:05
 * 说明：
 */
public interface GroupMapper {

    @Select("select * from dev_group")
    List<Group> findAll();

    @Select("select * from dev_group where id = #{id}")
    Group findGroupById(int id);

    @UpdateProvider(type = com.radebit.smartpi.provider.UpdateProvider.class,method = "updateGroup")
    Integer update(Group group);

    @Delete("delete from dev_group where id = #{id}")
    Integer delete(int id);

    @Insert("INSERT INTO `smartpi`.`dev_group`(`group_name`) VALUES (#{groupName});")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    Integer add(Group group);
}
