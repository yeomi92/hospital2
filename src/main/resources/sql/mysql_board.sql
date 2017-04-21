-- seq,id,title,content,regdate,read_count --
drop table article;
drop Sequence art_seq;
--CREATE SEQUENCE--
CREATE SEQUENCE art_seq
	START WITH 1
	INCREMENT BY 1
	NOCACHE
	NOCYCLE;
--CREATE TABLE--
CREATE TABLE Article(
	art_seq INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	writer_id VARCHAR(10) NOT NULL,
	title VARCHAR(30) NOT NULL,
	content VARCHAR(100) NOT NULL,
	reg_date VARCHAR(10) NOT NULL,
	read_count INT NOT NULL,
);
--INSERT(11\uAC74)--
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun','안녕하세요','안녕하세요 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun1','안녕하세요1','안녕하세요1 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun2','안녕하세요2','안녕하세요2 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun3','안녕하세요3','안녕하세요3 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun4','안녕하세요4','안녕하세요4 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun5','안녕하세요5','안녕하세요5 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun6','안녕하세요6','안녕하세요6 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun7','안녕하세요7','안녕하세요7 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun8','안녕하세요8','안녕하세요8 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun9','안녕하세요9','안녕하세요9 content','2017-01-01',0);
INSERT INTO Article(art_seq,writer_id,title,content,reg_date,read_count) VALUES('yheisun10','안녕하세요10','안녕하세요10 content','2017-01-01',0);

--READ ONE--
select * from article where art_seq='1';
--READ ALL--
select * from article;
--READ SOME--
select title from article where regdate like '%02%';
--UPDATE--
update ARTICLE set title='' where art_seq='';
--DELETE--
delete from ARTICLE where art_seq='1'; 