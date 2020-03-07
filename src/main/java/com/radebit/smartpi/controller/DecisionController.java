package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.Decision;
import com.radebit.smartpi.model.po.Device;
import com.radebit.smartpi.model.vo.DeviceVO;
import com.radebit.smartpi.service.DecisionGroupService;
import com.radebit.smartpi.service.DecisionInfoService;
import com.radebit.smartpi.service.DecisionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rade
 * @date 2020/3/7 3:10 下午
 * @url https://blog.radebit.com
 * 说明：智慧决策控制
 */
@Api(value = "设备信息模块")
@RestController
@RequestMapping("/api/v1/decision")
public class DecisionController {

    @Autowired
    private DecisionGroupService decisionGroupService;

    @Autowired
    private DecisionService decisionService;

    @Autowired
    private DecisionInfoService decisionInfoService;

    public JsonData findDecisionList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     @RequestBody Decision decision){
        PageHelper.startPage(page, size);
        List<Decision> list = decisionService.selectByAll(decision);
        for (Decision decisionTemp:list){

        }
        PageInfo<Decision> pageInfo = new PageInfo<>(list);

        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }
}
