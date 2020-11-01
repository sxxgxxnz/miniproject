create table userInfo(
name varchar2(15) not null, --이름
pw varchar2(15) not null,   --비밀번호
email varchar2(20) primary key, --이메일 기본키->not null, unique
coin number default 1000);


alter table userinfo modify (email varchar(25));

select * from userInfo;

commit;

select pw from userinfo where name='신승은';
select count(name) as cnt from userinfo where name='신승은';