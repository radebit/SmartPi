package com.radebit.smartpi.service.impl;

import com.radebit.smartpi.mapper.DeviceMapper;
import com.radebit.smartpi.model.po.Device;
import com.radebit.smartpi.model.po.DeviceRecord;
import com.radebit.smartpi.model.po.DeviceSwitch;
import com.radebit.smartpi.model.po.DeviceWarn;
import com.radebit.smartpi.service.DeviceRecordService;
import com.radebit.smartpi.service.DeviceService;
import com.radebit.smartpi.service.DeviceSwitchService;
import com.radebit.smartpi.service.DeviceWarnService;
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

    @Autowired
    private DeviceRecordService deviceRecordService;

    @Autowired
    private DeviceWarnService deviceWarnService;

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
        //处理删除设备后同步删除record
        for (DeviceRecord deviceRecord:deviceRecordService.findByDeviceId(id)){
            deviceRecordService.delete(deviceRecord.getId());
        }
        //处理删除设备后同步删除switch
        deviceSwitchService.delete(id);
        //处理删除设备后同步删除warn
        for (DeviceWarn deviceWarn:deviceWarnService.findByDeviceId(id)){
            deviceWarnService.delete(deviceWarn.getId());
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
