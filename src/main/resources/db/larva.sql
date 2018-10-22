-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: larva
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `file` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文件Id',
  `name` varchar(256) NOT NULL COMMENT '文件名',
  `suffix` varchar(16) NOT NULL COMMENT '文件后缀',
  `size` bigint(20) DEFAULT '0' COMMENT '文件大小，单位bit',
  `local_url` varchar(1024) NOT NULL COMMENT '本地路径',
  `visit_url` varchar(1024) NOT NULL COMMENT '客户端访问路径',
  `description` varchar(1024) DEFAULT NULL COMMENT '文件描述',
  `upload_uid` int(10) unsigned NOT NULL COMMENT '上传用户Id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` tinyint(3) unsigned DEFAULT '0' COMMENT '是否逻辑删除',
  `is_visible` tinyint(3) unsigned DEFAULT '1' COMMENT '是否客户端可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,'avatar','.jpg',94697,'E:/banner/avatar.jpg','/banner/avatar.jpg',NULL,1,'2018-10-01 15:38:52',0,1),(2,'avatar','.jpg',94697,'E:/banner/avatar.jpg','/banner/avatar.jpg',NULL,1,'2018-10-01 15:42:39',0,1),(3,'avatar','.jpg',94697,'E:/banner/avatar.jpg','/banner/avatar.jpg',NULL,1,'2018-10-01 15:43:37',0,1),(4,'avatar','.jpg',94697,'E:/banner/avatar.jpg','/banner/avatar.jpg',NULL,1,'2018-10-01 15:44:05',0,1),(5,'apple-touch-icon-next','.png',1544,'E:/banner/apple-touch-icon-next.png','/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 15:45:27',0,1),(6,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 15:46:16',0,1),(7,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 15:47:10',0,1),(8,'apple-touch-icon-next','.png',1544,'E:/banner/apple-touch-icon-next.png','/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 15:47:24',0,1),(9,'apple-touch-icon-next','.png',1544,'E:/banner/apple-touch-icon-next.png','/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 15:48:32',0,1),(10,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 15:49:06',0,1),(11,'avatar','.jpg',94697,'E:/banner/avatar.jpg','/banner/avatar.jpg',NULL,1,'2018-10-01 15:50:12',0,1),(12,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 15:50:43',0,1),(13,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 15:50:52',0,1),(14,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 15:51:10',0,1),(15,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 15:56:29',0,1),(16,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 15:57:57',0,1),(17,'apple-touch-icon-next','.png',1544,'E:/banner/apple-touch-icon-next.png','/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 16:32:46',0,1),(18,'apple-touch-icon-next','.png',1544,'E:/banner/apple-touch-icon-next.png','/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 16:33:08',0,1),(19,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 16:42:24',0,1),(20,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 16:46:25',0,1),(21,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 16:48:24',0,1),(22,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 16:50:11',0,1),(23,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 17:16:01',0,1),(24,'apple-touch-icon-next','.png',1544,'E:/banner/apple-touch-icon-next.png','/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 17:16:04',0,1),(25,'avatar','.jpg',94697,'E:/banner/avatar.jpg','/banner/avatar.jpg',NULL,1,'2018-10-01 17:16:06',0,1),(26,'alipay','.jpg',75471,'E:/banner/alipay.jpg','/banner/alipay.jpg',NULL,1,'2018-10-01 17:16:21',0,1),(27,'apple-touch-icon-next','.png',1544,'E:/banner/apple-touch-icon-next.png','/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 17:16:22',0,1),(28,'avatar','.jpg',94697,'E:/banner/avatar.jpg','/banner/avatar.jpg',NULL,1,'2018-10-01 17:16:22',0,1),(29,'alipay','.jpg',75471,'D:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\binbanner/alipay.jpg','/upload/banner/alipay.jpg',NULL,1,'2018-10-01 17:31:38',0,1),(30,'apple-touch-icon-next','.png',1544,'D:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\binbanner/apple-touch-icon-next.png','/upload/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 17:31:38',0,1),(31,'avatar','.jpg',94697,'D:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\binbanner/avatar.jpg','/upload/banner/avatar.jpg',NULL,1,'2018-10-01 17:31:38',0,1),(32,'alipay','.jpg',75471,'/D:/Program%20Files/Apache%20Software%20Foundation/Tomcat%209.0/webapps/ROOT/WEB-INF/classes/banner/alipay.jpg','/upload/banner/alipay.jpg',NULL,1,'2018-10-01 17:33:56',0,1),(33,'apple-touch-icon-next','.png',1544,'/D:/Program%20Files/Apache%20Software%20Foundation/Tomcat%209.0/webapps/ROOT/WEB-INF/classes/banner/apple-touch-icon-next.png','/upload/banner/apple-touch-icon-next.png',NULL,1,'2018-10-01 17:33:57',0,1),(34,'avatar','.jpg',94697,'/D:/Program%20Files/Apache%20Software%20Foundation/Tomcat%209.0/webapps/ROOT/WEB-INF/classes/banner/avatar.jpg','/upload/banner/avatar.jpg',NULL,1,'2018-10-01 17:33:57',0,1),(35,'apple-touch-icon-next','.png',1544,'/D:/Program%20Files/Apache%20Software%20Foundation/Tomcat%209.0/webapps/ROOT/upload/banner/apple-touch-icon-next.png','/upload/banner/apple-touch-icon-next.png',NULL,1,'2018-10-02 08:11:20',0,1);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `resource` varchar(45) NOT NULL COMMENT '所控制的部分',
  `operation` int(11) DEFAULT '0' COMMENT '操作',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission_name_UNIQUE` (`permission_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL,
  `permission_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `real_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `email` varchar(255) NOT NULL COMMENT '电子邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `is_enabled` tinyint(3) unsigned DEFAULT '0' COMMENT '是否可用',
  `is_deleted` tinyint(3) unsigned DEFAULT '0' COMMENT '是否逻辑删除',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'SignorinoY','龚梓阳','meetziyang@163.com','123456','none',NULL,NULL,0,0),(7,'SignorinoY','龚梓阳','meetziyang@5q55.com','12345556','/upload/avatar/default.png','2017-05-18 02:26:10','2017-05-18 02:26:10',1,1),(8,'SignorinoY','龚梓阳','meetziyang@q123.com','123456','none','2018-10-01 15:12:05','2018-10-01 15:12:05',0,0),(10,'SignorinoY','龚梓阳','meetziyang@q1123.com','123456',NULL,'2018-10-01 15:14:15','2018-10-01 15:14:15',0,0),(12,'SignorinoY','龚梓阳','meetziyang@q11456123.com','123456',NULL,'2018-10-01 15:21:26','2018-10-01 15:21:26',0,0),(14,'test','admin','123456@123.com','1234567','none','2018-10-01 19:01:44','2018-10-01 19:01:44',0,0),(15,'test','admin','123456@1243.com','1234567','none','2018-10-01 19:15:22','2018-10-01 19:15:22',0,0),(17,'test','admin','123456@55243.com','1234567','none','2018-10-01 19:32:19','2018-10-01 19:32:19',0,0),(20,'test','admin','1234567@55243.com','1234567','none','2018-10-02 06:09:32','2018-10-02 06:09:32',0,0),(23,'test','admin','1234567@5555243.com','1234567','','2018-10-02 06:20:08','2018-10-02 06:20:08',0,0),(24,'test','admin','1234567@qq555243.com','1234567','','2018-10-02 06:32:24','2018-10-02 06:32:24',0,0),(25,'test','admin','1234567@qq5243.com','1234567','/upload/avatar/default.png','2018-10-02 06:36:52','2018-10-02 06:36:52',1,0),(31,'admin','admin','1234567@qq525543.com','1234567','/upload/avatar/default.png','2018-10-02 11:21:12','2018-10-02 11:21:12',0,0),(32,'admin','admin','1234567@qq52655543.com','{bcrypt}$2a$10$sm9RVDIgJ4uNOvPgshV4F.9lOKdjHjfaafeaw/KqM99H40YxHfq8.','/upload/avatar/default.png','2018-10-02 11:37:18','2018-10-02 11:37:18',0,0),(33,'admin','admin','1234567@qq5265555543.com','{bcrypt}$2a$10$Nv/RMe7YFtdY41vif7xUdu7cKiR16YyXMf89km4II7QoC7s6bwAJW','/upload/avatar/default.png','2018-10-02 11:39:24','2018-10-02 11:39:24',1,0),(34,'admin','admin','1234567@qdq5243.com','{bcrypt}$2a$10$yDzcNer2rRfDj7zuaLD.DOS18jqei.NE3KT/IJvtakw1uupvVIi.a','/upload/avatar/default.png','2018-10-02 12:41:43','2018-10-02 12:41:43',0,0),(35,'admin','admin','1234567@qdq5d243.com','{bcrypt}$2a$10$ubmCHkvAioOuiZN1cuqoCeaQ5Ga.9DMIvKI2PGIpzGtF81iKvx83C','test.png','2018-10-02 12:42:43','2018-10-02 12:42:43',0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户操作记录Id',
  `uid` int(11) NOT NULL COMMENT '用户Id',
  `action` tinyint(3) unsigned NOT NULL COMMENT '用户操作',
  `ip_address` varchar(45) NOT NULL COMMENT 'Ip地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户操作记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_log`
--

LOCK TABLES `user_log` WRITE;
/*!40000 ALTER TABLE `user_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-13 13:03:14
