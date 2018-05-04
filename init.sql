-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.23 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 jingji_insurance 的数据库结构
CREATE DATABASE IF NOT EXISTS `jingji_insurance` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jingji_insurance`;


-- 导出  表 jingji_insurance.tb_dict 结构
CREATE TABLE IF NOT EXISTS `tb_dict` (
  `d_id` varchar(8) NOT NULL COMMENT '主键',
  `d_name` varchar(50) NOT NULL COMMENT '字典名称',
  `d_value` varchar(100) NOT NULL COMMENT '字典值',
  `d_remark` varchar(200) NOT NULL COMMENT '备注',
  PRIMARY KEY (`d_id`),
  UNIQUE KEY `d_name` (`d_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- 正在导出表  jingji_insurance.tb_dict 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `tb_dict` DISABLE KEYS */;
INSERT INTO `tb_dict` (`d_id`, `d_name`, `d_value`, `d_remark`) VALUES
	('s548241f', 'insurance_date', '2018-10-01', '默认投保日期(无此项则默认为当前年10月1日)');
/*!40000 ALTER TABLE `tb_dict` ENABLE KEYS */;


-- 导出  表 jingji_insurance.tb_employee 结构
CREATE TABLE IF NOT EXISTS `tb_employee` (
  `e_number` int(11) NOT NULL COMMENT '员工工号',
  `e_name` varchar(50) NOT NULL COMMENT '员工姓名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息表';

-- 正在导出表  jingji_insurance.tb_employee 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `tb_employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_employee` ENABLE KEYS */;


-- 导出  表 jingji_insurance.tb_insured_person_information 结构
CREATE TABLE IF NOT EXISTS `tb_insured_person_information` (
  `i_id` varchar(8) NOT NULL COMMENT '主键',
  `p_id` varchar(8) NOT NULL COMMENT '投保人id',
  `i_p_relation` int(1) NOT NULL DEFAULT '1' COMMENT '与投保人关系（1-本人；2-配偶；3-子女；4-父母；5-其他）',
  `i_name` varchar(50) NOT NULL COMMENT '被投保人姓名',
  `i_card_type` int(1) NOT NULL DEFAULT '1' COMMENT '被投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）',
  `i_card` varchar(100) NOT NULL COMMENT '被投保人证件号码',
  `i_birth` date NOT NULL COMMENT '被投保人出生日期',
  `i_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='被保险人信息表';

-- 正在导出表  jingji_insurance.tb_insured_person_information 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `tb_insured_person_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_insured_person_information` ENABLE KEYS */;


-- 导出  表 jingji_insurance.tb_policyholder_information 结构
CREATE TABLE IF NOT EXISTS `tb_policyholder_information` (
  `p_id` varchar(8) NOT NULL COMMENT '主键',
  `e_number` varchar(100) NOT NULL COMMENT '投保人工号',
  `p_name` varchar(100) NOT NULL COMMENT '投保人姓名',
  `p_card_type` int(11) NOT NULL DEFAULT '1' COMMENT '投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）',
  `p_card` varchar(50) NOT NULL COMMENT '投保人证件号码',
  `p_phone` varchar(11) NOT NULL COMMENT '投保人手机号码',
  `p_email` varchar(100) NOT NULL COMMENT '投保人电子邮箱',
  `p_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `p_item` int(1) NOT NULL DEFAULT '1' COMMENT '投保项目（1-经济版；2-豪华版；3-尊贵版）',
  `p_isAppend` int(1) NOT NULL DEFAULT '0' COMMENT '是否附加一年期营运交通工具乘意险（0-否；1-是）',
  `p_insurance_date` date NOT NULL DEFAULT '2018-10-01' COMMENT '投保日期（默认为每年10月1日）',
  `p_price` decimal(10,2) NOT NULL COMMENT '投保总价格',
  `p_isPay` int(1) NOT NULL DEFAULT '0' COMMENT '是否付款(0-否；1-是)',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投保人信息表';

-- 正在导出表  jingji_insurance.tb_policyholder_information 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `tb_policyholder_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_policyholder_information` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
