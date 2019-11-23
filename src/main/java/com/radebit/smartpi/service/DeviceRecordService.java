package com.radebit.smartpi.service;

import com.radebit.smartpi.model.po.DeviceRecord;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-22 15:31
 * 说明：
 */
public interface DeviceRecordService {

    List<DeviceRecord> findAll();

    List<DeviceRecord> findByDeviceId(int id);

    List<DeviceRecord> findAllByTime(Timestamp startTime, Timestamp endTime);

    List<DeviceRecord> findDeviceRecordByTime(int deviceId,Timestamp startTime, Timestamp endTime);

    DeviceRecord findById(Long id);

    Integer delete(Long id);

    Integer add(DeviceRecord deviceRecord);
}
