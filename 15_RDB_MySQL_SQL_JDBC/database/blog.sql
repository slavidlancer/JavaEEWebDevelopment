-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 07, 2016 at 06:08 PM
-- Server version: 5.5.52-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `blog`
--

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(300) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `title`, `content`, `date`, `user_id`) VALUES
(1, 'Welcome', 'daljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq qdaljdqlihqlhm qhkhq q', '2016-10-19 22:00:37', 2),
(2, 'title', 'qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop', '2016-10-19 22:01:04', 3),
(3, 'titulum', 'asdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjkl\r\nasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjkl\r\nasdfghjkl\r\nasdfghjklasdfghjklasdfghjklasdfghjkl\r\nasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjkl', '2016-10-19 22:01:35', 2),
(4, 'new', 'content', '0000-00-00 00:00:00', 3),
(5, 'localhost', 'JEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application\r\nJEE application', '2016-11-07 17:25:28', 4),
(6, 'example', 'Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:Search all fields:', '0000-00-00 00:00:00', 7),
(7, 'title', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '2016-11-07 17:27:16', 3),
(8, 't', 'StringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringString', '2016-11-07 00:00:00', 5),
(9, 'i', 'information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information', '0000-00-00 00:00:00', 6),
(10, 'i2', 'information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information information', '2016-11-07 17:28:58', 6);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `first_name`, `last_name`, `email`) VALUES
(1, 'admin', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'Ad', 'Min', 'admin@administration.com'),
(2, 'user', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'First', 'Name', 'none@none.com'),
(3, 'some_user', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'Some', 'User', 'some@user.com'),
(4, 'usera', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, NULL, 'user@kliomba.com'),
(5, 'user01', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, 'name', NULL),
(6, 'alabala', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'Ala', 'Bala', 'ala@bala.com'),
(7, 'newuser', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'New', 'User', 'newuser@user.com');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
