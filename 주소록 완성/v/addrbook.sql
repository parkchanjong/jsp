CREATE TABLE addrbook (
  ab_id int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ab_name varchar(8) NOT NULL,
  ab_email varchar(20) DEFAULT NULL,
  ab_comdept varchar(20) NOT NULL,
  ab_birth varchar(10) NOT NULL,
  ab_tel varchar(15) DEFAULT NULL,
  ab_memo varchar(30) DEFAULT NULL
);