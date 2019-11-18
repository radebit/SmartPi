package com.radebit.smartpi.controller;

import com.radebit.smartpi.controller.annotation.AuthToken;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.Group;
import com.radebit.smartpi.service.GroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-11-18 10:46
 * 说明：分组模块
 */

@Api(value = "分组模块")
@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("findAll")
    public JsonData findAll() {
        List<Group> groupList = groupService.findAll();
        return JsonData.buildSuccess(groupList);
    }

    @GetMapping("find")
    public JsonData find(int id) {
        return JsonData.buildSuccess(groupService.findGroupById(id));
    }

    @AuthToken
    @PutMapping("update")
    public JsonData update(@RequestParam(value = "id") int id,
                           @RequestParam(value = "group_name") String groupName) {
        Group group = groupService.findGroupById(id);
        if (group == null){
            return JsonData.buildError("分组不存在！",602);
        }
        group.setGroupName(groupName);
        if (groupService.update(group) == 1) {
            return JsonData.buildSuccess(group,"编辑成功！");
        }
        return JsonData.buildError("编辑失败！");
    }

    @AuthToken
    @DeleteMapping("delete")
    public JsonData delete(@RequestParam(value = "id") int id) {
        if (id == 0){
            return JsonData.buildError("请勿删除默认分组！",601);
        }
        if (groupService.delete(id) == 1){
            return JsonData.buildSuccess("删除成功！");
        }
        return JsonData.buildError("删除失败！");
    }

    @AuthToken
    @PostMapping("add")
    public JsonData add(@RequestParam(value = "group_name") String groupName){
        Group group = new Group();
        group.setGroupName(groupName);
        if (groupService.add(group)==1){
            return JsonData.buildSuccess("新建成功！");
        }
        return JsonData.buildError("新建失败！");
    }
}
