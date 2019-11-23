package com.radebit.smartpi.service.impl;

import com.radebit.smartpi.mapper.DeviceRecordMapper;
import com.radebit.smartpi.model.po.DeviceRecord;
import com.radebit.smartpi.service.DeviceRecordService;
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
public class DeviceRecordServiceImpl implements DeviceRecordService {

    @Autowired
    private DeviceRecordMapper deviceRecordMapper;

    @Override
    public List<DeviceRecord> findAll() {
        return deviceRecordMapper.findAll();
    }

    @Override
    public List<DeviceRecord> findByDeviceId(int id) {
        return deviceRecordMapper.findByDeviceId(id);
    }

    @Override
    public List<DeviceRecord> findAllByTime(Timestamp startTime, Timestamp endTime) {
        return deviceRecordMapper.findAllByTime(startTime,endTime);
    }

    @Override
    public List<DeviceRecord> findDeviceRecordByTime(int deviceId, Timestamp startTime, Timestamp endTime) {
        return deviceRecordMapper.findDeviceRecordByTime(deviceId,startTime,endTime);
    }

    @Override
    public DeviceRecord findById(Long id) {
        return deviceRecordMapper.findById(id);
    }

    @Override
    public Integer add(DeviceRecord deviceRecord) {
        return deviceRecordMapper.add(deviceRecord);
    }
}
