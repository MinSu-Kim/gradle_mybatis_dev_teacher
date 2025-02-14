drop database if exists mybatis_dev;

create database mybatis_dev;

create table mybatis_dev.addresses (
  addr_id int(11) not null auto_increment comment '주소코드',
  street varchar(50) not null comment '도로',
  city varchar(50) not null comment '시',
  state varchar(50) not null comment '구',
  zip varchar(10)  null comment '우편번호',
  country varchar(50) not null comment '읍',
  primary key (addr_id)
) comment '주소';

create table mybatis_dev.students (
  stud_id int(11) not null auto_increment  comment '학생코드',
  name varchar(50) not null comment '이름',
  email varchar(50) not null comment '이메일',
  phone varchar(15) default null comment '연락처',  
  dob date null comment '생일',
  bio longtext null comment '자기소개',
  pic blob null comment '사진',
  addr_id int(11) default null comment '주소',  
  primary key (stud_id),
  constraint fk_students_addr foreign key (addr_id) references mybatis_dev.addresses (addr_id)
)comment '학생';

create table mybatis_dev.tutors (
  tutor_id int(11) not null auto_increment comment '교수번호',
  name varchar(50) not null comment '이름',
  email varchar(50) not null comment '이메일',
  phone varchar(15) default null comment '연락처',  
  dob date default null comment '생일',
  bio longtext default null comment '교수소개',
  pic blob default null comment '사진',
  addr_id int(11) default null comment '주소',
  primary key (tutor_id),
  constraint fk_tutors_addr foreign key (addr_id) references mybatis_dev.addresses (addr_id)  
) comment '교수';

create table mybatis_dev.courses (
  course_id int(11) not null auto_increment  comment '과목코드',
  name varchar(100) not null comment '과목명',
  description varchar(512) default null comment '설명',
  start_date date default null comment '시작일',
  end_date date default null comment '종료일',
  tutor_id int(11) not null comment '담당교수',
  primary key (course_id),
  constraint fk_course_tutor foreign key (tutor_id)  references mybatis_dev.tutors (tutor_id)
) comment '과목';

create table mybatis_dev.course_enrollment(
  course_id int(11) not null comment '과목코드',
  stud_id int(11) not null comment '학생코드',
  primary key (course_id,stud_id),
  constraint fk_enrollment_stud foreign key (stud_id) references mybatis_dev.students (stud_id),
  constraint fk_enrollment_course foreign key (course_id) references mybatis_dev.courses (course_id)
);

-- gender column 추가
alter table students add gender tinyint unsigned; 


-- userPic 테이블 추가
create table mybatis_dev.user_pics(
	id integer auto_increment primary key,
	name varchar(50) not null,
	pic longblob,
	bio longtext
);



-- 계정 추가
grant all privileges 
on mybatis_dev.* 
to 'user_mybatis_dev'@'localhost' 
identified by 'rootroot';

grant all privileges 
on mybatis_dev.* 
to 'user_mybatis_dev'@'%' 
identified by 'rootroot';