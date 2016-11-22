-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 21, 2016 at 12:05 AM
-- Server version: 5.5.52-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `issue_tracker`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` text NOT NULL,
  `commentator` varchar(200) NOT NULL,
  `issue_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `issue_id` (`issue_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=43 ;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `comment`, `commentator`, `issue_id`) VALUES
(1, 'Java', 'visitor 01', 12),
(2, 'JSF 2x', 'visitor 01', 12),
(3, 'Prime Faces', 'visitor 01', 12),
(4, 'EJB 3x', 'visitor 02', 12),
(5, 'JPA', 'visitor 02', 12),
(6, 'Hibernate', 'visitor 02', 12),
(7, 'MySQL', 'visitor 03', 12),
(8, 'Wildfly', 'visitor 04', 12),
(9, 'HTML/XHTML', 'visitor 05', 12),
(10, 'CSS', 'visitor 06', 12),
(23, 'Issues:\r\ntitle, description, author, state and submission date and time.', 'user #01', 17),
(25, 'States:\r\nNew, Open, Fixed and Closed.', 'user #02', 17),
(26, 'Users:\r\nusername, password, full name and e-mail.', 'user #03', 17),
(27, 'Comments:\r\ncomment and commentator, for issue.', 'user #04', 17),
(30, 'agree', 'admin', 17),
(31, 'and approve', 'admin01', 17),
(35, 'to be completed ASAP', 'admin', 8),
(36, 'Issue Tracker project is selected.', 'user', 11),
(40, 'Future improvements:\r\n- use facelets, templates for views (XHTML);\r\n- support cookies;\r\n- add avatars (img) for users (profiles);\r\n- admin approves comments, show/hide.', 'dev', 17),
(41, 'OK (approve)', 'admin', 10);

-- --------------------------------------------------------

--
-- Table structure for table `issues`
--

CREATE TABLE IF NOT EXISTS `issues` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL,
  `description` text NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `submission_date_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `state_id` (`state_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `issues`
--

INSERT INTO `issues` (`id`, `title`, `description`, `user_id`, `state_id`, `submission_date_time`) VALUES
(1, 'User registration [REQUIRED]', 'Create user, log in. No authorization is required.\r\nOptional: user profiles, edit user.\r\nLogin and logout functionalities.', 2, 4, '2016-11-11 00:27:10'),
(2, 'View all issues [REQUIRED]', 'List issues.\r\nOptional: paging of issues.\r\nNo login is required.', 3, 4, '2016-11-11 01:48:24'),
(3, 'View issue details [REQUIRED]', 'View title, description, author, state and submission date and time of issue.\r\nIn a new page. No login is required.', 2, 4, '2016-11-11 01:27:18'),
(4, 'Create new issue [REQUIRED]', 'Crate issue functionality. Issues have title, description, author, state and submission date and time.\r\nThe states are: New, Open, Fixed and Closed.\r\nLogin is required.', 3, 4, '2016-11-11 01:27:56'),
(5, 'Edit issue [OPTIONAL]', 'Only title, description and state can be changed.\r\nLogin is required.', 3, 4, '2016-11-11 01:32:09'),
(6, 'Add new comment [OPTIONAL]', 'New comment can be added for an existing issue by visitors. Each visitor must fill out his name and comment text.\r\nNo login is required.', 3, 3, '2016-11-11 13:38:27'),
(7, 'Sidebar listing all issues states [OPTIONAL]', 'Implement a sidebar holding a list of all issues states. Clicking at issue state shows all issues matching this state.\r\nNo login is required.', 2, 3, '2016-11-11 13:38:46'),
(8, 'Search by title [OPTIONAL]', 'Functionality for searching by title (as substring).\r\nFilter can be used. No login is required.', 2, 3, '2016-11-11 13:39:18'),
(9, 'Admin panel [OPTIONAL]', 'Inside the admin panel: add/edit/delete issues and comments, add/edit user, etc.', 3, 3, '2016-11-11 13:39:33'),
(10, 'Issue Tracker', 'Design and implement a simple issue tracking system (bug tracker).\r\n\r\n\r\nRequired functionalities:\r\n\r\nUser registration (and optionally user profiles) / login / logout.\r\n\r\nView all issues (optionally with paging), without login.\r\n\r\nView issue details, without login.\r\n\r\nCreate new issue (after login). Issues have title, description, author, state and submission date and time. States are: New, Open, Fixed and Closed.\r\n\r\n\r\nOptional functionalities:\r\n\r\nEdit issue (after login). Can change only title, description and state.\r\n\r\nAdd new comment for existing issue by visitors – each visitor must fill out his name and comment text.\r\n\r\nImplement a sidebar holding a list of all issues states. Clicking at issue state shows all issues matching this state.\r\n\r\nFunctionality for searching by title (as substring).\r\n\r\nAdmin panel: add / edit / delete issues and comments, etc.', 2, 2, '2016-11-11 13:40:42'),
(11, 'Practical Project Assignment for Java EE Fundamentals course', 'Design and implement a Web-based JEE application, e.g. blog / forum / photo album / listings site / other.\r\n\r\n\r\nTechnologies \r\nThe technology stack for your project development must include the following, e.g.\r\nJava, JSF 2x and Prime Faces, EJB 3x, JPA and Hibernate, MySQL, Wildfly, HTML, CSS\r\n\r\nYou are allowed to use in addition other technologies like Bootstrap, SASS, LESS. You are allowed to use development tools, libraries and resources like Web design templates, Java Maven artefacts, Code generators and others.\r\n\r\n\r\nProject Scope\r\nYour project should implement at least the following functionality:\r\nUser registration, login and logout.\r\nView some content (e.g. blog articles, listings, photos, issues, publications, NOT users).\r\nCreate/Edit new content (e.g. post new blog article, post new listing, upload new photo, create new issue).\r\nOptionally implement more functionality.\r\n\r\nYour project should keep its data in a relational database \r\nUse at least 2 tables (collections) with a relationship, e.g. users and blog posts.\r\nUse a database (like MySQL).\r\n\r\nYour project should implement at least 4 pages (views).\r\n\r\nYou are allowed even to take the project developed during the course and extend it for your needs.\r\n\r\n\r\nForbidden Techniques and Tools\r\nYour project should be created by you only.\r\nYou are not allowed to copy a project from Internet and present it as your development.\r\nYou can use external libraries, frameworks and tools, but not to clone a project and present it as yours.\r\n\r\n\r\nDeliverables and Deadline\r\nThe project should be submitted as homework on the “Exam” part of the course\r\nAll projects should be submitted not later than 21 November 2016.\r\n\r\n\r\nPublic Project Defense\r\nEach student will have to deliver a public defense of its work in front of the trainer.\r\n\r\nThe student will have only ~15 minutes for the following:\r\nDemonstrate the application’s functionality (very shortly).\r\nShow the source code and explain briefly how it works.\r\nIf requested by the trainer, make a small change on the source code.\r\n\r\nHints for better presentation:\r\nBe well prepared for presenting maximum of your work for minimum time.\r\nOpen all project assets beforehand to save time: open your site in the browser, login and open the user / admin panel in another browser, etc.\r\n\r\n\r\nAssessment Criteria\r\nFunctionality – 0…70\r\nWhat is implemented? Does it work correctly? Does it have intuitive UI?\r\nHow much effort you have put in this project?\r\nIs the functionality enough according to the project requirements?\r\nWhat portion of the work is own code written by you and what is ready-to-use framework?\r\nProject/Source quality – 0…30\r\nIs the source code well formatted?\r\nAre code standards followed?\r\nIs JEE project structure correct?\r\nIs MVC standard followed?\r\nBonus – 0...10\r\nBonus point are given for implementing more than expected.\r\n\r\n\r\nSample Projects\r\nThe below described projects are sample, just to give you some ideas. You could work on your own project.', 3, 1, '2016-11-11 13:40:42'),
(12, 'Source Code Hierarchy', 'EJB module\r\n\r\nModel/Entity beans\r\n\r\ncom.jee.entity.base\r\nBaseDomainObject\r\n\r\ncom.jee.entity\r\nUserModel\r\nIssueModel\r\nStateModel\r\nCommentModel\r\n\r\n\r\nSession beans (implicit WebServices)\r\n\r\ncom.jee.service\r\nUserDaoService\r\nUserDaoServiceLocal\r\nIssueDaoService\r\nIssueDaoServiceLocal\r\nStateDaoService\r\nStateDaoServiceLocal\r\nCommentDaoService\r\nCommentDaoServiceLocal\r\n\r\n\r\nMETA-INF config\r\n\r\npersistence.xml\r\n\r\n\r\n\r\n\r\nWeb module\r\n\r\nWeb Managed Beans\r\n\r\ncom.jee.web.beans\r\nAdminBean.java\r\nLoginBean.java\r\n\r\ncom.jee.web.beans.comments\r\nCreateCommentBean.java\r\nDeleteCommentBean.java\r\nEditCommentBean.java\r\nListCommentBean.java\r\nViewCommentBean.java\r\n\r\ncom.jee.web.beans.issues\r\nCreateIssueBean.java\r\nDeleteIssueBean.java\r\nEditIssueBean.java\r\nListIssuesBean.java\r\nViewIssueBean.java\r\n\r\ncom.jee.web.beans.states\r\nListStatesBean.java\r\n\r\ncom.jee.web.beans.users\r\nCreateUserBean.java\r\nDeleteUserBean.java\r\nEditUserBean.java\r\nListUsersBean.java\r\n\r\n\r\nFilter\r\n\r\nAdminFilter.java\r\nAuthenticationFilter.java\r\n\r\n\r\nConstants\r\n\r\ncom.jee.web.constants\r\nOtherConstants.java\r\nUrlConstants.java\r\n\r\n\r\nUtils\r\n\r\ncom.jee.web.utils\r\nContextCheck.java\r\nGeneralUtils.java\r\nMessageUtils.java\r\n\r\ncom.jee.web.utils.validation\r\nValidateComment.java\r\nValidateIssue.java\r\nValidateUser.java\r\n\r\n\r\nResources\r\n\r\nresources\r\napplication.properties\r\n\r\n\r\nWebContent\r\n\r\nindex.jsp\r\n\r\nimg\r\ndelete.png, edit.png, excel.png, logout.png, pdf.png, user_profile.png\r\nimg/icon\r\nfavicon-16x16.png, favicon-32x32.png, favicon-96x96.png\r\n\r\nCSS\r\nbootstrap.css\r\ncommon.css\r\n\r\nView\r\npages\r\n\r\ncreateUser.xhtml\r\nerror.xhtml\r\nlistIssues.xhtml\r\nlogin.xhtml\r\nviewIssue.xhtml\r\n\r\npages/auth\r\ncreateIssue.xhtml\r\neditIssue.xhtml\r\neditUser.xhtml\r\nlistIssues.xhtml\r\nviewIssue.xhtml\r\n\r\npages/admin\r\nadminPanel.xhtml\r\ncreateIssue.xhtml\r\ncreateUser.xhtml\r\neditIssue.xhtml\r\neditUser.xhtml\r\nlistIssues.xhtml\r\nlistUsers.xhtml\r\nviewIssue.xhtml\r\n\r\nWEB-INF config\r\n\r\nbeans.xml\r\nfaces-config.xml\r\nweb.xml\r\n\r\nlibraries\r\nbcprov-jdk14-138.jar, commons-lang3-3.1.jar, gson-2.2.4.jar, primefaces-5.2.jar, primefaces-extensions-3.2.0.jar, redmond-1.0.9.jar', 4, 2, '2016-11-13 20:57:49'),
(17, 'Presentation', 'Main Features\r\nUser registration, login and logout.\r\nView pages with content. Create new content. Edit content.\r\n\r\nIssue Tracker\r\nUser registration, login and logout, user profiles).\r\nView all issues without and with login.\r\nView issue details without and with login.\r\nCreate new issue (after login).\r\nEdit issue (after login). Title, description and state can be changed.\r\nNew comment for existing issue by visitors can be added - each visitor must fill out his name and comment text.\r\nBar holding a list of all issues states. Clicking at issue state shows all issues matching this state.\r\nSearch by issue title (as substring, contains).\r\nAdmin panel: add, edit, delete issues, users and comments.', 2, 2, '2016-11-19 17:49:43');

-- --------------------------------------------------------

--
-- Table structure for table `states`
--

CREATE TABLE IF NOT EXISTS `states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `states`
--

INSERT INTO `states` (`id`, `type`) VALUES
(4, 'CLOSED'),
(3, 'FIXED'),
(1, 'NEW'),
(2, 'OPEN');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `full_name` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `full_name`, `email`) VALUES
(1, 'admin', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', 'Ad Min', 'admin@console.com'),
(2, 'user', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', 'Us Er', 'user@console.com'),
(3, 'user02', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', 'Us Er 02', NULL),
(4, 'test', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', 'Te St', 'test@console.com');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `fk_issues_id` FOREIGN KEY (`issue_id`) REFERENCES `issues` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `issues`
--
ALTER TABLE `issues`
  ADD CONSTRAINT `fk_states_id` FOREIGN KEY (`state_id`) REFERENCES `states` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
