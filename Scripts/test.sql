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



