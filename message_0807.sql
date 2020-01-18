/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-04-23 12:00:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message_0807
-- ----------------------------
DROP TABLE IF EXISTS `message_0807`;
CREATE TABLE `message_0807` (
  `send_Id` int(11) DEFAULT NULL,
  `accept_Id` int(11) DEFAULT NULL,
  `send_Time` datetime DEFAULT NULL,
  `accept_Time` datetime DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `if_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_0807
-- ----------------------------
INSERT INTO `message_0807` VALUES ('1', '2', '2018-04-18 20:30:43', '2018-04-18 20:30:43', '1', '主题', '内容', '0');
INSERT INTO `message_0807` VALUES ('1', '2', '2018-04-18 20:30:43', '2018-04-18 20:30:43', '2', '主题', '内容', '0');
INSERT INTO `message_0807` VALUES ('1', '2', '2018-04-18 20:30:43', '2018-04-18 20:30:43', '3', '主题', '内容', '1');
INSERT INTO `message_0807` VALUES ('1', '2', '2018-04-18 20:30:43', '2018-04-18 20:30:43', '4', '主题', '内容', '1');
INSERT INTO `message_0807` VALUES ('1', '2', '2018-04-18 20:30:43', '2018-04-18 20:30:43', '5', '主题', '内容', '1');
INSERT INTO `message_0807` VALUES ('1', '2', '2018-04-18 20:30:43', '2018-04-18 20:30:43', '6', '主题', '内容', '1');
INSERT INTO `message_0807` VALUES ('1', '2', '2018-04-18 20:30:43', '2018-04-18 20:30:43', '7', '主题', '内容', '1');
INSERT INTO `message_0807` VALUES ('1', '2', '2018-04-18 20:30:43', '2018-04-18 20:30:43', '8', '主题', '内容', '1');
INSERT INTO `message_0807` VALUES (null, null, null, null, '11', null, null, null);
INSERT INTO `message_0807` VALUES (null, null, null, null, '12', null, null, null);
INSERT INTO `message_0807` VALUES (null, null, null, null, '13', null, null, null);
INSERT INTO `message_0807` VALUES (null, null, null, null, '14', null, null, null);
INSERT INTO `message_0807` VALUES ('5', '5', '2018-04-22 23:42:11', '2018-04-22 23:42:11', '17', '123', '123', '0');
INSERT INTO `message_0807` VALUES ('5', '5', '2018-04-23 11:17:07', '2018-04-23 11:17:07', '18', '123', '123', '0');
INSERT INTO `message_0807` VALUES ('7', '5', '2018-04-23 11:25:00', '2018-04-23 11:25:00', '19', '123', '123', '0');
INSERT INTO `message_0807` VALUES ('7', '7', '2018-04-23 11:29:51', '2018-04-23 11:29:51', '20', 'hello', '123', '1');
