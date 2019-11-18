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

    @UpdateProvider(type = com.radebit.smartpi.provider.UpdateProvider.class,method = "updateDevice")
    Integer update(Device device);

    @Delete("delete from device where id = #{id}")
    Integer delete(int id);

    @Insert("INSERT INTO `smartpi`.`device`(`name`, `group_id`, `ascription`, `star`, `ip`, `auto_control`, `create_time`, `last_online_time`, `remark`, `cover_img`) VALUES (#{name},#{groupId},#{ascription},#{star},#{ip},#{autoControl},#{createTime},#{lastOnlineTime},#{remark},#{coverImg});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer add(Device device);
}
