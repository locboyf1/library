/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `qltv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qltv`;

CREATE TABLE IF NOT EXISTS `tbl_doc_gia` (
  `ma_doc_gia` int NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(10) DEFAULT NULL,
  `lop` varchar(50) DEFAULT NULL,
  `ngay_dang_ky` date DEFAULT NULL,
  `sodt` varchar(20) DEFAULT NULL,
  `ten_doc_gia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ma_doc_gia`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tbl_doc_gia` (`ma_doc_gia`, `dia_chi`, `gioi_tinh`, `lop`, `ngay_dang_ky`, `sodt`, `ten_doc_gia`) VALUES
	(2, 'Đường Quốc Lộ 46', 'Nữ', '63K2', '2025-10-22', '012345678', 'Kim Danh 123'),
	(3, 'Vô gia cư', 'Nam', '63k10', '2025-10-22', '1234567', 'Kim Danh'),
	(4, 'Hàn Quắc', 'Nữ', '321321', '2025-10-22', '123123', 'Kim Don ...');

CREATE TABLE IF NOT EXISTS `tbl_nhan_vien` (
  `ma_nhan_vien` int NOT NULL AUTO_INCREMENT,
  `chuc_vu` varchar(50) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(10) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `sodt` varchar(20) DEFAULT NULL,
  `ten_nhan_vien` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ma_nhan_vien`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tbl_nhan_vien` (`ma_nhan_vien`, `chuc_vu`, `dia_chi`, `gioi_tinh`, `ngay_sinh`, `sodt`, `ten_nhan_vien`) VALUES
	(1, 'Vip Pro', 'Trên nóc nhà', 'Nam', NULL, '01234567', 'Kim Danh 321'),
	(2, 'Vip pro', 'Người trời', 'Nữ', NULL, '0123132', 'KD123');

CREATE TABLE IF NOT EXISTS `tbl_tai_khoan` (
  `ten_dang_nhap` varchar(50) NOT NULL,
  `loai_tai_khoan` varchar(20) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `ma_doc_gia` int DEFAULT NULL,
  `ma_nhan_vien` int DEFAULT NULL,
  PRIMARY KEY (`ten_dang_nhap`),
  UNIQUE KEY `UK22i1j0ahjweu9i24orjemaou3` (`ma_doc_gia`),
  UNIQUE KEY `UK9lgbn2s493gh5v4thjjseswxc` (`ma_nhan_vien`),
  CONSTRAINT `FK3fcpwc97c44i957l050dy32gf` FOREIGN KEY (`ma_doc_gia`) REFERENCES `tbl_doc_gia` (`ma_doc_gia`),
  CONSTRAINT `FK6u2x527jr3uocgv3x3e9gv5ht` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `tbl_nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tbl_tai_khoan` (`ten_dang_nhap`, `loai_tai_khoan`, `mat_khau`, `ma_doc_gia`, `ma_nhan_vien`) VALUES
	('kimdanh1', 'nhanvien', '$2a$10$0i37N20/.UgkLW5Gp2ctv.q6XBdaX2nZQwLFYXhgnwt7zsHTrpS2G', NULL, 2),
	('kimdanh2', 'docgia', '$2a$10$j8wHG0VzmWKQfz9e6q2/lecYq5M3VCWzAly1jIu5bX.h48rWvz6fO', 4, NULL),
	('kimdanhancot', 'docgia', '$2a$10$/1DcijpcWb2O4oQbZjlpyuZDKAfu179EoQaYYoQCMaKxUWgMrHc26', 2, NULL),
	('kimdanhancot2', 'nhanvien', '$2a$10$Lgpa1iJ70NNiWcnSLQOs5uMLdIJ7fChrFPDlg6AY23CURqVs3nEXm', NULL, 1),
	('kimdanhancot3', 'docgia', '$2a$10$iLaZJEgHtGw9yAQ.cvEjgufcCmysCwmAvs1T2hVllwDrd2gQtGUfy', 3, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
