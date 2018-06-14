create sequence mid increment by 1 start with 1;
--����רҵ��
create table major(
    mid         int           primary key,    
    mname       varchar2(50)  not null,       
    director    varchar2(50)  not null,
    gradecount  int        
);

--�����༶������
create sequence gid increment by 1 start with 1;
--�����༶��
create table grade(
    gid         int           primary key,    
    gname       varchar2(50)  not null,       
    year        char(4)       not null,       
    mid         int           not null,   
    stucount    int,
    foreign key (mid) references major(mid) on delete cascade
);

--����ѧ����
create table student(
    sno         char(9)       primary key,    
    sname       varchar2(50)  not null,       
    ssex        char(3)       not null,       
    sage        smallint      not null,       
    gid         int           not null,       
    foreign key (gid) references grade(gid) on delete cascade
);

--�����γ̱�
create table course(
    cno         char(6)       primary key,   
    cname       varchar2(50)  not null,       
    credit      number(2,1)   not null,       
    period      smallint      not null        
);

--����ѡ�α�
create table sc(
    sno         char(9)       not null,       
    cno         char(6)       not null,       
    grade       number(4,1),                  
    primary key(sno,cno),
    foreign key (sno) references student(sno) on delete cascade,
    foreign key (cno) references course(cno) on delete cascade
);

--�����û�������
create sequence user_id increment by 1 start with 1;
--�����û����
create table users(
    id          int           primary key,
    username    varchar2(50)  not null,
    password    varchar2(50)  not null
);
--**************************ͳ�ư༶������������ʼ***********************
create or replace trigger tr_grade
after insert or delete or update on grade
declare
  cursor cur_grade is select mid,count(*) count from grade group by mid;
begin
  for temp in cur_grade loop
    update major set gradecount = temp.count where mid = temp.mid;
  end loop;
end tr_grade;
--**************************ͳ�ư༶��������������***********************
--**************************ͳ��ѧ��������������ʼ***********************
create or replace trigger tr_student
after insert or delete or update on student
declare
  cursor cur_student is select gid,count(*) count from student group by gid;
begin
  for temp in cur_student loop
    update grade set stucount = temp.count where gid = temp.gid;
  end loop;
end tr_student;
--**************************ͳ��ѧ����������������***********************

--����רҵ������
insert into major(mid,mname,director) values(mid.nextval,'�������̼����Զ���','����');
insert into major(mid,mname,director) values(mid.nextval,'������Ϣ����','�ƺ���');
insert into major(mid,mname,director) values(mid.nextval,'������Ϣ��ѧ�뼼��','������');
insert into major(mid,mname,director) values(mid.nextval,'�Զ���','÷��ΰ');
insert into major(mid,mname,director) values(mid.nextval,'�������ѧ�뼼��','���ǻ�');
insert into major(mid,mname,director) values(mid.nextval,'�������','���ʤ');
insert into major(mid,mname,director) values(mid.nextval,'���ϳ��ͼ����ƹ���','����');
insert into major(mid,mname,director) values(mid.nextval,'���Ͽ�ѧ�빤��','����');
insert into major(mid,mname,director) values(mid.nextval,'��������','����');
commit;


--����༶������
insert into grade(gid,gname,year,mid) values(gid.nextval,'�����141','2014',5);
insert into grade(gid,gname,year,mid) values(gid.nextval,'�����142','2014',5);
insert into grade(gid,gname,year,mid) values(gid.nextval,'�����143','2014',5);
insert into grade(gid,gname,year,mid) values(gid.nextval,'���141','2014',6);
insert into grade(gid,gname,year,mid) values(gid.nextval,'�����151','2015',5);
insert into grade(gid,gname,year,mid) values(gid.nextval,'�����152','2015',5);
insert into grade(gid,gname,year,mid) values(gid.nextval,'���151','2015',6);
insert into grade(gid,gname,year,mid) values(gid.nextval,'���152','2015',6);
insert into grade(gid,gname,year,mid) values(gid.nextval,'�Զ���151','2015',4);
insert into grade(gid,gname,year,mid) values(gid.nextval,'�Զ���152','2015',4);
insert into grade(gid,gname,year,mid) values(gid.nextval,'�Զ���153','2015',4);
insert into grade(gid,gname,year,mid) values(gid.nextval,'�Զ���154','2015',4);
commit;

--����ѧ��������
insert into student values('201400601','����','��',19,1);
insert into student values('201400602','����','��',20,1);
insert into student values('201400603','����','Ů',20,1);
insert into student values('201400604','����','��',22,1);
insert into student values('201400605','���','Ů',21,1);
insert into student values('201400606','�ź�','��',20,1);
insert into student values('201400607','ǮСƽ','Ů',18,1);
insert into student values('201400608','������','��',19,1);
insert into student values('201400609','�Ž�','��',19,1);
insert into student values('201400610','������','��',19,1);
insert into student values('201400611','������','��',19,1);
insert into student values('201400612','����','��',19,1);
insert into student values('201400613','�����','��',19,1);
insert into student values('201400614','֣����','��',19,1);
insert into student values('201400615','���','��',19,1);
insert into student values('201400616','�Ŵ���','��',19,1);
insert into student values('201400617','����','��',19,1);
insert into student values('201400618','�޲���','��',19,1);
insert into student values('201400619','�̻���','��',19,1);
insert into student values('201400620','������','��',19,1);

insert into student values('201400630','����ΰ','��',19,2);
insert into student values('201400631','���','��',19,2);
insert into student values('201400632','������','��',19,2);
insert into student values('201400633','Ф��','��',19,2);
insert into student values('201400634','���弪','��',19,2);
insert into student values('201400635','����','��',19,2);
insert into student values('201400636','������','��',19,2);
insert into student values('201400637','������','��',19,2);
insert into student values('201400638','�ż�ΰ','��',19,2);
insert into student values('201400639','���','��',19,2);
insert into student values('201400640','����','��',19,2);
insert into student values('201400641','�ž���','��',19,2);
insert into student values('201400642','������','��',19,2);
insert into student values('201400643','������','��',19,2);
insert into student values('201400644','���','��',19,2);
insert into student values('201400645','����','��',19,2);
insert into student values('201400646','ʷ����','��',19,2);
insert into student values('201400647','�����','��',19,2);
insert into student values('201400648','�ŷ�','��',19,2);
insert into student values('201400649','���','��',19,2);
insert into student values('201400650','������','Ů',19,2);
insert into student values('201400651','����','��',19,2);
insert into student values('201400652','�','��',19,2);
insert into student values('201400653','������','��',19,2);
insert into student values('201400654','����','��',19,2);
insert into student values('201400655','���','��',19,2);
insert into student values('201400656','��հ','��',19,2);
insert into student values('201400657','�⽨��','��',19,2);
insert into student values('201400658','������','��',19,2);
insert into student values('201400659','����','��',19,2);
insert into student values('201400660','����','��',19,2);
insert into student values('201400661','�¹���','��',19,2);

insert into student values('201400670','������','��',19,3);
insert into student values('201400671','��ǰ��','��',19,3);
insert into student values('201400672','����','��',19,3);
insert into student values('201400673','�˺���','��',19,3);
insert into student values('201400674','����','��',19,3);
insert into student values('201400675','����','��',19,3);
insert into student values('201400676','����','��',19,3);
insert into student values('201400677','����ͤ','��',19,3);
insert into student values('201400678','¬����','��',19,3);
insert into student values('201400679','���Ʒ�','��',19,3);
insert into student values('201400680','ʷ����','��',19,3);
insert into student values('201400681','����ΰ','��',19,3);
insert into student values('201400682','�ܾ�','��',19,3);
insert into student values('201400683','������','��',19,3);
insert into student values('201400684','��ǿ','��',19,3);
insert into student values('201400685','����ά','��',19,3);
insert into student values('201400686','������','��',19,3);
insert into student values('201400687','����','��',19,3);
insert into student values('201400688','���ͥ','��',19,3);
insert into student values('201400689','��С��','��',19,3);
insert into student values('201400690','����','��',19,3);
insert into student values('201400691','�Ų���','��',19,3);
insert into student values('201400692','����λ','��',19,3);
insert into student values('201400693','�ܺ�ɭ','��',19,3);
insert into student values('201400694','����','��',19,3);
insert into student values('201400695','��С��','��',19,3);
insert into student values('201400696','������','��',19,3);
insert into student values('201400697','����','��',19,3);
insert into student values('201400698','���º�','��',19,3);
insert into student values('201400699','������','��',19,3);
insert into student values('201400700','ʯ��','��',19,3);
insert into student values('201400701','������','��',19,3);

insert into student values('201500488','����','��',19,9);
insert into student values('201500775','�쿵','��',19,9);
insert into student values('201500816','Ԭ��','��',19,9);
insert into student values('201500824','����','��',19,9);
insert into student values('201500831','�ܺ���','��',19,9);
insert into student values('201500832','�ϴ���','��',19,9);
insert into student values('201500833','���ݷ�','��',19,9);
insert into student values('201500834','�º��','��',19,9);
insert into student values('201500835','����','��',19,9);
insert into student values('201500836','����','��',19,9);
insert into student values('201500843','����','��',19,9);
insert into student values('201502005','����','��',19,9);
insert into student values('201500855','��Ԫ��','��',19,9);
insert into student values('201500856','������','��',19,9);
insert into student values('201500857','���ʹ�','��',19,9);
insert into student values('201500858','����','��',19,9);
insert into student values('201500859','������','��',19,9);
insert into student values('201500860','¬��','��',19,9);
insert into student values('201500861','��־��','��',19,9);
insert into student values('201500862','����','��',19,10);
insert into student values('201500863','�����','��',19,10);
insert into student values('201500864','��С��','��',19,10);
insert into student values('201500865','���','��',19,10);
insert into student values('201500866','�̶���','��',19,10);
insert into student values('201500867','���','��',19,10);
insert into student values('201500868','���','��',19,10);
insert into student values('201500869','����ǫ','��',19,10);
insert into student values('201500870','����','��',19,10);
insert into student values('201500871','����','��',19,10);
insert into student values('201500872','����','��',19,10);
insert into student values('201500873','֣��','��',19,10);
insert into student values('201500875','����','��',19,10);
insert into student values('201500876','�����','��',19,10);
insert into student values('201500878','��־��','��',19,10);
insert into student values('201500879','��ҫ��','��',19,10);
insert into student values('201500880','���','��',19,10);
insert into student values('201500881','������','��',19,10);
insert into student values('201500882','����','��',19,10);
insert into student values('201500883','�ĳ���','��',19,10);
insert into student values('201500885','����','��',19,10);
insert into student values('201500886','����','��',19,10);
insert into student values('201500380','����','��',19,10);
insert into student values('201500890','�����','��',19,11);
insert into student values('201500891','������','��',19,11);
insert into student values('201500892','���','��',19,11);
insert into student values('201500893','������','��',19,11);
insert into student values('201500894','������','��',19,11);
insert into student values('201500895','κ�ڱ�','��',19,11);
insert into student values('201500896','�����','��',19,11);
insert into student values('201500897','��־��','��',19,11);
insert into student values('201500898','������','��',19,11);
insert into student values('201500899','�Ե���','��',19,11);
insert into student values('201500900','������','��',19,11);
insert into student values('201500901','���ĺ�','��',19,11);
insert into student values('201500902','�Ʒ���','��',19,11);
insert into student values('201500903','����˫','��',19,11);
insert into student values('201500904','������','��',19,11);
insert into student values('201500905','ףС��','��',19,11);
insert into student values('201500907','��Ԫ��','��',19,11);
insert into student values('201500908','���','��',19,11);
insert into student values('201500909','������','��',19,11);
insert into student values('201500910','���ֺ�','��',19,11);
insert into student values('201500911','����','��',19,11);
insert into student values('201500912','������','��',19,11);
insert into student values('201500913','����','��',19,11);
insert into student values('201500914','���Ѻ�','��',19,11);
insert into student values('201500915','���','��',19,11);
insert into student values('201500916','�Ƶ�','��',19,11);
insert into student values('201500917','����','��',19,11);
insert into student values('201500918','������','��',19,11);
insert into student values('201500919','����','��',19,11);
insert into student values('201500920','������','��',19,11);
insert into student values('201500921','�ܽ���','��',19,11);
insert into student values('201500922','����','��',19,11);
insert into student values('201500923','��ɺ','��',19,11);
insert into student values('201500924','������','��',19,11);
insert into student values('201500925','������','��',19,11);
insert into student values('201500926','������','��',19,11);
insert into student values('201500927','������','��',19,11);
insert into student values('201501586','��ֲ��','��',19,11);
insert into student values('201502413','ʯ�','��',19,11);
insert into student values('201500930','��֪��','��',19,12);
insert into student values('201500931','��־��','��',19,12);
insert into student values('201500935','ʢ����','��',19,12);
insert into student values('201500938','��Զ��','��',19,12);
insert into student values('201500939','��Զ','��',19,12);
insert into student values('201500940','¬����','��',19,12);
insert into student values('201500941','�ź�','��',19,12);
insert into student values('201500959','��Ǭ','��',19,12);
insert into student values('201500962','������','��',19,12);
insert into student values('201500966','���','��',19,12);
commit;

--����γ̱�����
insert into course values('020420','C���Գ������',4,64);
insert into course values('020460','��������ԭ��',4,64);
insert into course values('020610','��ɢ��ѧ',4,64);
insert into course values('020621','���ݽṹ',4,64);
insert into course values('020630','����ϵͳԭ��',4,64);
insert into course values('020660','����ԭ��',3,48);
insert into course values('150014','�ߵ���ѧ',5,80);
insert into course values('020471','���������A',3.5,56);
insert into course values('020720','JAVA�������',3,48);
insert into course values('020640','���ݿ�ϵͳԭ��',3.5,56);
insert into course values('020650','�����ͼ��ѧ',2.5,40);
insert into course values('020730','�㷨��������',2.5,40);
insert into course values('020700','���ݿ�ϵͳʵ��',2.5,40);
insert into course values('020680','�������',2.0,32);
commit;

--����ѡ�α�����
insert into sc values('201400601','020420',92);
insert into sc values('201400601','020460',85);
insert into sc values('201400601','020621',88);
insert into sc values('201400602','020420',90);
insert into sc values('201400602','020460',100);
insert into sc values('201400602','020640',100);

insert into sc values('201400603','020420',90);
insert into sc values('201400603','020460',100);
insert into sc values('201400603','020640',100);
insert into sc values('201400603','020730',100);
insert into sc values('201400603','020700',100);

insert into sc values('201400630','020420',90);
insert into sc values('201400630','020460',100);
insert into sc values('201400630','020680',100);

insert into sc values('201400631','020420',90);
insert into sc values('201400631','020460',100);
insert into sc values('201400631','020650',100);

insert into sc values('201400632','020420',90);
insert into sc values('201400632','020460',100);
insert into sc values('201400632','020471',100);

insert into sc values('201400633','020420',90);
insert into sc values('201400633','020460',100);
insert into sc values('201400633','020720',100);

insert into sc values('201400670','020420',90);
insert into sc values('201400670','020460',100);
insert into sc values('201400670','020730',100);

insert into sc values('201400671','020420',90);
insert into sc values('201400671','020460',100);
insert into sc values('201400671','020621',100);

insert into sc values('201400672','020420',90);
insert into sc values('201400672','020460',100);
insert into sc values('201400672','020730',100);
commit;

insert into users values(user_id.nextval,'admin','admin');
commit;

select * from student;
