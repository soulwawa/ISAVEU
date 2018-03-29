-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 192.168.0.35    Database: iot_smartbuilding
-- ------------------------------------------------------
-- Server version	5.6.25-enterprise-commercial-advanced-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_action`
--

DROP TABLE IF EXISTS `tb_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_action` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_id` varchar(4) NOT NULL,
  `url` varchar(50) NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_action`
--

LOCK TABLES `tb_action` WRITE;
/*!40000 ALTER TABLE `tb_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_event`
--

DROP TABLE IF EXISTS `tb_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_id` varchar(4) NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `temp` float NOT NULL,
  `smoke` float NOT NULL,
  `gyro` float NOT NULL,
  `fire` float NOT NULL,
  `issue` varchar(1) NOT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_event`
--

LOCK TABLES `tb_event` WRITE;
/*!40000 ALTER TABLE `tb_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_fire_ex`
--

DROP TABLE IF EXISTS `tb_fire_ex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_fire_ex` (
  `fire_ex_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `ex_date` date NOT NULL,
  `check_date` datetime NOT NULL,
  PRIMARY KEY (`fire_ex_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_fire_ex`
--

LOCK TABLES `tb_fire_ex` WRITE;
/*!40000 ALTER TABLE `tb_fire_ex` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_fire_ex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_hr`
--

DROP TABLE IF EXISTS `tb_hr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_hr` (
  `hr_id` int(11) NOT NULL,
  `id` varchar(16) NOT NULL,
  `pw` varchar(16) NOT NULL,
  `name` varchar(10) NOT NULL,
  `location_id` int(11) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `birthday` varchar(8) NOT NULL,
  `level` varchar(1) NOT NULL,
  `FCM` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_hr`
--

LOCK TABLES `tb_hr` WRITE;
/*!40000 ALTER TABLE `tb_hr` DISABLE KEYS */;
INSERT INTO `tb_hr` VALUES (1,'Administrator','root','관리자',610,'010-0000-0000','administrator@HSB.com','F','20180317','0','dpLbZuQqfWI:APA91bGk_AXJK3q6Kx4_k9sil7hJQ1CzfqFvTPzonsQpl3OwOpCYVeHrcJdcBpvgY6XaazHcQLkSfHtho2cVdv6G9hkMZUELAPruewDjlffQ5sNCPyIQL71PNtQPVfPlPHOusLBnN6pJ');
/*!40000 ALTER TABLE `tb_hr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_location`
--

DROP TABLE IF EXISTS `tb_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_location` (
  `location_id` int(11) NOT NULL,
  `location` varchar(4) NOT NULL,
  `dept_name` varchar(20) NOT NULL,
  `manager` varchar(20) DEFAULT NULL,
  `dept_tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_location`
--

LOCK TABLES `tb_location` WRITE;
/*!40000 ALTER TABLE `tb_location` DISABLE KEYS */;
INSERT INTO `tb_location` VALUES (1,'600','hallway',NULL,'070-0000-0001'),(2,'601','President',NULL,'070-0000-0002'),(3,'602','Planning Dept',NULL,'070-0000-0003'),(4,'603','Management',NULL,'070-0000-0004'),(5,'604','Marketing',NULL,'070-0000-0005'),(6,'605','Design',NULL,'070-0000-0006'),(7,'606','Production',NULL,'070-0000-0007'),(8,'607','RNDTeam',NULL,'070-0000-0008'),(9,'608','Quality Control',NULL,'070-0000-0009'),(10,'609','Sales',NULL,'070-0000-0010'),(11,'610','Administration',NULL,'070-0000-0011');
/*!40000 ALTER TABLE `tb_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_module`
--

DROP TABLE IF EXISTS `tb_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_module` (
  `module_id` varchar(4) NOT NULL,
  `type` varchar(10) NOT NULL,
  `ip` varchar(16) NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_module`
--

LOCK TABLES `tb_module` WRITE;
/*!40000 ALTER TABLE `tb_module` DISABLE KEYS */;
INSERT INTO `tb_module` VALUES ('1','arduino','192.168.0.46',603),('2','raspberry','192.168.0.13',603);
/*!40000 ALTER TABLE `tb_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'iot_smartbuilding'
--

--
-- Dumping routines for database 'iot_smartbuilding'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-17 16:35:04
