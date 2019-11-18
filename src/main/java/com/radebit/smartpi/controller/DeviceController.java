package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.Device;
import com.radebit.smartpi.model.vo.DeviceVO;
import com.radebit.smartpi.service.DeviceService;
import com.radebit.smartpi.service.GroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Rade
 * @Date 2019-11-18 21:02
 * 说明：设备信息模块
 */
@Api(value = "设备信息模块")
@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private GroupService groupService;

    @GetMapping("findAll")
    public JsonData findAll(@RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Device> list = deviceService.findAll();
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    @GetMapping("findById")
    public JsonData findById(@RequestParam(value = "id") int id) {
        return JsonData.buildSuccess(deviceService.findDeviceById(id));
    }

    @GetMapping("findByName")
    public JsonData findByName(@RequestParam(value = "name") String name,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Device> list = deviceService.findDeviceByName(name);
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    @GetMapping("findByGroupId")
    public JsonData findByGroup(@RequestParam(value = "group_id") int groupId,
                                @RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "size", defaultValue = "10") int size) {
        if (groupService.findGroupById(groupId) == null) {
            return JsonData.buildError("没有相关分组！", 601);
        }
        PageHelper.startPage(page, size);
        List<Device> list = deviceService.findDeviceByGroup(groupId);
        PageInfo<Device> pageInfo = new PageInfo<>(list);
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
     * @param device
     * @return
     */
    public DeviceVO PoToVo(Device device) {
        DeviceVO deviceVO = new DeviceVO();
        deviceVO.setId(device.getId());
        deviceVO.setName(device.getName());
        deviceVO.setGroup(String.valueOf(device.getGroupId()));
        deviceVO.setAscription(device.getAscription());
        deviceVO.setStar(device.getStar());
        deviceVO.setIp(device.getIp());
        deviceVO.setAutoControl(device.getAutoControl());
        deviceVO.setCreateTime(device.getCreateTime());
        deviceVO.setLastOnlineTime(device.getLastOnlineTime());
        deviceVO.setRemark(device.getRemark());
        deviceVO.setCoverImg(device.getCoverImg());
        return deviceVO;
    }
}
