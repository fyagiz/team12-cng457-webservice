-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: team12
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `additional_feature`
--

DROP TABLE IF EXISTS `additional_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional_feature` (
  `additional_featureid` int NOT NULL AUTO_INCREMENT,
  `additional_feature` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`additional_featureid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_feature`
--

LOCK TABLES `additional_feature` WRITE;
/*!40000 ALTER TABLE `additional_feature` DISABLE KEYS */;
INSERT INTO `additional_feature` VALUES (1,'Long battery life'),(2,'Fingerprint'),(3,'Face recognition'),(4,'Long battery life');
/*!40000 ALTER TABLE `additional_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brandid` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brandid`),
  UNIQUE KEY `UK_hsu7w3m7wxvplg49ip7g0v5rr` (`brand_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Apple'),(2,'Asus'),(4,'MSI'),(3,'Samsung');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_and_rating`
--

DROP TABLE IF EXISTS `comment_and_rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_and_rating` (
  `comment_and_ratingid` int NOT NULL AUTO_INCREMENT,
  `customer_comment` varchar(255) DEFAULT NULL,
  `rating` int NOT NULL,
  `product_productid` int DEFAULT NULL,
  PRIMARY KEY (`comment_and_ratingid`),
  KEY `FKcvikoqs8y4j91wm9b77edqegg` (`product_productid`),
  CONSTRAINT `FKcvikoqs8y4j91wm9b77edqegg` FOREIGN KEY (`product_productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_and_rating`
--

LOCK TABLES `comment_and_rating` WRITE;
/*!40000 ALTER TABLE `comment_and_rating` DISABLE KEYS */;
INSERT INTO `comment_and_rating` VALUES (1,'Very nice computer.',5,7),(2,'It was getting hot.',3,7),(3,'Moderate.',4,7),(4,'Bad.',2,7),(5,'It was cool',5,1),(6,'Very expensive.',1,1),(7,'It is good but expensive',3,1),(8,'Meh',2,2),(9,'Nice',4,2),(10,'Cheap and fast',5,5);
/*!40000 ALTER TABLE `comment_and_rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computer`
--

DROP TABLE IF EXISTS `computer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `computer` (
  `computer_memory` varchar(255) DEFAULT NULL,
  `screen_resolution` varchar(255) DEFAULT NULL,
  `storage_capacity` varchar(255) DEFAULT NULL,
  `computerid` int NOT NULL,
  `processor_processorid` int DEFAULT NULL,
  PRIMARY KEY (`computerid`),
  KEY `FKmpfnuj6pdm0ypi46n0c5qqx9b` (`processor_processorid`),
  CONSTRAINT `FKgdb25lnydu6kwrr98re40y4tp` FOREIGN KEY (`computerid`) REFERENCES `product` (`productid`),
  CONSTRAINT `FKmpfnuj6pdm0ypi46n0c5qqx9b` FOREIGN KEY (`processor_processorid`) REFERENCES `processor` (`processorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computer`
--

LOCK TABLES `computer` WRITE;
/*!40000 ALTER TABLE `computer` DISABLE KEYS */;
INSERT INTO `computer` VALUES ('16 GB','1920x1080','1 TB',7,1),('32 GB','1920x1080','1 TB',14,1),('32 GB','1920x1080','1 TB',16,1),('32 GB','1920x1080','1 TB',17,1),('1 GB','1024x768','128 GB',19,2),('32 GB','1920x1080','1 TB',23,NULL);
/*!40000 ALTER TABLE `computer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone` (
  `internal_memory` varchar(255) DEFAULT NULL,
  `phoneid` int NOT NULL,
  PRIMARY KEY (`phoneid`),
  CONSTRAINT `FK3msxaxqlo948xvtp3ja9t2o77` FOREIGN KEY (`phoneid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES ('128 GB',1),('256 GB',2),('64 GB',5),(NULL,20),(NULL,21),(NULL,22),('256 GB',24),('',25),(NULL,26),(NULL,28),(NULL,29),(NULL,30),('64 GB',31),('64 GB',32);
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processor`
--

DROP TABLE IF EXISTS `processor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `processor` (
  `processorid` int NOT NULL AUTO_INCREMENT,
  `clock_frequency` float NOT NULL,
  `model_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`processorid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processor`
--

LOCK TABLES `processor` WRITE;
/*!40000 ALTER TABLE `processor` DISABLE KEYS */;
INSERT INTO `processor` VALUES (1,2.7,'Intel i7 7700 HQ'),(2,2000,'Intel i5 6800'),(3,2000,'Intel i5 6900');
/*!40000 ALTER TABLE `processor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productid` int NOT NULL AUTO_INCREMENT,
  `model` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `screen_size` float NOT NULL,
  `brand_brandid` int DEFAULT NULL,
  PRIMARY KEY (`productid`),
  KEY `FK6y2ehluicriy27dtgiekqc0bc` (`brand_brandid`),
  CONSTRAINT `FK6y2ehluicriy27dtgiekqc0bc` FOREIGN KEY (`brand_brandid`) REFERENCES `brand` (`brandid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'iPhone 12 Pro Max',1099,6.7,1),(2,'iPhone XS Max',1099,6.5,1),(5,'Galaxy S3',249.99,5.5,3),(7,'GL 702VMK',999.99,17.3,2),(14,'GL 702VMK',1999.99,17.3,2),(16,'GL 702VMK',1999.99,17.3,2),(17,'GL 702VMK',1999.99,17.3,2),(19,'Asus VivoBook S',10000,16.3,1),(20,NULL,0,0,NULL),(21,NULL,0,0,NULL),(22,NULL,5000,18.3,NULL),(23,'GL 702VMK',5000,17.3,NULL),(24,'IPhone 11',5000,16.3,NULL),(25,'',10000,16.3,NULL),(26,'iPhone XR',5000,18.3,NULL),(28,'iPhone XR',5000,18.3,NULL),(29,'iPhone XR',5000,18.3,1),(30,'iPhone XR',5000,18.3,1),(31,'iPhone XR',5000,18.3,1),(32,'iPhone XR',5000,18.3,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_additional_feature_relationship`
--

DROP TABLE IF EXISTS `product_additional_feature_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_additional_feature_relationship` (
  `additional_featureid` int NOT NULL,
  `productid` int NOT NULL,
  KEY `FKp7q2o0mj7ppjcyvvyuokdcss8` (`productid`),
  KEY `FKdneye8d8y6jwyjvsjspob1e22` (`additional_featureid`),
  CONSTRAINT `FKdneye8d8y6jwyjvsjspob1e22` FOREIGN KEY (`additional_featureid`) REFERENCES `product` (`productid`),
  CONSTRAINT `FKp7q2o0mj7ppjcyvvyuokdcss8` FOREIGN KEY (`productid`) REFERENCES `additional_feature` (`additional_featureid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_additional_feature_relationship`
--

LOCK TABLES `product_additional_feature_relationship` WRITE;
/*!40000 ALTER TABLE `product_additional_feature_relationship` DISABLE KEYS */;
INSERT INTO `product_additional_feature_relationship` VALUES (5,1),(5,2),(7,3),(7,3),(1,1),(1,3),(20,4),(20,3),(21,4),(21,3),(22,4),(22,3),(26,4),(26,3),(28,4),(28,3),(29,4),(29,3),(30,4),(30,3),(31,4),(31,3),(32,4),(32,3);
/*!40000 ALTER TABLE `product_additional_feature_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'team12'
--

--
-- Dumping routines for database 'team12'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-27 14:42:41
