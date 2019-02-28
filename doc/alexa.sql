/*
Navicat MySQL Data Transfer

Source Server         : 123 root
Source Server Version : 50537
Source Host           : 123.57.80.58:3306
Source Database       : alexa

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-08-08 10:43:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `QRTZ_BLOB_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_BLOB_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_CALENDARS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_CALENDARS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_CRON_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_CRON_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_FIRED_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_FIRED_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_JOB_DETAILS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_JOB_DETAILS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_LOCKS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_LOCKS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_PAUSED_TRIGGER_GRPS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_SCHEDULER_STATE`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_SCHEDULER_STATE
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_SIMPLE_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_SIMPLE_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_SIMPROP_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_SIMPROP_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `QRTZ_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of QRTZ_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `schedule_job`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'testTask', 'test', 'renren', '0 0/30 * * * ?', '0', '有参数测试', '2016-12-01 23:16:46');
INSERT INTO `schedule_job` VALUES ('2', 'testTask', 'test2', null, '0 0/30 * * * ?', '1', '无参数测试', '2016-12-03 14:55:56');

-- ----------------------------
-- Table structure for `schedule_job_log`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"iOQoZSxx8FLcwFTX\",\"aliyunAccessKeySecret\":\"QdFsgOMuMj1ETDuNSjb7TJnHGeHt1m\",\"aliyunBucketName\":\"dentist\",\"aliyunDomain\":\"http://image.lcworld.cn\",\"aliyunEndPoint\":\"http://oss-cn-beijing.aliyuncs.com\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":2}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '保存角色', 'com.lcworld.controller.SysRoleController.save()', '{\"menuIdList\":[1,2,15,16,17,18],\"remark\":\"test\",\"roleName\":\"test\"}', '221.219.104.181', '2017-07-12 19:37:44');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'sys/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('28', '1', '代码生成器', 'sys/generator.html', 'sys:generator:list,sys:generator:code', '1', 'fa fa-rocket', '8');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'sys/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('31', '1', '版本表', 'generator/version.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('32', '31', '查看', null, 'version:list,version:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('33', '31', '新增', null, 'version:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('34', '31', '修改', null, 'version:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('35', '31', '删除', null, 'version:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('36', '1', '设备管理', 'generator/device.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('37', '36', '查看', null, 'device:list,device:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('38', '36', '新增', null, 'device:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'device:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'device:delete', '2', null, '6');

-- ----------------------------
-- Table structure for `sys_oss`
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------
INSERT INTO `sys_oss` VALUES ('1', 'http://image.lcworld.cn/20170712/f0bfefd20e364fc9a2697f9439de08df', '2017-07-12 18:42:19');
INSERT INTO `sys_oss` VALUES ('2', 'http://image.lcworld.cn/20170713/59c3d8867999486195847f985797389c', '2017-07-13 15:38:28');
INSERT INTO `sys_oss` VALUES ('3', 'http://image.lcworld.cn/20170713/42d6c627c85d48e981b5c5348bb0ded1', '2017-07-13 16:37:53');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'test', 'test', '1', '2017-07-12 19:37:44');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '15');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '16');
INSERT INTO `sys_role_menu` VALUES ('5', '1', '17');
INSERT INTO `sys_role_menu` VALUES ('6', '1', '18');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'root@renren.io', '13612345678', '1', null, '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_device`
-- ----------------------------
DROP TABLE IF EXISTS `tb_device`;
CREATE TABLE `tb_device` (
  `device_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_name` varchar(255) DEFAULT NULL COMMENT '设备名字',
  `imei` varchar(255) DEFAULT NULL COMMENT 'imei',
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_device
-- ----------------------------
INSERT INTO `tb_device` VALUES ('2', 'Lenovo S960', '862321020249436', '2017-07-13 17:35:20');
INSERT INTO `tb_device` VALUES ('3', 'MI NOTE Pro', '867302020156552', '2017-07-13 18:30:47');
INSERT INTO `tb_device` VALUES ('4', 'MI NOTE Pro', '867302020156552', '2017-07-13 18:31:10');
INSERT INTO `tb_device` VALUES ('5', 'MI NOTE Pro', '867302020156552', '2017-07-13 18:37:27');
INSERT INTO `tb_device` VALUES ('6', 'MI NOTE Pro', '867302020156552', '2017-07-13 18:49:59');
INSERT INTO `tb_device` VALUES ('7', 'MI NOTE Pro', '867302020156552', '2017-07-13 18:50:36');
INSERT INTO `tb_device` VALUES ('8', 'MI NOTE Pro', '867302020156552', '2017-07-13 19:24:41');
INSERT INTO `tb_device` VALUES ('9', 'MI NOTE Pro', '867302020156552', '2017-07-13 19:35:57');
INSERT INTO `tb_device` VALUES ('10', 'MI NOTE Pro', '867302020156552', '2017-07-13 19:36:53');
INSERT INTO `tb_device` VALUES ('11', 'MI NOTE Pro', '867302020156552', '2017-07-13 19:39:53');
INSERT INTO `tb_device` VALUES ('12', 'MI NOTE Pro', '867302020156552', '2017-07-13 19:41:45');
INSERT INTO `tb_device` VALUES ('13', 'MI NOTE Pro', '867302020156552', '2017-07-13 19:53:43');
INSERT INTO `tb_device` VALUES ('14', 'MI NOTE Pro', '867302020156552', '2017-07-13 20:14:31');
INSERT INTO `tb_device` VALUES ('15', 'MI NOTE Pro', '867302020156552', '2017-07-13 20:24:41');
INSERT INTO `tb_device` VALUES ('16', 'MI NOTE Pro', '867302020156552', '2017-07-13 20:28:35');
INSERT INTO `tb_device` VALUES ('17', 'MI NOTE Pro', '867302020156552', '2017-07-13 20:32:17');
INSERT INTO `tb_device` VALUES ('18', 'MI NOTE Pro', '867302020156552', '2017-07-13 20:33:59');
INSERT INTO `tb_device` VALUES ('19', 'MI NOTE Pro', '867302020156552', '2017-07-13 20:34:46');
INSERT INTO `tb_device` VALUES ('20', 'MI NOTE Pro', '867302020156552', '2017-07-14 10:45:28');
INSERT INTO `tb_device` VALUES ('21', 'MI NOTE Pro', '867302020156552', '2017-07-14 11:45:33');
INSERT INTO `tb_device` VALUES ('22', 'MI NOTE Pro', '867302020156552', '2017-07-14 12:00:13');
INSERT INTO `tb_device` VALUES ('23', 'Lenovo S960', '862321020249436', '2017-07-14 12:03:25');
INSERT INTO `tb_device` VALUES ('24', 'MI NOTE Pro', '867302020156552', '2017-07-14 12:12:41');
INSERT INTO `tb_device` VALUES ('25', 'MI 5', '862630033070229', '2017-07-14 18:47:31');
INSERT INTO `tb_device` VALUES ('26', 'MI 5', '862630033070229', '2017-07-14 18:48:00');
INSERT INTO `tb_device` VALUES ('27', 'ATH-AL00', '867875022994294', '2017-07-14 20:04:07');
INSERT INTO `tb_device` VALUES ('28', 'ATH-AL00', '867875022994294', '2017-07-14 20:05:28');
INSERT INTO `tb_device` VALUES ('29', 'MI 5', '862630033070229', '2017-07-14 20:05:51');
INSERT INTO `tb_device` VALUES ('30', 'ATH-AL00', '867875022994294', '2017-07-14 20:07:09');
INSERT INTO `tb_device` VALUES ('31', 'HUAWEI G660-L075', '864219022500442', '2017-07-15 11:23:25');
INSERT INTO `tb_device` VALUES ('32', 'PE-TL20', '865586024314959', '2017-07-15 11:26:28');
INSERT INTO `tb_device` VALUES ('33', 'xiaomi-1s', '770400759474535', '2017-07-15 11:26:30');
INSERT INTO `tb_device` VALUES ('34', 'xiaomi-1s', '770400759474535', '2017-07-15 11:26:40');
INSERT INTO `tb_device` VALUES ('35', 'Nexus 11', '74e019d22a7f929', '2017-07-15 11:26:50');
INSERT INTO `tb_device` VALUES ('36', 'Nexus 11', '972afacd3c4e72f', '2017-07-15 11:26:56');
INSERT INTO `tb_device` VALUES ('37', 'xiaomi-1s', '770400759474535', '2017-07-15 11:27:46');
INSERT INTO `tb_device` VALUES ('38', 'ATH-AL00', '867875022994294', '2017-07-15 11:28:01');
INSERT INTO `tb_device` VALUES ('39', 'PE-TL20', '865586024314959', '2017-07-15 11:28:56');
INSERT INTO `tb_device` VALUES ('40', 'PE-TL20', '865586024314959', '2017-07-15 11:31:54');
INSERT INTO `tb_device` VALUES ('41', 'MI NOTE Pro', '867302020156552', '2017-07-15 11:32:07');
INSERT INTO `tb_device` VALUES ('42', 'Nexus 11', '33d45b672e385d2', '2017-07-15 11:32:24');
INSERT INTO `tb_device` VALUES ('43', 'Nexus 11', '801ab633152ae08', '2017-07-15 11:32:29');
INSERT INTO `tb_device` VALUES ('44', 'Nexus 11', 'a74884eb80034d5', '2017-07-15 11:32:31');
INSERT INTO `tb_device` VALUES ('45', 'Lenovo S960', '862321020249436', '2017-07-15 11:34:04');
INSERT INTO `tb_device` VALUES ('46', 'Nexus 4', '576184428433171', '2017-07-15 11:35:03');
INSERT INTO `tb_device` VALUES ('47', 'MI NOTE Pro', '867302020156552', '2017-07-15 12:45:40');
INSERT INTO `tb_device` VALUES ('48', 'MI NOTE Pro', '867302020156552', '2017-07-15 12:46:27');
INSERT INTO `tb_device` VALUES ('49', 'MI NOTE Pro', '867302020156552', '2017-07-15 12:50:53');
INSERT INTO `tb_device` VALUES ('50', 'MI NOTE Pro', '867302020156552', '2017-07-15 12:51:06');
INSERT INTO `tb_device` VALUES ('51', 'MI NOTE Pro', '867302020156552', '2017-07-15 12:51:23');
INSERT INTO `tb_device` VALUES ('52', 'MI NOTE Pro', '867302020156552', '2017-07-15 12:51:29');
INSERT INTO `tb_device` VALUES ('53', 'MI NOTE Pro', '867302020156552', '2017-07-15 13:12:13');
INSERT INTO `tb_device` VALUES ('54', 'MI NOTE Pro', '867302020156552', '2017-07-15 13:30:07');
INSERT INTO `tb_device` VALUES ('55', 'ATH-AL00', '867875022994294', '2017-07-15 14:33:53');
INSERT INTO `tb_device` VALUES ('56', 'ATH-AL00', '867875022994294', '2017-07-15 14:34:27');
INSERT INTO `tb_device` VALUES ('57', 'ATH-AL00', '867875022994294', '2017-07-15 14:40:03');
INSERT INTO `tb_device` VALUES ('58', 'ATH-AL00', '867875022994294', '2017-07-15 17:12:43');
INSERT INTO `tb_device` VALUES ('59', 'ATH-AL00', '867875022994294', '2017-07-15 17:18:03');
INSERT INTO `tb_device` VALUES ('60', 'ATH-AL00', '867875022994294', '2017-07-15 17:26:32');
INSERT INTO `tb_device` VALUES ('61', 'ATH-AL00', '867875022994294', '2017-07-15 17:27:23');
INSERT INTO `tb_device` VALUES ('62', 'ATH-AL00', '867875022994294', '2017-07-15 17:28:23');
INSERT INTO `tb_device` VALUES ('63', 'ATH-AL00', '867875022994294', '2017-07-15 17:29:23');
INSERT INTO `tb_device` VALUES ('64', 'ATH-AL00', '867875022994294', '2017-07-15 17:29:30');
INSERT INTO `tb_device` VALUES ('65', 'ATH-AL00', '867875022994294', '2017-07-15 17:30:02');
INSERT INTO `tb_device` VALUES ('66', 'ATH-AL00', '867875022994294', '2017-07-15 17:30:28');
INSERT INTO `tb_device` VALUES ('67', 'ATH-AL00', '867875022994294', '2017-07-15 17:30:48');
INSERT INTO `tb_device` VALUES ('68', 'ATH-AL00', '867875022994294', '2017-07-15 17:30:57');
INSERT INTO `tb_device` VALUES ('69', 'ATH-AL00', '867875022994294', '2017-07-15 17:31:11');
INSERT INTO `tb_device` VALUES ('70', 'ATH-AL00', '867875022994294', '2017-07-15 17:31:30');
INSERT INTO `tb_device` VALUES ('71', 'ATH-AL00', '867875022994294', '2017-07-15 17:31:37');
INSERT INTO `tb_device` VALUES ('72', 'ATH-AL00', '867875022994294', '2017-07-15 17:31:53');
INSERT INTO `tb_device` VALUES ('73', 'ATH-AL00', '867875022994294', '2017-07-15 17:32:13');
INSERT INTO `tb_device` VALUES ('74', 'ATH-AL00', '867875022994294', '2017-07-15 17:37:33');
INSERT INTO `tb_device` VALUES ('75', 'ATH-AL00', '867875022994294', '2017-07-15 17:55:43');
INSERT INTO `tb_device` VALUES ('76', 'ATH-AL00', '867875022994294', '2017-07-16 09:48:58');
INSERT INTO `tb_device` VALUES ('77', 'ATH-AL00', '867875022994294', '2017-07-16 09:49:10');
INSERT INTO `tb_device` VALUES ('78', 'ATH-AL00', '867875022994294', '2017-07-16 09:49:39');
INSERT INTO `tb_device` VALUES ('79', 'ATH-AL00', '867875022994294', '2017-07-16 09:49:43');
INSERT INTO `tb_device` VALUES ('80', 'ATH-AL00', '867875022994294', '2017-07-16 09:49:46');
INSERT INTO `tb_device` VALUES ('81', 'MI NOTE Pro', '867302020156552', '2017-07-17 17:03:10');
INSERT INTO `tb_device` VALUES ('82', 'MI NOTE Pro', '867302020156552', '2017-07-17 17:07:31');
INSERT INTO `tb_device` VALUES ('83', 'Lenovo S960', '862321020249436', '2017-07-17 17:31:25');
INSERT INTO `tb_device` VALUES ('84', 'Lenovo S960', '862321020249436', '2017-07-17 18:26:16');
INSERT INTO `tb_device` VALUES ('85', 'Lenovo S960', '862321020249436', '2017-07-17 18:27:27');
INSERT INTO `tb_device` VALUES ('86', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:20:21');
INSERT INTO `tb_device` VALUES ('87', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:21:38');
INSERT INTO `tb_device` VALUES ('88', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:21:42');
INSERT INTO `tb_device` VALUES ('89', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:21:47');
INSERT INTO `tb_device` VALUES ('90', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:21:52');
INSERT INTO `tb_device` VALUES ('91', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:21:56');
INSERT INTO `tb_device` VALUES ('92', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:30:42');
INSERT INTO `tb_device` VALUES ('93', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:53:11');
INSERT INTO `tb_device` VALUES ('94', 'MI NOTE Pro', '867302020156552', '2017-07-17 19:57:46');
INSERT INTO `tb_device` VALUES ('95', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:01:36');
INSERT INTO `tb_device` VALUES ('96', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:04:34');
INSERT INTO `tb_device` VALUES ('97', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:16:06');
INSERT INTO `tb_device` VALUES ('98', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:18:09');
INSERT INTO `tb_device` VALUES ('99', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:23:41');
INSERT INTO `tb_device` VALUES ('100', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:23:49');
INSERT INTO `tb_device` VALUES ('101', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:25:07');
INSERT INTO `tb_device` VALUES ('102', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:34:20');
INSERT INTO `tb_device` VALUES ('103', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:36:05');
INSERT INTO `tb_device` VALUES ('104', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:37:07');
INSERT INTO `tb_device` VALUES ('105', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:39:33');
INSERT INTO `tb_device` VALUES ('106', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:40:45');
INSERT INTO `tb_device` VALUES ('107', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:42:00');
INSERT INTO `tb_device` VALUES ('108', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:44:44');
INSERT INTO `tb_device` VALUES ('109', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:45:40');
INSERT INTO `tb_device` VALUES ('110', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:53:18');
INSERT INTO `tb_device` VALUES ('111', 'MI NOTE Pro', '867302020156552', '2017-07-17 20:57:45');
INSERT INTO `tb_device` VALUES ('112', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:07:12');
INSERT INTO `tb_device` VALUES ('113', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:07:44');
INSERT INTO `tb_device` VALUES ('114', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:14:30');
INSERT INTO `tb_device` VALUES ('115', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:20:08');
INSERT INTO `tb_device` VALUES ('116', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:22:15');
INSERT INTO `tb_device` VALUES ('117', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:24:51');
INSERT INTO `tb_device` VALUES ('118', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:37:27');
INSERT INTO `tb_device` VALUES ('119', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:46:27');
INSERT INTO `tb_device` VALUES ('120', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:52:13');
INSERT INTO `tb_device` VALUES ('121', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:57:15');
INSERT INTO `tb_device` VALUES ('122', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:58:57');
INSERT INTO `tb_device` VALUES ('123', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:59:04');
INSERT INTO `tb_device` VALUES ('124', 'MI NOTE Pro', '867302020156552', '2017-07-18 17:59:33');
INSERT INTO `tb_device` VALUES ('125', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:01:08');
INSERT INTO `tb_device` VALUES ('126', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:03:19');
INSERT INTO `tb_device` VALUES ('127', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:14:25');
INSERT INTO `tb_device` VALUES ('128', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:14:41');
INSERT INTO `tb_device` VALUES ('129', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:16:42');
INSERT INTO `tb_device` VALUES ('130', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:19:19');
INSERT INTO `tb_device` VALUES ('131', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:22:56');
INSERT INTO `tb_device` VALUES ('132', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:28:19');
INSERT INTO `tb_device` VALUES ('133', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:32:17');
INSERT INTO `tb_device` VALUES ('134', 'MI NOTE Pro', '867302020156552', '2017-07-18 18:43:32');
INSERT INTO `tb_device` VALUES ('135', 'PE-TL20', '865586024314959', '2017-07-19 15:31:14');
INSERT INTO `tb_device` VALUES ('136', 'ATH-AL00', '867875022994294', '2017-07-19 16:07:06');
INSERT INTO `tb_device` VALUES ('137', 'ATH-AL00', '867875022994294', '2017-07-19 16:08:07');
INSERT INTO `tb_device` VALUES ('138', 'xiaomi-1s', '250021171574991', '2017-07-19 16:32:09');
INSERT INTO `tb_device` VALUES ('139', 'xiaomi-1s', '250021171574991', '2017-07-19 16:32:13');
INSERT INTO `tb_device` VALUES ('140', 'xiaomi-1s', '250021171574991', '2017-07-19 16:32:39');
INSERT INTO `tb_device` VALUES ('141', 'MI 5C', '862391036326312', '2017-07-19 16:35:48');
INSERT INTO `tb_device` VALUES ('142', 'MI 5C', '862391036326312', '2017-07-19 16:36:08');
INSERT INTO `tb_device` VALUES ('143', 'PE-TL20', '865586024314959', '2017-07-19 16:46:25');

-- ----------------------------
-- Table structure for `tb_token`
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of tb_token
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

-- ----------------------------
-- Table structure for `tb_version`
-- ----------------------------
DROP TABLE IF EXISTS `tb_version`;
CREATE TABLE `tb_version` (
  `version_id` int(11) NOT NULL AUTO_INCREMENT,
  `version_code` int(11) DEFAULT NULL COMMENT '版本号(整形,每次递增)',
  `version_name` varchar(100) DEFAULT NULL,
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '0:安卓 1:IOS',
  `url` varchar(100) DEFAULT NULL COMMENT '包地址(对于ios来说,可以在新版本审核通过,添加ios的版本信息,然后app通过版本更新接口提示用户升级)',
  `is_force_update` int(11) NOT NULL DEFAULT '0' COMMENT '是否强制更新:0 否;1是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `content` varchar(255) DEFAULT NULL COMMENT '更新说明',
  PRIMARY KEY (`version_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='版本表';

-- ----------------------------
-- Records of tb_version
-- ----------------------------
INSERT INTO `tb_version` VALUES ('5', '1', '1.0.0', '0', 'http://image.lcworld.cn/20170712/f0bfefd20e364fc9a2697f9439de08df', '1', '2017-07-12 18:43:11', 'xxxx');
