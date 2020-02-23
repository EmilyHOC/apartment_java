/*
Navicat MySQL Data Transfer

Source Server         : apartment
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : t_admin

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-02-23 21:58:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin_info
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_info`;
CREATE TABLE `t_admin_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_kind` varchar(45) DEFAULT NULL,
  `admin_realname` varchar(255) DEFAULT NULL,
  `admin_worktime` float(11,1) DEFAULT NULL,
  `admin_lastlogin` date DEFAULT NULL,
  `admin_remarks` varchar(255) DEFAULT NULL,
  `admin_score` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin_info
-- ----------------------------
INSERT INTO `t_admin_info` VALUES ('1', 'root', 'root', 'admin', '杨欣静', '5.0', '2020-02-14', null, '优秀老板');
INSERT INTO `t_admin_info` VALUES ('2', 'user1', 'user1', 'user', '张三', '2.0', '2020-02-14', '新员工', '连续5季度销售冠军');
INSERT INTO `t_admin_info` VALUES ('9', 'user2', 'user2', 'user', '王五', '2.0', '2020-02-14', null, '业主好评率第一');
INSERT INTO `t_admin_info` VALUES ('51', '小鑫鑫', '123456', 'user', '谭鑫', '2.0', '2020-02-14', null, '最诚信销售称号');
INSERT INTO `t_admin_info` VALUES ('52', 'chenyu', 'chenyu', 'user', '陈玉', '5.0', '2020-02-14', '985毕业', '双一流销售');

-- ----------------------------
-- Table structure for t_custom_info
-- ----------------------------
DROP TABLE IF EXISTS `t_custom_info`;
CREATE TABLE `t_custom_info` (
  `customId` int(255) NOT NULL AUTO_INCREMENT,
  `custom_name` varchar(255) DEFAULT NULL,
  `custom_sex` varchar(255) DEFAULT NULL,
  `custom_age` int(11) DEFAULT NULL,
  `custom_phone` varchar(255) DEFAULT NULL,
  `custom_occupation` varchar(255) DEFAULT NULL,
  `custom_rendInfo` varchar(255) DEFAULT NULL,
  `custom_rendNeed` varchar(255) DEFAULT NULL,
  `custom_introducer` varchar(255) DEFAULT NULL,
  `custom_sign` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_custom_info
-- ----------------------------
INSERT INTO `t_custom_info` VALUES ('1', '赵紫燕', '女', '25', '17786738633', 'UI设计师', null, '有厨房', '杨欣静', '1');
INSERT INTO `t_custom_info` VALUES ('3', '张新晴', '男', '31', '13923983389', '前端架构师', '主卧独卫', '主卧', '谭鑫', '1');

-- ----------------------------
-- Table structure for t_device_info
-- ----------------------------
DROP TABLE IF EXISTS `t_device_info`;
CREATE TABLE `t_device_info` (
  `device_Id` int(255) NOT NULL AUTO_INCREMENT,
  `device_address` varchar(255) DEFAULT NULL,
  `device_kind` varchar(255) DEFAULT NULL,
  `device_num` int(11) DEFAULT NULL,
  `device_rend` varchar(255) DEFAULT NULL,
  `device_start` date DEFAULT NULL,
  `device_returntime` datetime DEFAULT '0000-00-00 00:00:00',
  `device_pay` decimal(10,0) DEFAULT NULL,
  `device_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `device_return` varchar(255) DEFAULT NULL,
  `device_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`device_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2343554 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_device_info
-- ----------------------------
INSERT INTO `t_device_info` VALUES ('3432', '雨花台区恒大华府', '马桶抽', '2', 'true', '2020-01-13', null, null, '1', '0', '5.00');
INSERT INTO `t_device_info` VALUES ('23344', '雨花台区中南锦苑', '椅子', '1', 'false', '2020-02-18', '2020-02-22 00:00:00', '89', '0', '0', '89.00');
INSERT INTO `t_device_info` VALUES ('2343545', '雨花台区区时光澔韵', '路由器', '1', 'true', '2020-02-18', null, '144', '1', '0', '144.00');
INSERT INTO `t_device_info` VALUES ('2343546', '文华名苑', '抹布', '5', 'true', '2020-01-28', null, null, '1', '0', '2.00');
INSERT INTO `t_device_info` VALUES ('2343547', '翠屏国际', '台灯', '1', 'false', '2020-02-20', '2020-02-22 00:00:00', null, '0', '0', '44.00');
INSERT INTO `t_device_info` VALUES ('2343551', 'a', 'w', '33', '0', '2020-02-21', '2020-02-22 00:00:00', null, '0', '0', '2.00');
INSERT INTO `t_device_info` VALUES ('2343552', 'b', 'a', '3', '1', '2020-02-21', '2020-02-22 00:00:00', null, '1', '0', '2.00');
INSERT INTO `t_device_info` VALUES ('2343553', '翠屏山3幢', '马桶抽', '2', '1', '2020-02-22', '2020-02-23 00:00:00', null, '1', '0', '44.00');

-- ----------------------------
-- Table structure for t_financial_info
-- ----------------------------
DROP TABLE IF EXISTS `t_financial_info`;
CREATE TABLE `t_financial_info` (
  `financial_roomId` varchar(255) NOT NULL,
  `financial_address` varchar(255) DEFAULT NULL,
  `financial_rendtime` date DEFAULT NULL,
  `financial_price` varchar(10) DEFAULT NULL,
  `financial_premoney` varchar(255) DEFAULT NULL,
  `findancial_waterprice` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `findancial_watermeter` varchar(255) DEFAULT NULL,
  `findancial_powerprice` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `findancial_powermeter` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`financial_roomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_financial_info
-- ----------------------------
INSERT INTO `t_financial_info` VALUES ('2233232', '中南锦苑4幢2单元406', '2020-02-10', '1690', '1690', '1.2', '12300', '0.5', '120');

-- ----------------------------
-- Table structure for t_rend_info
-- ----------------------------
DROP TABLE IF EXISTS `t_rend_info`;
CREATE TABLE `t_rend_info` (
  `rend_Id` int(11) NOT NULL AUTO_INCREMENT,
  `rend_address` varchar(255) DEFAULT NULL,
  `rend_man` varchar(255) DEFAULT NULL,
  `rend_contract` varchar(255) DEFAULT NULL,
  `rend_start` date DEFAULT NULL,
  `rend_paymore` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `rend_end` date DEFAULT NULL,
  PRIMARY KEY (`rend_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2020110203 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_rend_info
-- ----------------------------
INSERT INTO `t_rend_info` VALUES ('202012345', '江苏省南京市雨花台区中南锦苑4幢2单元406', '杨欣静', '17798539223', '2020-02-18', '0', '2030-11-18');

-- ----------------------------
-- Table structure for t_room_info
-- ----------------------------
DROP TABLE IF EXISTS `t_room_info`;
CREATE TABLE `t_room_info` (
  `roomid` int(11) NOT NULL AUTO_INCREMENT,
  `room_address` varchar(255) DEFAULT NULL,
  `room_usage` varchar(255) DEFAULT NULL,
  `room_area` double(255,0) DEFAULT NULL,
  `room_rend` int(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roomid`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_room_info
-- ----------------------------
INSERT INTO `t_room_info` VALUES ('1', '江苏省南京市江宁区翠屏清华园55幢1104', '5', '55', '1', '2019-12-17 00:00:00', '看房要带鞋套');
INSERT INTO `t_room_info` VALUES ('2', '江苏省南京市江宁区中南景苑4幢2单元1108', '2', '22', '1', '2019-11-26 00:00:00', '无');
INSERT INTO `t_room_info` VALUES ('3', '江苏省南京市浦口区高新街道55号004', '4', '42', '1', '2020-02-25 17:42:52', '无');
INSERT INTO `t_room_info` VALUES ('38', '江苏省南京市长诸公寓44栋440', '4', '55', '0', '2019-12-16 11:41:26', '管家带看房要买瓶水');
INSERT INTO `t_room_info` VALUES ('39', '江苏省南京市江宁区翠屏国际城水杉苑701', '3', '44', '1', '2020-02-13 11:41:32', '管家进门先敲门');
INSERT INTO `t_room_info` VALUES ('40', '江苏省南京市江宁开发区天元西路88号文化名园4幢440', '5', '33', '1', '2020-01-06 11:41:37', '小户型');
INSERT INTO `t_room_info` VALUES ('41', '江苏省南京市浦口区沿江街道南浦路323号江岸水城42号楼509', '4', '66', '0', '2020-02-10 00:00:00', '短租');
INSERT INTO `t_room_info` VALUES ('42', '江苏省南京市保利香槟国际（金沙江东街）55幢302', '5', '89', '1', '2020-2-10 12:47:51', '好地段');
INSERT INTO `t_room_info` VALUES ('44', '江苏省雨花台区软件大道198号恒大华府44幢443', '4', '44', '1', '2020-2-10 15:18:35', '别墅区');
INSERT INTO `t_room_info` VALUES ('48', '江苏省南京市江宁区香山美墅5幢819', '3', '44', '1', '2020-2-11 19:53:16', '别墅区，风景好');
