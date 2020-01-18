/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-04-23 12:01:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_0807
-- ----------------------------
DROP TABLE IF EXISTS `user_0807`;
CREATE TABLE `user_0807` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `friend_List` varchar(255) DEFAULT NULL,
  `create_Time` datetime DEFAULT NULL,
  `mail_Account` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_0807
-- ----------------------------
INSERT INTO `user_0807` VALUES ('lili', '202cb962ac59075b964b07152d234b70', null, '2018-04-17 13:15:53', '123', '5');
INSERT INTO `user_0807` VALUES ('mingming', '202cb962ac59075b964b07152d234b70', null, '2018-04-19 00:56:59', '123', '6');
INSERT INTO `user_0807` VALUES ('kiss', '202cb962ac59075b964b07152d234b70', null, '2018-04-23 11:18:30', '123', '7');
