/*=============删除数据库=============*/  
DROP DATABASE IF EXISTS usr;  
/*=============创建数据库=============*/  
CREATE DATABASE usr;  
/*=============使用数据库=============*/  
USE usr;  
/*=============删除数据库表===========*/  
DROP TABLE IF EXISTS login;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS take;
DROP TABLE IF EXISTS teach;
/*=============创建数据库表===========*/
CREATE TABLE teachers(
	tid VARCHAR(32) PRIMARY KEY,
	tname VARCHAR(32) NOT NULL
);
INSERT INTO teachers(tid, tname)VALUES
('001','赵本山'),
('002','范伟');
/*=============创建数据库表===========*/
CREATE TABLE students(
	sid VARCHAR(32) PRIMARY KEY,
	sname VARCHAR(32) NOT NULL
);
INSERT INTO students(sid, sname)VALUES
('000','admin'),
('001','赵四'),
('002','刘能'),
('003','宋小宝'),
('004','小沈阳');
/*=============创建数据库表===========*/  
CREATE TABLE courses(
	cid VARCHAR(32) PRIMARY KEY,
	cname VARCHAR(32) NOT NULL
);
INSERT INTO courses(cname, cid)VALUES
('c语言设计','001'),
('java课程设计','002'),
('数据结构','003'),
('编译原理','004'),
('计算机网络基础','005'),
('高等数学','006'),
('深度学习','007');
/*=============创建数据库表===========*/  
CREATE TABLE login(  
    id VARCHAR(32) PRIMARY KEY,  
    password VARCHAR(32) NOT NULL,
    sid VARCHAR(32),
    CONSTRAINT log_fk FOREIGN KEY (sid) REFERENCES students(sid)
);  
  
INSERT INTO login(id, password, sid)VALUES('admin', 'admin', '000');
/*=============创建数据库表===========*/
CREATE TABLE take(
	sid VARCHAR(32),
	cid VARCHAR(32),
	CONSTRAINT takes_pk PRIMARY KEY (sid, cid),
	FOREIGN KEY (sid) REFERENCES students(sid),
	FOREIGN KEY (cid) REFERENCES courses(cid)
);
/*=============创建数据库表===========*/
CREATE TABLE teach(
	tid VARCHAR(32),
	cid VARCHAR(32),
	CONSTRAINT teach_pk PRIMARY KEY (tid, cid),
	FOREIGN KEY (tid) REFERENCES teachers(tid),
	FOREIGN KEY (cid) REFERENCES courses(cid)
);
INSERT INTO teach(tid, cid) VALUES
('001', '002'),
('001', '003'),
('001', '007'),
('002', '001'),
('002', '004'),
('002', '006'),
('002', '005');