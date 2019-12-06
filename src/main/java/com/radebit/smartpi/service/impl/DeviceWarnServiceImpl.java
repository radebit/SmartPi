package com.radebit.smartpi.service.impl;

import com.radebit.smartpi.mapper.DeviceWarnMapper;
import com.radebit.smartpi.model.po.DeviceWarn;
import com.radebit.smartpi.service.DeviceWarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-12-06 15:10
 * 说明：
 */
@Service
public class DeviceWarnServiceImpl implements DeviceWarnService {

    @Autowired
    private DeviceWarnMapper deviceWarnMapper;

    @Override
    public List<DeviceWarn> findAll() {
        return deviceWarnMapper.findAll();
    }

    @Override
    public List<DeviceWarn> findByDeviceId(int deviceId) {
        return deviceWarnMapper.findByDeviceId(deviceId);
    }

    @Override
    public List<DeviceWarn> findNotHandle(int deviceId) {
        return deviceWarnMapper.findNotHandle(deviceId);
    }

    @Override
    public List<DeviceWarn> findHandle(int deviceId) {
        return deviceWarnMapper.findHandle(deviceId);
    }

    @Override
    public DeviceWarn findById(int id) {
        return deviceWarnMapper.findById(id);
    }

    @Override
    public Integer delete(int id) {
        return deviceWarnMapper.delete(id);
    }

    @Override
    public Integer add(DeviceWarn deviceWarn) {
        return deviceWarnMapper.add(deviceWarn);
    }

    @Override
    public Integer setWarnIsHandle(int isHandle,int id) {
        return deviceWarnMapper.setWarnHandle(isHandle,id);
    }
}
