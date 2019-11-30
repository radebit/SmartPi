package com.radebit.smartpi.service.impl;

import com.radebit.smartpi.mapper.DeviceSwitchMapper;
import com.radebit.smartpi.model.po.DeviceSwitch;
import com.radebit.smartpi.service.DeviceSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-30 20:55
 * 说明：
 */
@Service
public class DeviceSwitchServiceImpl implements DeviceSwitchService {

    @Autowired
    private DeviceSwitchMapper deviceSwitchMapper;

    @Override
    public List<DeviceSwitch> findAll() {
        return deviceSwitchMapper.findAll();
    }

    @Override
    public DeviceSwitch findDeviceSwitchByDeviceId(int deviceId) {
        return deviceSwitchMapper.findDeviceSwitchByDeviceId(deviceId);
    }

    @Override
    public Integer update(DeviceSwitch deviceSwitch) {
        return deviceSwitchMapper.update(deviceSwitch);
    }

    @Override
    public Integer delete(int deviceId) {
        return deviceSwitchMapper.delete(deviceId);
    }

    @Override
    public Integer add(DeviceSwitch deviceSwitch) {
        return deviceSwitchMapper.add(deviceSwitch);
    }
}
