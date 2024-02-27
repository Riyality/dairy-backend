
DROP SCHEMA IF EXISTS `dairy`;
CREATE DATABASE `dairy` ;
use `dairy`;

CREATE TABLE `branch` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL,
  `address` VARCHAR(128) NULL,
  `owner` VARCHAR(32) NOT NULL,
  `start_date` TIMESTAMP NULL,
  `owner_contact`VARCHAR(16) NOT NULL,
   `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));
  
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(25) NOT NULL,
  `role`  VARCHAR(32) NOT NULL,
  `name` VARCHAR(32) NOT NULL,
   `branch` INT,
   `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`branch`) REFERENCES `branch`(`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);

CREATE TABLE `dairy`.`bank_details` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bank_name` VARCHAR(45) NOT NULL,
  `IFSC_code` VARCHAR(32) NULL,
  `branch_name` VARCHAR(45) NULL,
  `account_number` VARCHAR(45) NOT NULL,
  `UPI_id` VARCHAR(45) NULL,
   `branch` INT,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
   FOREIGN KEY (`branch`) REFERENCES `branch`(`id`)
  );

  
CREATE TABLE `employee` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL,
  `contact` VARCHAR(16) NOT NULL,
  `address` VARCHAR(64)NOT NULL,
  `date_of_joining` TIMESTAMP NULL,
   branch INT NOT NULL,
   bank BIGINT NULL,
    `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (bank) REFERENCES bank_details(id),
   FOREIGN KEY (branch) REFERENCES branch(id),
  PRIMARY KEY (`id`));
  
  CREATE TABLE `dairy`.`equipment` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `date_of_purchase` TIMESTAMP NULL,
  `quantity` INT NULL,
  `price` FLOAT NULL,
   `total_amount` FLOAT NULL,
   `branch` INT,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`branch`) REFERENCES `branch`(`id`)
  );

  CREATE TABLE `dairy`.`vendor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NULL,
  `contact` VARCHAR(16) NULL,
  `date_of_registration` TIMESTAMP NULL,
  `address` VARCHAR(64) NULL,
   bank BIGINT NULL,
   `branch` INT,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (`branch`) REFERENCES `branch`(`id`),
   FOREIGN KEY (bank) REFERENCES bank_details(id),
  PRIMARY KEY (`id`));
  
  CREATE TABLE `dairy`.`feed_company` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NULL,
    `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `dairy`.`feed_types` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(32) NOT NULL,
   feed_company BIGINT NULL,
   `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (feed_company) REFERENCES feed_company(id),
  PRIMARY KEY (`id`));
  
  
  CREATE TABLE `dairy`.`feed_stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_of_purchase` TIMESTAMP NULL,
  `feed_cost_per_unit` FLOAT NULL,
  `quantity` INT NULL,
  `total_amount` FLOAT NULL,
  vendor BIGINT NULL,
  feed_company BIGINT NULL,
  feed_type BIGINT NULL,
  `branch` INT,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (`vendor`) REFERENCES `vendor`(`id`),
  FOREIGN KEY (`feed_company`) REFERENCES `feed_company`(`id`),
  FOREIGN KEY (`feed_type`) REFERENCES `feed_types`(`id`),
  FOREIGN KEY (`branch`) REFERENCES `branch`(`id`)
  PRIMARY KEY (`id`));


CREATE TABLE `dairy`.`farmers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL,
  `date_of_registration` TIMESTAMP NULL,
  `contact` VARCHAR(16) NOT NULL,
  `route` BIGINT(64) NOT NULL,
  `address` VARCHAR(64) NULL,
  `status` VARCHAR(32) NULL,
   bank BIGINT NULL,
   branch INT NOT NULL,
   `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`bank`) REFERENCES `bank_details`(`id`),
  FOREIGN KEY (`branch`) REFERENCES `branch`(`id`)
);

  
  CREATE TABLE `dairy`.`farmer_animal_mapping` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `count` INT NULL,
  `status` VARCHAR(45) NULL,
  `farmer` BIGINT,
    `branch` INT,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`farmer`) REFERENCES `farmers`(`id`),
  FOREIGN KEY (`branch`) REFERENCES `branch`(`id`)
);
  
  CREATE TABLE `dairy`.`milk_collection` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `date_of_collection` TIMESTAMP NULL,
  `shift` VARCHAR(32) NULL,
  `type` VARCHAR(32) NOT NULL,
  `quantity` FLOAT NULL,
  `fat` FLOAT NULL,
  `snf` FLOAT NULL,
  `rate` FLOAT NULL,
  `total_amount` FLOAT NULL,
  `farmer` BIGINT,
    `branch` INT,
`payment_status` VARCHAR(32),
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`farmer`) REFERENCES `farmers`(`id`),
  FOREIGN KEY (`branch`) REFERENCES `branch`(`id`)
);
  
  CREATE TABLE `dairy`.`milk_rate` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `date_of_rate` TIMESTAMP NULL,
  `fat` FLOAT ZEROFILL NULL,
  `snf` FLOAT NULL,
  `rate` FLOAT NULL,
  created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

   CREATE TABLE `advance_to_farmer` (
	  `id` bigint NOT NULL AUTO_INCREMENT,
	  `date_of_advance` timestamp NULL DEFAULT NULL,
	  `amount` float DEFAULT NULL,
	  `remaining_amount` float DEFAULT NULL,
	  `farmer` bigint DEFAULT NULL,
	  `branch` int DEFAULT NULL,
	  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	  `updated_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	  PRIMARY KEY (`id`),
	  KEY `farmer` (`farmer`),
	  KEY `branch` (`branch`),
	  CONSTRAINT `advance_to_farmer_ibfk_1` FOREIGN KEY (`farmer`) REFERENCES `farmers` (`id`),
	  CONSTRAINT `advance_to_farmer_ibfk_2` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`)
	)

  
 CREATE TABLE `feed_to_farmer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_of_purchase` timestamp NULL DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `feed_rate` float DEFAULT NULL,
  `total_amount` float NOT NULL,
  `paid_amount` float DEFAULT NULL,
  `remaining_amount` float DEFAULT NULL,
  `remark` varchar(45) DEFAULT NULL,
  `farmer` bigint DEFAULT NULL,
  `branch` int DEFAULT NULL,
  `feed_company` bigint DEFAULT NULL,
  `feed_type` bigint DEFAULT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `farmer` (`farmer`),
  KEY `branch` (`branch`),
  KEY `feed_company` (`feed_company`),
  KEY `feed_type` (`feed_type`),
  CONSTRAINT `feed_to_farmer_ibfk_1` FOREIGN KEY (`farmer`) REFERENCES `farmers` (`id`),
  CONSTRAINT `feed_to_farmer_ibfk_2` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `feed_to_farmer_ibfk_3` FOREIGN KEY (`feed_company`) REFERENCES `feed_company` (`id`),
  CONSTRAINT `feed_to_farmer_ibfk_4` FOREIGN KEY (`feed_type`) REFERENCES `feed_types` (`id`)
)

CREATE TABLE `payment_to_farmer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `invoice_date` timestamp NULL DEFAULT NULL,
  `from_date` timestamp NULL DEFAULT NULL,
  `to_date` timestamp NULL DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `farmer` bigint DEFAULT NULL,
  `branch` int DEFAULT NULL,
  `total_collected_milk` double DEFAULT NULL,
  `milktype` varchar(45) DEFAULT NULL,
  `feed_deduction` double DEFAULT NULL,
  `advance_deduction` double DEFAULT NULL,
  `payment_method` varchar(45) DEFAULT NULL,
  `payment_note` varchar(45) DEFAULT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `farmer` (`farmer`),
  KEY `branch` (`branch`),
  CONSTRAINT `payment_to_farmer_ibfk_1` FOREIGN KEY (`farmer`) REFERENCES `farmers` (`id`),
  CONSTRAINT `payment_to_farmer_ibfk_2` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`)
)

CREATE TABLE `dairy`.`route` (
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `remark` TEXT,
    `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `branch` INT,
    FOREIGN KEY (`branch`) REFERENCES `branch`(`id`)
);

CREATE TABLE `bonus_of_farmer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `from_date` date NULL  NULL,
  `to_date` date NULL  NULL,
 `total_quntity` float Null,
 `bonus_amount_per_liter` float  NULL,
 `total_bonus_amount` float  NULL,
  `milk_Type` varchar(45) DEFAULT NULL,
  `farmer` bigint  NULL,
  `branch` int  NULL,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
 FOREIGN KEY (`farmer`) REFERENCES `farmers` (`id`),
 FOREIGN KEY (`branch`) REFERENCES `branch` (`id`)
) 


  


CREATE TABLE `dairy`.`main_branch` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(32) NULL,
  `date_of_collection` TIMESTAMP NULL,
  `shift` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `quantity` FLOAT NULL,
  `fat` FLOAT NULL,
  `snf` FLOAT NULL,
  `protein` FLOAT NULL,
  `rate` FLOAT NULL,
  `total_amount` FLOAT NULL,
  `remark` TEXT,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

CREATE TABLE `dairy_manger` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) ,
  `person_id` int ,
  `date_transaction` timestamp NULL ,
  `transaction_type` varchar(20) NULL ,
  `contact` varchar(20) NULL,
  `amount` bigint ,
  `remark` varchar(255)  NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `contact_UNIQUE` (`contact`)
);
  
  CREATE TABLE  `dairy_manger_update`(
   `id` BIGINT  NOT NULL AUTO_INCREMENT ,
    `date_transaction` TIMESTAMP NULL,
    `transaction_type` VARCHAR(20)  NULL,
     `balance` bigint,
    `remark` VARCHAR(255),
    `dairy_manger` BIGINT NULL,
    `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (`dairy_manger`) REFERENCES `dairy_manger`(`id`),
    PRIMARY KEY (`id`)
   
);
  

