package com.radebit.smartpi.mapper;

import com.radebit.smartpi.model.po.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-18 11:54
 * 说明：
 */
public interface DeviceMapper {

    @Select("select * from device")
    List<Device> findAll();

    @Select("select * from device where id = #{id}")
    Device findDeviceById(int id);

    @Select("select * from device where name like '%${name}%'")
    List<Device> findDeviceByName(String name);

    @Select("select * from device where group_id = #{groupId}")
    List<Device> findDeviceByGroup(int groupId);

    @Select("select * from device where is_online = #{isOnline}")
    List<Device> findDeviceIsOnline(int isOnline);

    @org.apache.ibatis.annotations.UpdateProvider(type = com.radebit.smartpi.provider.UpdateProvider.class,method = "updateDevice")
    Integer update(Device device);

    @Delete("delete from device where id = #{id}")
    Integer delete(int id);

    @Insert("INSERT INTO `smartpi`.`device`(`name`, `group_id`, `ascription`, `ip`, `create_time`,`last_online_time`, `remark`) VALUES (#{name},#{groupId},#{ascription},#{ip},#{createTime},#{lastOnlineTime},#{remark});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer add(Device device);
}
