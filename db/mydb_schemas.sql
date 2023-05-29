-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
drop database mydb;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category` (
  `categoryID` INT NOT NULL,
  `categoryName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`categoryID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`announcement`
-- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `mydb`.`announcement` (
--   `announcementId` INT NOT NULL AUTO_INCREMENT,
--   `announcementTitle` VARCHAR(200) NOT NULL,
--   `announcementDescription` MEDIUMTEXT NOT NULL,
--   `categoryId` INT NOT NULL,
--   `publishDate` DATETIME NULL DEFAULT NULL,
--   `closeDate` DATETIME NULL DEFAULT NULL,
--   `announcementDisplay` ENUM('Y', 'N') NULL DEFAULT 'N',
--   PRIMARY KEY (`announcementId`, `categoryId`),
--   INDEX `fk_categoryId_idx` (`categoryId` ASC) VISIBLE,
--   CONSTRAINT `fk_categoryId`
--     FOREIGN KEY (`categoryId`)
--     REFERENCES `mydb`.`category` (`categoryID`))
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8mb3;
CREATE TABLE IF NOT EXISTS `mydb`.`announcement` (
  `announcementId` INT NOT NULL AUTO_INCREMENT,
  `announcementTitle` VARCHAR(200) NOT NULL,
  `announcementDescription` VARCHAR(10000) NOT NULL,
  `announcementCategory` INT NOT NULL,
  `publishDate` DATETIME NULL DEFAULT NULL,
  `closeDate` DATETIME NULL DEFAULT NULL,
  `announcementDisplay` ENUM('Y', 'N') NULL DEFAULT 'N',
  PRIMARY KEY (`announcementId`, `announcementCategory`),
  INDEX `fk_announcement_category_idx` (`announcementCategory` ASC) VISIBLE,
  CONSTRAINT `fk_announcement_category`
    FOREIGN KEY (`announcementCategory`)
    REFERENCES `mydb`.`category` (`categoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into category values
(1,'ทั่วไป'),(2,'ทุนการศึกษา'),(3,'หางาน'),(4,'ฝึกงาน')
;




-- date bangkok
insert into announcement (announcementTitle,announcementDescription,announcementCategory,publishDate,closeDate,announcementDisplay)values 
('บริษัท เน็ตเซอร์พลัส จํากัด รับสมัครงาน 2 ตําแหน่ง','บริษัท เน็ตเซอร์พลัส จํากัด เปิดรับสมังาน 2 ตําแหน่ง Application Support และ Customer Support',2,null,null,'N'),
('รายชื่อนักศึกษาที่ได้รับทุนการศึกษาประเภท "ทุนจ้างงาน" 2/2565','คณะ ฯ ประกาศรายชื่อนักศึกษาที่ได้รับทุนการศึกษาประเภท "ทุนจ้างงาน" ประจำภาคการศึกษา 2/2565',3,null,'2023-05-31 18:00:00+07:00','Y'),
('แนวปฎิบัติการสอบออนไลน์ พ.ศ. 2565','ประกาศมหาวิทยาลัยเทคโนโลยีพระจอมเกล้าธนบุรี เรื่องแนวทางปฎิบัติการสอบออนไลน์ พ.ศ. 2565',1,'2023-01-27 06:00:00+07:00',null,'Y'),
('กิจกรรมพี่อ้อย พี่ฉอด On Tour 2566','ขอเชิญนักศึกษาทุกชั้นปี เข้าร่วมกิจกรรมพี่อ้อย พี่ฉอด On Tour',1,'2023-04-19 06:00:00+07:00','2023-05-08 18:00:00+07:00','Y')
;



use mydb;

SET SQL_SAFE_UPDATES = 0;
select * from announcement;
