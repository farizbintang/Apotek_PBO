-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2021 at 03:43 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projek_pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_beli`
--

CREATE TABLE `tabel_beli` (
  `kode_beli` varchar(100) NOT NULL,
  `kode_pelanggan` varchar(100) NOT NULL,
  `kode_produk` varchar(100) NOT NULL,
  `jumlah_produk` int(100) NOT NULL,
  `total_harga` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_beli`
--

INSERT INTO `tabel_beli` (`kode_beli`, `kode_pelanggan`, `kode_produk`, `jumlah_produk`, `total_harga`) VALUES
('C001', 'A003', 'B003', 0, 200000),
('C002', 'A001', 'B001', 2, 100000),
('C003', 'A001', 'B004', 2, 20000),
('C005', 'A003', 'B003', 2, 24000),
('C007', 'A001', 'B003', 2, 24000),
('C008', 'A001', 'B001', 1, 5000);

--
-- Triggers `tabel_beli`
--
DELIMITER $$
CREATE TRIGGER `t_stok` AFTER INSERT ON `tabel_beli` FOR EACH ROW BEGIN
	UPDATE tabel_produk SET stok=stok-new.jumlah_produk 
    WHERE kode_produk=new.kode_produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tabel_pelanggan`
--

CREATE TABLE `tabel_pelanggan` (
  `kode_pelanggan` varchar(100) NOT NULL,
  `nama_pelanggan` varchar(100) NOT NULL,
  `pekerjaan` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_pelanggan`
--

INSERT INTO `tabel_pelanggan` (`kode_pelanggan`, `nama_pelanggan`, `pekerjaan`, `alamat`) VALUES
('A001', 'Budiman', 'PNS', 'Pekanbaru'),
('A002', 'Sarah', 'IRT', 'Rumbai'),
('A003', 'Tati', 'Swasta', 'Palas');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_produk`
--

CREATE TABLE `tabel_produk` (
  `kode_produk` varchar(100) NOT NULL,
  `nama_produk` varchar(100) NOT NULL,
  `jenis_produk` varchar(100) NOT NULL,
  `stok` int(100) NOT NULL,
  `harga_barang` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_produk`
--

INSERT INTO `tabel_produk` (`kode_produk`, `nama_produk`, `jenis_produk`, `stok`, `harga_barang`) VALUES
('B001', 'Panadol', 'Obat Ringan', 8, 5000),
('B003', 'OBQ', 'Obat Ringan', 3, 12000),
('B004', 'Paracetamol', 'Obat Ringan', 3, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_beli`
--
ALTER TABLE `tabel_beli`
  ADD PRIMARY KEY (`kode_beli`),
  ADD KEY `fk_kode_pelanggan` (`kode_pelanggan`),
  ADD KEY `fk_kode_produk` (`kode_produk`);

--
-- Indexes for table `tabel_pelanggan`
--
ALTER TABLE `tabel_pelanggan`
  ADD PRIMARY KEY (`kode_pelanggan`);

--
-- Indexes for table `tabel_produk`
--
ALTER TABLE `tabel_produk`
  ADD PRIMARY KEY (`kode_produk`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tabel_beli`
--
ALTER TABLE `tabel_beli`
  ADD CONSTRAINT `fk_kode_pelanggan` FOREIGN KEY (`kode_pelanggan`) REFERENCES `tabel_pelanggan` (`kode_pelanggan`),
  ADD CONSTRAINT `fk_kode_produk` FOREIGN KEY (`kode_produk`) REFERENCES `tabel_produk` (`kode_produk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
