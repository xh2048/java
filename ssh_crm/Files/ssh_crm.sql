/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : ssh_crm

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-10-17 16:48:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `base_dict`
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_dict
-- ----------------------------
INSERT INTO `base_dict` VALUES ('1', '001', '客户行业', '教育培训 ', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('10', '003', '公司性质', '民企', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('12', '004', '年营业额', '1-10万', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('13', '004', '年营业额', '10-20万', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('14', '004', '年营业额', '20-50万', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('15', '004', '年营业额', '50-100万', null, '4', '1', null);
INSERT INTO `base_dict` VALUES ('16', '004', '年营业额', '100-500万', null, '5', '1', null);
INSERT INTO `base_dict` VALUES ('17', '004', '年营业额', '500-1000万', null, '6', '1', null);
INSERT INTO `base_dict` VALUES ('18', '005', '客户状态', '基础客户', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('19', '005', '客户状态', '潜在客户', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('2', '001', '客户行业', '电子商务', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('20', '005', '客户状态', '成功客户', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('21', '005', '客户状态', '无效客户', null, '4', '1', null);
INSERT INTO `base_dict` VALUES ('22', '006', '客户级别', '普通客户', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('23', '006', '客户级别', 'VIP客户', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('24', '007', '商机状态', '意向客户', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('25', '007', '商机状态', '初步沟通', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('26', '007', '商机状态', '深度沟通', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('27', '007', '商机状态', '签订合同', null, '4', '1', null);
INSERT INTO `base_dict` VALUES ('3', '001', '客户行业', '对外贸易', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('30', '008', '商机类型', '新业务', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('31', '008', '商机类型', '现有业务', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('32', '009', '商机来源', '电话营销', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('33', '009', '商机来源', '网络营销', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('34', '009', '商机来源', '推广活动', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('4', '001', '客户行业', '酒店旅游', null, '4', '1', null);
INSERT INTO `base_dict` VALUES ('5', '001', '客户行业', '房地产', null, '5', '1', null);
INSERT INTO `base_dict` VALUES ('6', '002', '客户信息来源', '电话营销', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('7', '002', '客户信息来源', '网络营销', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('8', '003', '公司性质', '合资', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('9', '003', '公司性质', '国企', null, '2', '1', null);

-- ----------------------------
-- Table structure for `cst_customer`
-- ----------------------------
DROP TABLE IF EXISTS `cst_customer`;
CREATE TABLE `cst_customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_linkman` varchar(255) DEFAULT NULL,
  `cust_phone` varchar(255) DEFAULT NULL,
  `cust_mobile` varchar(255) DEFAULT NULL,
  `cust_source` varchar(255) DEFAULT NULL,
  `cust_industry` varchar(255) DEFAULT NULL,
  `cust_level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  KEY `FKeh5g36duab8g1h051pdjfwcgd` (`cust_source`),
  KEY `FK2xhr3arwp3tkuae1da4lqv352` (`cust_industry`),
  KEY `FKrty52nvbjg1echf0se39eng49` (`cust_level`),
  CONSTRAINT `FK2xhr3arwp3tkuae1da4lqv352` FOREIGN KEY (`cust_industry`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `FKeh5g36duab8g1h051pdjfwcgd` FOREIGN KEY (`cust_source`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `FKrty52nvbjg1echf0se39eng49` FOREIGN KEY (`cust_level`) REFERENCES `base_dict` (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_customer
-- ----------------------------
INSERT INTO `cst_customer` VALUES ('1', 'xiahui', null, '164546161', '64616416', '33', '2', '23');
INSERT INTO `cst_customer` VALUES ('2', '唐伟', null, '1325525', '52346236', '32', '4', '22');
INSERT INTO `cst_customer` VALUES ('3', 'zhangping', null, '216161616', '646181616', '33', '2', '23');
INSERT INTO `cst_customer` VALUES ('4', '温江', null, '34252', '346257275', '33', '3', '22');
INSERT INTO `cst_customer` VALUES ('5', '羊羊', null, '5263246', '8484256164', '32', '2', '22');

-- ----------------------------
-- Table structure for `cst_linkman`
-- ----------------------------
DROP TABLE IF EXISTS `cst_linkman`;
CREATE TABLE `cst_linkman` (
  `lkm_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lkm_gender` char(1) DEFAULT NULL,
  `lkm_name` varchar(255) DEFAULT NULL,
  `lkm_phone` varchar(255) DEFAULT NULL,
  `lkm_email` varchar(255) DEFAULT NULL,
  `lkm_qq` varchar(255) DEFAULT NULL,
  `lkm_mobile` varchar(255) DEFAULT NULL,
  `lkm_memo` varchar(255) DEFAULT NULL,
  `lkm_position` varchar(255) DEFAULT NULL,
  `lkm_cust_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`lkm_id`),
  KEY `FKh9yp1nql5227xxcopuxqx2e7q` (`lkm_cust_id`),
  CONSTRAINT `FKh9yp1nql5227xxcopuxqx2e7q` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_linkman
-- ----------------------------
INSERT INTO `cst_linkman` VALUES ('1', '1', '张三', '51243534', null, null, '632346', null, null, '1');
INSERT INTO `cst_linkman` VALUES ('2', '1', '李四', '4632364', null, null, '23734', null, null, '2');
INSERT INTO `cst_linkman` VALUES ('3', '1', '王小二', '56246', null, null, '6234623723', null, null, '3');
INSERT INTO `cst_linkman` VALUES ('4', '2', '大王', '233512', null, null, '613462346', null, null, '4');
INSERT INTO `cst_linkman` VALUES ('5', '1', '飞泰', '26347', null, null, '23732734', null, null, '5');

-- ----------------------------
-- Table structure for `sale_visit`
-- ----------------------------
DROP TABLE IF EXISTS `sale_visit`;
CREATE TABLE `sale_visit` (
  `visit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `visit_interviewee` varchar(255) DEFAULT NULL,
  `visit_addr` varchar(255) DEFAULT NULL,
  `visit_detail` varchar(255) DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  `visit_nexttime` datetime DEFAULT NULL,
  `visit_cust_id` bigint(20) DEFAULT NULL,
  `visit_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`visit_id`),
  KEY `FKgr4aivocixwcvkwxcmc0b4css` (`visit_cust_id`),
  KEY `FKc92iepd26mixxfiris92hccjx` (`visit_user_id`),
  CONSTRAINT `FKc92iepd26mixxfiris92hccjx` FOREIGN KEY (`visit_user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FKgr4aivocixwcvkwxcmc0b4css` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_visit
-- ----------------------------
INSERT INTO `sale_visit` VALUES ('1', '根', '水果蛋糕 ', '公司的风格', '2017-10-03 00:00:00', '2017-10-26 00:00:00', '1', '3');
INSERT INTO `sale_visit` VALUES ('2', '根深蒂固', '三个地方', '归属地', '2017-10-12 00:00:00', '2017-10-28 00:00:00', '2', '3');
INSERT INTO `sale_visit` VALUES ('3', '根深蒂固', '公司的风格', '第几个', '2017-10-26 00:00:00', '2017-10-25 00:00:00', '3', '3');
INSERT INTO `sale_visit` VALUES ('4', '好的发挥', '电话费', '好的发挥', '2017-10-12 00:00:00', '2017-10-27 00:00:00', '4', '3');
INSERT INTO `sale_visit` VALUES ('5', '好的发挥', '好的发挥', '的花非花', '2017-10-20 00:00:00', '2017-10-28 00:00:00', '5', '3');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('2', 'hongmei', '红梅', '5b2ca80528c4cf3bd0e7e7c0b0f1471e', null);
INSERT INTO `sys_user` VALUES ('3', 'xiahui', '夏辉', '7040ae73bf0788edb16f0c1c406fa61f', null);
INSERT INTO `sys_user` VALUES ('5', 'tangwei', '唐伟', '6302e4aa693fcf99d012be5578001f0b', null);
