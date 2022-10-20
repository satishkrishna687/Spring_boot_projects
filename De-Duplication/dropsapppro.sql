-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               4.1.22-community-nt - MySQL Community Edition (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for dropsapppro
DROP DATABASE IF EXISTS `dropsapppro`;
CREATE DATABASE IF NOT EXISTS `dropsapppro` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dropsapppro`;


-- Dumping structure for table dropsapppro.algorithmcomparisonmodel
DROP TABLE IF EXISTS `algorithmcomparisonmodel`;
CREATE TABLE IF NOT EXISTS `algorithmcomparisonmodel` (
  `id` bigint(20) NOT NULL auto_increment,
  `algo1time` double default NULL,
  `algo2time` double default NULL,
  `level_algo1` double default NULL,
  `level_algo2` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.algorithmcomparisonmodel: 0 rows
DELETE FROM `algorithmcomparisonmodel`;
/*!40000 ALTER TABLE `algorithmcomparisonmodel` DISABLE KEYS */;
/*!40000 ALTER TABLE `algorithmcomparisonmodel` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.alivenodes_algo1
DROP TABLE IF EXISTS `alivenodes_algo1`;
CREATE TABLE IF NOT EXISTS `alivenodes_algo1` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ALIVENODES` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.alivenodes_algo1: ~15 rows (approximately)
DELETE FROM `alivenodes_algo1`;
/*!40000 ALTER TABLE `alivenodes_algo1` DISABLE KEYS */;
INSERT INTO `alivenodes_algo1` (`ITERATION`, `ALIVENODES`) VALUES
	(1, 50),
	(2, 50),
	(3, 50),
	(4, 50),
	(5, 50),
	(6, 50),
	(7, 50),
	(8, 50),
	(9, 50),
	(10, 50),
	(11, 50),
	(12, 50),
	(13, 50),
	(14, 50),
	(15, 50);
/*!40000 ALTER TABLE `alivenodes_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.alivenodes_algo2
DROP TABLE IF EXISTS `alivenodes_algo2`;
CREATE TABLE IF NOT EXISTS `alivenodes_algo2` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ALIVENODES` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.alivenodes_algo2: ~15 rows (approximately)
DELETE FROM `alivenodes_algo2`;
/*!40000 ALTER TABLE `alivenodes_algo2` DISABLE KEYS */;
INSERT INTO `alivenodes_algo2` (`ITERATION`, `ALIVENODES`) VALUES
	(1, 11),
	(2, 18),
	(3, 8),
	(4, 11),
	(5, 7),
	(6, 13),
	(7, 6),
	(8, 22),
	(9, 20),
	(10, 6),
	(11, 6),
	(12, 13),
	(13, 24),
	(14, 28),
	(15, 39);
/*!40000 ALTER TABLE `alivenodes_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.alivenodes_algo3
DROP TABLE IF EXISTS `alivenodes_algo3`;
CREATE TABLE IF NOT EXISTS `alivenodes_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ALIVENODES` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.alivenodes_algo3: ~15 rows (approximately)
DELETE FROM `alivenodes_algo3`;
/*!40000 ALTER TABLE `alivenodes_algo3` DISABLE KEYS */;
INSERT INTO `alivenodes_algo3` (`ITERATION`, `ALIVENODES`) VALUES
	(1, 10),
	(2, 18),
	(3, 7),
	(4, 8),
	(5, 7),
	(6, 7),
	(7, 6),
	(8, 19),
	(9, 9),
	(10, 6),
	(11, 6),
	(12, 13),
	(13, 24),
	(14, 25),
	(15, 26);
/*!40000 ALTER TABLE `alivenodes_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.alivenodes_algo4
DROP TABLE IF EXISTS `alivenodes_algo4`;
CREATE TABLE IF NOT EXISTS `alivenodes_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ALIVENODES` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.alivenodes_algo4: ~15 rows (approximately)
DELETE FROM `alivenodes_algo4`;
/*!40000 ALTER TABLE `alivenodes_algo4` DISABLE KEYS */;
INSERT INTO `alivenodes_algo4` (`ITERATION`, `ALIVENODES`) VALUES
	(1, 13),
	(2, 22),
	(3, 18),
	(4, 19),
	(5, 15),
	(6, 10),
	(7, 2),
	(8, 2),
	(9, 2),
	(10, 2),
	(11, 2),
	(12, 19),
	(13, 21),
	(14, 25),
	(15, 25);
/*!40000 ALTER TABLE `alivenodes_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.bestroutedetailid_sequence
DROP TABLE IF EXISTS `bestroutedetailid_sequence`;
CREATE TABLE IF NOT EXISTS `bestroutedetailid_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.bestroutedetailid_sequence: 0 rows
DELETE FROM `bestroutedetailid_sequence`;
/*!40000 ALTER TABLE `bestroutedetailid_sequence` DISABLE KEYS */;
INSERT INTO `bestroutedetailid_sequence` (`next_val`) VALUES
	(0);
/*!40000 ALTER TABLE `bestroutedetailid_sequence` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.bestroutedetails
DROP TABLE IF EXISTS `bestroutedetails`;
CREATE TABLE IF NOT EXISTS `bestroutedetails` (
  `bestroutedetailid` bigint(20) NOT NULL default '0',
  `nodeid` int(11) default NULL,
  `routeno_id` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`bestroutedetailid`),
  KEY `FKawltl7iciadf0pet13opyi2nd` (`routeno_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.bestroutedetails: 0 rows
DELETE FROM `bestroutedetails`;
/*!40000 ALTER TABLE `bestroutedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `bestroutedetails` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.bestroutereplicadetails
DROP TABLE IF EXISTS `bestroutereplicadetails`;
CREATE TABLE IF NOT EXISTS `bestroutereplicadetails` (
  `routeno` bigint(20) NOT NULL default '0',
  `replicanode` int(11) default NULL,
  `routenoreplica_id` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`routeno`),
  KEY `FKsnflrqf1ahqob7rnyl64g4hu0` (`routenoreplica_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.bestroutereplicadetails: 0 rows
DELETE FROM `bestroutereplicadetails`;
/*!40000 ALTER TABLE `bestroutereplicadetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `bestroutereplicadetails` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.bestroutereplicadetails_sequence
DROP TABLE IF EXISTS `bestroutereplicadetails_sequence`;
CREATE TABLE IF NOT EXISTS `bestroutereplicadetails_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.bestroutereplicadetails_sequence: 0 rows
DELETE FROM `bestroutereplicadetails_sequence`;
/*!40000 ALTER TABLE `bestroutereplicadetails_sequence` DISABLE KEYS */;
INSERT INTO `bestroutereplicadetails_sequence` (`next_val`) VALUES
	(0);
/*!40000 ALTER TABLE `bestroutereplicadetails_sequence` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node1
DROP TABLE IF EXISTS `buffer_node1`;
CREATE TABLE IF NOT EXISTS `buffer_node1` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node1: ~1 rows (approximately)
DELETE FROM `buffer_node1`;
/*!40000 ALTER TABLE `buffer_node1` DISABLE KEYS */;
INSERT INTO `buffer_node1` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node10
DROP TABLE IF EXISTS `buffer_node10`;
CREATE TABLE IF NOT EXISTS `buffer_node10` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node10: ~1 rows (approximately)
DELETE FROM `buffer_node10`;
/*!40000 ALTER TABLE `buffer_node10` DISABLE KEYS */;
INSERT INTO `buffer_node10` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node10` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node11
DROP TABLE IF EXISTS `buffer_node11`;
CREATE TABLE IF NOT EXISTS `buffer_node11` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node11: ~1 rows (approximately)
DELETE FROM `buffer_node11`;
/*!40000 ALTER TABLE `buffer_node11` DISABLE KEYS */;
INSERT INTO `buffer_node11` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node11` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node12
DROP TABLE IF EXISTS `buffer_node12`;
CREATE TABLE IF NOT EXISTS `buffer_node12` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node12: ~1 rows (approximately)
DELETE FROM `buffer_node12`;
/*!40000 ALTER TABLE `buffer_node12` DISABLE KEYS */;
INSERT INTO `buffer_node12` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node12` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node13
DROP TABLE IF EXISTS `buffer_node13`;
CREATE TABLE IF NOT EXISTS `buffer_node13` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node13: ~1 rows (approximately)
DELETE FROM `buffer_node13`;
/*!40000 ALTER TABLE `buffer_node13` DISABLE KEYS */;
INSERT INTO `buffer_node13` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node13` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node14
DROP TABLE IF EXISTS `buffer_node14`;
CREATE TABLE IF NOT EXISTS `buffer_node14` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node14: ~1 rows (approximately)
DELETE FROM `buffer_node14`;
/*!40000 ALTER TABLE `buffer_node14` DISABLE KEYS */;
INSERT INTO `buffer_node14` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node14` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node15
DROP TABLE IF EXISTS `buffer_node15`;
CREATE TABLE IF NOT EXISTS `buffer_node15` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node15: ~1 rows (approximately)
DELETE FROM `buffer_node15`;
/*!40000 ALTER TABLE `buffer_node15` DISABLE KEYS */;
INSERT INTO `buffer_node15` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node15` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node16
DROP TABLE IF EXISTS `buffer_node16`;
CREATE TABLE IF NOT EXISTS `buffer_node16` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node16: ~1 rows (approximately)
DELETE FROM `buffer_node16`;
/*!40000 ALTER TABLE `buffer_node16` DISABLE KEYS */;
INSERT INTO `buffer_node16` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node16` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node17
DROP TABLE IF EXISTS `buffer_node17`;
CREATE TABLE IF NOT EXISTS `buffer_node17` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node17: ~1 rows (approximately)
DELETE FROM `buffer_node17`;
/*!40000 ALTER TABLE `buffer_node17` DISABLE KEYS */;
INSERT INTO `buffer_node17` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node17` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node18
DROP TABLE IF EXISTS `buffer_node18`;
CREATE TABLE IF NOT EXISTS `buffer_node18` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node18: ~1 rows (approximately)
DELETE FROM `buffer_node18`;
/*!40000 ALTER TABLE `buffer_node18` DISABLE KEYS */;
INSERT INTO `buffer_node18` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node18` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node19
DROP TABLE IF EXISTS `buffer_node19`;
CREATE TABLE IF NOT EXISTS `buffer_node19` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node19: ~1 rows (approximately)
DELETE FROM `buffer_node19`;
/*!40000 ALTER TABLE `buffer_node19` DISABLE KEYS */;
INSERT INTO `buffer_node19` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node19` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node2
DROP TABLE IF EXISTS `buffer_node2`;
CREATE TABLE IF NOT EXISTS `buffer_node2` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node2: ~1 rows (approximately)
DELETE FROM `buffer_node2`;
/*!40000 ALTER TABLE `buffer_node2` DISABLE KEYS */;
INSERT INTO `buffer_node2` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node20
DROP TABLE IF EXISTS `buffer_node20`;
CREATE TABLE IF NOT EXISTS `buffer_node20` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node20: ~1 rows (approximately)
DELETE FROM `buffer_node20`;
/*!40000 ALTER TABLE `buffer_node20` DISABLE KEYS */;
INSERT INTO `buffer_node20` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node20` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node21
DROP TABLE IF EXISTS `buffer_node21`;
CREATE TABLE IF NOT EXISTS `buffer_node21` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node21: ~1 rows (approximately)
DELETE FROM `buffer_node21`;
/*!40000 ALTER TABLE `buffer_node21` DISABLE KEYS */;
INSERT INTO `buffer_node21` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node21` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node22
DROP TABLE IF EXISTS `buffer_node22`;
CREATE TABLE IF NOT EXISTS `buffer_node22` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node22: ~1 rows (approximately)
DELETE FROM `buffer_node22`;
/*!40000 ALTER TABLE `buffer_node22` DISABLE KEYS */;
INSERT INTO `buffer_node22` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node22` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node23
DROP TABLE IF EXISTS `buffer_node23`;
CREATE TABLE IF NOT EXISTS `buffer_node23` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node23: ~1 rows (approximately)
DELETE FROM `buffer_node23`;
/*!40000 ALTER TABLE `buffer_node23` DISABLE KEYS */;
INSERT INTO `buffer_node23` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node23` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node24
DROP TABLE IF EXISTS `buffer_node24`;
CREATE TABLE IF NOT EXISTS `buffer_node24` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node24: ~1 rows (approximately)
DELETE FROM `buffer_node24`;
/*!40000 ALTER TABLE `buffer_node24` DISABLE KEYS */;
INSERT INTO `buffer_node24` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node24` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node25
DROP TABLE IF EXISTS `buffer_node25`;
CREATE TABLE IF NOT EXISTS `buffer_node25` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node25: ~1 rows (approximately)
DELETE FROM `buffer_node25`;
/*!40000 ALTER TABLE `buffer_node25` DISABLE KEYS */;
INSERT INTO `buffer_node25` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node25` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node26
DROP TABLE IF EXISTS `buffer_node26`;
CREATE TABLE IF NOT EXISTS `buffer_node26` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node26: ~1 rows (approximately)
DELETE FROM `buffer_node26`;
/*!40000 ALTER TABLE `buffer_node26` DISABLE KEYS */;
INSERT INTO `buffer_node26` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node26` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node27
DROP TABLE IF EXISTS `buffer_node27`;
CREATE TABLE IF NOT EXISTS `buffer_node27` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node27: ~1 rows (approximately)
DELETE FROM `buffer_node27`;
/*!40000 ALTER TABLE `buffer_node27` DISABLE KEYS */;
INSERT INTO `buffer_node27` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node27` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node28
DROP TABLE IF EXISTS `buffer_node28`;
CREATE TABLE IF NOT EXISTS `buffer_node28` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node28: ~1 rows (approximately)
DELETE FROM `buffer_node28`;
/*!40000 ALTER TABLE `buffer_node28` DISABLE KEYS */;
INSERT INTO `buffer_node28` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node28` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node29
DROP TABLE IF EXISTS `buffer_node29`;
CREATE TABLE IF NOT EXISTS `buffer_node29` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node29: ~1 rows (approximately)
DELETE FROM `buffer_node29`;
/*!40000 ALTER TABLE `buffer_node29` DISABLE KEYS */;
INSERT INTO `buffer_node29` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node29` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node3
DROP TABLE IF EXISTS `buffer_node3`;
CREATE TABLE IF NOT EXISTS `buffer_node3` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node3: ~1 rows (approximately)
DELETE FROM `buffer_node3`;
/*!40000 ALTER TABLE `buffer_node3` DISABLE KEYS */;
INSERT INTO `buffer_node3` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node30
DROP TABLE IF EXISTS `buffer_node30`;
CREATE TABLE IF NOT EXISTS `buffer_node30` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node30: ~1 rows (approximately)
DELETE FROM `buffer_node30`;
/*!40000 ALTER TABLE `buffer_node30` DISABLE KEYS */;
INSERT INTO `buffer_node30` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node30` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node31
DROP TABLE IF EXISTS `buffer_node31`;
CREATE TABLE IF NOT EXISTS `buffer_node31` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node31: ~1 rows (approximately)
DELETE FROM `buffer_node31`;
/*!40000 ALTER TABLE `buffer_node31` DISABLE KEYS */;
INSERT INTO `buffer_node31` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node31` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node32
DROP TABLE IF EXISTS `buffer_node32`;
CREATE TABLE IF NOT EXISTS `buffer_node32` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node32: ~1 rows (approximately)
DELETE FROM `buffer_node32`;
/*!40000 ALTER TABLE `buffer_node32` DISABLE KEYS */;
INSERT INTO `buffer_node32` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node32` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node33
DROP TABLE IF EXISTS `buffer_node33`;
CREATE TABLE IF NOT EXISTS `buffer_node33` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node33: ~1 rows (approximately)
DELETE FROM `buffer_node33`;
/*!40000 ALTER TABLE `buffer_node33` DISABLE KEYS */;
INSERT INTO `buffer_node33` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node33` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node34
DROP TABLE IF EXISTS `buffer_node34`;
CREATE TABLE IF NOT EXISTS `buffer_node34` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node34: ~1 rows (approximately)
DELETE FROM `buffer_node34`;
/*!40000 ALTER TABLE `buffer_node34` DISABLE KEYS */;
INSERT INTO `buffer_node34` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node34` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node35
DROP TABLE IF EXISTS `buffer_node35`;
CREATE TABLE IF NOT EXISTS `buffer_node35` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node35: ~1 rows (approximately)
DELETE FROM `buffer_node35`;
/*!40000 ALTER TABLE `buffer_node35` DISABLE KEYS */;
INSERT INTO `buffer_node35` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node35` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node36
DROP TABLE IF EXISTS `buffer_node36`;
CREATE TABLE IF NOT EXISTS `buffer_node36` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node36: ~1 rows (approximately)
DELETE FROM `buffer_node36`;
/*!40000 ALTER TABLE `buffer_node36` DISABLE KEYS */;
INSERT INTO `buffer_node36` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node36` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node37
DROP TABLE IF EXISTS `buffer_node37`;
CREATE TABLE IF NOT EXISTS `buffer_node37` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node37: ~1 rows (approximately)
DELETE FROM `buffer_node37`;
/*!40000 ALTER TABLE `buffer_node37` DISABLE KEYS */;
INSERT INTO `buffer_node37` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node37` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node38
DROP TABLE IF EXISTS `buffer_node38`;
CREATE TABLE IF NOT EXISTS `buffer_node38` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node38: ~1 rows (approximately)
DELETE FROM `buffer_node38`;
/*!40000 ALTER TABLE `buffer_node38` DISABLE KEYS */;
INSERT INTO `buffer_node38` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node38` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node39
DROP TABLE IF EXISTS `buffer_node39`;
CREATE TABLE IF NOT EXISTS `buffer_node39` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node39: ~1 rows (approximately)
DELETE FROM `buffer_node39`;
/*!40000 ALTER TABLE `buffer_node39` DISABLE KEYS */;
INSERT INTO `buffer_node39` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node39` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node4
DROP TABLE IF EXISTS `buffer_node4`;
CREATE TABLE IF NOT EXISTS `buffer_node4` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node4: ~1 rows (approximately)
DELETE FROM `buffer_node4`;
/*!40000 ALTER TABLE `buffer_node4` DISABLE KEYS */;
INSERT INTO `buffer_node4` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node40
DROP TABLE IF EXISTS `buffer_node40`;
CREATE TABLE IF NOT EXISTS `buffer_node40` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node40: ~1 rows (approximately)
DELETE FROM `buffer_node40`;
/*!40000 ALTER TABLE `buffer_node40` DISABLE KEYS */;
INSERT INTO `buffer_node40` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node40` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node41
DROP TABLE IF EXISTS `buffer_node41`;
CREATE TABLE IF NOT EXISTS `buffer_node41` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node41: ~1 rows (approximately)
DELETE FROM `buffer_node41`;
/*!40000 ALTER TABLE `buffer_node41` DISABLE KEYS */;
INSERT INTO `buffer_node41` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node41` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node42
DROP TABLE IF EXISTS `buffer_node42`;
CREATE TABLE IF NOT EXISTS `buffer_node42` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node42: ~1 rows (approximately)
DELETE FROM `buffer_node42`;
/*!40000 ALTER TABLE `buffer_node42` DISABLE KEYS */;
INSERT INTO `buffer_node42` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node42` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node43
DROP TABLE IF EXISTS `buffer_node43`;
CREATE TABLE IF NOT EXISTS `buffer_node43` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node43: ~1 rows (approximately)
DELETE FROM `buffer_node43`;
/*!40000 ALTER TABLE `buffer_node43` DISABLE KEYS */;
INSERT INTO `buffer_node43` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node43` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node44
DROP TABLE IF EXISTS `buffer_node44`;
CREATE TABLE IF NOT EXISTS `buffer_node44` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node44: ~1 rows (approximately)
DELETE FROM `buffer_node44`;
/*!40000 ALTER TABLE `buffer_node44` DISABLE KEYS */;
INSERT INTO `buffer_node44` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node44` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node45
DROP TABLE IF EXISTS `buffer_node45`;
CREATE TABLE IF NOT EXISTS `buffer_node45` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node45: ~1 rows (approximately)
DELETE FROM `buffer_node45`;
/*!40000 ALTER TABLE `buffer_node45` DISABLE KEYS */;
INSERT INTO `buffer_node45` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node45` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node46
DROP TABLE IF EXISTS `buffer_node46`;
CREATE TABLE IF NOT EXISTS `buffer_node46` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node46: ~1 rows (approximately)
DELETE FROM `buffer_node46`;
/*!40000 ALTER TABLE `buffer_node46` DISABLE KEYS */;
INSERT INTO `buffer_node46` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node46` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node47
DROP TABLE IF EXISTS `buffer_node47`;
CREATE TABLE IF NOT EXISTS `buffer_node47` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node47: ~1 rows (approximately)
DELETE FROM `buffer_node47`;
/*!40000 ALTER TABLE `buffer_node47` DISABLE KEYS */;
INSERT INTO `buffer_node47` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node47` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node48
DROP TABLE IF EXISTS `buffer_node48`;
CREATE TABLE IF NOT EXISTS `buffer_node48` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node48: ~1 rows (approximately)
DELETE FROM `buffer_node48`;
/*!40000 ALTER TABLE `buffer_node48` DISABLE KEYS */;
INSERT INTO `buffer_node48` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node48` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node49
DROP TABLE IF EXISTS `buffer_node49`;
CREATE TABLE IF NOT EXISTS `buffer_node49` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node49: ~1 rows (approximately)
DELETE FROM `buffer_node49`;
/*!40000 ALTER TABLE `buffer_node49` DISABLE KEYS */;
INSERT INTO `buffer_node49` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node49` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node5
DROP TABLE IF EXISTS `buffer_node5`;
CREATE TABLE IF NOT EXISTS `buffer_node5` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node5: ~1 rows (approximately)
DELETE FROM `buffer_node5`;
/*!40000 ALTER TABLE `buffer_node5` DISABLE KEYS */;
INSERT INTO `buffer_node5` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node5` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node50
DROP TABLE IF EXISTS `buffer_node50`;
CREATE TABLE IF NOT EXISTS `buffer_node50` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node50: ~1 rows (approximately)
DELETE FROM `buffer_node50`;
/*!40000 ALTER TABLE `buffer_node50` DISABLE KEYS */;
INSERT INTO `buffer_node50` (`BUFFER`) VALUES
	(9999);
/*!40000 ALTER TABLE `buffer_node50` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node6
DROP TABLE IF EXISTS `buffer_node6`;
CREATE TABLE IF NOT EXISTS `buffer_node6` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node6: ~1 rows (approximately)
DELETE FROM `buffer_node6`;
/*!40000 ALTER TABLE `buffer_node6` DISABLE KEYS */;
INSERT INTO `buffer_node6` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node6` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node7
DROP TABLE IF EXISTS `buffer_node7`;
CREATE TABLE IF NOT EXISTS `buffer_node7` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node7: ~1 rows (approximately)
DELETE FROM `buffer_node7`;
/*!40000 ALTER TABLE `buffer_node7` DISABLE KEYS */;
INSERT INTO `buffer_node7` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node7` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node8
DROP TABLE IF EXISTS `buffer_node8`;
CREATE TABLE IF NOT EXISTS `buffer_node8` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node8: ~1 rows (approximately)
DELETE FROM `buffer_node8`;
/*!40000 ALTER TABLE `buffer_node8` DISABLE KEYS */;
INSERT INTO `buffer_node8` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node8` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.buffer_node9
DROP TABLE IF EXISTS `buffer_node9`;
CREATE TABLE IF NOT EXISTS `buffer_node9` (
  `BUFFER` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.buffer_node9: ~1 rows (approximately)
DELETE FROM `buffer_node9`;
/*!40000 ALTER TABLE `buffer_node9` DISABLE KEYS */;
INSERT INTO `buffer_node9` (`BUFFER`) VALUES
	(0);
/*!40000 ALTER TABLE `buffer_node9` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.comparealgoresults
DROP TABLE IF EXISTS `comparealgoresults`;
CREATE TABLE IF NOT EXISTS `comparealgoresults` (
  `id` bigint(20) NOT NULL auto_increment,
  `between_centrality_time` double default NULL,
  `closeness_centrality_time` double default NULL,
  `e_centrality_time` double default NULL,
  `enc_bytes_between_centrality` double default NULL,
  `enc_bytes_closeness_centrality` double default NULL,
  `enc_bytesecentrality` double default NULL,
  `enc_bytes_optimized` double default NULL,
  `memory_consumed_between_centrality` double default NULL,
  `memory_consumed_closeness_centrality` double default NULL,
  `memory_consumedecentrality` double default NULL,
  `memory_consumed_optimized` double default NULL,
  `optimized_time` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.comparealgoresults: 5 rows
DELETE FROM `comparealgoresults`;
/*!40000 ALTER TABLE `comparealgoresults` DISABLE KEYS */;
INSERT INTO `comparealgoresults` (`id`, `between_centrality_time`, `closeness_centrality_time`, `e_centrality_time`, `enc_bytes_between_centrality`, `enc_bytes_closeness_centrality`, `enc_bytesecentrality`, `enc_bytes_optimized`, `memory_consumed_between_centrality`, `memory_consumed_closeness_centrality`, `memory_consumedecentrality`, `memory_consumed_optimized`, `optimized_time`) VALUES
	(1, 76.024, 76.024, 76.024, 8353, 8353, 8353, 65941, 37906768, 37906768, 37906768, 19001928, 48.806),
	(2, 44.937, 44.937, 44.937, 8377, 8377, 8377, 65937, 33513472, 33513472, 33513472, 13339656, 21.514),
	(3, 36.24, 36.24, 36.24, 8364, 8364, 8364, 65953, 47011328, 47011328, 47011328, 25820864, 7.719),
	(4, 8.838, 8.838, 8.838, 3330, 3330, 3330, 24469, 9619256, 18324936, 9619256, 9619256, 2.958),
	(5, 0.272, 1.985, 0.272, 950, 950, 950, 5347, -6162048, 19690384, -6162048, -6162048, 0.272);
/*!40000 ALTER TABLE `comparealgoresults` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.deadnodes_algo1
DROP TABLE IF EXISTS `deadnodes_algo1`;
CREATE TABLE IF NOT EXISTS `deadnodes_algo1` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `DEADNODES` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.deadnodes_algo1: ~15 rows (approximately)
DELETE FROM `deadnodes_algo1`;
/*!40000 ALTER TABLE `deadnodes_algo1` DISABLE KEYS */;
INSERT INTO `deadnodes_algo1` (`ITERATION`, `DEADNODES`) VALUES
	(1, 0),
	(2, 0),
	(3, 0),
	(4, 0),
	(5, 0),
	(6, 0),
	(7, 0),
	(8, 0),
	(9, 0),
	(10, 0),
	(11, 0),
	(12, 0),
	(13, 0),
	(14, 0),
	(15, 0);
/*!40000 ALTER TABLE `deadnodes_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.deadnodes_algo2
DROP TABLE IF EXISTS `deadnodes_algo2`;
CREATE TABLE IF NOT EXISTS `deadnodes_algo2` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `DEADNODES` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.deadnodes_algo2: ~15 rows (approximately)
DELETE FROM `deadnodes_algo2`;
/*!40000 ALTER TABLE `deadnodes_algo2` DISABLE KEYS */;
INSERT INTO `deadnodes_algo2` (`ITERATION`, `DEADNODES`) VALUES
	(1, 39),
	(2, 32),
	(3, 42),
	(4, 39),
	(5, 43),
	(6, 37),
	(7, 44),
	(8, 28),
	(9, 30),
	(10, 44),
	(11, 44),
	(12, 37),
	(13, 26),
	(14, 22),
	(15, 11);
/*!40000 ALTER TABLE `deadnodes_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.deadnodes_algo3
DROP TABLE IF EXISTS `deadnodes_algo3`;
CREATE TABLE IF NOT EXISTS `deadnodes_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `DEADNODES` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.deadnodes_algo3: ~15 rows (approximately)
DELETE FROM `deadnodes_algo3`;
/*!40000 ALTER TABLE `deadnodes_algo3` DISABLE KEYS */;
INSERT INTO `deadnodes_algo3` (`ITERATION`, `DEADNODES`) VALUES
	(1, 40),
	(2, 32),
	(3, 43),
	(4, 42),
	(5, 43),
	(6, 43),
	(7, 44),
	(8, 31),
	(9, 41),
	(10, 44),
	(11, 44),
	(12, 37),
	(13, 26),
	(14, 25),
	(15, 24);
/*!40000 ALTER TABLE `deadnodes_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.deadnodes_algo4
DROP TABLE IF EXISTS `deadnodes_algo4`;
CREATE TABLE IF NOT EXISTS `deadnodes_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `DEADNODES` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.deadnodes_algo4: ~15 rows (approximately)
DELETE FROM `deadnodes_algo4`;
/*!40000 ALTER TABLE `deadnodes_algo4` DISABLE KEYS */;
INSERT INTO `deadnodes_algo4` (`ITERATION`, `DEADNODES`) VALUES
	(1, 37),
	(2, 28),
	(3, 32),
	(4, 31),
	(5, 35),
	(6, 40),
	(7, 48),
	(8, 48),
	(9, 48),
	(10, 48),
	(11, 48),
	(12, 31),
	(13, 29),
	(14, 25),
	(15, 25);
/*!40000 ALTER TABLE `deadnodes_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_algo1
DROP TABLE IF EXISTS `energy_algo1`;
CREATE TABLE IF NOT EXISTS `energy_algo1` (
  `ENERGY` double default NULL,
  `ITERATION` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_algo1: ~15 rows (approximately)
DELETE FROM `energy_algo1`;
/*!40000 ALTER TABLE `energy_algo1` DISABLE KEYS */;
INSERT INTO `energy_algo1` (`ENERGY`, `ITERATION`) VALUES
	(1403.5899625507, 1),
	(1465.94137949758, 2),
	(15119.6222457652, 3),
	(14100.1675629433, 4),
	(28346.2639586909, 5),
	(1597.75229020114, 6),
	(2375.52833451801, 7),
	(1639.10476400841, 8),
	(1615.85232386266, 9),
	(3856.16605514662, 10),
	(3808.76876221735, 11),
	(1442.62608701617, 12),
	(1011.29225917247, 13),
	(846.050266281705, 14),
	(1066.70532193182, 15);
/*!40000 ALTER TABLE `energy_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_algo2
DROP TABLE IF EXISTS `energy_algo2`;
CREATE TABLE IF NOT EXISTS `energy_algo2` (
  `ENERGY` double default NULL,
  `ITERATION` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_algo2: ~15 rows (approximately)
DELETE FROM `energy_algo2`;
/*!40000 ALTER TABLE `energy_algo2` DISABLE KEYS */;
INSERT INTO `energy_algo2` (`ENERGY`, `ITERATION`) VALUES
	(2437.45037719491, 1),
	(8593.36581721498, 2),
	(150036.780335559, 3),
	(166133.370110391, 4),
	(312946.862260956, 5),
	(20059.8666168719, 6),
	(27610.8898506495, 7),
	(11698.4346768478, 8),
	(11698.0473060402, 9),
	(26213.7426035129, 10),
	(19143.0862061131, 11),
	(14229.5357616334, 12),
	(14777.7953718415, 13),
	(11723.595904848, 14),
	(10095.9124983864, 15);
/*!40000 ALTER TABLE `energy_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_algo3
DROP TABLE IF EXISTS `energy_algo3`;
CREATE TABLE IF NOT EXISTS `energy_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ENERGY` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_algo3: ~15 rows (approximately)
DELETE FROM `energy_algo3`;
/*!40000 ALTER TABLE `energy_algo3` DISABLE KEYS */;
INSERT INTO `energy_algo3` (`ITERATION`, `ENERGY`) VALUES
	(1, 2484.72409735395),
	(2, 15808.2469027027),
	(3, 224491.210000702),
	(4, 227323.957389143),
	(5, 394925.745598942),
	(6, 27662.0325462942),
	(7, 37237.3353160633),
	(8, 16378.5727410119),
	(9, 16379.2506399253),
	(10, 33966.600521873),
	(11, 20801.7440789287),
	(12, 14730.6015318038),
	(13, 15928.8113094971),
	(14, 12804.939745981),
	(15, 11912.1736728159);
/*!40000 ALTER TABLE `energy_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_algo4
DROP TABLE IF EXISTS `energy_algo4`;
CREATE TABLE IF NOT EXISTS `energy_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ENERGY` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_algo4: ~15 rows (approximately)
DELETE FROM `energy_algo4`;
/*!40000 ALTER TABLE `energy_algo4` DISABLE KEYS */;
INSERT INTO `energy_algo4` (`ITERATION`, `ENERGY`) VALUES
	(1, 16378.7664264157),
	(2, 16375.5706172524),
	(3, 16377.1201004831),
	(4, 16378.379055608),
	(5, 16377.9916848004),
	(6, 15627.8125099154),
	(7, 9339.96666477828),
	(8, 9339.96666477828),
	(9, 9339.96666477828),
	(10, 9339.96666477828),
	(11, 9339.96666477828),
	(12, 16380.7032804541),
	(13, 18252.8849933136),
	(14, 16233.6025342821),
	(15, 23302.320301346);
/*!40000 ALTER TABLE `energy_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node1
DROP TABLE IF EXISTS `energy_node1`;
CREATE TABLE IF NOT EXISTS `energy_node1` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node1: ~1 rows (approximately)
DELETE FROM `energy_node1`;
/*!40000 ALTER TABLE `energy_node1` DISABLE KEYS */;
INSERT INTO `energy_node1` (`ENERGY`) VALUES
	(28.2731293445608);
/*!40000 ALTER TABLE `energy_node1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node10
DROP TABLE IF EXISTS `energy_node10`;
CREATE TABLE IF NOT EXISTS `energy_node10` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node10: ~1 rows (approximately)
DELETE FROM `energy_node10`;
/*!40000 ALTER TABLE `energy_node10` DISABLE KEYS */;
INSERT INTO `energy_node10` (`ENERGY`) VALUES
	(28.2731293445608);
/*!40000 ALTER TABLE `energy_node10` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node11
DROP TABLE IF EXISTS `energy_node11`;
CREATE TABLE IF NOT EXISTS `energy_node11` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node11: ~1 rows (approximately)
DELETE FROM `energy_node11`;
/*!40000 ALTER TABLE `energy_node11` DISABLE KEYS */;
INSERT INTO `energy_node11` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node11` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node12
DROP TABLE IF EXISTS `energy_node12`;
CREATE TABLE IF NOT EXISTS `energy_node12` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node12: ~1 rows (approximately)
DELETE FROM `energy_node12`;
/*!40000 ALTER TABLE `energy_node12` DISABLE KEYS */;
INSERT INTO `energy_node12` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node12` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node13
DROP TABLE IF EXISTS `energy_node13`;
CREATE TABLE IF NOT EXISTS `energy_node13` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node13: ~1 rows (approximately)
DELETE FROM `energy_node13`;
/*!40000 ALTER TABLE `energy_node13` DISABLE KEYS */;
INSERT INTO `energy_node13` (`ENERGY`) VALUES
	(28.2731293445608);
/*!40000 ALTER TABLE `energy_node13` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node14
DROP TABLE IF EXISTS `energy_node14`;
CREATE TABLE IF NOT EXISTS `energy_node14` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node14: ~1 rows (approximately)
DELETE FROM `energy_node14`;
/*!40000 ALTER TABLE `energy_node14` DISABLE KEYS */;
INSERT INTO `energy_node14` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node14` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node15
DROP TABLE IF EXISTS `energy_node15`;
CREATE TABLE IF NOT EXISTS `energy_node15` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node15: ~1 rows (approximately)
DELETE FROM `energy_node15`;
/*!40000 ALTER TABLE `energy_node15` DISABLE KEYS */;
INSERT INTO `energy_node15` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node15` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node16
DROP TABLE IF EXISTS `energy_node16`;
CREATE TABLE IF NOT EXISTS `energy_node16` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node16: ~1 rows (approximately)
DELETE FROM `energy_node16`;
/*!40000 ALTER TABLE `energy_node16` DISABLE KEYS */;
INSERT INTO `energy_node16` (`ENERGY`) VALUES
	(28.2731293445608);
/*!40000 ALTER TABLE `energy_node16` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node17
DROP TABLE IF EXISTS `energy_node17`;
CREATE TABLE IF NOT EXISTS `energy_node17` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node17: ~1 rows (approximately)
DELETE FROM `energy_node17`;
/*!40000 ALTER TABLE `energy_node17` DISABLE KEYS */;
INSERT INTO `energy_node17` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node17` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node18
DROP TABLE IF EXISTS `energy_node18`;
CREATE TABLE IF NOT EXISTS `energy_node18` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node18: ~1 rows (approximately)
DELETE FROM `energy_node18`;
/*!40000 ALTER TABLE `energy_node18` DISABLE KEYS */;
INSERT INTO `energy_node18` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node18` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node19
DROP TABLE IF EXISTS `energy_node19`;
CREATE TABLE IF NOT EXISTS `energy_node19` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node19: ~1 rows (approximately)
DELETE FROM `energy_node19`;
/*!40000 ALTER TABLE `energy_node19` DISABLE KEYS */;
INSERT INTO `energy_node19` (`ENERGY`) VALUES
	(28.2731293445608);
/*!40000 ALTER TABLE `energy_node19` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node2
DROP TABLE IF EXISTS `energy_node2`;
CREATE TABLE IF NOT EXISTS `energy_node2` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node2: ~1 rows (approximately)
DELETE FROM `energy_node2`;
/*!40000 ALTER TABLE `energy_node2` DISABLE KEYS */;
INSERT INTO `energy_node2` (`ENERGY`) VALUES
	(28.0238634184597);
/*!40000 ALTER TABLE `energy_node2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node20
DROP TABLE IF EXISTS `energy_node20`;
CREATE TABLE IF NOT EXISTS `energy_node20` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node20: ~1 rows (approximately)
DELETE FROM `energy_node20`;
/*!40000 ALTER TABLE `energy_node20` DISABLE KEYS */;
INSERT INTO `energy_node20` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node20` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node21
DROP TABLE IF EXISTS `energy_node21`;
CREATE TABLE IF NOT EXISTS `energy_node21` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node21: ~1 rows (approximately)
DELETE FROM `energy_node21`;
/*!40000 ALTER TABLE `energy_node21` DISABLE KEYS */;
INSERT INTO `energy_node21` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node21` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node22
DROP TABLE IF EXISTS `energy_node22`;
CREATE TABLE IF NOT EXISTS `energy_node22` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node22: ~1 rows (approximately)
DELETE FROM `energy_node22`;
/*!40000 ALTER TABLE `energy_node22` DISABLE KEYS */;
INSERT INTO `energy_node22` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node22` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node23
DROP TABLE IF EXISTS `energy_node23`;
CREATE TABLE IF NOT EXISTS `energy_node23` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node23: ~1 rows (approximately)
DELETE FROM `energy_node23`;
/*!40000 ALTER TABLE `energy_node23` DISABLE KEYS */;
INSERT INTO `energy_node23` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node23` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node24
DROP TABLE IF EXISTS `energy_node24`;
CREATE TABLE IF NOT EXISTS `energy_node24` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node24: ~1 rows (approximately)
DELETE FROM `energy_node24`;
/*!40000 ALTER TABLE `energy_node24` DISABLE KEYS */;
INSERT INTO `energy_node24` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node24` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node25
DROP TABLE IF EXISTS `energy_node25`;
CREATE TABLE IF NOT EXISTS `energy_node25` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node25: ~1 rows (approximately)
DELETE FROM `energy_node25`;
/*!40000 ALTER TABLE `energy_node25` DISABLE KEYS */;
INSERT INTO `energy_node25` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node25` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node26
DROP TABLE IF EXISTS `energy_node26`;
CREATE TABLE IF NOT EXISTS `energy_node26` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node26: ~1 rows (approximately)
DELETE FROM `energy_node26`;
/*!40000 ALTER TABLE `energy_node26` DISABLE KEYS */;
INSERT INTO `energy_node26` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node26` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node27
DROP TABLE IF EXISTS `energy_node27`;
CREATE TABLE IF NOT EXISTS `energy_node27` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node27: ~1 rows (approximately)
DELETE FROM `energy_node27`;
/*!40000 ALTER TABLE `energy_node27` DISABLE KEYS */;
INSERT INTO `energy_node27` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node27` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node28
DROP TABLE IF EXISTS `energy_node28`;
CREATE TABLE IF NOT EXISTS `energy_node28` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node28: ~1 rows (approximately)
DELETE FROM `energy_node28`;
/*!40000 ALTER TABLE `energy_node28` DISABLE KEYS */;
INSERT INTO `energy_node28` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node28` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node29
DROP TABLE IF EXISTS `energy_node29`;
CREATE TABLE IF NOT EXISTS `energy_node29` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node29: ~1 rows (approximately)
DELETE FROM `energy_node29`;
/*!40000 ALTER TABLE `energy_node29` DISABLE KEYS */;
INSERT INTO `energy_node29` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node29` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node3
DROP TABLE IF EXISTS `energy_node3`;
CREATE TABLE IF NOT EXISTS `energy_node3` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node3: ~1 rows (approximately)
DELETE FROM `energy_node3`;
/*!40000 ALTER TABLE `energy_node3` DISABLE KEYS */;
INSERT INTO `energy_node3` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node30
DROP TABLE IF EXISTS `energy_node30`;
CREATE TABLE IF NOT EXISTS `energy_node30` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node30: ~1 rows (approximately)
DELETE FROM `energy_node30`;
/*!40000 ALTER TABLE `energy_node30` DISABLE KEYS */;
INSERT INTO `energy_node30` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node30` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node31
DROP TABLE IF EXISTS `energy_node31`;
CREATE TABLE IF NOT EXISTS `energy_node31` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node31: ~1 rows (approximately)
DELETE FROM `energy_node31`;
/*!40000 ALTER TABLE `energy_node31` DISABLE KEYS */;
INSERT INTO `energy_node31` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node31` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node32
DROP TABLE IF EXISTS `energy_node32`;
CREATE TABLE IF NOT EXISTS `energy_node32` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node32: ~1 rows (approximately)
DELETE FROM `energy_node32`;
/*!40000 ALTER TABLE `energy_node32` DISABLE KEYS */;
INSERT INTO `energy_node32` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node32` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node33
DROP TABLE IF EXISTS `energy_node33`;
CREATE TABLE IF NOT EXISTS `energy_node33` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node33: ~1 rows (approximately)
DELETE FROM `energy_node33`;
/*!40000 ALTER TABLE `energy_node33` DISABLE KEYS */;
INSERT INTO `energy_node33` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node33` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node34
DROP TABLE IF EXISTS `energy_node34`;
CREATE TABLE IF NOT EXISTS `energy_node34` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node34: ~1 rows (approximately)
DELETE FROM `energy_node34`;
/*!40000 ALTER TABLE `energy_node34` DISABLE KEYS */;
INSERT INTO `energy_node34` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node34` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node35
DROP TABLE IF EXISTS `energy_node35`;
CREATE TABLE IF NOT EXISTS `energy_node35` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node35: ~1 rows (approximately)
DELETE FROM `energy_node35`;
/*!40000 ALTER TABLE `energy_node35` DISABLE KEYS */;
INSERT INTO `energy_node35` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node35` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node36
DROP TABLE IF EXISTS `energy_node36`;
CREATE TABLE IF NOT EXISTS `energy_node36` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node36: ~1 rows (approximately)
DELETE FROM `energy_node36`;
/*!40000 ALTER TABLE `energy_node36` DISABLE KEYS */;
INSERT INTO `energy_node36` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node36` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node37
DROP TABLE IF EXISTS `energy_node37`;
CREATE TABLE IF NOT EXISTS `energy_node37` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node37: ~1 rows (approximately)
DELETE FROM `energy_node37`;
/*!40000 ALTER TABLE `energy_node37` DISABLE KEYS */;
INSERT INTO `energy_node37` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node37` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node38
DROP TABLE IF EXISTS `energy_node38`;
CREATE TABLE IF NOT EXISTS `energy_node38` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node38: ~1 rows (approximately)
DELETE FROM `energy_node38`;
/*!40000 ALTER TABLE `energy_node38` DISABLE KEYS */;
INSERT INTO `energy_node38` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node38` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node39
DROP TABLE IF EXISTS `energy_node39`;
CREATE TABLE IF NOT EXISTS `energy_node39` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node39: ~1 rows (approximately)
DELETE FROM `energy_node39`;
/*!40000 ALTER TABLE `energy_node39` DISABLE KEYS */;
INSERT INTO `energy_node39` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node39` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node4
DROP TABLE IF EXISTS `energy_node4`;
CREATE TABLE IF NOT EXISTS `energy_node4` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node4: ~1 rows (approximately)
DELETE FROM `energy_node4`;
/*!40000 ALTER TABLE `energy_node4` DISABLE KEYS */;
INSERT INTO `energy_node4` (`ENERGY`) VALUES
	(28.2731293445608);
/*!40000 ALTER TABLE `energy_node4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node40
DROP TABLE IF EXISTS `energy_node40`;
CREATE TABLE IF NOT EXISTS `energy_node40` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node40: ~1 rows (approximately)
DELETE FROM `energy_node40`;
/*!40000 ALTER TABLE `energy_node40` DISABLE KEYS */;
INSERT INTO `energy_node40` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node40` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node41
DROP TABLE IF EXISTS `energy_node41`;
CREATE TABLE IF NOT EXISTS `energy_node41` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node41: ~1 rows (approximately)
DELETE FROM `energy_node41`;
/*!40000 ALTER TABLE `energy_node41` DISABLE KEYS */;
INSERT INTO `energy_node41` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node41` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node42
DROP TABLE IF EXISTS `energy_node42`;
CREATE TABLE IF NOT EXISTS `energy_node42` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node42: ~1 rows (approximately)
DELETE FROM `energy_node42`;
/*!40000 ALTER TABLE `energy_node42` DISABLE KEYS */;
INSERT INTO `energy_node42` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node42` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node43
DROP TABLE IF EXISTS `energy_node43`;
CREATE TABLE IF NOT EXISTS `energy_node43` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node43: ~1 rows (approximately)
DELETE FROM `energy_node43`;
/*!40000 ALTER TABLE `energy_node43` DISABLE KEYS */;
INSERT INTO `energy_node43` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node43` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node44
DROP TABLE IF EXISTS `energy_node44`;
CREATE TABLE IF NOT EXISTS `energy_node44` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node44: ~1 rows (approximately)
DELETE FROM `energy_node44`;
/*!40000 ALTER TABLE `energy_node44` DISABLE KEYS */;
INSERT INTO `energy_node44` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node44` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node45
DROP TABLE IF EXISTS `energy_node45`;
CREATE TABLE IF NOT EXISTS `energy_node45` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node45: ~1 rows (approximately)
DELETE FROM `energy_node45`;
/*!40000 ALTER TABLE `energy_node45` DISABLE KEYS */;
INSERT INTO `energy_node45` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node45` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node46
DROP TABLE IF EXISTS `energy_node46`;
CREATE TABLE IF NOT EXISTS `energy_node46` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node46: ~1 rows (approximately)
DELETE FROM `energy_node46`;
/*!40000 ALTER TABLE `energy_node46` DISABLE KEYS */;
INSERT INTO `energy_node46` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node46` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node47
DROP TABLE IF EXISTS `energy_node47`;
CREATE TABLE IF NOT EXISTS `energy_node47` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node47: ~1 rows (approximately)
DELETE FROM `energy_node47`;
/*!40000 ALTER TABLE `energy_node47` DISABLE KEYS */;
INSERT INTO `energy_node47` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node47` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node48
DROP TABLE IF EXISTS `energy_node48`;
CREATE TABLE IF NOT EXISTS `energy_node48` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node48: ~1 rows (approximately)
DELETE FROM `energy_node48`;
/*!40000 ALTER TABLE `energy_node48` DISABLE KEYS */;
INSERT INTO `energy_node48` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node48` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node49
DROP TABLE IF EXISTS `energy_node49`;
CREATE TABLE IF NOT EXISTS `energy_node49` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node49: ~1 rows (approximately)
DELETE FROM `energy_node49`;
/*!40000 ALTER TABLE `energy_node49` DISABLE KEYS */;
INSERT INTO `energy_node49` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node49` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node5
DROP TABLE IF EXISTS `energy_node5`;
CREATE TABLE IF NOT EXISTS `energy_node5` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node5: ~1 rows (approximately)
DELETE FROM `energy_node5`;
/*!40000 ALTER TABLE `energy_node5` DISABLE KEYS */;
INSERT INTO `energy_node5` (`ENERGY`) VALUES
	(28.0238634184597);
/*!40000 ALTER TABLE `energy_node5` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node50
DROP TABLE IF EXISTS `energy_node50`;
CREATE TABLE IF NOT EXISTS `energy_node50` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node50: ~1 rows (approximately)
DELETE FROM `energy_node50`;
/*!40000 ALTER TABLE `energy_node50` DISABLE KEYS */;
INSERT INTO `energy_node50` (`ENERGY`) VALUES
	(9999);
/*!40000 ALTER TABLE `energy_node50` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node6
DROP TABLE IF EXISTS `energy_node6`;
CREATE TABLE IF NOT EXISTS `energy_node6` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node6: ~1 rows (approximately)
DELETE FROM `energy_node6`;
/*!40000 ALTER TABLE `energy_node6` DISABLE KEYS */;
INSERT INTO `energy_node6` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node6` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node7
DROP TABLE IF EXISTS `energy_node7`;
CREATE TABLE IF NOT EXISTS `energy_node7` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node7: ~1 rows (approximately)
DELETE FROM `energy_node7`;
/*!40000 ALTER TABLE `energy_node7` DISABLE KEYS */;
INSERT INTO `energy_node7` (`ENERGY`) VALUES
	(28.2731293445608);
/*!40000 ALTER TABLE `energy_node7` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node8
DROP TABLE IF EXISTS `energy_node8`;
CREATE TABLE IF NOT EXISTS `energy_node8` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node8: ~1 rows (approximately)
DELETE FROM `energy_node8`;
/*!40000 ALTER TABLE `energy_node8` DISABLE KEYS */;
INSERT INTO `energy_node8` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node8` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.energy_node9
DROP TABLE IF EXISTS `energy_node9`;
CREATE TABLE IF NOT EXISTS `energy_node9` (
  `ENERGY` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.energy_node9: ~1 rows (approximately)
DELETE FROM `energy_node9`;
/*!40000 ALTER TABLE `energy_node9` DISABLE KEYS */;
INSERT INTO `energy_node9` (`ENERGY`) VALUES
	(23.5682823361402);
/*!40000 ALTER TABLE `energy_node9` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.filechunkid_sequence
DROP TABLE IF EXISTS `filechunkid_sequence`;
CREATE TABLE IF NOT EXISTS `filechunkid_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.filechunkid_sequence: 0 rows
DELETE FROM `filechunkid_sequence`;
/*!40000 ALTER TABLE `filechunkid_sequence` DISABLE KEYS */;
INSERT INTO `filechunkid_sequence` (`next_val`) VALUES
	(0);
/*!40000 ALTER TABLE `filechunkid_sequence` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.filechunkstorage
DROP TABLE IF EXISTS `filechunkstorage`;
CREATE TABLE IF NOT EXISTS `filechunkstorage` (
  `filechunkid` bigint(20) NOT NULL default '0',
  `algorithm_name` varchar(255) default NULL,
  `datachunk` text,
  `encryptedchunk` text,
  `node_id` int(11) default NULL,
  `sequeneno` int(11) default NULL,
  `filestorage_id` bigint(20) NOT NULL default '0',
  `page_no` int(11) default NULL,
  `session_id` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  PRIMARY KEY  (`filechunkid`),
  KEY `FKelatkw2md96635p5och8ypqwb` (`filestorage_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.filechunkstorage: 0 rows
DELETE FROM `filechunkstorage`;
/*!40000 ALTER TABLE `filechunkstorage` DISABLE KEYS */;
/*!40000 ALTER TABLE `filechunkstorage` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.fileencstorage
DROP TABLE IF EXISTS `fileencstorage`;
CREATE TABLE IF NOT EXISTS `fileencstorage` (
  `filestorageid` bigint(20) NOT NULL default '0',
  `data` longblob,
  `filename` varchar(255) default NULL,
  `filetype` varchar(255) default NULL,
  `orginalname` varchar(255) default NULL,
  `secretkey` varchar(255) default NULL,
  `filestorage_id` bigint(20) default NULL,
  PRIMARY KEY  (`filestorageid`),
  KEY `FKroxpuoogeo5kwussx87gko23p` (`filestorage_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.fileencstorage: 0 rows
DELETE FROM `fileencstorage`;
/*!40000 ALTER TABLE `fileencstorage` DISABLE KEYS */;
/*!40000 ALTER TABLE `fileencstorage` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.fileencstorageid_sequence
DROP TABLE IF EXISTS `fileencstorageid_sequence`;
CREATE TABLE IF NOT EXISTS `fileencstorageid_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.fileencstorageid_sequence: 0 rows
DELETE FROM `fileencstorageid_sequence`;
/*!40000 ALTER TABLE `fileencstorageid_sequence` DISABLE KEYS */;
INSERT INTO `fileencstorageid_sequence` (`next_val`) VALUES
	(0);
/*!40000 ALTER TABLE `fileencstorageid_sequence` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.filereplicaid_sequence
DROP TABLE IF EXISTS `filereplicaid_sequence`;
CREATE TABLE IF NOT EXISTS `filereplicaid_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.filereplicaid_sequence: 0 rows
DELETE FROM `filereplicaid_sequence`;
/*!40000 ALTER TABLE `filereplicaid_sequence` DISABLE KEYS */;
INSERT INTO `filereplicaid_sequence` (`next_val`) VALUES
	(0);
/*!40000 ALTER TABLE `filereplicaid_sequence` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.filereplicastorage
DROP TABLE IF EXISTS `filereplicastorage`;
CREATE TABLE IF NOT EXISTS `filereplicastorage` (
  `filereplicaid` bigint(20) NOT NULL default '0',
  `algorithm_name` varchar(255) default NULL,
  `datachunk` text,
  `encryptedchunk` text,
  `node_id` int(11) default NULL,
  `sequeneno` int(11) default NULL,
  `filestoragereplica_id` bigint(20) NOT NULL default '0',
  `page_no` int(11) default NULL,
  `session_id` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  PRIMARY KEY  (`filereplicaid`),
  KEY `FKfv7r762urnxsqjof1o6qf678x` (`filestoragereplica_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.filereplicastorage: 0 rows
DELETE FROM `filereplicastorage`;
/*!40000 ALTER TABLE `filereplicastorage` DISABLE KEYS */;
/*!40000 ALTER TABLE `filereplicastorage` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.filestorage
DROP TABLE IF EXISTS `filestorage`;
CREATE TABLE IF NOT EXISTS `filestorage` (
  `filestorageid` bigint(20) NOT NULL default '0',
  `data` longblob,
  `filename` varchar(255) default NULL,
  `filetype` varchar(255) default NULL,
  `orginalname` varchar(255) default NULL,
  `secretkey` varchar(255) default NULL,
  `filestorage_id` bigint(20) default NULL,
  PRIMARY KEY  (`filestorageid`),
  KEY `FKtdgm2nm0l4bxsmmk45j5u8wo8` (`filestorage_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.filestorage: 0 rows
DELETE FROM `filestorage`;
/*!40000 ALTER TABLE `filestorage` DISABLE KEYS */;
/*!40000 ALTER TABLE `filestorage` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.filestorageid_sequence
DROP TABLE IF EXISTS `filestorageid_sequence`;
CREATE TABLE IF NOT EXISTS `filestorageid_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.filestorageid_sequence: 0 rows
DELETE FROM `filestorageid_sequence`;
/*!40000 ALTER TABLE `filestorageid_sequence` DISABLE KEYS */;
INSERT INTO `filestorageid_sequence` (`next_val`) VALUES
	(0);
/*!40000 ALTER TABLE `filestorageid_sequence` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.hops_algo1
DROP TABLE IF EXISTS `hops_algo1`;
CREATE TABLE IF NOT EXISTS `hops_algo1` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `HOPS` int(11) default NULL,
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.hops_algo1: ~15 rows (approximately)
DELETE FROM `hops_algo1`;
/*!40000 ALTER TABLE `hops_algo1` DISABLE KEYS */;
INSERT INTO `hops_algo1` (`ITERATION`, `HOPS`) VALUES
	(1, 109),
	(2, 73),
	(3, 72),
	(4, 182),
	(5, 180),
	(6, 73),
	(7, 88),
	(8, 75),
	(9, 67),
	(10, 63),
	(11, 115),
	(12, 73),
	(13, 47),
	(14, 40),
	(15, 42);
/*!40000 ALTER TABLE `hops_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.hops_algo2
DROP TABLE IF EXISTS `hops_algo2`;
CREATE TABLE IF NOT EXISTS `hops_algo2` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `HOPS` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.hops_algo2: ~15 rows (approximately)
DELETE FROM `hops_algo2`;
/*!40000 ALTER TABLE `hops_algo2` DISABLE KEYS */;
INSERT INTO `hops_algo2` (`ITERATION`, `HOPS`) VALUES
	(1, 1189),
	(2, 505),
	(3, 505),
	(4, 1141),
	(5, 841),
	(6, 627),
	(7, 152),
	(8, 389),
	(9, 793),
	(10, 882),
	(11, 1522),
	(12, 864),
	(13, 636),
	(14, 509),
	(15, 368);
/*!40000 ALTER TABLE `hops_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.hops_algo3
DROP TABLE IF EXISTS `hops_algo3`;
CREATE TABLE IF NOT EXISTS `hops_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `HOPS` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.hops_algo3: ~15 rows (approximately)
DELETE FROM `hops_algo3`;
/*!40000 ALTER TABLE `hops_algo3` DISABLE KEYS */;
INSERT INTO `hops_algo3` (`ITERATION`, `HOPS`) VALUES
	(1, 707),
	(2, 1480),
	(3, 921),
	(4, 660),
	(5, 155),
	(6, 707),
	(7, 1196),
	(8, 1217),
	(9, 1886),
	(10, 1192),
	(11, 1603),
	(12, 707),
	(13, 685),
	(14, 552),
	(15, 433);
/*!40000 ALTER TABLE `hops_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.hops_algo4
DROP TABLE IF EXISTS `hops_algo4`;
CREATE TABLE IF NOT EXISTS `hops_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `HOPS` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.hops_algo4: ~15 rows (approximately)
DELETE FROM `hops_algo4`;
/*!40000 ALTER TABLE `hops_algo4` DISABLE KEYS */;
INSERT INTO `hops_algo4` (`ITERATION`, `HOPS`) VALUES
	(1, 707),
	(2, 707),
	(3, 707),
	(4, 707),
	(5, 707),
	(6, 675),
	(7, 404),
	(8, 404),
	(9, 404),
	(10, 404),
	(11, 404),
	(12, 707),
	(13, 787),
	(14, 698),
	(15, 843);
/*!40000 ALTER TABLE `hops_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.ipadressmaintainer
DROP TABLE IF EXISTS `ipadressmaintainer`;
CREATE TABLE IF NOT EXISTS `ipadressmaintainer` (
  `NODEID` int(11) NOT NULL default '0',
  `IPADDRESS` text NOT NULL,
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.ipadressmaintainer: ~2 rows (approximately)
DELETE FROM `ipadressmaintainer`;
/*!40000 ALTER TABLE `ipadressmaintainer` DISABLE KEYS */;
INSERT INTO `ipadressmaintainer` (`NODEID`, `IPADDRESS`) VALUES
	(2, '192.178.90.08'),
	(3, '178.89.80.100');
/*!40000 ALTER TABLE `ipadressmaintainer` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.lifetime_algo1
DROP TABLE IF EXISTS `lifetime_algo1`;
CREATE TABLE IF NOT EXISTS `lifetime_algo1` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `LIFETIME` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.lifetime_algo1: ~15 rows (approximately)
DELETE FROM `lifetime_algo1`;
/*!40000 ALTER TABLE `lifetime_algo1` DISABLE KEYS */;
INSERT INTO `lifetime_algo1` (`ITERATION`, `LIFETIME`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(5, 1),
	(6, 1),
	(7, 1),
	(8, 1),
	(9, 1),
	(10, 1),
	(11, 1),
	(12, 1),
	(13, 1),
	(14, 1),
	(15, 1);
/*!40000 ALTER TABLE `lifetime_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.lifetime_algo2
DROP TABLE IF EXISTS `lifetime_algo2`;
CREATE TABLE IF NOT EXISTS `lifetime_algo2` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `LIFETIME` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.lifetime_algo2: ~15 rows (approximately)
DELETE FROM `lifetime_algo2`;
/*!40000 ALTER TABLE `lifetime_algo2` DISABLE KEYS */;
INSERT INTO `lifetime_algo2` (`ITERATION`, `LIFETIME`) VALUES
	(1, 0.136363636363636),
	(2, 0.785714285714286),
	(3, 0.666666666666667),
	(4, 0.136363636363636),
	(5, 0.136363636363636),
	(6, 0.351351351351351),
	(7, 0.282051282051282),
	(8, 0.5625),
	(9, 0.19047619047619),
	(10, 0.282051282051282),
	(11, 0.162790697674419),
	(12, 0.351351351351351),
	(13, 0.923076923076923),
	(14, 1),
	(15, 1);
/*!40000 ALTER TABLE `lifetime_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.lifetime_algo3
DROP TABLE IF EXISTS `lifetime_algo3`;
CREATE TABLE IF NOT EXISTS `lifetime_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `LIFETIME` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.lifetime_algo3: ~15 rows (approximately)
DELETE FROM `lifetime_algo3`;
/*!40000 ALTER TABLE `lifetime_algo3` DISABLE KEYS */;
INSERT INTO `lifetime_algo3` (`ITERATION`, `LIFETIME`) VALUES
	(1, 0.136363636363636),
	(2, 0.612903225806452),
	(3, 0.219512195121951),
	(4, 0.136363636363636),
	(5, 0.123),
	(6, 0.351351351351351),
	(7, 0.25),
	(8, 0.5625),
	(9, 0.162790697674419),
	(10, 0.19047619047619),
	(11, 0.162790697674419),
	(12, 0.162790697674419),
	(13, 0.923076923076923),
	(14, 1),
	(15, 1);
/*!40000 ALTER TABLE `lifetime_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.lifetime_algo4
DROP TABLE IF EXISTS `lifetime_algo4`;
CREATE TABLE IF NOT EXISTS `lifetime_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `LIFETIME` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.lifetime_algo4: ~15 rows (approximately)
DELETE FROM `lifetime_algo4`;
/*!40000 ALTER TABLE `lifetime_algo4` DISABLE KEYS */;
INSERT INTO `lifetime_algo4` (`ITERATION`, `LIFETIME`) VALUES
	(1, 0.351351351351351),
	(2, 0.785714285714286),
	(3, 0.5625),
	(4, 0.612903225806452),
	(5, 0.428571428571429),
	(6, 0.25),
	(7, 0.0416666666666667),
	(8, 0.0416666666666667),
	(9, 0.0416666666666667),
	(10, 0.0416666666666667),
	(11, 0.0416666666666667),
	(12, 0.612903225806452),
	(13, 0.724137931034483),
	(14, 1),
	(15, 1);
/*!40000 ALTER TABLE `lifetime_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.lineartopology
DROP TABLE IF EXISTS `lineartopology`;
CREATE TABLE IF NOT EXISTS `lineartopology` (
  `NODEID` int(11) NOT NULL default '0',
  `XCORDINATE` double NOT NULL default '0',
  `YCORDINATE` double NOT NULL default '0',
  `BUFFER` int(11) NOT NULL default '0',
  `NETWORKCOST` int(11) NOT NULL default '0',
  `POWERAVAILABLE` double NOT NULL default '0',
  `ENERGY` double NOT NULL default '0',
  `TRUSTLEVEL` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.lineartopology: ~50 rows (approximately)
DELETE FROM `lineartopology`;
/*!40000 ALTER TABLE `lineartopology` DISABLE KEYS */;
INSERT INTO `lineartopology` (`NODEID`, `XCORDINATE`, `YCORDINATE`, `BUFFER`, `NETWORKCOST`, `POWERAVAILABLE`, `ENERGY`, `TRUSTLEVEL`) VALUES
	(1, 0, 0, 9999, 9999, 9999, 9999, 0),
	(2, 30, 0, 9999, 9999, 9999, 9999, 0),
	(3, 60, 0, 9999, 9999, 9999, 9999, 0),
	(4, 90, 0, 9999, 9999, 9999, 9999, 0),
	(5, 120, 0, 9999, 9999, 9999, 9999, 0),
	(6, 150, 0, 9999, 9999, 9999, 9999, 0),
	(7, 180, 0, 9999, 9999, 9999, 9999, 0),
	(8, 210, 0, 9999, 9999, 9999, 9999, 0),
	(9, 240, 0, 9999, 9999, 9999, 9999, 0),
	(10, 270, 0, 9999, 9999, 9999, 9999, 0),
	(11, 300, 0, 9999, 9999, 9999, 9999, 0),
	(12, 330, 0, 9999, 9999, 9999, 9999, 0),
	(13, 360, 0, 9999, 9999, 9999, 9999, 0),
	(14, 390, 0, 9999, 9999, 9999, 9999, 0),
	(15, 420, 0, 9999, 9999, 9999, 9999, 0),
	(16, 450, 0, 9999, 9999, 9999, 9999, 0),
	(17, 480, 0, 9999, 9999, 9999, 9999, 0),
	(18, 510, 0, 9999, 9999, 9999, 9999, 0),
	(19, 540, 0, 9999, 9999, 9999, 9999, 0),
	(20, 570, 0, 9999, 9999, 9999, 9999, 0),
	(21, 600, 0, 9999, 9999, 9999, 9999, 0),
	(22, 630, 0, 9999, 9999, 9999, 9999, 0),
	(23, 660, 0, 9999, 9999, 9999, 9999, 0),
	(24, 690, 0, 9999, 9999, 9999, 9999, 0),
	(25, 720, 0, 9999, 9999, 9999, 9999, 0),
	(26, 750, 0, 9999, 9999, 9999, 9999, 0),
	(27, 780, 0, 9999, 9999, 9999, 9999, 0),
	(28, 810, 0, 9999, 9999, 9999, 9999, 0),
	(29, 840, 0, 9999, 9999, 9999, 9999, 0),
	(30, 870, 0, 9999, 9999, 9999, 9999, 0),
	(31, 900, 0, 9999, 9999, 9999, 9999, 0),
	(32, 930, 0, 9999, 9999, 9999, 9999, 0),
	(33, 960, 0, 9999, 9999, 9999, 9999, 0),
	(34, 990, 0, 9999, 9999, 9999, 9999, 0),
	(35, 1020, 0, 9999, 9999, 9999, 9999, 0),
	(36, 1050, 0, 9999, 9999, 9999, 9999, 0),
	(37, 1080, 0, 9999, 9999, 9999, 9999, 0),
	(38, 1110, 0, 9999, 9999, 9999, 9999, 0),
	(39, 1140, 0, 9999, 9999, 9999, 9999, 0),
	(40, 1170, 0, 9999, 9999, 9999, 9999, 0),
	(41, 1200, 0, 9999, 9999, 9999, 9999, 0),
	(42, 1230, 0, 9999, 9999, 9999, 9999, 0),
	(43, 1260, 0, 9999, 9999, 9999, 9999, 0),
	(44, 1290, 0, 9999, 9999, 9999, 9999, 0),
	(45, 1320, 0, 9999, 9999, 9999, 9999, 0),
	(46, 1350, 0, 9999, 9999, 9999, 9999, 0),
	(47, 1380, 0, 9999, 9999, 9999, 9999, 0),
	(48, 1410, 0, 9999, 9999, 9999, 9999, 0),
	(49, 1440, 0, 9999, 9999, 9999, 9999, 0),
	(50, 1470, 0, 9999, 9999, 9999, 9999, 0);
/*!40000 ALTER TABLE `lineartopology` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node1
DROP TABLE IF EXISTS `linear_rt_node1`;
CREATE TABLE IF NOT EXISTS `linear_rt_node1` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node1: ~50 rows (approximately)
DELETE FROM `linear_rt_node1`;
/*!40000 ALTER TABLE `linear_rt_node1` DISABLE KEYS */;
INSERT INTO `linear_rt_node1` (`NODEID`, `DISTANCE`) VALUES
	(1, 0),
	(2, 30),
	(3, 60),
	(4, 90),
	(5, 120),
	(6, 150),
	(7, 180),
	(8, 210),
	(9, 240),
	(10, 270),
	(11, 300),
	(12, 330),
	(13, 360),
	(14, 390),
	(15, 420),
	(16, 450),
	(17, 480),
	(18, 510),
	(19, 540),
	(20, 570),
	(21, 600),
	(22, 630),
	(23, 660),
	(24, 690),
	(25, 720),
	(26, 750),
	(27, 780),
	(28, 810),
	(29, 840),
	(30, 870),
	(31, 900),
	(32, 930),
	(33, 960),
	(34, 990),
	(35, 1020),
	(36, 1050),
	(37, 1080),
	(38, 1110),
	(39, 1140),
	(40, 1170),
	(41, 1200),
	(42, 1230),
	(43, 1260),
	(44, 1290),
	(45, 1320),
	(46, 1350),
	(47, 1380),
	(48, 1410),
	(49, 1440),
	(50, 1470);
/*!40000 ALTER TABLE `linear_rt_node1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node10
DROP TABLE IF EXISTS `linear_rt_node10`;
CREATE TABLE IF NOT EXISTS `linear_rt_node10` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node10: ~50 rows (approximately)
DELETE FROM `linear_rt_node10`;
/*!40000 ALTER TABLE `linear_rt_node10` DISABLE KEYS */;
INSERT INTO `linear_rt_node10` (`NODEID`, `DISTANCE`) VALUES
	(1, 270),
	(2, 240),
	(3, 210),
	(4, 180),
	(5, 150),
	(6, 120),
	(7, 90),
	(8, 60),
	(9, 30),
	(10, 0),
	(11, 30),
	(12, 60),
	(13, 90),
	(14, 120),
	(15, 150),
	(16, 180),
	(17, 210),
	(18, 240),
	(19, 270),
	(20, 300),
	(21, 330),
	(22, 360),
	(23, 390),
	(24, 420),
	(25, 450),
	(26, 480),
	(27, 510),
	(28, 540),
	(29, 570),
	(30, 600),
	(31, 630),
	(32, 660),
	(33, 690),
	(34, 720),
	(35, 750),
	(36, 780),
	(37, 810),
	(38, 840),
	(39, 870),
	(40, 900),
	(41, 930),
	(42, 960),
	(43, 990),
	(44, 1020),
	(45, 1050),
	(46, 1080),
	(47, 1110),
	(48, 1140),
	(49, 1170),
	(50, 1200);
/*!40000 ALTER TABLE `linear_rt_node10` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node11
DROP TABLE IF EXISTS `linear_rt_node11`;
CREATE TABLE IF NOT EXISTS `linear_rt_node11` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node11: ~50 rows (approximately)
DELETE FROM `linear_rt_node11`;
/*!40000 ALTER TABLE `linear_rt_node11` DISABLE KEYS */;
INSERT INTO `linear_rt_node11` (`NODEID`, `DISTANCE`) VALUES
	(1, 300),
	(2, 270),
	(3, 240),
	(4, 210),
	(5, 180),
	(6, 150),
	(7, 120),
	(8, 90),
	(9, 60),
	(10, 30),
	(11, 0),
	(12, 30),
	(13, 60),
	(14, 90),
	(15, 120),
	(16, 150),
	(17, 180),
	(18, 210),
	(19, 240),
	(20, 270),
	(21, 300),
	(22, 330),
	(23, 360),
	(24, 390),
	(25, 420),
	(26, 450),
	(27, 480),
	(28, 510),
	(29, 540),
	(30, 570),
	(31, 600),
	(32, 630),
	(33, 660),
	(34, 690),
	(35, 720),
	(36, 750),
	(37, 780),
	(38, 810),
	(39, 840),
	(40, 870),
	(41, 900),
	(42, 930),
	(43, 960),
	(44, 990),
	(45, 1020),
	(46, 1050),
	(47, 1080),
	(48, 1110),
	(49, 1140),
	(50, 1170);
/*!40000 ALTER TABLE `linear_rt_node11` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node12
DROP TABLE IF EXISTS `linear_rt_node12`;
CREATE TABLE IF NOT EXISTS `linear_rt_node12` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node12: ~50 rows (approximately)
DELETE FROM `linear_rt_node12`;
/*!40000 ALTER TABLE `linear_rt_node12` DISABLE KEYS */;
INSERT INTO `linear_rt_node12` (`NODEID`, `DISTANCE`) VALUES
	(1, 330),
	(2, 300),
	(3, 270),
	(4, 240),
	(5, 210),
	(6, 180),
	(7, 150),
	(8, 120),
	(9, 90),
	(10, 60),
	(11, 30),
	(12, 0),
	(13, 30),
	(14, 60),
	(15, 90),
	(16, 120),
	(17, 150),
	(18, 180),
	(19, 210),
	(20, 240),
	(21, 270),
	(22, 300),
	(23, 330),
	(24, 360),
	(25, 390),
	(26, 420),
	(27, 450),
	(28, 480),
	(29, 510),
	(30, 540),
	(31, 570),
	(32, 600),
	(33, 630),
	(34, 660),
	(35, 690),
	(36, 720),
	(37, 750),
	(38, 780),
	(39, 810),
	(40, 840),
	(41, 870),
	(42, 900),
	(43, 930),
	(44, 960),
	(45, 990),
	(46, 1020),
	(47, 1050),
	(48, 1080),
	(49, 1110),
	(50, 1140);
/*!40000 ALTER TABLE `linear_rt_node12` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node13
DROP TABLE IF EXISTS `linear_rt_node13`;
CREATE TABLE IF NOT EXISTS `linear_rt_node13` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node13: ~50 rows (approximately)
DELETE FROM `linear_rt_node13`;
/*!40000 ALTER TABLE `linear_rt_node13` DISABLE KEYS */;
INSERT INTO `linear_rt_node13` (`NODEID`, `DISTANCE`) VALUES
	(1, 360),
	(2, 330),
	(3, 300),
	(4, 270),
	(5, 240),
	(6, 210),
	(7, 180),
	(8, 150),
	(9, 120),
	(10, 90),
	(11, 60),
	(12, 30),
	(13, 0),
	(14, 30),
	(15, 60),
	(16, 90),
	(17, 120),
	(18, 150),
	(19, 180),
	(20, 210),
	(21, 240),
	(22, 270),
	(23, 300),
	(24, 330),
	(25, 360),
	(26, 390),
	(27, 420),
	(28, 450),
	(29, 480),
	(30, 510),
	(31, 540),
	(32, 570),
	(33, 600),
	(34, 630),
	(35, 660),
	(36, 690),
	(37, 720),
	(38, 750),
	(39, 780),
	(40, 810),
	(41, 840),
	(42, 870),
	(43, 900),
	(44, 930),
	(45, 960),
	(46, 990),
	(47, 1020),
	(48, 1050),
	(49, 1080),
	(50, 1110);
/*!40000 ALTER TABLE `linear_rt_node13` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node14
DROP TABLE IF EXISTS `linear_rt_node14`;
CREATE TABLE IF NOT EXISTS `linear_rt_node14` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node14: ~50 rows (approximately)
DELETE FROM `linear_rt_node14`;
/*!40000 ALTER TABLE `linear_rt_node14` DISABLE KEYS */;
INSERT INTO `linear_rt_node14` (`NODEID`, `DISTANCE`) VALUES
	(1, 390),
	(2, 360),
	(3, 330),
	(4, 300),
	(5, 270),
	(6, 240),
	(7, 210),
	(8, 180),
	(9, 150),
	(10, 120),
	(11, 90),
	(12, 60),
	(13, 30),
	(14, 0),
	(15, 30),
	(16, 60),
	(17, 90),
	(18, 120),
	(19, 150),
	(20, 180),
	(21, 210),
	(22, 240),
	(23, 270),
	(24, 300),
	(25, 330),
	(26, 360),
	(27, 390),
	(28, 420),
	(29, 450),
	(30, 480),
	(31, 510),
	(32, 540),
	(33, 570),
	(34, 600),
	(35, 630),
	(36, 660),
	(37, 690),
	(38, 720),
	(39, 750),
	(40, 780),
	(41, 810),
	(42, 840),
	(43, 870),
	(44, 900),
	(45, 930),
	(46, 960),
	(47, 990),
	(48, 1020),
	(49, 1050),
	(50, 1080);
/*!40000 ALTER TABLE `linear_rt_node14` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node15
DROP TABLE IF EXISTS `linear_rt_node15`;
CREATE TABLE IF NOT EXISTS `linear_rt_node15` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node15: ~50 rows (approximately)
DELETE FROM `linear_rt_node15`;
/*!40000 ALTER TABLE `linear_rt_node15` DISABLE KEYS */;
INSERT INTO `linear_rt_node15` (`NODEID`, `DISTANCE`) VALUES
	(1, 420),
	(2, 390),
	(3, 360),
	(4, 330),
	(5, 300),
	(6, 270),
	(7, 240),
	(8, 210),
	(9, 180),
	(10, 150),
	(11, 120),
	(12, 90),
	(13, 60),
	(14, 30),
	(15, 0),
	(16, 30),
	(17, 60),
	(18, 90),
	(19, 120),
	(20, 150),
	(21, 180),
	(22, 210),
	(23, 240),
	(24, 270),
	(25, 300),
	(26, 330),
	(27, 360),
	(28, 390),
	(29, 420),
	(30, 450),
	(31, 480),
	(32, 510),
	(33, 540),
	(34, 570),
	(35, 600),
	(36, 630),
	(37, 660),
	(38, 690),
	(39, 720),
	(40, 750),
	(41, 780),
	(42, 810),
	(43, 840),
	(44, 870),
	(45, 900),
	(46, 930),
	(47, 960),
	(48, 990),
	(49, 1020),
	(50, 1050);
/*!40000 ALTER TABLE `linear_rt_node15` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node16
DROP TABLE IF EXISTS `linear_rt_node16`;
CREATE TABLE IF NOT EXISTS `linear_rt_node16` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node16: ~50 rows (approximately)
DELETE FROM `linear_rt_node16`;
/*!40000 ALTER TABLE `linear_rt_node16` DISABLE KEYS */;
INSERT INTO `linear_rt_node16` (`NODEID`, `DISTANCE`) VALUES
	(1, 450),
	(2, 420),
	(3, 390),
	(4, 360),
	(5, 330),
	(6, 300),
	(7, 270),
	(8, 240),
	(9, 210),
	(10, 180),
	(11, 150),
	(12, 120),
	(13, 90),
	(14, 60),
	(15, 30),
	(16, 0),
	(17, 30),
	(18, 60),
	(19, 90),
	(20, 120),
	(21, 150),
	(22, 180),
	(23, 210),
	(24, 240),
	(25, 270),
	(26, 300),
	(27, 330),
	(28, 360),
	(29, 390),
	(30, 420),
	(31, 450),
	(32, 480),
	(33, 510),
	(34, 540),
	(35, 570),
	(36, 600),
	(37, 630),
	(38, 660),
	(39, 690),
	(40, 720),
	(41, 750),
	(42, 780),
	(43, 810),
	(44, 840),
	(45, 870),
	(46, 900),
	(47, 930),
	(48, 960),
	(49, 990),
	(50, 1020);
/*!40000 ALTER TABLE `linear_rt_node16` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node17
DROP TABLE IF EXISTS `linear_rt_node17`;
CREATE TABLE IF NOT EXISTS `linear_rt_node17` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node17: ~50 rows (approximately)
DELETE FROM `linear_rt_node17`;
/*!40000 ALTER TABLE `linear_rt_node17` DISABLE KEYS */;
INSERT INTO `linear_rt_node17` (`NODEID`, `DISTANCE`) VALUES
	(1, 480),
	(2, 450),
	(3, 420),
	(4, 390),
	(5, 360),
	(6, 330),
	(7, 300),
	(8, 270),
	(9, 240),
	(10, 210),
	(11, 180),
	(12, 150),
	(13, 120),
	(14, 90),
	(15, 60),
	(16, 30),
	(17, 0),
	(18, 30),
	(19, 60),
	(20, 90),
	(21, 120),
	(22, 150),
	(23, 180),
	(24, 210),
	(25, 240),
	(26, 270),
	(27, 300),
	(28, 330),
	(29, 360),
	(30, 390),
	(31, 420),
	(32, 450),
	(33, 480),
	(34, 510),
	(35, 540),
	(36, 570),
	(37, 600),
	(38, 630),
	(39, 660),
	(40, 690),
	(41, 720),
	(42, 750),
	(43, 780),
	(44, 810),
	(45, 840),
	(46, 870),
	(47, 900),
	(48, 930),
	(49, 960),
	(50, 990);
/*!40000 ALTER TABLE `linear_rt_node17` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node18
DROP TABLE IF EXISTS `linear_rt_node18`;
CREATE TABLE IF NOT EXISTS `linear_rt_node18` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node18: ~50 rows (approximately)
DELETE FROM `linear_rt_node18`;
/*!40000 ALTER TABLE `linear_rt_node18` DISABLE KEYS */;
INSERT INTO `linear_rt_node18` (`NODEID`, `DISTANCE`) VALUES
	(1, 510),
	(2, 480),
	(3, 450),
	(4, 420),
	(5, 390),
	(6, 360),
	(7, 330),
	(8, 300),
	(9, 270),
	(10, 240),
	(11, 210),
	(12, 180),
	(13, 150),
	(14, 120),
	(15, 90),
	(16, 60),
	(17, 30),
	(18, 0),
	(19, 30),
	(20, 60),
	(21, 90),
	(22, 120),
	(23, 150),
	(24, 180),
	(25, 210),
	(26, 240),
	(27, 270),
	(28, 300),
	(29, 330),
	(30, 360),
	(31, 390),
	(32, 420),
	(33, 450),
	(34, 480),
	(35, 510),
	(36, 540),
	(37, 570),
	(38, 600),
	(39, 630),
	(40, 660),
	(41, 690),
	(42, 720),
	(43, 750),
	(44, 780),
	(45, 810),
	(46, 840),
	(47, 870),
	(48, 900),
	(49, 930),
	(50, 960);
/*!40000 ALTER TABLE `linear_rt_node18` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node19
DROP TABLE IF EXISTS `linear_rt_node19`;
CREATE TABLE IF NOT EXISTS `linear_rt_node19` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node19: ~50 rows (approximately)
DELETE FROM `linear_rt_node19`;
/*!40000 ALTER TABLE `linear_rt_node19` DISABLE KEYS */;
INSERT INTO `linear_rt_node19` (`NODEID`, `DISTANCE`) VALUES
	(1, 540),
	(2, 510),
	(3, 480),
	(4, 450),
	(5, 420),
	(6, 390),
	(7, 360),
	(8, 330),
	(9, 300),
	(10, 270),
	(11, 240),
	(12, 210),
	(13, 180),
	(14, 150),
	(15, 120),
	(16, 90),
	(17, 60),
	(18, 30),
	(19, 0),
	(20, 30),
	(21, 60),
	(22, 90),
	(23, 120),
	(24, 150),
	(25, 180),
	(26, 210),
	(27, 240),
	(28, 270),
	(29, 300),
	(30, 330),
	(31, 360),
	(32, 390),
	(33, 420),
	(34, 450),
	(35, 480),
	(36, 510),
	(37, 540),
	(38, 570),
	(39, 600),
	(40, 630),
	(41, 660),
	(42, 690),
	(43, 720),
	(44, 750),
	(45, 780),
	(46, 810),
	(47, 840),
	(48, 870),
	(49, 900),
	(50, 930);
/*!40000 ALTER TABLE `linear_rt_node19` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node2
DROP TABLE IF EXISTS `linear_rt_node2`;
CREATE TABLE IF NOT EXISTS `linear_rt_node2` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node2: ~50 rows (approximately)
DELETE FROM `linear_rt_node2`;
/*!40000 ALTER TABLE `linear_rt_node2` DISABLE KEYS */;
INSERT INTO `linear_rt_node2` (`NODEID`, `DISTANCE`) VALUES
	(1, 30),
	(2, 0),
	(3, 30),
	(4, 60),
	(5, 90),
	(6, 120),
	(7, 150),
	(8, 180),
	(9, 210),
	(10, 240),
	(11, 270),
	(12, 300),
	(13, 330),
	(14, 360),
	(15, 390),
	(16, 420),
	(17, 450),
	(18, 480),
	(19, 510),
	(20, 540),
	(21, 570),
	(22, 600),
	(23, 630),
	(24, 660),
	(25, 690),
	(26, 720),
	(27, 750),
	(28, 780),
	(29, 810),
	(30, 840),
	(31, 870),
	(32, 900),
	(33, 930),
	(34, 960),
	(35, 990),
	(36, 1020),
	(37, 1050),
	(38, 1080),
	(39, 1110),
	(40, 1140),
	(41, 1170),
	(42, 1200),
	(43, 1230),
	(44, 1260),
	(45, 1290),
	(46, 1320),
	(47, 1350),
	(48, 1380),
	(49, 1410),
	(50, 1440);
/*!40000 ALTER TABLE `linear_rt_node2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node20
DROP TABLE IF EXISTS `linear_rt_node20`;
CREATE TABLE IF NOT EXISTS `linear_rt_node20` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node20: ~50 rows (approximately)
DELETE FROM `linear_rt_node20`;
/*!40000 ALTER TABLE `linear_rt_node20` DISABLE KEYS */;
INSERT INTO `linear_rt_node20` (`NODEID`, `DISTANCE`) VALUES
	(1, 570),
	(2, 540),
	(3, 510),
	(4, 480),
	(5, 450),
	(6, 420),
	(7, 390),
	(8, 360),
	(9, 330),
	(10, 300),
	(11, 270),
	(12, 240),
	(13, 210),
	(14, 180),
	(15, 150),
	(16, 120),
	(17, 90),
	(18, 60),
	(19, 30),
	(20, 0),
	(21, 30),
	(22, 60),
	(23, 90),
	(24, 120),
	(25, 150),
	(26, 180),
	(27, 210),
	(28, 240),
	(29, 270),
	(30, 300),
	(31, 330),
	(32, 360),
	(33, 390),
	(34, 420),
	(35, 450),
	(36, 480),
	(37, 510),
	(38, 540),
	(39, 570),
	(40, 600),
	(41, 630),
	(42, 660),
	(43, 690),
	(44, 720),
	(45, 750),
	(46, 780),
	(47, 810),
	(48, 840),
	(49, 870),
	(50, 900);
/*!40000 ALTER TABLE `linear_rt_node20` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node21
DROP TABLE IF EXISTS `linear_rt_node21`;
CREATE TABLE IF NOT EXISTS `linear_rt_node21` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node21: ~50 rows (approximately)
DELETE FROM `linear_rt_node21`;
/*!40000 ALTER TABLE `linear_rt_node21` DISABLE KEYS */;
INSERT INTO `linear_rt_node21` (`NODEID`, `DISTANCE`) VALUES
	(1, 600),
	(2, 570),
	(3, 540),
	(4, 510),
	(5, 480),
	(6, 450),
	(7, 420),
	(8, 390),
	(9, 360),
	(10, 330),
	(11, 300),
	(12, 270),
	(13, 240),
	(14, 210),
	(15, 180),
	(16, 150),
	(17, 120),
	(18, 90),
	(19, 60),
	(20, 30),
	(21, 0),
	(22, 30),
	(23, 60),
	(24, 90),
	(25, 120),
	(26, 150),
	(27, 180),
	(28, 210),
	(29, 240),
	(30, 270),
	(31, 300),
	(32, 330),
	(33, 360),
	(34, 390),
	(35, 420),
	(36, 450),
	(37, 480),
	(38, 510),
	(39, 540),
	(40, 570),
	(41, 600),
	(42, 630),
	(43, 660),
	(44, 690),
	(45, 720),
	(46, 750),
	(47, 780),
	(48, 810),
	(49, 840),
	(50, 870);
/*!40000 ALTER TABLE `linear_rt_node21` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node22
DROP TABLE IF EXISTS `linear_rt_node22`;
CREATE TABLE IF NOT EXISTS `linear_rt_node22` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node22: ~50 rows (approximately)
DELETE FROM `linear_rt_node22`;
/*!40000 ALTER TABLE `linear_rt_node22` DISABLE KEYS */;
INSERT INTO `linear_rt_node22` (`NODEID`, `DISTANCE`) VALUES
	(1, 630),
	(2, 600),
	(3, 570),
	(4, 540),
	(5, 510),
	(6, 480),
	(7, 450),
	(8, 420),
	(9, 390),
	(10, 360),
	(11, 330),
	(12, 300),
	(13, 270),
	(14, 240),
	(15, 210),
	(16, 180),
	(17, 150),
	(18, 120),
	(19, 90),
	(20, 60),
	(21, 30),
	(22, 0),
	(23, 30),
	(24, 60),
	(25, 90),
	(26, 120),
	(27, 150),
	(28, 180),
	(29, 210),
	(30, 240),
	(31, 270),
	(32, 300),
	(33, 330),
	(34, 360),
	(35, 390),
	(36, 420),
	(37, 450),
	(38, 480),
	(39, 510),
	(40, 540),
	(41, 570),
	(42, 600),
	(43, 630),
	(44, 660),
	(45, 690),
	(46, 720),
	(47, 750),
	(48, 780),
	(49, 810),
	(50, 840);
/*!40000 ALTER TABLE `linear_rt_node22` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node23
DROP TABLE IF EXISTS `linear_rt_node23`;
CREATE TABLE IF NOT EXISTS `linear_rt_node23` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node23: ~50 rows (approximately)
DELETE FROM `linear_rt_node23`;
/*!40000 ALTER TABLE `linear_rt_node23` DISABLE KEYS */;
INSERT INTO `linear_rt_node23` (`NODEID`, `DISTANCE`) VALUES
	(1, 660),
	(2, 630),
	(3, 600),
	(4, 570),
	(5, 540),
	(6, 510),
	(7, 480),
	(8, 450),
	(9, 420),
	(10, 390),
	(11, 360),
	(12, 330),
	(13, 300),
	(14, 270),
	(15, 240),
	(16, 210),
	(17, 180),
	(18, 150),
	(19, 120),
	(20, 90),
	(21, 60),
	(22, 30),
	(23, 0),
	(24, 30),
	(25, 60),
	(26, 90),
	(27, 120),
	(28, 150),
	(29, 180),
	(30, 210),
	(31, 240),
	(32, 270),
	(33, 300),
	(34, 330),
	(35, 360),
	(36, 390),
	(37, 420),
	(38, 450),
	(39, 480),
	(40, 510),
	(41, 540),
	(42, 570),
	(43, 600),
	(44, 630),
	(45, 660),
	(46, 690),
	(47, 720),
	(48, 750),
	(49, 780),
	(50, 810);
/*!40000 ALTER TABLE `linear_rt_node23` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node24
DROP TABLE IF EXISTS `linear_rt_node24`;
CREATE TABLE IF NOT EXISTS `linear_rt_node24` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node24: ~50 rows (approximately)
DELETE FROM `linear_rt_node24`;
/*!40000 ALTER TABLE `linear_rt_node24` DISABLE KEYS */;
INSERT INTO `linear_rt_node24` (`NODEID`, `DISTANCE`) VALUES
	(1, 690),
	(2, 660),
	(3, 630),
	(4, 600),
	(5, 570),
	(6, 540),
	(7, 510),
	(8, 480),
	(9, 450),
	(10, 420),
	(11, 390),
	(12, 360),
	(13, 330),
	(14, 300),
	(15, 270),
	(16, 240),
	(17, 210),
	(18, 180),
	(19, 150),
	(20, 120),
	(21, 90),
	(22, 60),
	(23, 30),
	(24, 0),
	(25, 30),
	(26, 60),
	(27, 90),
	(28, 120),
	(29, 150),
	(30, 180),
	(31, 210),
	(32, 240),
	(33, 270),
	(34, 300),
	(35, 330),
	(36, 360),
	(37, 390),
	(38, 420),
	(39, 450),
	(40, 480),
	(41, 510),
	(42, 540),
	(43, 570),
	(44, 600),
	(45, 630),
	(46, 660),
	(47, 690),
	(48, 720),
	(49, 750),
	(50, 780);
/*!40000 ALTER TABLE `linear_rt_node24` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node25
DROP TABLE IF EXISTS `linear_rt_node25`;
CREATE TABLE IF NOT EXISTS `linear_rt_node25` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node25: ~50 rows (approximately)
DELETE FROM `linear_rt_node25`;
/*!40000 ALTER TABLE `linear_rt_node25` DISABLE KEYS */;
INSERT INTO `linear_rt_node25` (`NODEID`, `DISTANCE`) VALUES
	(1, 720),
	(2, 690),
	(3, 660),
	(4, 630),
	(5, 600),
	(6, 570),
	(7, 540),
	(8, 510),
	(9, 480),
	(10, 450),
	(11, 420),
	(12, 390),
	(13, 360),
	(14, 330),
	(15, 300),
	(16, 270),
	(17, 240),
	(18, 210),
	(19, 180),
	(20, 150),
	(21, 120),
	(22, 90),
	(23, 60),
	(24, 30),
	(25, 0),
	(26, 30),
	(27, 60),
	(28, 90),
	(29, 120),
	(30, 150),
	(31, 180),
	(32, 210),
	(33, 240),
	(34, 270),
	(35, 300),
	(36, 330),
	(37, 360),
	(38, 390),
	(39, 420),
	(40, 450),
	(41, 480),
	(42, 510),
	(43, 540),
	(44, 570),
	(45, 600),
	(46, 630),
	(47, 660),
	(48, 690),
	(49, 720),
	(50, 750);
/*!40000 ALTER TABLE `linear_rt_node25` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node26
DROP TABLE IF EXISTS `linear_rt_node26`;
CREATE TABLE IF NOT EXISTS `linear_rt_node26` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node26: ~50 rows (approximately)
DELETE FROM `linear_rt_node26`;
/*!40000 ALTER TABLE `linear_rt_node26` DISABLE KEYS */;
INSERT INTO `linear_rt_node26` (`NODEID`, `DISTANCE`) VALUES
	(1, 750),
	(2, 720),
	(3, 690),
	(4, 660),
	(5, 630),
	(6, 600),
	(7, 570),
	(8, 540),
	(9, 510),
	(10, 480),
	(11, 450),
	(12, 420),
	(13, 390),
	(14, 360),
	(15, 330),
	(16, 300),
	(17, 270),
	(18, 240),
	(19, 210),
	(20, 180),
	(21, 150),
	(22, 120),
	(23, 90),
	(24, 60),
	(25, 30),
	(26, 0),
	(27, 30),
	(28, 60),
	(29, 90),
	(30, 120),
	(31, 150),
	(32, 180),
	(33, 210),
	(34, 240),
	(35, 270),
	(36, 300),
	(37, 330),
	(38, 360),
	(39, 390),
	(40, 420),
	(41, 450),
	(42, 480),
	(43, 510),
	(44, 540),
	(45, 570),
	(46, 600),
	(47, 630),
	(48, 660),
	(49, 690),
	(50, 720);
/*!40000 ALTER TABLE `linear_rt_node26` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node27
DROP TABLE IF EXISTS `linear_rt_node27`;
CREATE TABLE IF NOT EXISTS `linear_rt_node27` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node27: ~50 rows (approximately)
DELETE FROM `linear_rt_node27`;
/*!40000 ALTER TABLE `linear_rt_node27` DISABLE KEYS */;
INSERT INTO `linear_rt_node27` (`NODEID`, `DISTANCE`) VALUES
	(1, 780),
	(2, 750),
	(3, 720),
	(4, 690),
	(5, 660),
	(6, 630),
	(7, 600),
	(8, 570),
	(9, 540),
	(10, 510),
	(11, 480),
	(12, 450),
	(13, 420),
	(14, 390),
	(15, 360),
	(16, 330),
	(17, 300),
	(18, 270),
	(19, 240),
	(20, 210),
	(21, 180),
	(22, 150),
	(23, 120),
	(24, 90),
	(25, 60),
	(26, 30),
	(27, 0),
	(28, 30),
	(29, 60),
	(30, 90),
	(31, 120),
	(32, 150),
	(33, 180),
	(34, 210),
	(35, 240),
	(36, 270),
	(37, 300),
	(38, 330),
	(39, 360),
	(40, 390),
	(41, 420),
	(42, 450),
	(43, 480),
	(44, 510),
	(45, 540),
	(46, 570),
	(47, 600),
	(48, 630),
	(49, 660),
	(50, 690);
/*!40000 ALTER TABLE `linear_rt_node27` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node28
DROP TABLE IF EXISTS `linear_rt_node28`;
CREATE TABLE IF NOT EXISTS `linear_rt_node28` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node28: ~50 rows (approximately)
DELETE FROM `linear_rt_node28`;
/*!40000 ALTER TABLE `linear_rt_node28` DISABLE KEYS */;
INSERT INTO `linear_rt_node28` (`NODEID`, `DISTANCE`) VALUES
	(1, 810),
	(2, 780),
	(3, 750),
	(4, 720),
	(5, 690),
	(6, 660),
	(7, 630),
	(8, 600),
	(9, 570),
	(10, 540),
	(11, 510),
	(12, 480),
	(13, 450),
	(14, 420),
	(15, 390),
	(16, 360),
	(17, 330),
	(18, 300),
	(19, 270),
	(20, 240),
	(21, 210),
	(22, 180),
	(23, 150),
	(24, 120),
	(25, 90),
	(26, 60),
	(27, 30),
	(28, 0),
	(29, 30),
	(30, 60),
	(31, 90),
	(32, 120),
	(33, 150),
	(34, 180),
	(35, 210),
	(36, 240),
	(37, 270),
	(38, 300),
	(39, 330),
	(40, 360),
	(41, 390),
	(42, 420),
	(43, 450),
	(44, 480),
	(45, 510),
	(46, 540),
	(47, 570),
	(48, 600),
	(49, 630),
	(50, 660);
/*!40000 ALTER TABLE `linear_rt_node28` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node29
DROP TABLE IF EXISTS `linear_rt_node29`;
CREATE TABLE IF NOT EXISTS `linear_rt_node29` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node29: ~50 rows (approximately)
DELETE FROM `linear_rt_node29`;
/*!40000 ALTER TABLE `linear_rt_node29` DISABLE KEYS */;
INSERT INTO `linear_rt_node29` (`NODEID`, `DISTANCE`) VALUES
	(1, 840),
	(2, 810),
	(3, 780),
	(4, 750),
	(5, 720),
	(6, 690),
	(7, 660),
	(8, 630),
	(9, 600),
	(10, 570),
	(11, 540),
	(12, 510),
	(13, 480),
	(14, 450),
	(15, 420),
	(16, 390),
	(17, 360),
	(18, 330),
	(19, 300),
	(20, 270),
	(21, 240),
	(22, 210),
	(23, 180),
	(24, 150),
	(25, 120),
	(26, 90),
	(27, 60),
	(28, 30),
	(29, 0),
	(30, 30),
	(31, 60),
	(32, 90),
	(33, 120),
	(34, 150),
	(35, 180),
	(36, 210),
	(37, 240),
	(38, 270),
	(39, 300),
	(40, 330),
	(41, 360),
	(42, 390),
	(43, 420),
	(44, 450),
	(45, 480),
	(46, 510),
	(47, 540),
	(48, 570),
	(49, 600),
	(50, 630);
/*!40000 ALTER TABLE `linear_rt_node29` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node3
DROP TABLE IF EXISTS `linear_rt_node3`;
CREATE TABLE IF NOT EXISTS `linear_rt_node3` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node3: ~50 rows (approximately)
DELETE FROM `linear_rt_node3`;
/*!40000 ALTER TABLE `linear_rt_node3` DISABLE KEYS */;
INSERT INTO `linear_rt_node3` (`NODEID`, `DISTANCE`) VALUES
	(1, 60),
	(2, 30),
	(3, 0),
	(4, 30),
	(5, 60),
	(6, 90),
	(7, 120),
	(8, 150),
	(9, 180),
	(10, 210),
	(11, 240),
	(12, 270),
	(13, 300),
	(14, 330),
	(15, 360),
	(16, 390),
	(17, 420),
	(18, 450),
	(19, 480),
	(20, 510),
	(21, 540),
	(22, 570),
	(23, 600),
	(24, 630),
	(25, 660),
	(26, 690),
	(27, 720),
	(28, 750),
	(29, 780),
	(30, 810),
	(31, 840),
	(32, 870),
	(33, 900),
	(34, 930),
	(35, 960),
	(36, 990),
	(37, 1020),
	(38, 1050),
	(39, 1080),
	(40, 1110),
	(41, 1140),
	(42, 1170),
	(43, 1200),
	(44, 1230),
	(45, 1260),
	(46, 1290),
	(47, 1320),
	(48, 1350),
	(49, 1380),
	(50, 1410);
/*!40000 ALTER TABLE `linear_rt_node3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node30
DROP TABLE IF EXISTS `linear_rt_node30`;
CREATE TABLE IF NOT EXISTS `linear_rt_node30` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node30: ~50 rows (approximately)
DELETE FROM `linear_rt_node30`;
/*!40000 ALTER TABLE `linear_rt_node30` DISABLE KEYS */;
INSERT INTO `linear_rt_node30` (`NODEID`, `DISTANCE`) VALUES
	(1, 870),
	(2, 840),
	(3, 810),
	(4, 780),
	(5, 750),
	(6, 720),
	(7, 690),
	(8, 660),
	(9, 630),
	(10, 600),
	(11, 570),
	(12, 540),
	(13, 510),
	(14, 480),
	(15, 450),
	(16, 420),
	(17, 390),
	(18, 360),
	(19, 330),
	(20, 300),
	(21, 270),
	(22, 240),
	(23, 210),
	(24, 180),
	(25, 150),
	(26, 120),
	(27, 90),
	(28, 60),
	(29, 30),
	(30, 0),
	(31, 30),
	(32, 60),
	(33, 90),
	(34, 120),
	(35, 150),
	(36, 180),
	(37, 210),
	(38, 240),
	(39, 270),
	(40, 300),
	(41, 330),
	(42, 360),
	(43, 390),
	(44, 420),
	(45, 450),
	(46, 480),
	(47, 510),
	(48, 540),
	(49, 570),
	(50, 600);
/*!40000 ALTER TABLE `linear_rt_node30` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node31
DROP TABLE IF EXISTS `linear_rt_node31`;
CREATE TABLE IF NOT EXISTS `linear_rt_node31` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node31: ~50 rows (approximately)
DELETE FROM `linear_rt_node31`;
/*!40000 ALTER TABLE `linear_rt_node31` DISABLE KEYS */;
INSERT INTO `linear_rt_node31` (`NODEID`, `DISTANCE`) VALUES
	(1, 900),
	(2, 870),
	(3, 840),
	(4, 810),
	(5, 780),
	(6, 750),
	(7, 720),
	(8, 690),
	(9, 660),
	(10, 630),
	(11, 600),
	(12, 570),
	(13, 540),
	(14, 510),
	(15, 480),
	(16, 450),
	(17, 420),
	(18, 390),
	(19, 360),
	(20, 330),
	(21, 300),
	(22, 270),
	(23, 240),
	(24, 210),
	(25, 180),
	(26, 150),
	(27, 120),
	(28, 90),
	(29, 60),
	(30, 30),
	(31, 0),
	(32, 30),
	(33, 60),
	(34, 90),
	(35, 120),
	(36, 150),
	(37, 180),
	(38, 210),
	(39, 240),
	(40, 270),
	(41, 300),
	(42, 330),
	(43, 360),
	(44, 390),
	(45, 420),
	(46, 450),
	(47, 480),
	(48, 510),
	(49, 540),
	(50, 570);
/*!40000 ALTER TABLE `linear_rt_node31` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node32
DROP TABLE IF EXISTS `linear_rt_node32`;
CREATE TABLE IF NOT EXISTS `linear_rt_node32` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node32: ~50 rows (approximately)
DELETE FROM `linear_rt_node32`;
/*!40000 ALTER TABLE `linear_rt_node32` DISABLE KEYS */;
INSERT INTO `linear_rt_node32` (`NODEID`, `DISTANCE`) VALUES
	(1, 930),
	(2, 900),
	(3, 870),
	(4, 840),
	(5, 810),
	(6, 780),
	(7, 750),
	(8, 720),
	(9, 690),
	(10, 660),
	(11, 630),
	(12, 600),
	(13, 570),
	(14, 540),
	(15, 510),
	(16, 480),
	(17, 450),
	(18, 420),
	(19, 390),
	(20, 360),
	(21, 330),
	(22, 300),
	(23, 270),
	(24, 240),
	(25, 210),
	(26, 180),
	(27, 150),
	(28, 120),
	(29, 90),
	(30, 60),
	(31, 30),
	(32, 0),
	(33, 30),
	(34, 60),
	(35, 90),
	(36, 120),
	(37, 150),
	(38, 180),
	(39, 210),
	(40, 240),
	(41, 270),
	(42, 300),
	(43, 330),
	(44, 360),
	(45, 390),
	(46, 420),
	(47, 450),
	(48, 480),
	(49, 510),
	(50, 540);
/*!40000 ALTER TABLE `linear_rt_node32` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node33
DROP TABLE IF EXISTS `linear_rt_node33`;
CREATE TABLE IF NOT EXISTS `linear_rt_node33` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node33: ~50 rows (approximately)
DELETE FROM `linear_rt_node33`;
/*!40000 ALTER TABLE `linear_rt_node33` DISABLE KEYS */;
INSERT INTO `linear_rt_node33` (`NODEID`, `DISTANCE`) VALUES
	(1, 960),
	(2, 930),
	(3, 900),
	(4, 870),
	(5, 840),
	(6, 810),
	(7, 780),
	(8, 750),
	(9, 720),
	(10, 690),
	(11, 660),
	(12, 630),
	(13, 600),
	(14, 570),
	(15, 540),
	(16, 510),
	(17, 480),
	(18, 450),
	(19, 420),
	(20, 390),
	(21, 360),
	(22, 330),
	(23, 300),
	(24, 270),
	(25, 240),
	(26, 210),
	(27, 180),
	(28, 150),
	(29, 120),
	(30, 90),
	(31, 60),
	(32, 30),
	(33, 0),
	(34, 30),
	(35, 60),
	(36, 90),
	(37, 120),
	(38, 150),
	(39, 180),
	(40, 210),
	(41, 240),
	(42, 270),
	(43, 300),
	(44, 330),
	(45, 360),
	(46, 390),
	(47, 420),
	(48, 450),
	(49, 480),
	(50, 510);
/*!40000 ALTER TABLE `linear_rt_node33` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node34
DROP TABLE IF EXISTS `linear_rt_node34`;
CREATE TABLE IF NOT EXISTS `linear_rt_node34` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node34: ~50 rows (approximately)
DELETE FROM `linear_rt_node34`;
/*!40000 ALTER TABLE `linear_rt_node34` DISABLE KEYS */;
INSERT INTO `linear_rt_node34` (`NODEID`, `DISTANCE`) VALUES
	(1, 990),
	(2, 960),
	(3, 930),
	(4, 900),
	(5, 870),
	(6, 840),
	(7, 810),
	(8, 780),
	(9, 750),
	(10, 720),
	(11, 690),
	(12, 660),
	(13, 630),
	(14, 600),
	(15, 570),
	(16, 540),
	(17, 510),
	(18, 480),
	(19, 450),
	(20, 420),
	(21, 390),
	(22, 360),
	(23, 330),
	(24, 300),
	(25, 270),
	(26, 240),
	(27, 210),
	(28, 180),
	(29, 150),
	(30, 120),
	(31, 90),
	(32, 60),
	(33, 30),
	(34, 0),
	(35, 30),
	(36, 60),
	(37, 90),
	(38, 120),
	(39, 150),
	(40, 180),
	(41, 210),
	(42, 240),
	(43, 270),
	(44, 300),
	(45, 330),
	(46, 360),
	(47, 390),
	(48, 420),
	(49, 450),
	(50, 480);
/*!40000 ALTER TABLE `linear_rt_node34` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node35
DROP TABLE IF EXISTS `linear_rt_node35`;
CREATE TABLE IF NOT EXISTS `linear_rt_node35` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node35: ~50 rows (approximately)
DELETE FROM `linear_rt_node35`;
/*!40000 ALTER TABLE `linear_rt_node35` DISABLE KEYS */;
INSERT INTO `linear_rt_node35` (`NODEID`, `DISTANCE`) VALUES
	(1, 1020),
	(2, 990),
	(3, 960),
	(4, 930),
	(5, 900),
	(6, 870),
	(7, 840),
	(8, 810),
	(9, 780),
	(10, 750),
	(11, 720),
	(12, 690),
	(13, 660),
	(14, 630),
	(15, 600),
	(16, 570),
	(17, 540),
	(18, 510),
	(19, 480),
	(20, 450),
	(21, 420),
	(22, 390),
	(23, 360),
	(24, 330),
	(25, 300),
	(26, 270),
	(27, 240),
	(28, 210),
	(29, 180),
	(30, 150),
	(31, 120),
	(32, 90),
	(33, 60),
	(34, 30),
	(35, 0),
	(36, 30),
	(37, 60),
	(38, 90),
	(39, 120),
	(40, 150),
	(41, 180),
	(42, 210),
	(43, 240),
	(44, 270),
	(45, 300),
	(46, 330),
	(47, 360),
	(48, 390),
	(49, 420),
	(50, 450);
/*!40000 ALTER TABLE `linear_rt_node35` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node36
DROP TABLE IF EXISTS `linear_rt_node36`;
CREATE TABLE IF NOT EXISTS `linear_rt_node36` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node36: ~50 rows (approximately)
DELETE FROM `linear_rt_node36`;
/*!40000 ALTER TABLE `linear_rt_node36` DISABLE KEYS */;
INSERT INTO `linear_rt_node36` (`NODEID`, `DISTANCE`) VALUES
	(1, 1050),
	(2, 1020),
	(3, 990),
	(4, 960),
	(5, 930),
	(6, 900),
	(7, 870),
	(8, 840),
	(9, 810),
	(10, 780),
	(11, 750),
	(12, 720),
	(13, 690),
	(14, 660),
	(15, 630),
	(16, 600),
	(17, 570),
	(18, 540),
	(19, 510),
	(20, 480),
	(21, 450),
	(22, 420),
	(23, 390),
	(24, 360),
	(25, 330),
	(26, 300),
	(27, 270),
	(28, 240),
	(29, 210),
	(30, 180),
	(31, 150),
	(32, 120),
	(33, 90),
	(34, 60),
	(35, 30),
	(36, 0),
	(37, 30),
	(38, 60),
	(39, 90),
	(40, 120),
	(41, 150),
	(42, 180),
	(43, 210),
	(44, 240),
	(45, 270),
	(46, 300),
	(47, 330),
	(48, 360),
	(49, 390),
	(50, 420);
/*!40000 ALTER TABLE `linear_rt_node36` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node37
DROP TABLE IF EXISTS `linear_rt_node37`;
CREATE TABLE IF NOT EXISTS `linear_rt_node37` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node37: ~50 rows (approximately)
DELETE FROM `linear_rt_node37`;
/*!40000 ALTER TABLE `linear_rt_node37` DISABLE KEYS */;
INSERT INTO `linear_rt_node37` (`NODEID`, `DISTANCE`) VALUES
	(1, 1080),
	(2, 1050),
	(3, 1020),
	(4, 990),
	(5, 960),
	(6, 930),
	(7, 900),
	(8, 870),
	(9, 840),
	(10, 810),
	(11, 780),
	(12, 750),
	(13, 720),
	(14, 690),
	(15, 660),
	(16, 630),
	(17, 600),
	(18, 570),
	(19, 540),
	(20, 510),
	(21, 480),
	(22, 450),
	(23, 420),
	(24, 390),
	(25, 360),
	(26, 330),
	(27, 300),
	(28, 270),
	(29, 240),
	(30, 210),
	(31, 180),
	(32, 150),
	(33, 120),
	(34, 90),
	(35, 60),
	(36, 30),
	(37, 0),
	(38, 30),
	(39, 60),
	(40, 90),
	(41, 120),
	(42, 150),
	(43, 180),
	(44, 210),
	(45, 240),
	(46, 270),
	(47, 300),
	(48, 330),
	(49, 360),
	(50, 390);
/*!40000 ALTER TABLE `linear_rt_node37` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node38
DROP TABLE IF EXISTS `linear_rt_node38`;
CREATE TABLE IF NOT EXISTS `linear_rt_node38` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node38: ~50 rows (approximately)
DELETE FROM `linear_rt_node38`;
/*!40000 ALTER TABLE `linear_rt_node38` DISABLE KEYS */;
INSERT INTO `linear_rt_node38` (`NODEID`, `DISTANCE`) VALUES
	(1, 1110),
	(2, 1080),
	(3, 1050),
	(4, 1020),
	(5, 990),
	(6, 960),
	(7, 930),
	(8, 900),
	(9, 870),
	(10, 840),
	(11, 810),
	(12, 780),
	(13, 750),
	(14, 720),
	(15, 690),
	(16, 660),
	(17, 630),
	(18, 600),
	(19, 570),
	(20, 540),
	(21, 510),
	(22, 480),
	(23, 450),
	(24, 420),
	(25, 390),
	(26, 360),
	(27, 330),
	(28, 300),
	(29, 270),
	(30, 240),
	(31, 210),
	(32, 180),
	(33, 150),
	(34, 120),
	(35, 90),
	(36, 60),
	(37, 30),
	(38, 0),
	(39, 30),
	(40, 60),
	(41, 90),
	(42, 120),
	(43, 150),
	(44, 180),
	(45, 210),
	(46, 240),
	(47, 270),
	(48, 300),
	(49, 330),
	(50, 360);
/*!40000 ALTER TABLE `linear_rt_node38` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node39
DROP TABLE IF EXISTS `linear_rt_node39`;
CREATE TABLE IF NOT EXISTS `linear_rt_node39` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node39: ~50 rows (approximately)
DELETE FROM `linear_rt_node39`;
/*!40000 ALTER TABLE `linear_rt_node39` DISABLE KEYS */;
INSERT INTO `linear_rt_node39` (`NODEID`, `DISTANCE`) VALUES
	(1, 1140),
	(2, 1110),
	(3, 1080),
	(4, 1050),
	(5, 1020),
	(6, 990),
	(7, 960),
	(8, 930),
	(9, 900),
	(10, 870),
	(11, 840),
	(12, 810),
	(13, 780),
	(14, 750),
	(15, 720),
	(16, 690),
	(17, 660),
	(18, 630),
	(19, 600),
	(20, 570),
	(21, 540),
	(22, 510),
	(23, 480),
	(24, 450),
	(25, 420),
	(26, 390),
	(27, 360),
	(28, 330),
	(29, 300),
	(30, 270),
	(31, 240),
	(32, 210),
	(33, 180),
	(34, 150),
	(35, 120),
	(36, 90),
	(37, 60),
	(38, 30),
	(39, 0),
	(40, 30),
	(41, 60),
	(42, 90),
	(43, 120),
	(44, 150),
	(45, 180),
	(46, 210),
	(47, 240),
	(48, 270),
	(49, 300),
	(50, 330);
/*!40000 ALTER TABLE `linear_rt_node39` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node4
DROP TABLE IF EXISTS `linear_rt_node4`;
CREATE TABLE IF NOT EXISTS `linear_rt_node4` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node4: ~50 rows (approximately)
DELETE FROM `linear_rt_node4`;
/*!40000 ALTER TABLE `linear_rt_node4` DISABLE KEYS */;
INSERT INTO `linear_rt_node4` (`NODEID`, `DISTANCE`) VALUES
	(1, 90),
	(2, 60),
	(3, 30),
	(4, 0),
	(5, 30),
	(6, 60),
	(7, 90),
	(8, 120),
	(9, 150),
	(10, 180),
	(11, 210),
	(12, 240),
	(13, 270),
	(14, 300),
	(15, 330),
	(16, 360),
	(17, 390),
	(18, 420),
	(19, 450),
	(20, 480),
	(21, 510),
	(22, 540),
	(23, 570),
	(24, 600),
	(25, 630),
	(26, 660),
	(27, 690),
	(28, 720),
	(29, 750),
	(30, 780),
	(31, 810),
	(32, 840),
	(33, 870),
	(34, 900),
	(35, 930),
	(36, 960),
	(37, 990),
	(38, 1020),
	(39, 1050),
	(40, 1080),
	(41, 1110),
	(42, 1140),
	(43, 1170),
	(44, 1200),
	(45, 1230),
	(46, 1260),
	(47, 1290),
	(48, 1320),
	(49, 1350),
	(50, 1380);
/*!40000 ALTER TABLE `linear_rt_node4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node40
DROP TABLE IF EXISTS `linear_rt_node40`;
CREATE TABLE IF NOT EXISTS `linear_rt_node40` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node40: ~50 rows (approximately)
DELETE FROM `linear_rt_node40`;
/*!40000 ALTER TABLE `linear_rt_node40` DISABLE KEYS */;
INSERT INTO `linear_rt_node40` (`NODEID`, `DISTANCE`) VALUES
	(1, 1170),
	(2, 1140),
	(3, 1110),
	(4, 1080),
	(5, 1050),
	(6, 1020),
	(7, 990),
	(8, 960),
	(9, 930),
	(10, 900),
	(11, 870),
	(12, 840),
	(13, 810),
	(14, 780),
	(15, 750),
	(16, 720),
	(17, 690),
	(18, 660),
	(19, 630),
	(20, 600),
	(21, 570),
	(22, 540),
	(23, 510),
	(24, 480),
	(25, 450),
	(26, 420),
	(27, 390),
	(28, 360),
	(29, 330),
	(30, 300),
	(31, 270),
	(32, 240),
	(33, 210),
	(34, 180),
	(35, 150),
	(36, 120),
	(37, 90),
	(38, 60),
	(39, 30),
	(40, 0),
	(41, 30),
	(42, 60),
	(43, 90),
	(44, 120),
	(45, 150),
	(46, 180),
	(47, 210),
	(48, 240),
	(49, 270),
	(50, 300);
/*!40000 ALTER TABLE `linear_rt_node40` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node41
DROP TABLE IF EXISTS `linear_rt_node41`;
CREATE TABLE IF NOT EXISTS `linear_rt_node41` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node41: ~50 rows (approximately)
DELETE FROM `linear_rt_node41`;
/*!40000 ALTER TABLE `linear_rt_node41` DISABLE KEYS */;
INSERT INTO `linear_rt_node41` (`NODEID`, `DISTANCE`) VALUES
	(1, 1200),
	(2, 1170),
	(3, 1140),
	(4, 1110),
	(5, 1080),
	(6, 1050),
	(7, 1020),
	(8, 990),
	(9, 960),
	(10, 930),
	(11, 900),
	(12, 870),
	(13, 840),
	(14, 810),
	(15, 780),
	(16, 750),
	(17, 720),
	(18, 690),
	(19, 660),
	(20, 630),
	(21, 600),
	(22, 570),
	(23, 540),
	(24, 510),
	(25, 480),
	(26, 450),
	(27, 420),
	(28, 390),
	(29, 360),
	(30, 330),
	(31, 300),
	(32, 270),
	(33, 240),
	(34, 210),
	(35, 180),
	(36, 150),
	(37, 120),
	(38, 90),
	(39, 60),
	(40, 30),
	(41, 0),
	(42, 30),
	(43, 60),
	(44, 90),
	(45, 120),
	(46, 150),
	(47, 180),
	(48, 210),
	(49, 240),
	(50, 270);
/*!40000 ALTER TABLE `linear_rt_node41` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node42
DROP TABLE IF EXISTS `linear_rt_node42`;
CREATE TABLE IF NOT EXISTS `linear_rt_node42` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node42: ~50 rows (approximately)
DELETE FROM `linear_rt_node42`;
/*!40000 ALTER TABLE `linear_rt_node42` DISABLE KEYS */;
INSERT INTO `linear_rt_node42` (`NODEID`, `DISTANCE`) VALUES
	(1, 1230),
	(2, 1200),
	(3, 1170),
	(4, 1140),
	(5, 1110),
	(6, 1080),
	(7, 1050),
	(8, 1020),
	(9, 990),
	(10, 960),
	(11, 930),
	(12, 900),
	(13, 870),
	(14, 840),
	(15, 810),
	(16, 780),
	(17, 750),
	(18, 720),
	(19, 690),
	(20, 660),
	(21, 630),
	(22, 600),
	(23, 570),
	(24, 540),
	(25, 510),
	(26, 480),
	(27, 450),
	(28, 420),
	(29, 390),
	(30, 360),
	(31, 330),
	(32, 300),
	(33, 270),
	(34, 240),
	(35, 210),
	(36, 180),
	(37, 150),
	(38, 120),
	(39, 90),
	(40, 60),
	(41, 30),
	(42, 0),
	(43, 30),
	(44, 60),
	(45, 90),
	(46, 120),
	(47, 150),
	(48, 180),
	(49, 210),
	(50, 240);
/*!40000 ALTER TABLE `linear_rt_node42` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node43
DROP TABLE IF EXISTS `linear_rt_node43`;
CREATE TABLE IF NOT EXISTS `linear_rt_node43` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node43: ~50 rows (approximately)
DELETE FROM `linear_rt_node43`;
/*!40000 ALTER TABLE `linear_rt_node43` DISABLE KEYS */;
INSERT INTO `linear_rt_node43` (`NODEID`, `DISTANCE`) VALUES
	(1, 1260),
	(2, 1230),
	(3, 1200),
	(4, 1170),
	(5, 1140),
	(6, 1110),
	(7, 1080),
	(8, 1050),
	(9, 1020),
	(10, 990),
	(11, 960),
	(12, 930),
	(13, 900),
	(14, 870),
	(15, 840),
	(16, 810),
	(17, 780),
	(18, 750),
	(19, 720),
	(20, 690),
	(21, 660),
	(22, 630),
	(23, 600),
	(24, 570),
	(25, 540),
	(26, 510),
	(27, 480),
	(28, 450),
	(29, 420),
	(30, 390),
	(31, 360),
	(32, 330),
	(33, 300),
	(34, 270),
	(35, 240),
	(36, 210),
	(37, 180),
	(38, 150),
	(39, 120),
	(40, 90),
	(41, 60),
	(42, 30),
	(43, 0),
	(44, 30),
	(45, 60),
	(46, 90),
	(47, 120),
	(48, 150),
	(49, 180),
	(50, 210);
/*!40000 ALTER TABLE `linear_rt_node43` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node44
DROP TABLE IF EXISTS `linear_rt_node44`;
CREATE TABLE IF NOT EXISTS `linear_rt_node44` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node44: ~50 rows (approximately)
DELETE FROM `linear_rt_node44`;
/*!40000 ALTER TABLE `linear_rt_node44` DISABLE KEYS */;
INSERT INTO `linear_rt_node44` (`NODEID`, `DISTANCE`) VALUES
	(1, 1290),
	(2, 1260),
	(3, 1230),
	(4, 1200),
	(5, 1170),
	(6, 1140),
	(7, 1110),
	(8, 1080),
	(9, 1050),
	(10, 1020),
	(11, 990),
	(12, 960),
	(13, 930),
	(14, 900),
	(15, 870),
	(16, 840),
	(17, 810),
	(18, 780),
	(19, 750),
	(20, 720),
	(21, 690),
	(22, 660),
	(23, 630),
	(24, 600),
	(25, 570),
	(26, 540),
	(27, 510),
	(28, 480),
	(29, 450),
	(30, 420),
	(31, 390),
	(32, 360),
	(33, 330),
	(34, 300),
	(35, 270),
	(36, 240),
	(37, 210),
	(38, 180),
	(39, 150),
	(40, 120),
	(41, 90),
	(42, 60),
	(43, 30),
	(44, 0),
	(45, 30),
	(46, 60),
	(47, 90),
	(48, 120),
	(49, 150),
	(50, 180);
/*!40000 ALTER TABLE `linear_rt_node44` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node45
DROP TABLE IF EXISTS `linear_rt_node45`;
CREATE TABLE IF NOT EXISTS `linear_rt_node45` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node45: ~50 rows (approximately)
DELETE FROM `linear_rt_node45`;
/*!40000 ALTER TABLE `linear_rt_node45` DISABLE KEYS */;
INSERT INTO `linear_rt_node45` (`NODEID`, `DISTANCE`) VALUES
	(1, 1320),
	(2, 1290),
	(3, 1260),
	(4, 1230),
	(5, 1200),
	(6, 1170),
	(7, 1140),
	(8, 1110),
	(9, 1080),
	(10, 1050),
	(11, 1020),
	(12, 990),
	(13, 960),
	(14, 930),
	(15, 900),
	(16, 870),
	(17, 840),
	(18, 810),
	(19, 780),
	(20, 750),
	(21, 720),
	(22, 690),
	(23, 660),
	(24, 630),
	(25, 600),
	(26, 570),
	(27, 540),
	(28, 510),
	(29, 480),
	(30, 450),
	(31, 420),
	(32, 390),
	(33, 360),
	(34, 330),
	(35, 300),
	(36, 270),
	(37, 240),
	(38, 210),
	(39, 180),
	(40, 150),
	(41, 120),
	(42, 90),
	(43, 60),
	(44, 30),
	(45, 0),
	(46, 30),
	(47, 60),
	(48, 90),
	(49, 120),
	(50, 150);
/*!40000 ALTER TABLE `linear_rt_node45` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node46
DROP TABLE IF EXISTS `linear_rt_node46`;
CREATE TABLE IF NOT EXISTS `linear_rt_node46` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node46: ~50 rows (approximately)
DELETE FROM `linear_rt_node46`;
/*!40000 ALTER TABLE `linear_rt_node46` DISABLE KEYS */;
INSERT INTO `linear_rt_node46` (`NODEID`, `DISTANCE`) VALUES
	(1, 1350),
	(2, 1320),
	(3, 1290),
	(4, 1260),
	(5, 1230),
	(6, 1200),
	(7, 1170),
	(8, 1140),
	(9, 1110),
	(10, 1080),
	(11, 1050),
	(12, 1020),
	(13, 990),
	(14, 960),
	(15, 930),
	(16, 900),
	(17, 870),
	(18, 840),
	(19, 810),
	(20, 780),
	(21, 750),
	(22, 720),
	(23, 690),
	(24, 660),
	(25, 630),
	(26, 600),
	(27, 570),
	(28, 540),
	(29, 510),
	(30, 480),
	(31, 450),
	(32, 420),
	(33, 390),
	(34, 360),
	(35, 330),
	(36, 300),
	(37, 270),
	(38, 240),
	(39, 210),
	(40, 180),
	(41, 150),
	(42, 120),
	(43, 90),
	(44, 60),
	(45, 30),
	(46, 0),
	(47, 30),
	(48, 60),
	(49, 90),
	(50, 120);
/*!40000 ALTER TABLE `linear_rt_node46` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node47
DROP TABLE IF EXISTS `linear_rt_node47`;
CREATE TABLE IF NOT EXISTS `linear_rt_node47` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node47: ~50 rows (approximately)
DELETE FROM `linear_rt_node47`;
/*!40000 ALTER TABLE `linear_rt_node47` DISABLE KEYS */;
INSERT INTO `linear_rt_node47` (`NODEID`, `DISTANCE`) VALUES
	(1, 1380),
	(2, 1350),
	(3, 1320),
	(4, 1290),
	(5, 1260),
	(6, 1230),
	(7, 1200),
	(8, 1170),
	(9, 1140),
	(10, 1110),
	(11, 1080),
	(12, 1050),
	(13, 1020),
	(14, 990),
	(15, 960),
	(16, 930),
	(17, 900),
	(18, 870),
	(19, 840),
	(20, 810),
	(21, 780),
	(22, 750),
	(23, 720),
	(24, 690),
	(25, 660),
	(26, 630),
	(27, 600),
	(28, 570),
	(29, 540),
	(30, 510),
	(31, 480),
	(32, 450),
	(33, 420),
	(34, 390),
	(35, 360),
	(36, 330),
	(37, 300),
	(38, 270),
	(39, 240),
	(40, 210),
	(41, 180),
	(42, 150),
	(43, 120),
	(44, 90),
	(45, 60),
	(46, 30),
	(47, 0),
	(48, 30),
	(49, 60),
	(50, 90);
/*!40000 ALTER TABLE `linear_rt_node47` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node48
DROP TABLE IF EXISTS `linear_rt_node48`;
CREATE TABLE IF NOT EXISTS `linear_rt_node48` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node48: ~50 rows (approximately)
DELETE FROM `linear_rt_node48`;
/*!40000 ALTER TABLE `linear_rt_node48` DISABLE KEYS */;
INSERT INTO `linear_rt_node48` (`NODEID`, `DISTANCE`) VALUES
	(1, 1410),
	(2, 1380),
	(3, 1350),
	(4, 1320),
	(5, 1290),
	(6, 1260),
	(7, 1230),
	(8, 1200),
	(9, 1170),
	(10, 1140),
	(11, 1110),
	(12, 1080),
	(13, 1050),
	(14, 1020),
	(15, 990),
	(16, 960),
	(17, 930),
	(18, 900),
	(19, 870),
	(20, 840),
	(21, 810),
	(22, 780),
	(23, 750),
	(24, 720),
	(25, 690),
	(26, 660),
	(27, 630),
	(28, 600),
	(29, 570),
	(30, 540),
	(31, 510),
	(32, 480),
	(33, 450),
	(34, 420),
	(35, 390),
	(36, 360),
	(37, 330),
	(38, 300),
	(39, 270),
	(40, 240),
	(41, 210),
	(42, 180),
	(43, 150),
	(44, 120),
	(45, 90),
	(46, 60),
	(47, 30),
	(48, 0),
	(49, 30),
	(50, 60);
/*!40000 ALTER TABLE `linear_rt_node48` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node49
DROP TABLE IF EXISTS `linear_rt_node49`;
CREATE TABLE IF NOT EXISTS `linear_rt_node49` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node49: ~50 rows (approximately)
DELETE FROM `linear_rt_node49`;
/*!40000 ALTER TABLE `linear_rt_node49` DISABLE KEYS */;
INSERT INTO `linear_rt_node49` (`NODEID`, `DISTANCE`) VALUES
	(1, 1440),
	(2, 1410),
	(3, 1380),
	(4, 1350),
	(5, 1320),
	(6, 1290),
	(7, 1260),
	(8, 1230),
	(9, 1200),
	(10, 1170),
	(11, 1140),
	(12, 1110),
	(13, 1080),
	(14, 1050),
	(15, 1020),
	(16, 990),
	(17, 960),
	(18, 930),
	(19, 900),
	(20, 870),
	(21, 840),
	(22, 810),
	(23, 780),
	(24, 750),
	(25, 720),
	(26, 690),
	(27, 660),
	(28, 630),
	(29, 600),
	(30, 570),
	(31, 540),
	(32, 510),
	(33, 480),
	(34, 450),
	(35, 420),
	(36, 390),
	(37, 360),
	(38, 330),
	(39, 300),
	(40, 270),
	(41, 240),
	(42, 210),
	(43, 180),
	(44, 150),
	(45, 120),
	(46, 90),
	(47, 60),
	(48, 30),
	(49, 0),
	(50, 30);
/*!40000 ALTER TABLE `linear_rt_node49` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node5
DROP TABLE IF EXISTS `linear_rt_node5`;
CREATE TABLE IF NOT EXISTS `linear_rt_node5` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node5: ~50 rows (approximately)
DELETE FROM `linear_rt_node5`;
/*!40000 ALTER TABLE `linear_rt_node5` DISABLE KEYS */;
INSERT INTO `linear_rt_node5` (`NODEID`, `DISTANCE`) VALUES
	(1, 120),
	(2, 90),
	(3, 60),
	(4, 30),
	(5, 0),
	(6, 30),
	(7, 60),
	(8, 90),
	(9, 120),
	(10, 150),
	(11, 180),
	(12, 210),
	(13, 240),
	(14, 270),
	(15, 300),
	(16, 330),
	(17, 360),
	(18, 390),
	(19, 420),
	(20, 450),
	(21, 480),
	(22, 510),
	(23, 540),
	(24, 570),
	(25, 600),
	(26, 630),
	(27, 660),
	(28, 690),
	(29, 720),
	(30, 750),
	(31, 780),
	(32, 810),
	(33, 840),
	(34, 870),
	(35, 900),
	(36, 930),
	(37, 960),
	(38, 990),
	(39, 1020),
	(40, 1050),
	(41, 1080),
	(42, 1110),
	(43, 1140),
	(44, 1170),
	(45, 1200),
	(46, 1230),
	(47, 1260),
	(48, 1290),
	(49, 1320),
	(50, 1350);
/*!40000 ALTER TABLE `linear_rt_node5` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node50
DROP TABLE IF EXISTS `linear_rt_node50`;
CREATE TABLE IF NOT EXISTS `linear_rt_node50` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node50: ~50 rows (approximately)
DELETE FROM `linear_rt_node50`;
/*!40000 ALTER TABLE `linear_rt_node50` DISABLE KEYS */;
INSERT INTO `linear_rt_node50` (`NODEID`, `DISTANCE`) VALUES
	(1, 1470),
	(2, 1440),
	(3, 1410),
	(4, 1380),
	(5, 1350),
	(6, 1320),
	(7, 1290),
	(8, 1260),
	(9, 1230),
	(10, 1200),
	(11, 1170),
	(12, 1140),
	(13, 1110),
	(14, 1080),
	(15, 1050),
	(16, 1020),
	(17, 990),
	(18, 960),
	(19, 930),
	(20, 900),
	(21, 870),
	(22, 840),
	(23, 810),
	(24, 780),
	(25, 750),
	(26, 720),
	(27, 690),
	(28, 660),
	(29, 630),
	(30, 600),
	(31, 570),
	(32, 540),
	(33, 510),
	(34, 480),
	(35, 450),
	(36, 420),
	(37, 390),
	(38, 360),
	(39, 330),
	(40, 300),
	(41, 270),
	(42, 240),
	(43, 210),
	(44, 180),
	(45, 150),
	(46, 120),
	(47, 90),
	(48, 60),
	(49, 30),
	(50, 0);
/*!40000 ALTER TABLE `linear_rt_node50` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node6
DROP TABLE IF EXISTS `linear_rt_node6`;
CREATE TABLE IF NOT EXISTS `linear_rt_node6` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node6: ~50 rows (approximately)
DELETE FROM `linear_rt_node6`;
/*!40000 ALTER TABLE `linear_rt_node6` DISABLE KEYS */;
INSERT INTO `linear_rt_node6` (`NODEID`, `DISTANCE`) VALUES
	(1, 150),
	(2, 120),
	(3, 90),
	(4, 60),
	(5, 30),
	(6, 0),
	(7, 30),
	(8, 60),
	(9, 90),
	(10, 120),
	(11, 150),
	(12, 180),
	(13, 210),
	(14, 240),
	(15, 270),
	(16, 300),
	(17, 330),
	(18, 360),
	(19, 390),
	(20, 420),
	(21, 450),
	(22, 480),
	(23, 510),
	(24, 540),
	(25, 570),
	(26, 600),
	(27, 630),
	(28, 660),
	(29, 690),
	(30, 720),
	(31, 750),
	(32, 780),
	(33, 810),
	(34, 840),
	(35, 870),
	(36, 900),
	(37, 930),
	(38, 960),
	(39, 990),
	(40, 1020),
	(41, 1050),
	(42, 1080),
	(43, 1110),
	(44, 1140),
	(45, 1170),
	(46, 1200),
	(47, 1230),
	(48, 1260),
	(49, 1290),
	(50, 1320);
/*!40000 ALTER TABLE `linear_rt_node6` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node7
DROP TABLE IF EXISTS `linear_rt_node7`;
CREATE TABLE IF NOT EXISTS `linear_rt_node7` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node7: ~50 rows (approximately)
DELETE FROM `linear_rt_node7`;
/*!40000 ALTER TABLE `linear_rt_node7` DISABLE KEYS */;
INSERT INTO `linear_rt_node7` (`NODEID`, `DISTANCE`) VALUES
	(1, 180),
	(2, 150),
	(3, 120),
	(4, 90),
	(5, 60),
	(6, 30),
	(7, 0),
	(8, 30),
	(9, 60),
	(10, 90),
	(11, 120),
	(12, 150),
	(13, 180),
	(14, 210),
	(15, 240),
	(16, 270),
	(17, 300),
	(18, 330),
	(19, 360),
	(20, 390),
	(21, 420),
	(22, 450),
	(23, 480),
	(24, 510),
	(25, 540),
	(26, 570),
	(27, 600),
	(28, 630),
	(29, 660),
	(30, 690),
	(31, 720),
	(32, 750),
	(33, 780),
	(34, 810),
	(35, 840),
	(36, 870),
	(37, 900),
	(38, 930),
	(39, 960),
	(40, 990),
	(41, 1020),
	(42, 1050),
	(43, 1080),
	(44, 1110),
	(45, 1140),
	(46, 1170),
	(47, 1200),
	(48, 1230),
	(49, 1260),
	(50, 1290);
/*!40000 ALTER TABLE `linear_rt_node7` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node8
DROP TABLE IF EXISTS `linear_rt_node8`;
CREATE TABLE IF NOT EXISTS `linear_rt_node8` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node8: ~50 rows (approximately)
DELETE FROM `linear_rt_node8`;
/*!40000 ALTER TABLE `linear_rt_node8` DISABLE KEYS */;
INSERT INTO `linear_rt_node8` (`NODEID`, `DISTANCE`) VALUES
	(1, 210),
	(2, 180),
	(3, 150),
	(4, 120),
	(5, 90),
	(6, 60),
	(7, 30),
	(8, 0),
	(9, 30),
	(10, 60),
	(11, 90),
	(12, 120),
	(13, 150),
	(14, 180),
	(15, 210),
	(16, 240),
	(17, 270),
	(18, 300),
	(19, 330),
	(20, 360),
	(21, 390),
	(22, 420),
	(23, 450),
	(24, 480),
	(25, 510),
	(26, 540),
	(27, 570),
	(28, 600),
	(29, 630),
	(30, 660),
	(31, 690),
	(32, 720),
	(33, 750),
	(34, 780),
	(35, 810),
	(36, 840),
	(37, 870),
	(38, 900),
	(39, 930),
	(40, 960),
	(41, 990),
	(42, 1020),
	(43, 1050),
	(44, 1080),
	(45, 1110),
	(46, 1140),
	(47, 1170),
	(48, 1200),
	(49, 1230),
	(50, 1260);
/*!40000 ALTER TABLE `linear_rt_node8` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.linear_rt_node9
DROP TABLE IF EXISTS `linear_rt_node9`;
CREATE TABLE IF NOT EXISTS `linear_rt_node9` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.linear_rt_node9: ~50 rows (approximately)
DELETE FROM `linear_rt_node9`;
/*!40000 ALTER TABLE `linear_rt_node9` DISABLE KEYS */;
INSERT INTO `linear_rt_node9` (`NODEID`, `DISTANCE`) VALUES
	(1, 240),
	(2, 210),
	(3, 180),
	(4, 150),
	(5, 120),
	(6, 90),
	(7, 60),
	(8, 30),
	(9, 0),
	(10, 30),
	(11, 60),
	(12, 90),
	(13, 120),
	(14, 150),
	(15, 180),
	(16, 210),
	(17, 240),
	(18, 270),
	(19, 300),
	(20, 330),
	(21, 360),
	(22, 390),
	(23, 420),
	(24, 450),
	(25, 480),
	(26, 510),
	(27, 540),
	(28, 570),
	(29, 600),
	(30, 630),
	(31, 660),
	(32, 690),
	(33, 720),
	(34, 750),
	(35, 780),
	(36, 810),
	(37, 840),
	(38, 870),
	(39, 900),
	(40, 930),
	(41, 960),
	(42, 990),
	(43, 1020),
	(44, 1050),
	(45, 1080),
	(46, 1110),
	(47, 1140),
	(48, 1170),
	(49, 1200),
	(50, 1230);
/*!40000 ALTER TABLE `linear_rt_node9` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node1
DROP TABLE IF EXISTS `networkcost_node1`;
CREATE TABLE IF NOT EXISTS `networkcost_node1` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node1: ~1 rows (approximately)
DELETE FROM `networkcost_node1`;
/*!40000 ALTER TABLE `networkcost_node1` DISABLE KEYS */;
INSERT INTO `networkcost_node1` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node10
DROP TABLE IF EXISTS `networkcost_node10`;
CREATE TABLE IF NOT EXISTS `networkcost_node10` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node10: ~1 rows (approximately)
DELETE FROM `networkcost_node10`;
/*!40000 ALTER TABLE `networkcost_node10` DISABLE KEYS */;
INSERT INTO `networkcost_node10` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node10` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node11
DROP TABLE IF EXISTS `networkcost_node11`;
CREATE TABLE IF NOT EXISTS `networkcost_node11` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node11: ~1 rows (approximately)
DELETE FROM `networkcost_node11`;
/*!40000 ALTER TABLE `networkcost_node11` DISABLE KEYS */;
INSERT INTO `networkcost_node11` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node11` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node12
DROP TABLE IF EXISTS `networkcost_node12`;
CREATE TABLE IF NOT EXISTS `networkcost_node12` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node12: ~1 rows (approximately)
DELETE FROM `networkcost_node12`;
/*!40000 ALTER TABLE `networkcost_node12` DISABLE KEYS */;
INSERT INTO `networkcost_node12` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node12` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node13
DROP TABLE IF EXISTS `networkcost_node13`;
CREATE TABLE IF NOT EXISTS `networkcost_node13` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node13: ~1 rows (approximately)
DELETE FROM `networkcost_node13`;
/*!40000 ALTER TABLE `networkcost_node13` DISABLE KEYS */;
INSERT INTO `networkcost_node13` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node13` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node14
DROP TABLE IF EXISTS `networkcost_node14`;
CREATE TABLE IF NOT EXISTS `networkcost_node14` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node14: ~1 rows (approximately)
DELETE FROM `networkcost_node14`;
/*!40000 ALTER TABLE `networkcost_node14` DISABLE KEYS */;
INSERT INTO `networkcost_node14` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node14` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node15
DROP TABLE IF EXISTS `networkcost_node15`;
CREATE TABLE IF NOT EXISTS `networkcost_node15` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node15: ~1 rows (approximately)
DELETE FROM `networkcost_node15`;
/*!40000 ALTER TABLE `networkcost_node15` DISABLE KEYS */;
INSERT INTO `networkcost_node15` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node15` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node16
DROP TABLE IF EXISTS `networkcost_node16`;
CREATE TABLE IF NOT EXISTS `networkcost_node16` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node16: ~1 rows (approximately)
DELETE FROM `networkcost_node16`;
/*!40000 ALTER TABLE `networkcost_node16` DISABLE KEYS */;
INSERT INTO `networkcost_node16` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node16` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node17
DROP TABLE IF EXISTS `networkcost_node17`;
CREATE TABLE IF NOT EXISTS `networkcost_node17` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node17: ~1 rows (approximately)
DELETE FROM `networkcost_node17`;
/*!40000 ALTER TABLE `networkcost_node17` DISABLE KEYS */;
INSERT INTO `networkcost_node17` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node17` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node18
DROP TABLE IF EXISTS `networkcost_node18`;
CREATE TABLE IF NOT EXISTS `networkcost_node18` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node18: ~1 rows (approximately)
DELETE FROM `networkcost_node18`;
/*!40000 ALTER TABLE `networkcost_node18` DISABLE KEYS */;
INSERT INTO `networkcost_node18` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node18` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node19
DROP TABLE IF EXISTS `networkcost_node19`;
CREATE TABLE IF NOT EXISTS `networkcost_node19` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node19: ~1 rows (approximately)
DELETE FROM `networkcost_node19`;
/*!40000 ALTER TABLE `networkcost_node19` DISABLE KEYS */;
INSERT INTO `networkcost_node19` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node19` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node2
DROP TABLE IF EXISTS `networkcost_node2`;
CREATE TABLE IF NOT EXISTS `networkcost_node2` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node2: ~1 rows (approximately)
DELETE FROM `networkcost_node2`;
/*!40000 ALTER TABLE `networkcost_node2` DISABLE KEYS */;
INSERT INTO `networkcost_node2` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node20
DROP TABLE IF EXISTS `networkcost_node20`;
CREATE TABLE IF NOT EXISTS `networkcost_node20` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node20: ~1 rows (approximately)
DELETE FROM `networkcost_node20`;
/*!40000 ALTER TABLE `networkcost_node20` DISABLE KEYS */;
INSERT INTO `networkcost_node20` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node20` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node21
DROP TABLE IF EXISTS `networkcost_node21`;
CREATE TABLE IF NOT EXISTS `networkcost_node21` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node21: ~1 rows (approximately)
DELETE FROM `networkcost_node21`;
/*!40000 ALTER TABLE `networkcost_node21` DISABLE KEYS */;
INSERT INTO `networkcost_node21` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node21` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node22
DROP TABLE IF EXISTS `networkcost_node22`;
CREATE TABLE IF NOT EXISTS `networkcost_node22` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node22: ~1 rows (approximately)
DELETE FROM `networkcost_node22`;
/*!40000 ALTER TABLE `networkcost_node22` DISABLE KEYS */;
INSERT INTO `networkcost_node22` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node22` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node23
DROP TABLE IF EXISTS `networkcost_node23`;
CREATE TABLE IF NOT EXISTS `networkcost_node23` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node23: ~1 rows (approximately)
DELETE FROM `networkcost_node23`;
/*!40000 ALTER TABLE `networkcost_node23` DISABLE KEYS */;
INSERT INTO `networkcost_node23` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node23` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node24
DROP TABLE IF EXISTS `networkcost_node24`;
CREATE TABLE IF NOT EXISTS `networkcost_node24` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node24: ~1 rows (approximately)
DELETE FROM `networkcost_node24`;
/*!40000 ALTER TABLE `networkcost_node24` DISABLE KEYS */;
INSERT INTO `networkcost_node24` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node24` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node25
DROP TABLE IF EXISTS `networkcost_node25`;
CREATE TABLE IF NOT EXISTS `networkcost_node25` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node25: ~1 rows (approximately)
DELETE FROM `networkcost_node25`;
/*!40000 ALTER TABLE `networkcost_node25` DISABLE KEYS */;
INSERT INTO `networkcost_node25` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node25` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node26
DROP TABLE IF EXISTS `networkcost_node26`;
CREATE TABLE IF NOT EXISTS `networkcost_node26` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node26: ~1 rows (approximately)
DELETE FROM `networkcost_node26`;
/*!40000 ALTER TABLE `networkcost_node26` DISABLE KEYS */;
INSERT INTO `networkcost_node26` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node26` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node27
DROP TABLE IF EXISTS `networkcost_node27`;
CREATE TABLE IF NOT EXISTS `networkcost_node27` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node27: ~1 rows (approximately)
DELETE FROM `networkcost_node27`;
/*!40000 ALTER TABLE `networkcost_node27` DISABLE KEYS */;
INSERT INTO `networkcost_node27` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node27` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node28
DROP TABLE IF EXISTS `networkcost_node28`;
CREATE TABLE IF NOT EXISTS `networkcost_node28` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node28: ~1 rows (approximately)
DELETE FROM `networkcost_node28`;
/*!40000 ALTER TABLE `networkcost_node28` DISABLE KEYS */;
INSERT INTO `networkcost_node28` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node28` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node29
DROP TABLE IF EXISTS `networkcost_node29`;
CREATE TABLE IF NOT EXISTS `networkcost_node29` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node29: ~1 rows (approximately)
DELETE FROM `networkcost_node29`;
/*!40000 ALTER TABLE `networkcost_node29` DISABLE KEYS */;
INSERT INTO `networkcost_node29` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node29` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node3
DROP TABLE IF EXISTS `networkcost_node3`;
CREATE TABLE IF NOT EXISTS `networkcost_node3` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node3: ~1 rows (approximately)
DELETE FROM `networkcost_node3`;
/*!40000 ALTER TABLE `networkcost_node3` DISABLE KEYS */;
INSERT INTO `networkcost_node3` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node30
DROP TABLE IF EXISTS `networkcost_node30`;
CREATE TABLE IF NOT EXISTS `networkcost_node30` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node30: ~1 rows (approximately)
DELETE FROM `networkcost_node30`;
/*!40000 ALTER TABLE `networkcost_node30` DISABLE KEYS */;
INSERT INTO `networkcost_node30` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node30` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node31
DROP TABLE IF EXISTS `networkcost_node31`;
CREATE TABLE IF NOT EXISTS `networkcost_node31` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node31: ~1 rows (approximately)
DELETE FROM `networkcost_node31`;
/*!40000 ALTER TABLE `networkcost_node31` DISABLE KEYS */;
INSERT INTO `networkcost_node31` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node31` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node32
DROP TABLE IF EXISTS `networkcost_node32`;
CREATE TABLE IF NOT EXISTS `networkcost_node32` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node32: ~1 rows (approximately)
DELETE FROM `networkcost_node32`;
/*!40000 ALTER TABLE `networkcost_node32` DISABLE KEYS */;
INSERT INTO `networkcost_node32` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node32` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node33
DROP TABLE IF EXISTS `networkcost_node33`;
CREATE TABLE IF NOT EXISTS `networkcost_node33` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node33: ~1 rows (approximately)
DELETE FROM `networkcost_node33`;
/*!40000 ALTER TABLE `networkcost_node33` DISABLE KEYS */;
INSERT INTO `networkcost_node33` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node33` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node34
DROP TABLE IF EXISTS `networkcost_node34`;
CREATE TABLE IF NOT EXISTS `networkcost_node34` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node34: ~1 rows (approximately)
DELETE FROM `networkcost_node34`;
/*!40000 ALTER TABLE `networkcost_node34` DISABLE KEYS */;
INSERT INTO `networkcost_node34` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node34` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node35
DROP TABLE IF EXISTS `networkcost_node35`;
CREATE TABLE IF NOT EXISTS `networkcost_node35` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node35: ~1 rows (approximately)
DELETE FROM `networkcost_node35`;
/*!40000 ALTER TABLE `networkcost_node35` DISABLE KEYS */;
INSERT INTO `networkcost_node35` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node35` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node36
DROP TABLE IF EXISTS `networkcost_node36`;
CREATE TABLE IF NOT EXISTS `networkcost_node36` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node36: ~1 rows (approximately)
DELETE FROM `networkcost_node36`;
/*!40000 ALTER TABLE `networkcost_node36` DISABLE KEYS */;
INSERT INTO `networkcost_node36` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node36` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node37
DROP TABLE IF EXISTS `networkcost_node37`;
CREATE TABLE IF NOT EXISTS `networkcost_node37` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node37: ~1 rows (approximately)
DELETE FROM `networkcost_node37`;
/*!40000 ALTER TABLE `networkcost_node37` DISABLE KEYS */;
INSERT INTO `networkcost_node37` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node37` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node38
DROP TABLE IF EXISTS `networkcost_node38`;
CREATE TABLE IF NOT EXISTS `networkcost_node38` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node38: ~1 rows (approximately)
DELETE FROM `networkcost_node38`;
/*!40000 ALTER TABLE `networkcost_node38` DISABLE KEYS */;
INSERT INTO `networkcost_node38` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node38` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node39
DROP TABLE IF EXISTS `networkcost_node39`;
CREATE TABLE IF NOT EXISTS `networkcost_node39` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node39: ~1 rows (approximately)
DELETE FROM `networkcost_node39`;
/*!40000 ALTER TABLE `networkcost_node39` DISABLE KEYS */;
INSERT INTO `networkcost_node39` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node39` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node4
DROP TABLE IF EXISTS `networkcost_node4`;
CREATE TABLE IF NOT EXISTS `networkcost_node4` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node4: ~1 rows (approximately)
DELETE FROM `networkcost_node4`;
/*!40000 ALTER TABLE `networkcost_node4` DISABLE KEYS */;
INSERT INTO `networkcost_node4` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node40
DROP TABLE IF EXISTS `networkcost_node40`;
CREATE TABLE IF NOT EXISTS `networkcost_node40` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node40: ~1 rows (approximately)
DELETE FROM `networkcost_node40`;
/*!40000 ALTER TABLE `networkcost_node40` DISABLE KEYS */;
INSERT INTO `networkcost_node40` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node40` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node41
DROP TABLE IF EXISTS `networkcost_node41`;
CREATE TABLE IF NOT EXISTS `networkcost_node41` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node41: ~1 rows (approximately)
DELETE FROM `networkcost_node41`;
/*!40000 ALTER TABLE `networkcost_node41` DISABLE KEYS */;
INSERT INTO `networkcost_node41` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node41` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node42
DROP TABLE IF EXISTS `networkcost_node42`;
CREATE TABLE IF NOT EXISTS `networkcost_node42` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node42: ~1 rows (approximately)
DELETE FROM `networkcost_node42`;
/*!40000 ALTER TABLE `networkcost_node42` DISABLE KEYS */;
INSERT INTO `networkcost_node42` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node42` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node43
DROP TABLE IF EXISTS `networkcost_node43`;
CREATE TABLE IF NOT EXISTS `networkcost_node43` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node43: ~1 rows (approximately)
DELETE FROM `networkcost_node43`;
/*!40000 ALTER TABLE `networkcost_node43` DISABLE KEYS */;
INSERT INTO `networkcost_node43` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node43` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node44
DROP TABLE IF EXISTS `networkcost_node44`;
CREATE TABLE IF NOT EXISTS `networkcost_node44` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node44: ~1 rows (approximately)
DELETE FROM `networkcost_node44`;
/*!40000 ALTER TABLE `networkcost_node44` DISABLE KEYS */;
INSERT INTO `networkcost_node44` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node44` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node45
DROP TABLE IF EXISTS `networkcost_node45`;
CREATE TABLE IF NOT EXISTS `networkcost_node45` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node45: ~1 rows (approximately)
DELETE FROM `networkcost_node45`;
/*!40000 ALTER TABLE `networkcost_node45` DISABLE KEYS */;
INSERT INTO `networkcost_node45` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node45` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node46
DROP TABLE IF EXISTS `networkcost_node46`;
CREATE TABLE IF NOT EXISTS `networkcost_node46` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node46: ~1 rows (approximately)
DELETE FROM `networkcost_node46`;
/*!40000 ALTER TABLE `networkcost_node46` DISABLE KEYS */;
INSERT INTO `networkcost_node46` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node46` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node47
DROP TABLE IF EXISTS `networkcost_node47`;
CREATE TABLE IF NOT EXISTS `networkcost_node47` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node47: ~1 rows (approximately)
DELETE FROM `networkcost_node47`;
/*!40000 ALTER TABLE `networkcost_node47` DISABLE KEYS */;
INSERT INTO `networkcost_node47` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node47` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node48
DROP TABLE IF EXISTS `networkcost_node48`;
CREATE TABLE IF NOT EXISTS `networkcost_node48` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node48: ~1 rows (approximately)
DELETE FROM `networkcost_node48`;
/*!40000 ALTER TABLE `networkcost_node48` DISABLE KEYS */;
INSERT INTO `networkcost_node48` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node48` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node49
DROP TABLE IF EXISTS `networkcost_node49`;
CREATE TABLE IF NOT EXISTS `networkcost_node49` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node49: ~1 rows (approximately)
DELETE FROM `networkcost_node49`;
/*!40000 ALTER TABLE `networkcost_node49` DISABLE KEYS */;
INSERT INTO `networkcost_node49` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node49` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node5
DROP TABLE IF EXISTS `networkcost_node5`;
CREATE TABLE IF NOT EXISTS `networkcost_node5` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node5: ~1 rows (approximately)
DELETE FROM `networkcost_node5`;
/*!40000 ALTER TABLE `networkcost_node5` DISABLE KEYS */;
INSERT INTO `networkcost_node5` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node5` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node50
DROP TABLE IF EXISTS `networkcost_node50`;
CREATE TABLE IF NOT EXISTS `networkcost_node50` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node50: ~1 rows (approximately)
DELETE FROM `networkcost_node50`;
/*!40000 ALTER TABLE `networkcost_node50` DISABLE KEYS */;
INSERT INTO `networkcost_node50` (`NETWORKCOST`) VALUES
	(9999);
/*!40000 ALTER TABLE `networkcost_node50` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node6
DROP TABLE IF EXISTS `networkcost_node6`;
CREATE TABLE IF NOT EXISTS `networkcost_node6` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node6: ~1 rows (approximately)
DELETE FROM `networkcost_node6`;
/*!40000 ALTER TABLE `networkcost_node6` DISABLE KEYS */;
INSERT INTO `networkcost_node6` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node6` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node7
DROP TABLE IF EXISTS `networkcost_node7`;
CREATE TABLE IF NOT EXISTS `networkcost_node7` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node7: ~1 rows (approximately)
DELETE FROM `networkcost_node7`;
/*!40000 ALTER TABLE `networkcost_node7` DISABLE KEYS */;
INSERT INTO `networkcost_node7` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node7` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node8
DROP TABLE IF EXISTS `networkcost_node8`;
CREATE TABLE IF NOT EXISTS `networkcost_node8` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node8: ~1 rows (approximately)
DELETE FROM `networkcost_node8`;
/*!40000 ALTER TABLE `networkcost_node8` DISABLE KEYS */;
INSERT INTO `networkcost_node8` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node8` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.networkcost_node9
DROP TABLE IF EXISTS `networkcost_node9`;
CREATE TABLE IF NOT EXISTS `networkcost_node9` (
  `NETWORKCOST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.networkcost_node9: ~1 rows (approximately)
DELETE FROM `networkcost_node9`;
/*!40000 ALTER TABLE `networkcost_node9` DISABLE KEYS */;
INSERT INTO `networkcost_node9` (`NETWORKCOST`) VALUES
	(0);
/*!40000 ALTER TABLE `networkcost_node9` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_algo1
DROP TABLE IF EXISTS `power_algo1`;
CREATE TABLE IF NOT EXISTS `power_algo1` (
  `POWER` double default NULL,
  `ITERATION` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_algo1: ~0 rows (approximately)
DELETE FROM `power_algo1`;
/*!40000 ALTER TABLE `power_algo1` DISABLE KEYS */;
/*!40000 ALTER TABLE `power_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_algo2
DROP TABLE IF EXISTS `power_algo2`;
CREATE TABLE IF NOT EXISTS `power_algo2` (
  `POWER` double default NULL,
  `ITERATION` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_algo2: ~0 rows (approximately)
DELETE FROM `power_algo2`;
/*!40000 ALTER TABLE `power_algo2` DISABLE KEYS */;
/*!40000 ALTER TABLE `power_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node1
DROP TABLE IF EXISTS `power_node1`;
CREATE TABLE IF NOT EXISTS `power_node1` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node1: ~1 rows (approximately)
DELETE FROM `power_node1`;
/*!40000 ALTER TABLE `power_node1` DISABLE KEYS */;
INSERT INTO `power_node1` (`POWER`) VALUES
	(8896.90029892929);
/*!40000 ALTER TABLE `power_node1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node10
DROP TABLE IF EXISTS `power_node10`;
CREATE TABLE IF NOT EXISTS `power_node10` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node10: ~1 rows (approximately)
DELETE FROM `power_node10`;
/*!40000 ALTER TABLE `power_node10` DISABLE KEYS */;
INSERT INTO `power_node10` (`POWER`) VALUES
	(7523.84963352251);
/*!40000 ALTER TABLE `power_node10` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node11
DROP TABLE IF EXISTS `power_node11`;
CREATE TABLE IF NOT EXISTS `power_node11` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node11: ~1 rows (approximately)
DELETE FROM `power_node11`;
/*!40000 ALTER TABLE `power_node11` DISABLE KEYS */;
INSERT INTO `power_node11` (`POWER`) VALUES
	(8054.22058835426);
/*!40000 ALTER TABLE `power_node11` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node12
DROP TABLE IF EXISTS `power_node12`;
CREATE TABLE IF NOT EXISTS `power_node12` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node12: ~1 rows (approximately)
DELETE FROM `power_node12`;
/*!40000 ALTER TABLE `power_node12` DISABLE KEYS */;
INSERT INTO `power_node12` (`POWER`) VALUES
	(8057.41840322914);
/*!40000 ALTER TABLE `power_node12` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node13
DROP TABLE IF EXISTS `power_node13`;
CREATE TABLE IF NOT EXISTS `power_node13` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node13: ~1 rows (approximately)
DELETE FROM `power_node13`;
/*!40000 ALTER TABLE `power_node13` DISABLE KEYS */;
INSERT INTO `power_node13` (`POWER`) VALUES
	(7892.31028016571);
/*!40000 ALTER TABLE `power_node13` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node14
DROP TABLE IF EXISTS `power_node14`;
CREATE TABLE IF NOT EXISTS `power_node14` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node14: ~1 rows (approximately)
DELETE FROM `power_node14`;
/*!40000 ALTER TABLE `power_node14` DISABLE KEYS */;
INSERT INTO `power_node14` (`POWER`) VALUES
	(8657.35796233117);
/*!40000 ALTER TABLE `power_node14` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node15
DROP TABLE IF EXISTS `power_node15`;
CREATE TABLE IF NOT EXISTS `power_node15` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node15: ~1 rows (approximately)
DELETE FROM `power_node15`;
/*!40000 ALTER TABLE `power_node15` DISABLE KEYS */;
INSERT INTO `power_node15` (`POWER`) VALUES
	(8482.67677420018);
/*!40000 ALTER TABLE `power_node15` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node16
DROP TABLE IF EXISTS `power_node16`;
CREATE TABLE IF NOT EXISTS `power_node16` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node16: ~1 rows (approximately)
DELETE FROM `power_node16`;
/*!40000 ALTER TABLE `power_node16` DISABLE KEYS */;
INSERT INTO `power_node16` (`POWER`) VALUES
	(8735.30729143685);
/*!40000 ALTER TABLE `power_node16` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node17
DROP TABLE IF EXISTS `power_node17`;
CREATE TABLE IF NOT EXISTS `power_node17` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node17: ~1 rows (approximately)
DELETE FROM `power_node17`;
/*!40000 ALTER TABLE `power_node17` DISABLE KEYS */;
INSERT INTO `power_node17` (`POWER`) VALUES
	(8939.83054844537);
/*!40000 ALTER TABLE `power_node17` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node18
DROP TABLE IF EXISTS `power_node18`;
CREATE TABLE IF NOT EXISTS `power_node18` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node18: ~1 rows (approximately)
DELETE FROM `power_node18`;
/*!40000 ALTER TABLE `power_node18` DISABLE KEYS */;
INSERT INTO `power_node18` (`POWER`) VALUES
	(9135.24407630784);
/*!40000 ALTER TABLE `power_node18` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node19
DROP TABLE IF EXISTS `power_node19`;
CREATE TABLE IF NOT EXISTS `power_node19` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node19: ~1 rows (approximately)
DELETE FROM `power_node19`;
/*!40000 ALTER TABLE `power_node19` DISABLE KEYS */;
INSERT INTO `power_node19` (`POWER`) VALUES
	(9281.62242932979);
/*!40000 ALTER TABLE `power_node19` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node2
DROP TABLE IF EXISTS `power_node2`;
CREATE TABLE IF NOT EXISTS `power_node2` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node2: ~1 rows (approximately)
DELETE FROM `power_node2`;
/*!40000 ALTER TABLE `power_node2` DISABLE KEYS */;
INSERT INTO `power_node2` (`POWER`) VALUES
	(8533.88346929065);
/*!40000 ALTER TABLE `power_node2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node20
DROP TABLE IF EXISTS `power_node20`;
CREATE TABLE IF NOT EXISTS `power_node20` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node20: ~1 rows (approximately)
DELETE FROM `power_node20`;
/*!40000 ALTER TABLE `power_node20` DISABLE KEYS */;
INSERT INTO `power_node20` (`POWER`) VALUES
	(9497.2430536028);
/*!40000 ALTER TABLE `power_node20` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node21
DROP TABLE IF EXISTS `power_node21`;
CREATE TABLE IF NOT EXISTS `power_node21` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node21: ~1 rows (approximately)
DELETE FROM `power_node21`;
/*!40000 ALTER TABLE `power_node21` DISABLE KEYS */;
INSERT INTO `power_node21` (`POWER`) VALUES
	(9503.49346629135);
/*!40000 ALTER TABLE `power_node21` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node22
DROP TABLE IF EXISTS `power_node22`;
CREATE TABLE IF NOT EXISTS `power_node22` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node22: ~1 rows (approximately)
DELETE FROM `power_node22`;
/*!40000 ALTER TABLE `power_node22` DISABLE KEYS */;
INSERT INTO `power_node22` (`POWER`) VALUES
	(9834.511523176);
/*!40000 ALTER TABLE `power_node22` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node23
DROP TABLE IF EXISTS `power_node23`;
CREATE TABLE IF NOT EXISTS `power_node23` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node23: ~1 rows (approximately)
DELETE FROM `power_node23`;
/*!40000 ALTER TABLE `power_node23` DISABLE KEYS */;
INSERT INTO `power_node23` (`POWER`) VALUES
	(9811.06787380291);
/*!40000 ALTER TABLE `power_node23` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node24
DROP TABLE IF EXISTS `power_node24`;
CREATE TABLE IF NOT EXISTS `power_node24` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node24: ~1 rows (approximately)
DELETE FROM `power_node24`;
/*!40000 ALTER TABLE `power_node24` DISABLE KEYS */;
INSERT INTO `power_node24` (`POWER`) VALUES
	(9975.49403414539);
/*!40000 ALTER TABLE `power_node24` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node25
DROP TABLE IF EXISTS `power_node25`;
CREATE TABLE IF NOT EXISTS `power_node25` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node25: ~1 rows (approximately)
DELETE FROM `power_node25`;
/*!40000 ALTER TABLE `power_node25` DISABLE KEYS */;
INSERT INTO `power_node25` (`POWER`) VALUES
	(9951.92575180924);
/*!40000 ALTER TABLE `power_node25` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node26
DROP TABLE IF EXISTS `power_node26`;
CREATE TABLE IF NOT EXISTS `power_node26` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node26: ~1 rows (approximately)
DELETE FROM `power_node26`;
/*!40000 ALTER TABLE `power_node26` DISABLE KEYS */;
INSERT INTO `power_node26` (`POWER`) VALUES
	(9951.92575180924);
/*!40000 ALTER TABLE `power_node26` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node27
DROP TABLE IF EXISTS `power_node27`;
CREATE TABLE IF NOT EXISTS `power_node27` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node27: ~1 rows (approximately)
DELETE FROM `power_node27`;
/*!40000 ALTER TABLE `power_node27` DISABLE KEYS */;
INSERT INTO `power_node27` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node27` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node28
DROP TABLE IF EXISTS `power_node28`;
CREATE TABLE IF NOT EXISTS `power_node28` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node28: ~1 rows (approximately)
DELETE FROM `power_node28`;
/*!40000 ALTER TABLE `power_node28` DISABLE KEYS */;
INSERT INTO `power_node28` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node28` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node29
DROP TABLE IF EXISTS `power_node29`;
CREATE TABLE IF NOT EXISTS `power_node29` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node29: ~1 rows (approximately)
DELETE FROM `power_node29`;
/*!40000 ALTER TABLE `power_node29` DISABLE KEYS */;
INSERT INTO `power_node29` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node29` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node3
DROP TABLE IF EXISTS `power_node3`;
CREATE TABLE IF NOT EXISTS `power_node3` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node3: ~1 rows (approximately)
DELETE FROM `power_node3`;
/*!40000 ALTER TABLE `power_node3` DISABLE KEYS */;
INSERT INTO `power_node3` (`POWER`) VALUES
	(7740.28940437856);
/*!40000 ALTER TABLE `power_node3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node30
DROP TABLE IF EXISTS `power_node30`;
CREATE TABLE IF NOT EXISTS `power_node30` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node30: ~1 rows (approximately)
DELETE FROM `power_node30`;
/*!40000 ALTER TABLE `power_node30` DISABLE KEYS */;
INSERT INTO `power_node30` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node30` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node31
DROP TABLE IF EXISTS `power_node31`;
CREATE TABLE IF NOT EXISTS `power_node31` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node31: ~1 rows (approximately)
DELETE FROM `power_node31`;
/*!40000 ALTER TABLE `power_node31` DISABLE KEYS */;
INSERT INTO `power_node31` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node31` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node32
DROP TABLE IF EXISTS `power_node32`;
CREATE TABLE IF NOT EXISTS `power_node32` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node32: ~1 rows (approximately)
DELETE FROM `power_node32`;
/*!40000 ALTER TABLE `power_node32` DISABLE KEYS */;
INSERT INTO `power_node32` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node32` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node33
DROP TABLE IF EXISTS `power_node33`;
CREATE TABLE IF NOT EXISTS `power_node33` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node33: ~1 rows (approximately)
DELETE FROM `power_node33`;
/*!40000 ALTER TABLE `power_node33` DISABLE KEYS */;
INSERT INTO `power_node33` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node33` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node34
DROP TABLE IF EXISTS `power_node34`;
CREATE TABLE IF NOT EXISTS `power_node34` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node34: ~1 rows (approximately)
DELETE FROM `power_node34`;
/*!40000 ALTER TABLE `power_node34` DISABLE KEYS */;
INSERT INTO `power_node34` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node34` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node35
DROP TABLE IF EXISTS `power_node35`;
CREATE TABLE IF NOT EXISTS `power_node35` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node35: ~1 rows (approximately)
DELETE FROM `power_node35`;
/*!40000 ALTER TABLE `power_node35` DISABLE KEYS */;
INSERT INTO `power_node35` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node35` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node36
DROP TABLE IF EXISTS `power_node36`;
CREATE TABLE IF NOT EXISTS `power_node36` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node36: ~1 rows (approximately)
DELETE FROM `power_node36`;
/*!40000 ALTER TABLE `power_node36` DISABLE KEYS */;
INSERT INTO `power_node36` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node36` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node37
DROP TABLE IF EXISTS `power_node37`;
CREATE TABLE IF NOT EXISTS `power_node37` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node37: ~1 rows (approximately)
DELETE FROM `power_node37`;
/*!40000 ALTER TABLE `power_node37` DISABLE KEYS */;
INSERT INTO `power_node37` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node37` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node38
DROP TABLE IF EXISTS `power_node38`;
CREATE TABLE IF NOT EXISTS `power_node38` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node38: ~1 rows (approximately)
DELETE FROM `power_node38`;
/*!40000 ALTER TABLE `power_node38` DISABLE KEYS */;
INSERT INTO `power_node38` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node38` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node39
DROP TABLE IF EXISTS `power_node39`;
CREATE TABLE IF NOT EXISTS `power_node39` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node39: ~1 rows (approximately)
DELETE FROM `power_node39`;
/*!40000 ALTER TABLE `power_node39` DISABLE KEYS */;
INSERT INTO `power_node39` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node39` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node4
DROP TABLE IF EXISTS `power_node4`;
CREATE TABLE IF NOT EXISTS `power_node4` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node4: ~1 rows (approximately)
DELETE FROM `power_node4`;
/*!40000 ALTER TABLE `power_node4` DISABLE KEYS */;
INSERT INTO `power_node4` (`POWER`) VALUES
	(7454.86255102713);
/*!40000 ALTER TABLE `power_node4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node40
DROP TABLE IF EXISTS `power_node40`;
CREATE TABLE IF NOT EXISTS `power_node40` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node40: ~1 rows (approximately)
DELETE FROM `power_node40`;
/*!40000 ALTER TABLE `power_node40` DISABLE KEYS */;
INSERT INTO `power_node40` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node40` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node41
DROP TABLE IF EXISTS `power_node41`;
CREATE TABLE IF NOT EXISTS `power_node41` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node41: ~1 rows (approximately)
DELETE FROM `power_node41`;
/*!40000 ALTER TABLE `power_node41` DISABLE KEYS */;
INSERT INTO `power_node41` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node41` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node42
DROP TABLE IF EXISTS `power_node42`;
CREATE TABLE IF NOT EXISTS `power_node42` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node42: ~1 rows (approximately)
DELETE FROM `power_node42`;
/*!40000 ALTER TABLE `power_node42` DISABLE KEYS */;
INSERT INTO `power_node42` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node42` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node43
DROP TABLE IF EXISTS `power_node43`;
CREATE TABLE IF NOT EXISTS `power_node43` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node43: ~1 rows (approximately)
DELETE FROM `power_node43`;
/*!40000 ALTER TABLE `power_node43` DISABLE KEYS */;
INSERT INTO `power_node43` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node43` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node44
DROP TABLE IF EXISTS `power_node44`;
CREATE TABLE IF NOT EXISTS `power_node44` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node44: ~1 rows (approximately)
DELETE FROM `power_node44`;
/*!40000 ALTER TABLE `power_node44` DISABLE KEYS */;
INSERT INTO `power_node44` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node44` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node45
DROP TABLE IF EXISTS `power_node45`;
CREATE TABLE IF NOT EXISTS `power_node45` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node45: ~1 rows (approximately)
DELETE FROM `power_node45`;
/*!40000 ALTER TABLE `power_node45` DISABLE KEYS */;
INSERT INTO `power_node45` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node45` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node46
DROP TABLE IF EXISTS `power_node46`;
CREATE TABLE IF NOT EXISTS `power_node46` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node46: ~1 rows (approximately)
DELETE FROM `power_node46`;
/*!40000 ALTER TABLE `power_node46` DISABLE KEYS */;
INSERT INTO `power_node46` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node46` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node47
DROP TABLE IF EXISTS `power_node47`;
CREATE TABLE IF NOT EXISTS `power_node47` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node47: ~1 rows (approximately)
DELETE FROM `power_node47`;
/*!40000 ALTER TABLE `power_node47` DISABLE KEYS */;
INSERT INTO `power_node47` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node47` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node48
DROP TABLE IF EXISTS `power_node48`;
CREATE TABLE IF NOT EXISTS `power_node48` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node48: ~1 rows (approximately)
DELETE FROM `power_node48`;
/*!40000 ALTER TABLE `power_node48` DISABLE KEYS */;
INSERT INTO `power_node48` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node48` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node49
DROP TABLE IF EXISTS `power_node49`;
CREATE TABLE IF NOT EXISTS `power_node49` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node49: ~1 rows (approximately)
DELETE FROM `power_node49`;
/*!40000 ALTER TABLE `power_node49` DISABLE KEYS */;
INSERT INTO `power_node49` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node49` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node5
DROP TABLE IF EXISTS `power_node5`;
CREATE TABLE IF NOT EXISTS `power_node5` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node5: ~1 rows (approximately)
DELETE FROM `power_node5`;
/*!40000 ALTER TABLE `power_node5` DISABLE KEYS */;
INSERT INTO `power_node5` (`POWER`) VALUES
	(7500.78560132705);
/*!40000 ALTER TABLE `power_node5` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node50
DROP TABLE IF EXISTS `power_node50`;
CREATE TABLE IF NOT EXISTS `power_node50` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node50: ~1 rows (approximately)
DELETE FROM `power_node50`;
/*!40000 ALTER TABLE `power_node50` DISABLE KEYS */;
INSERT INTO `power_node50` (`POWER`) VALUES
	(9999);
/*!40000 ALTER TABLE `power_node50` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node6
DROP TABLE IF EXISTS `power_node6`;
CREATE TABLE IF NOT EXISTS `power_node6` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node6: ~1 rows (approximately)
DELETE FROM `power_node6`;
/*!40000 ALTER TABLE `power_node6` DISABLE KEYS */;
INSERT INTO `power_node6` (`POWER`) VALUES
	(7057.72848442061);
/*!40000 ALTER TABLE `power_node6` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node7
DROP TABLE IF EXISTS `power_node7`;
CREATE TABLE IF NOT EXISTS `power_node7` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node7: ~1 rows (approximately)
DELETE FROM `power_node7`;
/*!40000 ALTER TABLE `power_node7` DISABLE KEYS */;
INSERT INTO `power_node7` (`POWER`) VALUES
	(7208.20068503384);
/*!40000 ALTER TABLE `power_node7` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node8
DROP TABLE IF EXISTS `power_node8`;
CREATE TABLE IF NOT EXISTS `power_node8` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node8: ~1 rows (approximately)
DELETE FROM `power_node8`;
/*!40000 ALTER TABLE `power_node8` DISABLE KEYS */;
INSERT INTO `power_node8` (`POWER`) VALUES
	(7709.38482224029);
/*!40000 ALTER TABLE `power_node8` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.power_node9
DROP TABLE IF EXISTS `power_node9`;
CREATE TABLE IF NOT EXISTS `power_node9` (
  `POWER` double NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.power_node9: ~1 rows (approximately)
DELETE FROM `power_node9`;
/*!40000 ALTER TABLE `power_node9` DISABLE KEYS */;
INSERT INTO `power_node9` (`POWER`) VALUES
	(7796.43457786584);
/*!40000 ALTER TABLE `power_node9` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.prescriptioninformation
DROP TABLE IF EXISTS `prescriptioninformation`;
CREATE TABLE IF NOT EXISTS `prescriptioninformation` (
  `id` bigint(20) NOT NULL default '0',
  `clinic_hospital_name` text,
  `doctor_name` text,
  `enc_clinic_hospital_name` text,
  `enc_doctor_name` text,
  `enc_end_date` text,
  `enc_prescription_info_id` text,
  `enc_prescription_info_summary` text,
  `enc_prescription_treatment_details` text,
  `enc_start_date` text,
  `end_date` varchar(255) default NULL,
  `prescription_info_id` text,
  `prescription_info_summary` text,
  `prescription_treatment_details` text,
  `start_date` varchar(255) default NULL,
  `th_enc_clinic_hospital_name` text,
  `th_enc_doctor_name` text,
  `th_enc_end_date` text,
  `th_enc_prescription_info_id` text,
  `th_enc_prescription_info_summary` text,
  `th_enc_prescription_treatment_details` text,
  `th_enc_start_date` text,
  `user_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.prescriptioninformation: 0 rows
DELETE FROM `prescriptioninformation`;
/*!40000 ALTER TABLE `prescriptioninformation` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescriptioninformation` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.prescriptioninformationapprove
DROP TABLE IF EXISTS `prescriptioninformationapprove`;
CREATE TABLE IF NOT EXISTS `prescriptioninformationapprove` (
  `id` bigint(20) NOT NULL default '0',
  `clinic_hospital_name` text,
  `doctor_name` text,
  `enc_clinic_hospital_name` text,
  `enc_doctor_name` text,
  `enc_end_date` text,
  `enc_prescription_info_id` text,
  `enc_prescription_info_summary` text,
  `enc_prescription_treatment_details` text,
  `enc_start_date` text,
  `end_date` varchar(255) default NULL,
  `prescription_info_id` text,
  `prescription_info_summary` text,
  `prescription_treatment_details` text,
  `start_date` varchar(255) default NULL,
  `th_enc_clinic_hospital_name` text,
  `th_enc_doctor_name` text,
  `th_enc_end_date` text,
  `th_enc_prescription_info_id` text,
  `th_enc_prescription_info_summary` text,
  `th_enc_prescription_treatment_details` text,
  `th_enc_start_date` text,
  `user_id` varchar(255) default NULL,
  `usernameapproved` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.prescriptioninformationapprove: 0 rows
DELETE FROM `prescriptioninformationapprove`;
/*!40000 ALTER TABLE `prescriptioninformationapprove` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescriptioninformationapprove` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.prescriptioninformationapprove_sequence
DROP TABLE IF EXISTS `prescriptioninformationapprove_sequence`;
CREATE TABLE IF NOT EXISTS `prescriptioninformationapprove_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.prescriptioninformationapprove_sequence: 1 rows
DELETE FROM `prescriptioninformationapprove_sequence`;
/*!40000 ALTER TABLE `prescriptioninformationapprove_sequence` DISABLE KEYS */;
INSERT INTO `prescriptioninformationapprove_sequence` (`next_val`) VALUES
	(1);
/*!40000 ALTER TABLE `prescriptioninformationapprove_sequence` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.prescriptioninformation_sequence
DROP TABLE IF EXISTS `prescriptioninformation_sequence`;
CREATE TABLE IF NOT EXISTS `prescriptioninformation_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.prescriptioninformation_sequence: 1 rows
DELETE FROM `prescriptioninformation_sequence`;
/*!40000 ALTER TABLE `prescriptioninformation_sequence` DISABLE KEYS */;
INSERT INTO `prescriptioninformation_sequence` (`next_val`) VALUES
	(1);
/*!40000 ALTER TABLE `prescriptioninformation_sequence` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.randomtopology
DROP TABLE IF EXISTS `randomtopology`;
CREATE TABLE IF NOT EXISTS `randomtopology` (
  `NODEID` int(11) NOT NULL default '0',
  `XCORDINATE` double NOT NULL default '0',
  `YCORDINATE` double NOT NULL default '0',
  `BUFFER` int(11) NOT NULL default '0',
  `NETWORKCOST` int(11) NOT NULL default '0',
  `POWERAVAILABLE` double NOT NULL default '0',
  `ENERGY` double NOT NULL default '0',
  `TRUSTLEVEL` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.randomtopology: ~50 rows (approximately)
DELETE FROM `randomtopology`;
/*!40000 ALTER TABLE `randomtopology` DISABLE KEYS */;
INSERT INTO `randomtopology` (`NODEID`, `XCORDINATE`, `YCORDINATE`, `BUFFER`, `NETWORKCOST`, `POWERAVAILABLE`, `ENERGY`, `TRUSTLEVEL`) VALUES
	(1, 99, 70, 1000, 10, 1000, 3555, 0),
	(2, 54, 5, 1000, 10, 1000, 3555, 0),
	(3, 43, 48, 1000, 10, 1000, 3555, 0),
	(4, 39, 47, 1000, 10, 1000, 3555, 0),
	(5, 93, 28, 1000, 10, 1000, 3555, 0),
	(6, 33, 52, 1000, 10, 1000, 3555, 0),
	(7, 12, 9, 1000, 10, 1000, 3555, 0),
	(8, 12, 83, 1000, 10, 1000, 3555, 0),
	(9, 76, 9, 1000, 10, 1000, 3555, 0),
	(10, 29, 90, 1000, 10, 1000, 3555, 0),
	(11, 89, 68, 1000, 10, 1000, 3555, 0),
	(12, 79, 29, 1000, 10, 1000, 3555, 0),
	(13, 80, 34, 1000, 10, 1000, 3555, 0),
	(14, 48, 27, 1000, 10, 1000, 3555, 0),
	(15, 84, 41, 1000, 10, 1000, 3555, 0),
	(16, 52, 95, 1000, 10, 1000, 3555, 0),
	(17, 97, 99, 1000, 10, 1000, 3555, 0),
	(18, 31, 38, 1000, 10, 1000, 3555, 0),
	(19, 23, 42, 1000, 10, 1000, 3555, 0),
	(20, 14, 23, 1000, 10, 1000, 3555, 0),
	(21, 5, 98, 1000, 10, 1000, 3555, 0),
	(22, 96, 3, 1000, 10, 1000, 3555, 0),
	(23, 52, 76, 1000, 10, 1000, 3555, 0),
	(24, 21, 66, 1000, 10, 1000, 3555, 0),
	(25, 28, 93, 1000, 10, 1000, 3555, 0),
	(26, 52, 20, 1000, 10, 1000, 3555, 0),
	(27, 49, 61, 1000, 10, 1000, 3555, 0),
	(28, 18, 4, 1000, 10, 1000, 3555, 0),
	(29, 91, 91, 1000, 10, 1000, 3555, 0),
	(30, 51, 2, 1000, 10, 1000, 3555, 0),
	(31, 34, 79, 1000, 10, 1000, 3555, 0),
	(32, 14, 58, 1000, 10, 1000, 3555, 0),
	(33, 54, 83, 1000, 10, 1000, 3555, 0),
	(34, 49, 19, 1000, 10, 1000, 3555, 0),
	(35, 18, 11, 1000, 10, 1000, 3555, 0),
	(36, 14, 34, 1000, 10, 1000, 3555, 0),
	(37, 83, 42, 1000, 10, 1000, 3555, 0),
	(38, 12, 54, 1000, 10, 1000, 3555, 0),
	(39, 31, 60, 1000, 10, 1000, 3555, 0),
	(40, 71, 40, 1000, 10, 1000, 3555, 0),
	(41, 20, 99, 1000, 10, 1000, 3555, 0),
	(42, 87, 14, 1000, 10, 1000, 3555, 0),
	(43, 66, 40, 1000, 10, 1000, 3555, 0),
	(44, 65, 11, 1000, 10, 1000, 3555, 0),
	(45, 43, 52, 1000, 10, 1000, 3555, 0),
	(46, 51, 83, 1000, 10, 1000, 3555, 0),
	(47, 83, 37, 1000, 10, 1000, 3555, 0),
	(48, 92, 89, 1000, 10, 1000, 3555, 0),
	(49, 98, 8, 1000, 10, 1000, 3555, 0),
	(50, 64, 63, 1000, 10, 1000, 3555, 0);
/*!40000 ALTER TABLE `randomtopology` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node1
DROP TABLE IF EXISTS `random_rt_node1`;
CREATE TABLE IF NOT EXISTS `random_rt_node1` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node1: ~50 rows (approximately)
DELETE FROM `random_rt_node1`;
/*!40000 ALTER TABLE `random_rt_node1` DISABLE KEYS */;
INSERT INTO `random_rt_node1` (`NODEID`, `DISTANCE`) VALUES
	(1, 0),
	(2, 79.0569415042095),
	(3, 60.1664358259653),
	(4, 64.2572953056694),
	(5, 42.4264068711928),
	(6, 68.4105255059483),
	(7, 106.254411673116),
	(8, 87.965902484997),
	(9, 65.1920240520265),
	(10, 72.8010988928052),
	(11, 10.1980390271856),
	(12, 45.6179789118282),
	(13, 40.7062648740952),
	(14, 66.7083203206317),
	(15, 32.649655434629),
	(16, 53.2353266168247),
	(17, 29.0688837074973),
	(18, 75.1531769122237),
	(19, 80.9938269252663),
	(20, 97.1287804927046),
	(21, 98.0815986819138),
	(22, 67.0671305484289),
	(23, 47.3814309619285),
	(24, 78.1024967590665),
	(25, 74.6324326281812),
	(26, 68.6221538571911),
	(27, 50.8035431835222),
	(28, 104.484448603608),
	(29, 22.4722050542442),
	(30, 83.2346081867393),
	(31, 65.6201188660917),
	(32, 85.842879728024),
	(33, 46.8401537145215),
	(34, 71.4212853426764),
	(35, 100.209779961838),
	(36, 92.3092628071528),
	(37, 32.2490309931942),
	(38, 88.4590300647707),
	(39, 68.7313611097583),
	(40, 41.0365690573664),
	(41, 84.154619599877),
	(42, 57.2712842531054),
	(43, 44.5982062419555),
	(44, 68.0955211449329),
	(45, 58.821764679411),
	(46, 49.7292670366254),
	(47, 36.6742416417845),
	(48, 20.2484567313166),
	(49, 62.00806399171),
	(50, 35.6931365951495);
/*!40000 ALTER TABLE `random_rt_node1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node10
DROP TABLE IF EXISTS `random_rt_node10`;
CREATE TABLE IF NOT EXISTS `random_rt_node10` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node10: ~50 rows (approximately)
DELETE FROM `random_rt_node10`;
/*!40000 ALTER TABLE `random_rt_node10` DISABLE KEYS */;
INSERT INTO `random_rt_node10` (`NODEID`, `DISTANCE`) VALUES
	(1, 72.8010988928052),
	(2, 88.6002257333467),
	(3, 44.2718872423573),
	(4, 44.1474801092882),
	(5, 89.1066776397819),
	(6, 38.2099463490856),
	(7, 82.7647267862342),
	(8, 18.3847763108502),
	(9, 93.6482781475452),
	(10, 0),
	(11, 63.9061812346818),
	(12, 78.873316146844),
	(13, 75.7429864739964),
	(14, 65.8027355054484),
	(15, 73.6613874428116),
	(16, 23.5372045918796),
	(17, 68.59300255857),
	(18, 52.0384473250308),
	(19, 48.3735464897913),
	(20, 68.6585755750875),
	(21, 25.298221281347),
	(22, 109.808924956034),
	(23, 26.9258240356725),
	(24, 25.298221281347),
	(25, 3.16227766016838),
	(26, 73.6817480791546),
	(27, 35.2278299076171),
	(28, 86.7006343690748),
	(29, 62.00806399171),
	(30, 90.7083237635885),
	(31, 12.0830459735946),
	(32, 35.3411940941446),
	(33, 25.9615099714943),
	(34, 73.7631344236401),
	(35, 79.7621464104371),
	(36, 57.974132162543),
	(37, 72.2495674727538),
	(38, 39.8120584747888),
	(39, 30.0665927567458),
	(40, 65.299310869258),
	(41, 12.7279220613579),
	(42, 95.603347221737),
	(43, 62.201286160336),
	(44, 86.8158971617526),
	(45, 40.4969134626332),
	(46, 23.0867927612304),
	(47, 75.6637297521078),
	(48, 63.0079360080935),
	(49, 107.168092266308),
	(50, 44.2040722106007);
/*!40000 ALTER TABLE `random_rt_node10` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node11
DROP TABLE IF EXISTS `random_rt_node11`;
CREATE TABLE IF NOT EXISTS `random_rt_node11` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node11: ~50 rows (approximately)
DELETE FROM `random_rt_node11`;
/*!40000 ALTER TABLE `random_rt_node11` DISABLE KEYS */;
INSERT INTO `random_rt_node11` (`NODEID`, `DISTANCE`) VALUES
	(1, 10.1980390271856),
	(2, 72.069410986909),
	(3, 50.1597448159378),
	(4, 54.230987451825),
	(5, 40.1995024844836),
	(6, 58.2408791142441),
	(7, 97.0051545022222),
	(8, 78.4474346298207),
	(9, 60.4152298679729),
	(10, 63.9061812346818),
	(11, 0),
	(12, 40.2616442783948),
	(13, 35.1710107901379),
	(14, 57.9827560572969),
	(15, 27.459060435492),
	(16, 45.8039299623951),
	(17, 32.0156211871642),
	(18, 65.299310869258),
	(19, 70.9365914038728),
	(20, 87.4642784226795),
	(21, 89.196412483911),
	(22, 65.3758365147246),
	(23, 37.8549864614954),
	(24, 68.0294054067798),
	(25, 65.9241988953981),
	(26, 60.605280298007),
	(27, 40.6078810084939),
	(28, 95.5876561068426),
	(29, 23.0867927612304),
	(30, 76.1577310586391),
	(31, 56.0892146495206),
	(32, 75.6637297521078),
	(33, 38.0788655293195),
	(34, 63.2534584034739),
	(35, 91.0494371207203),
	(36, 82.3468275041607),
	(37, 26.6833281282527),
	(38, 78.2623792124926),
	(39, 58.5491246732178),
	(40, 33.2866339541865),
	(41, 75.6439025963098),
	(42, 54.0370243444252),
	(43, 36.2353418639869),
	(44, 61.8465843842649),
	(45, 48.7031826475437),
	(46, 40.853396431631),
	(47, 31.5753068076939),
	(48, 21.2132034355964),
	(49, 60.6712452484701),
	(50, 25.4950975679639);
/*!40000 ALTER TABLE `random_rt_node11` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node12
DROP TABLE IF EXISTS `random_rt_node12`;
CREATE TABLE IF NOT EXISTS `random_rt_node12` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node12: ~50 rows (approximately)
DELETE FROM `random_rt_node12`;
/*!40000 ALTER TABLE `random_rt_node12` DISABLE KEYS */;
INSERT INTO `random_rt_node12` (`NODEID`, `DISTANCE`) VALUES
	(1, 45.6179789118282),
	(2, 34.6554469023269),
	(3, 40.7062648740952),
	(4, 43.8634243989226),
	(5, 14.0356688476182),
	(6, 51.4295634824952),
	(7, 69.9213844256534),
	(8, 86.0523096726637),
	(9, 20.2237484161567),
	(10, 78.873316146844),
	(11, 40.2616442783948),
	(12, 0),
	(13, 5.09901951359278),
	(14, 31.0644491340181),
	(15, 13),
	(16, 71.3091859440283),
	(17, 72.2772439983706),
	(18, 48.8364617882991),
	(19, 57.4891294072192),
	(20, 65.2763356814704),
	(21, 101.178060863015),
	(22, 31.0644491340181),
	(23, 54.2033209314706),
	(24, 68.7968022512675),
	(25, 81.8352002502591),
	(26, 28.4604989415154),
	(27, 43.8634243989226),
	(28, 65.9241988953981),
	(29, 63.1506136153878),
	(30, 38.8973006775534),
	(31, 67.2681202353686),
	(32, 71.175838597097),
	(33, 59.5063021872474),
	(34, 31.6227766016838),
	(35, 63.6003144646314),
	(36, 65.1920240520265),
	(37, 13.6014705087354),
	(38, 71.5122367151245),
	(39, 57.1401785086466),
	(40, 13.6014705087354),
	(41, 91.5478017212866),
	(42, 17),
	(43, 17.0293863659264),
	(44, 22.8035085019828),
	(45, 42.7200187265877),
	(46, 60.8276253029822),
	(47, 8.94427190999916),
	(48, 61.3921819126833),
	(49, 28.3196045170126),
	(50, 37.1618083521241);
/*!40000 ALTER TABLE `random_rt_node12` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node13
DROP TABLE IF EXISTS `random_rt_node13`;
CREATE TABLE IF NOT EXISTS `random_rt_node13` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node13: ~50 rows (approximately)
DELETE FROM `random_rt_node13`;
/*!40000 ALTER TABLE `random_rt_node13` DISABLE KEYS */;
INSERT INTO `random_rt_node13` (`NODEID`, `DISTANCE`) VALUES
	(1, 40.7062648740952),
	(2, 38.9486841883009),
	(3, 39.560080889705),
	(4, 43.0116263352131),
	(5, 14.3178210632764),
	(6, 50.3289181286465),
	(7, 72.4499827467198),
	(8, 83.8152730712011),
	(9, 25.3179778023443),
	(10, 75.7429864739964),
	(11, 35.1710107901379),
	(12, 5.09901951359278),
	(13, 0),
	(14, 32.7566787083184),
	(15, 8.06225774829855),
	(16, 67.1192967781993),
	(17, 67.1863081289633),
	(18, 49.1629942131274),
	(19, 57.5586657246326),
	(20, 66.9103878332804),
	(21, 98.5951317256587),
	(22, 34.8855270850248),
	(23, 50.4777178564959),
	(24, 67.1192967781993),
	(25, 78.644770964127),
	(26, 31.3049516849971),
	(27, 41.1096095821889),
	(28, 68.8767014308903),
	(29, 58.0517010948),
	(30, 43.1856457633784),
	(31, 64.3506021727847),
	(32, 70.2281994643178),
	(33, 55.4707129934347),
	(34, 34.4383507154451),
	(35, 66.1286624694618),
	(36, 66),
	(37, 8.54400374531753),
	(38, 70.8801805866774),
	(39, 55.4707129934347),
	(40, 10.816653826392),
	(41, 88.4590300647707),
	(42, 21.1896201004171),
	(43, 15.2315462117278),
	(44, 27.459060435492),
	(45, 41.146081222882),
	(46, 56.938563381947),
	(47, 4.24264068711928),
	(48, 56.2938717801503),
	(49, 31.6227766016838),
	(50, 33.1209903233584);
/*!40000 ALTER TABLE `random_rt_node13` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node14
DROP TABLE IF EXISTS `random_rt_node14`;
CREATE TABLE IF NOT EXISTS `random_rt_node14` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node14: ~50 rows (approximately)
DELETE FROM `random_rt_node14`;
/*!40000 ALTER TABLE `random_rt_node14` DISABLE KEYS */;
INSERT INTO `random_rt_node14` (`NODEID`, `DISTANCE`) VALUES
	(1, 66.7083203206317),
	(2, 22.8035085019828),
	(3, 21.5870331449229),
	(4, 21.9317121994613),
	(5, 45.0111097397076),
	(6, 29.1547594742265),
	(7, 40.2492235949962),
	(8, 66.573267908373),
	(9, 33.2866339541865),
	(10, 65.8027355054484),
	(11, 57.9827560572969),
	(12, 31.0644491340181),
	(13, 32.7566787083184),
	(14, 0),
	(15, 38.6264158316559),
	(16, 68.1175454637056),
	(17, 87.091905479212),
	(18, 20.2484567313166),
	(19, 29.1547594742265),
	(20, 34.2344855372474),
	(21, 83.0060238777886),
	(22, 53.6656314599949),
	(23, 49.1629942131274),
	(24, 47.4341649025257),
	(25, 68.9637585982667),
	(26, 8.06225774829855),
	(27, 34.0147027033899),
	(28, 37.8021163428716),
	(29, 77.103826104805),
	(30, 25.1793566240283),
	(31, 53.851648071345),
	(32, 46.0108682813094),
	(33, 56.3205113613149),
	(34, 8.06225774829855),
	(35, 34),
	(36, 34.7131099154196),
	(37, 38.0788655293195),
	(38, 45),
	(39, 37.1214223865412),
	(40, 26.4196896272458),
	(41, 77.2528316633119),
	(42, 41.1096095821889),
	(43, 22.2036033111745),
	(44, 23.3452350598575),
	(45, 25.4950975679639),
	(46, 56.0802995712398),
	(47, 36.4005494464026),
	(48, 76.0263112349929),
	(49, 53.4883164812653),
	(50, 39.3954312071844);
/*!40000 ALTER TABLE `random_rt_node14` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node15
DROP TABLE IF EXISTS `random_rt_node15`;
CREATE TABLE IF NOT EXISTS `random_rt_node15` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node15: ~50 rows (approximately)
DELETE FROM `random_rt_node15`;
/*!40000 ALTER TABLE `random_rt_node15` DISABLE KEYS */;
INSERT INTO `random_rt_node15` (`NODEID`, `DISTANCE`) VALUES
	(1, 32.649655434629),
	(2, 46.8614980554399),
	(3, 41.5932686861708),
	(4, 45.3982378512647),
	(5, 15.8113883008419),
	(6, 52.1727898429823),
	(7, 78.7908624143688),
	(8, 83.3546639366988),
	(9, 32.9848450049413),
	(10, 73.6613874428116),
	(11, 27.459060435492),
	(12, 13),
	(13, 8.06225774829855),
	(14, 38.6264158316559),
	(15, 0),
	(16, 62.7694193059009),
	(17, 59.4390444068543),
	(18, 53.084837759948),
	(19, 61.0081961706786),
	(20, 72.2772439983706),
	(21, 97.4166310236604),
	(22, 39.8497176903426),
	(23, 47.4236228055175),
	(24, 67.7790528113222),
	(25, 76.4198926981712),
	(26, 38.2753184180093),
	(27, 40.3112887414927),
	(28, 75.6637297521078),
	(29, 50.4876222454573),
	(30, 51.0881590977792),
	(31, 62.8012738724303),
	(32, 72.034713853808),
	(33, 51.6139516022558),
	(34, 41.3400532171888),
	(35, 72.4982758415674),
	(36, 70.3491293478462),
	(37, 1.4142135623731),
	(38, 73.1641988953614),
	(39, 56.302753041037),
	(40, 13.0384048104053),
	(41, 86.3712915267567),
	(42, 27.1661554144122),
	(43, 18.0277563773199),
	(44, 35.5105618091294),
	(45, 42.4499705535822),
	(46, 53.4134814442946),
	(47, 4.12310562561766),
	(48, 48.6621002423858),
	(49, 35.8468966578698),
	(50, 29.732137494637);
/*!40000 ALTER TABLE `random_rt_node15` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node16
DROP TABLE IF EXISTS `random_rt_node16`;
CREATE TABLE IF NOT EXISTS `random_rt_node16` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node16: ~50 rows (approximately)
DELETE FROM `random_rt_node16`;
/*!40000 ALTER TABLE `random_rt_node16` DISABLE KEYS */;
INSERT INTO `random_rt_node16` (`NODEID`, `DISTANCE`) VALUES
	(1, 53.2353266168247),
	(2, 90.0222194794152),
	(3, 47.8539444560216),
	(4, 49.7292670366254),
	(5, 78.5493475466219),
	(6, 47.0106370941726),
	(7, 94.847245611035),
	(8, 41.7612260356422),
	(9, 89.2860571421989),
	(10, 23.5372045918796),
	(11, 45.8039299623951),
	(12, 71.3091859440283),
	(13, 67.1192967781993),
	(14, 68.1175454637056),
	(15, 62.7694193059009),
	(16, 0),
	(17, 45.1774279923061),
	(18, 60.7453701939498),
	(19, 60.4152298679729),
	(20, 81.4125297481905),
	(21, 47.0956473572665),
	(22, 101.980390271856),
	(23, 19),
	(24, 42.4499705535822),
	(25, 24.0831891575846),
	(26, 75),
	(27, 34.132096331752),
	(28, 97.1442226794779),
	(29, 39.2045915678253),
	(30, 93.0053761886914),
	(31, 24.0831891575846),
	(32, 53.0377224247045),
	(33, 12.1655250605964),
	(34, 76.0591874792257),
	(35, 90.6200860736735),
	(36, 71.8679344353238),
	(37, 61.400325732035),
	(38, 57.2800139664787),
	(39, 40.8166632639171),
	(40, 58.1893461039046),
	(41, 32.2490309931942),
	(42, 88.2383136738231),
	(43, 56.7538544946508),
	(44, 85),
	(45, 43.9317652729776),
	(46, 12.0415945787923),
	(47, 65.7647321898295),
	(48, 40.4474968323134),
	(49, 98.4123975929862),
	(50, 34.1760149812701);
/*!40000 ALTER TABLE `random_rt_node16` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node17
DROP TABLE IF EXISTS `random_rt_node17`;
CREATE TABLE IF NOT EXISTS `random_rt_node17` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node17: ~50 rows (approximately)
DELETE FROM `random_rt_node17`;
/*!40000 ALTER TABLE `random_rt_node17` DISABLE KEYS */;
INSERT INTO `random_rt_node17` (`NODEID`, `DISTANCE`) VALUES
	(1, 29.0688837074973),
	(2, 103.368273662667),
	(3, 74.2765104188397),
	(4, 77.8973683766018),
	(5, 71.1125867902441),
	(6, 79.4040301244213),
	(7, 123.794184031399),
	(8, 86.4927742646749),
	(9, 92.4175308044962),
	(10, 68.59300255857),
	(11, 32.0156211871642),
	(12, 72.2772439983706),
	(13, 67.1863081289633),
	(14, 87.091905479212),
	(15, 59.4390444068543),
	(16, 45.1774279923061),
	(17, 0),
	(18, 89.8721313867653),
	(19, 93.407708461347),
	(20, 112.538882169675),
	(21, 92.0054346220918),
	(22, 96.0052081920559),
	(23, 50.5371150739731),
	(24, 82.8552955459094),
	(25, 69.2603782836912),
	(26, 90.9175450614457),
	(27, 61.2209114600559),
	(28, 123.555655475579),
	(29, 10),
	(30, 107.354552767919),
	(31, 66.098411478643),
	(32, 92.5742944882649),
	(33, 45.8802789878178),
	(34, 93.2952303175248),
	(35, 118.258192105241),
	(36, 105.422957651548),
	(37, 58.6941223633168),
	(38, 96.1769203083567),
	(39, 76.6615940350838),
	(40, 64.4748012792595),
	(41, 77),
	(42, 85.5862138431184),
	(43, 66.6483308118065),
	(44, 93.637599285757),
	(45, 71.5891053163818),
	(46, 48.7031826475437),
	(47, 63.5609943282828),
	(48, 11.1803398874989),
	(49, 91.0054943396276),
	(50, 48.8364617882991);
/*!40000 ALTER TABLE `random_rt_node17` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node18
DROP TABLE IF EXISTS `random_rt_node18`;
CREATE TABLE IF NOT EXISTS `random_rt_node18` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node18: ~50 rows (approximately)
DELETE FROM `random_rt_node18`;
/*!40000 ALTER TABLE `random_rt_node18` DISABLE KEYS */;
INSERT INTO `random_rt_node18` (`NODEID`, `DISTANCE`) VALUES
	(1, 75.1531769122237),
	(2, 40.2243707222375),
	(3, 15.6204993518133),
	(4, 12.0415945787923),
	(5, 62.8012738724303),
	(6, 14.142135623731),
	(7, 34.6698716467194),
	(8, 48.8466989672793),
	(9, 53.5350352572967),
	(10, 52.0384473250308),
	(11, 65.299310869258),
	(12, 48.8364617882991),
	(13, 49.1629942131274),
	(14, 20.2484567313166),
	(15, 53.084837759948),
	(16, 60.7453701939498),
	(17, 89.8721313867653),
	(18, 0),
	(19, 8.94427190999916),
	(20, 22.6715680975093),
	(21, 65.3911308970873),
	(22, 73.824115301167),
	(23, 43.4165866921848),
	(24, 29.732137494637),
	(25, 55.0817574156816),
	(26, 27.6586333718787),
	(27, 29.2061637330205),
	(28, 36.4005494464026),
	(29, 80.0562302385017),
	(30, 41.182520563948),
	(31, 41.1096095821889),
	(32, 26.2488094968134),
	(33, 50.5371150739731),
	(34, 26.1725046566048),
	(35, 29.9666481275434),
	(36, 17.464249196573),
	(37, 52.1536192416212),
	(38, 24.8394846967484),
	(39, 22),
	(40, 40.0499687890016),
	(41, 61.9838688692469),
	(42, 60.9261848469113),
	(43, 35.0570962859162),
	(44, 43.4165866921848),
	(45, 18.4390889145858),
	(46, 49.2442890089805),
	(47, 52.0096144957834),
	(48, 79.5110055275369),
	(49, 73.4098086089318),
	(50, 41.4004830889689);
/*!40000 ALTER TABLE `random_rt_node18` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node19
DROP TABLE IF EXISTS `random_rt_node19`;
CREATE TABLE IF NOT EXISTS `random_rt_node19` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node19: ~50 rows (approximately)
DELETE FROM `random_rt_node19`;
/*!40000 ALTER TABLE `random_rt_node19` DISABLE KEYS */;
INSERT INTO `random_rt_node19` (`NODEID`, `DISTANCE`) VALUES
	(1, 80.9938269252663),
	(2, 48.2700735445887),
	(3, 20.8806130178211),
	(4, 16.7630546142402),
	(5, 71.386273190299),
	(6, 14.142135623731),
	(7, 34.7850542618522),
	(8, 42.4499705535822),
	(9, 62.4339651151519),
	(10, 48.3735464897913),
	(11, 70.9365914038728),
	(12, 57.4891294072192),
	(13, 57.5586657246326),
	(14, 29.1547594742265),
	(15, 61.0081961706786),
	(16, 60.4152298679729),
	(17, 93.407708461347),
	(18, 8.94427190999916),
	(19, 0),
	(20, 21.0237960416286),
	(21, 58.821764679411),
	(22, 82.7647267862342),
	(23, 44.6878059430087),
	(24, 24.0831891575846),
	(25, 51.2445119012758),
	(26, 36.4005494464026),
	(27, 32.2024843762092),
	(28, 38.3275357934736),
	(29, 83.8152730712011),
	(30, 48.8262224629348),
	(31, 38.6005181312376),
	(32, 18.3575597506858),
	(33, 51.4003891035856),
	(34, 34.7131099154196),
	(35, 31.4006369362152),
	(36, 12.0415945787923),
	(37, 60),
	(38, 16.2788205960997),
	(39, 19.6977156035922),
	(40, 48.0416485978573),
	(41, 57.0788927713213),
	(42, 69.8569967862919),
	(43, 43.0464865000618),
	(44, 52.2015325445528),
	(45, 22.3606797749979),
	(46, 49.6487663492256),
	(47, 60.2079728939615),
	(48, 83.4865258589672),
	(49, 82.3468275041607),
	(50, 46.0651712251241);
/*!40000 ALTER TABLE `random_rt_node19` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node2
DROP TABLE IF EXISTS `random_rt_node2`;
CREATE TABLE IF NOT EXISTS `random_rt_node2` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node2: ~50 rows (approximately)
DELETE FROM `random_rt_node2`;
/*!40000 ALTER TABLE `random_rt_node2` DISABLE KEYS */;
INSERT INTO `random_rt_node2` (`NODEID`, `DISTANCE`) VALUES
	(1, 79.0569415042095),
	(2, 0),
	(3, 44.3846820423443),
	(4, 44.5982062419555),
	(5, 45.2769256906871),
	(6, 51.478150704935),
	(7, 42.190046219458),
	(8, 88.5889383614004),
	(9, 22.3606797749979),
	(10, 88.6002257333467),
	(11, 72.069410986909),
	(12, 34.6554469023269),
	(13, 38.9486841883009),
	(14, 22.8035085019828),
	(15, 46.8614980554399),
	(16, 90.0222194794152),
	(17, 103.368273662667),
	(18, 40.2243707222375),
	(19, 48.2700735445887),
	(20, 43.8634243989226),
	(21, 105.118980208143),
	(22, 42.0475920832573),
	(23, 71.028163428319),
	(24, 69.3541635375988),
	(25, 91.7605579756357),
	(26, 15.1327459504216),
	(27, 56.2227711874824),
	(28, 36.0138862107382),
	(29, 93.6215787091843),
	(30, 4.24264068711928),
	(31, 76.6550715869472),
	(32, 66.4003012041361),
	(33, 78),
	(34, 14.8660687473185),
	(35, 36.4965751817893),
	(36, 49.4064773081425),
	(37, 47.0106370941726),
	(38, 64.5368112010502),
	(39, 59.6154342431555),
	(40, 38.9101529166874),
	(41, 99.9599919967984),
	(42, 34.2052627529741),
	(43, 37),
	(44, 12.5299640861417),
	(45, 48.2700735445887),
	(46, 78.0576709875461),
	(47, 43.1856457633784),
	(48, 92.1954445729289),
	(49, 44.1021541423999),
	(50, 58.8557558782486);
/*!40000 ALTER TABLE `random_rt_node2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node20
DROP TABLE IF EXISTS `random_rt_node20`;
CREATE TABLE IF NOT EXISTS `random_rt_node20` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node20: ~50 rows (approximately)
DELETE FROM `random_rt_node20`;
/*!40000 ALTER TABLE `random_rt_node20` DISABLE KEYS */;
INSERT INTO `random_rt_node20` (`NODEID`, `DISTANCE`) VALUES
	(1, 97.1287804927046),
	(2, 43.8634243989226),
	(3, 38.2883794381533),
	(4, 34.6554469023269),
	(5, 79.1580697086532),
	(6, 34.6698716467194),
	(7, 14.142135623731),
	(8, 60.0333240792145),
	(9, 63.5609943282828),
	(10, 68.6585755750875),
	(11, 87.4642784226795),
	(12, 65.2763356814704),
	(13, 66.9103878332804),
	(14, 34.2344855372474),
	(15, 72.2772439983706),
	(16, 81.4125297481905),
	(17, 112.538882169675),
	(18, 22.6715680975093),
	(19, 21.0237960416286),
	(20, 0),
	(21, 75.538069872085),
	(22, 84.4037913840368),
	(23, 65.2150289427215),
	(24, 43.5660418215839),
	(25, 71.386273190299),
	(26, 38.1182371050918),
	(27, 51.662365412358),
	(28, 19.4164878389476),
	(29, 102.727795654341),
	(30, 42.5440947723653),
	(31, 59.464274989274),
	(32, 35),
	(33, 72.1110255092798),
	(34, 35.2278299076171),
	(35, 12.6491106406735),
	(36, 11),
	(37, 71.5681493403316),
	(38, 31.0644491340181),
	(39, 40.7185461430047),
	(40, 59.4810894318522),
	(41, 76.2364742101837),
	(42, 73.5527021937332),
	(43, 54.7083174663597),
	(44, 52.3927475897189),
	(45, 41.0121933088198),
	(46, 70.4911341943084),
	(47, 70.4059656563278),
	(48, 102.176318195558),
	(49, 85.3287759199674),
	(50, 64.0312423743285);
/*!40000 ALTER TABLE `random_rt_node20` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node21
DROP TABLE IF EXISTS `random_rt_node21`;
CREATE TABLE IF NOT EXISTS `random_rt_node21` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node21: ~50 rows (approximately)
DELETE FROM `random_rt_node21`;
/*!40000 ALTER TABLE `random_rt_node21` DISABLE KEYS */;
INSERT INTO `random_rt_node21` (`NODEID`, `DISTANCE`) VALUES
	(1, 98.0815986819138),
	(2, 105.118980208143),
	(3, 62.8012738724303),
	(4, 61.2943716828878),
	(5, 112.445542374965),
	(6, 53.851648071345),
	(7, 89.2748564826626),
	(8, 16.5529453572468),
	(9, 113.850779531806),
	(10, 25.298221281347),
	(11, 89.196412483911),
	(12, 101.178060863015),
	(13, 98.5951317256587),
	(14, 83.0060238777886),
	(15, 97.4166310236604),
	(16, 47.0956473572665),
	(17, 92.0054346220918),
	(18, 65.3911308970873),
	(19, 58.821764679411),
	(20, 75.538069872085),
	(21, 0),
	(22, 131.552270980018),
	(23, 51.8941229813165),
	(24, 35.7770876399966),
	(25, 23.5372045918796),
	(26, 91.0659101969557),
	(27, 57.4891294072192),
	(28, 94.8946784598589),
	(29, 86.2844134244418),
	(30, 106.45186705737),
	(31, 34.6698716467194),
	(32, 41),
	(33, 51.2445119012758),
	(34, 90.4267659490264),
	(35, 87.965902484997),
	(36, 64.6297145282261),
	(37, 96.0208310732624),
	(38, 44.5533388198909),
	(39, 46.0434577328854),
	(40, 87.8635305459552),
	(41, 15.0332963783729),
	(42, 117.388244726634),
	(43, 84.1724420460759),
	(44, 105.683489722851),
	(45, 59.6657355607052),
	(46, 48.3838816136118),
	(47, 99.0201999594022),
	(48, 87.4642784226795),
	(49, 129.417927660738),
	(50, 68.60029154457);
/*!40000 ALTER TABLE `random_rt_node21` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node22
DROP TABLE IF EXISTS `random_rt_node22`;
CREATE TABLE IF NOT EXISTS `random_rt_node22` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node22: ~50 rows (approximately)
DELETE FROM `random_rt_node22`;
/*!40000 ALTER TABLE `random_rt_node22` DISABLE KEYS */;
INSERT INTO `random_rt_node22` (`NODEID`, `DISTANCE`) VALUES
	(1, 67.0671305484289),
	(2, 42.0475920832573),
	(3, 69.5269731830748),
	(4, 72.0069441095788),
	(5, 25.1793566240283),
	(6, 79.8122797569397),
	(7, 84.2140130857092),
	(8, 116),
	(9, 20.8806130178211),
	(10, 109.808924956034),
	(11, 65.3758365147246),
	(12, 31.0644491340181),
	(13, 34.8855270850248),
	(14, 53.6656314599949),
	(15, 39.8497176903426),
	(16, 101.980390271856),
	(17, 96.0052081920559),
	(18, 73.824115301167),
	(19, 82.7647267862342),
	(20, 84.4037913840368),
	(21, 131.552270980018),
	(22, 0),
	(23, 85.2349693494401),
	(24, 97.9489663038871),
	(25, 112.800709217629),
	(26, 47.169905660283),
	(27, 74.6525284233562),
	(28, 78.0064099930256),
	(29, 88.1419309976812),
	(30, 45.0111097397076),
	(31, 98.0815986819138),
	(32, 98.737024463977),
	(33, 90.3548559846121),
	(34, 49.6487663492256),
	(35, 78.4091831356507),
	(36, 87.6641317757725),
	(37, 41.1096095821889),
	(38, 98.2700361249552),
	(39, 86.4522989862039),
	(40, 44.6542271235322),
	(41, 122.441822920112),
	(42, 14.2126704035519),
	(43, 47.6340214552582),
	(44, 32.0156211871642),
	(45, 72.1803297304744),
	(46, 91.7877987534291),
	(47, 36.4005494464026),
	(48, 86.0929730001235),
	(49, 5.3851648071345),
	(50, 68);
/*!40000 ALTER TABLE `random_rt_node22` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node23
DROP TABLE IF EXISTS `random_rt_node23`;
CREATE TABLE IF NOT EXISTS `random_rt_node23` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node23: ~50 rows (approximately)
DELETE FROM `random_rt_node23`;
/*!40000 ALTER TABLE `random_rt_node23` DISABLE KEYS */;
INSERT INTO `random_rt_node23` (`NODEID`, `DISTANCE`) VALUES
	(1, 47.3814309619285),
	(2, 71.028163428319),
	(3, 29.4108823397055),
	(4, 31.7804971641414),
	(5, 63.1268564083465),
	(6, 30.6104557300279),
	(7, 78.0320446995976),
	(8, 40.6078810084939),
	(9, 71.1688133946323),
	(10, 26.9258240356725),
	(11, 37.8549864614954),
	(12, 54.2033209314706),
	(13, 50.4777178564959),
	(14, 49.1629942131274),
	(15, 47.4236228055175),
	(16, 19),
	(17, 50.5371150739731),
	(18, 43.4165866921848),
	(19, 44.6878059430087),
	(20, 65.2150289427215),
	(21, 51.8941229813165),
	(22, 85.2349693494401),
	(23, 0),
	(24, 32.5729949498047),
	(25, 29.4108823397055),
	(26, 56),
	(27, 15.2970585407784),
	(28, 79.6241169495775),
	(29, 41.7851648315524),
	(30, 74.0067564483136),
	(31, 18.2482875908947),
	(32, 42.0475920832573),
	(33, 7.28010988928052),
	(34, 57.0788927713213),
	(35, 73.3552997403732),
	(36, 56.6392090340252),
	(37, 46.0108682813094),
	(38, 45.6508488420533),
	(39, 26.4007575648882),
	(40, 40.7062648740952),
	(41, 39.4081209904761),
	(42, 71.1969100453102),
	(43, 38.6264158316559),
	(44, 66.2872536767062),
	(45, 25.6320112359526),
	(46, 7.07106781186548),
	(47, 49.8196748283246),
	(48, 42.0594816896262),
	(49, 82.0975030070952),
	(50, 17.6918060129541);
/*!40000 ALTER TABLE `random_rt_node23` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node24
DROP TABLE IF EXISTS `random_rt_node24`;
CREATE TABLE IF NOT EXISTS `random_rt_node24` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node24: ~50 rows (approximately)
DELETE FROM `random_rt_node24`;
/*!40000 ALTER TABLE `random_rt_node24` DISABLE KEYS */;
INSERT INTO `random_rt_node24` (`NODEID`, `DISTANCE`) VALUES
	(1, 78.1024967590665),
	(2, 69.3541635375988),
	(3, 28.4253408071038),
	(4, 26.1725046566048),
	(5, 81.4125297481905),
	(6, 18.4390889145858),
	(7, 57.706152185014),
	(8, 19.2353840616713),
	(9, 79.2085853932514),
	(10, 25.298221281347),
	(11, 68.0294054067798),
	(12, 68.7968022512675),
	(13, 67.1192967781993),
	(14, 47.4341649025257),
	(15, 67.7790528113222),
	(16, 42.4499705535822),
	(17, 82.8552955459094),
	(18, 29.732137494637),
	(19, 24.0831891575846),
	(20, 43.5660418215839),
	(21, 35.7770876399966),
	(22, 97.9489663038871),
	(23, 32.5729949498047),
	(24, 0),
	(25, 27.8926513619627),
	(26, 55.4707129934347),
	(27, 28.4429253066558),
	(28, 62.072538211354),
	(29, 74.3303437365925),
	(30, 70.6823881882892),
	(31, 18.3847763108502),
	(32, 10.6301458127347),
	(33, 37.1214223865412),
	(34, 54.7083174663597),
	(35, 55.0817574156816),
	(36, 32.7566787083184),
	(37, 66.4830805543786),
	(38, 15),
	(39, 11.6619037896906),
	(40, 56.3560112144215),
	(41, 33.0151480384384),
	(42, 84.0238061504),
	(43, 51.9711458407451),
	(44, 70.4343666117613),
	(45, 26.0768096208106),
	(46, 34.4818792991333),
	(47, 68.4470598345904),
	(48, 74.6324326281812),
	(49, 96.4002074686564),
	(50, 43.1045241245046);
/*!40000 ALTER TABLE `random_rt_node24` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node25
DROP TABLE IF EXISTS `random_rt_node25`;
CREATE TABLE IF NOT EXISTS `random_rt_node25` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node25: ~50 rows (approximately)
DELETE FROM `random_rt_node25`;
/*!40000 ALTER TABLE `random_rt_node25` DISABLE KEYS */;
INSERT INTO `random_rt_node25` (`NODEID`, `DISTANCE`) VALUES
	(1, 74.6324326281812),
	(2, 91.7605579756357),
	(3, 47.4341649025257),
	(4, 47.2969343615419),
	(5, 91.9238815542512),
	(6, 41.3037528561268),
	(7, 85.5102333057278),
	(8, 18.8679622641132),
	(9, 96.7470929795826),
	(10, 3.16227766016838),
	(11, 65.9241988953981),
	(12, 81.8352002502591),
	(13, 78.644770964127),
	(14, 68.9637585982667),
	(15, 76.4198926981712),
	(16, 24.0831891575846),
	(17, 69.2603782836912),
	(18, 55.0817574156816),
	(19, 51.2445119012758),
	(20, 71.386273190299),
	(21, 23.5372045918796),
	(22, 112.800709217629),
	(23, 29.4108823397055),
	(24, 27.8926513619627),
	(25, 0),
	(26, 76.8439978137525),
	(27, 38.2753184180093),
	(28, 89.5600357302296),
	(29, 63.0317380372777),
	(30, 93.8616002420585),
	(31, 15.2315462117278),
	(32, 37.6961536499415),
	(33, 27.8567765543682),
	(34, 76.9220384545287),
	(35, 82.6075057122535),
	(36, 60.6382717431821),
	(37, 75.0066663703967),
	(38, 42.154477816716),
	(39, 33.1360830515618),
	(40, 68.2495421230062),
	(41, 10),
	(42, 98.600202839548),
	(43, 65.2150289427215),
	(44, 89.9611027055582),
	(45, 43.6577599058861),
	(46, 25.0798724079689),
	(47, 78.4920378127616),
	(48, 64.1248781675256),
	(49, 110.113577727726),
	(50, 46.8614980554399);
/*!40000 ALTER TABLE `random_rt_node25` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node26
DROP TABLE IF EXISTS `random_rt_node26`;
CREATE TABLE IF NOT EXISTS `random_rt_node26` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node26: ~50 rows (approximately)
DELETE FROM `random_rt_node26`;
/*!40000 ALTER TABLE `random_rt_node26` DISABLE KEYS */;
INSERT INTO `random_rt_node26` (`NODEID`, `DISTANCE`) VALUES
	(1, 68.6221538571911),
	(2, 15.1327459504216),
	(3, 29.4108823397055),
	(4, 29.9666481275434),
	(5, 41.7731971484108),
	(6, 37.2155881318568),
	(7, 41.4849370253831),
	(8, 74.6257328272225),
	(9, 26.4007575648882),
	(10, 73.6817480791546),
	(11, 60.605280298007),
	(12, 28.4604989415154),
	(13, 31.3049516849971),
	(14, 8.06225774829855),
	(15, 38.2753184180093),
	(16, 75),
	(17, 90.9175450614457),
	(18, 27.6586333718787),
	(19, 36.4005494464026),
	(20, 38.1182371050918),
	(21, 91.0659101969557),
	(22, 47.169905660283),
	(23, 56),
	(24, 55.4707129934347),
	(25, 76.8439978137525),
	(26, 0),
	(27, 41.1096095821889),
	(28, 37.5765884561119),
	(29, 81.0061726043145),
	(30, 18.0277563773199),
	(31, 61.6846820531645),
	(32, 53.7401153701776),
	(33, 63.0317380372777),
	(34, 3.16227766016838),
	(35, 35.1710107901379),
	(36, 40.4969134626332),
	(37, 38.0131556174964),
	(38, 52.4976189936268),
	(39, 45.1774279923061),
	(40, 27.5862284482674),
	(41, 85.2349693494401),
	(42, 35.5105618091294),
	(43, 24.4131112314674),
	(44, 15.8113883008419),
	(45, 33.2415402771893),
	(46, 63.0079360080935),
	(47, 35.3553390593274),
	(48, 79.7558775263617),
	(49, 47.5394572960189),
	(50, 44.6430285710994);
/*!40000 ALTER TABLE `random_rt_node26` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node27
DROP TABLE IF EXISTS `random_rt_node27`;
CREATE TABLE IF NOT EXISTS `random_rt_node27` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node27: ~50 rows (approximately)
DELETE FROM `random_rt_node27`;
/*!40000 ALTER TABLE `random_rt_node27` DISABLE KEYS */;
INSERT INTO `random_rt_node27` (`NODEID`, `DISTANCE`) VALUES
	(1, 50.8035431835222),
	(2, 56.2227711874824),
	(3, 14.3178210632764),
	(4, 17.2046505340853),
	(5, 55),
	(6, 18.3575597506858),
	(7, 63.8200595424354),
	(8, 43.0464865000618),
	(9, 58.591808301161),
	(10, 35.2278299076171),
	(11, 40.6078810084939),
	(12, 43.8634243989226),
	(13, 41.1096095821889),
	(14, 34.0147027033899),
	(15, 40.3112887414927),
	(16, 34.132096331752),
	(17, 61.2209114600559),
	(18, 29.2061637330205),
	(19, 32.2024843762092),
	(20, 51.662365412358),
	(21, 57.4891294072192),
	(22, 74.6525284233562),
	(23, 15.2970585407784),
	(24, 28.4429253066558),
	(25, 38.2753184180093),
	(26, 41.1096095821889),
	(27, 0),
	(28, 64.8845127900333),
	(29, 51.6139516022558),
	(30, 59.0338885725818),
	(31, 23.43074902772),
	(32, 35.1283361405006),
	(33, 22.561028345357),
	(34, 42),
	(35, 58.8302643203309),
	(36, 44.2040722106007),
	(37, 38.9486841883009),
	(38, 37.6563407675255),
	(39, 18.0277563773199),
	(40, 30.4138126514911),
	(41, 47.8016736108685),
	(42, 60.4400529450463),
	(43, 27.0185121722126),
	(44, 52.4976189936268),
	(45, 10.816653826392),
	(46, 22.0907220343745),
	(47, 41.6173040933696),
	(48, 51.31276644267),
	(49, 72.1803297304744),
	(50, 15.1327459504216);
/*!40000 ALTER TABLE `random_rt_node27` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node28
DROP TABLE IF EXISTS `random_rt_node28`;
CREATE TABLE IF NOT EXISTS `random_rt_node28` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node28: ~50 rows (approximately)
DELETE FROM `random_rt_node28`;
/*!40000 ALTER TABLE `random_rt_node28` DISABLE KEYS */;
INSERT INTO `random_rt_node28` (`NODEID`, `DISTANCE`) VALUES
	(1, 104.484448603608),
	(2, 36.0138862107382),
	(3, 50.60632371552),
	(4, 47.8539444560216),
	(5, 78.7464284904401),
	(6, 50.2891638427206),
	(7, 7.81024967590665),
	(8, 79.227520471109),
	(9, 58.2151183113115),
	(10, 86.7006343690748),
	(11, 95.5876561068426),
	(12, 65.9241988953981),
	(13, 68.8767014308903),
	(14, 37.8021163428716),
	(15, 75.6637297521078),
	(16, 97.1442226794779),
	(17, 123.555655475579),
	(18, 36.4005494464026),
	(19, 38.3275357934736),
	(20, 19.4164878389476),
	(21, 94.8946784598589),
	(22, 78.0064099930256),
	(23, 79.6241169495775),
	(24, 62.072538211354),
	(25, 89.5600357302296),
	(26, 37.5765884561119),
	(27, 64.8845127900333),
	(28, 0),
	(29, 113.569362065656),
	(30, 33.0605505096331),
	(31, 76.6876782801514),
	(32, 54.1479454827235),
	(33, 86.8158971617526),
	(34, 34.4383507154451),
	(35, 7),
	(36, 30.2654919008431),
	(37, 75.2927619363243),
	(38, 50.3587132480567),
	(39, 57.4891294072192),
	(40, 64.0702739185654),
	(41, 95.0210502993942),
	(42, 69.7208720542134),
	(43, 60),
	(44, 47.5184174820669),
	(45, 54.1202365109392),
	(46, 85.615419172016),
	(47, 72.8971878744304),
	(48, 112.698713391059),
	(49, 80.0999375780032),
	(50, 74.8131004570724);
/*!40000 ALTER TABLE `random_rt_node28` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node29
DROP TABLE IF EXISTS `random_rt_node29`;
CREATE TABLE IF NOT EXISTS `random_rt_node29` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node29: ~50 rows (approximately)
DELETE FROM `random_rt_node29`;
/*!40000 ALTER TABLE `random_rt_node29` DISABLE KEYS */;
INSERT INTO `random_rt_node29` (`NODEID`, `DISTANCE`) VALUES
	(1, 22.4722050542442),
	(2, 93.6215787091843),
	(3, 64.4437739428721),
	(4, 68.1175454637056),
	(5, 63.0317380372777),
	(6, 69.8927750200262),
	(7, 113.863953909918),
	(8, 79.4040301244213),
	(9, 83.3606621854697),
	(10, 62.00806399171),
	(11, 23.0867927612304),
	(12, 63.1506136153878),
	(13, 58.0517010948),
	(14, 77.103826104805),
	(15, 50.4876222454573),
	(16, 39.2045915678253),
	(17, 10),
	(18, 80.0562302385017),
	(19, 83.8152730712011),
	(20, 102.727795654341),
	(21, 86.2844134244418),
	(22, 88.1419309976812),
	(23, 41.7851648315524),
	(24, 74.3303437365925),
	(25, 63.0317380372777),
	(26, 81.0061726043145),
	(27, 51.6139516022558),
	(28, 113.569362065656),
	(29, 0),
	(30, 97.5756117070244),
	(31, 58.2494635168428),
	(32, 83.773504164503),
	(33, 37.8549864614954),
	(34, 83.3546639366988),
	(35, 108.300507847378),
	(36, 95.8018788959799),
	(37, 49.6487663492256),
	(38, 87.2353139502575),
	(39, 67.5351760196122),
	(40, 54.7813836992094),
	(41, 71.449282711585),
	(42, 77.103826104805),
	(43, 56.7978872846517),
	(44, 84.1189633792523),
	(45, 61.8465843842649),
	(46, 40.7921561087423),
	(47, 54.5893762558247),
	(48, 2.23606797749979),
	(49, 83.2946576918352),
	(50, 38.8973006775534);
/*!40000 ALTER TABLE `random_rt_node29` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node3
DROP TABLE IF EXISTS `random_rt_node3`;
CREATE TABLE IF NOT EXISTS `random_rt_node3` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node3: ~50 rows (approximately)
DELETE FROM `random_rt_node3`;
/*!40000 ALTER TABLE `random_rt_node3` DISABLE KEYS */;
INSERT INTO `random_rt_node3` (`NODEID`, `DISTANCE`) VALUES
	(1, 60.1664358259653),
	(2, 44.3846820423443),
	(3, 0),
	(4, 4.12310562561766),
	(5, 53.851648071345),
	(6, 10.770329614269),
	(7, 49.8196748283246),
	(8, 46.7546789102438),
	(9, 51.0881590977792),
	(10, 44.2718872423573),
	(11, 50.1597448159378),
	(12, 40.7062648740952),
	(13, 39.560080889705),
	(14, 21.5870331449229),
	(15, 41.5932686861708),
	(16, 47.8539444560216),
	(17, 74.2765104188397),
	(18, 15.6204993518133),
	(19, 20.8806130178211),
	(20, 38.2883794381533),
	(21, 62.8012738724303),
	(22, 69.5269731830748),
	(23, 29.4108823397055),
	(24, 28.4253408071038),
	(25, 47.4341649025257),
	(26, 29.4108823397055),
	(27, 14.3178210632764),
	(28, 50.60632371552),
	(29, 64.4437739428721),
	(30, 46.690470119715),
	(31, 32.280024783138),
	(32, 30.6757233003559),
	(33, 36.6878726556883),
	(34, 29.6141857899217),
	(35, 44.6542271235322),
	(36, 32.2024843762092),
	(37, 40.4474968323134),
	(38, 31.5753068076939),
	(39, 16.9705627484771),
	(40, 29.1204395571221),
	(41, 55.9464029227975),
	(42, 55.6057550978314),
	(43, 24.3515913237718),
	(44, 43.0464865000618),
	(45, 4),
	(46, 35.9026461420325),
	(47, 41.4849370253831),
	(48, 63.8905313798532),
	(49, 68.0073525436772),
	(50, 25.8069758011279);
/*!40000 ALTER TABLE `random_rt_node3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node30
DROP TABLE IF EXISTS `random_rt_node30`;
CREATE TABLE IF NOT EXISTS `random_rt_node30` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node30: ~50 rows (approximately)
DELETE FROM `random_rt_node30`;
/*!40000 ALTER TABLE `random_rt_node30` DISABLE KEYS */;
INSERT INTO `random_rt_node30` (`NODEID`, `DISTANCE`) VALUES
	(1, 83.2346081867393),
	(2, 4.24264068711928),
	(3, 46.690470119715),
	(4, 46.5725240887801),
	(5, 49.3963561409139),
	(6, 53.1413210223457),
	(7, 39.6232255123179),
	(8, 89.8999443826302),
	(9, 25.9615099714943),
	(10, 90.7083237635885),
	(11, 76.1577310586391),
	(12, 38.8973006775534),
	(13, 43.1856457633784),
	(14, 25.1793566240283),
	(15, 51.0881590977792),
	(16, 93.0053761886914),
	(17, 107.354552767919),
	(18, 41.182520563948),
	(19, 48.8262224629348),
	(20, 42.5440947723653),
	(21, 106.45186705737),
	(22, 45.0111097397076),
	(23, 74.0067564483136),
	(24, 70.6823881882892),
	(25, 93.8616002420585),
	(26, 18.0277563773199),
	(27, 59.0338885725818),
	(28, 33.0605505096331),
	(29, 97.5756117070244),
	(30, 0),
	(31, 78.8542960148653),
	(32, 67.1192967781993),
	(33, 81.0555365166378),
	(34, 17.1172427686237),
	(35, 34.2052627529741),
	(36, 48.91829923454),
	(37, 51.2249938994628),
	(38, 65),
	(39, 61.3514466007119),
	(40, 42.9418211071678),
	(41, 101.833196944808),
	(42, 37.9473319220206),
	(43, 40.853396431631),
	(44, 16.6433169770932),
	(45, 50.6359556046887),
	(46, 81),
	(47, 47.4236228055175),
	(48, 96.1769203083567),
	(49, 47.3814309619285),
	(50, 62.3698645180507);
/*!40000 ALTER TABLE `random_rt_node30` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node31
DROP TABLE IF EXISTS `random_rt_node31`;
CREATE TABLE IF NOT EXISTS `random_rt_node31` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node31: ~50 rows (approximately)
DELETE FROM `random_rt_node31`;
/*!40000 ALTER TABLE `random_rt_node31` DISABLE KEYS */;
INSERT INTO `random_rt_node31` (`NODEID`, `DISTANCE`) VALUES
	(1, 65.6201188660917),
	(2, 76.6550715869472),
	(3, 32.280024783138),
	(4, 32.3882694814033),
	(5, 77.987178433381),
	(6, 27.0185121722126),
	(7, 73.3757453113766),
	(8, 22.3606797749979),
	(9, 81.6333265278342),
	(10, 12.0830459735946),
	(11, 56.0892146495206),
	(12, 67.2681202353686),
	(13, 64.3506021727847),
	(14, 53.851648071345),
	(15, 62.8012738724303),
	(16, 24.0831891575846),
	(17, 66.098411478643),
	(18, 41.1096095821889),
	(19, 38.6005181312376),
	(20, 59.464274989274),
	(21, 34.6698716467194),
	(22, 98.0815986819138),
	(23, 18.2482875908947),
	(24, 18.3847763108502),
	(25, 15.2315462117278),
	(26, 61.6846820531645),
	(27, 23.43074902772),
	(28, 76.6876782801514),
	(29, 58.2494635168428),
	(30, 78.8542960148653),
	(31, 0),
	(32, 29),
	(33, 20.3960780543711),
	(34, 61.8465843842649),
	(35, 69.8569967862919),
	(36, 49.2442890089805),
	(37, 61.400325732035),
	(38, 33.3016516106934),
	(39, 19.2353840616713),
	(40, 53.7587202228625),
	(41, 24.4131112314674),
	(42, 83.868945385047),
	(43, 50.4479930225178),
	(44, 74.7328575661335),
	(45, 28.4604989415154),
	(46, 17.464249196573),
	(47, 64.5368112010502),
	(48, 58.8557558782486),
	(49, 95.5876561068426),
	(50, 34);
/*!40000 ALTER TABLE `random_rt_node31` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node32
DROP TABLE IF EXISTS `random_rt_node32`;
CREATE TABLE IF NOT EXISTS `random_rt_node32` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node32: ~50 rows (approximately)
DELETE FROM `random_rt_node32`;
/*!40000 ALTER TABLE `random_rt_node32` DISABLE KEYS */;
INSERT INTO `random_rt_node32` (`NODEID`, `DISTANCE`) VALUES
	(1, 85.842879728024),
	(2, 66.4003012041361),
	(3, 30.6757233003559),
	(4, 27.3130005674953),
	(5, 84.504437753292),
	(6, 19.9248588451713),
	(7, 49.0407993409569),
	(8, 25.0798724079689),
	(9, 79.0253124005214),
	(10, 35.3411940941446),
	(11, 75.6637297521078),
	(12, 71.175838597097),
	(13, 70.2281994643178),
	(14, 46.0108682813094),
	(15, 72.034713853808),
	(16, 53.0377224247045),
	(17, 92.5742944882649),
	(18, 26.2488094968134),
	(19, 18.3575597506858),
	(20, 35),
	(21, 41),
	(22, 98.737024463977),
	(23, 42.0475920832573),
	(24, 10.6301458127347),
	(25, 37.6961536499415),
	(26, 53.7401153701776),
	(27, 35.1283361405006),
	(28, 54.1479454827235),
	(29, 83.773504164503),
	(30, 67.1192967781993),
	(31, 29),
	(32, 0),
	(33, 47.169905660283),
	(34, 52.4022900262956),
	(35, 47.169905660283),
	(36, 24),
	(37, 70.8307842678591),
	(38, 4.47213595499958),
	(39, 17.1172427686237),
	(40, 59.7745765355138),
	(41, 41.4366987102013),
	(42, 85.2349693494401),
	(43, 55.0272659687904),
	(44, 69.3541635375988),
	(45, 29.6141857899217),
	(46, 44.6542271235322),
	(47, 72.1248916810278),
	(48, 83.9344982709732),
	(49, 97.7547952787995),
	(50, 50.2493781056045);
/*!40000 ALTER TABLE `random_rt_node32` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node33
DROP TABLE IF EXISTS `random_rt_node33`;
CREATE TABLE IF NOT EXISTS `random_rt_node33` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node33: ~50 rows (approximately)
DELETE FROM `random_rt_node33`;
/*!40000 ALTER TABLE `random_rt_node33` DISABLE KEYS */;
INSERT INTO `random_rt_node33` (`NODEID`, `DISTANCE`) VALUES
	(1, 46.8401537145215),
	(2, 78),
	(3, 36.6878726556883),
	(4, 39),
	(5, 67.4240313241503),
	(6, 37.4432904536981),
	(7, 85.0881895447306),
	(8, 42),
	(9, 77.2010362624751),
	(10, 25.9615099714943),
	(11, 38.0788655293195),
	(12, 59.5063021872474),
	(13, 55.4707129934347),
	(14, 56.3205113613149),
	(15, 51.6139516022558),
	(16, 12.1655250605964),
	(17, 45.8802789878178),
	(18, 50.5371150739731),
	(19, 51.4003891035856),
	(20, 72.1110255092798),
	(21, 51.2445119012758),
	(22, 90.3548559846121),
	(23, 7.28010988928052),
	(24, 37.1214223865412),
	(25, 27.8567765543682),
	(26, 63.0317380372777),
	(27, 22.561028345357),
	(28, 86.8158971617526),
	(29, 37.8549864614954),
	(30, 81.0555365166378),
	(31, 20.3960780543711),
	(32, 47.169905660283),
	(33, 0),
	(34, 64.1950153828161),
	(35, 80.4984471899924),
	(36, 63.2534584034739),
	(37, 50.2195181179589),
	(38, 51.0392006206994),
	(39, 32.5269119345812),
	(40, 46.2385120867876),
	(41, 37.5765884561119),
	(42, 76.4852927038918),
	(43, 44.6430285710994),
	(44, 72.8354309385206),
	(45, 32.8937684067971),
	(46, 3),
	(47, 54.3783044972901),
	(48, 38.4707681233427),
	(49, 86.9540108333135),
	(50, 22.3606797749979);
/*!40000 ALTER TABLE `random_rt_node33` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node34
DROP TABLE IF EXISTS `random_rt_node34`;
CREATE TABLE IF NOT EXISTS `random_rt_node34` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node34: ~50 rows (approximately)
DELETE FROM `random_rt_node34`;
/*!40000 ALTER TABLE `random_rt_node34` DISABLE KEYS */;
INSERT INTO `random_rt_node34` (`NODEID`, `DISTANCE`) VALUES
	(1, 71.4212853426764),
	(2, 14.8660687473185),
	(3, 29.6141857899217),
	(4, 29.732137494637),
	(5, 44.9110231457712),
	(6, 36.6742416417845),
	(7, 38.3275357934736),
	(8, 73.9256383131049),
	(9, 28.7923600977759),
	(10, 73.7631344236401),
	(11, 63.2534584034739),
	(12, 31.6227766016838),
	(13, 34.4383507154451),
	(14, 8.06225774829855),
	(15, 41.3400532171888),
	(16, 76.0591874792257),
	(17, 93.2952303175248),
	(18, 26.1725046566048),
	(19, 34.7131099154196),
	(20, 35.2278299076171),
	(21, 90.4267659490264),
	(22, 49.6487663492256),
	(23, 57.0788927713213),
	(24, 54.7083174663597),
	(25, 76.9220384545287),
	(26, 3.16227766016838),
	(27, 42),
	(28, 34.4383507154451),
	(29, 83.3546639366988),
	(30, 17.1172427686237),
	(31, 61.8465843842649),
	(32, 52.4022900262956),
	(33, 64.1950153828161),
	(34, 0),
	(35, 32.0156211871642),
	(36, 38.0788655293195),
	(37, 41.0487515035476),
	(38, 50.9313263129874),
	(39, 44.7772263544762),
	(40, 30.4138126514911),
	(41, 85.0940655980192),
	(42, 38.3275357934736),
	(43, 27.0185121722126),
	(44, 17.8885438199983),
	(45, 33.5410196624968),
	(46, 64.0312423743285),
	(47, 38.4707681233427),
	(48, 82.1522975941635),
	(49, 50.2195181179589),
	(50, 46.4865571966778);
/*!40000 ALTER TABLE `random_rt_node34` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node35
DROP TABLE IF EXISTS `random_rt_node35`;
CREATE TABLE IF NOT EXISTS `random_rt_node35` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node35: ~50 rows (approximately)
DELETE FROM `random_rt_node35`;
/*!40000 ALTER TABLE `random_rt_node35` DISABLE KEYS */;
INSERT INTO `random_rt_node35` (`NODEID`, `DISTANCE`) VALUES
	(1, 100.209779961838),
	(2, 36.4965751817893),
	(3, 44.6542271235322),
	(4, 41.6773319683494),
	(5, 76.9025357189215),
	(6, 43.6577599058861),
	(7, 6.32455532033676),
	(8, 72.2495674727538),
	(9, 58.0344725141876),
	(10, 79.7621464104371),
	(11, 91.0494371207203),
	(12, 63.6003144646314),
	(13, 66.1286624694618),
	(14, 34),
	(15, 72.4982758415674),
	(16, 90.6200860736735),
	(17, 118.258192105241),
	(18, 29.9666481275434),
	(19, 31.4006369362152),
	(20, 12.6491106406735),
	(21, 87.965902484997),
	(22, 78.4091831356507),
	(23, 73.3552997403732),
	(24, 55.0817574156816),
	(25, 82.6075057122535),
	(26, 35.1710107901379),
	(27, 58.8302643203309),
	(28, 7),
	(29, 108.300507847378),
	(30, 34.2052627529741),
	(31, 69.8569967862919),
	(32, 47.169905660283),
	(33, 80.4984471899924),
	(34, 32.0156211871642),
	(35, 0),
	(36, 23.3452350598575),
	(37, 72.0138875495553),
	(38, 43.4165866921848),
	(39, 50.6951674225463),
	(40, 60.4152298679729),
	(41, 88.0227243386615),
	(42, 69.065186599328),
	(43, 56.0802995712398),
	(44, 47),
	(45, 48.0208288141719),
	(46, 79.2022726946645),
	(47, 70.0071424927486),
	(48, 107.517440445725),
	(49, 80.0562302385017),
	(50, 69.4262198308391);
/*!40000 ALTER TABLE `random_rt_node35` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node36
DROP TABLE IF EXISTS `random_rt_node36`;
CREATE TABLE IF NOT EXISTS `random_rt_node36` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node36: ~50 rows (approximately)
DELETE FROM `random_rt_node36`;
/*!40000 ALTER TABLE `random_rt_node36` DISABLE KEYS */;
INSERT INTO `random_rt_node36` (`NODEID`, `DISTANCE`) VALUES
	(1, 92.3092628071528),
	(2, 49.4064773081425),
	(3, 32.2024843762092),
	(4, 28.1780056072107),
	(5, 79.227520471109),
	(6, 26.1725046566048),
	(7, 25.0798724079689),
	(8, 49.0407993409569),
	(9, 66.8505796534331),
	(10, 57.974132162543),
	(11, 82.3468275041607),
	(12, 65.1920240520265),
	(13, 66),
	(14, 34.7131099154196),
	(15, 70.3491293478462),
	(16, 71.8679344353238),
	(17, 105.422957651548),
	(18, 17.464249196573),
	(19, 12.0415945787923),
	(20, 11),
	(21, 64.6297145282261),
	(22, 87.6641317757725),
	(23, 56.6392090340252),
	(24, 32.7566787083184),
	(25, 60.6382717431821),
	(26, 40.4969134626332),
	(27, 44.2040722106007),
	(28, 30.2654919008431),
	(29, 95.8018788959799),
	(30, 48.91829923454),
	(31, 49.2442890089805),
	(32, 24),
	(33, 63.2534584034739),
	(34, 38.0788655293195),
	(35, 23.3452350598575),
	(36, 0),
	(37, 69.462219947249),
	(38, 20.0997512422418),
	(39, 31.0644491340181),
	(40, 57.3149195236284),
	(41, 65.2763356814704),
	(42, 75.690157880665),
	(43, 52.3450093132096),
	(44, 55.9464029227975),
	(45, 34.132096331752),
	(46, 61.400325732035),
	(47, 69.065186599328),
	(48, 95.4410813015025),
	(49, 87.9317917479224),
	(50, 57.8013840664737);
/*!40000 ALTER TABLE `random_rt_node36` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node37
DROP TABLE IF EXISTS `random_rt_node37`;
CREATE TABLE IF NOT EXISTS `random_rt_node37` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node37: ~50 rows (approximately)
DELETE FROM `random_rt_node37`;
/*!40000 ALTER TABLE `random_rt_node37` DISABLE KEYS */;
INSERT INTO `random_rt_node37` (`NODEID`, `DISTANCE`) VALUES
	(1, 32.2490309931942),
	(2, 47.0106370941726),
	(3, 40.4474968323134),
	(4, 44.2831796509691),
	(5, 17.2046505340853),
	(6, 50.9901951359278),
	(7, 78.2943165242535),
	(8, 81.9878039710785),
	(9, 33.734255586866),
	(10, 72.2495674727538),
	(11, 26.6833281282527),
	(12, 13.6014705087354),
	(13, 8.54400374531753),
	(14, 38.0788655293195),
	(15, 1.4142135623731),
	(16, 61.400325732035),
	(17, 58.6941223633168),
	(18, 52.1536192416212),
	(19, 60),
	(20, 71.5681493403316),
	(21, 96.0208310732624),
	(22, 41.1096095821889),
	(23, 46.0108682813094),
	(24, 66.4830805543786),
	(25, 75.0066663703967),
	(26, 38.0131556174964),
	(27, 38.9486841883009),
	(28, 75.2927619363243),
	(29, 49.6487663492256),
	(30, 51.2249938994628),
	(31, 61.400325732035),
	(32, 70.8307842678591),
	(33, 50.2195181179589),
	(34, 41.0487515035476),
	(35, 72.0138875495553),
	(36, 69.462219947249),
	(37, 0),
	(38, 72.0069441095788),
	(39, 55.0272659687904),
	(40, 12.1655250605964),
	(41, 84.9588135510378),
	(42, 28.2842712474619),
	(43, 17.1172427686237),
	(44, 35.8468966578698),
	(45, 41.2310562561766),
	(46, 52.0096144957834),
	(47, 5),
	(48, 47.8539444560216),
	(49, 37.1618083521241),
	(50, 28.3196045170126);
/*!40000 ALTER TABLE `random_rt_node37` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node38
DROP TABLE IF EXISTS `random_rt_node38`;
CREATE TABLE IF NOT EXISTS `random_rt_node38` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node38: ~50 rows (approximately)
DELETE FROM `random_rt_node38`;
/*!40000 ALTER TABLE `random_rt_node38` DISABLE KEYS */;
INSERT INTO `random_rt_node38` (`NODEID`, `DISTANCE`) VALUES
	(1, 88.4590300647707),
	(2, 64.5368112010502),
	(3, 31.5753068076939),
	(4, 27.8926513619627),
	(5, 85.0705589496155),
	(6, 21.095023109729),
	(7, 45),
	(8, 29),
	(9, 78.2368199762746),
	(10, 39.8120584747888),
	(11, 78.2623792124926),
	(12, 71.5122367151245),
	(13, 70.8801805866774),
	(14, 45),
	(15, 73.1641988953614),
	(16, 57.2800139664787),
	(17, 96.1769203083567),
	(18, 24.8394846967484),
	(19, 16.2788205960997),
	(20, 31.0644491340181),
	(21, 44.5533388198909),
	(22, 98.2700361249552),
	(23, 45.6508488420533),
	(24, 15),
	(25, 42.154477816716),
	(26, 52.4976189936268),
	(27, 37.6563407675255),
	(28, 50.3587132480567),
	(29, 87.2353139502575),
	(30, 65),
	(31, 33.3016516106934),
	(32, 4.47213595499958),
	(33, 51.0392006206994),
	(34, 50.9313263129874),
	(35, 43.4165866921848),
	(36, 20.0997512422418),
	(37, 72.0069441095788),
	(38, 0),
	(39, 19.9248588451713),
	(40, 60.6382717431821),
	(41, 45.7055795281058),
	(42, 85),
	(43, 55.7853027239254),
	(44, 68.2495421230062),
	(45, 31.0644491340181),
	(46, 48.6004115208915),
	(47, 73.0068489937759),
	(48, 87.3212459828649),
	(49, 97.5294827218929),
	(50, 52.773099207835);
/*!40000 ALTER TABLE `random_rt_node38` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node39
DROP TABLE IF EXISTS `random_rt_node39`;
CREATE TABLE IF NOT EXISTS `random_rt_node39` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node39: ~50 rows (approximately)
DELETE FROM `random_rt_node39`;
/*!40000 ALTER TABLE `random_rt_node39` DISABLE KEYS */;
INSERT INTO `random_rt_node39` (`NODEID`, `DISTANCE`) VALUES
	(1, 68.7313611097583),
	(2, 59.6154342431555),
	(3, 16.9705627484771),
	(4, 15.2643375224737),
	(5, 69.7710541700496),
	(6, 8.24621125123532),
	(7, 54.4242592967511),
	(8, 29.8328677803526),
	(9, 68.0147042925278),
	(10, 30.0665927567458),
	(11, 58.5491246732178),
	(12, 57.1401785086466),
	(13, 55.4707129934347),
	(14, 37.1214223865412),
	(15, 56.302753041037),
	(16, 40.8166632639171),
	(17, 76.6615940350838),
	(18, 22),
	(19, 19.6977156035922),
	(20, 40.7185461430047),
	(21, 46.0434577328854),
	(22, 86.4522989862039),
	(23, 26.4007575648882),
	(24, 11.6619037896906),
	(25, 33.1360830515618),
	(26, 45.1774279923061),
	(27, 18.0277563773199),
	(28, 57.4891294072192),
	(29, 67.5351760196122),
	(30, 61.3514466007119),
	(31, 19.2353840616713),
	(32, 17.1172427686237),
	(33, 32.5269119345812),
	(34, 44.7772263544762),
	(35, 50.6951674225463),
	(36, 31.0644491340181),
	(37, 55.0272659687904),
	(38, 19.9248588451713),
	(39, 0),
	(40, 44.7213595499958),
	(41, 40.5215991787096),
	(42, 72.4706837279738),
	(43, 40.3112887414927),
	(44, 59.6405902049938),
	(45, 14.422205101856),
	(46, 30.4795013082563),
	(47, 56.859475903318),
	(48, 67.5425791630731),
	(49, 84.8115558164098),
	(50, 33.1360830515618);
/*!40000 ALTER TABLE `random_rt_node39` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node4
DROP TABLE IF EXISTS `random_rt_node4`;
CREATE TABLE IF NOT EXISTS `random_rt_node4` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node4: ~50 rows (approximately)
DELETE FROM `random_rt_node4`;
/*!40000 ALTER TABLE `random_rt_node4` DISABLE KEYS */;
INSERT INTO `random_rt_node4` (`NODEID`, `DISTANCE`) VALUES
	(1, 64.2572953056694),
	(2, 44.5982062419555),
	(3, 4.12310562561766),
	(4, 0),
	(5, 57.2450871254468),
	(6, 7.81024967590665),
	(7, 46.6154480832267),
	(8, 45),
	(9, 53.0377224247045),
	(10, 44.1474801092882),
	(11, 54.230987451825),
	(12, 43.8634243989226),
	(13, 43.0116263352131),
	(14, 21.9317121994613),
	(15, 45.3982378512647),
	(16, 49.7292670366254),
	(17, 77.8973683766018),
	(18, 12.0415945787923),
	(19, 16.7630546142402),
	(20, 34.6554469023269),
	(21, 61.2943716828878),
	(22, 72.0069441095788),
	(23, 31.7804971641414),
	(24, 26.1725046566048),
	(25, 47.2969343615419),
	(26, 29.9666481275434),
	(27, 17.2046505340853),
	(28, 47.8539444560216),
	(29, 68.1175454637056),
	(30, 46.5725240887801),
	(31, 32.3882694814033),
	(32, 27.3130005674953),
	(33, 39),
	(34, 29.732137494637),
	(35, 41.6773319683494),
	(36, 28.1780056072107),
	(37, 44.2831796509691),
	(38, 27.8926513619627),
	(39, 15.2643375224737),
	(40, 32.7566787083184),
	(41, 55.3624421426656),
	(42, 58.2494635168428),
	(43, 27.8926513619627),
	(44, 44.407206622349),
	(45, 6.40312423743285),
	(46, 37.9473319220206),
	(47, 45.1220566907139),
	(48, 67.6239602507869),
	(49, 70.7248188403477),
	(50, 29.6816441593117);
/*!40000 ALTER TABLE `random_rt_node4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node40
DROP TABLE IF EXISTS `random_rt_node40`;
CREATE TABLE IF NOT EXISTS `random_rt_node40` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node40: ~50 rows (approximately)
DELETE FROM `random_rt_node40`;
/*!40000 ALTER TABLE `random_rt_node40` DISABLE KEYS */;
INSERT INTO `random_rt_node40` (`NODEID`, `DISTANCE`) VALUES
	(1, 41.0365690573664),
	(2, 38.9101529166874),
	(3, 29.1204395571221),
	(4, 32.7566787083184),
	(5, 25.0599281722833),
	(6, 39.8497176903426),
	(7, 66.6483308118065),
	(8, 73.0068489937759),
	(9, 31.4006369362152),
	(10, 65.299310869258),
	(11, 33.2866339541865),
	(12, 13.6014705087354),
	(13, 10.816653826392),
	(14, 26.4196896272458),
	(15, 13.0384048104053),
	(16, 58.1893461039046),
	(17, 64.4748012792595),
	(18, 40.0499687890016),
	(19, 48.0416485978573),
	(20, 59.4810894318522),
	(21, 87.8635305459552),
	(22, 44.6542271235322),
	(23, 40.7062648740952),
	(24, 56.3560112144215),
	(25, 68.2495421230062),
	(26, 27.5862284482674),
	(27, 30.4138126514911),
	(28, 64.0702739185654),
	(29, 54.7813836992094),
	(30, 42.9418211071678),
	(31, 53.7587202228625),
	(32, 59.7745765355138),
	(33, 46.2385120867876),
	(34, 30.4138126514911),
	(35, 60.4152298679729),
	(36, 57.3149195236284),
	(37, 12.1655250605964),
	(38, 60.6382717431821),
	(39, 44.7213595499958),
	(40, 0),
	(41, 77.987178433381),
	(42, 30.5286750449475),
	(43, 5),
	(44, 29.6141857899217),
	(45, 30.4630924234556),
	(46, 47.4236228055175),
	(47, 12.369316876853),
	(48, 53.3104117410474),
	(49, 41.8688428309166),
	(50, 24.0416305603426);
/*!40000 ALTER TABLE `random_rt_node40` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node41
DROP TABLE IF EXISTS `random_rt_node41`;
CREATE TABLE IF NOT EXISTS `random_rt_node41` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node41: ~50 rows (approximately)
DELETE FROM `random_rt_node41`;
/*!40000 ALTER TABLE `random_rt_node41` DISABLE KEYS */;
INSERT INTO `random_rt_node41` (`NODEID`, `DISTANCE`) VALUES
	(1, 84.154619599877),
	(2, 99.9599919967984),
	(3, 55.9464029227975),
	(4, 55.3624421426656),
	(5, 101.833196944808),
	(6, 48.7647413609464),
	(7, 90.3548559846121),
	(8, 17.8885438199983),
	(9, 106),
	(10, 12.7279220613579),
	(11, 75.6439025963098),
	(12, 91.5478017212866),
	(13, 88.4590300647707),
	(14, 77.2528316633119),
	(15, 86.3712915267567),
	(16, 32.2490309931942),
	(17, 77),
	(18, 61.9838688692469),
	(19, 57.0788927713213),
	(20, 76.2364742101837),
	(21, 15.0332963783729),
	(22, 122.441822920112),
	(23, 39.4081209904761),
	(24, 33.0151480384384),
	(25, 10),
	(26, 85.2349693494401),
	(27, 47.8016736108685),
	(28, 95.0210502993942),
	(29, 71.449282711585),
	(30, 101.833196944808),
	(31, 24.4131112314674),
	(32, 41.4366987102013),
	(33, 37.5765884561119),
	(34, 85.0940655980192),
	(35, 88.0227243386615),
	(36, 65.2763356814704),
	(37, 84.9588135510378),
	(38, 45.7055795281058),
	(39, 40.5215991787096),
	(40, 77.987178433381),
	(41, 0),
	(42, 108.231233939192),
	(43, 74.8131004570724),
	(44, 98.8382517044894),
	(45, 52.3259018078045),
	(46, 34.8855270850248),
	(47, 88.3911760301898),
	(48, 72.691127381545),
	(49, 119.854077944808),
	(50, 56.8506816142076);
/*!40000 ALTER TABLE `random_rt_node41` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node42
DROP TABLE IF EXISTS `random_rt_node42`;
CREATE TABLE IF NOT EXISTS `random_rt_node42` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node42: ~50 rows (approximately)
DELETE FROM `random_rt_node42`;
/*!40000 ALTER TABLE `random_rt_node42` DISABLE KEYS */;
INSERT INTO `random_rt_node42` (`NODEID`, `DISTANCE`) VALUES
	(1, 57.2712842531054),
	(2, 34.2052627529741),
	(3, 55.6057550978314),
	(4, 58.2494635168428),
	(5, 15.2315462117278),
	(6, 66.0302960768767),
	(7, 75.1664818918645),
	(8, 101.911726508778),
	(9, 12.0830459735946),
	(10, 95.603347221737),
	(11, 54.0370243444252),
	(12, 17),
	(13, 21.1896201004171),
	(14, 41.1096095821889),
	(15, 27.1661554144122),
	(16, 88.2383136738231),
	(17, 85.5862138431184),
	(18, 60.9261848469113),
	(19, 69.8569967862919),
	(20, 73.5527021937332),
	(21, 117.388244726634),
	(22, 14.2126704035519),
	(23, 71.1969100453102),
	(24, 84.0238061504),
	(25, 98.600202839548),
	(26, 35.5105618091294),
	(27, 60.4400529450463),
	(28, 69.7208720542134),
	(29, 77.103826104805),
	(30, 37.9473319220206),
	(31, 83.868945385047),
	(32, 85.2349693494401),
	(33, 76.4852927038918),
	(34, 38.3275357934736),
	(35, 69.065186599328),
	(36, 75.690157880665),
	(37, 28.2842712474619),
	(38, 85),
	(39, 72.4706837279738),
	(40, 30.5286750449475),
	(41, 108.231233939192),
	(42, 0),
	(43, 33.4215499341368),
	(44, 22.2036033111745),
	(45, 58.1377674149945),
	(46, 77.8267306264371),
	(47, 23.3452350598575),
	(48, 75.1664818918645),
	(49, 12.5299640861417),
	(50, 54.1294744108974);
/*!40000 ALTER TABLE `random_rt_node42` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node43
DROP TABLE IF EXISTS `random_rt_node43`;
CREATE TABLE IF NOT EXISTS `random_rt_node43` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node43: ~50 rows (approximately)
DELETE FROM `random_rt_node43`;
/*!40000 ALTER TABLE `random_rt_node43` DISABLE KEYS */;
INSERT INTO `random_rt_node43` (`NODEID`, `DISTANCE`) VALUES
	(1, 44.5982062419555),
	(2, 37),
	(3, 24.3515913237718),
	(4, 27.8926513619627),
	(5, 29.5465734053883),
	(6, 35.1140997321589),
	(7, 62.2655603042324),
	(8, 69.0289794216893),
	(9, 32.5729949498047),
	(10, 62.201286160336),
	(11, 36.2353418639869),
	(12, 17.0293863659264),
	(13, 15.2315462117278),
	(14, 22.2036033111745),
	(15, 18.0277563773199),
	(16, 56.7538544946508),
	(17, 66.6483308118065),
	(18, 35.0570962859162),
	(19, 43.0464865000618),
	(20, 54.7083174663597),
	(21, 84.1724420460759),
	(22, 47.6340214552582),
	(23, 38.6264158316559),
	(24, 51.9711458407451),
	(25, 65.2150289427215),
	(26, 24.4131112314674),
	(27, 27.0185121722126),
	(28, 60),
	(29, 56.7978872846517),
	(30, 40.853396431631),
	(31, 50.4479930225178),
	(32, 55.0272659687904),
	(33, 44.6430285710994),
	(34, 27.0185121722126),
	(35, 56.0802995712398),
	(36, 52.3450093132096),
	(37, 17.1172427686237),
	(38, 55.7853027239254),
	(39, 40.3112887414927),
	(40, 5),
	(41, 74.8131004570724),
	(42, 33.4215499341368),
	(43, 0),
	(44, 29.0172362570938),
	(45, 25.9422435421457),
	(46, 45.5411901469428),
	(47, 17.2626765016321),
	(48, 55.4707129934347),
	(49, 45.254833995939),
	(50, 23.0867927612304);
/*!40000 ALTER TABLE `random_rt_node43` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node44
DROP TABLE IF EXISTS `random_rt_node44`;
CREATE TABLE IF NOT EXISTS `random_rt_node44` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node44: ~50 rows (approximately)
DELETE FROM `random_rt_node44`;
/*!40000 ALTER TABLE `random_rt_node44` DISABLE KEYS */;
INSERT INTO `random_rt_node44` (`NODEID`, `DISTANCE`) VALUES
	(1, 68.0955211449329),
	(2, 12.5299640861417),
	(3, 43.0464865000618),
	(4, 44.407206622349),
	(5, 32.7566787083184),
	(6, 52.0096144957834),
	(7, 53.0377224247045),
	(8, 89.4035793466906),
	(9, 11.1803398874989),
	(10, 86.8158971617526),
	(11, 61.8465843842649),
	(12, 22.8035085019828),
	(13, 27.459060435492),
	(14, 23.3452350598575),
	(15, 35.5105618091294),
	(16, 85),
	(17, 93.637599285757),
	(18, 43.4165866921848),
	(19, 52.2015325445528),
	(20, 52.3927475897189),
	(21, 105.683489722851),
	(22, 32.0156211871642),
	(23, 66.2872536767062),
	(24, 70.4343666117613),
	(25, 89.9611027055582),
	(26, 15.8113883008419),
	(27, 52.4976189936268),
	(28, 47.5184174820669),
	(29, 84.1189633792523),
	(30, 16.6433169770932),
	(31, 74.7328575661335),
	(32, 69.3541635375988),
	(33, 72.8354309385206),
	(34, 17.8885438199983),
	(35, 47),
	(36, 55.9464029227975),
	(37, 35.8468966578698),
	(38, 68.2495421230062),
	(39, 59.6405902049938),
	(40, 29.6141857899217),
	(41, 98.8382517044894),
	(42, 22.2036033111745),
	(43, 29.0172362570938),
	(44, 0),
	(45, 46.5295604965274),
	(46, 73.348483283569),
	(47, 31.6227766016838),
	(48, 82.5408989531856),
	(49, 33.1360830515618),
	(50, 52.0096144957834);
/*!40000 ALTER TABLE `random_rt_node44` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node45
DROP TABLE IF EXISTS `random_rt_node45`;
CREATE TABLE IF NOT EXISTS `random_rt_node45` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node45: ~50 rows (approximately)
DELETE FROM `random_rt_node45`;
/*!40000 ALTER TABLE `random_rt_node45` DISABLE KEYS */;
INSERT INTO `random_rt_node45` (`NODEID`, `DISTANCE`) VALUES
	(1, 58.821764679411),
	(2, 48.2700735445887),
	(3, 4),
	(4, 6.40312423743285),
	(5, 55.4616984954482),
	(6, 10),
	(7, 53.0094331227943),
	(8, 43.8406204335659),
	(9, 54.2033209314706),
	(10, 40.4969134626332),
	(11, 48.7031826475437),
	(12, 42.7200187265877),
	(13, 41.146081222882),
	(14, 25.4950975679639),
	(15, 42.4499705535822),
	(16, 43.9317652729776),
	(17, 71.5891053163818),
	(18, 18.4390889145858),
	(19, 22.3606797749979),
	(20, 41.0121933088198),
	(21, 59.6657355607052),
	(22, 72.1803297304744),
	(23, 25.6320112359526),
	(24, 26.0768096208106),
	(25, 43.6577599058861),
	(26, 33.2415402771893),
	(27, 10.816653826392),
	(28, 54.1202365109392),
	(29, 61.8465843842649),
	(30, 50.6359556046887),
	(31, 28.4604989415154),
	(32, 29.6141857899217),
	(33, 32.8937684067971),
	(34, 33.5410196624968),
	(35, 48.0208288141719),
	(36, 34.132096331752),
	(37, 41.2310562561766),
	(38, 31.0644491340181),
	(39, 14.422205101856),
	(40, 30.4630924234556),
	(41, 52.3259018078045),
	(42, 58.1377674149945),
	(43, 25.9422435421457),
	(44, 46.5295604965274),
	(45, 0),
	(46, 32.0156211871642),
	(47, 42.7200187265877),
	(48, 61.400325732035),
	(49, 70.4343666117613),
	(50, 23.7065391822594);
/*!40000 ALTER TABLE `random_rt_node45` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node46
DROP TABLE IF EXISTS `random_rt_node46`;
CREATE TABLE IF NOT EXISTS `random_rt_node46` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node46: ~50 rows (approximately)
DELETE FROM `random_rt_node46`;
/*!40000 ALTER TABLE `random_rt_node46` DISABLE KEYS */;
INSERT INTO `random_rt_node46` (`NODEID`, `DISTANCE`) VALUES
	(1, 49.7292670366254),
	(2, 78.0576709875461),
	(3, 35.9026461420325),
	(4, 37.9473319220206),
	(5, 69.2026011071838),
	(6, 35.8468966578698),
	(7, 83.6480723029527),
	(8, 39),
	(9, 78.108898340714),
	(10, 23.0867927612304),
	(11, 40.853396431631),
	(12, 60.8276253029822),
	(13, 56.938563381947),
	(14, 56.0802995712398),
	(15, 53.4134814442946),
	(16, 12.0415945787923),
	(17, 48.7031826475437),
	(18, 49.2442890089805),
	(19, 49.6487663492256),
	(20, 70.4911341943084),
	(21, 48.3838816136118),
	(22, 91.7877987534291),
	(23, 7.07106781186548),
	(24, 34.4818792991333),
	(25, 25.0798724079689),
	(26, 63.0079360080935),
	(27, 22.0907220343745),
	(28, 85.615419172016),
	(29, 40.7921561087423),
	(30, 81),
	(31, 17.464249196573),
	(32, 44.6542271235322),
	(33, 3),
	(34, 64.0312423743285),
	(35, 79.2022726946645),
	(36, 61.400325732035),
	(37, 52.0096144957834),
	(38, 48.6004115208915),
	(39, 30.4795013082563),
	(40, 47.4236228055175),
	(41, 34.8855270850248),
	(42, 77.8267306264371),
	(43, 45.5411901469428),
	(44, 73.348483283569),
	(45, 32.0156211871642),
	(46, 0),
	(47, 56.0357029044876),
	(48, 41.4366987102013),
	(49, 88.5098864534352),
	(50, 23.8537208837531);
/*!40000 ALTER TABLE `random_rt_node46` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node47
DROP TABLE IF EXISTS `random_rt_node47`;
CREATE TABLE IF NOT EXISTS `random_rt_node47` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node47: ~50 rows (approximately)
DELETE FROM `random_rt_node47`;
/*!40000 ALTER TABLE `random_rt_node47` DISABLE KEYS */;
INSERT INTO `random_rt_node47` (`NODEID`, `DISTANCE`) VALUES
	(1, 36.6742416417845),
	(2, 43.1856457633784),
	(3, 41.4849370253831),
	(4, 45.1220566907139),
	(5, 13.4536240470737),
	(6, 52.2015325445528),
	(7, 76.3216876123687),
	(8, 84.5990543682375),
	(9, 28.8617393793236),
	(10, 75.6637297521078),
	(11, 31.5753068076939),
	(12, 8.94427190999916),
	(13, 4.24264068711928),
	(14, 36.4005494464026),
	(15, 4.12310562561766),
	(16, 65.7647321898295),
	(17, 63.5609943282828),
	(18, 52.0096144957834),
	(19, 60.2079728939615),
	(20, 70.4059656563278),
	(21, 99.0201999594022),
	(22, 36.4005494464026),
	(23, 49.8196748283246),
	(24, 68.4470598345904),
	(25, 78.4920378127616),
	(26, 35.3553390593274),
	(27, 41.6173040933696),
	(28, 72.8971878744304),
	(29, 54.5893762558247),
	(30, 47.4236228055175),
	(31, 64.5368112010502),
	(32, 72.1248916810278),
	(33, 54.3783044972901),
	(34, 38.4707681233427),
	(35, 70.0071424927486),
	(36, 69.065186599328),
	(37, 5),
	(38, 73.0068489937759),
	(39, 56.859475903318),
	(40, 12.369316876853),
	(41, 88.3911760301898),
	(42, 23.3452350598575),
	(43, 17.2626765016321),
	(44, 31.6227766016838),
	(45, 42.7200187265877),
	(46, 56.0357029044876),
	(47, 0),
	(48, 52.773099207835),
	(49, 32.649655434629),
	(50, 32.2024843762092);
/*!40000 ALTER TABLE `random_rt_node47` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node48
DROP TABLE IF EXISTS `random_rt_node48`;
CREATE TABLE IF NOT EXISTS `random_rt_node48` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node48: ~50 rows (approximately)
DELETE FROM `random_rt_node48`;
/*!40000 ALTER TABLE `random_rt_node48` DISABLE KEYS */;
INSERT INTO `random_rt_node48` (`NODEID`, `DISTANCE`) VALUES
	(1, 20.2484567313166),
	(2, 92.1954445729289),
	(3, 63.8905313798532),
	(4, 67.6239602507869),
	(5, 61.0081961706786),
	(6, 69.6419413859206),
	(7, 113.137084989848),
	(8, 80.2246844805263),
	(9, 81.5843122174846),
	(10, 63.0079360080935),
	(11, 21.2132034355964),
	(12, 61.3921819126833),
	(13, 56.2938717801503),
	(14, 76.0263112349929),
	(15, 48.6621002423858),
	(16, 40.4474968323134),
	(17, 11.1803398874989),
	(18, 79.5110055275369),
	(19, 83.4865258589672),
	(20, 102.176318195558),
	(21, 87.4642784226795),
	(22, 86.0929730001235),
	(23, 42.0594816896262),
	(24, 74.6324326281812),
	(25, 64.1248781675256),
	(26, 79.7558775263617),
	(27, 51.31276644267),
	(28, 112.698713391059),
	(29, 2.23606797749979),
	(30, 96.1769203083567),
	(31, 58.8557558782486),
	(32, 83.9344982709732),
	(33, 38.4707681233427),
	(34, 82.1522975941635),
	(35, 107.517440445725),
	(36, 95.4410813015025),
	(37, 47.8539444560216),
	(38, 87.3212459828649),
	(39, 67.5425791630731),
	(40, 53.3104117410474),
	(41, 72.691127381545),
	(42, 75.1664818918645),
	(43, 55.4707129934347),
	(44, 82.5408989531856),
	(45, 61.400325732035),
	(46, 41.4366987102013),
	(47, 52.773099207835),
	(48, 0),
	(49, 81.2219182240853),
	(50, 38.2099463490856);
/*!40000 ALTER TABLE `random_rt_node48` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node49
DROP TABLE IF EXISTS `random_rt_node49`;
CREATE TABLE IF NOT EXISTS `random_rt_node49` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node49: ~50 rows (approximately)
DELETE FROM `random_rt_node49`;
/*!40000 ALTER TABLE `random_rt_node49` DISABLE KEYS */;
INSERT INTO `random_rt_node49` (`NODEID`, `DISTANCE`) VALUES
	(1, 62.00806399171),
	(2, 44.1021541423999),
	(3, 68.0073525436772),
	(4, 70.7248188403477),
	(5, 20.6155281280883),
	(6, 78.4920378127616),
	(7, 86.0058137569781),
	(8, 114.109596441316),
	(9, 22.0227155455452),
	(10, 107.168092266308),
	(11, 60.6712452484701),
	(12, 28.3196045170126),
	(13, 31.6227766016838),
	(14, 53.4883164812653),
	(15, 35.8468966578698),
	(16, 98.4123975929862),
	(17, 91.0054943396276),
	(18, 73.4098086089318),
	(19, 82.3468275041607),
	(20, 85.3287759199674),
	(21, 129.417927660738),
	(22, 5.3851648071345),
	(23, 82.0975030070952),
	(24, 96.4002074686564),
	(25, 110.113577727726),
	(26, 47.5394572960189),
	(27, 72.1803297304744),
	(28, 80.0999375780032),
	(29, 83.2946576918352),
	(30, 47.3814309619285),
	(31, 95.5876561068426),
	(32, 97.7547952787995),
	(33, 86.9540108333135),
	(34, 50.2195181179589),
	(35, 80.0562302385017),
	(36, 87.9317917479224),
	(37, 37.1618083521241),
	(38, 97.5294827218929),
	(39, 84.8115558164098),
	(40, 41.8688428309166),
	(41, 119.854077944808),
	(42, 12.5299640861417),
	(43, 45.254833995939),
	(44, 33.1360830515618),
	(45, 70.4343666117613),
	(46, 88.5098864534352),
	(47, 32.649655434629),
	(48, 81.2219182240853),
	(49, 0),
	(50, 64.6606526413088);
/*!40000 ALTER TABLE `random_rt_node49` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node5
DROP TABLE IF EXISTS `random_rt_node5`;
CREATE TABLE IF NOT EXISTS `random_rt_node5` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node5: ~50 rows (approximately)
DELETE FROM `random_rt_node5`;
/*!40000 ALTER TABLE `random_rt_node5` DISABLE KEYS */;
INSERT INTO `random_rt_node5` (`NODEID`, `DISTANCE`) VALUES
	(1, 42.4264068711928),
	(2, 45.2769256906871),
	(3, 53.851648071345),
	(4, 57.2450871254468),
	(5, 0),
	(6, 64.621977685614),
	(7, 83.198557679806),
	(8, 97.9081201943945),
	(9, 25.4950975679639),
	(10, 89.1066776397819),
	(11, 40.1995024844836),
	(12, 14.0356688476182),
	(13, 14.3178210632764),
	(14, 45.0111097397076),
	(15, 15.8113883008419),
	(16, 78.5493475466219),
	(17, 71.1125867902441),
	(18, 62.8012738724303),
	(19, 71.386273190299),
	(20, 79.1580697086532),
	(21, 112.445542374965),
	(22, 25.1793566240283),
	(23, 63.1268564083465),
	(24, 81.4125297481905),
	(25, 91.9238815542512),
	(26, 41.7731971484108),
	(27, 55),
	(28, 78.7464284904401),
	(29, 63.0317380372777),
	(30, 49.3963561409139),
	(31, 77.987178433381),
	(32, 84.504437753292),
	(33, 67.4240313241503),
	(34, 44.9110231457712),
	(35, 76.9025357189215),
	(36, 79.227520471109),
	(37, 17.2046505340853),
	(38, 85.0705589496155),
	(39, 69.7710541700496),
	(40, 25.0599281722833),
	(41, 101.833196944808),
	(42, 15.2315462117278),
	(43, 29.5465734053883),
	(44, 32.7566787083184),
	(45, 55.4616984954482),
	(46, 69.2026011071838),
	(47, 13.4536240470737),
	(48, 61.0081961706786),
	(49, 20.6155281280883),
	(50, 45.453272709454);
/*!40000 ALTER TABLE `random_rt_node5` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node50
DROP TABLE IF EXISTS `random_rt_node50`;
CREATE TABLE IF NOT EXISTS `random_rt_node50` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node50: ~50 rows (approximately)
DELETE FROM `random_rt_node50`;
/*!40000 ALTER TABLE `random_rt_node50` DISABLE KEYS */;
INSERT INTO `random_rt_node50` (`NODEID`, `DISTANCE`) VALUES
	(1, 35.6931365951495),
	(2, 58.8557558782486),
	(3, 25.8069758011279),
	(4, 29.6816441593117),
	(5, 45.453272709454),
	(6, 32.8937684067971),
	(7, 74.9666592559652),
	(8, 55.7135531087365),
	(9, 55.3172667437573),
	(10, 44.2040722106007),
	(11, 25.4950975679639),
	(12, 37.1618083521241),
	(13, 33.1209903233584),
	(14, 39.3954312071844),
	(15, 29.732137494637),
	(16, 34.1760149812701),
	(17, 48.8364617882991),
	(18, 41.4004830889689),
	(19, 46.0651712251241),
	(20, 64.0312423743285),
	(21, 68.60029154457),
	(22, 68),
	(23, 17.6918060129541),
	(24, 43.1045241245046),
	(25, 46.8614980554399),
	(26, 44.6430285710994),
	(27, 15.1327459504216),
	(28, 74.8131004570724),
	(29, 38.8973006775534),
	(30, 62.3698645180507),
	(31, 34),
	(32, 50.2493781056045),
	(33, 22.3606797749979),
	(34, 46.4865571966778),
	(35, 69.4262198308391),
	(36, 57.8013840664737),
	(37, 28.3196045170126),
	(38, 52.773099207835),
	(39, 33.1360830515618),
	(40, 24.0416305603426),
	(41, 56.8506816142076),
	(42, 54.1294744108974),
	(43, 23.0867927612304),
	(44, 52.0096144957834),
	(45, 23.7065391822594),
	(46, 23.8537208837531),
	(47, 32.2024843762092),
	(48, 38.2099463490856),
	(49, 64.6606526413088),
	(50, 0);
/*!40000 ALTER TABLE `random_rt_node50` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node6
DROP TABLE IF EXISTS `random_rt_node6`;
CREATE TABLE IF NOT EXISTS `random_rt_node6` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node6: ~50 rows (approximately)
DELETE FROM `random_rt_node6`;
/*!40000 ALTER TABLE `random_rt_node6` DISABLE KEYS */;
INSERT INTO `random_rt_node6` (`NODEID`, `DISTANCE`) VALUES
	(1, 68.4105255059483),
	(2, 51.478150704935),
	(3, 10.770329614269),
	(4, 7.81024967590665),
	(5, 64.621977685614),
	(6, 0),
	(7, 47.8539444560216),
	(8, 37.4432904536981),
	(9, 60.8111831820431),
	(10, 38.2099463490856),
	(11, 58.2408791142441),
	(12, 51.4295634824952),
	(13, 50.3289181286465),
	(14, 29.1547594742265),
	(15, 52.1727898429823),
	(16, 47.0106370941726),
	(17, 79.4040301244213),
	(18, 14.142135623731),
	(19, 14.142135623731),
	(20, 34.6698716467194),
	(21, 53.851648071345),
	(22, 79.8122797569397),
	(23, 30.6104557300279),
	(24, 18.4390889145858),
	(25, 41.3037528561268),
	(26, 37.2155881318568),
	(27, 18.3575597506858),
	(28, 50.2891638427206),
	(29, 69.8927750200262),
	(30, 53.1413210223457),
	(31, 27.0185121722126),
	(32, 19.9248588451713),
	(33, 37.4432904536981),
	(34, 36.6742416417845),
	(35, 43.6577599058861),
	(36, 26.1725046566048),
	(37, 50.9901951359278),
	(38, 21.095023109729),
	(39, 8.24621125123532),
	(40, 39.8497176903426),
	(41, 48.7647413609464),
	(42, 66.0302960768767),
	(43, 35.1140997321589),
	(44, 52.0096144957834),
	(45, 10),
	(46, 35.8468966578698),
	(47, 52.2015325445528),
	(48, 69.6419413859206),
	(49, 78.4920378127616),
	(50, 32.8937684067971);
/*!40000 ALTER TABLE `random_rt_node6` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node7
DROP TABLE IF EXISTS `random_rt_node7`;
CREATE TABLE IF NOT EXISTS `random_rt_node7` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node7: ~50 rows (approximately)
DELETE FROM `random_rt_node7`;
/*!40000 ALTER TABLE `random_rt_node7` DISABLE KEYS */;
INSERT INTO `random_rt_node7` (`NODEID`, `DISTANCE`) VALUES
	(1, 106.254411673116),
	(2, 42.190046219458),
	(3, 49.8196748283246),
	(4, 46.6154480832267),
	(5, 83.198557679806),
	(6, 47.8539444560216),
	(7, 0),
	(8, 74),
	(9, 64),
	(10, 82.7647267862342),
	(11, 97.0051545022222),
	(12, 69.9213844256534),
	(13, 72.4499827467198),
	(14, 40.2492235949962),
	(15, 78.7908624143688),
	(16, 94.847245611035),
	(17, 123.794184031399),
	(18, 34.6698716467194),
	(19, 34.7850542618522),
	(20, 14.142135623731),
	(21, 89.2748564826626),
	(22, 84.2140130857092),
	(23, 78.0320446995976),
	(24, 57.706152185014),
	(25, 85.5102333057278),
	(26, 41.4849370253831),
	(27, 63.8200595424354),
	(28, 7.81024967590665),
	(29, 113.863953909918),
	(30, 39.6232255123179),
	(31, 73.3757453113766),
	(32, 49.0407993409569),
	(33, 85.0881895447306),
	(34, 38.3275357934736),
	(35, 6.32455532033676),
	(36, 25.0798724079689),
	(37, 78.2943165242535),
	(38, 45),
	(39, 54.4242592967511),
	(40, 66.6483308118065),
	(41, 90.3548559846121),
	(42, 75.1664818918645),
	(43, 62.2655603042324),
	(44, 53.0377224247045),
	(45, 53.0094331227943),
	(46, 83.6480723029527),
	(47, 76.3216876123687),
	(48, 113.137084989848),
	(49, 86.0058137569781),
	(50, 74.9666592559652);
/*!40000 ALTER TABLE `random_rt_node7` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node8
DROP TABLE IF EXISTS `random_rt_node8`;
CREATE TABLE IF NOT EXISTS `random_rt_node8` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node8: ~50 rows (approximately)
DELETE FROM `random_rt_node8`;
/*!40000 ALTER TABLE `random_rt_node8` DISABLE KEYS */;
INSERT INTO `random_rt_node8` (`NODEID`, `DISTANCE`) VALUES
	(1, 87.965902484997),
	(2, 88.5889383614004),
	(3, 46.7546789102438),
	(4, 45),
	(5, 97.9081201943945),
	(6, 37.4432904536981),
	(7, 74),
	(8, 0),
	(9, 97.8365984690801),
	(10, 18.3847763108502),
	(11, 78.4474346298207),
	(12, 86.0523096726637),
	(13, 83.8152730712011),
	(14, 66.573267908373),
	(15, 83.3546639366988),
	(16, 41.7612260356422),
	(17, 86.4927742646749),
	(18, 48.8466989672793),
	(19, 42.4499705535822),
	(20, 60.0333240792145),
	(21, 16.5529453572468),
	(22, 116),
	(23, 40.6078810084939),
	(24, 19.2353840616713),
	(25, 18.8679622641132),
	(26, 74.6257328272225),
	(27, 43.0464865000618),
	(28, 79.227520471109),
	(29, 79.4040301244213),
	(30, 89.8999443826302),
	(31, 22.3606797749979),
	(32, 25.0798724079689),
	(33, 42),
	(34, 73.9256383131049),
	(35, 72.2495674727538),
	(36, 49.0407993409569),
	(37, 81.9878039710785),
	(38, 29),
	(39, 29.8328677803526),
	(40, 73.0068489937759),
	(41, 17.8885438199983),
	(42, 101.911726508778),
	(43, 69.0289794216893),
	(44, 89.4035793466906),
	(45, 43.8406204335659),
	(46, 39),
	(47, 84.5990543682375),
	(48, 80.2246844805263),
	(49, 114.109596441316),
	(50, 55.7135531087365);
/*!40000 ALTER TABLE `random_rt_node8` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.random_rt_node9
DROP TABLE IF EXISTS `random_rt_node9`;
CREATE TABLE IF NOT EXISTS `random_rt_node9` (
  `NODEID` int(11) NOT NULL default '0',
  `DISTANCE` double NOT NULL default '0',
  PRIMARY KEY  (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.random_rt_node9: ~50 rows (approximately)
DELETE FROM `random_rt_node9`;
/*!40000 ALTER TABLE `random_rt_node9` DISABLE KEYS */;
INSERT INTO `random_rt_node9` (`NODEID`, `DISTANCE`) VALUES
	(1, 65.1920240520265),
	(2, 22.3606797749979),
	(3, 51.0881590977792),
	(4, 53.0377224247045),
	(5, 25.4950975679639),
	(6, 60.8111831820431),
	(7, 64),
	(8, 97.8365984690801),
	(9, 0),
	(10, 93.6482781475452),
	(11, 60.4152298679729),
	(12, 20.2237484161567),
	(13, 25.3179778023443),
	(14, 33.2866339541865),
	(15, 32.9848450049413),
	(16, 89.2860571421989),
	(17, 92.4175308044962),
	(18, 53.5350352572967),
	(19, 62.4339651151519),
	(20, 63.5609943282828),
	(21, 113.850779531806),
	(22, 20.8806130178211),
	(23, 71.1688133946323),
	(24, 79.2085853932514),
	(25, 96.7470929795826),
	(26, 26.4007575648882),
	(27, 58.591808301161),
	(28, 58.2151183113115),
	(29, 83.3606621854697),
	(30, 25.9615099714943),
	(31, 81.6333265278342),
	(32, 79.0253124005214),
	(33, 77.2010362624751),
	(34, 28.7923600977759),
	(35, 58.0344725141876),
	(36, 66.8505796534331),
	(37, 33.734255586866),
	(38, 78.2368199762746),
	(39, 68.0147042925278),
	(40, 31.4006369362152),
	(41, 106),
	(42, 12.0830459735946),
	(43, 32.5729949498047),
	(44, 11.1803398874989),
	(45, 54.2033209314706),
	(46, 78.108898340714),
	(47, 28.8617393793236),
	(48, 81.5843122174846),
	(49, 22.0227155455452),
	(50, 55.3172667437573);
/*!40000 ALTER TABLE `random_rt_node9` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.residualenergy_algo1
DROP TABLE IF EXISTS `residualenergy_algo1`;
CREATE TABLE IF NOT EXISTS `residualenergy_algo1` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `RESIDUALENERGY` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.residualenergy_algo1: ~18 rows (approximately)
DELETE FROM `residualenergy_algo1`;
/*!40000 ALTER TABLE `residualenergy_algo1` DISABLE KEYS */;
INSERT INTO `residualenergy_algo1` (`ITERATION`, `RESIDUALENERGY`) VALUES
	(1, 81005.053544481),
	(2, 81000.8998212627),
	(3, 81001.0935066666),
	(4, 81004.3297635432),
	(5, 81004.3297635432),
	(6, 150839.895800343),
	(7, 29876),
	(8, 502540.764736782),
	(9, 97941.8968575037),
	(10, 97941.8968575037),
	(11, 98837.7149914515),
	(12, 81004.7560656392),
	(13, 485431.01981117),
	(14, 240588.650707777),
	(15, 472861.552448857),
	(16, 240588.549857748),
	(17, 463159.969336473),
	(18, 240630.620431963);
/*!40000 ALTER TABLE `residualenergy_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.residualenergy_algo2
DROP TABLE IF EXISTS `residualenergy_algo2`;
CREATE TABLE IF NOT EXISTS `residualenergy_algo2` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `RESIDUALENERGY` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.residualenergy_algo2: ~15 rows (approximately)
DELETE FROM `residualenergy_algo2`;
/*!40000 ALTER TABLE `residualenergy_algo2` DISABLE KEYS */;
INSERT INTO `residualenergy_algo2` (`ITERATION`, `RESIDUALENERGY`) VALUES
	(1, 59994),
	(2, 59994),
	(3, 59994),
	(4, 59994),
	(5, 59994),
	(6, 129987),
	(7, 16786),
	(8, 180741.058054239),
	(9, 69993),
	(10, 69993),
	(11, 69993),
	(12, 69993),
	(13, 240588.650707777),
	(14, 240588.549857748),
	(15, 240630.620431963);
/*!40000 ALTER TABLE `residualenergy_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.residualenergy_algo3
DROP TABLE IF EXISTS `residualenergy_algo3`;
CREATE TABLE IF NOT EXISTS `residualenergy_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `RESIDUALENERGY` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.residualenergy_algo3: ~12 rows (approximately)
DELETE FROM `residualenergy_algo3`;
/*!40000 ALTER TABLE `residualenergy_algo3` DISABLE KEYS */;
INSERT INTO `residualenergy_algo3` (`ITERATION`, `RESIDUALENERGY`) VALUES
	(1, 59994),
	(2, 59994),
	(3, 59994),
	(4, 59994),
	(5, 59994),
	(6, 129987),
	(7, 16885),
	(8, 179982),
	(9, 69993),
	(10, 69993),
	(11, 69993),
	(12, 69993);
/*!40000 ALTER TABLE `residualenergy_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.residualenergy_algo4
DROP TABLE IF EXISTS `residualenergy_algo4`;
CREATE TABLE IF NOT EXISTS `residualenergy_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `RESIDUALENERGY` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.residualenergy_algo4: ~15 rows (approximately)
DELETE FROM `residualenergy_algo4`;
/*!40000 ALTER TABLE `residualenergy_algo4` DISABLE KEYS */;
INSERT INTO `residualenergy_algo4` (`ITERATION`, `RESIDUALENERGY`) VALUES
	(1, 18899.0898015344),
	(2, 18899.0898015344),
	(3, 18899.0898015344),
	(4, 18899.0898015344),
	(5, 18899.0898015344),
	(6, 16665),
	(7, 16665),
	(8, 16665),
	(9, 16665),
	(10, 16665),
	(11, 16665),
	(12, 16665),
	(13, 239976),
	(14, 239976),
	(15, 239976);
/*!40000 ALTER TABLE `residualenergy_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.routingorganizer
DROP TABLE IF EXISTS `routingorganizer`;
CREATE TABLE IF NOT EXISTS `routingorganizer` (
  `PROPERTYNAME` varchar(200) default NULL,
  `PROPERTYVALUE` varchar(250) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.routingorganizer: ~1 rows (approximately)
DELETE FROM `routingorganizer`;
/*!40000 ALTER TABLE `routingorganizer` DISABLE KEYS */;
INSERT INTO `routingorganizer` (`PROPERTYNAME`, `PROPERTYVALUE`) VALUES
	('TOPOLOGYTYPE', 'LINEAR');
/*!40000 ALTER TABLE `routingorganizer` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.routingoverhead_algo1
DROP TABLE IF EXISTS `routingoverhead_algo1`;
CREATE TABLE IF NOT EXISTS `routingoverhead_algo1` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ROUTINGOVERHEAD` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.routingoverhead_algo1: ~15 rows (approximately)
DELETE FROM `routingoverhead_algo1`;
/*!40000 ALTER TABLE `routingoverhead_algo1` DISABLE KEYS */;
INSERT INTO `routingoverhead_algo1` (`ITERATION`, `ROUTINGOVERHEAD`) VALUES
	(1, 0.176),
	(2, 0.15),
	(3, 0.134),
	(4, 0.126),
	(5, 0.23),
	(6, 0.146),
	(7, 0.218),
	(8, 0.146),
	(9, 0.144),
	(10, 0.364),
	(11, 0.36),
	(12, 0.146),
	(13, 0.094),
	(14, 0.08),
	(15, 0.084);
/*!40000 ALTER TABLE `routingoverhead_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.routingoverhead_algo2
DROP TABLE IF EXISTS `routingoverhead_algo2`;
CREATE TABLE IF NOT EXISTS `routingoverhead_algo2` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ROUTINGOVERHEAD` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.routingoverhead_algo2: ~15 rows (approximately)
DELETE FROM `routingoverhead_algo2`;
/*!40000 ALTER TABLE `routingoverhead_algo2` DISABLE KEYS */;
INSERT INTO `routingoverhead_algo2` (`ITERATION`, `ROUTINGOVERHEAD`) VALUES
	(1, 0.304),
	(2, 0.778),
	(3, 1.586),
	(4, 1.764),
	(5, 3.044),
	(6, 1.728),
	(7, 2.378),
	(8, 1.01),
	(9, 1.01),
	(10, 2.282),
	(11, 1.682),
	(12, 1.254),
	(13, 1.272),
	(14, 1.018),
	(15, 0.736);
/*!40000 ALTER TABLE `routingoverhead_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.routingoverhead_algo3
DROP TABLE IF EXISTS `routingoverhead_algo3`;
CREATE TABLE IF NOT EXISTS `routingoverhead_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ROUTINGOVERHEAD` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.routingoverhead_algo3: ~15 rows (approximately)
DELETE FROM `routingoverhead_algo3`;
/*!40000 ALTER TABLE `routingoverhead_algo3` DISABLE KEYS */;
INSERT INTO `routingoverhead_algo3` (`ITERATION`, `ROUTINGOVERHEAD`) VALUES
	(1, 0.31),
	(2, 1.414),
	(3, 2.392),
	(4, 2.434),
	(5, 3.772),
	(6, 2.384),
	(7, 3.206),
	(8, 1.414),
	(9, 1.414),
	(10, 2.96),
	(11, 1.842),
	(12, 1.32),
	(13, 1.37),
	(14, 1.104),
	(15, 0.866);
/*!40000 ALTER TABLE `routingoverhead_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.routingoverhead_algo4
DROP TABLE IF EXISTS `routingoverhead_algo4`;
CREATE TABLE IF NOT EXISTS `routingoverhead_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `ROUTINGOVERHEAD` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.routingoverhead_algo4: ~15 rows (approximately)
DELETE FROM `routingoverhead_algo4`;
/*!40000 ALTER TABLE `routingoverhead_algo4` DISABLE KEYS */;
INSERT INTO `routingoverhead_algo4` (`ITERATION`, `ROUTINGOVERHEAD`) VALUES
	(1, 1.414),
	(2, 1.414),
	(3, 1.414),
	(4, 1.414),
	(5, 1.414),
	(6, 1.35),
	(7, 0.808),
	(8, 0.808),
	(9, 0.808),
	(10, 0.808),
	(11, 0.808),
	(12, 1.414),
	(13, 1.574),
	(14, 1.396),
	(15, 1.686);
/*!40000 ALTER TABLE `routingoverhead_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.throughput_algo1
DROP TABLE IF EXISTS `throughput_algo1`;
CREATE TABLE IF NOT EXISTS `throughput_algo1` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `THROUGHPUT` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.throughput_algo1: ~15 rows (approximately)
DELETE FROM `throughput_algo1`;
/*!40000 ALTER TABLE `throughput_algo1` DISABLE KEYS */;
INSERT INTO `throughput_algo1` (`ITERATION`, `THROUGHPUT`) VALUES
	(1, 2.12314225053079),
	(2, 0.259336099585062),
	(3, 0.147275405007364),
	(4, 0.255689082076195),
	(5, 0.134282261313281),
	(6, 0.107158165452207),
	(7, 0.189178963299281),
	(8, 0.134879956838414),
	(9, 0.258397932816537),
	(10, 0.109926349345938),
	(11, 0.113391540991042),
	(12, 0.241662638956017),
	(13, 1.16822429906542),
	(14, 2.49376558603491),
	(15, 1.57977883096367);
/*!40000 ALTER TABLE `throughput_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.throughput_algo2
DROP TABLE IF EXISTS `throughput_algo2`;
CREATE TABLE IF NOT EXISTS `throughput_algo2` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `THROUGHPUT` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.throughput_algo2: ~15 rows (approximately)
DELETE FROM `throughput_algo2`;
/*!40000 ALTER TABLE `throughput_algo2` DISABLE KEYS */;
INSERT INTO `throughput_algo2` (`ITERATION`, `THROUGHPUT`) VALUES
	(1, 1.78890876565295),
	(2, 0.043750273439209),
	(3, 0.0146066431012825),
	(4, 0.0193749636719431),
	(5, 0.0119713167251266),
	(6, 0.016260426998813),
	(7, 0.0122853141354824),
	(8, 0.0350029752528965),
	(9, 0.0325796572620056),
	(10, 0.0171924696982722),
	(11, 0.0233579370270018),
	(12, 0.0347717236343406),
	(13, 0.122234445666789),
	(14, 0.183385292499542),
	(15, 0.245579567779961);
/*!40000 ALTER TABLE `throughput_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.throughput_algo3
DROP TABLE IF EXISTS `throughput_algo3`;
CREATE TABLE IF NOT EXISTS `throughput_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `THROUGHPUT` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.throughput_algo3: ~15 rows (approximately)
DELETE FROM `throughput_algo3`;
/*!40000 ALTER TABLE `throughput_algo3` DISABLE KEYS */;
INSERT INTO `throughput_algo3` (`ITERATION`, `THROUGHPUT`) VALUES
	(1, 1.3986013986014),
	(2, 0.0214629120879121),
	(3, 0.0132669983416252),
	(4, 0.0135435289018907),
	(5, 0.00852485848734911),
	(6, 0.01268520397808),
	(7, 0.0103327133705311),
	(8, 0.0260254007911722),
	(9, 0.0240598609340038),
	(10, 0.0117834207270371),
	(11, 0.0227821570146261),
	(12, 0.0340518268805121),
	(13, 0.120438395760568),
	(14, 0.115713955102985),
	(15, 0.1776514478593);
/*!40000 ALTER TABLE `throughput_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.throughput_algo4
DROP TABLE IF EXISTS `throughput_algo4`;
CREATE TABLE IF NOT EXISTS `throughput_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `THROUGHPUT` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.throughput_algo4: ~15 rows (approximately)
DELETE FROM `throughput_algo4`;
/*!40000 ALTER TABLE `throughput_algo4` DISABLE KEYS */;
INSERT INTO `throughput_algo4` (`ITERATION`, `THROUGHPUT`) VALUES
	(1, 0.0197565987039671),
	(2, 0.0298027060857126),
	(3, 0.0247157686604053),
	(4, 0.0202445542149162),
	(5, 0.0217547370940022),
	(6, 0.0178606511993427),
	(7, 0.0324591015320696),
	(8, 0.0280379072506028),
	(9, 0.0344281484541761),
	(10, 0.0346248398601157),
	(11, 0.0285339268390116),
	(12, 0.00972753183334792),
	(13, 0.0894614421184469),
	(14, 0.093214019388516),
	(15, 0.0952018278750952);
/*!40000 ALTER TABLE `throughput_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.time_algo1
DROP TABLE IF EXISTS `time_algo1`;
CREATE TABLE IF NOT EXISTS `time_algo1` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `TIME` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.time_algo1: ~15 rows (approximately)
DELETE FROM `time_algo1`;
/*!40000 ALTER TABLE `time_algo1` DISABLE KEYS */;
INSERT INTO `time_algo1` (`ITERATION`, `TIME`) VALUES
	(1, 471),
	(2, 3856),
	(3, 6790),
	(4, 3911),
	(5, 7447),
	(6, 9332),
	(7, 5286),
	(8, 7414),
	(9, 3870),
	(10, 9097),
	(11, 8819),
	(12, 4138),
	(13, 856),
	(14, 401),
	(15, 633);
/*!40000 ALTER TABLE `time_algo1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.time_algo2
DROP TABLE IF EXISTS `time_algo2`;
CREATE TABLE IF NOT EXISTS `time_algo2` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `TIME` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.time_algo2: ~15 rows (approximately)
DELETE FROM `time_algo2`;
/*!40000 ALTER TABLE `time_algo2` DISABLE KEYS */;
INSERT INTO `time_algo2` (`ITERATION`, `TIME`) VALUES
	(1, 559),
	(2, 22857),
	(3, 68462),
	(4, 51613),
	(5, 83533),
	(6, 61499),
	(7, 81398),
	(8, 28569),
	(9, 30694),
	(10, 58165),
	(11, 42812),
	(12, 28759),
	(13, 8181),
	(14, 5453),
	(15, 4072);
/*!40000 ALTER TABLE `time_algo2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.time_algo3
DROP TABLE IF EXISTS `time_algo3`;
CREATE TABLE IF NOT EXISTS `time_algo3` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `TIME` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.time_algo3: ~15 rows (approximately)
DELETE FROM `time_algo3`;
/*!40000 ALTER TABLE `time_algo3` DISABLE KEYS */;
INSERT INTO `time_algo3` (`ITERATION`, `TIME`) VALUES
	(1, 715),
	(2, 46592),
	(3, 75375),
	(4, 73836),
	(5, 117304),
	(6, 78832),
	(7, 96780),
	(8, 38424),
	(9, 41563),
	(10, 84865),
	(11, 43894),
	(12, 29367),
	(13, 8303),
	(14, 8642),
	(15, 5629);
/*!40000 ALTER TABLE `time_algo3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.time_algo4
DROP TABLE IF EXISTS `time_algo4`;
CREATE TABLE IF NOT EXISTS `time_algo4` (
  `ITERATION` int(11) NOT NULL auto_increment,
  `TIME` double NOT NULL default '0',
  PRIMARY KEY  (`ITERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.time_algo4: ~15 rows (approximately)
DELETE FROM `time_algo4`;
/*!40000 ALTER TABLE `time_algo4` DISABLE KEYS */;
INSERT INTO `time_algo4` (`ITERATION`, `TIME`) VALUES
	(1, 40078),
	(2, 53201),
	(3, 62201),
	(4, 48815),
	(5, 49581),
	(6, 48942),
	(7, 50616),
	(8, 33554),
	(9, 40460),
	(10, 49396),
	(11, 45967),
	(12, 55989),
	(13, 11178),
	(14, 10728),
	(15, 10504);
/*!40000 ALTER TABLE `time_algo4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node1
DROP TABLE IF EXISTS `trust_node1`;
CREATE TABLE IF NOT EXISTS `trust_node1` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node1: ~1 rows (approximately)
DELETE FROM `trust_node1`;
/*!40000 ALTER TABLE `trust_node1` DISABLE KEYS */;
INSERT INTO `trust_node1` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node1` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node10
DROP TABLE IF EXISTS `trust_node10`;
CREATE TABLE IF NOT EXISTS `trust_node10` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node10: ~1 rows (approximately)
DELETE FROM `trust_node10`;
/*!40000 ALTER TABLE `trust_node10` DISABLE KEYS */;
INSERT INTO `trust_node10` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node10` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node11
DROP TABLE IF EXISTS `trust_node11`;
CREATE TABLE IF NOT EXISTS `trust_node11` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node11: ~1 rows (approximately)
DELETE FROM `trust_node11`;
/*!40000 ALTER TABLE `trust_node11` DISABLE KEYS */;
INSERT INTO `trust_node11` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node11` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node12
DROP TABLE IF EXISTS `trust_node12`;
CREATE TABLE IF NOT EXISTS `trust_node12` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node12: ~1 rows (approximately)
DELETE FROM `trust_node12`;
/*!40000 ALTER TABLE `trust_node12` DISABLE KEYS */;
INSERT INTO `trust_node12` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node12` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node13
DROP TABLE IF EXISTS `trust_node13`;
CREATE TABLE IF NOT EXISTS `trust_node13` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node13: ~1 rows (approximately)
DELETE FROM `trust_node13`;
/*!40000 ALTER TABLE `trust_node13` DISABLE KEYS */;
INSERT INTO `trust_node13` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node13` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node14
DROP TABLE IF EXISTS `trust_node14`;
CREATE TABLE IF NOT EXISTS `trust_node14` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node14: ~1 rows (approximately)
DELETE FROM `trust_node14`;
/*!40000 ALTER TABLE `trust_node14` DISABLE KEYS */;
INSERT INTO `trust_node14` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node14` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node15
DROP TABLE IF EXISTS `trust_node15`;
CREATE TABLE IF NOT EXISTS `trust_node15` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node15: ~1 rows (approximately)
DELETE FROM `trust_node15`;
/*!40000 ALTER TABLE `trust_node15` DISABLE KEYS */;
INSERT INTO `trust_node15` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node15` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node16
DROP TABLE IF EXISTS `trust_node16`;
CREATE TABLE IF NOT EXISTS `trust_node16` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node16: ~1 rows (approximately)
DELETE FROM `trust_node16`;
/*!40000 ALTER TABLE `trust_node16` DISABLE KEYS */;
INSERT INTO `trust_node16` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node16` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node17
DROP TABLE IF EXISTS `trust_node17`;
CREATE TABLE IF NOT EXISTS `trust_node17` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node17: ~1 rows (approximately)
DELETE FROM `trust_node17`;
/*!40000 ALTER TABLE `trust_node17` DISABLE KEYS */;
INSERT INTO `trust_node17` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node17` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node18
DROP TABLE IF EXISTS `trust_node18`;
CREATE TABLE IF NOT EXISTS `trust_node18` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node18: ~1 rows (approximately)
DELETE FROM `trust_node18`;
/*!40000 ALTER TABLE `trust_node18` DISABLE KEYS */;
INSERT INTO `trust_node18` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node18` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node19
DROP TABLE IF EXISTS `trust_node19`;
CREATE TABLE IF NOT EXISTS `trust_node19` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node19: ~1 rows (approximately)
DELETE FROM `trust_node19`;
/*!40000 ALTER TABLE `trust_node19` DISABLE KEYS */;
INSERT INTO `trust_node19` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node19` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node2
DROP TABLE IF EXISTS `trust_node2`;
CREATE TABLE IF NOT EXISTS `trust_node2` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node2: ~1 rows (approximately)
DELETE FROM `trust_node2`;
/*!40000 ALTER TABLE `trust_node2` DISABLE KEYS */;
INSERT INTO `trust_node2` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node2` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node20
DROP TABLE IF EXISTS `trust_node20`;
CREATE TABLE IF NOT EXISTS `trust_node20` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node20: ~1 rows (approximately)
DELETE FROM `trust_node20`;
/*!40000 ALTER TABLE `trust_node20` DISABLE KEYS */;
INSERT INTO `trust_node20` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node20` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node21
DROP TABLE IF EXISTS `trust_node21`;
CREATE TABLE IF NOT EXISTS `trust_node21` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node21: ~1 rows (approximately)
DELETE FROM `trust_node21`;
/*!40000 ALTER TABLE `trust_node21` DISABLE KEYS */;
INSERT INTO `trust_node21` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node21` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node22
DROP TABLE IF EXISTS `trust_node22`;
CREATE TABLE IF NOT EXISTS `trust_node22` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node22: ~1 rows (approximately)
DELETE FROM `trust_node22`;
/*!40000 ALTER TABLE `trust_node22` DISABLE KEYS */;
INSERT INTO `trust_node22` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node22` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node23
DROP TABLE IF EXISTS `trust_node23`;
CREATE TABLE IF NOT EXISTS `trust_node23` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node23: ~1 rows (approximately)
DELETE FROM `trust_node23`;
/*!40000 ALTER TABLE `trust_node23` DISABLE KEYS */;
INSERT INTO `trust_node23` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node23` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node24
DROP TABLE IF EXISTS `trust_node24`;
CREATE TABLE IF NOT EXISTS `trust_node24` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node24: ~1 rows (approximately)
DELETE FROM `trust_node24`;
/*!40000 ALTER TABLE `trust_node24` DISABLE KEYS */;
INSERT INTO `trust_node24` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node24` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node25
DROP TABLE IF EXISTS `trust_node25`;
CREATE TABLE IF NOT EXISTS `trust_node25` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node25: ~1 rows (approximately)
DELETE FROM `trust_node25`;
/*!40000 ALTER TABLE `trust_node25` DISABLE KEYS */;
INSERT INTO `trust_node25` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node25` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node26
DROP TABLE IF EXISTS `trust_node26`;
CREATE TABLE IF NOT EXISTS `trust_node26` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node26: ~1 rows (approximately)
DELETE FROM `trust_node26`;
/*!40000 ALTER TABLE `trust_node26` DISABLE KEYS */;
INSERT INTO `trust_node26` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node26` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node27
DROP TABLE IF EXISTS `trust_node27`;
CREATE TABLE IF NOT EXISTS `trust_node27` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node27: ~1 rows (approximately)
DELETE FROM `trust_node27`;
/*!40000 ALTER TABLE `trust_node27` DISABLE KEYS */;
INSERT INTO `trust_node27` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node27` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node28
DROP TABLE IF EXISTS `trust_node28`;
CREATE TABLE IF NOT EXISTS `trust_node28` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node28: ~1 rows (approximately)
DELETE FROM `trust_node28`;
/*!40000 ALTER TABLE `trust_node28` DISABLE KEYS */;
INSERT INTO `trust_node28` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node28` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node29
DROP TABLE IF EXISTS `trust_node29`;
CREATE TABLE IF NOT EXISTS `trust_node29` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node29: ~1 rows (approximately)
DELETE FROM `trust_node29`;
/*!40000 ALTER TABLE `trust_node29` DISABLE KEYS */;
INSERT INTO `trust_node29` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node29` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node3
DROP TABLE IF EXISTS `trust_node3`;
CREATE TABLE IF NOT EXISTS `trust_node3` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node3: ~1 rows (approximately)
DELETE FROM `trust_node3`;
/*!40000 ALTER TABLE `trust_node3` DISABLE KEYS */;
INSERT INTO `trust_node3` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node3` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node30
DROP TABLE IF EXISTS `trust_node30`;
CREATE TABLE IF NOT EXISTS `trust_node30` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node30: ~1 rows (approximately)
DELETE FROM `trust_node30`;
/*!40000 ALTER TABLE `trust_node30` DISABLE KEYS */;
INSERT INTO `trust_node30` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node30` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node31
DROP TABLE IF EXISTS `trust_node31`;
CREATE TABLE IF NOT EXISTS `trust_node31` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node31: ~1 rows (approximately)
DELETE FROM `trust_node31`;
/*!40000 ALTER TABLE `trust_node31` DISABLE KEYS */;
INSERT INTO `trust_node31` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node31` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node32
DROP TABLE IF EXISTS `trust_node32`;
CREATE TABLE IF NOT EXISTS `trust_node32` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node32: ~1 rows (approximately)
DELETE FROM `trust_node32`;
/*!40000 ALTER TABLE `trust_node32` DISABLE KEYS */;
INSERT INTO `trust_node32` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node32` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node33
DROP TABLE IF EXISTS `trust_node33`;
CREATE TABLE IF NOT EXISTS `trust_node33` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node33: ~1 rows (approximately)
DELETE FROM `trust_node33`;
/*!40000 ALTER TABLE `trust_node33` DISABLE KEYS */;
INSERT INTO `trust_node33` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node33` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node34
DROP TABLE IF EXISTS `trust_node34`;
CREATE TABLE IF NOT EXISTS `trust_node34` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node34: ~1 rows (approximately)
DELETE FROM `trust_node34`;
/*!40000 ALTER TABLE `trust_node34` DISABLE KEYS */;
INSERT INTO `trust_node34` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node34` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node35
DROP TABLE IF EXISTS `trust_node35`;
CREATE TABLE IF NOT EXISTS `trust_node35` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node35: ~1 rows (approximately)
DELETE FROM `trust_node35`;
/*!40000 ALTER TABLE `trust_node35` DISABLE KEYS */;
INSERT INTO `trust_node35` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node35` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node36
DROP TABLE IF EXISTS `trust_node36`;
CREATE TABLE IF NOT EXISTS `trust_node36` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node36: ~1 rows (approximately)
DELETE FROM `trust_node36`;
/*!40000 ALTER TABLE `trust_node36` DISABLE KEYS */;
INSERT INTO `trust_node36` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node36` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node37
DROP TABLE IF EXISTS `trust_node37`;
CREATE TABLE IF NOT EXISTS `trust_node37` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node37: ~1 rows (approximately)
DELETE FROM `trust_node37`;
/*!40000 ALTER TABLE `trust_node37` DISABLE KEYS */;
INSERT INTO `trust_node37` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node37` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node38
DROP TABLE IF EXISTS `trust_node38`;
CREATE TABLE IF NOT EXISTS `trust_node38` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node38: ~1 rows (approximately)
DELETE FROM `trust_node38`;
/*!40000 ALTER TABLE `trust_node38` DISABLE KEYS */;
INSERT INTO `trust_node38` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node38` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node39
DROP TABLE IF EXISTS `trust_node39`;
CREATE TABLE IF NOT EXISTS `trust_node39` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node39: ~1 rows (approximately)
DELETE FROM `trust_node39`;
/*!40000 ALTER TABLE `trust_node39` DISABLE KEYS */;
INSERT INTO `trust_node39` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node39` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node4
DROP TABLE IF EXISTS `trust_node4`;
CREATE TABLE IF NOT EXISTS `trust_node4` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node4: ~1 rows (approximately)
DELETE FROM `trust_node4`;
/*!40000 ALTER TABLE `trust_node4` DISABLE KEYS */;
INSERT INTO `trust_node4` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node4` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node40
DROP TABLE IF EXISTS `trust_node40`;
CREATE TABLE IF NOT EXISTS `trust_node40` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node40: ~1 rows (approximately)
DELETE FROM `trust_node40`;
/*!40000 ALTER TABLE `trust_node40` DISABLE KEYS */;
INSERT INTO `trust_node40` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node40` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node41
DROP TABLE IF EXISTS `trust_node41`;
CREATE TABLE IF NOT EXISTS `trust_node41` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node41: ~1 rows (approximately)
DELETE FROM `trust_node41`;
/*!40000 ALTER TABLE `trust_node41` DISABLE KEYS */;
INSERT INTO `trust_node41` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node41` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node42
DROP TABLE IF EXISTS `trust_node42`;
CREATE TABLE IF NOT EXISTS `trust_node42` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node42: ~1 rows (approximately)
DELETE FROM `trust_node42`;
/*!40000 ALTER TABLE `trust_node42` DISABLE KEYS */;
INSERT INTO `trust_node42` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node42` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node43
DROP TABLE IF EXISTS `trust_node43`;
CREATE TABLE IF NOT EXISTS `trust_node43` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node43: ~1 rows (approximately)
DELETE FROM `trust_node43`;
/*!40000 ALTER TABLE `trust_node43` DISABLE KEYS */;
INSERT INTO `trust_node43` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node43` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node44
DROP TABLE IF EXISTS `trust_node44`;
CREATE TABLE IF NOT EXISTS `trust_node44` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node44: ~1 rows (approximately)
DELETE FROM `trust_node44`;
/*!40000 ALTER TABLE `trust_node44` DISABLE KEYS */;
INSERT INTO `trust_node44` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node44` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node45
DROP TABLE IF EXISTS `trust_node45`;
CREATE TABLE IF NOT EXISTS `trust_node45` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node45: ~1 rows (approximately)
DELETE FROM `trust_node45`;
/*!40000 ALTER TABLE `trust_node45` DISABLE KEYS */;
INSERT INTO `trust_node45` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node45` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node46
DROP TABLE IF EXISTS `trust_node46`;
CREATE TABLE IF NOT EXISTS `trust_node46` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node46: ~1 rows (approximately)
DELETE FROM `trust_node46`;
/*!40000 ALTER TABLE `trust_node46` DISABLE KEYS */;
INSERT INTO `trust_node46` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node46` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node47
DROP TABLE IF EXISTS `trust_node47`;
CREATE TABLE IF NOT EXISTS `trust_node47` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node47: ~1 rows (approximately)
DELETE FROM `trust_node47`;
/*!40000 ALTER TABLE `trust_node47` DISABLE KEYS */;
INSERT INTO `trust_node47` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node47` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node48
DROP TABLE IF EXISTS `trust_node48`;
CREATE TABLE IF NOT EXISTS `trust_node48` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node48: ~1 rows (approximately)
DELETE FROM `trust_node48`;
/*!40000 ALTER TABLE `trust_node48` DISABLE KEYS */;
INSERT INTO `trust_node48` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node48` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node49
DROP TABLE IF EXISTS `trust_node49`;
CREATE TABLE IF NOT EXISTS `trust_node49` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node49: ~1 rows (approximately)
DELETE FROM `trust_node49`;
/*!40000 ALTER TABLE `trust_node49` DISABLE KEYS */;
INSERT INTO `trust_node49` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node49` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node5
DROP TABLE IF EXISTS `trust_node5`;
CREATE TABLE IF NOT EXISTS `trust_node5` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node5: ~1 rows (approximately)
DELETE FROM `trust_node5`;
/*!40000 ALTER TABLE `trust_node5` DISABLE KEYS */;
INSERT INTO `trust_node5` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node5` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node50
DROP TABLE IF EXISTS `trust_node50`;
CREATE TABLE IF NOT EXISTS `trust_node50` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node50: ~1 rows (approximately)
DELETE FROM `trust_node50`;
/*!40000 ALTER TABLE `trust_node50` DISABLE KEYS */;
INSERT INTO `trust_node50` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node50` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node6
DROP TABLE IF EXISTS `trust_node6`;
CREATE TABLE IF NOT EXISTS `trust_node6` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node6: ~1 rows (approximately)
DELETE FROM `trust_node6`;
/*!40000 ALTER TABLE `trust_node6` DISABLE KEYS */;
INSERT INTO `trust_node6` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node6` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node7
DROP TABLE IF EXISTS `trust_node7`;
CREATE TABLE IF NOT EXISTS `trust_node7` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node7: ~1 rows (approximately)
DELETE FROM `trust_node7`;
/*!40000 ALTER TABLE `trust_node7` DISABLE KEYS */;
INSERT INTO `trust_node7` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node7` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node8
DROP TABLE IF EXISTS `trust_node8`;
CREATE TABLE IF NOT EXISTS `trust_node8` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node8: ~1 rows (approximately)
DELETE FROM `trust_node8`;
/*!40000 ALTER TABLE `trust_node8` DISABLE KEYS */;
INSERT INTO `trust_node8` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node8` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.trust_node9
DROP TABLE IF EXISTS `trust_node9`;
CREATE TABLE IF NOT EXISTS `trust_node9` (
  `TRUST` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.trust_node9: ~1 rows (approximately)
DELETE FROM `trust_node9`;
/*!40000 ALTER TABLE `trust_node9` DISABLE KEYS */;
INSERT INTO `trust_node9` (`TRUST`) VALUES
	(0);
/*!40000 ALTER TABLE `trust_node9` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.userinforoutesession
DROP TABLE IF EXISTS `userinforoutesession`;
CREATE TABLE IF NOT EXISTS `userinforoutesession` (
  `routeno` bigint(20) NOT NULL default '0',
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `algorithmtype` varchar(255) default NULL,
  `routeinstrformat` varchar(255) default NULL,
  `sessionid` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`routeno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.userinforoutesession: 0 rows
DELETE FROM `userinforoutesession`;
/*!40000 ALTER TABLE `userinforoutesession` DISABLE KEYS */;
/*!40000 ALTER TABLE `userinforoutesession` ENABLE KEYS */;


-- Dumping structure for table dropsapppro.userinforoutesession_sequence
DROP TABLE IF EXISTS `userinforoutesession_sequence`;
CREATE TABLE IF NOT EXISTS `userinforoutesession_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table dropsapppro.userinforoutesession_sequence: 0 rows
DELETE FROM `userinforoutesession_sequence`;
/*!40000 ALTER TABLE `userinforoutesession_sequence` DISABLE KEYS */;
INSERT INTO `userinforoutesession_sequence` (`next_val`) VALUES
	(0);
/*!40000 ALTER TABLE `userinforoutesession_sequence` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
