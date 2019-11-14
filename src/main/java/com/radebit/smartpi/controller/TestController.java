package com.radebit.smartpi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Rade
 * @Date 2019-09-08 10:55
 * 说明：测试接口
 */
@Api(value = "测试接口模块")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "Hello";
    }
}
