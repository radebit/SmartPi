package com.radebit.smartpi.mapper;

import com.radebit.smartpi.model.po.DeviceWarn;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-12-06 14:21
 * 说明：
 */
public interface DeviceWarnMapper {

    @Select("select * from device_warn")
    List<DeviceWarn> findAll();

    @Select("select * from device_warn where device_id = #{deviceId}")
    List<DeviceWarn> findByDeviceId(int deviceId);

    @Select("select * from device_warn where is_handle = 0 and device_id = #{deviceId}")
    List<DeviceWarn> findNotHandle(int deviceId);

    @Select("select * from device_warn where is_handle = 1 and device_id = #{deviceId}")
    List<DeviceWarn> findHandle(int deviceId);

    @Select("select * from device_warn where id = #{id}")
    DeviceWarn findById(int id);

    @Delete("delete from device_warn where id = #{id}")
    Integer delete(int id);

    @Insert("INSERT INTO `smartpi`.`device_warn`(`device_id`, `warn_time`, `content`, `solution`, `is_handle`) VALUES (#{deviceId}, #{warnTime}, #{content}, #{solution}, #{isHandle});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer add(DeviceWarn deviceWarn);

    @Update("UPDATE `smartpi`.`device_warn` SET is_handle = #{isHandle} WHERE `id` = #{id};")
    Integer setWarnHandle(int isHandle,int id);

}
