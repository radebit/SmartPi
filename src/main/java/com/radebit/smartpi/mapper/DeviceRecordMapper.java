package com.radebit.smartpi.mapper;

import com.radebit.smartpi.model.po.DeviceRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-22 01:28
 * 说明：
 */
public interface DeviceRecordMapper {

    @Select("select * from device_record")
    List<DeviceRecord> findAll();

    @Select("select * from device_record where device_id = #{id}")
    List<DeviceRecord> findByDeviceId(Integer id);

    @Select("select * FROM device_record where record_time between  '${startTime}'  and '${endTime}'")
    List<DeviceRecord> findByTime(Timestamp startTime, Timestamp endTime);

    @Select("select * from device_record where id = #{id}")
    DeviceRecord findById(Integer id);

    @Insert("INSERT INTO `smartpi`.`device_record`(`device_id`, `record_time`, `air_temp`, `air_humidity`, `soil_moisture`, `co2`, `n_content`, `p_content`, `k_content`, `soil_fertility`, `ph`, `illumination`, `air_quality`) VALUES (#{deviceId},#{recordTime},#{airTemp},#{airHumidity},#{soilMoisture},#{co2},#{nContent},#{pContent},#{kContent},#{soilFertility},#{ph},#{illumination},#{airQuality});")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    Integer add(DeviceRecord deviceRecord);
}
