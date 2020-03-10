package com.radebit.smartpi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.smartpi.controller.annotation.AuthToken;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.Decision;
import com.radebit.smartpi.model.vo.DecisionVO;
import com.radebit.smartpi.service.DecisionGroupService;
import com.radebit.smartpi.service.DecisionInfoService;
import com.radebit.smartpi.service.DecisionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Rade
 * @date 2020/3/7 3:10 下午
 * @url https://blog.radebit.com
 * 说明：智慧决策控制
 */
@Api(value = "智慧决策模块")
@RestController
@RequestMapping("/api/v1/decision")
public class DecisionController {

    @Autowired
    private DecisionGroupService decisionGroupService;

    @Autowired
    private DecisionService decisionService;

    @Autowired
    private DecisionInfoService decisionInfoService;

    @GetMapping(value = "/list")
    public JsonData findDecisionList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     Decision decision) {
        PageHelper.startPage(page, size);

        List<Decision> list = decisionService.selectByAll(decision);
        PageInfo<Decision> pageInfoTemp = new PageInfo<>(list);

        List<DecisionVO> listVO = new ArrayList<>();
        for (Decision decisionTmp : list) {
            DecisionVO decisionVO = PoToVo(decisionTmp);
            decisionVO.setDecisionInfoList(decisionInfoService.selectByDecisionId(decisionVO.getDecisionId()));
            listVO.add(decisionVO);
        }
        PageInfo<DecisionVO> pageInfo = new PageInfo<>(listVO);

        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfoTemp.getTotal());//总条数
        data.put("total_page", pageInfoTemp.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    @AuthToken
    @PostMapping()
    public JsonData add(@RequestBody Decision decision){
        decision.setCreateTime(new Date());
        if (decisionService.insert(decision)==1)
            return JsonData.buildSuccess(decision,"新建成功！");
        return JsonData.buildError("新建失败！");
    }

    @AuthToken
    @PutMapping()
    public JsonData update(@RequestBody Decision decision){
        if (decisionService.updateByPrimaryKey(decision)==1)
            return JsonData.buildSuccess(decision,"编辑成功！");
        return JsonData.buildError("编辑失败！");
    }

    @AuthToken
    @DeleteMapping()
    public JsonData delete(String decisionId){
        if (decisionService.deleteByPrimaryKey(Long.valueOf(decisionId))==1){
            //联动info
            decisionInfoService.deleteByDecisionId(Long.valueOf(decisionId));
            return JsonData.buildSuccess("删除成功！");
        }
        return JsonData.buildError("删除失败！");
    }


    /**
     * PoToVo
     *
     * @param decision
     * @return
     */
    public DecisionVO PoToVo(Decision decision) {
        DecisionVO decisionVO = new DecisionVO();
        decisionVO.setDecisionId(decision.getDecisionId());
        decisionVO.setDecisionName(decision.getDecisionName());
        decisionVO.setDecisionGroupId(decision.getDecisionGroup());
        decisionVO.setDecisionGroupName(decisionGroupService.selectByPrimaryKey(Long.valueOf(decision.getDecisionGroup())).getGroupName());
        decisionVO.setState(decision.getState());
        decisionVO.setFounder(String.valueOf(decision.getFounder()));
        decisionVO.setRemarks(decision.getRemarks());
        decisionVO.setCreateTime(decision.getCreateTime());
        return decisionVO;

    }
}
