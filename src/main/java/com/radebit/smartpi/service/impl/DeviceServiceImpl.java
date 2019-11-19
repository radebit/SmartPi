package com.radebit.smartpi.service.impl;

import com.radebit.smartpi.mapper.DeviceMapper;
import com.radebit.smartpi.model.po.Device;
import com.radebit.smartpi.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-18 20:57
 * 说明：
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<Device> findAll() {
        return deviceMapper.findAll();
    }

    @Override
    public Device findDeviceById(int id) {
        return deviceMapper.findDeviceById(id);
    }

    @Override
    public List<Device> findDeviceByName(String name) {
        return deviceMapper.findDeviceByName(name);
    }

    @Override
    public List<Device> findDeviceByGroup(int groupId) {
        return deviceMapper.findDeviceByGroup(groupId);
    }

    @Override
    public List<Device> findDeviceIsOnline(int isOnline) {
        return deviceMapper.findDeviceIsOnline(isOnline);
    }

    @Override
    public Integer update(Device device) {
        return deviceMapper.update(device);
    }

    @Override
    public Integer delete(int id) {
        return deviceMapper.delete(id);
    }

    @Override
    public Integer add(Device device) {
        return deviceMapper.add(device);
    }
}
