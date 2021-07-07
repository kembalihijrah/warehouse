-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for warehouse
CREATE DATABASE IF NOT EXISTS `warehouse` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `warehouse`;

-- Dumping structure for table warehouse.archive
CREATE TABLE IF NOT EXISTS `archive` (
  `id_archive` varchar(50) NOT NULL,
  `name_archive` varchar(50) DEFAULT NULL,
  `date_archive` date DEFAULT NULL,
  `theme_archive` varchar(50) DEFAULT NULL,
  `bulk_archive` text DEFAULT NULL,
  PRIMARY KEY (`id_archive`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.archive: ~2 rows (approximately)
/*!40000 ALTER TABLE `archive` DISABLE KEYS */;
INSERT INTO `archive` (`id_archive`, `name_archive`, `date_archive`, `theme_archive`, `bulk_archive`) VALUES
	('archive0', 'Germany', '2021-06-04', 'Social', 'document0_document1_document2'),
	('archive1', 'Custom', '2021-06-04', 'Social', 'documentCustom');
/*!40000 ALTER TABLE `archive` ENABLE KEYS */;

-- Dumping structure for table warehouse.article
CREATE TABLE IF NOT EXISTS `article` (
  `id_article` varchar(50) NOT NULL,
  `name_article` varchar(50) DEFAULT NULL,
  `date_article` date DEFAULT NULL,
  `content_article` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.article: ~10 rows (approximately)
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`id_article`, `name_article`, `date_article`, `content_article`) VALUES
	('article0', 'Article0', '2021-06-04', 'Hello World!'),
	('article1', 'Article1', '2021-06-04', 'Hello World!'),
	('article2', 'Article2', '2021-06-04', 'Hello World!'),
	('article3', 'Article3', '2021-06-04', 'Hello World!'),
	('article4', 'Article4', '2021-06-04', 'Hello World!'),
	('article5', 'Article5', '2021-06-04', 'Hello World!'),
	('article6', 'Article6', '2021-06-04', 'Hello World!'),
	('article7', 'Article7', '2021-06-04', 'Hello World!'),
	('article8', 'Article8', '2021-06-04', 'Hello World!'),
	('article9', 'Article9', '2021-06-09', 'Hello_World_Underscore!');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- Dumping structure for table warehouse.auth
CREATE TABLE IF NOT EXISTS `auth` (
  `id_auth` varchar(50) NOT NULL,
  `username_auth` varchar(50) DEFAULT NULL,
  `password_auth` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_auth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.auth: ~9 rows (approximately)
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` (`id_auth`, `username_auth`, `password_auth`) VALUES
	('ID-ADMIN', 'admin', 'admin'),
	('ID-mrB', 'mrBigB', 'mrBigB'),
	('ID-SPECIAL', 'special', 'special'),
	('ID-test', 'test', 'test'),
	('ID-testing', 'testing', 'testing'),
	('ID-TRY', 'try', 'try'),
	('ID-TRY12', 'try12', 'try12'),
	('ID-USER', 'mrBlagi', 'mrBlagi');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;

-- Dumping structure for table warehouse.document
CREATE TABLE IF NOT EXISTS `document` (
  `id_document` varchar(50) NOT NULL,
  `name_document` varchar(50) DEFAULT NULL,
  `date_document` date DEFAULT NULL,
  `theme_document` varchar(50) DEFAULT NULL,
  `bulk_document` text DEFAULT NULL,
  PRIMARY KEY (`id_document`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.document: ~5 rows (approximately)
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` (`id_document`, `name_document`, `date_document`, `theme_document`, `bulk_document`) VALUES
	('document0', 'Normandian', '2021-06-04', 'WW2', 'article0_article1_article2'),
	('document1', 'Germany', '2021-06-04', 'Union', 'article3_article4_article5'),
	('document2', 'Nazi', '2021-06-04', 'Revolution', 'article6_article7_article8'),
	('documentCustom', 'Nazi', '2021-06-04', 'Custom', 'article9');
/*!40000 ALTER TABLE `document` ENABLE KEYS */;

-- Dumping structure for table warehouse.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `id_profile` varchar(50) NOT NULL,
  `name_profile` varchar(50) DEFAULT NULL,
  `date_profile` date DEFAULT NULL,
  `status_profile` varchar(50) DEFAULT NULL,
  `borrow_profile` text DEFAULT NULL,
  `motto_profile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_profile`),
  CONSTRAINT `FK_profile_auth` FOREIGN KEY (`id_profile`) REFERENCES `auth` (`id_auth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.profile: ~4 rows (approximately)
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` (`id_profile`, `name_profile`, `date_profile`, `status_profile`, `borrow_profile`, `motto_profile`) VALUES
	('ID-ADMIN', 'Admin', '2021-06-04', 'active', 'false', 'hello world'),
	('ID-SPECIAL', 'Special', '2021-06-04', 'active', 'false', 'hello special'),
	('ID-TRY', 'Try', '2021-06-04', 'active', 'false', 'helloTRYAGAIN'),
	('ID-USER', 'User', '2021-06-04', 'active', 'true', 'hello stickey');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;

-- Dumping structure for table warehouse.query
CREATE TABLE IF NOT EXISTS `query` (
  `id_query` varchar(50) NOT NULL,
  `name_query` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_query`),
  CONSTRAINT `FK_query_auth` FOREIGN KEY (`id_query`) REFERENCES `auth` (`id_auth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.query: ~4 rows (approximately)
/*!40000 ALTER TABLE `query` DISABLE KEYS */;
INSERT INTO `query` (`id_query`, `name_query`) VALUES
	('ID-ADMIN', 'archive0_document0_article0'),
	('ID-SPECIAL', 'archive0_document0_article0'),
	('ID-TRY', 'archive0_document0_article0'),
	('ID-USER', '__article0');
/*!40000 ALTER TABLE `query` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
