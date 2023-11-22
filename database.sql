-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: htdttt_doan_benh
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `benh`
--

DROP TABLE IF EXISTS `benh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benh` (
  `cach_dieu_tri` varchar(1000) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `loi_khuyen` varchar(1000) DEFAULT NULL,
  `nguyen_nhan` varchar(1000) DEFAULT NULL,
  `ten_benh` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benh`
--

LOCK TABLES `benh` WRITE;
/*!40000 ALTER TABLE `benh` DISABLE KEYS */;
INSERT INTO `benh` VALUES ('Theo dõi nhiệt độ của trẻ: khi thân nhiệt của trẻ đo ở nách trên 38,5 độ C thì cho bé dùng thuốc hạ sốt (liều paracetamol 10-15 mg/kg/lần, cách 4h-6h/lần, không quá 60 mg/kg/ngày)- Cho trẻ uống thuốc tr...','D1','Tiêm phòng vắc xin cúm hàng năm- Đeo khẩu trang, tăng cường rửa tay, vệ sinh hô hấp khi ho khạc- Tránh tập trung đông người khi dịch xảy ra- Giữ ấm cơ thể khi thời tiết thay đổi ','Do thời tiết thay đổi từ nóng sang lạnh, độ ẩm không khí thấp đột ngột. Cơ thể không thích ứng kịp thời khiến cho sự xâm nhập của vi rút cúm tạo điều kiện thuận lợi mắc bệnh cúm.','Cảm cúm'),('Điều trị bằng thuốc, lưu ý không được sử dụng thuốc kháng sinh- Chăm sóc trẻ đúng cách: bổ sung đủ nước và chất điện giải; thường xuyên vệ sinh mũi họng bằng nước mũi sinh lý đúng cách; cho trẻ ăn uống đủ chất, thức ăn dạng lỏng dễ tiêu hóa; bổ sung vitamin tự nhiên cho trẻ bằng trái cây; không tắm nước lạnh ','D2','Tập cho trẻ thói quen thường xuyên rửa tay với xà phòng và nước sạch trong ít nhất 20 giây hoặc rửa tay với dung dịch khử khuẩn có chứa ít nhất 60% cồn. - Hạn chế cho trẻ chạm tay vào mắt, mũi, miệng, nhất là khi tay bẩn.- Thường xuyên dọn dẹp, khử khuẩn không gian sống nhất là các bề mặt thường xuyên chạm vào như tay nắm cửa, công tắc đèn, mặt bàn,…- Hướng dẫn trẻ dùng khăn giấy che miệng khi ho, hắt hơi, xì mũi, sau đó vứt khăn giấy đã dùng vào thùng rác và rửa tay lại với xà phòng.- Không cho trẻ dùng chung các vật dụng cá nhân với người khác như ly uống nước, thìa, đồ chơi,- Đeo khẩu trang cho trẻ khi đến những nơi công cộng, đông người.- Thực hiện chế độ dinh dưỡng đủ chất, phù hợp với lứa tuổi cho trẻ.','Thời điểm giao mùa, thời tiết thay đổi đột ngột, là một trong những nguyên nhân dẫn đến bệnh cảm lạnh.- Bé tiếp xúc trực tiếp với nguồn bệnh khi chạm vào người nhiễm bệnh hoặc các đồ vật, đồ chơi có virus.','Cảm lạnh'),('Sử dụng thuốc: Thuốc cắt cơn hen, Thuốc kiểm soát cơn hen- Bổ sung các thực phẩm giàu magie, omega 3, vitamin C, vitamin E, mật ong ','D3','Tránh cho trẻ tiếp xúc với các loại khói, bụi như: bếp than, bếp củi, khói thuốc lá, thuốc lào. - Không để vật nuôi chó mèo trong nhà, lông/ len trải thảm vì trẻ dễ hít các loại lông sẽ phát sinh ra cơn hen.- Cần chú ý các loại thức ăn có thành phần dễ gây dị ứng cho trẻ, đặc biệt chú ý các đồ hải sản như tôm, cua, ghẹ, ốc dễ gây dị ứng và phát sinh cơn hen.- Không để trẻ chơi đùa, nghịch ngợm quá sức trong thời gian điều trị dự phòng hen phế quản.- Giữ ấm cho trẻ khi mùa lạnh, tắm nước ấm và tắm nhanh.- Tập cho trẻ thói quen ăn đa dạng rau củ quả, đặc biệt là táo và rau tươi để tăng sức đề kháng trong đó có phòng và hỗ trợ chữa hen.','Các dị nguyên hô hấp: khói bụi,lông súc vật,phấn hoa,hoá chất, mỹ phẩm,chất có mùi tanh, khí lạnh- Các dị nguyên thức ăn: đặc biệt các thức ăn có nguồn gốc động vật: trứng, tôm, cua,cá,..- Các yếu tố nhiễm khuẩn: Viêm phế quản,viêm phổi tái phát,viêm đường hô hấp do virus…','Hen phế quản'),('Vệ sinh mũi cho trẻ: dùng nước muối sinh lý NaCl 0.9% để nhỏ mũi làm sạch cho trẻ nhiều lần mỗi ngày.- Giữ ấm cơ thể cho trẻ, tránh để viêm phế quản tiến triển sang viêm phổi, cho trẻ uống nước ấm.- Chườm ấm toàn thân để hạ sốt cho trẻ, theo dõi nhiệt độ cơ thể trẻ thường xuyên, đặc biệt là ban đêm. Khi trẻ sốt cao trên 38.5 độ C, uống thuốc hạ sốt paracetamol là cần thiết, cần uống theo sự chỉ dẫn của bác sĩ với liều lượng phù hợp.- Không tự ý sử dụng thuốc kháng sinh: Viêm phế quản ở trẻ nếu do virus gây ra thì kháng sinh không có hiệu quả điều trị tiêu diệt bệnh. Cha mẹ không tự ý cho trẻ sử dụng kháng sinh vì có thể dẫn tới nhiều hệ lụy sức khỏe sau này.- Cho trẻ uống nhiều nước: Uống đủ nước vừa giúp hạ sốt, vừa làm giảm tình trạng tắc nghẽn đường hô hấp. Trẻ có thể ho dễ dàng và tống đờm ra ngoài, giảm triệu chứng khó chịu hơn.','D4','Giữ ấm cho trẻ, giữ cho môi trường sống của trẻ sạch sẽ bằng cách thường xuyên lau chùi nhà cửa, thay chăn nệm sạch sẽ.- Với trẻ đã bị dị ứng với phấn hoa, lông chó mèo, mạt bụi nhà,..., cần hạn chế tiếp xúc với các tác nhân trên. Hạn chế cho trẻ tiếp xúc với khói bụi, khói thuốc lá,...- Chủ động cách ly với người lớn hoặc trẻ nhỏ khác đang mắc bệnh đường hô hấp.- Tiêm vaccine phòng bệnh cho trẻ như vaccine phế cầu, vaccine Haemophilus influenza,...','Tác nhân gây ra viêm phế quản ở trẻ em thường gặp nhất là do virus- Các yếu tố khiến trẻ bị viêm phế quản tái phát nhiều lần gồm cơ địa dị ứng, trào ngược dạ dày thực quản, bệnh xơ nang, suy giảm miễn dịch, môi trường sống có nhiều khói bụi…','Viêm phế quản'),('Khuyến khích trẻ nghỉ ngơi hoặc ngủ nhiều hơn bình thường- Cho trẻ uống nhiều nước để giữ ấm cho cổ họng và ngăn ngừa tình trạng mất nước- Cho trả súc miệng bằng nước muối ấm- Có thể ngậm viên ngậm để giảm đau họng- Hạ sốt khi trẻ có biểu hiện sốt cao trên 38.5 độ C- Sử dụng máy tạo độ ẩm không khí để loại bỏ không khí khô có thể gây kích ứng thêm cho cơn đau','D5','Rửa tay thường xuyên- Thường xuyên vệ sinh nhà cửa, đồ chơi của trẻ- Không dùng chung đồ ăn, đồ uống, đồ dùng hoặc vật dụng các nhân- Tiêm phòng vacxin cho trẻ đầy đủ- Tránh hút thuốc và hút thuốc thụ động- Tránh tiếp xúc gần với những người có triệu chứng viêm amidan nói riêng hoặc các bệnh viêm đường hô hấp nói chung','Amidan được chia làm 2 nhóm chính do vi khuẩn hoặc virus. Trong đó, phần lớn các trường hợp viêm amidan là do virus gây ra. còn lại khoảng 5-40% được cho là do vi khuẩn.Thông thường, một số điều kiện thuận lợi gây ra tình trạng viêm amidan như:- Yếu tố vệ sinh: Sử dụng thực phẩm không đảm bảo, khoang miệng không được vệ sinh sạch sẽ thường xuyên- Môi trường ô nhiễm- Thời tiết thay đổi đột ngột - Có dị tật ở cổ họng hay amidan','Viêm amidan'),('Uống nhiều nước ấm: đây là cách để giữ ấm họng, làm dịu cơn đau do viêm họng- Làm mát cổ họng: dùng khăn mát để cổ họng được xoa dịu- Súc miệng bằng nước muối sin lý- Thuốc xịt họng- Cho trẻ ăn những thức ăn mềm','D6','Hướng dẫn trẻ thực hành vệ sinh tay tốt.- Tránh xa những người bị viêm họng, cảm lạnh hoặc các bệnh nhiễm trùng đường hô hấp trên khác.- Giữ trẻ bạn tránh xa khói thuốc.- Tiêm chủng vaccine đầy đủ cho trẻ theo đúng lịch.','Sự tấn công của virus, vi khuẩn.- Viêm họng do kích thích: căn nguyên từ hiện tượng khô khốc ở vùng họng, ho sặc làm tổn thương và kích thích niêm mạc họng.- Mắc dị vật ở vùng họng như: mảnh đồ chơi, hạt trái cây, xương cá,...- Nuốt phải hóa chất có hại.- Rối loạn hệ miễn dịch do mắc bệnh hệ thống (hiếm gặp).','Viêm họng');
/*!40000 ALTER TABLE `benh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luat`
--

DROP TABLE IF EXISTS `luat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luat` (
  `trang_thai` bit(1) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luat`
--

LOCK TABLES `luat` WRITE;
/*!40000 ALTER TABLE `luat` DISABLE KEYS */;
INSERT INTO `luat` VALUES (_binary '','R01'),(_binary '','R02'),(_binary '','R03'),(_binary '','R04'),(_binary '','R05'),(_binary '','R06'),(_binary '','R07'),(_binary '','R08'),(_binary '','R09'),(_binary '','R10'),(_binary '','R11'),(_binary '','R12'),(_binary '','R13'),(_binary '','R14'),(_binary '','R15'),(_binary '','R16'),(_binary '','R17'),(_binary '\0','R18'),(_binary '\0','R19'),(_binary '\0','R20'),(_binary '\0','R21'),(_binary '\0','R22'),(_binary '\0','R23'),(_binary '\0','R24'),(_binary '\0','R25'),(_binary '\0','R26'),(_binary '\0','R27'),(_binary '\0','R28'),(_binary '\0','R29'),(_binary '\0','R30'),(_binary '\0','R31'),(_binary '\0','R32');
/*!40000 ALTER TABLE `luat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suy_dien`
--

DROP TABLE IF EXISTS `suy_dien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suy_dien` (
  `benh_id` varchar(255) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `luat_id` varchar(255) DEFAULT NULL,
  `trieu_chung_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiiumgi7j1a4xaxgjramk5t8tu` (`benh_id`),
  KEY `FKby12kiocnhi7muffbh87iahq4` (`luat_id`),
  KEY `FKchqbpe9p325kfdfelqx2i6aem` (`trieu_chung_id`),
  CONSTRAINT `FKby12kiocnhi7muffbh87iahq4` FOREIGN KEY (`luat_id`) REFERENCES `luat` (`id`),
  CONSTRAINT `FKchqbpe9p325kfdfelqx2i6aem` FOREIGN KEY (`trieu_chung_id`) REFERENCES `trieu_chung` (`id`),
  CONSTRAINT `FKiiumgi7j1a4xaxgjramk5t8tu` FOREIGN KEY (`benh_id`) REFERENCES `benh` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suy_dien`
--

LOCK TABLES `suy_dien` WRITE;
/*!40000 ALTER TABLE `suy_dien` DISABLE KEYS */;
INSERT INTO `suy_dien` VALUES ('D1',1,'R01','S01'),('D4',2,'R01','S01'),('D6',3,'R01','S01'),('D2',4,'R02','S02'),('D5',5,'R02','S02'),('D3',6,'R03','S03'),('D4',7,'R04','S04'),('D6',8,'R04','S04'),('D1',9,'R05','S05'),('D2',10,'R05','S05'),('D3',11,'R05','S05'),('D4',12,'R05','S05'),('D5',13,'R05','S05'),('D6',14,'R05','S05'),('D1',15,'R06','S06'),('D2',16,'R06','S06'),('D4',17,'R06','S06'),('D5',18,'R07','S07'),('D6',19,'R07','S07'),('D3',20,'R08','S08'),('D4',21,'R08','S08'),('D3',22,'R09','S09'),('D4',23,'R09','S09'),('D1',24,'R10','S10'),('D2',25,'R10','S10'),('D3',26,'R10','S10'),('D5',27,'R11','S11'),('D6',28,'R12','S12'),('D6',29,'R13','S13'),('D1',30,'R14','S14'),('D2',31,'R14','S14'),('D3',32,'R15','S15'),('D5',33,'R16','S16'),('D5',34,'R17','S17'),('D1',35,'R18','S01'),('D1',36,'R18','S05'),('D1',37,'R18','S06'),('D1',38,'R18','S10'),('D1',39,'R19','S01'),('D1',40,'R19','S05'),('D1',41,'R19','S06'),('D1',42,'R19','S14'),('D2',43,'R20','S02'),('D2',44,'R20','S05'),('D2',45,'R20','S06'),('D2',46,'R20','S10'),('D2',47,'R21','S02'),('D2',48,'R21','S05'),('D2',49,'R21','S06'),('D2',50,'R21','S14'),('D3',51,'R22','S03'),('D3',52,'R22','S05'),('D3',53,'R22','S08'),('D3',54,'R22','S09'),('D3',55,'R23','S03'),('D3',56,'R23','S05'),('D3',57,'R23','S08'),('D3',58,'R23','S10'),('D3',59,'R24','S03'),('D3',60,'R24','S05'),('D3',61,'R24','S09'),('D3',62,'R24','S15'),('D4',63,'R25','S01'),('D4',64,'R25','S04'),('D4',65,'R25','S05'),('D4',66,'R25','S06'),('D4',67,'R26','S01'),('D4',68,'R26','S05'),('D4',69,'R26','S08'),('D4',70,'R26','S09'),('D5',71,'R27','S02'),('D5',72,'R27','S05'),('D5',73,'R27','S06'),('D5',74,'R27','S11'),('D5',75,'R28','S02'),('D5',76,'R28','S05'),('D5',77,'R28','S07'),('D5',78,'R28','S16'),('D5',79,'R29','S02'),('D5',80,'R29','S05'),('D5',81,'R29','S16'),('D5',82,'R29','S17'),('D6',83,'R30','S01'),('D6',84,'R30','S04'),('D6',85,'R30','S05'),('D6',86,'R30','S07'),('D6',87,'R31','S01'),('D6',88,'R31','S04'),('D6',89,'R31','S07'),('D6',90,'R31','S12'),('D6',91,'R32','S01'),('D6',92,'R32','S04'),('D6',93,'R32','S12'),('D6',94,'R32','S13');
/*!40000 ALTER TABLE `suy_dien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trieu_chung`
--

DROP TABLE IF EXISTS `trieu_chung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trieu_chung` (
  `id` varchar(255) NOT NULL,
  `trieu_chung` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trieu_chung`
--

LOCK TABLES `trieu_chung` WRITE;
/*!40000 ALTER TABLE `trieu_chung` DISABLE KEYS */;
INSERT INTO `trieu_chung` VALUES ('S01','Sốt cao kéo dài, sốt đột ngột'),('S02','Sốt nhẹ'),('S03','Ho kéo dài, lâu ngày, ho nhiều về đêm'),('S04','Ho khan hay ho có đờm'),('S05','Nghẹt mũi, chảy nước mũi'),('S06','Nhức đầu, đau cơ'),('S07','Ngứa cổ, Đau rát họng'),('S08','Khó thở, thở khò khè'),('S09','Thở nhanh, thở gấp'),('S10','Mệt mỏi, chán ăn'),('S11','Ù tai, đau nhức trong tai'),('S12','Soi cổ thấy sưng đỏ'),('S13','Nổi hạch ở cổ, bên cạnh hàm'),('S14','Buồn nôn, tiêu chảy'),('S15','Cơ thể tím tái, ra nhiều mồ hôi'),('S16','Đau vướng khi nuốt nước bọt'),('S17','Amidan bị sưng to tấy đỏ');
/*!40000 ALTER TABLE `trieu_chung` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-23  5:09:36
