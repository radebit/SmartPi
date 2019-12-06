package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.DeviceWarn;
import com.radebit.smartpi.model.vo.DeviceWarnVO;
import com.radebit.smartpi.service.DeviceService;
import com.radebit.smartpi.service.DeviceWarnService;
import com.radebit.smartpi.service.GroupService;
import com.radebit.smartpi.utils.DateTimeUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Rade
 * @Date 2019-12-06 15:26
 * 说明：设备预警模块
 */
@Api(value = "预警模块")
@RestController
@RequestMapping("/api/v1/warn")
public class DeviceWarnController {

    @Autowired
    private DeviceWarnService deviceWarnService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private DeviceService deviceService;

    /**
     * 获取全部预警信息
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findAll")
    public JsonData findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<DeviceWarn> list = deviceWarnService.findAll();
        List<DeviceWarnVO> listVO = new ArrayList<>();
        for (DeviceWarn deviceWarn : list) {
            listVO.add(PoToVo(deviceWarn));
        }
        PageInfo<DeviceWarnVO> pageInfo = new PageInfo<>(listVO);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 获取对应设备id的全部预警信息
     *
     * @param deviceId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findByDeviceId")
    public JsonData findByDeviceId(@RequestParam(value = "device_id") Integer deviceId,
                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (deviceService.findDeviceById(deviceId)==null){
            return JsonData.buildError("设备不存在！",601);
        }
        PageHelper.startPage(page, size);
        List<DeviceWarn> list = deviceWarnService.findByDeviceId(deviceId);
        List<DeviceWarnVO> listVO = new ArrayList<>();
        for (DeviceWarn deviceWarn : list) {
            listVO.add(PoToVo(deviceWarn));
        }
        PageInfo<DeviceWarnVO> pageInfo = new PageInfo<>(listVO);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 查找未读预警
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findNotHandle")
    public JsonData findNotHandle(@RequestParam(value = "device_id") Integer deviceId,
                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size){
        if (deviceService.findDeviceById(deviceId)==null){
            return JsonData.buildError("设备不存在！",601);
        }
        PageHelper.startPage(page, size);
        List<DeviceWarn> list = deviceWarnService.findNotHandle(deviceId);
        List<DeviceWarnVO> listVO = new ArrayList<>();
        for (DeviceWarn deviceWarn : list) {
            listVO.add(PoToVo(deviceWarn));
        }
        PageInfo<DeviceWarnVO> pageInfo = new PageInfo<>(listVO);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 查找已读预警
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findHandle")
    public JsonData findHandle(@RequestParam(value = "device_id") Integer deviceId,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size){
        if (deviceService.findDeviceById(deviceId)==null){
            return JsonData.buildError("设备不存在！",601);
        }
        PageHelper.startPage(page, size);
        List<DeviceWarn> list = deviceWarnService.findHandle(deviceId);
        List<DeviceWarnVO> listVO = new ArrayList<>();
        for (DeviceWarn deviceWarn : list) {
            listVO.add(PoToVo(deviceWarn));
        }
        PageInfo<DeviceWarnVO> pageInfo = new PageInfo<>(listVO);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }


    /**
     * PoToVo
     *
     * @param deviceWarn
     * @return
     */
    public DeviceWarnVO PoToVo(DeviceWarn deviceWarn) {

        DeviceWarnVO deviceWarnVO = new DeviceWarnVO();
        deviceWarnVO.setId(deviceWarn.getId());
        deviceWarnVO.setWarnTime(DateTimeUtils.timestampToString(deviceWarn.getWarnTime(), "yyyy-MM-dd HH:mm:ss"));
        deviceWarnVO.setDeviceId(deviceWarn.getDeviceId());
        deviceWarnVO.setDeviceName(deviceService.findDeviceById(deviceWarn.getDeviceId()).getName());
        deviceWarnVO.setDeviceGroupId(deviceService.findDeviceById(deviceWarn.getDeviceId()).getGroupId());
        deviceWarnVO.setDeviceGroupName(groupService.findGroupById(deviceService.findDeviceById(deviceWarn.getDeviceId()).getGroupId()).getGroupName());
        deviceWarnVO.setContent(deviceWarn.getContent());
        deviceWarnVO.setSolution(deviceWarn.getSolution());
        deviceWarnVO.setIsHandle(deviceWarn.getIsHandle());
        return deviceWarnVO;

    }
}
