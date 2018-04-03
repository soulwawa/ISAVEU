tb_module-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
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
INSERT INTO `tb_module` VALUES ('0','arduino','192.168.0.46',1)
,('1','arduino','192.168.0.47',11),('10','arduino','192.168.0.54',8),
('11','raspberry','192.168.0.13',9),('12','raspberry','192.168.0.61',10),
('2','arduino','192.168.0.55',1),('3','arduino','192.168.0.56',1),
('4','arduino','192.168.0.48',2),('5','arduino','192.168.0.49',3),
('6','arduino','192.168.0.50',4),('7','arduino','192.168.0.51',5),
('8','arduino','192.168.0.52',6),('9','arduino','192.168.0.53',7);
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

-- Dump completed on 2018-04-03 17:00:35
