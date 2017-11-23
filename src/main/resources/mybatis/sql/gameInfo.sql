/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.36 : Database - game
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`game` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `game`;

/*Table structure for table `game_info` */

DROP TABLE IF EXISTS `game_info`;

CREATE TABLE `game_info` (
  `game_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `game_name` varchar(64) NOT NULL COMMENT '游戏名称',
  `game_type` int(8) unsigned NOT NULL COMMENT '游戏类型',
  `game_pic` varchar(256) NOT NULL COMMENT '游戏图片',
  `game_path` varchar(256) NOT NULL COMMENT '游戏路径',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='游戏信息';

/*Data for the table `game_info` */
