/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.6.42 : Database - authority-shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`authority-shiro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `authority-shiro`;

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '菜单名称',
  `pid` int(11) NOT NULL COMMENT '父级菜单id',
  `parent_name` varchar(50) DEFAULT NULL COMMENT '父级菜单名称',
  `type` tinyint(4) NOT NULL COMMENT '菜单类型 1:目录 2：菜单 3：按钮',
  `url` varchar(50) DEFAULT NULL COMMENT '菜单url',
  `code` varchar(50) DEFAULT NULL COMMENT '授权编码',
  `color` varchar(32) DEFAULT NULL COMMENT '颜色',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `sort` tinyint(4) NOT NULL COMMENT '排序',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `t_permission` */

insert  into `t_permission`(`permission_id`,`name`,`pid`,`parent_name`,`type`,`url`,`code`,`color`,`icon`,`sort`) values (1,'系统管理-PC',0,NULL,1,NULL,NULL,NULL,NULL,1),(2,'用户管理',1,'系统管理',2,'user/listUI','user:listUI',NULL,NULL,1),(3,'新增',2,'用户管理',3,'','user:add','btn-primary','icon-ok',0),(4,'编辑',2,'用户管理',3,NULL,'user:update','btn-warning','icon-edit',3),(5,'删除',2,'用户管理',3,NULL,'user:delete','btn-danger','icon-trash',4),(6,'角色管理',1,'系统管理',2,'role/listUI','role:listUI',NULL,NULL,2),(7,'新增',6,'角色管理',3,NULL,'role:add','btn-primary','icon-ok',2),(8,'编辑',6,'角色管理',3,NULL,'role:update','btn-warning','icon-edit',3),(9,'删除',6,'角色管理',3,NULL,'role:delete','btn-danger','icon-trash',4),(10,'权限管理',1,'系统管理',2,'permission/listUI','permission:listUI',NULL,NULL,3),(11,'新增',10,'权限管理',3,NULL,'permission:add','btn-primary','icon-ok',1),(12,'编辑',10,'权限管理',3,NULL,'permission:update','btn-warning','icon-edit',2),(13,'删除',10,'权限管理',3,NULL,'permission:delete','btn-danger','icon-trash',3),(14,'设置角色',2,'用户管理',3,NULL,'user:setRole','btn-success','icon-cog',1),(15,'设置权限',6,'角色管理',3,NULL,'role:setPermission','btn-success','icon-cog',1),(16,'系统管理-APP',0,NULL,1,NULL,NULL,NULL,NULL,1),(17,'PBI项目',16,'系统管理-APP',2,'','manage:manage1',NULL,NULL,0),(18,'PIA项目',16,'系统管理-APP',2,'','manage:manage2',NULL,NULL,0),(30,'wymb项目1',16,'系统管理-APP',2,'','',NULL,NULL,0);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `descr` varchar(255) DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`name`,`descr`) values (1,'超级管理员','最高权限'),(2,'产品经理','项目管理最高权限'),(3,'wymb项目','wymb项目权限');

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_permission` */

insert  into `t_role_permission`(`id`,`role_id`,`permission_id`) values (147,1,1),(148,1,2),(149,1,3),(150,1,4),(151,1,5),(152,1,14),(153,1,6),(154,1,7),(155,1,8),(156,1,9),(157,1,15),(158,1,10),(159,1,11),(160,1,12),(161,1,13),(162,1,30),(163,1,16),(164,1,17),(165,1,18),(209,2,1),(210,2,2),(211,2,3),(212,2,4),(213,2,5),(214,2,14),(215,2,6);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `salt` varchar(10) DEFAULT NULL COMMENT '盐',
  `status` tinyint(1) NOT NULL COMMENT '状态1:启用 0：禁用',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`user_name`,`password`,`email`,`phone`,`salt`,`status`,`create_time`,`update_time`) values (1,'admin','21232f297a57a5a743894a0e4a801fc3','admin@163.com','17603083280','abc',1,'2017-12-12 12:42:20','2018-11-12 06:51:10'),(6,'张明杰','e10adc3949ba59abbe56e057f20f883e','137455054@qq.com','17603083280',NULL,1,'2018-11-12 07:13:10','2018-11-13 03:08:13'),(7,'开发1','e10adc3949ba59abbe56e057f20f883e','137455054@qq.com','17603083280',NULL,1,'2018-11-12 07:13:16','2018-11-13 07:57:30'),(8,'开发2','e10adc3949ba59abbe56e057f20f883e','137455054@qq.com','17603083280',NULL,1,'2018-11-12 07:13:20','2018-11-13 07:57:43'),(9,'c','e10adc3949ba59abbe56e057f20f883e','c','c',NULL,1,'2018-11-12 07:13:25','2018-11-12 07:13:25'),(10,'d','e10adc3949ba59abbe56e057f20f883e','d','d',NULL,1,'2018-11-12 07:13:30','2018-11-12 07:13:30'),(11,'e','e10adc3949ba59abbe56e057f20f883e','e','e',NULL,0,'2018-11-12 07:13:34','2018-11-12 07:13:49'),(12,'fff','e10adc3949ba59abbe56e057f20f883e','fff','fff',NULL,1,'2018-11-13 07:48:43','2018-11-13 07:50:25');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`user_id`,`role_id`) values (1,1,1),(7,6,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
