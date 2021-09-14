#How to create a function in mysql database

USE `test`;
DROP function IF EXISTS `income_function`;

DELIMITER $$
USE `test`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `income_function`(value INTEGER) RETURNS int(11)
BEGIN
	declare income INT;
    SET income = 0;
    
    label1: while income<=300 do
		SET income = income + value;
	end while label1;
	RETURN income;
END$$

DELIMITER ;