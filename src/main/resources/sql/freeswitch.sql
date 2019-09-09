/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : freeswitch

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-09-09 16:51:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for call_record
-- ----------------------------
DROP TABLE IF EXISTS `call_record`;
CREATE TABLE `call_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `call_uuid` varchar(36) NOT NULL COMMENT '关联ID，同主叫方UUID',
  `caller_id_name` varchar(56) DEFAULT '' COMMENT '主叫方昵称',
  `caller_id_number` varchar(56) DEFAULT NULL COMMENT '主叫号码',
  `destination_number` varchar(56) DEFAULT NULL COMMENT '被叫号码',
  `start_stamp` bigint(20) DEFAULT NULL COMMENT '呼叫发起的日期/时间',
  `answer_stamp` bigint(20) DEFAULT NULL COMMENT '实际应答呼叫远端的日期/时间 如果未接听电话，则为空字符串',
  `end_stamp` bigint(20) DEFAULT NULL COMMENT '呼叫终止的日期/时间',
  `uduration` bigint(20) DEFAULT NULL COMMENT '总呼叫持续时间（以微秒为单位）',
  `billsec` int(11) DEFAULT NULL COMMENT '可计费的通话时长（秒）可计费时间不包括在远端接听电话之前在“早期媒体”中花费的通话时间',
  `hangup_cause` varchar(255) DEFAULT NULL COMMENT '挂断原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of call_record
-- ----------------------------
INSERT INTO `call_record` VALUES ('1', 'c226b766-d2c7-11e9-9a91-e98a91163029', '1004', '1004', '1001', null, null, null, null, null, null);
INSERT INTO `call_record` VALUES ('3', '64081780-d2d4-11e9-9b25-e98a91163029', '1004', '1004', '1001', null, null, null, null, null, 'NORMAL_CLEARING');
INSERT INTO `call_record` VALUES ('4', '88be68a4-d2d4-11e9-9b58-e98a91163029', '1004', '1004', '1001', null, null, null, null, null, 'NORMAL_CLEARING');
INSERT INTO `call_record` VALUES ('5', 'a20d3482-d2d6-11e9-9bee-e98a91163029', '1004', '1004', '1001', '1568015489540750', '1568015503820719', null, null, null, null);
INSERT INTO `call_record` VALUES ('6', '37f6b152-d2d8-11e9-9c20-e98a91163029', '1004', '1004', '1001', '1568016170600742', '1568016198420743', null, null, null, null);
INSERT INTO `call_record` VALUES ('7', '7ec5de6e-d2d8-11e9-9c51-e98a91163029', '1004', '1004', '1001', '1568016289380748', '1568016303420703', null, null, null, null);
INSERT INTO `call_record` VALUES ('8', 'b7f414d0-d2d8-11e9-9c83-e98a91163029', '1004', '1004', '1001', '1568016385280695', '1568016399920703', null, null, null, null);
INSERT INTO `call_record` VALUES ('9', 'ddcfa782-d2d8-11e9-9cb4-e98a91163029', '1004', '1004', '1001', '1568016448820748', '1568016461680705', null, null, null, null);
INSERT INTO `call_record` VALUES ('10', '1922a4b0-d2d9-11e9-9ce4-e98a91163029', '1002', '1002', '1009', '1568016548600704', '1568016558700693', null, null, null, null);
INSERT INTO `call_record` VALUES ('11', '2100ca86-d2d9-11e9-9d1d-e98a91163029', '1004', '1004', '1001', '1568016561500697', '1568016574220748', null, null, null, null);
INSERT INTO `call_record` VALUES ('12', '89bd2a42-d2d9-11e9-9d4e-e98a91163029', '1004', '1004', '1001', '1568016737220701', '1568016750280748', null, null, null, null);
INSERT INTO `call_record` VALUES ('13', '11499810-d2da-11e9-9d80-e98a91163029', '1004', '1004', '1001', '1568016964640702', '1568016980000706', null, null, null, null);
INSERT INTO `call_record` VALUES ('14', 'de8e214c-d2da-11e9-9db2-e98a91163029', '1004', '1004', '1001', '1568017309040699', '1568017327440706', null, null, null, null);
INSERT INTO `call_record` VALUES ('15', '7941142e-d2db-11e9-9de3-e98a91163029', '1004', '1004', '1001', '1568017568580742', '1568017582300739', '1568017584300744', '15720002', '2000005', 'NORMAL_CLEARING');
INSERT INTO `call_record` VALUES ('16', '6dc19878-d2de-11e9-9e18-e98a91163029', '1004', '1004', '1001', '1568018837800703', '1568018850700700', '1568018860140709', '22340006', '9', 'NORMAL_CLEARING');
INSERT INTO `call_record` VALUES ('17', 'b3dfcfc8-d2de-11e9-9e4a-e98a91163029', '1004', '1004', '1001', '1568018955440750', '1568018969640697', '1568018994260695', '38819945', '24', 'NORMAL_CLEARING');
INSERT INTO `call_record` VALUES ('18', 'cd6511c4-d2de-11e9-9e7b-e98a91163029', '1004', '1004', '1001', '1568018998240713', '1568019012840759', '1568019023280749', '25040036', '10', 'NORMAL_CLEARING');

-- ----------------------------
-- Table structure for call_sound
-- ----------------------------
DROP TABLE IF EXISTS `call_sound`;
CREATE TABLE `call_sound` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `call_uuid` varchar(36) NOT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of call_sound
-- ----------------------------
INSERT INTO `call_sound` VALUES ('1', 'cd6511c4-d2de-11e9-9e7b-e98a91163029', '/home/record/2019-09-09-16-50-08_1001_1004.wav');
