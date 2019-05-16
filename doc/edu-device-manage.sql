/*
 Navicat Premium Data Transfer

 Source Server         : zhibi
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 120.27.24.193:3306
 Source Schema         : edu-device-manage

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : 65001

 Date: 16/05/2019 21:45:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `user_id` int(11) NULL DEFAULT 0,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `pay_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `price` double(255, 2) NULL DEFAULT 0.00,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('rrr', 1, 'fff', '2019-05-16', '/upload/351b2e39-5f21-408e-a1bf-fe3b97da5383.jpg', 123.00, '借出', 3, '2019-05-16 21:09:14', '2019-05-16 21:19:23');
INSERT INTO `device` VALUES ('444', 1, '54g', '2019-05-16', '/upload/f219581c-18fa-450d-bb1a-2f847bf2387c.png', 4555.00, '借出', 2, '2019-05-16 17:58:13', '2019-05-16 21:20:24');
INSERT INTO `device` VALUES ('555', 1, '5645', '2019-12-16', '/upload/a1626d00-abfd-445b-92ab-6d786d40baac.jpg', 55.00, '借出', 4, '2019-05-16 21:24:37', '2019-05-16 21:24:43');
INSERT INTO `device` VALUES ('tt', 1, '12', '2019-05-16', '/upload/412012d3-d1cd-4283-9457-6289fd8ffabc.jpeg', 12.00, '未借', 5, '2019-05-16 21:28:11', '2019-05-16 21:44:06');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `user_id` int(11) NULL DEFAULT 0,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `device_id` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('借出', 1, 1, '2019-05-16 21:43:15', NULL, 4);
INSERT INTO `orders` VALUES ('归还', 1, 2, '2019-05-16 21:43:45', '2019-05-16 21:44:06', 5);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `wx` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', 'ces', '202CB962AC59075B964B07152D234B70', '', '', 1, '2019-05-16 16:49:01', NULL);

SET FOREIGN_KEY_CHECKS = 1;
