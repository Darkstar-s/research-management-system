/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : db_system

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 07/05/2023 10:32:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `admin_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '姓名',
  `admin_sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `admin_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '电话',
  `admin_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '密码',
  `role` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '0用户 1科研管理员 2记账员 3超级管理员',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2019115 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学校管理员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (2013123, '落秋', '1', '19874123563', '123456', '1');
INSERT INTO `tb_admin` VALUES (2019114, '南风', '0', '19874568956', '145236', '1');

-- ----------------------------
-- Table structure for tb_bfd
-- ----------------------------
DROP TABLE IF EXISTS `tb_bfd`;
CREATE TABLE `tb_bfd`  (
  `pj_number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目编号',
  `bfd_picture` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '拨付单文件',
  `pj_balance` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '当前项目余额',
  `pj_bk` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '本次拨款金额',
  `admin_status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '管理员审核状态（0待审核 1审核通过 2打回修改）',
  `bk_status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '记账员审核状态（0待审核 1审核通过 2打回修改）',
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_bfd
-- ----------------------------
INSERT INTO `tb_bfd` VALUES ('HX20233', 'http://localhost:8080/2023/04/18/Snipaste_2023-03-17_00-08-05.png', '6666', '555', '1', '1', 1);
INSERT INTO `tb_bfd` VALUES ('HX20239', 'http://localhost:8080/2023/04/20/Snipaste_2023-03-17_00-08-05.png', '4520', '8541', '1', '1', 2);
INSERT INTO `tb_bfd` VALUES ('HX202327', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '42632', '25360', '1', '1', 4);
INSERT INTO `tb_bfd` VALUES ('HX202328', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '61523', '7760', '1', '1', 5);
INSERT INTO `tb_bfd` VALUES ('HX202328', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '37011', '24512', '1', '1', 6);
INSERT INTO `tb_bfd` VALUES ('HX202328', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '0', '3701', '1', '1', 7);
INSERT INTO `tb_bfd` VALUES ('HX202323', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '37011', '37010', '1', '1', 8);
INSERT INTO `tb_bfd` VALUES ('HX202323', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-06.png', '17011', '20000', '1', '1', 9);
INSERT INTO `tb_bfd` VALUES ('HX202323', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-06.png', '0', '17011', '1', '1', 10);
INSERT INTO `tb_bfd` VALUES ('HX202324', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-06.png', '45000', '25000', '1', '1', 11);
INSERT INTO `tb_bfd` VALUES ('HX202324', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-06.png', '0', '20000', '1', '1', 12);

-- ----------------------------
-- Table structure for tb_bk
-- ----------------------------
DROP TABLE IF EXISTS `tb_bk`;
CREATE TABLE `tb_bk`  (
  `bk_id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bk_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '姓名',
  `bk_sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `bk_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '电话',
  `bk_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '密码',
  `role` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '2' COMMENT '0用户 1科研管理员 2记账员 3超级管理员',
  PRIMARY KEY (`bk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 217413 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '记账员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_bk
-- ----------------------------
INSERT INTO `tb_bk` VALUES (123123, '郑蕊', '1', '17698463251', '123', '2');
INSERT INTO `tb_bk` VALUES (217412, '余滕', '0', '17845965820', '1452', '2');

-- ----------------------------
-- Table structure for tb_bz
-- ----------------------------
DROP TABLE IF EXISTS `tb_bz`;
CREATE TABLE `tb_bz`  (
  `pj_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目编号',
  `bz_time` datetime NULL DEFAULT NULL COMMENT '报账日期',
  `pj_yw` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '项目业务费',
  `pj_sb` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '仪器设备费',
  `pj_jd` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '业务接待费',
  `pj_car` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '车辆使用费',
  `pj_wx` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '外协费',
  `pj_people` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '人员费',
  `pj_manage` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '管理费',
  `pj_money` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '总金额',
  `bz_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '记账员审核状态 （0待审核 1审核通过 2打回修改）',
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_bz
-- ----------------------------
INSERT INTO `tb_bz` VALUES ('HX20233', '2023-04-20 17:01:00', '555', '444', '333', '555', '444', '5000', '1200', '8531', '1', 1);
INSERT INTO `tb_bz` VALUES ('HX202327', '2023-05-05 16:11:31', '423', '421', '423', '654', '485', '231', '500', '3137', '1', 3);
INSERT INTO `tb_bz` VALUES ('HX202327', '2023-05-05 16:12:06', '231', '412', '366', '520', '142', '4120', '212', '6003', '1', 4);
INSERT INTO `tb_bz` VALUES ('HX202328', '2023-05-12 00:00:00', '465', '4568', '618', '468', '468', '2540', '456', '9583', '1', 5);
INSERT INTO `tb_bz` VALUES ('HX202328', '2023-07-20 16:34:23', '4862', '2450', '5423', '941', '2000', '8000', '600', '24276', '1', 6);
INSERT INTO `tb_bz` VALUES ('HX202328', '2022-09-30 00:00:00', '5000', '7000', '4000', '780', '5844', '12000', '800', '35424', '1', 7);
INSERT INTO `tb_bz` VALUES ('HX202323', '2023-05-05 16:47:54', '20000', '5000', '2000', '30000', '300', '2500', '2470', '5000', '1', 8);
INSERT INTO `tb_bz` VALUES ('HX202323', '2023-06-15 16:49:26', '25000', '5000', '2000', '30000', '3000', '2000', '2000', '8000', '0', 9);

-- ----------------------------
-- Table structure for tb_jfdz
-- ----------------------------
DROP TABLE IF EXISTS `tb_jfdz`;
CREATE TABLE `tb_jfdz`  (
  `xm_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目编号',
  `dz_picture` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '经费到账图片',
  `dz_time` datetime NULL DEFAULT NULL COMMENT '到账时间',
  `dz_money` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '到账金额',
  `dz_status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '到帐单审核',
  `dz_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  PRIMARY KEY (`dz_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_jfdz
-- ----------------------------
INSERT INTO `tb_jfdz` VALUES ('HX20233', 'http://localhost:8080/2023/04/17/Snipaste_2023-03-17_00-08-05.png', '2023-04-13 21:28:06', '555.00', '1', 1);
INSERT INTO `tb_jfdz` VALUES ('HX20233', 'http://localhost:8080/2023/04/17/Snipaste_2023-03-17_00-08-05.png', '2023-04-20 16:12:00', '4500.00', '1', 2);
INSERT INTO `tb_jfdz` VALUES ('HX20234', 'http://localhost:8080/2023/04/17/Snipaste_2023-03-17_00-08-05.png', '2023-04-13 04:00:00', '555', '1', 3);
INSERT INTO `tb_jfdz` VALUES ('HX202327', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '2023-05-05 16:09:59', '5555', '1', 5);
INSERT INTO `tb_jfdz` VALUES ('HX202327', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '2023-04-20 00:00:00', '4020', '1', 6);
INSERT INTO `tb_jfdz` VALUES ('HX202328', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '2023-05-20 00:00:00', '4562', '1', 7);
INSERT INTO `tb_jfdz` VALUES ('HX202328', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '2022-06-08 00:00:00', '15230', '1', 8);
INSERT INTO `tb_jfdz` VALUES ('HX202328', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '2023-07-07 00:00:00', '25412', '1', 9);
INSERT INTO `tb_jfdz` VALUES ('HX202323', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '2023-05-27 16:50:38', '25000', '1', 10);
INSERT INTO `tb_jfdz` VALUES ('HX202323', 'http://localhost:8080/2023/05/05/Snipaste_2023-03-17_00-08-05.png', '2023-07-12 16:50:53', '20000', '1', 11);

-- ----------------------------
-- Table structure for tb_pj
-- ----------------------------
DROP TABLE IF EXISTS `tb_pj`;
CREATE TABLE `tb_pj`  (
  `pj_id` int NOT NULL AUTO_INCREMENT COMMENT '项目申报ID',
  `pj_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '项目编号',
  `pj_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '项目名称',
  `pj_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '项目类型（0技术开发（委托） 1技术开发（合作） 2技术服务 3技术咨询 4技术转让（专利权） 5技术转让（专利实施许可） 6技术转让（专利申请权） 7技术转让（技术秘密）',
  `pj_money` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '项目合同金额',
  `pj_dzmoney` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '实际到账金额',
  `pj_user` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '负责人',
  `pj_userid` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '负责人ID',
  `pj_users` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '参与人',
  `pj_xmdw` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '项目单位',
  `pj_hzdw` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '合作单位',
  `pj_shstatus` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '申报审核（0待审核 1审核通过 2打回修改）',
  `pj_jtstatus` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '结题审核（0待申请 1申请中 2申请通过 3打回修改）',
  `pj_bcstatus` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '补充合同审核（0待审核 1审核通过 2打回修改）',
  `pj_xmht` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '合同',
  `pj_bcht` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '补充合同',
  `pj_stime` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `pj_etime` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `pj_jtime` datetime NULL DEFAULT NULL COMMENT '结题时间',
  `pj_remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `pj_jtzm` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '结题证明',
  `pj_jtbg` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '结题报告',
  `pj_cgcl` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '成果材料',
  PRIMARY KEY (`pj_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_pj
-- ----------------------------
INSERT INTO `tb_pj` VALUES (3, 'HX20233', '基于spring boot的横向科研项目管理系统的设计实现三', '3', '24563.00', '2493', '测试', '2019125', '张三，里斯，王五，赵六', '湖北文理学院', '湖北文理学院计算机功工程学院', '1', '2', '1', 'http://localhost:8080/2023/04/17/电子签名.pdf', 'http://localhost:8080/2023/04/17/电子签名.pdf', '2023-04-19 19:26:17', '2023-04-19 19:26:20', '2023-04-19 20:37:15', NULL, 'http://localhost:8080/2023/04/18/电子签名.pdf', NULL, NULL);
INSERT INTO `tb_pj` VALUES (4, 'HX20234', '基于spring boot的横向科研项目管理系统的设计实现四', '7', '52102', '62012', '测试', '2019125', '测试，湖北文理学院测试', '湖北文理学院', '湖北文理学院计算机', '1', '1', '1', 'http://localhost:8080/2023/04/17/华为MUX VLAN的配置.pdf', 'http://localhost:8080/2023/04/17/电子签名.pdf', '2023-04-19 20:38:17', '2023-04-19 20:38:22', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (9, 'HX20239', '基于spring boot的横向科研项目管理系统的设计实现九', '5', '', '', '测试', '2019125', '', '', '', '1', '0', '0', 'http://localhost:8080/2023/04/17/华为MUX VLAN的配置.pdf', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (10, '', '基于spring boot的横向科研项目管理系统的设计实现十', '3', '', '', '测试', '2019125', '', '', '', '2', '0', '0', 'http://localhost:8080/2023/04/17/电子签名.pdf', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (14, '', '基于spring+boot的横向科研项目管理系统的设计实现十4', '2', '', '', '测试', '2019125', '', '', '', '0', '0', '0', 'http://localhost:8080/2023/04/17/电子签名.pdf', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (15, '', 'filePath', '7', '', '', '测试', '2019125', '', '', '', '0', '0', '0', 'http://localhost:8080/2023/04/17/电子签名.pdf', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (17, 'HX202317', 'pjXmht', '1', '55555', '48925', '测试', '2019125', '测试1', '湖北文理学院', '湖北文理学院计算机学院', '1', '2', '1', 'http://localhost:8080/2023/04/17/电子签名.pdf', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf', '2023-04-20 18:08:57', '2023-04-20 18:09:02', '2023-04-20 18:08:52', '无', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf');
INSERT INTO `tb_pj` VALUES (21, '', '基于element ui+vue的前台页面设置', '3', '', '', '李蕾', '1', '', '', '', '0', '0', '0', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (22, '', '测试时', '4', '', '', '测试', '2019125', '', '', '', '0', '0', '0', 'http://localhost:8080/2023/05/05/2022年下半年英语四级笔试准考证(42112720010923083X).pdf', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (23, 'HX202323', '基于Docker的云计算平台开发', '1', '60000', '56895', '武代曼', '2020126', '乔柱琥\r\n平歌甜\r\n童维婧\r\n程焕露\r\n史珍云', '湖北文理学院', '湖北文理学院土木工程', '1', '2', '1', 'http://localhost:8080/2023/05/05/Node.js编程技术实验04内容.pdf', 'http://localhost:8080/2023/05/05/2022年上半年英语四级笔试准考证(周超).pdf', '2023-05-05 16:43:25', '2023-08-07 16:43:27', '2023-08-04 16:43:40', '无', 'http://localhost:8080/2023/05/05/2019117124 周超 申请表.pdf', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf');
INSERT INTO `tb_pj` VALUES (24, 'HX202324', '基于Unity的虚拟现实游戏开发', '3', '50000', '49820', '武代曼', '2020126', '乔柱琥\r\n平歌甜\r\n童维婧\r\n程焕露\r\n史珍云', '湖北文理学院', '湖北文理学院土木工程', '1', '2', '1', 'http://localhost:8080/2023/05/05/Node.js编程技术实验05 Express视图.pdf', 'http://localhost:8080/2023/05/05/2022年上半年英语四级笔试准考证(周超).pdf', '2023-05-05 16:43:20', '2023-07-01 16:43:32', '2023-07-01 16:43:36', '无', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf', 'http://localhost:8080/2023/04/20/JERP-2022-4-12_4.pdf');
INSERT INTO `tb_pj` VALUES (25, '', '基于以太坊的去中心化应用开发', '8', '', '', '武代曼', '2020126', '', '', '', '0', '0', '0', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (26, '', '基于深度强化学习的游戏AI算法优化', '4', '', '', '叶庭', '2001021', '', '', '', '0', '0', '0', 'http://localhost:8080/2023/05/05/国家普通话水平测试准考证.pdf', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_pj` VALUES (27, 'HX202327', '基于TensorFlow的语音识别系统开发', '7', '55003', '55003', '叶庭', '2001021', '邓航骏 蒙蒙寒 马冰联 孙玮容 祖晗菲', '湖北文理学院', '湖北文理学院土木工程', '1', '2', '1', 'http://localhost:8080/2023/05/05/2019117124 周超 登记卡.pdf', 'http://localhost:8080/2023/05/05/2022年上半年英语四级笔试准考证(周超).pdf', '2023-05-05 16:02:43', '2023-09-23 00:00:00', '2023-09-30 16:07:26', NULL, 'http://localhost:8080/2023/05/05/2019117124 周超 申请表.pdf', 'http://localhost:8080/2023/05/05/国家普通话水平测试准考证.pdf', 'http://localhost:8080/2023/05/05/2019117124 周超 登记卡.pdf');
INSERT INTO `tb_pj` VALUES (28, 'HX202328', '基于LoRaWAN的智能农业监控系统', '4', '64512', '64512', '贺悍', '4242424', '常溪渤\r\n赖倩耘\r\n罗璇妤\r\n裘瑾艳', '湖北文理学院', '湖北文理学院物电学院', '1', '2', '1', 'http://localhost:8080/2023/05/05/2019117124 周超 登记卡.pdf', 'http://localhost:8080/2023/05/05/2022年上半年英语四级笔试准考证(周超).pdf', '2023-05-05 16:25:27', '2023-08-01 16:25:34', '2023-08-08 16:25:49', '无', 'http://localhost:8080/2023/05/05/国家普通话水平测试准考证.pdf', 'http://localhost:8080/2023/05/05/2019117124 周超 申请表.pdf', 'http://localhost:8080/2023/05/05/2019117124 周超 登记卡.pdf');

-- ----------------------------
-- Table structure for tb_sysadmin
-- ----------------------------
DROP TABLE IF EXISTS `tb_sysadmin`;
CREATE TABLE `tb_sysadmin`  (
  `sysadmin_id` int NOT NULL COMMENT 'ID',
  `sysadmin_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '密码',
  `role` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '3' COMMENT '0用户 1科研管理员 2记账员 3超级管理员',
  PRIMARY KEY (`sysadmin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '超级管理员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_sysadmin
-- ----------------------------
INSERT INTO `tb_sysadmin` VALUES (1001, '123', '3');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '姓名',
  `user_sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `user_zc` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '职称（0助教 1讲师 2副教授 3教授）',
  `user_xy` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '8' COMMENT '所属学院（0建筑学院 1经济管理学院 2土木工程学院 3马克思主义学院 4政法学院 5教育学院 6体育学院 7文学与传媒学院 8计算机工程学院 9物理与电子工程学院 10美术学院 11音乐与舞蹈学院 12外国语学院）',
  `user_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '电话',
  `user_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '密码',
  `role` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '0用户 1学院管理员 2学校管理员 3记账员 4超级管理员',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7577528 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1249665, '潘茗', '0', '0', '11', '18860668266', 'dssfdsdf', '0');
INSERT INTO `tb_user` VALUES (1546161, '余奇', '1', '3', '12', '15668424742', '32ewr343', '0');
INSERT INTO `tb_user` VALUES (1654896, '宋予娉', '1', '1', '4', '19785423679', '12345', '0');
INSERT INTO `tb_user` VALUES (2001021, '叶庭', '1', '3', '7', '13248746514', 'bfbfdb', '0');
INSERT INTO `tb_user` VALUES (2012117, '唐绮怀', '1', '1', '3', '18671794917', '533fdg', '0');
INSERT INTO `tb_user` VALUES (2018124, '邬茹竹', '1', '3', '4', '19875645236', '123123', '0');
INSERT INTO `tb_user` VALUES (2019125, '周超', '0', '0', '8', '19870039767', '111222', '0');
INSERT INTO `tb_user` VALUES (2019147, '钱闯澄', '0', '2', '2', '19875412563', '16616', '0');
INSERT INTO `tb_user` VALUES (2020126, '武代曼', '0', '0', '1', '17784903436', '456789', '0');
INSERT INTO `tb_user` VALUES (2020179, '江苏荷', '1', '2', '1', '15224075355', '159789', '0');
INSERT INTO `tb_user` VALUES (2021489, '石琳怡', '0', '0', '5', '13289585197', '2482782', '0');
INSERT INTO `tb_user` VALUES (2023212, '刘熙阳', '1', '2', '8', '15587177646', 'bfdbfd', '0');
INSERT INTO `tb_user` VALUES (2101255, '马蕊', '0', '2', '7', '18639716465', '123143rwer', '0');
INSERT INTO `tb_user` VALUES (2614997, '文蔓', '0', '1', '9', '17556994858', 'bfdfbdg', '0');
INSERT INTO `tb_user` VALUES (4242424, '贺悍', '1', '1', '10', '16636463200', 'sfdsdfsdg', '0');
INSERT INTO `tb_user` VALUES (7577527, '丁促', '1', '2', '6', '17712894962', '8\\57\\7\\5', '0');

SET FOREIGN_KEY_CHECKS = 1;
