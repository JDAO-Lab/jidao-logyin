/*
 Navicat Premium Data Transfer

 Source Server         : mysqlLocal
 Source Server Type    : MySQL
 Source Server Version : 50738 (5.7.38-log)
 Source Host           : localhost:3306
 Source Schema         : long_yin

 Target Server Type    : MySQL
 Target Server Version : 50738 (5.7.38-log)
 File Encoding         : 65001

 Date: 11/05/2025 00:42:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_cat
-- ----------------------------
DROP TABLE IF EXISTS `app_cat`;
CREATE TABLE `app_cat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户端名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户端简介',
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '客户端应用类型' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of app_cat
-- ----------------------------
INSERT INTO `app_cat` VALUES (1, '安卓', '安卓系列应用版本。', '2021-05-12 13:34:27', '2021-05-12 13:39:34', 0);
INSERT INTO `app_cat` VALUES (2, 'IOS', '苹果手机系统版本应用。', '2021-05-12 13:35:16', '2021-05-12 13:39:20', 0);

-- ----------------------------
-- Table structure for app_version
-- ----------------------------
DROP TABLE IF EXISTS `app_version`;
CREATE TABLE `app_version`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '版本标题',
  `up_log` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '更新日志',
  `down_url` varchar(666) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '下载地址',
  `down_pwd` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '提取码',
  `down_type` tinyint(2) NOT NULL DEFAULT 0 COMMENT '下载方式：0本地OSS 1阿里网盘 2蓝奏云 3小鸟云 4百度网盘',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新日期',
  `cid` int(11) NULL DEFAULT NULL COMMENT '客户端类型',
  `version` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '0.0.1' COMMENT '版本号',
  `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否删除默认为0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '客户端应用版本管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of app_version
-- ----------------------------

-- ----------------------------
-- Table structure for sms_code
-- ----------------------------
DROP TABLE IF EXISTS `sms_code`;
CREATE TABLE `sms_code`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '接收验证码的手机号',
  `code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '验证码',
  `send_time` datetime NULL DEFAULT NULL COMMENT '发送时间',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '1注册 2登录 3找回密码 4实名验证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '手机验证码' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sms_code
-- ----------------------------

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `is_deleted` tinyint(2) NULL DEFAULT 0 COMMENT '0未删除 1已删除',
  `rule_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `enable` tinyint(2) NOT NULL DEFAULT 1 COMMENT '0禁用 1启用',
  `login_at` datetime NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '管理员用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, 'admin', '7fef6171469e80d32c0559f88b377245', '31ad083163cdb4cf6fbcbe148e46fed3', '2021-02-07 20:10:10', '2021-05-04 14:59:57', 0, 1, 'https://oss.youqiong.net/2a8038416840457e8edd92d939ccf5ae/184b1aadd7d744babadc54ae69bfa143.jpg', 1, '2025-05-10 22:50:59');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'web_site', 'LogYin Admin 一款好用的基线后台开发系统', '2021-03-05 21:32:49', '2021-03-05 21:32:54');
INSERT INTO `sys_config` VALUES (2, 'short_title', '后台管理系统', '2021-03-05 21:34:27', '2021-03-05 21:34:29');
INSERT INTO `sys_config` VALUES (3, 'author', '任聪聪', '2021-03-18 20:35:42', NULL);
INSERT INTO `sys_config` VALUES (4, 'admin_key', '861157525', '2021-03-18 20:35:45', NULL);
INSERT INTO `sys_config` VALUES (5, 'theme_config', '{\"logo\":{\"title\":\"LogYin Admin\",\"image\":\"https://oss.youqiong.net/2a8038416840457e8edd92d939ccf5ae/184b1aadd7d744babadc54ae69bfa143.jpg\"},\"menu\":{\"data\":\"admin/get_menu\",\"method\":\"GET\",\"accordion\":true,\"collapse\":false,\"control\":false,\"controlWidth\":500,\"select\":\"24\",\"async\":true},\"tab\":{\"enable\":true,\"keepState\":true,\"session\":true,\"preload\":false,\"max\":\"30\",\"index\":{\"id\":\"24\",\"href\":\"/admin/console\",\"title\":\"控制台\"}},\"theme\":{\"defaultColor\":\"2\",\"defaultMenu\":\"dark-theme\",\"defaultHeader\":\"light-theme\",\"allowCustom\":true,\"banner\":false},\"colors\":[{\"id\":\"1\",\"color\":\"#2d8cf0\",\"second\":\"#ecf5ff\"},{\"id\":\"2\",\"color\":\"#36b368\",\"second\":\"#f0f9eb\"},{\"id\":\"3\",\"color\":\"#f6ad55\",\"second\":\"#fdf6ec\"},{\"id\":\"4\",\"color\":\"#f56c6c\",\"second\":\"#fef0f0\"},{\"id\":\"5\",\"color\":\"#3963bc\",\"second\":\"#ecf5ff\"}],\"other\":{\"keepLoad\":\"200\",\"autoHead\":\"true\",\"footer\":\"true\"}}', '2021-03-18 20:35:45', NULL);
INSERT INTO `sys_config` VALUES (6, 'prohibited_words', 'admin,rcc,admin888,root', '2021-03-18 20:35:45', NULL);
INSERT INTO `sys_config` VALUES (7, 'web_ico', 'https://oss.youqiong.net/8ff91f19496c4ec199959ecfa88efe3b/73d8b9e36a7e4ab694cd852a01c37ba4.png', '2021-03-18 20:35:45', NULL);
INSERT INTO `sys_config` VALUES (8, 'web_keywords', 'LogYin,基线后台管理系统', '2021-03-18 20:35:45', NULL);
INSERT INTO `sys_config` VALUES (9, 'web_description', 'LogYin Admin 一款好用的基线后台开发系统，能够帮助你快速进入java项目的开发工作当中。', '2021-03-18 20:35:45', NULL);
INSERT INTO `sys_config` VALUES (10, 'icp_number', '', '2021-03-18 20:35:45', NULL);
INSERT INTO `sys_config` VALUES (11, 'icp_href', '', '2021-03-18 20:35:45', NULL);
INSERT INTO `sys_config` VALUES (12, 'static_script', '', '2021-03-18 20:35:45', NULL);

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文件原始名',
  `file_path` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上传后的文件路径 调用它即可',
  `file_md5` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '唯一MD5 uuid+文件名转换而来',
  `created_at` datetime NULL DEFAULT NULL COMMENT '上传时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上传者ip',
  `size` int(11) NULL DEFAULT NULL COMMENT '文件大小',
  `ext` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文件类型 例：.jpg',
  `local` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文件存储方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文件缓存表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '访问ip',
  `path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '访问路径',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注：一般登录用户会增加用户名的字眼开头',
  `result` tinyint(2) NOT NULL DEFAULT 0 COMMENT '结果：0未知、1成功、2失败',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `method` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_orders
-- ----------------------------
DROP TABLE IF EXISTS `sys_orders`;
CREATE TABLE `sys_orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单备注信息',
  `trade_no` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单编号 唯一的系统生成',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '0未支付 1已支付 2已取消',
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL COMMENT '购买人id',
  `pay_type` tinyint(2) NULL DEFAULT NULL COMMENT '支付方式 1微信 2支付宝',
  `out_trade_no` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '平台的支付订单编号 外部订单号',
  `income_id` tinyint(2) NULL DEFAULT NULL COMMENT '对应增值服务id',
  `pay_at` datetime NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_orders
-- ----------------------------

-- ----------------------------
-- Table structure for sys_rules
-- ----------------------------
DROP TABLE IF EXISTS `sys_rules`;
CREATE TABLE `sys_rules`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限名称：管理员、普通用户',
  `rules` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '菜单id，以，号隔开。',
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `is_deleted` tinyint(2) NULL DEFAULT 0 COMMENT '0正常 1删除',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统权限配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_rules
-- ----------------------------
INSERT INTO `sys_rules` VALUES (1, '超级管理员', '10,15,7,21,22,11,2,3,37,4,40,29,30,31,12,5,20,28,44,36,6,17,18,19,27,33,41,42,43,16,13,32,14,26,38,39,23,8,9,24,25', '2021-03-06 22:17:00', '2021-05-03 14:53:02', 0, '系统默认权限组，所有路径均可访问。');
INSERT INTO `sys_rules` VALUES (2, '管理员', '10,15,7,21,22,11,2,3,37,4,40,29,30,31,12,5,20,28,44,36,6,17,18,19,27,33,41,42,43,16,13,32,14,26,38,39,23,8,9,24,25', '2021-04-10 14:29:40', '2021-05-03 14:53:08', 0, '普通管理员权限');

-- ----------------------------
-- Table structure for sys_rules_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_rules_menu`;
CREATE TABLE `sys_rules_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单的名称',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单的路径',
  `pid` int(11) NOT NULL DEFAULT 0 COMMENT '菜单的父节点',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单的描述',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单的ifon图标',
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `is_deleted` tinyint(2) NULL DEFAULT 0 COMMENT '0正常 1删除',
  `target` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '打开方式',
  `allow` tinyint(2) NOT NULL DEFAULT 0 COMMENT '0为需验证进行访问 1为无需验证即可访问',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '序号',
  `hide` tinyint(2) NOT NULL DEFAULT 0 COMMENT '0为显示 1为隐藏',
  `enable` tinyint(2) NOT NULL DEFAULT 1 COMMENT '0禁用 1启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '权限菜单表，包含了系统中的相关菜单信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_rules_menu
-- ----------------------------
INSERT INTO `sys_rules_menu` VALUES (1, '前往前台', '/', 23, '', 'layui-icon-home', '2021-03-06 21:46:09', '2021-04-05 14:37:42', 1, '_target', 0, 1, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (2, '菜单管理', '/admin/menus/list', 11, '编辑和调整菜单信息越详细越好。', 'layui-icon layui-icon-menu-fill', '2021-03-06 21:47:00', '2021-04-10 21:27:46', 0, '_self', 0, 1, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (3, '权限配置', '/admin/rules/list', 11, '配置权限信息选择越详细越好。', 'layui-icon layui-icon-key', '2021-03-06 21:48:29', '2021-04-10 21:28:51', 0, '_self', 0, 2, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (4, '系统管理员', '/admin/sys_admin/list', 11, '除超级管理员admin外其余用户均可删除。', 'layui-icon layui-icon layui-icon-user', '2021-03-06 21:54:05', '2021-04-10 15:56:09', 0, '_self', 0, 3, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (5, '用户列表', '/admin/users/list', 12, NULL, 'layui-icon-water', '2021-03-06 21:54:08', NULL, 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (6, '数据统计', '#', 0, '', 'layui-icon layui-icon-test', '2021-03-06 21:54:11', '2021-04-05 14:48:17', 0, '_self', 0, 4, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (7, '系统配置', '/admin/setting', 10, '系统配置界面信息', 'layui-icon layui-icon-slider', '2021-03-06 21:54:13', '2021-04-05 13:07:32', 0, '_self', 0, 2, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (8, '资料修改', '/admin/sys_admins/profile', 23, NULL, 'layui-icon-tabs', '2021-03-06 21:54:15', '2021-04-05 14:37:45', 0, '_self', 0, 2, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (9, '安全退出', '/admin/logout', 23, NULL, 'layui-icon-logout', '2021-03-06 21:54:17', '2021-04-05 14:37:47', 0, '_self', 0, 3, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (10, '系统管理', '#', 0, '', 'layui-icon layui-icon-slider', '2021-03-07 19:52:04', '2021-04-05 14:46:50', 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (11, '权限管理', '#', 0, '', 'layui-icon layui-icon-password', '2021-03-07 19:52:06', '2021-04-05 14:47:20', 0, '_self', 0, 1, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (12, '用户管理', '#', 0, '', 'layui-icon layui-icon-username', '2021-03-07 19:52:09', '2021-04-05 14:47:56', 0, '_self', 0, 3, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (13, '客户端类型', '/admin/app_cat/list', 16, '', 'layui-icon layui-icon layui-icon-face-smile', '2021-03-07 19:52:11', '2021-05-04 18:44:07', 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (14, '版本管理', '/admin/app_version/list', 16, '', 'layui-icon layui-icon-face-smile', '2021-03-07 19:52:13', '2021-05-04 18:44:25', 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (15, '主题配置', '/admin/theme_setting', 10, '主题配置信息', 'layui-icon layui-icon-heart', '2021-03-07 19:52:15', '2021-04-05 14:47:07', 0, '_self', 0, 1, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (16, '客户端管理', '#', 0, '', 'layui-icon layui-icon-app', '2021-03-07 19:52:17', '2021-04-05 14:48:44', 0, '_self', 0, 6, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (17, '综合分析', '/admin/statics/all', 6, NULL, 'layui-icon-face-smile', '2021-03-07 19:52:19', NULL, 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (18, '收入分析', '/admin/statics/order', 6, NULL, 'layui-icon-face-smile', '2021-03-07 19:52:21', NULL, 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (19, '用户分析', '/admin/statics/user', 6, NULL, 'layui-icon-face-smile', '2021-03-07 19:52:24', NULL, 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (20, '获取数据', '/admin/users/data', 5, '', 'layui-icon layui-icon-face-smile', '2021-03-07 19:52:26', '2021-04-11 17:34:45', 0, '_self', 0, 0, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (21, '系统日志', '/admin/log/sys_log', 10, '此页面展示从系统创建至今的所有用户操作信息记录，可以通过数据库进行删除！', 'layui-icon-face-smile', '2021-03-07 19:52:28', NULL, 0, '_self', 0, 3, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (22, '违禁词', '/admin/prohibited_words', 10, NULL, 'layui-icon-face-smile', '2021-03-07 19:52:31', NULL, 0, '_self', 0, 4, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (23, '用户行为', NULL, 0, NULL, 'layui-icon-face-smile', '2021-03-07 19:52:33', '2021-04-05 14:35:48', 0, '_self', 0, 100, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (24, '控制台', '/admin/console', 23, NULL, 'layui-icon-face-smile', '2021-03-08 21:56:37', '2021-04-05 14:37:49', 0, '_self', 0, 4, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (25, '登录', '/admin/login', 23, NULL, 'layui-icon-face-smile', '2021-03-13 18:36:21', '2021-04-05 14:37:52', 0, '_self', 0, 5, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (26, '其他菜单', NULL, 0, NULL, 'layui-icon-face-smile', '2021-03-13 18:39:27', '2021-04-05 14:34:02', 0, '_self', 0, 8, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (27, '管理中心', '/admin', 0, '', 'layui-icon layui-icon-face-smile', '2021-03-13 18:40:01', '2021-04-05 14:39:04', 0, '_self', 0, 5, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (28, '意见反馈', '/admin/opinion/list', 12, '', 'layui-icon layui-icon-gift', '2021-04-04 23:45:57', '2021-05-12 15:57:49', 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (29, '前台导航', '#', 0, '', 'layui-icon layui-icon-website', '2021-04-04 23:45:55', '2021-04-05 14:47:40', 0, '_self', 0, 2, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (30, '位置管理', '/admin/nav_cat/list', 29, '', 'layui-icon ', '2021-04-04 23:45:53', '2021-05-03 18:21:26', 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (31, '导航列表', '/admin/nav/list', 29, '', 'layui-icon ', '2021-04-04 23:45:48', '2021-05-03 18:21:45', 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (32, '列表', '/admin/app/category/list', 13, '客户端类型包括安卓、ios、mac、linux、win等，可自定义前端下载页显示。', 'layui-icon layui-icon-circle-dot', '2021-04-04 23:39:04', NULL, 1, '_self', 0, 0, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (33, '图文管理', '#', 0, '文章管理功能顶级菜单', 'layui-icon layui-icon layui-icon-carousel', '2021-04-05 00:02:14', '2021-04-05 14:39:11', 0, '_self', 0, 5, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (34, '测试', '/test', 0, '测试页面', 'layui-icon layui-icon-home', '2021-04-05 13:34:41', NULL, 1, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (35, '测试子级', '/test', 34, '子级删除测试', 'layui-icon layui-icon-home', '2021-04-05 13:44:05', NULL, 1, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (36, '增值服务', '/admin/income/list', 12, '增值服务管理配置功能', 'layui-icon layui-icon layui-icon layui-icon layui-icon-light', '2021-04-05 14:45:55', '2021-04-30 16:52:44', 0, '_self', 0, 8, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (37, '获取数据', '/admin/rules/data', 3, '', 'layui-icon layui-icon layui-icon-home', '2021-04-09 23:34:22', '2021-05-04 00:11:40', 0, '_self', 0, 0, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (38, '获取主题', '/admin/get_the_theme', 26, '', 'layui-icon layui-icon-link', '2021-04-10 15:03:05', NULL, 0, '_self', 0, 0, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (39, '获取菜单', '/admin/get_menu', 26, '', 'layui-icon layui-icon-link', '2021-04-10 15:04:17', NULL, 0, '_self', 0, 0, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (40, '获取数据', '/admin/sys_admin/data', 4, '', 'layui-icon layui-icon-link', '2021-04-10 15:05:18', NULL, 0, '_self', 0, 0, 1, 1);
INSERT INTO `sys_rules_menu` VALUES (41, '图文分类', '/admin/post_cat/list', 33, '', 'layui-icon layui-icon layui-icon layui-icon-link', '2021-04-11 17:38:05', '2021-05-04 18:23:24', 0, '_self', 0, 0, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (42, '图文列表', '/admin/post/list', 33, '', 'layui-icon layui-icon layui-icon layui-icon-link', '2021-04-11 17:38:22', '2021-05-04 18:23:33', 0, '_self', 0, 1, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (43, '回收站', '/admin/post_recovery/list', 33, '此页面均为删除状态为1的数据，在此页面删除的内容会转为2，留存在数据库中，但不会显示在任何页面。', 'layui-icon layui-icon layui-icon layui-icon-link', '2021-04-30 19:53:31', '2021-05-04 18:39:58', 0, '_self', 0, 3, 0, 1);
INSERT INTO `sys_rules_menu` VALUES (44, '订单记录', '/admin/orders/list', 12, '购买增值服务的订单数据信息', 'layui-icon layui-icon-link', '2021-05-03 14:51:24', NULL, 0, '_self', 0, 4, 0, 1);

-- ----------------------------
-- Table structure for sys_static
-- ----------------------------
DROP TABLE IF EXISTS `sys_static`;
CREATE TABLE `sys_static`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '统计项名称：中文',
  `value` double(15, 2) NULL DEFAULT 0.00 COMMENT '统计数，保留两位小数点',
  `created_at` datetime NULL DEFAULT NULL COMMENT '统计日期',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '统计更新时间',
  `type` tinyint(2) NOT NULL DEFAULT 0 COMMENT '定义类型在枚举类StaticTypeEnum中',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统数据统计' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_static
-- ----------------------------
INSERT INTO `sys_static` VALUES (1, '2021-04-14 付款人数', 12.00, '2021-04-14 18:23:36', '2021-04-14 18:26:17', 2);
INSERT INTO `sys_static` VALUES (2, '2021-04-14 收入总额', 200.00, '2021-04-14 18:23:36', '2021-04-14 18:26:17', 6);
INSERT INTO `sys_static` VALUES (3, '2021-04-14 付款人数', 113.00, '2021-04-14 18:23:36', '2021-04-14 18:26:17', 4);
INSERT INTO `sys_static` VALUES (4, '2021-04-14 浏览次数', 1770.00, '2021-04-14 18:23:36', '2021-04-14 18:26:17', 0);
INSERT INTO `sys_static` VALUES (5, '2021-04-14 增加人数', 1279.00, '2021-04-14 18:23:36', '2021-04-14 18:26:17', 1);
INSERT INTO `sys_static` VALUES (6, '2021-04-14 收入总额', 2000.00, '2021-04-14 18:23:36', '2021-04-14 18:26:17', 3);
INSERT INTO `sys_static` VALUES (7, '2021-04-14 Api调用', 1324.00, '2021-04-14 18:23:36', '2021-04-14 18:26:17', 5);
INSERT INTO `sys_static` VALUES (8, '2021-04-13 收入总额', 23.95, '2021-04-13 18:23:36', NULL, 6);
INSERT INTO `sys_static` VALUES (9, '2021-04-30 浏览次数', 6.00, '2021-04-30 14:29:17', '2021-04-30 16:08:52', 0);
INSERT INTO `sys_static` VALUES (10, '2021-05-03 浏览次数', 33.00, '2021-05-03 15:41:04', '2021-05-03 15:43:23', 0);
INSERT INTO `sys_static` VALUES (11, '2021-05-04 浏览次数', 4.00, '2021-05-04 09:55:28', '2021-05-04 14:59:29', 0);
INSERT INTO `sys_static` VALUES (12, '2021-05-26 浏览次数', 1.00, '2021-05-26 23:19:23', NULL, 0);
INSERT INTO `sys_static` VALUES (13, '2021-05-27 浏览次数', 6.00, '2021-05-27 14:27:16', '2021-05-27 15:23:41', 0);
INSERT INTO `sys_static` VALUES (14, '2021-06-30 浏览次数', 1.00, '2021-06-30 18:10:26', NULL, 0);
INSERT INTO `sys_static` VALUES (15, '2021-08-25 浏览次数', 5.00, '2021-08-25 16:16:48', '2021-08-25 16:19:21', 0);
INSERT INTO `sys_static` VALUES (16, '2021-09-07 浏览次数', 2.00, '2021-09-07 00:42:41', '2021-09-07 00:42:49', 0);
INSERT INTO `sys_static` VALUES (17, '2021-10-05 浏览次数', 2.00, '2021-10-05 19:13:41', '2021-10-05 19:13:48', 0);
INSERT INTO `sys_static` VALUES (18, '2025-05-10 浏览次数', 4.00, '2025-05-10 22:50:14', '2025-05-10 22:50:34', 0);

-- ----------------------------
-- Table structure for web_income
-- ----------------------------
DROP TABLE IF EXISTS `web_income`;
CREATE TABLE `web_income`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '增值服务名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '描述信息',
  `discount` int(3) NULL DEFAULT NULL COMMENT '折扣',
  `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否删除0未删除 1已删除',
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会员标识图标',
  `duration` int(11) NULL DEFAULT NULL COMMENT '开通时长 单位天 -1为永久',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '增值服务信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_income
-- ----------------------------
INSERT INTO `web_income` VALUES (1, '年租会员', 199.00, '包年会员，低至0.5元每天。', 95, 0, '2021-04-30 16:46:06', '2021-05-03 14:40:02', NULL, 365);
INSERT INTO `web_income` VALUES (2, '日租会员', 1.00, '适合偶尔使用场景，按日付费', NULL, 0, '2021-05-03 14:22:13', '2021-05-03 14:40:05', NULL, 1);
INSERT INTO `web_income` VALUES (3, '月租会员', 19.90, '按月付费，适合较为频繁使用的频率。', NULL, 0, '2021-05-03 14:24:43', '2021-05-03 14:40:09', NULL, 30);
INSERT INTO `web_income` VALUES (4, '永久会员', 999.98, '适合长期使用的场景。', NULL, 0, '2021-05-03 14:25:54', '2021-05-03 14:39:58', NULL, -1);
INSERT INTO `web_income` VALUES (5, '十二生肖活动会员', 19.88, '一次续费12年有效，鼠年庆祝活动特别会员。', 60, 0, '2021-05-03 14:32:49', '2021-05-12 11:00:11', '', 365000);

-- ----------------------------
-- Table structure for web_nav
-- ----------------------------
DROP TABLE IF EXISTS `web_nav`;
CREATE TABLE `web_nav`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '导航名称',
  `keywords` varchar(666) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '关键词',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '图文内容',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `pid` int(11) NOT NULL DEFAULT 0 COMMENT '上级id',
  `path` varchar(666) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '路径',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '1' COMMENT '1图文 2连接',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `enable` tinyint(4) NOT NULL DEFAULT 0 COMMENT '启用状态',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '描述信息',
  `cid` int(11) NULL DEFAULT NULL COMMENT '类型id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_nav
-- ----------------------------
INSERT INTO `web_nav` VALUES (1, '介绍', NULL, NULL, 0, 0, '/', '2', '2021-05-03 21:04:38', '2021-05-04 10:20:20', 1, NULL, 1);
INSERT INTO `web_nav` VALUES (2, '定价', '购买界面', NULL, 1, 0, '/price', '1', '2021-05-03 21:05:36', '2021-05-04 11:17:41', 1, '', 1);
INSERT INTO `web_nav` VALUES (3, '版本', NULL, NULL, 2, 0, NULL, '1', '2021-05-03 21:05:39', '2021-05-04 10:20:22', 1, NULL, 1);
INSERT INTO `web_nav` VALUES (4, '帮助', NULL, NULL, 3, 0, NULL, '1', '2021-05-03 21:05:41', '2021-05-04 10:20:23', 1, NULL, 1);
INSERT INTO `web_nav` VALUES (22, '登录设置', '密码修改', NULL, 1, 0, '/user/setting', '1', '2021-05-04 10:22:06', '2021-05-04 10:38:14', 1, '修改密码及设置登录方式。', 2);
INSERT INTO `web_nav` VALUES (23, '会员信息', '会员信息', NULL, 2, 0, '', '1', '2021-05-04 10:22:38', '2021-05-04 10:38:18', 1, '', 2);
INSERT INTO `web_nav` VALUES (24, '充值记录', '充值记录', NULL, 3, 0, '', '1', '2021-05-04 10:23:19', '2021-05-04 10:38:20', 1, '', 2);
INSERT INTO `web_nav` VALUES (25, '隐私政策', '隐私', '# 家人健康平安', 1, 0, '', '1', '2021-05-04 10:36:24', '2021-05-04 14:26:02', 1, '', 3);
INSERT INTO `web_nav` VALUES (26, '用户协议', '协议', NULL, 2, 0, '', '1', '2021-05-04 10:37:52', '2021-05-04 10:38:06', 1, '', 3);

-- ----------------------------
-- Table structure for web_nav_cat
-- ----------------------------
DROP TABLE IF EXISTS `web_nav_cat`;
CREATE TABLE `web_nav_cat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(166) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类型名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '描述信息',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '前端导航分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_nav_cat
-- ----------------------------
INSERT INTO `web_nav_cat` VALUES (1, '主导航', '用于官网的导航显示，删除后将不再显示！！', '2021-05-03 19:13:53', '2021-05-12 13:40:17', 0);
INSERT INTO `web_nav_cat` VALUES (2, '个人中心', '个人中心部分显示的菜单信息。', '2021-05-03 19:14:00', '2021-05-12 13:40:20', 0);
INSERT INTO `web_nav_cat` VALUES (3, '页脚导航', '在页脚调用的导航信息，包含隐私政策等。', '2021-05-03 19:14:07', '2021-05-12 13:40:14', 0);

-- ----------------------------
-- Table structure for web_opinion
-- ----------------------------
DROP TABLE IF EXISTS `web_opinion`;
CREATE TABLE `web_opinion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '意见反馈说明',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '意见反馈内容',
  `is_deleted` tinyint(2) NULL DEFAULT NULL COMMENT '0未删除 1已删除',
  `ip` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'ip地址信息',
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '页面路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '意见反馈表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_opinion
-- ----------------------------

-- ----------------------------
-- Table structure for web_post
-- ----------------------------
DROP TABLE IF EXISTS `web_post`;
CREATE TABLE `web_post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文章标题',
  `keywords` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文章关键词',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文章描述',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '文章内容',
  `views` int(11) NOT NULL DEFAULT 0 COMMENT '浏览人数',
  `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '0未删除 1已删除 2彻底删除',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `cid` int(11) NULL DEFAULT NULL COMMENT '类型id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '图文信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_post
-- ----------------------------
INSERT INTO `web_post` VALUES (1, '用户注册说明', '注册用户信息', '帮助您快速注册个人账号的教程。', '# 注册账户说明\n\n# 步骤一、点击右上角注册按钮\n\n# 步骤二、进入注册界面，填写信息\n\n# 步骤三、接收验证码并提交请求\n\n# end：打开登录界面进行登录', 900, 1, '2021-05-12 10:50:26', '2021-05-12 10:59:51', 1);
INSERT INTO `web_post` VALUES (2, '测试添加', '测试添加', '', '	测试添加', 90, 2, '2021-05-12 11:01:27', '2021-05-12 11:03:55', 0);
INSERT INTO `web_post` VALUES (3, 'jkkkk', 'kkk', 'kkkkk\n', 'mjjj', 100, 1, '2021-05-12 11:08:24', '2021-05-12 11:09:23', 1);
INSERT INTO `web_post` VALUES (4, '测试1', '测试1', '测试1', '测试1', 100, 1, '2021-05-12 11:09:49', NULL, 1);
INSERT INTO `web_post` VALUES (5, '测试2', '测试2', '测试2', '', 100, 1, '2021-05-12 11:10:03', NULL, 1);
INSERT INTO `web_post` VALUES (6, '测试图文详情', '测试图文详情显示', '图文详情显示', '# 显示图片\n![](https://oss.youqiong.net/dd263dacefd645319567e9532d003c6d/8e7d324622d94f2a8df6fc580c226a1f.png)\n\n# 显示代码\n`print(\"888\");`\n\n# 显示多行代码\n       // 获取select元素\n       const selectElement = document.getElementById(\'mySelect\');\n    \n       // 添加change事件监听器\n       selectElement.addEventListener(\'change\', function() {\n           console.log(\'Select value changed:\', this.value);\n       });\n       \n	   \n\n# 显示代码块\n	 12321\n\n# 显示多行代码风格2\n```\n   // 获取select元素\n   const selectElement = document.getElementById(\'mySelect\');\n\n   // 添加change事件监听器\n   selectElement.addEventListener(\'change\', function() {\n       console.log(\'Select value changed:\', this.value);\n   });\n   \n```\n\n# 显示表格\n|  序号 | 标题  |\n| ------------ | ------------ |\n| 1  | 事业有成  |\n|  2 |  顺顺利利 |\n\n# 显示序号\n1. 你好\n2. 世界\n\n###科学公式 TeX(KaTeX)\n                    \n$$E=mc^2$$\n\n行内的公式$$E=mc^2$$行内的公式，行内的$$E=mc^2$$公式。\n\n$$\\(\\sqrt{3x-1}+(1+x)^2\\)$$\n                    \n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\n\n$$X^2 > Y$$\n\n#####上标和下标\n\n上标：X&lt;sup&gt;2&lt;/sup&gt;\n\n下标：O&lt;sub&gt;2&lt;/sub&gt;\n\n##### 代码块里包含的过滤标签及属性不会被过滤\n\n```html\n&lt;style type=\"text/style\"&gt;\nbody{background:red;}\n&lt;/style&gt;\n\n&lt;script type=\"text/javscript\"&gt;\nalert(\"script\");\n&lt;/script&gt;\n\n&lt;iframe height=498 width=510 src=\"http://player.youku.com/embed/XMzA0MzIwMDgw\" frameborder=0 allowfullscreen&gt;&lt;/iframe&gt;\n```\n\n[========]\n\n#####Style\n\n```&lt;style&gt;\nbody{background:red;}\n&lt;/style&gt;\n\n&lt;style type=\"text/style\"&gt;\nbody{background:red;}\n&lt;/style&gt;```\n\n#####Script\n\n```&lt;script&gt;\nalert(\"script\");\n&lt;/script&gt;\n\n&lt;script type=\"text/javscript\"&gt;\nalert(\"script\");\n&lt;/script&gt;```', 100, 0, '2021-05-12 11:14:38', '2021-05-12 11:54:53', 1);

-- ----------------------------
-- Table structure for web_post_cat
-- ----------------------------
DROP TABLE IF EXISTS `web_post_cat`;
CREATE TABLE `web_post_cat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `created_at` datetime NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `is_deleted` tinyint(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '图文类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_post_cat
-- ----------------------------
INSERT INTO `web_post_cat` VALUES (1, '常见问题', '产品使用中常见疑难解答内容。\n', '2021-05-04 18:33:55', '2021-05-04 18:36:00', 0);
INSERT INTO `web_post_cat` VALUES (2, '使用说明', '常规操作使用说明，让使用没有烦恼。', '2021-05-04 18:34:02', '2021-05-04 18:36:20', 0);

-- ----------------------------
-- Table structure for web_users
-- ----------------------------
DROP TABLE IF EXISTS `web_users`;
CREATE TABLE `web_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名 默认为自动生成的数字和英文',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `created_at` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像',
  `login_at` datetime NULL DEFAULT NULL COMMENT '登录时间',
  `sex` tinyint(2) NULL DEFAULT NULL COMMENT '0保密 1男 2女',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最后登录ip',
  `enable` tinyint(2) NOT NULL DEFAULT 1 COMMENT '0禁用 1启用',
  `token` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '令牌凭据',
  `login_count` int(11) NULL DEFAULT NULL COMMENT '登录次数',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '地理信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '前台用户数据表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of web_users
-- ----------------------------

-- ----------------------------
-- Table structure for web_users_vipser
-- ----------------------------
DROP TABLE IF EXISTS `web_users_vipser`;
CREATE TABLE `web_users_vipser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '开通状态: 激活(1)、未激活(0)、已过期(2)',
  `start_time` datetime NULL DEFAULT NULL COMMENT '最初冲会员的时间，不做更改',
  `end_time` datetime NULL DEFAULT NULL COMMENT '用于停止会员服务使用，每次充值后更新此时间，即失效时间',
  `renewals` int(11) NOT NULL DEFAULT 0 COMMENT '续费次数 单位次 仅供统计使用',
  `total_duration` int(11) NOT NULL DEFAULT 0 COMMENT '累计时长 单位秒 仅供统计使用',
  `last_renewal_time` datetime NULL DEFAULT NULL COMMENT '最近的续费时间，用于统计活跃付费用户',
  `income_id` int(11) NULL DEFAULT NULL COMMENT '增值服务id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = 'vip会员数据表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of web_users_vipser
-- ----------------------------
INSERT INTO `web_users_vipser` VALUES (1, 1, 1, '2021-04-30 16:15:28', '2025-05-01 16:15:31', 1, 31536000, '2021-04-30 16:15:53', 1);

SET FOREIGN_KEY_CHECKS = 1;
