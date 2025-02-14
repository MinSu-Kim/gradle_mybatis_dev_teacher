insert into addresses (addr_id,street,city,state,zip,country) values 
 (1,'4891 pacific hwy','san diego','ca','92110','san diego'),
 (2,'2400 n jefferson st','perry','fl','32347','taylor'),
 (3,'710 n cable rd','lima','oh','45825','allen'),
 (4,'5108 w gore blvd','lawton','ok','32365','comanche');

insert into students (stud_id,name,email,phone,dob,bio,pic,addr_id) values 
 (1,'timothy','timothy@gmail.com','123-123-1234','1988-04-25',null,null,3),
 (2,'douglas','douglas@gmail.com','789-456-1234','1990-08-15',null,null,4);

insert into tutors (tutor_id,name,email,phone,dob,bio,pic,addr_id) values 
 (1,'john','john@gmail.com','111-222-3333','1980-05-20',null,null,1),
 (2,'ken','ken@gmail.com','111-222-3333','1980-05-20',null,null,1),
 (3,'paul','paul@gmail.com','123-321-4444','1981-03-15',null,null,2),
 (4,'mike','mike@gmail.com','123-321-4444','1981-03-15',null,null,2);

insert into courses (course_id,name,description,start_date,end_date,tutor_id) values 
 (1,'quickstart core java','core java programming','2013-03-01','2013-04-15',1),
 (2,'quickstart javaee6','enterprise app development using javaee6','2013-04-01','2013-08-30',1),
 (3,'mybatis3 premier','mybatis 3 framework','2013-06-01','2013-07-15',2);

insert into course_enrollment (course_id,stud_id) values 
 (1,1),
 (1,2),
 (2,2);
