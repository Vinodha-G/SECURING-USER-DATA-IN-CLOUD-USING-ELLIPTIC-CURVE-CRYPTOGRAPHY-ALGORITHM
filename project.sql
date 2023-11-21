-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2023 at 08:16 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecc`
--

-- --------------------------------------------------------

--
-- Table structure for table `fileupdetails`
--

CREATE TABLE `fileupdetails` (
  `ownername` varchar(50) NOT NULL,
  `filename` varchar(50) NOT NULL,
  `path` varchar(100) NOT NULL,
  `publickey` varchar(500) NOT NULL,
  `privatekey` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fileupdetails`
--

INSERT INTO `fileupdetails` (`ownername`, `filename`, `path`, `publickey`, `privatekey`) VALUES
('aa', 'hi.txt', 'F:SERVERhi.txt', 'C:/Users/MAXPRO/Desktop/gpk.txt', 'C:/Users/MAXPRO/Desktop/gprk.txt'),
('aa', 'hi.txt', 'D:SERVERhi.txt', 'C:/Users/MAXPRO/Desktop/gpk.txt', 'C:/Users/MAXPRO/Desktop/gprk.txt'),
('aa', 'bb.txt', 'D:SERVERb.txt', 'C:/Users/MAXPRO/Desktop/gpk.txt', 'C:/Users/MAXPRO/Desktop/gprk.txt'),
('aa', 'bb.txt', 'D:SERVERb.txt', 'C:/Users/MAXPRO/Desktop/gpk.txt', 'C:/Users/MAXPRO/Desktop/gprk.txt');

-- --------------------------------------------------------

--
-- Table structure for table `keyfilepath`
--

CREATE TABLE `keyfilepath` (
  `privatekeyfile` varchar(1000) NOT NULL,
  `publickeyfile` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `keyfilepath`
--

INSERT INTO `keyfilepath` (`privatekeyfile`, `publickeyfile`) VALUES
('C:/Users/MAXPRO/Desktop/gprk.txt', 'C:/Users/MAXPRO/Desktop/gpk.txt'),
('C:/Users/MAXPRO/Desktop/gprk.txt', 'C:/Users/MAXPRO/Desktop/gpk.txt'),
('C:/Users/MAXPRO/Desktop/gprk.txt', 'C:/Users/MAXPRO/Desktop/gpk.txt'),
('C:/Users/MAXPRO/Desktop/gprk.txt', 'C:/Users/MAXPRO/Desktop/gpk.txt');

-- --------------------------------------------------------

--
-- Table structure for table `reqkey`
--

CREATE TABLE `reqkey` (
  `username` varchar(50) NOT NULL,
  `ownername` varchar(50) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reqkey`
--

INSERT INTO `reqkey` (`username`, `ownername`, `filename`, `status`) VALUES
('bb', 'aa', 'bb.txt', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `userregister`
--

CREATE TABLE `userregister` (
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `cpassword` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userregister`
--

INSERT INTO `userregister` (`name`, `password`, `cpassword`, `email`) VALUES
('aa', 'aa', 'aa', 'aa@gmail.com'),
('bb', 'bb', 'bb', 'bb@gmail.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
