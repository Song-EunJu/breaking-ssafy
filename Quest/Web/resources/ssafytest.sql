CREATE DATABASE  IF NOT EXISTS `ssafytest`;
USE `ssafytest`;

DROP TABLE IF EXISTS `mobile`;

CREATE TABLE `mobile` (
  `mobileCode` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `price` int NOT NULL,
  `company` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mobileCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `mobile` WRITE;
INSERT INTO `mobile` VALUES ('ios-2655','iphoneX',1700000,'애플'),('S236ZD95P','갤럭시S24',1475900,'삼성'),('NT550XDZ-AD5A','갤럭시 폴드',1729000,'삼성');
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `pw` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('admin','admin'),('ssafy','ssafy');
UNLOCK TABLES;
