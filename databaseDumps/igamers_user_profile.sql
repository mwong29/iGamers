-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: igamers
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_profile` (
  `iduser_profile` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `idbilling_address` int(11) DEFAULT NULL,
  `idshipping_address` int(11) DEFAULT NULL,
  `idcredit_card_info` int(11) DEFAULT NULL,
  `username` varchar(45) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `password` varchar(45) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser_profile`),
  UNIQUE KEY `user_name_UNIQUE` (`username`),
  KEY `idbilling_address_idx` (`idbilling_address`),
  KEY `idshipping_address_idx` (`idshipping_address`),
  KEY `idcredit_card_info_idx` (`idcredit_card_info`),
  CONSTRAINT `idbilling_address` FOREIGN KEY (`idbilling_address`) REFERENCES `billing_address` (`idbilling_address`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idcredit_card_info` FOREIGN KEY (`idcredit_card_info`) REFERENCES `credit_card_info` (`idcredit_card_info`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idshipping_address` FOREIGN KEY (`idshipping_address`) REFERENCES `shipping_address` (`idshipping_address`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (1,'John','Doe',1,1,1,'JohnDoe','JohnDoe',NULL),(2,'Ben','Biggie',2,2,2,'BenBiggie','Tux',NULL),(3,'Gordon','Ramsey',3,3,3,'Gordo','Ramrod',NULL),(4,'Tom','Brady',4,4,4,'tommy5','braid',NULL),(20,'Frank','Tanky',21,8,8,'FrankTanky','FrankTanky','frankUnderhill@gmail.com'),(21,'Bob','Thorton',22,9,9,'BobThor','BobThorn','frankUnderhill@gmail.com'),(22,'Bob','Thorton',23,10,10,'BobThor2','BobThorn','bobbob@gmail.com');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-13 12:59:53
