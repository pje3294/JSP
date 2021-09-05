select * from all_tables;
select * from member;

drop table member;


create table member(
   num int primary key,
    mid varchar(15) not null,
    mpw varchar(15) not null
);

insert into member values((select nvl(max(num),0)+1 from member),'Á¤Àº','1234');
insert into member values((select nvl(max(num),0)+1 from member),'mint','choco');
insert into member values((select nvl(max(num),0)+1 from member),'a','aa');

