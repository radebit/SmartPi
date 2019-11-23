package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.DeviceRecord;
import com.radebit.smartpi.service.DeviceRecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Rade
 * @Date 2019-11-22 16:13
 * 说明：设备记录模块
 */
@Api(value = "设备记录模块")
@RestController
@RequestMapping("/api/v1/deviceRecord")
public class DeviceRecordController {

    @Autowired
    private DeviceRecordService deviceRecordService;

    /**
     * 获取全部记录
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findAll")
    public JsonData findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageHelper.startPage(page, size);
        List<DeviceRecord> list = deviceRecordService.findAll();
        PageInfo<DeviceRecord> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 获取设备对应记录
     *
     * @param deviceId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findDeviceId")
    public JsonData findDeviceId(@RequestParam(value = "device_id")Integer deviceId,
                                 @RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size){

        PageHelper.startPage(page, size);
        List<DeviceRecord> list = deviceRecordService.findByDeviceId(deviceId);
        PageInfo<DeviceRecord> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 获取时间段记录
     *
     * @param startTime
     * @param endTime
     * @param deviceId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findByTime")
    public JsonData findByTime(@RequestParam(value = "start_time")String startTime,
                               @RequestParam(value = "end_time")String endTime,
                               @RequestParam(value = "device_id",required = false)Integer deviceId,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageHelper.startPage(page, size);
        List<DeviceRecord> list;

        if (deviceId == null){
            list = deviceRecordService.findAllByTime(Timestamp.valueOf(startTime),Timestamp.valueOf(endTime));
        }else {
            list = deviceRecordService.findDeviceRecordByTime(deviceId,Timestamp.valueOf(startTime),Timestamp.valueOf(endTime));
        }
        PageInfo<DeviceRecord> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }
}
