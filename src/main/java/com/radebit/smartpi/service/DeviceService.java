package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.Device;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-18 20:55
 * 说明：
 */
public interface DeviceService {

    List<Device> findAll();

    Device findDeviceById(int id);

    List<Device> findDeviceByName(String name);

    List<Device> findDeviceByGroup(int groupId);

    List<Device> findDeviceIsOnline(int isOnline);

    Integer update(Device device);

    Integer delete(int id);

    Integer add(Device device);
}
