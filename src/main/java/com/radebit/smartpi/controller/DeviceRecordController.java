package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.DeviceRecord;
import com.radebit.smartpi.service.DeviceRecordService;
import com.radebit.smartpi.service.DeviceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
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

    @Autowired
    private DeviceService deviceService;

    /**
     * 获取全部记录
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findAll")
    public JsonData findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
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
    public JsonData findDeviceId(@RequestParam(value = "device_id") Integer deviceId,
                                 @RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {

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
    public JsonData findByTime(@RequestParam(value = "start_time") String startTime,
                               @RequestParam(value = "end_time") String endTime,
                               @RequestParam(value = "device_id", required = false) Integer deviceId,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<DeviceRecord> list;

        if (deviceId == null) {
            list = deviceRecordService.findAllByTime(Timestamp.valueOf(startTime), Timestamp.valueOf(endTime));
        } else {
            list = deviceRecordService.findDeviceRecordByTime(deviceId, Timestamp.valueOf(startTime), Timestamp.valueOf(endTime));
        }
        PageInfo<DeviceRecord> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete")
    public JsonData delete(@RequestParam(value = "id") Long id) {
        if (deviceRecordService.findById(id) == null) {
            return JsonData.buildError("记录不存在！", 601);
        }
        if (deviceRecordService.delete(id) == 1) {
            return JsonData.buildSuccess("删除成功！");
        }
        return JsonData.buildError("删除失败！");
    }

    /**
     * 添加记录
     *
     * @param deviceId
     * @param airTemp
     * @param airHumidity
     * @param soilMoisture
     * @param co2
     * @param nContent
     * @param pContent
     * @param kContent
     * @param soilFertility
     * @param ph
     * @param illumination
     * @param airQuality
     * @return
     */
    @PostMapping("add")
    public JsonData add(@RequestParam(value = "device_id") Integer deviceId,
                        @RequestParam(value = "air_temp") String airTemp,
                        @RequestParam(value = "air_humidity") String airHumidity,
                        @RequestParam(value = "soil_moisture") String soilMoisture,
                        @RequestParam(value = "co2") String co2,
                        @RequestParam(value = "n_content") String nContent,
                        @RequestParam(value = "p_content") String pContent,
                        @RequestParam(value = "k_content") String kContent,
                        @RequestParam(value = "soil_fertility") Integer soilFertility,
                        @RequestParam(value = "ph") String ph,
                        @RequestParam(value = "illumination") String illumination,
                        @RequestParam(value = "air_quality") String airQuality) {

        if (deviceService.findDeviceById(deviceId)==null){
            return JsonData.buildError("设备不存在！",601);
        }

        DeviceRecord deviceRecord = new DeviceRecord();
        deviceRecord.setDeviceId(deviceId);
        deviceRecord.setRecordTime(new Timestamp(new Date().getTime()));
        deviceRecord.setAirTemp(airTemp);
        deviceRecord.setAirHumidity(airHumidity);
        deviceRecord.setSoilMoisture(soilMoisture);
        deviceRecord.setCo2(co2);
        deviceRecord.setNContent(nContent);
        deviceRecord.setPContent(pContent);
        deviceRecord.setKContent(kContent);
        deviceRecord.setSoilFertility(soilFertility);
        deviceRecord.setPh(ph);
        deviceRecord.setIllumination(illumination);
        deviceRecord.setAirQuality(airQuality);

        if (deviceRecordService.add(deviceRecord) == 1) {
            return JsonData.buildSuccess(deviceRecord, "新增记录成功！");
        }
        return JsonData.buildError("新增记录失败！");
    }
}
