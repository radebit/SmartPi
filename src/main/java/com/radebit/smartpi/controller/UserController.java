package com.radebit.smartpi.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.SecureUtil;
import com.radebit.smartpi.controller.annotation.AuthToken;
import com.radebit.smartpi.domain.JsonData;
import com.radebit.smartpi.model.po.User;
import com.radebit.smartpi.model.vo.UserVO;
import com.radebit.smartpi.service.UserService;
import com.radebit.smartpi.utils.ConstantKit;
import com.radebit.smartpi.utils.Md5TokenGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

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

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public JsonData userLogin(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password) {
        Assert.notBlank(username);
        Assert.notBlank(password);
        if (userService.checkLogin(username, password)) {

            User user = userService.findUserByUsername(username);
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            jedis.auth("26564356");
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
     * 用户注册
     * @param username
     * @param password
     * @param email
     * @param phone
     * @return
     */
    @PostMapping("add")
    public JsonData addUser(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "email",required = false) String email,
                            @RequestParam(value = "phone",required = false) String phone){
        Assert.notBlank(username);
        Assert.notBlank(password);
        if (userService.findUserByUsername(username)!=null){
            return JsonData.buildError("用户已存在！",601);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(SecureUtil.md5(password));
        user.setEmail(email);
        if (phone!=null)
            if (userService.findUserByPhone(phone)!=null)
                return JsonData.buildError("手机号已存在！");
            user.setPhone(phone);
        if (userService.add(user)==1){
            return JsonData.buildSuccess(user,"用户注册成功！");
        }
        return JsonData.buildError("用户注册失败！");
    }


    /**
     * 删除用户
     * @param id
     * @return
     */
    @AuthToken
    @DeleteMapping("delete")
    public JsonData delete(@RequestParam(value = "id") int id){
        Assert.notNull(id);
        if (id == 1){
            return JsonData.buildError("请勿删除默认用户！",601);
        }
        if (userService.delete(id)==1){
            return JsonData.buildSuccess("删除成功！");
        }
        return JsonData.buildError("删除失败！");
    }

    /**
     * 修改密码
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @AuthToken
    @PutMapping("changePass")
    public JsonData updateAdmin(@RequestParam(value = "username") String username,
                                @RequestParam(value = "oldPassword") String oldPassword,
                                @RequestParam(value = "newPassword") String newPassword){
        Assert.notBlank(username);
        Assert.notBlank(oldPassword);
        Assert.notBlank(newPassword);

        User user = userService.findUserByUsername(username);

        if (user==null){
            return JsonData.buildError("用户不存在！",601);
        }
        if (!SecureUtil.md5(oldPassword).equals(user.getPassword())){
            return JsonData.buildError("原始密码不匹配",602);
        }
        user.setPassword(SecureUtil.md5(newPassword));
        if (userService.update(user) == 1){
            return JsonData.buildSuccess(user,"重置密码成功！");
        }
        return JsonData.buildError("重置密码失败！");

    }

    /**
     * 用户注销登录
     *
     * @param username
     * @return
     */
    @AuthToken
    @PostMapping("logout")
    public JsonData logout(@RequestParam(value = "username")String username,
                           @RequestParam(value = "token")String token){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("26564356");
        jedis.del(username,token);
        jedis.close();
        return JsonData.buildSuccess("用户注销成功！");
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
