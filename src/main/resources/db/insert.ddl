INSERT INTO `dairy`.`branch` (`id`, `name`, `address`, `owner`, `start_date`, `owner_contact`) VALUES ('1', 'Ghadge Wasti', 'Thombarewadi', 'Sanjay Ghadge', '2023-11-09 19:12:00', '8080851891');

INSERT INTO `dairy`.`login` (`id`, `username`, `password`, `role`, `name`) VALUES ('1', '8080851891', 'Demo_1234', 'Owner', 'Sanjay Ghadge');

INSERT INTO `dairy`.`employee` (`id`, `name`, `contact`, `address`, `date_of_joining`, `branch`) VALUES ('1', 'Sanjay Ghadge', '8080851891', 'Ghadge wasti', '2023-11-09 01:23:00', '1');

INSERT INTO `dairy`.`farmers` (`id`, `name`, `date_of_registration`, `contact`, `route`, `address`, `status`, `bank`, `branch`) VALUES ('2', 'Sam', '2024-02-013 00:00:00', '8678678678', '1', 'Lotewadi', 'active', '1', '1');

INSERT INTO `dairy`.`bank_details` (`id`, `bank_name`, `IFSC_code`, `branch_name`, `account_number`, `UPI_id`, `branch`, `created_on`, `updated_on`) VALUES ('1', 'SBI', 'SBIN000342', 'sangola', '34567', 'dummy@ybl', '1', '2024-01-12 10:11:36', '2024-01-12 10:11:36');

INSERT INTO `dairy`.`milk_collection` (`id`, `date_of_collection`, `shift`, `type`, `quantity`, `fat`, `snf`, `rate`, `total_amount`, `farmer`, `branch`) VALUES ('1', '2024-02-13', 'evening', 'cow', '22.4', '3', '4', '27', '604.8', '1', '1');
INSERT INTO `dairy`.`milk_collection` (`id`, `date_of_collection`, `shift`, `type`, `quantity`, `fat`, `snf`, `rate`, `total_amount`, `farmer`, `branch`) VALUES ('2', '2024-02-09', 'morning', 'cow', '25.8', '3', '4', '27', '696.6', '2', '1');

INSERT INTO `dairy`.`milk_rate` (`id`, `type`, `date_of_rate`, `fat`, `snf`, `rate`) VALUES ('1', 'cow', '2024-01-09 00:00:00', '3', '4', '27');
INSERT INTO `dairy`.`milk_rate` (`id`, `type`, `date_of_rate`, `fat`, `snf`, `rate`) VALUES ('2', 'cow', '2024-01-09 00:00:00', '4', '5', '31');

