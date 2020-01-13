-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: vote
-- ------------------------------------------------------
-- Server version	5.7.21-1

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
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_pwd` varchar(255) DEFAULT NULL,
  `admin_kind` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` VALUES (1,'root','root','admin'),(2,'username','password','user'),(9,'user','pass','user'),(10,'rootqq','root','user');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_info`
--

DROP TABLE IF EXISTS `t_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_sex` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_info`
--

LOCK TABLES `t_user_info` WRITE;
/*!40000 ALTER TABLE `t_user_info` DISABLE KEYS */;
INSERT INTO `t_user_info` VALUES (1,'10025','user1','男','17777777777','pwd1'),(2,'10026','user2','女','18888888888','pwd2');
/*!40000 ALTER TABLE `t_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_vote`
--

DROP TABLE IF EXISTS `t_vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `vote_name` varchar(255) DEFAULT NULL,
  `vote_messages` longtext,
  `status` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_vote`
--

LOCK TABLES `t_vote` WRITE;
/*!40000 ALTER TABLE `t_vote` DISABLE KEYS */;
INSERT INTO `t_vote` VALUES (5,'皮卡丘','大侦探皮卡丘符合你的心里预期吗','[{\"option_num\":104,\"option_id\":1,\"option_name\":\"符合，你给我皮卡丘我就给你钱\"},{\"option_num\":6,\"option_id\":2,\"option_name\":\"不符合，剧情水人设差缺点多\"},{\"option_num\":21,\"option_id\":3,\"option_name\":\"不感兴趣，没看\"}]',2,'2019-05-11','2019-06-10'),(6,'煮饭的灭霸','如何看待蓄势的《复仇者联盟游戏》','[{\"option_num\":5,\"option_id\":1,\"option_name\":\"还看什么，买爆就对了\"},{\"option_num\":5,\"option_id\":2,\"option_name\":\"观望后再决定是否入手\"},{\"option_num\":0,\"option_id\":3,\"option_name\":\"无所谓，佛系玩家\"}]',9,'2019-05-10','2019-05-18'),(7,'G胖','你会选择首发还是特卖时入手游戏','[{\"option_num\":5,\"option_id\":1,\"option_name\":\"早买早享受\"},{\"option_num\":1,\"option_id\":2,\"option_name\":\"晚买享折扣\"},{\"option_num\":4,\"option_id\":3,\"option_name\":\"不买免费送\"},{\"option_num\":3,\"option_id\":4,\"option_name\":\"我是土豪，只选择预购+终极豪华套装\"}]',2,'2019-05-07','2019-05-22'),(8,'奥斯卡','你如何看待2019届的奥斯卡','[{\"option_num\":6,\"option_id\":1,\"option_name\":\"奥斯卡正在变得更加包容，客观公正\"},{\"option_num\":2,\"option_id\":2,\"option_name\":\"带过最差的一届奥斯卡，权威受到政治挑战\"},{\"option_num\":1,\"option_id\":3,\"option_name\":\"没米下锅，矮子里拔高子，没更好的只能凑合\"}]',2,'2019-05-07','2019-05-22'),(10,'史蒂芬','你觉得云游戏，会在未来成为主流吗？','[{\"option_num\":3,\"option_id\":1,\"option_name\":\"云游戏降低了硬件入门门槛，也是游戏界的新风向\"},{\"option_num\":0,\"option_id\":2,\"option_name\":\"实体主机玩起来更踏实，游戏氛围也好\"},{\"option_num\":0,\"option_id\":3,\"option_name\":\"不关心具体的游戏形式，只关注能否获得更好的游戏体验\"}]',2,'2019-05-15','2019-05-22'),(11,'Tim','你觉得Epic与steam的竞争是否正当？','[{\"option_id\":1,\"option_name\":\"正当，Steam抽成过高，Epic是市场拯救者\",\"option_num\":0},{\"option_id\":2,\"option_name\":\"不正当，通过独占形式获得游戏损害了玩家利益\",\"option_num\":0},{\"option_id\":3,\"option_name\":\"没什么正当不正当，商业竞争而已\",\"option_num\":0}]',9,'2019-04-29','2019-05-05'),(12,'马化化','微信新添“访客功能”，你支持吗？','[{\"option_num\":4,\"option_id\":1,\"option_name\":\"哈哈哈 看上去不错\"},{\"option_num\":2,\"option_id\":2,\"option_name\":\"可以哦小伙砸\"},{\"option_num\":0,\"option_id\":3,\"option_name\":\"没什么大用处\"}]',2,'2019-05-11','2019-05-20'),(13,'步知迟','你是否支持“服务型游戏”？','[{\"option_id\":1,\"option_name\":\"支持，厂商多赚钱才能提供更好的游戏体验\",\"option_num\":0},{\"option_id\":2,\"option_name\":\"抵制，这是一种赤裸裸的圈钱行为\",\"option_num\":0},{\"option_id\":3,\"option_name\":\"无所谓，我不太在乎这个\",\"option_num\":0},{\"option_id\":4,\"option_name\":\"没事我有钱，随便怎么收\",\"option_num\":0}]',9,'2019-05-06','2019-05-14'),(14,'user','啦啦啦','[{\"option_id\":1,\"option_name\":\"qqq\",\"option_num\":0},{\"option_id\":2,\"option_name\":\"www\",\"option_num\":0}]',2,'2019-04-30','2019-05-30');
/*!40000 ALTER TABLE `t_vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-19 22:29:36
