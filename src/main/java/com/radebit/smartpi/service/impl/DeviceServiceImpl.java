package com.radebit.smartpi.service.impl;

import com.radebit.smartpi.mapper.DeviceMapper;
import com.radebit.smartpi.model.po.Device;
import com.radebit.smartpi.model.po.DeviceSwitch;
import com.radebit.smartpi.service.DeviceService;
import com.radebit.smartpi.service.DeviceSwitchService;
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

    @Autowired
    private DeviceSwitchService deviceSwitchService;

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
        if (deviceSwitchService.delete(id)!=1){
            return 0;
        }
        return deviceMapper.delete(id);
    }

    @Override
    public Integer add(Device device) {
        Integer add = deviceMapper.add(device);

        //绑定开关表，新增一条对应记录
        DeviceSwitch deviceSwitch = new DeviceSwitch();
        deviceSwitch.setDeviceId(device.getId());
        deviceSwitch.setWater1(0);
        deviceSwitch.setWater2(0);
        deviceSwitch.setWater3(0);
        deviceSwitch.setHeat(0);
        deviceSwitch.setFan(0);
        deviceSwitch.setHumidifier(0);
        deviceSwitch.setRed(0);
        deviceSwitch.setBlue(0);
        deviceSwitch.setGreen(0);
        deviceSwitch.setYellow(0);
        deviceSwitch.setIllumination(0);
        deviceSwitch.setUltraviolet(0);

        if (deviceSwitchService.add(deviceSwitch) != 1) {
            return 0;
        }

        return add;
    }
}
