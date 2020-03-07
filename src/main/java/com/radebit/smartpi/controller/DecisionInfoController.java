package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.DecisionGroup;
import com.radebit.smartpi.model.po.DecisionInfo;
import com.radebit.smartpi.service.DecisionGroupService;
import com.radebit.smartpi.service.DecisionInfoService;
import com.radebit.smartpi.service.DecisionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rade
 * @date 2020/3/7 6:09 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@Api(value = "智慧决策详情模块")
@RestController
@RequestMapping("/api/v1/decision/info")
public class DecisionInfoController {
    @Autowired
    private DecisionInfoService decisionInfoService;

    @Autowired
    private DecisionService decisionService;

    @GetMapping(value = "/list")
    public JsonData list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                         @RequestBody DecisionInfo decisionInfo){
        PageHelper.startPage(page, size);
        List<DecisionInfo> list = decisionInfoService.selectByDecisionId(decisionInfo.getDecisionId());
        PageInfo<DecisionInfo> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    @PostMapping()
    public JsonData add(@RequestBody DecisionInfo decisionInfo){
        if (decisionService.selectByPrimaryKey(decisionInfo.getDecisionId())==null)
            return JsonData.buildError("新建失败，决策不存在！");
        if (decisionInfoService.insert(decisionInfo)==1)
            return JsonData.buildSuccess(decisionInfo,"新建成功！");
        return JsonData.buildError("新建失败！");
    }

    @PutMapping()
    public JsonData update(@RequestBody DecisionInfo decisionInfo){
        if (decisionInfoService.updateByPrimaryKey(decisionInfo)==1)
            return JsonData.buildSuccess(decisionInfo,"编辑成功！");
        return JsonData.buildError("编辑失败！");
    }

    @DeleteMapping()
    public JsonData delete(String decisionUuid){
        if (decisionInfoService.deleteByPrimaryKey(Long.valueOf(decisionUuid))==1){
            return JsonData.buildSuccess("删除成功！");
        }
        return JsonData.buildError("删除失败！");
    }
}
