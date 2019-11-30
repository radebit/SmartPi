package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.controller.annotation.AuthToken;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.DeviceSwitch;
import com.radebit.smartpi.service.DeviceService;
import com.radebit.smartpi.service.DeviceSwitchService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Rade
 * @Date 2019-11-30 21:02
 * 说明：
 */
@Api(value = "设备开关模块")
@RestController
@RequestMapping("/api/v1/deviceSwitch")
public class DeviceSwitchController {

    @Autowired
    private DeviceSwitchService deviceSwitchService;

    @Autowired
    private DeviceService deviceService;

    /**
     * 获取全部设备开关信息
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findAll")
    public JsonData findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<DeviceSwitch> list = deviceSwitchService.findAll();
        PageInfo<DeviceSwitch> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 获取设备开关信息
     *
     * @param deviceId
     * @return
     */
    @GetMapping("findSwitch")
    public JsonData findSwitchByDeviceId(@RequestParam(value = "device_id") Integer deviceId) {

        if (deviceService.findDeviceById(deviceId) == null) {
            return JsonData.buildError("设备不存在！", 601);
        }
        return JsonData.buildSuccess(deviceSwitchService.findDeviceSwitchByDeviceId(deviceId));

    }

    /**
     * 更新设备开关信息
     *
     * @param deviceId
     * @param water1
     * @param water2
     * @param water3
     * @param heat
     * @param fan
     * @param humidifier
     * @param red
     * @param blue
     * @param green
     * @param yellow
     * @param illumination
     * @param ultraviolet
     * @return
     */
    @AuthToken
    @PutMapping("update")
    public JsonData update(@RequestParam(value = "device_id") Integer deviceId,
                           @RequestParam(value = "water1", required = false) Integer water1,
                           @RequestParam(value = "water2", required = false) Integer water2,
                           @RequestParam(value = "water3", required = false) Integer water3,
                           @RequestParam(value = "heat", required = false) Integer heat,
                           @RequestParam(value = "fan", required = false) Integer fan,
                           @RequestParam(value = "humidifier", required = false) Integer humidifier,
                           @RequestParam(value = "red", required = false) Integer red,
                           @RequestParam(value = "blue", required = false) Integer blue,
                           @RequestParam(value = "green", required = false) Integer green,
                           @RequestParam(value = "yellow", required = false) Integer yellow,
                           @RequestParam(value = "illumination", required = false) Integer illumination,
                           @RequestParam(value = "ultraviolet", required = false) Integer ultraviolet) {

        if (deviceSwitchService.findDeviceSwitchByDeviceId(deviceId) == null) {
            return JsonData.buildError("设备不存在！", 601);
        }

        DeviceSwitch deviceSwitch = new DeviceSwitch();
        deviceSwitch.setDeviceId(deviceId);
        deviceSwitch.setWater1(water1);
        deviceSwitch.setWater2(water2);
        deviceSwitch.setWater3(water3);
        deviceSwitch.setHeat(heat);
        deviceSwitch.setFan(fan);
        deviceSwitch.setHumidifier(humidifier);
        deviceSwitch.setRed(red);
        deviceSwitch.setBlue(blue);
        deviceSwitch.setGreen(green);
        deviceSwitch.setYellow(yellow);
        deviceSwitch.setIllumination(illumination);
        deviceSwitch.setUltraviolet(ultraviolet);

        if (deviceSwitchService.update(deviceSwitch) == 1) {
            return JsonData.buildSuccess(deviceSwitchService.findDeviceSwitchByDeviceId(deviceId), "编辑成功！");
        }
        return JsonData.buildError("编辑失败！");

    }

//    /**
//     * 删除设备开关记录
//     *
//     * @param deviceId
//     * @return
//     */
//    @DeleteMapping("delete")
//    public JsonData delete(@RequestParam(value = "device_id") Integer deviceId) {
//        if (deviceSwitchService.findDeviceSwitchByDeviceId(deviceId) == null) {
//            return JsonData.buildError("设备不存在！", 601);
//        }
//
//        if (deviceSwitchService.delete(deviceId) == 1) {
//            return JsonData.buildSuccess("删除成功！");
//        }
//        return JsonData.buildError("删除失败！");
//
//    }
//
//    /**
//     * 增加设备开关记录
//     *
//     * @param deviceId
//     * @return
//     */
//    @PostMapping("add")
//    public JsonData add(@RequestParam(value = "device_id") Integer deviceId) {
//        if (deviceService.findDeviceById(deviceId) != null) {
//            return JsonData.buildError("设备ID重复！");
//        }
//        DeviceSwitch deviceSwitch = new DeviceSwitch();
//        deviceSwitch.setDeviceId(deviceId);
//        deviceSwitch.setWater1(0);
//        deviceSwitch.setWater2(0);
//        deviceSwitch.setWater3(0);
//        deviceSwitch.setHeat(0);
//        deviceSwitch.setFan(0);
//        deviceSwitch.setHumidifier(0);
//        deviceSwitch.setRed(0);
//        deviceSwitch.setBlue(0);
//        deviceSwitch.setGreen(0);
//        deviceSwitch.setYellow(0);
//        deviceSwitch.setIllumination(0);
//        deviceSwitch.setUltraviolet(0);
//
//        if (deviceSwitchService.add(deviceSwitch) == 1) {
//            return JsonData.buildSuccess(deviceSwitchService.findDeviceSwitchByDeviceId(deviceId), "新建成功！");
//        }
//
//        return JsonData.buildError("新增失败！");
//    }
}
