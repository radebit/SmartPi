package com.radebit.smartpi.mapper;

import com.radebit.smartpi.model.po.DeviceSwitch;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-29 20:04
 * 说明：
 */
public interface DeviceSwitchMapper {

    @Select("select * from device_switch")
    List<DeviceSwitch> findAll();

    @Select("select * from device_switch where device_id = #{deviceId}")
    DeviceSwitch findDeviceSwitchByDeviceId(int deviceId);

    @UpdateProvider(type = com.radebit.smartpi.provider.UpdateProvider.class,method = "updateDeviceSwitch")
    Integer update(DeviceSwitch deviceSwitch);

    @Delete("DELETE FROM device_switch where device_id = #{deviceId}")
    Integer delete(int deviceId);

    @Insert("INSERT INTO `smartpi`.`device_switch`(`device_id`, `water1`, `water2`, `water3`, `heat`, `fan`, `humidifier`, `red`, `blue`, `green`, `yellow`, `Illumination`, `ultraviolet`) VALUES (#{deviceId}, #{water1}, #{water2}, #{water3}, #{heat}, #{fan}, #{humidifier}, #{red}, #{blue}, #{green}, #{yellow}, #{illumination}, #{ultraviolet});")
    Integer add(DeviceSwitch deviceSwitch);

}
