ALTER TABLE `dairy`.`branch` 
CHANGE COLUMN `name` `name` VARCHAR(32) NOT NULL ,
CHANGE COLUMN `owner_contact` `owner_contact` VARCHAR(16) NOT NULL ;
CHANGE COLUMN `owner` `owner` VARCHAR(32) NOT NULL ;


ALTER TABLE `dairy`.`employee` 
CHANGE COLUMN `contact` `contact` VARCHAR(16) NOT NULL ;
CHANGE COLUMN `address` `address` VARCHAR(64) NULL ,
CHANGE COLUMN `date_of_joining` `date_of_joining` TIMESTAMP NOT NULL ;


ALTER TABLE `dairy`.`farmers` 
CHANGE COLUMN `name` `name` VARCHAR(32) NOT NULL ,
CHANGE COLUMN `contact` `contact` VARCHAR(16) NOT NULL ,
CHANGE COLUMN `route` `route` VARCHAR(64) NOT NULL ;


ALTER TABLE `dairy`.`feed_types` 
CHANGE COLUMN `type` `type` VARCHAR(32) NOT NULL ;


ALTER TABLE `dairy`.`milk_collection` 
CHANGE COLUMN `type` `type` VARCHAR(32) NOT NULL ;

ALTER TABLE `dairy`.`bank_details` 
CHANGE COLUMN `bank_name` `bank_name` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `account_number` `account_number` VARCHAR(45) NOT NULL ;
