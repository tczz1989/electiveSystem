/*=============ɾ�����ݿ�=============*/  
DROP DATABASE IF EXISTS usr;  
/*=============�������ݿ�=============*/  
CREATE DATABASE usr;  
/*=============ʹ�����ݿ�=============*/  
USE usr;  
/*=============ɾ�����ݿ��===========*/  
DROP TABLE IF EXISTS login;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS take;
DROP TABLE IF EXISTS teach;
/*=============�������ݿ��===========*/
CREATE TABLE teachers(
	tid VARCHAR(32) PRIMARY KEY,
	tname VARCHAR(32) NOT NULL
);
INSERT INTO teachers(tid, tname)VALUES
('001','�Ա�ɽ'),
('002','��ΰ');
/*=============�������ݿ��===========*/
CREATE TABLE students(
	sid VARCHAR(32) PRIMARY KEY,
	sname VARCHAR(32) NOT NULL
);
INSERT INTO students(sid, sname)VALUES
('000','admin'),
('001','����'),
('002','����'),
('003','��С��'),
('004','С����');
/*=============�������ݿ��===========*/  
CREATE TABLE courses(
	cid VARCHAR(32) PRIMARY KEY,
	cname VARCHAR(32) NOT NULL
);
INSERT INTO courses(cname, cid)VALUES
('c�������','001'),
('java�γ����','002'),
('���ݽṹ','003'),
('����ԭ��','004'),
('������������','005'),
('�ߵ���ѧ','006'),
('���ѧϰ','007');
/*=============�������ݿ��===========*/  
CREATE TABLE login(  
    id VARCHAR(32) PRIMARY KEY,  
    password VARCHAR(32) NOT NULL,
    sid VARCHAR(32),
    CONSTRAINT log_fk FOREIGN KEY (sid) REFERENCES students(sid)
);  
  
INSERT INTO login(id, password, sid)VALUES('admin', 'admin', '000');
/*=============�������ݿ��===========*/
CREATE TABLE take(
	sid VARCHAR(32),
	cid VARCHAR(32),
	CONSTRAINT takes_pk PRIMARY KEY (sid, cid),
	FOREIGN KEY (sid) REFERENCES students(sid),
	FOREIGN KEY (cid) REFERENCES courses(cid)
);
/*=============�������ݿ��===========*/
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