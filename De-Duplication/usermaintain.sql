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

-- Dumping database structure for usermaintain
CREATE DATABASE IF NOT EXISTS `usermaintain` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `usermaintain`;


-- Dumping structure for table usermaintain.activities
CREATE TABLE IF NOT EXISTS `activities` (
  `id` bigint(20) NOT NULL auto_increment,
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `activity_desc` varchar(255) default NULL,
  `activity_name` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  `app_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKqm29lm70hnb1uju6bn109genk` (`user_name`,`app_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.activities: 0 rows
DELETE FROM `activities`;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;


-- Dumping structure for table usermaintain.answers
CREATE TABLE IF NOT EXISTS `answers` (
  `id` bigint(20) NOT NULL default '0',
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `text` text,
  `question_id` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `FK3erw1a3t0r78st8ty27x6v3g1` (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.answers: 0 rows
DELETE FROM `answers`;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;


-- Dumping structure for table usermaintain.answer_sequence
CREATE TABLE IF NOT EXISTS `answer_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.answer_sequence: 1 rows
DELETE FROM `answer_sequence`;
/*!40000 ALTER TABLE `answer_sequence` DISABLE KEYS */;
INSERT INTO `answer_sequence` (`next_val`) VALUES
	(1000);
/*!40000 ALTER TABLE `answer_sequence` ENABLE KEYS */;


-- Dumping structure for table usermaintain.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` bigint(20) NOT NULL auto_increment,
  `age` int(11) default NULL,
  `current_location` varchar(255) default NULL,
  `designation` varchar(255) default NULL,
  `experience` varchar(255) default NULL,
  `first_name` varchar(255) default NULL,
  `last_name` varchar(255) default NULL,
  `phone_number` bigint(20) default NULL,
  `tele_commuter_temp` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.employee: 1 rows
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `age`, `current_location`, `designation`, `experience`, `first_name`, `last_name`, `phone_number`, `tele_commuter_temp`) VALUES
	(1, 10, '9234932', 'jsadjasdhsaj', '2', 'adhsd', 'ajsdashd', 982349849823, 1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- Dumping structure for table usermaintain.license
CREATE TABLE IF NOT EXISTS `license` (
  `app_name` varchar(20) NOT NULL default '',
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `expiry_date` varchar(10) NOT NULL default '',
  PRIMARY KEY  (`app_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.license: 5 rows
DELETE FROM `license`;
/*!40000 ALTER TABLE `license` DISABLE KEYS */;
INSERT INTO `license` (`app_name`, `created_at`, `updated_at`, `expiry_date`) VALUES
	('APP+91-9740723080', '2019-06-15 01:36:49', '2019-06-15 01:36:49', '10/10/2020'),
	('APP+91-8867487802', '2019-09-04 07:08:23', '2019-09-04 07:08:23', '25/08/2020'),
	('APP+91-7259268907', '2019-09-20 23:26:37', '2019-09-20 23:26:37', '25/08/2020'),
	('APP+91-RIGELSOFT', '2019-10-06 20:19:03', '2019-10-13 13:06:37', '25/08/2020'),
	('APP+91-9880185386', '2022-10-28 23:44:04', '2022-10-28 23:44:04', '25/08/2022');
/*!40000 ALTER TABLE `license` ENABLE KEYS */;


-- Dumping structure for table usermaintain.questions
CREATE TABLE IF NOT EXISTS `questions` (
  `id` bigint(20) NOT NULL default '0',
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `description` text,
  `title` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.questions: 0 rows
DELETE FROM `questions`;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;


-- Dumping structure for table usermaintain.question_sequence
CREATE TABLE IF NOT EXISTS `question_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.question_sequence: 1 rows
DELETE FROM `question_sequence`;
/*!40000 ALTER TABLE `question_sequence` DISABLE KEYS */;
INSERT INTO `question_sequence` (`next_val`) VALUES
	(1000);
/*!40000 ALTER TABLE `question_sequence` ENABLE KEYS */;


-- Dumping structure for table usermaintain.services
CREATE TABLE IF NOT EXISTS `services` (
  `id` bigint(20) NOT NULL auto_increment,
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `company_name_service` varchar(255) default NULL,
  `cost` double default NULL,
  `service_name` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  `app_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK6g0vb9b9q7svks7v0hxpjpep3` (`user_name`,`app_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.services: 0 rows
DELETE FROM `services`;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
/*!40000 ALTER TABLE `services` ENABLE KEYS */;


-- Dumping structure for table usermaintain.servicetype
CREATE TABLE IF NOT EXISTS `servicetype` (
  `id` bigint(20) NOT NULL auto_increment,
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `app_name` varchar(255) default NULL,
  `service_type_desc` varchar(255) default NULL,
  `service_type_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.servicetype: 0 rows
DELETE FROM `servicetype`;
/*!40000 ALTER TABLE `servicetype` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicetype` ENABLE KEYS */;


-- Dumping structure for table usermaintain.skills
CREATE TABLE IF NOT EXISTS `skills` (
  `id` bigint(20) NOT NULL auto_increment,
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `skill_name` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  `app_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK5sicnep6rv28ep1878nl2kinl` (`user_name`,`app_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.skills: 0 rows
DELETE FROM `skills`;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;


-- Dumping structure for table usermaintain.subjects
CREATE TABLE IF NOT EXISTS `subjects` (
  `id` bigint(20) NOT NULL auto_increment,
  `subject_desc` varchar(255) default NULL,
  `subject_name` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  `app_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK4t6p336hfduph707n6886oq40` (`user_name`,`app_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.subjects: 0 rows
DELETE FROM `subjects`;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;


-- Dumping structure for table usermaintain.usermaintain
CREATE TABLE IF NOT EXISTS `usermaintain` (
  `app_name` varchar(255) NOT NULL default '',
  `user_name` varchar(255) NOT NULL default '',
  `created_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL default '0000-00-00 00:00:00',
  `address` text,
  `admission_type` varchar(255) default NULL,
  `age` int(11) default NULL,
  `branch` varchar(255) default NULL,
  `challan_number` varchar(100) default NULL,
  `city` varchar(255) default NULL,
  `college_name` varchar(255) default NULL,
  `company_name` varchar(255) default NULL,
  `country` varchar(255) default NULL,
  `degree` varchar(30) default NULL,
  `department` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  `dob` varchar(255) default NULL,
  `email` varchar(60) NOT NULL default '',
  `father_email` varchar(100) default NULL,
  `father_name` varchar(30) default NULL,
  `father_number` varchar(15) default NULL,
  `fee_paid` double default NULL,
  `gender` varchar(255) default NULL,
  `is_account_locked` varchar(255) default NULL,
  `local_guard_email` varchar(100) default NULL,
  `local_guard_name` varchar(30) default NULL,
  `local_guard_number` varchar(15) default NULL,
  `login_type` int(11) NOT NULL default '0',
  `mother_email` varchar(100) default NULL,
  `mother_name` varchar(30) default NULL,
  `mother_number` varchar(30) default NULL,
  `no_of_wrong_passwords` int(11) default NULL,
  `password` varchar(40) NOT NULL default '',
  `phone_no` varchar(15) NOT NULL default '',
  `pin_code` varchar(255) default NULL,
  `project_title` varchar(255) default NULL,
  `residence_status` varchar(10) default NULL,
  `residential_address` text,
  `secret_answer1` varchar(255) default NULL,
  `secret_answer2` varchar(255) default NULL,
  `secret_question1` varchar(255) default NULL,
  `secret_question2` varchar(255) default NULL,
  `semester_marks` double default NULL,
  `service_type` varchar(255) default NULL,
  `specification` text,
  `state` varchar(255) default NULL,
  `street_address_line1` varchar(255) default NULL,
  `street_address_line2` varchar(255) default NULL,
  `total_cost_all_services` double default NULL,
  `total_rating` double default NULL,
  `university` varchar(255) default NULL,
  `usn_number` varchar(255) default NULL,
  `year_of_project` int(11) default NULL,
  PRIMARY KEY  (`app_name`,`user_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table usermaintain.usermaintain: 21 rows
DELETE FROM `usermaintain`;
/*!40000 ALTER TABLE `usermaintain` DISABLE KEYS */;
INSERT INTO `usermaintain` (`app_name`, `user_name`, `created_at`, `updated_at`, `address`, `admission_type`, `age`, `branch`, `challan_number`, `city`, `college_name`, `company_name`, `country`, `degree`, `department`, `description`, `dob`, `email`, `father_email`, `father_name`, `father_number`, `fee_paid`, `gender`, `is_account_locked`, `local_guard_email`, `local_guard_name`, `local_guard_number`, `login_type`, `mother_email`, `mother_name`, `mother_number`, `no_of_wrong_passwords`, `password`, `phone_no`, `pin_code`, `project_title`, `residence_status`, `residential_address`, `secret_answer1`, `secret_answer2`, `secret_question1`, `secret_question2`, `semester_marks`, `service_type`, `specification`, `state`, `street_address_line1`, `street_address_line2`, `total_cost_all_services`, `total_rating`, `university`, `usn_number`, `year_of_project`) VALUES
	('APP+91-9740723080', 'sphradmin', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 0, NULL, NULL, 'Bangalore', NULL, '', 'India', NULL, NULL, '', NULL, 'admin124@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, 'pass@1234', '+91-7259268908', '560022', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', 'This is Street Address Line1', 'This is Street Address Line2', 0, 0, NULL, NULL, 0),
	('APP+91-9740723080', 'customer789', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 18, NULL, NULL, 'Bengalooru', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'test56@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'pass@23378132', '7259268908', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9740723080', 'doctor12', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 0, NULL, NULL, 'Bengalooru', NULL, 'Vcare', 'India', NULL, NULL, 'This is Test Clinic', NULL, 'doctor12@gmail.com', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL, 0, 'doctor123456789', '7259268908', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9740723080', 'customer12', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 32, NULL, NULL, 'Bengalooru', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'customer12@gmail.com', NULL, NULL, NULL, 0, 'FEMALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'customer123456789', '7259268908', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9740723080', 'insurance12', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 0, NULL, NULL, 'Mysore', NULL, 'BharthiAxa', 'India', NULL, NULL, 'Company Started in 2019', NULL, 'insurance12@gmail.com', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, 0, 'insurance12345678', '7259268909', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9740723080', 'doctoruvce', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 0, NULL, NULL, 'Bangalore', NULL, 'Vivo', 'India', NULL, NULL, 'No 78. RT Nagar, Bangalore', NULL, 'doct@gmail.com', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL, 0, 'doctoruvce@123456789', '7259268908', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9740723080', 'patuvce', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 30, NULL, NULL, 'Bengalooru', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'patert@gmail.com', NULL, NULL, NULL, 0, 'FEMALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'pat@123456789', '729087654', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9740723080', 'insuranceagent12', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 0, NULL, NULL, 'Mysore', NULL, 'Bharthi Axa Ins', 'India', NULL, NULL, 'It is providing Healt and Life Insurance', NULL, 'bharthiaxa.insurance@gmaill.com', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, 0, 'insuranceagent123456', '67890654', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9740723080', 'doc2387482', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 0, NULL, NULL, 'kdasjkdasjksdkj', NULL, 'kwekrjewk', 'sfksjdkfjk', NULL, NULL, 'kasdjkfjsdjjkfksdjfjk', NULL, 'sdjhf@gmail.com', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, NULL, 0, '934895893jksdfjfkjks', '92348982938948', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'ksdjfjsdkjfkj', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-8867487802', 'uvcesantizeradmin123', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 25, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'aaquibnawazrvce@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, 'uvcesantizeradmin123@8867487802', '7259268909', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-8867487802', 'sanitizeuser1', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 23, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'sanitize@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'sanitizeruser123', '2849384923984', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-8867487802', 'sanitizernewuser2', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 23, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'sanitizerapp@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'pass@23378132', '987654321', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-7259268907', 'customer12', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 23, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'testr45@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'pass@123456789', '239420394092', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-RIGELSOFT', 'rigeladmin123', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 25, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'aaquibnawazrvce@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, 'rigeladmin@0987654321', '7259268909', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-RIGELSOFT', 'zuheef', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 22, 'RTNAGAR', NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'zuheef@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, 'zuheef@987654321', '897654321', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9880185386', 'cust10112019', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 23, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'testme123@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'pass@23378132', '78127312873', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9880185386', 'admin123', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 23, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'testme123@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, 'pass@23378132', '78127312873', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9880185386', 'newuser890', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 22, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'test45@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'pass@23378132', '9435389909', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9880185386', 'vituser12', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 33, NULL, NULL, 'Vellore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'vituser@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, ' pass@12345', '7777999098', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Tamil Naidu', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9880185386', 'vit12', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 22, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'test451@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 0, 'pass@123456789', '237482378472', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0),
	('APP+91-9880185386', 'sathishadmin', '2021-09-29 00:00:00', '2021-09-29 00:00:00', NULL, NULL, 22, NULL, NULL, 'Bangalore', NULL, NULL, 'India', NULL, NULL, NULL, NULL, 'test451@gmail.com', NULL, NULL, NULL, 0, 'MALE', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 0, 'pass@123456789', '237482378472', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'Karnataka', NULL, NULL, 0, 0, NULL, NULL, 0);
/*!40000 ALTER TABLE `usermaintain` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
