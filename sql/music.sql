/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3307
 Source Schema         : music

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 29/01/2022 12:46:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) NULL DEFAULT 1,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_UNIQUE`(`phone`) USING BTREE,
  UNIQUE INDEX `name_UNIQUE`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, '超级管理员', '15599764059', 'admin', '$2a$10$3P7WxwVnLkTZgyCZ4FzB9.CVXUkCjSEMO514hHqg19pOui1zFLBHW', 1, 'https://cdn.jsdelivr.net/gh/xwrich/gallery@master/images/16420650372011.jpg');
INSERT INTO `t_admin` VALUES (2, '测试', '18798260156', 'test', '$2a$10$ogvUqZZAxrBwrmVI/e7.SuFYyx8my8d.9zJ6bs9lPKWvbD9eefyCe', 1, 'https://cdn.jsdelivr.net/gh/xwrich/gallery@master/images/16420654282169.jpg');

-- ----------------------------
-- Table structure for t_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_role`;
CREATE TABLE `t_admin_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `adminId` int NULL DEFAULT NULL COMMENT '用户id',
  `rid` int NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  INDEX `adminId`(`adminId`) USING BTREE,
  CONSTRAINT `t_admin_role_ibfk_1` FOREIGN KEY (`adminId`) REFERENCES `t_admin` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `t_admin_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin_role
-- ----------------------------
INSERT INTO `t_admin_role` VALUES (1, 1, 1);
INSERT INTO `t_admin_role` VALUES (2, 2, 2);

-- ----------------------------
-- Table structure for t_album
-- ----------------------------
DROP TABLE IF EXISTS `t_album`;
CREATE TABLE `t_album`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `album_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专辑名',
  `song_id` int NULL DEFAULT NULL COMMENT '歌曲id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `song_id`(`song_id`) USING BTREE,
  CONSTRAINT `t_album_ibfk_1` FOREIGN KEY (`song_id`) REFERENCES `t_song` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_album
-- ----------------------------

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `category_name`(`category_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '华语', '2022-01-27 21:10:51', NULL);
INSERT INTO `t_category` VALUES (2, '流行', '2022-01-27 20:54:42', NULL);
INSERT INTO `t_category` VALUES (3, '摇滚', '2022-01-27 20:54:56', NULL);
INSERT INTO `t_category` VALUES (4, '民谣', '2022-01-27 20:55:29', NULL);
INSERT INTO `t_category` VALUES (5, '电子', '2022-01-27 20:55:38', NULL);
INSERT INTO `t_category` VALUES (8, '测试1', '2022-01-27 21:04:35', NULL);
INSERT INTO `t_category` VALUES (9, '测试2', '2022-01-27 21:04:40', NULL);
INSERT INTO `t_category` VALUES (10, '测试3', '2022-01-27 21:04:43', NULL);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` int NOT NULL COMMENT '评论用户id',
  `song_id` int NOT NULL COMMENT '评论歌曲id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `song_id`(`song_id`) USING BTREE,
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_comment_ibfk_2` FOREIGN KEY (`song_id`) REFERENCES `t_song` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `parentId` int NULL DEFAULT NULL COMMENT '父菜单id',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parentId`(`parentId`) USING BTREE,
  CONSTRAINT `t_menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, '首页', '/', '', '', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (2, '歌曲管理', '/', '/home', 'Home', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (3, '用户管理', '/', '/home', 'Home', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (4, '评论管理', '/', '/home', 'Home', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (5, '系统管理', '/', '/home', 'Home', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (6, '歌单管理', '/song/basic/**', '/song/basic', 'SongBasic', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (7, '歌手管理', '/song/singer/**', '/song/singer', 'SongSinger', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (8, '专辑管理', '/song/album/**', '/song/album', 'SongAlbum', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (9, '分类管理', '/song/category/**', '/song/category', 'SongCategory', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (10, '榜单管理', '/song/rank/**', '/song/rank', 'SongRank', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (11, '用户管理', '/admin/basic/**', '/admin/basic', 'AdminBasic', NULL, 3, 1);
INSERT INTO `t_menu` VALUES (12, '评论管理', '/comment/basic/**', '/comment/basic', 'CommentBasic', NULL, 4, 1);
INSERT INTO `t_menu` VALUES (13, '角色管理', '/system/role/**', '/system/role', 'SysRole', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (14, '菜单管理', '/system/menu/**', '/system/menu', 'SysMenu', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (15, '操作日志', '/system/log/**', '/sys/log', 'SysLog', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (16, '个人中心', '/system/admin/**', '/sys/admin', 'SysAdmin', NULL, 5, 1);

-- ----------------------------
-- Table structure for t_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_role`;
CREATE TABLE `t_menu_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '菜单权限id',
  `mid` int NULL DEFAULT NULL COMMENT '菜单id',
  `rid` int NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `t_menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu_role
-- ----------------------------
INSERT INTO `t_menu_role` VALUES (1, 1, 1);
INSERT INTO `t_menu_role` VALUES (2, 2, 1);
INSERT INTO `t_menu_role` VALUES (3, 3, 1);
INSERT INTO `t_menu_role` VALUES (4, 4, 1);
INSERT INTO `t_menu_role` VALUES (5, 5, 1);
INSERT INTO `t_menu_role` VALUES (6, 6, 1);
INSERT INTO `t_menu_role` VALUES (7, 7, 1);
INSERT INTO `t_menu_role` VALUES (8, 8, 1);
INSERT INTO `t_menu_role` VALUES (9, 9, 1);
INSERT INTO `t_menu_role` VALUES (10, 10, 1);
INSERT INTO `t_menu_role` VALUES (11, 11, 1);
INSERT INTO `t_menu_role` VALUES (12, 12, 1);
INSERT INTO `t_menu_role` VALUES (13, 13, 1);
INSERT INTO `t_menu_role` VALUES (14, 14, 1);
INSERT INTO `t_menu_role` VALUES (15, 15, 1);
INSERT INTO `t_menu_role` VALUES (16, 16, 1);
INSERT INTO `t_menu_role` VALUES (18, 1, 2);
INSERT INTO `t_menu_role` VALUES (19, 2, 2);
INSERT INTO `t_menu_role` VALUES (20, 3, 2);
INSERT INTO `t_menu_role` VALUES (21, 4, 2);
INSERT INTO `t_menu_role` VALUES (22, 5, 2);
INSERT INTO `t_menu_role` VALUES (23, 6, 2);
INSERT INTO `t_menu_role` VALUES (24, 7, 2);
INSERT INTO `t_menu_role` VALUES (25, 8, 2);
INSERT INTO `t_menu_role` VALUES (26, 9, 2);
INSERT INTO `t_menu_role` VALUES (27, 10, 2);
INSERT INTO `t_menu_role` VALUES (29, 13, 2);
INSERT INTO `t_menu_role` VALUES (30, 14, 2);
INSERT INTO `t_menu_role` VALUES (31, 15, 2);

-- ----------------------------
-- Table structure for t_rank
-- ----------------------------
DROP TABLE IF EXISTS `t_rank`;
CREATE TABLE `t_rank`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '排行榜id',
  `rank_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '榜单名称',
  `song_id` int NOT NULL COMMENT '歌曲id',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '榜单简介',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `song_id`(`song_id`) USING BTREE,
  CONSTRAINT `t_rank_ibfk_1` FOREIGN KEY (`song_id`) REFERENCES `t_song` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_rank
-- ----------------------------
INSERT INTO `t_rank` VALUES (1, '飙升榜', 1, '热度排行榜', '2022-01-27 20:54:30', NULL);
INSERT INTO `t_rank` VALUES (2, '新歌榜', 2, '新歌排行榜', '2022-01-27 20:55:00', NULL);
INSERT INTO `t_rank` VALUES (3, '原创榜', 3, '实力排行榜', '2022-01-27 20:54:30', NULL);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `nameZh` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'ROLE_admin', '系统管理员');
INSERT INTO `t_role` VALUES (2, 'ROLE_test', '测试角色');

-- ----------------------------
-- Table structure for t_singer
-- ----------------------------
DROP TABLE IF EXISTS `t_singer`;
CREATE TABLE `t_singer`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '歌手id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` tinyint NULL DEFAULT NULL COMMENT '性别',
  `post` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '海报',
  `birth` datetime NULL DEFAULT NULL COMMENT '出生年月',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_singer
-- ----------------------------
INSERT INTO `t_singer` VALUES (1, '周杰伦', 1, 'http://p1.music.126.net/BbR3TuhPULMLDV0MjczI4g==/109951165793869641.jpg', '1985-01-27 00:00:00', '中国北京', '实力派最佳歌手之一');
INSERT INTO `t_singer` VALUES (2, '陈奕迅', 1, 'http://p2.music.126.net/w_vuv9hBWq2hlJxJcmJrjg==/109951166115915081.jpg', '1975-02-18 00:00:00', '中国上海', '中国香港流行乐男歌手、演员、作曲人，毕业于英国金斯顿大学。');
INSERT INTO `t_singer` VALUES (3, '薛之谦', 1, 'http://p1.music.126.net/BbR3TuhPULMLDV0MjczI4g==/109951165793869641.jpg', '1983-07-27 00:00:00', '中国杭州', '中国内地流行乐男歌手、影视演员、音乐制作人，毕业于格里昂酒店管理学院。 2005年，因参加选秀节目《我型我秀》而正式出道。2006年，发行首张同名专辑《薛之谦》，随后凭借歌曲《认真的雪》获得广泛关注。');
INSERT INTO `t_singer` VALUES (4, '邓紫棋', 0, 'http://p1.music.126.net/W42LIbHIkxcccJfQYWzSIA==/109951164561122718.jpg', '1991-08-18 00:00:00', '中国台湾', '中国香港流行乐女歌手、词曲作者、音乐制作人。 ');

-- ----------------------------
-- Table structure for t_song
-- ----------------------------
DROP TABLE IF EXISTS `t_song`;
CREATE TABLE `t_song`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '歌曲id',
  `singer_id` int NOT NULL COMMENT '作者id',
  `category_id` int NULL DEFAULT NULL COMMENT '歌曲分类',
  `song_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '歌曲名',
  `song_words` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌词',
  `audio_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌曲mp3/avi的url',
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌曲MV的url',
  `post` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '海报',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `singer_id`(`singer_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `t_song_ibfk_1` FOREIGN KEY (`singer_id`) REFERENCES `t_singer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_song_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_song
-- ----------------------------
INSERT INTO `t_song` VALUES (1, 1, 1, '稻香', '歌词显示11', NULL, NULL, 'http://p1.music.126.net/BbR3TuhPULMLDV0MjczI4g==/109951165793869641.jpg', '周杰伦的稻香');
INSERT INTO `t_song` VALUES (2, 2, 3, '富士山下', '歌词显示222', NULL, NULL, 'http://p2.music.126.net/w_vuv9hBWq2hlJxJcmJrjg==/109951166115915081.jpg', '陈奕迅的富士山下');
INSERT INTO `t_song` VALUES (3, 3, 2, '演员', '歌词显示33', NULL, NULL, 'http://p1.music.126.net/BbR3TuhPULMLDV0MjczI4g==/109951165793869641.jpg', '薛之谦的演员');
INSERT INTO `t_song` VALUES (4, 2, 3, '光年之外', '歌词显示444', NULL, NULL, 'http://p1.music.126.net/W42LIbHIkxcccJfQYWzSIA==/109951164561122718.jpg', '邓紫棋的光年之外');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '普通用户id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
