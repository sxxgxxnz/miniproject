create table userInfo(
name varchar2(15) not null, --�̸�
pw varchar2(15) not null,   --��й�ȣ
email varchar2(20) primary key, --�̸��� �⺻Ű->not null, unique
coin number default 1000);


alter table userinfo modify (email varchar(25));

select * from userInfo;

commit;

select pw from userinfo where name='�Ž���';
select count(name) as cnt from userinfo where name='�Ž���';