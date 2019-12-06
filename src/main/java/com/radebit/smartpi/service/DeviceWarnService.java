package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.DeviceWarn;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-12-06 14:40
 * 说明：
 */
public interface DeviceWarnService {

    List<DeviceWarn> findAll();

    List<DeviceWarn> findByDeviceId(int deviceId);

    List<DeviceWarn> findNotHandle(int deviceId);

    List<DeviceWarn> findHandle(int deviceId);

    DeviceWarn findById(int id);

    Integer delete(int id);

    Integer add(DeviceWarn deviceWarn);

    Integer setWarnIsHandle(int id);

    Integer setWarnIsNotHandle(int id);
}
