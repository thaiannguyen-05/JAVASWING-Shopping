-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2025 at 04:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  `Dob` varchar(13) DEFAULT NULL,
  `Position` varchar(50) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  `PassWord` varchar(50) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `SelectStaySign` varchar(3) DEFAULT '0',
  `TimeToChangeUserName` varchar(3) DEFAULT '0',
  `Budget` varchar(30) DEFAULT NULL,
  `CheckLogin` varchar(3) NOT NULL DEFAULT '0',
  `voucher` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cID`, `Name`, `Address`, `Gender`, `Email`, `Dob`, `Position`, `UserName`, `PassWord`, `Phone`, `SelectStaySign`, `TimeToChangeUserName`, `Budget`, `CheckLogin`, `voucher`) VALUES
(1, 'BrownJac', 'Singapore', 'Male', 'jackbrown@gmail.com', '1996-00-17', 'customer', 'jack', 'brown123@', NULL, '0', '0', NULL, '0', NULL),
(3, 'John Smith', '123 Main St, New York, NY', 'Male', 'john.smith@email.com', '1985-06-15', 'Senior Developer', 'jsmith', 'Pass123!', NULL, '0', '1', NULL, '0', NULL),
(4, 'Sarah Johnson', '456 Oak Ave, Chicago, IL', 'Female', 'sarah.j@email.com', '1990-03-22', 'Project Manager', 'sjohnson', 'SecureP@ss2', '312-555-6789', '0', '1', '4500000.0', '0', NULL),
(5, 'Michael Chen', '789 Pine St, San Francisco, CA', 'Male', 'mchen@email.com', '1988-11-30', 'UX Designer', 'mchen', 'Design2024!', NULL, '0', '1', '78000', '0', NULL),
(6, 'Emily Rodriguez', '234 Elm St, Austin, TX', 'Female', 'erodriguez@email.com', '1992-07-18', 'Data Analyst', 'erodriguez', 'DataPro#456', NULL, '0', '1', NULL, '0', NULL),
(7, 'David Kim', '567 Maple Dr, Seattle, WA', 'Male', 'dkim@email.com', '1983-00-05', 'Systems Administrator', 'dki', 'SysAdm1n!', '206-555-9876', '0', '1', NULL, '0', NULL),
(8, 'Lisa Wang', '890 Cedar Blvd, Boston, MA', 'Female', 'lwang@email.com', '1991-12-03', 'Marketing Specialist', 'lwang', 'Mkt2025#', NULL, '0', '1', '65000', '0', NULL),
(9, 'Robert Taylor', '123 Birch St, Denver, CO', 'Male', 'rtaylor@email.com', '1987-04-25', 'Financial Analyst', 'rtaylor', 'Finance$789', '303-555-4567', '0', '1', '82000', '0', NULL),
(10, 'Jennifer Lopez', '456 Walnut Ave, Miami, FL', 'Female', 'jlopez@email.com', '1989-08-10', 'HR Manager', 'jlopez', 'HRMan@ger', NULL, '0', '1', NULL, '0', NULL),
(11, 'Thomas Wright', '789 Cherry Ln, Portland, OR', 'Male', 'twright@email.com', '1984-02-14', 'Product Manager', 'twright', 'Product#321', '503-555-7890', '0', '1', '90000', '0', NULL),
(12, 'Michelle Garcia', '234 Aspen Dr, Phoenix, AZ', 'Female', 'mgarcia@email.com', '1993-10-08', 'Content Writer', 'mgarcia', 'Write123!', NULL, '0', '1', '60000', '0', NULL),
(15, '1', '1', 'Male', '3', '2000-01-02', 'customer', '1', '1', NULL, '0', '0', NULL, '0', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `dateofshift`
--

CREATE TABLE `dateofshift` (
  `dateOfWeek` varchar(10) NOT NULL,
  `dateOfMonth` varchar(15) NOT NULL,
  `shiftHaveChoose` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dateofshift`
--

INSERT INTO `dateofshift` (`dateOfWeek`, `dateOfMonth`, `shiftHaveChoose`) VALUES
('Monday', '2025-05-05', 'not registered'),
('Tuesday', '2025-05-06', 'Afternoon Shift(14 : 00 - 22 : 00)'),
('Wednesday', '2025-05-07', 'not registered'),
('Thursday', '2025-05-08', 'not registered'),
('Friday', '2025-05-09', 'not registered'),
('Saturday', '2025-05-10', 'not registered'),
('Sunday', '2025-05-11', 'not registered');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `eID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  `Dob` date DEFAULT NULL,
  `Position` varchar(12) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  `PassWord` varchar(50) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `SelectStaySign` varchar(2) DEFAULT '0',
  `TimeToChangeUserName` varchar(3) DEFAULT '0',
  `salary` varchar(30) DEFAULT NULL,
  `totalShift` int(11) DEFAULT NULL,
  `CheckLogin` varchar(3) DEFAULT '0',
  `detailShift` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`eID`, `Name`, `Address`, `Gender`, `Email`, `Dob`, `Position`, `UserName`, `PassWord`, `Phone`, `SelectStaySign`, `TimeToChangeUserName`, `salary`, `totalShift`, `CheckLogin`, `detailShift`) VALUES
(3, 'John Smith', '123 Main St, New York, NY', 'Male', 'john.smith@email.com', '1985-06-15', 'employee', 'jsmith', 'Pass123!', NULL, '0', '1', '0', 0, '0', 'WednesdayMorning Shift(6 : 00 - 14 : 00)\nWednesdayMorning Shift(6 : 00 - 14 : 00)\nFridayMorning Shift(6 : 00 - 14 : 00)\nTuesdayAfternoon Shift(14 : 00 - 22 : 00)\n');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pID` int(11) NOT NULL,
  `barCode` varchar(50) DEFAULT NULL,
  `NameProduct` varchar(30) DEFAULT NULL,
  `costPrice` varchar(30) DEFAULT NULL,
  `sellPrice` varchar(30) DEFAULT NULL,
  `quantity` varchar(30) DEFAULT NULL,
  `mfdDate` varchar(30) DEFAULT NULL,
  `expDate` varchar(30) DEFAULT NULL,
  `brandName` varchar(50) DEFAULT NULL,
  `discount` varchar(30) DEFAULT NULL,
  `pathImg` varchar(100) DEFAULT NULL,
  `typeOfClothes` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pID`, `barCode`, `NameProduct`, `costPrice`, `sellPrice`, `quantity`, `mfdDate`, `expDate`, `brandName`, `discount`, `pathImg`, `typeOfClothes`) VALUES
(1, '123', 'QuanSuong', '120000', '150000', '16', '2010-01-14', '2032-05-13', 'đẹp trai Brand', '1', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\quan1.png', 'Trousers'),
(2, '1234', 'Áo đẹp trai', '120000', '150000', '50', '2009-01-16', '2029-05-10', 'đẹp trai Brand', '0', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\imgProduct\\ao1.png', 'T-Shirt'),
(3, '2345', 'áo xấu trai', '100000', '130000', '100', '2006-01-27', '2026-05-01', 'xấu trai brand', '12', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\imgProduct\\ao2.png', 'T-Shirt'),
(4, '123123', 'áo xanh', '90000', '90000', '30', '2004-01-09', '2028-09-21', 'đẹp trai brand', '0', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\imgProduct\\ao3.png', 'T-Shirt'),
(5, '1324232', 'áo xám', '80000', '90000', '15', '2000-01-02', '2029-11-06', 'EllBrand', '0', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\imgProduct\\ao4.png', 'T-Shirt'),
(6, '12312321', 'Áo đen', '200000', '200000', '25', '2004-01-10', '2031-09-25', 'xấu trai brand', '0', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\imgProduct\\ao5.png', 'T-Shirt'),
(7, '42233', 'Áo sad boi', '250000', '270000', '50', '2004-01-16', '2028-05-25', 'saiboyBrand', '13', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\imgProduct\\ao6.png', 'T-Shirt'),
(8, '343455', 'áo khoác đẹp trai', '300000', '320000', '50', '2003-01-16', '2028-05-17', 'đẹp trai brand', '0', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\5df6c5b103bd937819a13bb536639836.png', 'Jacket'),
(9, '309232', 'áo nắng', '150000', '160000', '200', '1996-01-17', '2029-05-17', 'áo nắng Việt Nam', '0', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\6da3c0f482bd0379928de2f9d92817aa.png', 'Jacket'),
(10, '23982', 'áo 007', '500000', '520000', '50', '2000-01-02', '3000-05-22', 'đẹp trai brand', '0', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\1028d08bbb5b06e4d5a182c4bbaeaeb0.png', 'Jacket'),
(11, '276327', 'quần đẹp trai', '300000', '300000', '50', '2000-01-02', '2029-05-11', 'xấu trai brand', '0', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\quan2.png', 'Trousers'),
(12, '4356546', 'quần suông', '400000', '420000', '100', '2004-01-22', '2029-05-19', 'đẹp trai brand', '14', 'D:\\Back Up Data\\Cong nghe Java\\Shopping\\src\\product\\quan3.png', 'Trousers');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `sID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  `Dob` date DEFAULT NULL,
  `Position` varchar(12) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  `PassWord` varchar(50) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `SelectStaySign` varchar(2) DEFAULT '0',
  `TimeToChangeUserName` varchar(3) DEFAULT '0',
  `Budget` varchar(50) DEFAULT NULL,
  `CheckLogin` varchar(3) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`sID`, `Name`, `Address`, `Gender`, `Email`, `Dob`, `Position`, `UserName`, `PassWord`, `Phone`, `SelectStaySign`, `TimeToChangeUserName`, `Budget`, `CheckLogin`) VALUES
(13, 'John Smith', '123 Main St, New York, NY', 'Male', 'john.smith@email.com', '1985-06-15', 'Developer', 'jsmith', 'Pass123!', NULL, '0', '1', '85000', '0'),
(14, 'Sarah Johnson', '456 Oak Ave, Chicago, IL', 'Female', 'sarah.j@email.com', '1990-03-22', 'Manager', 'sjohnson', 'SecureP@ss2', '312-555-6789', '0', '1', '95000', '0'),
(15, 'Michael Chen', '789 Pine St, San Francisco, CA', 'Male', 'mchen@email.com', '1988-11-30', 'Designer', 'mchen', 'Design2024!', NULL, '0', '1', '78000', '0'),
(16, 'Emily Rodriguez', '234 Elm St, Austin, TX', 'Female', 'erodriguez@email.com', '1992-07-18', 'Analyst', 'erodriguez', 'DataPro#456', NULL, '0', '1', '72000', '0'),
(17, 'David Kim', '567 Maple Dr, Seattle, WA', 'Male', 'dkim@email.com', '1983-09-05', 'Admin', 'dkim', 'SysAdm1n!', '206-555-9876', '0', '1', '80000', '0'),
(18, 'Lisa Wang', '890 Cedar Blvd, Boston, MA', 'Female', 'lwang@email.com', '1991-12-03', 'Marketing', 'lwang', 'Mkt2025#', NULL, '0', '1', '65000', '0'),
(19, 'Robert Taylor', '123 Birch St, Denver, CO', 'Male', 'rtaylor@email.com', '1987-04-25', 'Finance', 'rtaylor', 'Finance$789', '303-555-4567', '0', '1', '82000', '0'),
(20, 'Jennifer Lopez', '456 Walnut Ave, Miami, FL', 'Female', 'jlopez@email.com', '1989-08-10', 'HR', 'jlopez', 'HRMan@ger', NULL, '0', '1', '75000', '0'),
(21, 'Thomas Wright', '789 Cherry Ln, Portland, OR', 'Male', 'twright@email.com', '1984-02-14', 'Product', 'twright', 'Product#321', '503-555-7890', '0', '1', '90000', '0'),
(22, 'Michelle Garcia', '234 Aspen Dr, Phoenix, AZ', 'Female', 'mgarcia@email.com', '1993-10-08', 'Writer', 'mgarcia', 'Write123!', NULL, '0', '1', '60000', '0'),
(24, '1', '3', 'Male', '2', '2000-01-02', 'supplier', '1', '1', NULL, '0', '0', '500000', '0');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Dob` varchar(12) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Position` varchar(50) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  `PassWord` varchar(50) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `SelectStaySign` varchar(3) DEFAULT '0',
  `TimeToChangeUserName` varchar(3) DEFAULT '0',
  `CheckLogin` varchar(3) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `Name`, `Address`, `Gender`, `Dob`, `Email`, `Position`, `UserName`, `PassWord`, `Phone`, `SelectStaySign`, `TimeToChangeUserName`, `CheckLogin`) VALUES
(1, 'Thai An', 'VietNam', 'male', '2005-12-02', 'thaiandev05@gmail.com', 'admin', 'admin', 'admin', '0337700159', '0', '0', '0'),
(2, 'chan', 'VietNam', 'Female', '2002-00-05', 'chan@gmail.com', 'admin', 'chan', 'chan@', NULL, '0', '0', '0'),
(3, 'John Smith', '123 Main St, New York, NY', 'Male', '1985-06-15', 'john.smith@email.com', 'employee', 'jsmith', 'Pass123!', NULL, '0', '1', '0'),
(4, 'Sarah Johnson', '456 Oak Ave, Chicago, IL', 'Female', '1990-03-22', 'sarah.j@email.com', 'customer', 'sjohnson', 'SecureP@ss2', '312-555-6789', '1', '0', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cID`),
  ADD UNIQUE KEY `unique_userName` (`UserName`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`eID`),
  ADD UNIQUE KEY `unique_userName` (`UserName`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`sID`),
  ADD UNIQUE KEY `unique_userName` (`UserName`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `unique_userName` (`UserName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `eID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `sID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
