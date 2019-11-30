package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.DeviceSwitch;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-30 20:50
 * 说明：
 */
public interface DeviceSwitchService {

    List<DeviceSwitch> findAll();

    DeviceSwitch findDeviceSwitchByDeviceId(int deviceId);

    Integer update(DeviceSwitch deviceSwitch);

    Integer delete(int deviceId);

    Integer add(DeviceSwitch deviceSwitch);
}
