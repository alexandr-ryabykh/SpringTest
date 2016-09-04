CREATE TABLE `phonebook`.contact (
id INT NOT NULL AUTO_INCREMENT, 
firstName VARCHAR(50) default null,
lastName VARCHAR(50) default null,
telephone INT default null, 
address VARCHAR(100) default null,
email VARCHAR(50) default null,
PRIMARY KEY (id)
);
