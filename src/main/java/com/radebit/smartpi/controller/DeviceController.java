package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.controller.annotation.AuthToken;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.Device;
import com.radebit.smartpi.model.po.DeviceRecord;
import com.radebit.smartpi.model.po.DeviceSwitch;
import com.radebit.smartpi.model.po.DeviceWarn;
import com.radebit.smartpi.model.vo.DeviceVO;
import com.radebit.smartpi.service.*;
import com.radebit.smartpi.utils.DateTimeUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

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

    @Autowired
    private UserService userService;

    /**
     * 查询所有设备
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findAll")
    public JsonData findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);

        List<Device> list = deviceService.findAll();
        PageInfo<Device> pageInfoTemp = new PageInfo<>(list);

        List<DeviceVO> listVO = new ArrayList<>();
        for (Device device : list) {
            listVO.add(PoToVo(device));
        }
        PageInfo<DeviceVO> pageInfo = new PageInfo<>(listVO);

        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfoTemp.getTotal());//总条数
        data.put("total_page", pageInfoTemp.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 根据ID查询设备
     *
     * @param id
     * @return
     */
    @GetMapping("findById")
    public JsonData findById(@RequestParam(value = "id") Integer id) {
        if (deviceService.findDeviceById(id)==null){
            return JsonData.buildError("设备不存在！",601);
        }
        return JsonData.buildSuccess(PoToVo(deviceService.findDeviceById(id)));
    }

    /**
     * 根据设备名称模糊查询
     *
     * @param name
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findByName")
    public JsonData findByName(@RequestParam(value = "name") String name,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<Device> list = deviceService.findDeviceByName(name);
        List<DeviceVO> listVO = new ArrayList<>();
        for (Device device : list) {
            listVO.add(PoToVo(device));
        }
        PageInfo<DeviceVO> pageInfo = new PageInfo<>(listVO);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 根据分组查询设备
     *
     * @param groupId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findByGroupId")
    public JsonData findByGroup(@RequestParam(value = "group_id") Integer groupId,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (groupService.findGroupById(groupId) == null) {
            return JsonData.buildError("没有相关分组！", 601);
        }
        PageHelper.startPage(page, size);
        List<Device> list = deviceService.findDeviceByGroup(groupId);
        List<DeviceVO> listVO = new ArrayList<>();
        for (Device device : list) {
            listVO.add(PoToVo(device));
        }
        PageInfo<DeviceVO> pageInfo = new PageInfo<>(listVO);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);

    }

    /**
     * 查找是否在线设备
     *
     * @param isOnline
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findIsOnline")
    public JsonData findIsOnline(@RequestParam(value = "is_online") Integer isOnline,
                                 @RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<Device> list = deviceService.findDeviceIsOnline(isOnline);
        List<DeviceVO> listVO = new ArrayList<>();
        for (Device device : list) {
            listVO.add(PoToVo(device));
        }
        PageInfo<DeviceVO> pageInfo = new PageInfo<>(listVO);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    /**
     * 更新设备信息
     *
     * @param name
     * @param groupId
     * @param ascription
     * @param star
     * @param ip
     * @param autoControl
     * @param remark
     * @param coverImg
     * @param isOnline
     * @return
     */
    @AuthToken
    @PutMapping("update")
    public JsonData update(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "group_id", required = false) Integer groupId,
                           @RequestParam(value = "ascription", required = false) Integer ascription,
                           @RequestParam(value = "star", required = false) Integer star,
                           @RequestParam(value = "ip", required = false) String ip,
                           @RequestParam(value = "auto_control", required = false) Integer autoControl,
                           @RequestParam(value = "remark", required = false) String remark,
                           @RequestParam(value = "cover_img", required = false) String coverImg,
                           @RequestParam(value = "is_online", required = false) Integer isOnline,
                           @RequestParam(value = "ac_id", required = false) Integer acId) {

        if (groupService.findGroupById(groupId) == null) {
            return JsonData.buildError("分组不存在！", 6001);
        }
        Device device = new Device();
        device.setId(id);
        device.setName(name);
        device.setAscription(ascription);
        device.setGroupId(groupId);
        device.setStar(star);
        device.setIp(ip);
        device.setAutoControl(autoControl);
        device.setAcId(acId);
        if (isOnline==1){
            device.setLastOnlineTime(new Timestamp(new Date().getTime()));
        }
        device.setRemark(remark);
        device.setCoverImg(coverImg);
        device.setIsOnline(isOnline);

        if (deviceService.update(device) == 1) {
            return JsonData.buildSuccess(PoToVo(deviceService.findDeviceById(id)), "修改成功！");
        }
        return JsonData.buildError("修改失败！");

    }

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    @AuthToken
    @DeleteMapping("delete")
    public JsonData delete(@RequestParam(value = "id") Integer id) {
        if (deviceService.findDeviceById(id) == null) {
            return JsonData.buildError("设备不存在！", 601);
        }
        if (deviceService.delete(id) == 1) {
            return JsonData.buildSuccess("删除成功！");
        }
        return JsonData.buildError("删除失败！");
    }

    /**
     * 添加设备
     *
     * @param name
     * @param groupId
     * @param ascription
     * @param ip
     * @param remark
     * @return
     */
    @AuthToken
    @PostMapping("add")
    public JsonData add(@RequestParam(value = "name") String name,
                        @RequestParam(value = "group_id") Integer groupId,
                        @RequestParam(value = "ascription") String ascription,
                        @RequestParam(value = "ip", required = false) String ip,
                        @RequestParam(value = "remark", required = false) String remark) {

        if (userService.findUserByUsername(ascription) == null) {
            return JsonData.buildError("设备所属人有误！", 601);
        }
        Integer ascriptionId = userService.findUserByUsername(ascription).getId();
        Device device = new Device();
        device.setName(name);
        device.setGroupId(groupId);
        device.setAscription(ascriptionId);
        device.setIp(ip);
        device.setCreateTime(new Timestamp(new Date().getTime()));
        device.setLastOnlineTime(new Timestamp(new Date().getTime()));
        device.setRemark(remark);
        if (deviceService.add(device) == 1) {
            return JsonData.buildSuccess(device, "添加设备成功！");
        }
        return JsonData.buildError("添加失败！");
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
        deviceVO.setGroupId(device.getGroupId());
        deviceVO.setGroupName(groupService.findGroupById(device.getGroupId()).getGroupName());
        deviceVO.setAscriptionId(device.getAscription());
        deviceVO.setAscriptionName(userService.findUserById(device.getAscription()).getUsername());
        deviceVO.setStar(device.getStar());
        deviceVO.setIp(device.getIp());
        deviceVO.setAutoControl(device.getAutoControl());
        deviceVO.setCreateTime(DateTimeUtils.timestampToString(device.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        deviceVO.setLastOnlineTime(DateTimeUtils.timestampToString(device.getLastOnlineTime(), "yyyy-MM-dd HH:mm:ss"));
        deviceVO.setRemark(device.getRemark());
        deviceVO.setCoverImg(device.getCoverImg());
        deviceVO.setIsOnline(device.getIsOnline());
        deviceVO.setAcId(device.getAcId());
        return deviceVO;
    }

}
