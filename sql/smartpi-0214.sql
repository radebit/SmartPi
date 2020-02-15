/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL5.7
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : smartpi

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 14/02/2020 20:13:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dev_group
-- ----------------------------
DROP TABLE IF EXISTS `dev_group`;
CREATE TABLE `dev_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of dev_group
-- ----------------------------
BEGIN;
INSERT INTO `dev_group` VALUES (1, '其他');
INSERT INTO `dev_group` VALUES (2, '测试');
INSERT INTO `dev_group` VALUES (3, '测试分类1');
INSERT INTO `dev_group` VALUES (4, '分组3');
COMMIT;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `name` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备名称',
  `group_id` int(11) DEFAULT '0' COMMENT '设备分组',
  `ascription` int(11) DEFAULT '0' COMMENT '设备归属用户',
  `star` int(11) DEFAULT '0' COMMENT '是否收藏',
  `ip` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备IP',
  `auto_control` int(11) DEFAULT '0' COMMENT '是否自动控制',
  `create_time` datetime DEFAULT NULL COMMENT '设备创建时间',
  `last_online_time` datetime DEFAULT NULL COMMENT '上次在线时间',
  `remark` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `cover_img` varchar(5000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '封面图',
  `is_online` int(11) NOT NULL DEFAULT '0' COMMENT '是否在线',
  `ac_id` int(11) DEFAULT NULL COMMENT '自动控制策略ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of device
-- ----------------------------
BEGIN;
INSERT INTO `device` VALUES (1, '测试设备dde', 4, 1, 1, '12121', 1, '2019-11-18 12:02:01', '2019-10-19 10:24:40', '', '', 0, 1);
INSERT INTO `device` VALUES (2, '测试设备wdx', 4, 1, 0, '10.9.9.0', 1, '2019-11-18 12:03:03', '2019-12-08 11:52:24', NULL, NULL, 1, 2);
INSERT INTO `device` VALUES (4, '测试新增设备', 2, 1, 0, '192.168.2.3', 0, '2019-11-21 15:56:03', NULL, '123123', NULL, 0, 1);
INSERT INTO `device` VALUES (5, '测试新增设备', 2, 1, 0, NULL, 0, '2019-11-21 15:56:37', NULL, '123123', NULL, 0, 1);
INSERT INTO `device` VALUES (6, '测试新增设备', 2, 1, 0, '192.168.2.3', 0, '2019-11-21 15:59:25', NULL, '123123', NULL, 0, 2);
INSERT INTO `device` VALUES (7, '测试新增设备121', 1, 1, 0, '192.168.2.3', 0, '2019-11-21 16:00:26', NULL, '123123', NULL, 0, 2);
INSERT INTO `device` VALUES (8, '联动测试', 1, 1, 0, '192.168.2.3', 0, '2020-02-01 05:25:26', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (9, '测试设备001', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:16:43', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (10, '测试设备002', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:16:47', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (11, '测试设备003', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:16:49', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (12, '测试设备004', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:16:51', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (13, '测试设备005', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:04', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (14, '测试设备006', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:06', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (15, '测试设备007', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:08', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (16, '测试设备008', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:11', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (17, '测试设备009', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:13', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (18, '测试设备010', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:15', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (19, '测试设备011', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:18', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (20, '测试设备012', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:24', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (21, '测试设备013', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:26', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (22, '测试设备014', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:28', NULL, '123123', NULL, 0, NULL);
INSERT INTO `device` VALUES (23, '测试设备015', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 09:17:30', NULL, '123123', NULL, 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for device_record
-- ----------------------------
DROP TABLE IF EXISTS `device_record`;
CREATE TABLE `device_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `device_id` int(11) NOT NULL COMMENT '设备id',
  `record_time` datetime NOT NULL COMMENT '记录时间',
  `air_temp` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '空气温度',
  `air_humidity` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '空气湿度',
  `soil_moisture` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '土壤湿度',
  `co2` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二氧化碳浓度',
  `n_content` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '含氮量',
  `p_content` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '含磷量',
  `k_content` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '含钾量',
  `soil_fertility` int(11) DEFAULT NULL COMMENT '土壤肥力',
  `ph` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '土壤PH值',
  `illumination` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '光照强度',
  `air_quality` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '空气质量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of device_record
-- ----------------------------
BEGIN;
INSERT INTO `device_record` VALUES (1, 1, '2019-11-20 14:35:12', '13', '2', '3', '4', '5', '3', '2', 3, '4', '2', '3');
INSERT INTO `device_record` VALUES (2, 2, '2019-11-21 14:37:39', '22', '2', '3', '2', '5', '1234', '435', 234, '23', '324', '32');
INSERT INTO `device_record` VALUES (3, 2, '2019-11-21 14:38:01', '3234', '23', '1235', '13254', '3124', '234', '234', 534, '234', '234', '23');
INSERT INTO `device_record` VALUES (4, 1, '2019-11-22 14:38:17', '342', '234', '56', '23', '4', '234', '234', 324, '234', '234', '234');
INSERT INTO `device_record` VALUES (6, 2, '2019-11-23 03:11:23', '12', '32', '3', '2', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (7, 2, '2019-11-23 03:11:28', '12', '32', '3', '2', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (8, 2, '2019-11-23 03:11:29', '12', '32', '3', '2', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (9, 1, '2019-11-23 03:11:49', '12', '32', '3', '2', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (10, 4, '2019-11-23 03:11:52', '12', '32', '3', '2', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (11, 4, '2019-11-23 03:13:45', '12', '32', '3', '2', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (12, 2, '2019-11-23 03:14:03', '12', '32', '3', '2', '4', '32', '21', 32, '4', '32', '23');
COMMIT;

-- ----------------------------
-- Table structure for device_switch
-- ----------------------------
DROP TABLE IF EXISTS `device_switch`;
CREATE TABLE `device_switch` (
  `device_id` int(11) NOT NULL COMMENT '设备id',
  `water1` int(11) DEFAULT NULL COMMENT '水泵1开关',
  `water2` int(11) DEFAULT NULL COMMENT '水泵2开关',
  `water3` int(11) DEFAULT NULL COMMENT '水泵3开关',
  `heat` int(11) DEFAULT NULL COMMENT '加热开关',
  `fan` int(11) DEFAULT NULL COMMENT '风扇开关',
  `humidifier` int(11) DEFAULT NULL COMMENT '加湿器开关',
  `red` int(200) DEFAULT NULL COMMENT '红光光照强度',
  `blue` int(200) DEFAULT NULL COMMENT '蓝光光照强度',
  `green` int(200) DEFAULT NULL COMMENT '绿光光照强度',
  `yellow` int(200) DEFAULT NULL COMMENT '黄光光照强度',
  `Illumination` int(200) DEFAULT NULL COMMENT '照明光照强度',
  `ultraviolet` int(200) DEFAULT NULL COMMENT '紫外线灯',
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of device_switch
-- ----------------------------
BEGIN;
INSERT INTO `device_switch` VALUES (1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for device_warn
-- ----------------------------
DROP TABLE IF EXISTS `device_warn`;
CREATE TABLE `device_warn` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预警id',
  `device_id` int(11) NOT NULL COMMENT '报警设备id',
  `warn_time` datetime DEFAULT NULL COMMENT '预警时间',
  `content` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报警信息内容',
  `solution` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '解决方案',
  `is_handle` int(11) NOT NULL DEFAULT '0' COMMENT '是否处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of device_warn
-- ----------------------------
BEGIN;
INSERT INTO `device_warn` VALUES (1, 1, '2019-12-06 14:49:56', '温度过高', '0', 1);
INSERT INTO `device_warn` VALUES (2, 1, '2019-12-06 15:31:17', '湿度太低', NULL, 0);
INSERT INTO `device_warn` VALUES (3, 1, '2019-12-06 15:31:19', '湿度太低', NULL, 1);
INSERT INTO `device_warn` VALUES (4, 1, '2019-12-06 15:31:24', '湿度太高', NULL, 0);
INSERT INTO `device_warn` VALUES (5, 2, '2019-12-06 15:31:27', '湿度太高', NULL, 0);
INSERT INTO `device_warn` VALUES (6, 2, '2019-12-06 15:31:30', '湿度太低', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `openid` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'rade', '202cb962ac59075b964b07152d234b70', '123456', '26564356@qq.com', '19858185300', 1);
INSERT INTO `user` VALUES (2, 'test', '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
