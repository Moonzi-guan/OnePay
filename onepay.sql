/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : onepay

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-09-24 09:09:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message_for_administrators
-- ----------------------------
DROP TABLE IF EXISTS `message_for_administrators`;
CREATE TABLE `message_for_administrators` (
  `message_aid` varchar(50) NOT NULL,
  `message_sid` varchar(50) DEFAULT NULL,
  `message_type` varchar(10) DEFAULT NULL,
  `message_topic` varchar(50) DEFAULT NULL,
  `message_content` varchar(255) DEFAULT NULL,
  `message_time` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `reply_message_topic` varchar(50) DEFAULT NULL,
  `reply_message_conten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_for_administrators
-- ----------------------------
INSERT INTO `message_for_administrators` VALUES ('11', '1', '遗失', '冻结问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', '', null);
INSERT INTO `message_for_administrators` VALUES ('12', '2', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null);
INSERT INTO `message_for_administrators` VALUES ('13', '3', '遗失', '冻结问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null);
INSERT INTO `message_for_administrators` VALUES ('14', '4', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null);
INSERT INTO `message_for_administrators` VALUES ('15', '5', '遗失', '冻结问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null);
INSERT INTO `message_for_administrators` VALUES ('16', '6', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null);
INSERT INTO `message_for_administrators` VALUES ('17', '7', '遗失', '冻结问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null);

-- ----------------------------
-- Table structure for message_for_student
-- ----------------------------
DROP TABLE IF EXISTS `message_for_student`;
CREATE TABLE `message_for_student` (
  `message_sid` varchar(50) NOT NULL,
  `message_type` varchar(50) DEFAULT NULL,
  `message_topic` varchar(50) DEFAULT NULL,
  `message_content` varchar(225) DEFAULT NULL,
  `message_time` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `receive_message_time` varchar(50) DEFAULT NULL,
  `receive_message_topic` varchar(50) DEFAULT NULL,
  `receive_message_content` varchar(255) DEFAULT NULL,
  `show` int(255) DEFAULT NULL,
  PRIMARY KEY (`message_sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_for_student
-- ----------------------------
INSERT INTO `message_for_student` VALUES ('1', '遗失', '冻结问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null, null, '0');
INSERT INTO `message_for_student` VALUES ('10', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', '2018-09-02 12:12:12', '2', '2', '0');
INSERT INTO `message_for_student` VALUES ('4', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null, null, '1');
INSERT INTO `message_for_student` VALUES ('5', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null, null, '1');
INSERT INTO `message_for_student` VALUES ('6', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null, null, '1');
INSERT INTO `message_for_student` VALUES ('7', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', null, null, null, '1');
INSERT INTO `message_for_student` VALUES ('8', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', '2018-09-06 04:20:42', 'ds', 'sd', '0');
INSERT INTO `message_for_student` VALUES ('9', '捡到', '归还问题', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '2018-09-01 16:38:23', '583314115@qq.com', '2018-09-02 12:12:12', '关于归还的问题', '这个问题我们已经在处理当中，如果不出意外，我们将会在3天内给您答复，谢谢！', '0');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` varchar(50) NOT NULL,
  `news_classify` varchar(255) DEFAULT NULL,
  `news_topic` varchar(255) DEFAULT NULL,
  `news_content` varchar(255) DEFAULT NULL,
  `release_time` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('sadfsadfasdas', '校园资讯', '校园一卡通', '测试测试', '2018-09-12 12:12:12', 'picture1.jpg');
INSERT INTO `news` VALUES ('12', '校园资讯', '校园一卡通', '测试测试', '2018-09-12 12:12:12', 'picture1.jpg');
INSERT INTO `news` VALUES ('121', '校园资讯', '校园一卡通', '测试测试', '2018-09-12 12:12:12', 'picture1.jpg');
INSERT INTO `news` VALUES ('121212', '校园资讯', '校园一卡通', '测试测试', '2018-09-12 12:12:12', 'picture1.jpg');
INSERT INTO `news` VALUES ('1212', '校园资讯', '校园一卡通', '测试测试', '2018-09-12 12:12:12', 'picture1.jpg');
INSERT INTO `news` VALUES ('12312', '校园资讯', '校园一卡通', '测试测试', '2018-09-12 12:12:12', 'picture1.jpg');
INSERT INTO `news` VALUES ('b47b012f-bed7-4b93-b1cf-21a380087dc7', '国内新闻', '吓死', '西安市西安市西安市', '2018-09-18 03:09:54', null);
INSERT INTO `news` VALUES ('7dee2222-2a3f-424c-a9f0-6bf46d95bfd2', '国际新闻', 'sad', 'ssssssss', '2018-09-18 03:16:11', null);

-- ----------------------------
-- Table structure for news_classify
-- ----------------------------
DROP TABLE IF EXISTS `news_classify`;
CREATE TABLE `news_classify` (
  `nid` int(11) NOT NULL,
  `classify` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_classify
-- ----------------------------
INSERT INTO `news_classify` VALUES ('1', '校园新闻');
INSERT INTO `news_classify` VALUES ('2', '国内新闻');
INSERT INTO `news_classify` VALUES ('3', '国际新闻');

-- ----------------------------
-- Table structure for student_information
-- ----------------------------
DROP TABLE IF EXISTS `student_information`;
CREATE TABLE `student_information` (
  `id` varchar(50) NOT NULL,
  `student_sid` varchar(50) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `student_sex` varchar(50) DEFAULT NULL,
  `student_major` varchar(50) DEFAULT NULL,
  `student_class` varchar(50) DEFAULT NULL,
  `student_addr` varchar(50) DEFAULT NULL,
  `student_money` float(50,2) DEFAULT NULL,
  `student_status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_information
-- ----------------------------
INSERT INTO `student_information` VALUES ('1', '1001', '张三', '男', '理学院', '信息16-1', '广东省', '100.12', '0');
INSERT INTO `student_information` VALUES ('2', '1002', '李四', '女', '经济管理学院', '法学16-1', '福建省', '12.00', '1');
INSERT INTO `student_information` VALUES ('3', '1003', '王五', '男', '理学院', '信息16-1', '广东省', '100.12', '1');
INSERT INTO `student_information` VALUES ('4', '1004', '赵六', '女', '经济管理学院', '法学16-1', '福建省', '12.00', '1');
INSERT INTO `student_information` VALUES ('13451e2d-175a-40da-b82d-4222a880f8b6', '1009', '官春发', '男', '信息与计算科学', '信息16-1', '广东省', '0.00', '正常');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `power` varchar(20) DEFAULT NULL,
  `lock` varchar(20) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'good', '123', '信息录入员', '是', '2018-09-01');
INSERT INTO `user` VALUES ('4', 'test02', '123', '信息录入员', '否', '2018-01-01');
INSERT INTO `user` VALUES ('6', 'test03', '123', '信息录入员', '否', '2018-01-01');
INSERT INTO `user` VALUES ('8', 'test04', '123', '信息录入员', '是', '2018-08-25');
INSERT INTO `user` VALUES ('10', 'test05', '123', '信息录入员', '是', '2018-08-25');
INSERT INTO `user` VALUES ('11', 'test06', '123', '信息录入员', '否', '2018-08-25');
INSERT INTO `user` VALUES ('14', 'test07', '123', '信息录入员', '否', '2018-08-25');
INSERT INTO `user` VALUES ('efd9cf36-1e83-4bda-9f97-529fd2ea6217', 'test09', '123', '信息录入员', '是', '2018-08-25');
INSERT INTO `user` VALUES ('3a295f89-3b25-4fed-a5e2-0a3d070ad447', 'test10', '123', '信息录入员', '是', '2018-08-25');
INSERT INTO `user` VALUES ('45a80188-8fff-4fcb-9c19-90425572d6bd', 'test11', '123', '超级管理员', '否', '2018-08-25');
INSERT INTO `user` VALUES ('6bf203b2-6ca2-4162-a5a7-4e1baea48e5f', 'test12', '123', '超级管理员', '否', '2018-08-25');
INSERT INTO `user` VALUES ('96abe9d0-5ec1-40f5-a244-6ab9b908c159', 'test13', '123', '信息录入员', '是', '2018-09-03 09:28:50');

-- ----------------------------
-- Table structure for userpower
-- ----------------------------
DROP TABLE IF EXISTS `userpower`;
CREATE TABLE `userpower` (
  `cid` int(11) NOT NULL,
  `powername` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userpower
-- ----------------------------
INSERT INTO `userpower` VALUES ('1', '信息录入员');
INSERT INTO `userpower` VALUES ('2', '一般管理员');
INSERT INTO `userpower` VALUES ('3', '超级管理员');
