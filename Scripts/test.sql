select user(), database();

select * from addresses;
select * from course_enrollment;
select * from courses;
select * from students;
select * from tutors;

select stud_id, name, email, dob, phone 
from students where stud_id=1;

select stud_id, name, email, dob, phone, 
       substring(phone, 1, 3) as f, substring(phone, 5, 3) as m, substring(phone, 9, 4) as l
from students where stud_id=1;

select stud_id, name, email, phone, dob from students;

set foreign_key_checks = 0;
delete from students;
set foreign_key_checks = 1;

desc students;
select * from addresses where addr_id = 3;
select stud_id, name, email, phone, a.addr_id, street, city, state, zip, country
  from students s left join addresses a on s.addr_id = a.addr_id
 where stud_id = 1;

select * from tutors;
select * from courses;

select t.tutor_id, t.name as tutor_name, email, course_id, c.name, description, start_date, end_date 
  from tutors t left join courses c on t.tutor_id = c.tutor_id
 where t.tutor_id = 1;



alter table students add gender tinyint unsigned; 

select * from students;
desc students;

show tables;

select * from user_pics;

desc user_pics;
select addr_id, street, city, state, zip, country 
		  from addresses;
