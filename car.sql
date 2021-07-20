-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2021 at 11:03 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'secret');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `user` varchar(600) NOT NULL,
  `email` varchar(500) NOT NULL,
  `package` varchar(500) NOT NULL,
  `bookingdate` varchar(500) NOT NULL,
  `status` varchar(500) NOT NULL DEFAULT 'Pending',
  `Amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `user`, `email`, `package`, `bookingdate`, `status`, `Amount`) VALUES
(18, 'Prathap', 's@gmail.com', ' dsdssd', '2021/07/20 14:00:53', 'Cancelled', 500),
(19, 'Prathap', 'Prathap23@gmail.com', ' Silver Package', '2021/07/20 14:30:07', 'Pending', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `carpackage`
--

CREATE TABLE `carpackage` (
  `id` int(11) NOT NULL,
  `name` varchar(600) NOT NULL,
  `description` varchar(500) NOT NULL,
  `cost` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `carpackage`
--

INSERT INTO `carpackage` (`id`, `name`, `description`, `cost`) VALUES
(1, 'Premium Car Wash', 'Its A Premeium Pack', 5000),
(2, 'Silver Package', 'Its a silver Packages', 3000),
(3, 'Platinum Packages', 'Its A PlatinumPack', 7000),
(4, 'Silver Package', 'Its A Premeium Pack', 6000),
(5, 'Normal', 'Its A Premeium Pack', 6000);

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `id` int(11) NOT NULL,
  `name` varchar(600) NOT NULL,
  `description` varchar(500) NOT NULL,
  `destination` mediumtext NOT NULL,
  `hotel` varchar(5000) NOT NULL,
  `cost` int(11) NOT NULL,
  `days` int(11) NOT NULL,
  `start` varchar(6000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `package`
--

INSERT INTO `package` (`id`, `name`, `description`, `destination`, `hotel`, `cost`, `days`, `start`) VALUES
(10, 'Summer Package', 'JAffna Tourist places More Places Visit', 'Nelliyadi', 'Luxmy', 6000, 5, '2021-06-16'),
(11, 'Nuwerelliya Tour Pack', 'Nuwarelliya Tourist places More Places Visit', 'Nuwerelliya', 'Jetwing ', 5500, 4, '2021-06-25');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `fullname` varchar(600) NOT NULL,
  `username` varchar(60) NOT NULL,
  `mobile` int(12) NOT NULL,
  `address` varchar(600) NOT NULL,
  `mail` varchar(600) NOT NULL,
  `password` varchar(600) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `fullname`, `username`, `mobile`, `address`, `mail`, `password`) VALUES
(5, 'Prathap', 'Prathap', 754445454, 'Manipay,Srilanka', 'Prathap@gmail.com', '4545');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `carpackage`
--
ALTER TABLE `carpackage`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `carpackage`
--
ALTER TABLE `carpackage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `package`
--
ALTER TABLE `package`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
