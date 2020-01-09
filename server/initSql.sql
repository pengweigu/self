/*
 Source Server Type    : MySQL
 Source Server Version : 50728
 Target Server Type    : MySQL
 Target Server Version : 50728

 Author: pengwei
 Date: 07/01/2020 17:01:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 后台人员表
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(50)  NULL DEFAULT NULL COMMENT '后台用户账号',
  `name` varchar(50)  NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(100)  NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(255)  NULL DEFAULT NULL COMMENT '电话',
  `sex` varchar(10)  NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(100)  NULL DEFAULT NULL COMMENT '邮箱',
  `exts` longtext  NULL COMMENT '拓展json串',
  `status` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8;

-- ----------------------------
-- 初始化数据
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', 'admin', '123456', '18518666741', '1', '18518666741@163.com', NULL, 1);

-- ----------------------------
-- 数据库配置表
-- ----------------------------
DROP TABLE IF EXISTS `sys_conf`;
CREATE TABLE `sys_conf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NULL DEFAULT NULL,
  `value` longtext NULL,
  `status` int(255) NULL DEFAULT NULL,
  `type` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8;


SET FOREIGN_KEY_CHECKS = 1;
