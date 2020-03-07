package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.Decision;
import com.radebit.smartpi.model.po.DecisionGroup;
import com.radebit.smartpi.model.po.DecisionInfo;
import com.radebit.smartpi.model.po.Device;
import com.radebit.smartpi.model.vo.DeviceVO;
import com.radebit.smartpi.service.DecisionGroupService;
import com.radebit.smartpi.service.DecisionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Rade
 * @date 2020/3/7 6:22 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@Api(value = "智慧决策分组模块")
@RestController
@RequestMapping("/api/v1/decision/group")
public class DecisionGroupController {
    @Autowired
    private DecisionGroupService decisionGroupService;

    @Autowired
    private DecisionService decisionService;

    @GetMapping(value = "/list")
    public JsonData list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                         @RequestBody DecisionGroup decisionGroup){
        PageHelper.startPage(page, size);
        List<DecisionGroup> list = decisionGroupService.selectByAll(decisionGroup);
        PageInfo<DecisionGroup> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    @PostMapping()
    public JsonData add(@RequestBody DecisionGroup decisionGroup){
        if (decisionGroupService.insert(decisionGroup)==1)
            return JsonData.buildSuccess(decisionGroup,"新建成功！");
        return JsonData.buildError("新建失败！");
    }

    @PutMapping()
    public JsonData update(@RequestBody DecisionGroup decisionGroup){
        if (decisionGroupService.updateByPrimaryKey(decisionGroup)==1)
            return JsonData.buildSuccess(decisionGroup,"编辑成功！");
        return JsonData.buildError("编辑失败！");
    }

    @DeleteMapping()
    public JsonData delete(String groupId){
        //查询该分组下是否还存在决策内容
        if (decisionService.countByDecisionGroup(groupId)!=0){
            return JsonData.buildError("该分组下还存在决策内容！请勿删除！");
        }
        if (decisionGroupService.deleteByPrimaryKey(Long.valueOf(groupId))==1){
            return JsonData.buildSuccess("删除成功！");
        }
        return JsonData.buildError("删除失败！");
    }
}
