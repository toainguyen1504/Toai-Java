CREATE DATABASE IF NOT EXISTS `shoemanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `shoemanagement`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  `shoesid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `customer` (`id`, `name`, `address`, `phonenumber`, `shoesid`) VALUES
(1, 'Dong Ho Thuy Sy', 'abc', 763383442, 3);

DROP TABLE IF EXISTS `shoes`;
CREATE TABLE `shoes` (
  `shoesid` int(11) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `nameofshoes` varchar(255) NOT NULL,
  `size` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `shoes` (`shoesid`, `brand`, `nameofshoes`, `size`, `quantity`, `price`, `total`) VALUES
(3, 'Adidas', 'Adidas Running', 43, 1, 200000, 200000);


ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `shoesid` (`shoesid`);

ALTER TABLE `shoes`
  ADD PRIMARY KEY (`shoesid`);


ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE `shoes`
  MODIFY `shoesid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;


ALTER TABLE `customer`
  ADD CONSTRAINT `shoesid` FOREIGN KEY (`shoesid`) REFERENCES `shoes` (`shoesid`) ON DELETE CASCADE;