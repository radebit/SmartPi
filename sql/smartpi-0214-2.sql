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

 Date: 14/02/2020 23:16:21
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of dev_group
-- ----------------------------
BEGIN;
INSERT INTO `dev_group` VALUES (1, '默认分组');
INSERT INTO `dev_group` VALUES (2, '阳台');
INSERT INTO `dev_group` VALUES (3, '卧室');
INSERT INTO `dev_group` VALUES (4, '客厅');
INSERT INTO `dev_group` VALUES (5, '厨房');
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of device
-- ----------------------------
BEGIN;
INSERT INTO `device` VALUES (24, '默认测试设备', 1, 1, 0, '192.168.2.3', 0, '2020-02-14 13:44:29', '2020-02-14 23:14:56', '', NULL, 0, NULL);
INSERT INTO `device` VALUES (25, '阳台测试机器', 2, 1, 0, '192.168.2.1', 0, '2020-02-14 13:44:53', '2020-02-14 23:14:59', '', NULL, 0, NULL);
INSERT INTO `device` VALUES (26, '卧室测试机器', 3, 1, 0, '192.168.2.1', 0, '2020-02-14 13:45:07', '2020-02-14 23:15:04', '', NULL, 0, NULL);
INSERT INTO `device` VALUES (27, '客厅测试机器1', 4, 1, 0, '192.168.2.1', 0, '2020-02-14 13:45:17', '2020-02-14 23:15:07', '', NULL, 0, NULL);
INSERT INTO `device` VALUES (28, '客厅测试机器2', 4, 1, 0, '192.168.2.1', 0, '2020-02-14 13:45:19', '2020-02-14 23:15:09', '', NULL, 0, NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of device_record
-- ----------------------------
BEGIN;
INSERT INTO `device_record` VALUES (13, 24, '2020-02-14 13:47:20', '12', '32', '3', '2', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (14, 24, '2020-02-14 13:47:33', '13', '32', '3', '23', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (15, 24, '2020-02-14 13:47:35', '13', '32', '2', '23', '4', '32', '21', 32, '4', '32', '23');
INSERT INTO `device_record` VALUES (16, 24, '2020-02-14 13:47:38', '13', '32', '2', '23', '4', '32', '21', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (17, 25, '2020-02-14 13:47:44', '13', '32', '2', '23', '4', '32', '21', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (18, 25, '2020-02-14 13:47:48', '13', '31', '2', '23', '4', '32', '21', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (19, 25, '2020-02-14 13:47:51', '13', '31', '2', '23', '5', '32', '21', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (20, 25, '2020-02-14 13:47:54', '10', '31', '2', '23', '5', '32', '21', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (21, 26, '2020-02-14 13:47:56', '10', '31', '2', '23', '5', '32', '21', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (22, 26, '2020-02-14 13:47:59', '10', '31', '2', '23', '5', '32', '20', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (23, 26, '2020-02-14 13:48:03', '10', '31', '2', '23', '20', '32', '20', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (24, 27, '2020-02-14 13:48:07', '10', '31', '2', '23', '20', '32', '20', 32, '5', '32', '23');
INSERT INTO `device_record` VALUES (25, 27, '2020-02-14 13:48:16', '10', '31', '2', '23', '20', '32', '10', 32, '5', '32', '23');
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
INSERT INTO `device_switch` VALUES (24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `device_switch` VALUES (28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of device_warn
-- ----------------------------
BEGIN;
INSERT INTO `device_warn` VALUES (7, 24, '2020-02-14 13:49:52', '湿度太低', NULL, 0);
INSERT INTO `device_warn` VALUES (8, 25, '2020-02-14 13:50:03', '湿度过高', NULL, 0);
INSERT INTO `device_warn` VALUES (9, 27, '2020-02-14 13:50:12', '湿度过低', NULL, 0);
INSERT INTO `device_warn` VALUES (10, 28, '2020-02-14 13:50:24', '温度过高', NULL, 0);
INSERT INTO `device_warn` VALUES (11, 25, '2020-02-14 13:50:32', '养料不足', NULL, 0);
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
