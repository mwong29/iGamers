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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `idproduct` int(11) NOT NULL AUTO_INCREMENT,
  `product_code` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `special_deals` varchar(45) DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproduct`),
  UNIQUE KEY `product_code_UNIQUE` (`product_code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,1,'Enter the lives of three very different criminals, Michael, Franklin and Trevor, as they risk everything in a series of daring and dangerous heists that could set them up for life.',59.99,'none','C:\\iGamers\\web\\resources\\images\\games\\xboxone\\gta5.jpg','XBOX ONE','Grand Theft Auto V'),(2,2,'Bethesda Game Studios, the award-winning creators of Fallout 3 and The Elder Scrolls V: Skyrim, welcome you to the world of Fallout 4 - their most ambitious game ever, and the next generation of open-world gaming.',59.99,'Pre-Order','C:\\iGamers\\web\\resources\\images\\games\\xboxone\\fallout4.jpg','XBOX ONE','Fallout 4'),(3,3,'Call of Duty®: Black Ops III Hardened Edition includes collectible physical items and bonus digital content designed to enhance your in-game experience. Pre-Order now while supplies last.',79.99,'Exclusive','C:\\iGamers\\web\\resources\\images\\games\\xboxone\\CodBlackOps3.jpg','XBOX ONE','Call of Duty: Black Ops III Hardened Edition'),(4,4,'Be the playmaker with the Madden NFL 16 Deluxe Edition. With 36 Madden Ultimate Team Pro Packs including NFL super stars of the past and present and the pre-order exclusive Playmaker Pack, you have never been more equipped to challenge the competition this Madden Season!',59.99,'Exclusive','C:\\iGamers\\web\\resources\\images\\games\\ps4\\Madden16.jpg','PS4','Madden NFL 16'),(5,5,'Feeling the ominous thud of an AT-AT stomping down on the frozen tundra of Hoth. Rebel forces firing blasters as Imperial speeder bikes zip through the lush forests of Endor. Intense dogfights between squadrons of X-wings and TIE fighters filling the skies. ',69.99,'Exclusive','C:\\iGamers\\web\\resources\\images\\games\\ps4\\battlefront4.jpg','PS4','STAR WARS Battlefront Deluxe Edition'),(6,6,'FIFA 16 innovates across the entire pitch to deliver a balanced, authentic, and exciting football experience that lets you play your way, and compete at a higher level.',59.99,'none','C:\\iGamers\\web\\resources\\images\\games\\ps4\\fifa16.jpg','PS4','FIFA 16'),(7,7,'Explore an Alien World in a Game Like No Other In the Pikmin 3 game, players take command of three explorers and a legion of adorable Pikmin in a fight for survival.',55.99,'pre-owned','C:\\iGamers\\web\\resources\\images\\games\\wiiU\\pikmin3.jpg','Wii U','Pikmin 3'),(8,8,'Feel the rush as your kart rockets across the ceiling! Race upside-down and along walls on anti-gravity tracks in the most action-fueled Mario Kart game yet!',59.99,'none','C:\\iGamers\\web\\resources\\images\\games\\wiiU\\marioKart8.jpg','Wii U','Mario Kart 8'),(9,9,'Mario! Link! Samus! Pikachu! All of your favorite Nintendo characters are back, along with plenty of new faces, in Super Smash Bros. for Wii U, the next entry in the beloved Super Smash Bros. series.',59.99,'none','C:\\iGamers\\web\\resources\\images\\games\\wiiU\\smashBros.jpg','Wii U','Super Smash Bros.'),(10,10,'After uncovering an ancient mystery, Lara Croft embarks on a journey throughout the most treacherous and remote regions of the world to find the secret of immortality.',59.99,'none','C:\\iGamers\\web\\resources\\images\\games\\xboxone\\rise_of_the_tomb_raider.jpg','XBOX ONE','Rise of the Tomb Raider'),(11,11,'Several years after his last adventure, retired fortune hunter, Nathan Drake, is forced back into the world of thieves. With the stakes much more personal, Drake embarks on a globe-trotting journey in pursuit of a historical conspiracy behind a fabled pirate treasure.',59.99,'none','C:\\iGamers\\web\\resources\\images\\games\\ps4\\uncharted4.jpg','PS4','Uncharted 4: A Thief\'s End'),(12,12,'Everything changed with the arrival of the Traveler. It sparked a Golden Age when our civilization spanned our solar system, but it didn\'t last. Something hit us, knocked us down.',59.99,'none','C:\\iGamers\\web\\resources\\images\\games\\ps4\\destiny.jpg','PS4','Destiny');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
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
