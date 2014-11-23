




select * from jumpBoard where board_num = 1;

select NAME, VALUE$ FROM SYS.PROPS$

UPDATE SYS.PROPS$ set value$='KOREAN' where name='NLS_LANGUAGE';
UPDATE SYS.PROPS$ set value$='KOREAN' where name='NLS_TERRITORY';
UPDATE SYS.PROPS$ set value$='KO16MSWIN949' where name='NLS_CHARACTERSET';
COMMIT;
SHUTDOWN IMMEDIATE
STARTUP

select distinct(nls_charset_name(charsetid)) CHARACTERSET,
decode(type#, 1, decode(charsetform, 1, 'VARCHAR2', 2, 'NVARCHAR2','UNKOWN'),
9, decode(charsetform, 1, 'VARCHAR', 2, 'NCHAR VARYING', 'UNKOWN'),
96, decode(charsetform, 1, 'CHAR', 2, 'NCHAR', 'UNKOWN'),
112, decode(charsetform, 1, 'CLOB', 2, 'NCLOB', 'UNKOWN')) TYPES_USED_IN
from sys.col$ where charsetform in (1,2) and type# in (1, 9, 96, 112);

create table authorities(
	user_id varchar2(10),
	authority varchar2(10)
)
insert into authorities values('dlacjfgus','ROLE_USER')
insert into authorities values('cjfgus@hanmail.net','ROLE_USER')

select * from authorities


select jump_pwd from jump where jump_id= 'cjfgus@hanmail.net';
create table jump(
	jump_id varchar2(1000) primary key,
	jump_pwd varchar2(1000)not null,
	jump_name varchar2(1000) not null
)

Select * From v$nls_parameters;
Select * From nls_database_parameters;

select * from jump
insert into jump values('cjfgus@hanmail.net','1111','임철현')

create sequence board_num;
drop sequence board_num;


select board_num  from JUMPBOARD where jump_id = 'cjfgus@hanmail.net' order by rownum desc

select * from jumpBoard

create table jumpBoard(
	jump_id varchar2(1000) not null,
	board_num number primary key, /*create sequence board_num*/
	board_date date default sysdate,
	board_title varchar2(250) not null,
	board_area varchar2(250) not null,
	board_content varchar2(4000),
	foreign key(jump_id) references jump(jump_id)
)
select * from JUMPBOARD;
select * from jumpBoard where board_title like '%z%' or board_content like '%%';

create table jumpImage(
	board_num number not null,
	image varchar2(100) not null,
	foreign key(board_num) references jumpBoard(board_num)
)

select check_best from jumpCheck where board_num = 20 and jump_id = 'cjfgus@hanmal.net'

select * from jumpCheck where jump_id = 'cjfgus@hanmail.net' and board_num = 25;
select * from jumpCheck

create table jumpCheck(
	jump_id varchar2(1000) not null,
	board_num number not null,
	check_best number default 0,
	foreign key(jump_id) references jump(jump_id),
	foreign key(board_num) references jumpBoard(board_num)
)

update jumpCheck set check_best = 0 where jump_id = 'cjfgus@hanmail.net' and board_num=25


drop table jumpCheck;
drop table jumpImage;
drop table jumpBoard;
