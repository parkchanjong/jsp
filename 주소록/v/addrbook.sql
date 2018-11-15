CREATE TABLE addrbook (
  ab_id int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ab_name varchar(8) NOT NULL,
  ab_email varchar(20) DEFAULT NULL,
  ab_comdept varchar(20) NOT NULL,
  ab_birth varchar(10) NOT NULL,
  ab_tel varchar(15) DEFAULT NULL,
  ab_memo varchar(30) DEFAULT NULL
);

insert into addrbook(ab_name, ab_email, ab_comdept, ab_birth, ab_tel, ab_memo) values();

insert into addrbook(ab_name, ab_email, ab_comdept, ab_birth, ab_tel, ab_memo) 
values('김기찬','test@test.net','삼전주식회사','2010-10-10','010-1111-2222','친구아님');

select * from addrbook;