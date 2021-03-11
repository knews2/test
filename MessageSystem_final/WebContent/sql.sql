1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
   컬럼명 : email / pw / tel / address


create table web_member (

email varchar2(500),
pw varchar2(500),
tel varchar2(500),
address varchar2(500)

)

select * from web_member;

실행 ALT X 
	
create table Message (

num number,
send varchar2(500),
receive varchar2(500),
content varchar2(500),
send_date date

)

시퀀스 생성

create sequence num start with 1 increment by 1;

create sequence send_date start  

select * from message;

insert into message
values(
num.nextval,
'juzi',
'juzimom',
'hello world',
sysdate
);

insert into message
values(
num.nextval,
'juzi',
'juzi',
'hello java',
sysdate
);

