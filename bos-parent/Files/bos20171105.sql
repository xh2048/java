/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : bos

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-11-05 23:54:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_function`
-- ----------------------------
DROP TABLE IF EXISTS `auth_function`;
CREATE TABLE `auth_function` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `page` varchar(255) DEFAULT NULL,
  `generatemenu` varchar(255) DEFAULT NULL,
  `zindex` int(11) DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_Key_2` (`name`),
  KEY `FK33r6np87v1p6gge7t6rpcao5h` (`pid`),
  CONSTRAINT `FK33r6np87v1p6gge7t6rpcao5h` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `FK_Reference_1x` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_function
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_Key_2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------

-- ----------------------------
-- Table structure for `bc_decidedzone`
-- ----------------------------
DROP TABLE IF EXISTS `bc_decidedzone`;
CREATE TABLE `bc_decidedzone` (
  `id` varchar(32) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `staff_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh0xplk12o52a6eryw4hcqnfwt` (`staff_id`),
  CONSTRAINT `FK_decidedzone_staff` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `FKh0xplk12o52a6eryw4hcqnfwt` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_decidedzone
-- ----------------------------
INSERT INTO `bc_decidedzone` VALUES ('123', 'xiahui', '402882825f6c4fad015f6c50c8e30001');
INSERT INTO `bc_decidedzone` VALUES ('1234', '2123', '4028c4815f7aa8fa015f7aaa8d650000');
INSERT INTO `bc_decidedzone` VALUES ('12425', 'tangwei', '402882825f6c4fad015f6c5115c40002');
INSERT INTO `bc_decidedzone` VALUES ('1312', '4234', '402882825f6c4fad015f6c507b3b0000');
INSERT INTO `bc_decidedzone` VALUES ('132', '5235', '402882825f6adc42015f6add93770000');

-- ----------------------------
-- Table structure for `bc_region`
-- ----------------------------
DROP TABLE IF EXISTS `bc_region`;
CREATE TABLE `bc_region` (
  `id` varchar(32) NOT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `postcode` varchar(50) DEFAULT NULL,
  `shortcode` varchar(30) DEFAULT NULL,
  `citycode` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_region
-- ----------------------------
INSERT INTO `bc_region` VALUES ('QY001', '北京市', '北京市', '东城区', '110101', 'BJBJDC', 'beijing');
INSERT INTO `bc_region` VALUES ('QY002', '北京市', '北京市', '西城区', '110102', 'BJBJXC', 'beijing');
INSERT INTO `bc_region` VALUES ('QY003', '北京市', '北京市', '朝阳区', '110105', 'BJBJCY', 'beijing');
INSERT INTO `bc_region` VALUES ('QY004', '北京市', '北京市', '丰台区', '110106', 'BJBJFT', 'beijing');
INSERT INTO `bc_region` VALUES ('QY005', '北京市', '北京市', '石景山区', '110107', 'BJBJSJS', 'beijing');
INSERT INTO `bc_region` VALUES ('QY006', '北京市', '北京市', '海淀区', '110108', 'BJBJHD', 'beijing');
INSERT INTO `bc_region` VALUES ('QY007', '北京市', '北京市', '门头沟区', '110109', 'BJBJMTG', 'beijing');
INSERT INTO `bc_region` VALUES ('QY008', '北京市', '北京市', '房山区', '110111', 'BJBJFS', 'beijing');
INSERT INTO `bc_region` VALUES ('QY009', '北京市', '北京市', '通州区', '110112', 'BJBJTZ', 'beijing');
INSERT INTO `bc_region` VALUES ('QY010', '北京市', '北京市', '顺义区', '110113', 'BJBJSY', 'beijing');
INSERT INTO `bc_region` VALUES ('QY011', '北京市', '北京市', '昌平区', '110114', 'BJBJCP', 'beijing');
INSERT INTO `bc_region` VALUES ('QY012', '北京市', '北京市', '大兴区', '110115', 'BJBJDX', 'beijing');
INSERT INTO `bc_region` VALUES ('QY013', '北京市', '北京市', '怀柔区', '110116', 'BJBJHR', 'beijing');
INSERT INTO `bc_region` VALUES ('QY014', '北京市', '北京市', '平谷区', '110117', 'BJBJPG', 'beijing');
INSERT INTO `bc_region` VALUES ('QY015', '北京市', '北京市', '密云县', '110228', 'BJBJMY', 'beijing');
INSERT INTO `bc_region` VALUES ('QY016', '北京市', '北京市', '延庆县', '110229', 'BJBJYQ', 'beijing');
INSERT INTO `bc_region` VALUES ('QY017', '河北省', '石家庄市', '长安区', '130102', 'HBSJZZA', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY018', '河北省', '石家庄市', '桥东区', '130103', 'HBSJZQD', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY019', '河北省', '石家庄市', '桥西区', '130104', 'HBSJZQX', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY020', '河北省', '石家庄市', '新华区', '130105', 'HBSJZXH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY021', '河北省', '石家庄市', '井陉矿区', '130107', 'HBSJZJXK', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY022', '河北省', '石家庄市', '裕华区', '130108', 'HBSJZYH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY023', '河北省', '石家庄市', '井陉县', '130121', 'HBSJZJX', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY024', '河北省', '石家庄市', '正定县', '130123', 'HBSJZZD', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY025', '河北省', '石家庄市', '栾城县', '130124', 'HBSJZLC', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY026', '河北省', '石家庄市', '行唐县', '130125', 'HBSJZXT', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY027', '河北省', '石家庄市', '灵寿县', '130126', 'HBSJZLS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY028', '河北省', '石家庄市', '高邑县', '130127', 'HBSJZGY', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY029', '河北省', '石家庄市', '深泽县', '130128', 'HBSJZSZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY030', '河北省', '石家庄市', '赞皇县', '130129', 'HBSJZZH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY031', '河北省', '石家庄市', '无极县', '130130', 'HBSJZWJ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY032', '河北省', '石家庄市', '平山县', '130131', 'HBSJZPS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY033', '河北省', '石家庄市', '元氏县', '130132', 'HBSJZYS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY034', '河北省', '石家庄市', '赵县', '130133', 'HBSJZZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY035', '河北省', '石家庄市', '辛集市', '130181', 'HBSJZXJ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY036', '河北省', '石家庄市', '藁城市', '130182', 'HBSJZGC', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY037', '河北省', '石家庄市', '晋州市', '130183', 'HBSJZJZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY038', '河北省', '石家庄市', '新乐市', '130184', 'HBSJZXL', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY039', '河北省', '石家庄市', '鹿泉市', '130185', 'HBSJZLQ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('QY040', '天津市', '天津市', '和平区', '120101', 'TJTJHP', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY041', '天津市', '天津市', '河东区', '120102', 'TJTJHD', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY042', '天津市', '天津市', '河西区', '120103', 'TJTJHX', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY043', '天津市', '天津市', '南开区', '120104', 'TJTJNK', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY044', '天津市', '天津市', '河北区', '120105', 'TJTJHB', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY045', '天津市', '天津市', '红桥区', '120106', 'TJTJHQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY046', '天津市', '天津市', '滨海新区', '120116', 'TJTJBHX', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY047', '天津市', '天津市', '东丽区', '120110', 'TJTJDL', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY048', '天津市', '天津市', '西青区', '120111', 'TJTJXQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY049', '天津市', '天津市', '津南区', '120112', 'TJTJJN', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY050', '天津市', '天津市', '北辰区', '120113', 'TJTJBC', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY051', '天津市', '天津市', '武清区', '120114', 'TJTJWQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY052', '天津市', '天津市', '宝坻区', '120115', 'TJTJBC', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY053', '天津市', '天津市', '宁河县', '120221', 'TJTJNH', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY054', '天津市', '天津市', '静海县', '120223', 'TJTJJH', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY055', '天津市', '天津市', '蓟县', '120225', 'TJTJJ', 'tianjin');
INSERT INTO `bc_region` VALUES ('QY056', '山西省', '太原市', '小店区', '140105', 'SXTYXD', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY057', '山西省', '太原市', '迎泽区', '140106', 'SXTYYZ', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY058', '山西省', '太原市', '杏花岭区', '140107', 'SXTYXHL', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY059', '山西省', '太原市', '尖草坪区', '140108', 'SXTYJCP', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY060', '山西省', '太原市', '万柏林区', '140109', 'SXTYWBL', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY061', '山西省', '太原市', '晋源区', '140110', 'SXTYJY', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY062', '山西省', '太原市', '清徐县', '140121', 'SXTYQX', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY063', '山西省', '太原市', '阳曲县', '140122', 'SXTYYQ', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY064', '山西省', '太原市', '娄烦县', '140123', 'SXTYLF', 'taiyuan');
INSERT INTO `bc_region` VALUES ('QY065', '山西省', '太原市', '古交市', '140181', 'SXTYGJ', 'taiyuan');

-- ----------------------------
-- Table structure for `bc_staff`
-- ----------------------------
DROP TABLE IF EXISTS `bc_staff`;
CREATE TABLE `bc_staff` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `haspda` char(1) DEFAULT NULL,
  `deltag` char(1) DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  `standard` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_staff
-- ----------------------------
INSERT INTO `bc_staff` VALUES ('402882825f5d27d7015f5d290a4c0000', 'xiahui', '13541729353', '1', null, 'zyyf', '123');
INSERT INTO `bc_staff` VALUES ('402882825f6adc42015f6add93770000', '唐伟', '13563455345', '1', '0', 'sffa', '42342');
INSERT INTO `bc_staff` VALUES ('402882825f6c4fad015f6c507b3b0000', '张萍', '13548844114', '1', '0', 'zyyf', '14124');
INSERT INTO `bc_staff` VALUES ('402882825f6c4fad015f6c50c8e30001', '温江', '13684197494', '1', '0', 'zyyf', '23252');
INSERT INTO `bc_staff` VALUES ('402882825f6c4fad015f6c5115c40002', '罗伟', '13861644164', '1', '0', 'zyyf', '164491');
INSERT INTO `bc_staff` VALUES ('4028c4815f7aa8fa015f7aaa8d650000', '张三', '13684197479', '1', '0', 'zyyf', '4234');

-- ----------------------------
-- Table structure for `bc_subarea`
-- ----------------------------
DROP TABLE IF EXISTS `bc_subarea`;
CREATE TABLE `bc_subarea` (
  `id` varchar(32) NOT NULL,
  `decidedzone_id` varchar(32) DEFAULT NULL,
  `region_id` varchar(32) DEFAULT NULL,
  `addresskey` varchar(100) DEFAULT NULL,
  `startnum` varchar(30) DEFAULT NULL,
  `endnum` varchar(30) DEFAULT NULL,
  `single` char(1) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlndbc8oldgbg3k1x63n3n6t7n` (`decidedzone_id`),
  KEY `FKcjwxm19mx5njn3xyqgqp431mb` (`region_id`),
  CONSTRAINT `FK_area_decidedzone` FOREIGN KEY (`decidedzone_id`) REFERENCES `bc_decidedzone` (`id`),
  CONSTRAINT `FK_area_region` FOREIGN KEY (`region_id`) REFERENCES `bc_region` (`id`),
  CONSTRAINT `FKcjwxm19mx5njn3xyqgqp431mb` FOREIGN KEY (`region_id`) REFERENCES `bc_region` (`id`),
  CONSTRAINT `FKlndbc8oldgbg3k1x63n3n6t7n` FOREIGN KEY (`decidedzone_id`) REFERENCES `bc_decidedzone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_subarea
-- ----------------------------
INSERT INTO `bc_subarea` VALUES ('402882825f6adc42015f6aded63d0001', '123', 'QY003', '朝阳', '12', '16565', '1', '发的萨芬');
INSERT INTO `bc_subarea` VALUES ('402882825f6b3f4b015f6b40ac140000', '123', 'QY007', '门头沟', '121', '324423', '2', '432564');
INSERT INTO `bc_subarea` VALUES ('402882825f6b4226015f6b44880c0000', '12425', 'QY009', '通州', '12', '5235', '2', '2535');
INSERT INTO `bc_subarea` VALUES ('402882825f6c6650015f6c6740b20000', '1312', 'QY024', '正定', '12', '12344', '2', '正定');
INSERT INTO `bc_subarea` VALUES ('4028c4815f7a99a4015f7a9ad95c0000', '132', 'QY005', '石景山', '123', '434', '1', '4234');
INSERT INTO `bc_subarea` VALUES ('4028c4815f7aa8fa015f7aaad8000001', '1234', 'QY065', '古交', '4', '235', '0', '234234');

-- ----------------------------
-- Table structure for `qp_noticebill`
-- ----------------------------
DROP TABLE IF EXISTS `qp_noticebill`;
CREATE TABLE `qp_noticebill` (
  `id` varchar(32) NOT NULL,
  `staff_id` varchar(32) DEFAULT NULL,
  `customer_id` varchar(32) DEFAULT NULL,
  `customer_name` varchar(20) DEFAULT NULL,
  `delegater` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `pickaddress` varchar(200) DEFAULT NULL,
  `arrivecity` varchar(20) DEFAULT NULL,
  `product` varchar(20) DEFAULT NULL,
  `pickdate` date DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `volume` varchar(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `ordertype` varchar(20) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl5j3pm969oy1qdc1318jrmbgt` (`user_id`),
  KEY `FKhmbqr6qlg0uets978w5xshler` (`staff_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `FKhmbqr6qlg0uets978w5xshler` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `FKl5j3pm969oy1qdc1318jrmbgt` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `test` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qp_noticebill
-- ----------------------------
INSERT INTO `qp_noticebill` VALUES ('4028c4815f81956f015f819f10f40000', '402882825f6c4fad015f6c5115c40002', '3', '王五', '王五', '13533333333', '天津市河北区中山路30号', '', '', null, null, null, '', '', '自动分单', '1');
INSERT INTO `qp_noticebill` VALUES ('4028c4815f81d71d015f81d95c3e0000', '4028c4815f7aa8fa015f7aaa8d650000', '8', '小李', '小李', '13788888888', '北京市昌平区建材城西路100号', '', '1', '2017-11-08', '1', '1', '1', '11', '自动分单', '1');

-- ----------------------------
-- Table structure for `qp_workbill`
-- ----------------------------
DROP TABLE IF EXISTS `qp_workbill`;
CREATE TABLE `qp_workbill` (
  `id` varchar(32) NOT NULL,
  `noticebill_id` varchar(32) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `pickstate` varchar(20) DEFAULT NULL,
  `buildtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `attachbilltimes` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `staff_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKggojlcovnpimuukxcueb18apt` (`noticebill_id`),
  KEY `FK55ckcnjyvwinnnniu5jpelg7y` (`staff_id`),
  CONSTRAINT `FK55ckcnjyvwinnnniu5jpelg7y` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `FK_workbill_noticebill_fk` FOREIGN KEY (`noticebill_id`) REFERENCES `qp_noticebill` (`id`),
  CONSTRAINT `FKggojlcovnpimuukxcueb18apt` FOREIGN KEY (`noticebill_id`) REFERENCES `qp_noticebill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qp_workbill
-- ----------------------------
INSERT INTO `qp_workbill` VALUES ('4028c4815f81956f015f819f113a0001', '4028c4815f81956f015f819f10f40000', '新单', '未取件', '2017-11-03 19:23:26', '0', '', '402882825f6c4fad015f6c5115c40002');
INSERT INTO `qp_workbill` VALUES ('4028c4815f81d71d015f81d95c690001', '4028c4815f81d71d015f81d95c3e0000', '新单', '未取件', '2017-11-03 20:27:07', '0', '11', '4028c4815f7aa8fa015f7aaa8d650000');

-- ----------------------------
-- Table structure for `qp_workordermanage`
-- ----------------------------
DROP TABLE IF EXISTS `qp_workordermanage`;
CREATE TABLE `qp_workordermanage` (
  `id` varchar(32) NOT NULL,
  `arrivecity` varchar(20) DEFAULT NULL,
  `product` varchar(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `floadreqr` varchar(255) DEFAULT NULL,
  `prodtimelimit` varchar(40) DEFAULT NULL,
  `prodtype` varchar(40) DEFAULT NULL,
  `sendername` varchar(20) DEFAULT NULL,
  `senderphone` varchar(20) DEFAULT NULL,
  `senderaddr` varchar(200) DEFAULT NULL,
  `receivername` varchar(20) DEFAULT NULL,
  `receiverphone` varchar(20) DEFAULT NULL,
  `receiveraddr` varchar(200) DEFAULT NULL,
  `feeitemnum` int(11) DEFAULT NULL,
  `actlweit` double DEFAULT NULL,
  `vol` varchar(20) DEFAULT NULL,
  `managerCheck` varchar(1) DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qp_workordermanage
-- ----------------------------
INSERT INTO `qp_workordermanage` VALUES ('1', '22', '3', '1', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `qp_workordermanage` VALUES ('123', '54324', '5324', '52345', '53245', '5234', null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `role_function`
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `role_id` varchar(32) NOT NULL,
  `function_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`function_id`),
  KEY `FK5f8riddotqjpm9vly0b8c5nmf` (`function_id`),
  CONSTRAINT `FK10qo908yd9evkyb40vf88og85` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `FK5f8riddotqjpm9vly0b8c5nmf` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `FK_Reference_2x` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `FK_Reference_3x` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_function
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'xiahui', '7040ae73bf0788edb16f0c1c406fa61f', null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('2', 'admin', '7040ae73bf0788edb16f0c1c406fa61f', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKqqlqhas35obkljn18mrh6mmms` (`role_id`),
  CONSTRAINT `FK_Reference_4x` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_Reference_5x` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `FKeqon9sx5vssprq67dxm3s7ump` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKqqlqhas35obkljn18mrh6mmms` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
