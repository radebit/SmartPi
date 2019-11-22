package com.radebit.smartpi.service.impl;

import com.radebit.smartpi.mapper.DeviceRecordMapper;
import com.radebit.smartpi.model.po.DeviceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-22 15:32
 * 说明：
 */
@Service
public class DeviceRecordServiceImpl implements DeviceRecordMapper {

    @Autowired
    private DeviceRecordMapper deviceRecordMapper;

    @Override
    public List<DeviceRecord> findAll() {
        return deviceRecordMapper.findAll();
    }

    @Override
    public List<DeviceRecord> findByDeviceId(Integer id) {
        return deviceRecordMapper.findByDeviceId(id);
    }

    @Override
    public List<DeviceRecord> findByTime(Timestamp startTime, Timestamp endTime) {
        return deviceRecordMapper.findByTime(startTime,endTime);
    }

    @Override
    public DeviceRecord findById(Integer id) {
        return deviceRecordMapper.findById(id);
    }

    @Override
    public Integer add(DeviceRecord deviceRecord) {
        return deviceRecordMapper.add(deviceRecord);
    }
}
