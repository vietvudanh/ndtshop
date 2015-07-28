# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.25)
# Database: ndtshop
# Generation Time: 2015-07-28 16:17:17 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Category`;

CREATE TABLE `Category` (
  `CategoryID` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(30) DEFAULT NULL,
  `CategoryDescription` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Comment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Comment`;

CREATE TABLE `Comment` (
  `CommentID` int(11) NOT NULL AUTO_INCREMENT,
  `CommentContent` varchar(500) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `CommentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`CommentID`),
  KEY `FK_Product_Comment` (`ProductID`),
  KEY `FK_Customer_Comment` (`CustomerID`),
  CONSTRAINT `FK_Customer_Comment` FOREIGN KEY (`CustomerID`) REFERENCES `Customer` (`CustomerID`),
  CONSTRAINT `FK_Product_Comment` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Customer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerName` varchar(30) DEFAULT NULL,
  `CustomerDOB` datetime DEFAULT NULL,
  `CustomerTel` varchar(20) DEFAULT NULL,
  `CustomerEmail` varchar(30) DEFAULT NULL,
  `CustomerAddress` varchar(50) DEFAULT NULL,
  `CustomerCity` varchar(20) DEFAULT NULL,
  `CustomerCountry` varchar(20) DEFAULT NULL,
  `CustomerLastestLogin` datetime DEFAULT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Department
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Department`;

CREATE TABLE `Department` (
  `DepartmentID` int(11) NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table News
# ------------------------------------------------------------

DROP TABLE IF EXISTS `News`;

CREATE TABLE `News` (
  `NewsID` int(11) NOT NULL AUTO_INCREMENT,
  `NewsTitle` varchar(100) DEFAULT NULL,
  `NewsDescription` varchar(500) DEFAULT NULL,
  `StaffID` int(11) DEFAULT NULL,
  `NewsPostedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`NewsID`),
  KEY `FK_Staff_News` (`StaffID`),
  CONSTRAINT `FK_Staff_News` FOREIGN KEY (`StaffID`) REFERENCES `Staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table OrderDetail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `OrderDetail`;

CREATE TABLE `OrderDetail` (
  `OrderDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductExportPrice` float DEFAULT NULL,
  `OrderID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `ProductSaleQuantity` int(11) DEFAULT NULL,
  `Discount` float DEFAULT NULL,
  PRIMARY KEY (`OrderDetailID`),
  KEY `FK_Orders_OrderDetail` (`OrderID`,`ProductID`),
  KEY `FK_Products_OrderDetail` (`ProductID`),
  CONSTRAINT `FK_Orders_OrderDetail` FOREIGN KEY (`OrderID`) REFERENCES `Orders` (`OrderID`),
  CONSTRAINT `FK_Products_OrderDetail` FOREIGN KEY (`ProductID`) REFERENCES `Products` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Orders`;

CREATE TABLE `Orders` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(11) DEFAULT NULL,
  `StaffID` int(11) DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  `SaleDate` datetime DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `FK_Staff_Orders` (`StaffID`),
  KEY `FK_Customer_Orders` (`CustomerID`),
  CONSTRAINT `FK_Customer_Orders` FOREIGN KEY (`CustomerID`) REFERENCES `Customer` (`CustomerID`),
  CONSTRAINT `FK_Staff_Orders` FOREIGN KEY (`StaffID`) REFERENCES `Staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Products
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Products`;

CREATE TABLE `Products` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(30) DEFAULT NULL,
  `ProductDescription` varchar(500) DEFAULT NULL,
  `ProductImage` varchar(500) DEFAULT NULL,
  `ProductSalePrice` float DEFAULT NULL,
  `SubCategoryID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `FK_SubCategory_Product` (`SubCategoryID`),
  CONSTRAINT `FK_SubCategory_Product` FOREIGN KEY (`SubCategoryID`) REFERENCES `SubCategory` (`SubCategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ProductSupplier
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ProductSupplier`;

CREATE TABLE `ProductSupplier` (
  `SupplierID` int(11) NOT NULL DEFAULT '0',
  `ProductID` int(11) NOT NULL DEFAULT '0',
  `ProductImportPrice` float DEFAULT NULL,
  `ProductImportDate` datetime DEFAULT NULL,
  `ProductImportQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`SupplierID`,`ProductID`),
  KEY `FK_Product_ProductSupplier` (`ProductID`),
  CONSTRAINT `FK_Product_ProductSupplier` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`),
  CONSTRAINT `FK_Supplier_ProductSupplier` FOREIGN KEY (`SupplierID`) REFERENCES `Supplier` (`SupplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Roles
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Roles`;

CREATE TABLE `Roles` (
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Staff
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Staff`;

CREATE TABLE `Staff` (
  `StaffID` int(11) NOT NULL AUTO_INCREMENT,
  `StaffName` varchar(30) DEFAULT NULL,
  `StaffTel` varchar(20) DEFAULT NULL,
  `StaffDOB` datetime DEFAULT NULL,
  `StaffEmail` varchar(30) DEFAULT NULL,
  `StaffAddress` varchar(50) DEFAULT NULL,
  `StaffCity` varchar(20) DEFAULT NULL,
  `StaffCountry` varchar(20) DEFAULT NULL,
  `DepartmentID` int(11) DEFAULT NULL,
  `RoleID` int(11) DEFAULT NULL,
  `StaffLastestLogin` datetime DEFAULT NULL,
  PRIMARY KEY (`StaffID`),
  KEY `FK_Department_Staff` (`DepartmentID`),
  KEY `FK_Roles_Staff` (`RoleID`),
  CONSTRAINT `FK_Department_Staff` FOREIGN KEY (`DepartmentID`) REFERENCES `Department` (`DepartmentID`),
  CONSTRAINT `FK_Roles_Staff` FOREIGN KEY (`RoleID`) REFERENCES `Roles` (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table SubCategory
# ------------------------------------------------------------

DROP TABLE IF EXISTS `SubCategory`;

CREATE TABLE `SubCategory` (
  `SubCategoryID` int(11) NOT NULL AUTO_INCREMENT,
  `SubCategoryName` varchar(30) DEFAULT NULL,
  `SubCategoryDescription` varchar(500) DEFAULT NULL,
  `CategoryID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SubCategoryID`),
  KEY `FK_Category_SubCategory` (`CategoryID`),
  CONSTRAINT `FK_Category_SubCategory` FOREIGN KEY (`CategoryID`) REFERENCES `Category` (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Supplier
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Supplier`;

CREATE TABLE `Supplier` (
  `SupplierID` int(11) NOT NULL AUTO_INCREMENT,
  `SupplierName` varchar(30) DEFAULT NULL,
  `SupplierTel` varchar(20) DEFAULT NULL,
  `SupplierEmail` varchar(30) DEFAULT NULL,
  `SupplierAddress` varchar(50) DEFAULT NULL,
  `SupplierCity` varchar(20) DEFAULT NULL,
  `SupplierCountry` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SupplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
