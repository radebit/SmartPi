package com.radebit.smartpi.provider;


import com.radebit.smartpi.model.po.Device;
import com.radebit.smartpi.model.po.Group;
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
     *
     * @param user
     * @return
     */
    public String updateUser(final User user) {
        return new SQL() {{

            UPDATE("user");

            if (user.getPassword() != null) {
                SET("password = #{password}");
            }
            if (user.getEmail() != null) {
                SET("email = #{email}");
            }
            if (user.getPhone() != null) {
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

    /**
     * 分组信息条件更新
     *
     * @param group
     * @return
     */
    public String updateGroup(final Group group) {
        return new SQL() {{

            UPDATE("dev_group");

            if (group.getGroupName() != null) {
                SET("group_name = #{groupName}");
            }

            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * 设备信息条件更新
     *
     * @param device
     * @return
     */
    public String updateDevice(final Device device) {
        return new SQL() {{

            UPDATE("device");

            if (device.getName() != null) {
                SET("name = #{name}");
            }
            if (device.getGroupId() != null) {
                SET("group_id = #{groupId}");
            }
            if (device.getAscription() != null) {
                SET("ascription = #{ascription}");
            }
            if (device.getStar() != null) {
                SET("star = #{star}");
            }
            if (device.getIp() != null) {
                SET("ip = #{ip}");
            }
            if (device.getAutoControl() != null) {
                SET("auto_control = #{autoControl}");
            }
            if (device.getLastOnlineTime() != null) {
                SET("last_online_time = #{lastOnlineTime}");
            }
            if (device.getRemark() != null) {
                SET("remark = #{remark}");
            }
            if (device.getCoverImg() != null) {
                SET("cover_img = #{coverImg}");
            }
            if (device.getIsOnline() != null) {
                SET("is_online = #{isOnline}");
            }

            WHERE("id = #{id}");
        }}.toString();
    }
}
