CREATE TABLE img (
	img_id VARCHAR(30) PRIMARY KEY,
	img_name VARCHAR(30) NOT NULL,
	img_filename VARCHAR(30) NOT NULL,
	img_sizekb INT NOT NULL,
	img_time DATE,
	img_type_id INT,
	img_fileup_table_id INT,
	img_filedown_table_id INT,
	admin_id INT
);

CREATE TABLE img_type (
	img_type_id INT AUTO_INCREMENT PRIMARY KEY,
	img_type_name VARCHAR(20) NOT NULL,
	img_type_note VARCHAR(50)
);

CREATE TABLE img_fileup (
	img_fileup_id INT AUTO_INCREMENT PRIMARY KEY,
	img_fileup_time DATETIME NOT NULL,
	admin_id INT
);

CREATE TABLE img_fileup_table (
	img_fileup_table_id INT AUTO_INCREMENT PRIMARY KEY,
	img_fileup_id INT,
	img_id VARCHAR(30)
);

CREATE TABLE img_filedown (
	img_filedown_id INT AUTO_INCREMENT PRIMARY KEY,
	img_filedown_time DATETIME NOT NULL,
	user_id VARCHAR(30)
);

CREATE TABLE img_filedown_table (
	img_filedown_table_id INT AUTO_INCREMENT PRIMARY KEY,
	img_filedown_id INT,
	img_id VARCHAR(30)
);

CREATE TABLE authority_admin(
	authority_admin_id INT AUTO_INCREMENT PRIMARY KEY,
	admin_action_id INT NOT NULL,
	authority_url_id INT NOT NULL,
	authority_note VARCHAR(30)
	);
	
CREATE TABLE authority_url(
	authority_url_id INT AUTO_INCREMENT PRIMARY KEY,
	authority_url VARCHAR(30) NOT NULL,
	authority_note VARCHAR(30)
	);
