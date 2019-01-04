-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 05, 2017 at 12:50 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `studentdemo`
--

-- --------------------------------------------------------

--
-- Table structure for table `course_details`
--

CREATE TABLE IF NOT EXISTS `course_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_code` varchar(255) NOT NULL,
  `course_credit` int(11) DEFAULT NULL,
  `course_title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `course_details`
--

INSERT INTO `course_details` (`id`, `course_code`, `course_credit`, `course_title`) VALUES
(1, 'Cse2015', 3, 'Java'),
(2, 'Cse2016', 1, 'Java Lab'),
(3, 'Cse3011', 3, 'Database'),
(4, 'Cse3012', 1, 'Database Lab'),
(5, 'Cse4047', 3, 'Advance Java'),
(6, 'Cse4048', 1, 'Advance Java Lab'),
(7, 'Cse3035', 3, 'Information System Design And Software Engineering'),
(8, 'Cse3036', 1, 'Information System Design And Software Engineering Lab'),
(9, 'Cse4012', 1, 'Networking Lab');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
