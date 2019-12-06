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
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

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

        if (deviceService.findDeviceById(deviceId) == null) {
            return JsonData.buildError("设备不存在！", 601);
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
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findNotHandle")
    public JsonData findNotHandle(@RequestParam(value = "device_id") Integer deviceId,
                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (deviceService.findDeviceById(deviceId) == null) {
            return JsonData.buildError("设备不存在！", 601);
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
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("findHandle")
    public JsonData findHandle(@RequestParam(value = "device_id") Integer deviceId,
                               @RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (deviceService.findDeviceById(deviceId) == null) {
            return JsonData.buildError("设备不存在！", 601);
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
     * 通过ID查找预警信息
     *
     * @param id
     * @return
     */
    @GetMapping("findById")
    public JsonData findById(@RequestParam(value = "id") Integer id) {
        DeviceWarn deviceWarn = deviceWarnService.findById(id);
        if (deviceWarn == null) {
            return JsonData.buildError("预警信息不存在！", 601);
        }
        return JsonData.buildSuccess(deviceWarn);
    }

    /**
     * 删除预警信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete")
    public JsonData delete(@RequestParam(value = "id") Integer id) {
        if (deviceWarnService.delete(id) == 1) {
            return JsonData.buildSuccess("删除成功！");
        }
        return JsonData.buildError("删除失败！");
    }

    /**
     * 新增预警信息
     *
     * @param deviceId
     * @param content
     * @return
     */
    @PostMapping("add")
    public JsonData add(@RequestParam(value = "device_id") Integer deviceId,
                        @RequestParam(value = "content") String content) {

        DeviceWarn deviceWarn = new DeviceWarn();
        deviceWarn.setDeviceId(deviceId);
        deviceWarn.setWarnTime(new Timestamp(new Date().getTime()));
        deviceWarn.setContent(content);
        deviceWarn.setIsHandle(0);

        if (deviceWarnService.add(deviceWarn) == 1) {
            return JsonData.buildSuccess("新增成功！");
        }

        return JsonData.buildError("新增失败！");
    }

    /**
     * 修改是否已读
     *
     * @param isHandle
     * @param id
     * @return
     */
    @PutMapping("changeIsHandle")
    public JsonData changeIsHandle(@RequestParam(value = "is_handle") Integer isHandle,
                                   @RequestParam(value = "id") Integer id) {
        if (deviceWarnService.setWarnIsHandle(isHandle, id) == 1) {
            return JsonData.buildSuccess("修改成功！");
        }
        return JsonData.buildError("修改失败！");
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
