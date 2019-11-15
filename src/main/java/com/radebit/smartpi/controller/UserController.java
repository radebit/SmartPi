package com.radebit.smartpi.controller;

import cn.hutool.core.lang.Assert;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.User;
import com.radebit.smartpi.model.vo.UserVO;
import com.radebit.smartpi.service.UserService;
import com.radebit.smartpi.utils.ConstantKit;
import com.radebit.smartpi.utils.Md5TokenGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Rade
 * @Date 2019-11-15 19:22
 * 说明：用户模块
 */
@Api(value = "用户模块")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Md5TokenGenerator tokenGenerator;

    @PostMapping("login")
    public JsonData userLogin(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password,
                              HttpServletRequest request) {
        Assert.notBlank(username);
        Assert.notBlank(password);
        if (userService.checkLogin(username, password)) {

            User user = userService.findUserByUsername(username);
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            String token = tokenGenerator.generate(username, password);
            jedis.set(username, password);
            jedis.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
            jedis.set(token, username);
            jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
            Long currentTime = System.currentTimeMillis();
            jedis.set(token + username, currentTime.toString());
            jedis.close();

            UserVO userVO = PoToVo(user, token);
            return JsonData.buildSuccess(userVO, "登录成功！");
        } else {
            return JsonData.buildError("账号或密码错误！");
        }

    }


    /**
     * PoToVo
     *
     * @param user
     * @param token
     * @return
     */
    public UserVO PoToVo(User user, String token) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUsername(user.getUsername());
        userVO.setToken(token);
        userVO.setEmail(user.getEmail());
        userVO.setPhone(user.getPhone());
        userVO.setGender(String.valueOf(user.getGender()));
        return userVO;
    }
}
