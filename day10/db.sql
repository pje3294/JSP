select * from all_tables;


select * from BOARD;
select * from member;

select * from BOARD order by bnum desc;

drop table board;

-- ȸ�� ���̺�
create table member(
   mnum int primary key,
    mid varchar(15) not null,
    mpw varchar(15) not null
);

insert into member values((select nvl(max(mnum),0)+1 from member), 'a', 'aa');
insert into member values((select nvl(max(mnum),0)+1 from member), '����', '1234');

-- �Խ��� ���̺�  
create table board(
	bnum int primary key,
	id varchar(20) not null,
	title varchar(20) not null,
	content varchar(50) not null,
	bdate date default sysdate
);

select * from board where id like 'a%';

select * from board where id= 'a' order by bnum desc;

insert into board values((select nvl(max(bnum),0)+1 from board), 'chicken', 'taste','is very good',sysdate);
insert into board values((select nvl(max(bnum),0)+1 from board), 'a', 'a','a�� ����',sysdate);
insert into board values((select nvl(max(bnum),0)+1 from board), 'a', 'aaaaa','bbbbbb',sysdate);
insert into board values((select nvl(max(bnum),0)+1 from board), 'a', 'cccc','ddd',sysdate);
insert into board values((select nvl(max(bnum),0)+1 from board), 'abc', 'a','abc�� ����',sysdate);
insert into board values((select nvl(max(bnum),0)+1 from board), '����', '������','������',sysdate);
insert into board values((select nvl(max(bnum),0)+1 from board), '����', '�����','����ꤩ��',sysdate);
