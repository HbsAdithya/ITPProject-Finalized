-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2020 at 02:10 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `fullname` text NOT NULL,
  `date` text NOT NULL,
  `attendance` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `fullname`, `date`, `attendance`) VALUES
(2, 'Imesha Anuruddha', '2020-04-12', 'Arrived');

-- --------------------------------------------------------

--
-- Table structure for table `customerdetails`
--

CREATE TABLE `customerdetails` (
  `id` int(11) NOT NULL,
  `cname` varchar(30) NOT NULL,
  `ctype` varchar(20) NOT NULL,
  `mobileno` int(20) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerdetails`
--

INSERT INTO `customerdetails` (`id`, `cname`, `ctype`, `mobileno`, `email`) VALUES
(38896, 'Shashith Adithya', 'Bulk', 703673617, 'adithya@gmail.com'),
(38897, 'T Abishek', 'Regular', 768327247, 'tabishek@gmail.com'),
(38898, 'J Abishek', 'Regular', 704081881, 'jabishek@gmail.com'),
(38899, 'Kapilan', 'Bulk', 704081883, 'kapilan@gmail.com'),
(38900, 'kishan', 'Regular', 987633521, 'kishan@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `ID` int(150) NOT NULL,
  `NoofItems` int(150) DEFAULT NULL,
  `GrossTotal` double DEFAULT NULL,
  `StaffID` varchar(150) DEFAULT NULL,
  `PaymentMethod` varchar(150) DEFAULT NULL,
  `Amount_Paid` double DEFAULT NULL,
  `Balance` double DEFAULT NULL,
  `CardType` varchar(150) DEFAULT NULL,
  `CardNumber` varchar(150) DEFAULT NULL,
  `Credit` double DEFAULT NULL,
  `CustomerID` varchar(150) DEFAULT NULL,
  `DateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`ID`, `NoofItems`, `GrossTotal`, `StaffID`, `PaymentMethod`, `Amount_Paid`, `Balance`, `CardType`, `CardNumber`, `Credit`, `CustomerID`, `DateTime`) VALUES
(111567, 7, 450, 'S112', 'Card', 450, 0, 'MasterCard', '1234 1234 1234', 0, NULL, '2020-05-15 07:03:00'),
(111568, 5, 450, 'S112', 'Cash', 500, 50, NULL, NULL, 0, NULL, '2020-05-15 03:59:00'),
(111569, 10, 1320, 'S111', 'Cash', 1500, 180, NULL, NULL, NULL, NULL, '2020-05-15 12:40:00'),
(111570, 3, 200, 'S112', 'Cash', 200, 0, NULL, NULL, NULL, NULL, '2020-05-15 04:59:00'),
(111571, 6, 860, 'S115', 'Credit', 860, 0, NULL, NULL, 860, 'C123', '2020-05-16 06:15:00'),
(111572, 4, 1600, 'S112', 'Card', 1600, 0, 'VISA', '1234 1234 1234 ', NULL, NULL, '2020-05-16 13:49:00'),
(111584, 1, 20, 'Staff1', 'cash', 500, 480, NULL, NULL, 0, NULL, '2020-05-17 20:30:47');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `product_description` varchar(200) NOT NULL,
  `product_image` varchar(200) NOT NULL,
  `product_quantity` int(50) NOT NULL,
  `product_category` varchar(50) NOT NULL,
  `product_expiredate` date NOT NULL,
  `product_generic` varchar(200) NOT NULL,
  `product_code` varchar(50) NOT NULL,
  `product_cost` double NOT NULL,
  `product_retailprice` double NOT NULL,
  `supplier_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_description`, `product_image`, `product_quantity`, `product_category`, `product_expiredate`, `product_generic`, `product_code`, `product_cost`, `product_retailprice`, `supplier_name`) VALUES
(64, 'Insulin', 'used to improve blood sugar', 'Insulin.png', 100, 'Medicine', '2019-12-29', 'Insulin Lispro', 'In2', 560, 890, 'Hemas'),
(89, 'Amoxicillin 500mg (A 45)', 'used to treat....', 'Amoxicillin 500mg (A 45).png', 700, 'Medicine', '2020-05-19', 'penicillin', 'am4', 25, 50, 'Hemas'),
(98, 'Panadol', 'Pain relief', 'Panadol.png', 500, 'Medicine', '2020-06-30', 'Aspirine', 'pn5', 1.2, 2, 'My Chemist'),
(102, 'Anchor 1KG', 'Milk Powder', 'Anchor.png', 1, 'General Product', '2021-05-09', 'food', 'Anc01', 800, 910, 'Alaris'),
(103, 'Doxeoin 10mg (MYLAN 1049)', 'used to treat anxiety or depression ', 'Doxeoin 10mg (MYLAN 1049).png', 1000, 'Medicine', '2020-12-28', 'Sinequan ', 'Dx10', 25, 48, 'Pharma Associates'),
(104, 'Vitamin-C 500mg', 'Boost humanity', 'Vitamin-C 500mg.png', 500, 'Medicine', '2021-11-17', 'Xon-Ce', 'Vm500', 12, 15, 'Pharma Associates'),
(105, 'Costi 10mg', 'Used to treat blood pressure', 'Costi 10mg.png', 1000, 'Medicine', '2020-12-22', 'domperidonum', 'Cos1mg', 22.2, 25.5, 'Hemas'),
(106, 'Noklot 75 mg', 'Blood circulation', 'Noklot 75 mg.png', 2000, 'Medicine', '2022-04-14', 'Plavix', 'Novz', 15, 21.03, 'Alaris'),
(107, 'Atorva 10mg', 'Cholesterol tablet', 'Atorva 10mg.png', 800, 'Medicine', '2020-12-31', 'Dxpine', 'ATV2', 8, 13.4, 'Hemas'),
(108, 'Nervex-BT', 'Used for nuero problems', 'Nervex-BT.png', 1000, 'Medicine', '2021-08-20', 'Avexie', 'NBt', 42, 50, 'My Chemist'),
(109, 'Cataflam 50mg', 'Pain Relief tablet', 'Cataflam 50mg.png', 1000, 'Medicine', '2020-07-12', 'Norvat', 'CatF', 18, 25, 'My Chemist'),
(110, 'Glycomet', 'Pressure', 'Glycomet.png', 1000, 'Medicine', '2020-05-23', 'Metformin', 'G123', 9, 12, 'Hemas Distribution');

-- --------------------------------------------------------

--
-- Table structure for table `returnproduct`
--

CREATE TABLE `returnproduct` (
  `id` int(11) NOT NULL,
  `customer_name` varchar(150) NOT NULL,
  `product` varchar(200) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `returnproduct`
--

INSERT INTO `returnproduct` (`id`, `customer_name`, `product`, `quantity`, `amount`, `total`) VALUES
(0, 'Abishek', 'Panadol', 6, 60, 360),
(0, 'Abishek', 'Panadol', 1, 60, 60),
(0, 'Abishek', 'medicine1', 5, 1000, 5000),
(0, 'Abishek', 'medicine1', 5, 1000, 5000),
(0, 'Abishek', 'medicine3', 4, 60, 240),
(0, 'Abishek', 'medicine1', 5, 1000, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `salesaddprod`
--

CREATE TABLE `salesaddprod` (
  `prodID` int(50) NOT NULL,
  `prodName` varchar(150) NOT NULL,
  `Price` double NOT NULL,
  `Qty` int(100) NOT NULL,
  `Amt` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `full_name` text NOT NULL,
  `address` text NOT NULL,
  `designation` text NOT NULL,
  `dob` text NOT NULL,
  `age` int(11) NOT NULL,
  `gender` text NOT NULL,
  `nic` text NOT NULL,
  `phone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `full_name`, `address`, `designation`, `dob`, `age`, `gender`, `nic`, `phone`) VALUES
(1, 'Imesha Anuruddha', 'Dewata Rd, Ihalagama', 'sd', '2020-04-07', 45, 'male', '123456789v', '0771234567'),
(2, 'Kamal', 'Dewata Rd, Ihalagama', 'sd', '2020-04-07', 50, 'male', '123456789v', '0771234567'),
(3, 'suni', 'Dewata Rd, Ihalagama', 'zzz', '2020-04-07', 45, 'male', '123456789v', '0771234567');

-- --------------------------------------------------------

--
-- Table structure for table `staffleave`
--

CREATE TABLE `staffleave` (
  `id` int(11) NOT NULL,
  `full_name` text NOT NULL,
  `nuOfDays` int(11) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffleave`
--

INSERT INTO `staffleave` (`id`, `full_name`, `nuOfDays`, `description`) VALUES
(1, 'Imesha Anuruddha', 2, 'sdf'),
(2, 'dasun', 2, 'sdf'),
(3, 'Kamal ssenarathne', 12, 'Test');

-- --------------------------------------------------------

--
-- Table structure for table `supplier_details`
--

CREATE TABLE `supplier_details` (
  `supplier_id` int(5) NOT NULL,
  `supplier_name` varchar(150) NOT NULL,
  `supplier_addrs` varchar(300) NOT NULL,
  `supplier_city` varchar(50) NOT NULL,
  `supplier_phone` int(10) NOT NULL,
  `supplier_email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier_details`
--

INSERT INTO `supplier_details` (`supplier_id`, `supplier_name`, `supplier_addrs`, `supplier_city`, `supplier_phone`, `supplier_email`) VALUES
(10, 'My Chemistt', '37, Kirulapane Avenue', 'Colombo -05', 112415206, 'mychemist@yahoo.com'),
(11, 'Alaris', '9/3, Horona Road, Kesbewa', 'Pilyandala', 117028043, 'alaris@gmail.com'),
(12, 'State Pharmaceutical coporation of Sri Lanka', '85, Galee road', 'colombo-04', 119494436, 'spcsl@gmail.com'),
(13, 'Hemas', '307, Negombo road', 'Ragama', 111776376, 'HemasPvt@gmail.com'),
(14, 'Pharma Associates', '116, Layards Broadway', 'colombo - 14', 111695512, 'pharmaassociates@gmail.com'),
(15, 'Hemas Distribution', 'No 17, 10th Lane', 'Colombo', 1234456788, '1234@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `supplier_products`
--

CREATE TABLE `supplier_products` (
  `supOrd_id` int(5) NOT NULL,
  `sup_name` varchar(150) NOT NULL,
  `pro_name` varchar(150) NOT NULL,
  `pro_quantity` int(10) NOT NULL,
  `pro_category` varchar(150) NOT NULL,
  `date_supplied` date NOT NULL,
  `pro_cost` int(10) NOT NULL,
  `credit_limit` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier_products`
--

INSERT INTO `supplier_products` (`supOrd_id`, `sup_name`, `pro_name`, `pro_quantity`, `pro_category`, `date_supplied`, `pro_cost`, `credit_limit`) VALUES
(5004, 'American Premium Waters', '500 ml water bottle', 1000, 'Others ', '2020-05-13', 30000, 25000),
(5005, 'Hemas', 'Amoxicillin caps 500 mg', 300, 'Medication ', '2020-05-12', 1800, 1800),
(5006, 'Alaris', 'Risol 20', 500, 'Medication  ', '2020-05-20', 5000, 4500),
(5007, 'Alaris', 'LOSCAM 25', 500, 'Medication ', '2020-05-14', 10000, 10000),
(5008, 'Pharma Associates', 'Minobor 2 mg', 2000, 'Medication ', '2020-05-26', 8000, 7500),
(5009, 'Alaris', 'Lovaststin Tab 20mg', 1000, 'Medication ', '2020-05-26', 2000, 2000),
(5010, 'American Premium Waters', '1500 ml water bottle', 500, 'Others ', '2020-05-26', 37500, 36000),
(5011, 'Hemas', 'pantoprazole 40mg', 1000, 'Medication ', '2020-05-10', 40000, 35000),
(5012, 'Alaris', 'Amoxicillin caps 500 mg', 100, 'Medication ', '2020-05-26', 500, 400);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customerdetails`
--
ALTER TABLE `customerdetails`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staffleave`
--
ALTER TABLE `staffleave`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplier_details`
--
ALTER TABLE `supplier_details`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `supplier_products`
--
ALTER TABLE `supplier_products`
  ADD PRIMARY KEY (`supOrd_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customerdetails`
--
ALTER TABLE `customerdetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38901;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `ID` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111585;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `staffleave`
--
ALTER TABLE `staffleave`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `supplier_details`
--
ALTER TABLE `supplier_details`
  MODIFY `supplier_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `supplier_products`
--
ALTER TABLE `supplier_products`
  MODIFY `supOrd_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5013;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
