package com.radebit.smartpi.model.vo;

import java.io.Serializable;

/**
 * @Author Rade
 * @Date 2019-11-15 19:48
 * 说明：用户视图层对象
 */
public class UserVO implements Serializable {

    private Integer id;
    private String username;
    private String token;
    private String email;
    private String phone;
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
