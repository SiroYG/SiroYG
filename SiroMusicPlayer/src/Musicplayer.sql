-- 테이블 삭제
drop table useraccount;
drop table usermemo;
drop sequence memoseq;

--메모일련번호
create sequence memoseq;

--유저정보
create table useraccount (
	name varchar2(20) not null,			-- 회원이름 문자열 null존재불가
	id varchar2(20) primary key,		-- 아이디 null존재불가 
	password varchar2(20) not null		-- 비밀번호  null존재불가 
);
create sequence memo_seq 
start with 1
increment by 1

--메모정보
create table usermemo (
	memoseq varchar2(60) primary key,
    title varchar2(60) not null, 	--메모 제목
    content varchar2(2000) not null,--메모내용
    indate date default sysdate,    --메모작성일
    id varchar2(20),				--작성자
	constraint id_fk 
	foreign key (id) 
	references useraccount(id)	
);



create sequence music_seq 
start with 1
increment by 1
--뮤직
create table Music(
	musicseq varchar2(60) primary key,
	MusicName varchar2(60) not null,
	singer varchar2(60) not null,
	playtime number(20) not null,
    musicPath varchar2(200) not null,
	id varchar2(20),
	foreign key (id) 
	references useraccount(id)
);


--Bridge
create table Bridge(
		id varchar2(20) not null,
		musicseq varchar2(20) not null,
	foreign key (id) 
	references useraccount(id),
	foreign key (musicseq) 
	references Music(musicseq)
		)

		
--blob test table
create table bTest(
	MusicName varchar2(60) not null,
	singer varchar2(60) not null,
	rowdata blob not null,
);
		
-- 커밋
commit;


delete useraccount;
delete usermemo;

