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
-- Table structure for table `credit_card_info`
--

DROP TABLE IF EXISTS `credit_card_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_card_info` (
  `idcredit_card_info` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `name_on_card` varchar(45) DEFAULT NULL,
  `expiration_date` varchar(45) DEFAULT NULL,
  `cvv` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcredit_card_info`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card_info`
--

LOCK TABLES `credit_card_info` WRITE;
/*!40000 ALTER TABLE `credit_card_info` DISABLE KEYS */;
INSERT INTO `credit_card_info` VALUES (1,'American Express','1234123412341234','John Doe','01/01/16',1234),(2,'Visa','4321432143214321','Ben Biggie','05/10/17',4321),(3,'Discover','4567456745674567','Gordon Ramsey','10/20/20',4567),(4,'Visa','5858585858585858','Tom Brady','4/24/24',8585),(5,'American Express','9348576610293847','Frank Redhot','6/6/21',1212),(6,'Visa','1234567812345678','Frank Underhill','06/15/2017',4567),(8,'Visa','1234567812345678','Frank Tanky','06/15/2017',4567),(9,'Visa','1234567812345678','Bob Thorton','06/15/2017',4567),(10,'MasterCard','7474747474747474','Bob Thorton','06/18/2017',4567);
/*!40000 ALTER TABLE `credit_card_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-13 13:51:22
