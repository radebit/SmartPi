package com.radebit.smartpi.provider;


import com.radebit.smartpi.model.po.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author Rade
 * @Date 2019-09-08 13:39
 * 说明：更新数据动态更新
 */
public class UpdateProvider {

    /**
     * 用户基本数据条件更新
     * @param user
     * @return
     */
    public String updateUser(final User user) {
        return new SQL() {{

            UPDATE("user");

            if (user.getPassword() != null){
                SET("password = #{password}");
            }
            if (user.getEmail() != null){
                SET("email = #{email}");
            }
            if (user.getPhone() != null){
                SET("phone = #{phone}");
            }
            if (user.getGender() != null) {
                SET("gender = #{gender}");
            }
            if (user.getOpenid() != null) {
                SET("openid = #{openid}");
            }

            WHERE("id = #{id}");
        }}.toString();
    }
}
