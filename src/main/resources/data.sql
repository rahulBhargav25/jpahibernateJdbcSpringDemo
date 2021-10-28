insert into course(id,name,update,create) values(1001,'jpa in 50 steps',sysdate(),sysdate())
insert into course(id,name,update,create) values(1002,'Angular in 50 steps',sysdate(),sysdate())
insert into course(id,name,update,create) values(1003,'web in 50 steps',sysdate(),sysdate())
insert into passport(id,number) values(4001,'E123456')
insert into passport(id,number) values(4002,'N123457')
insert into passport(id,number) values(4003,'L123890')
insert into review(id,rating,description,course_id) values(5001,'5','gc',1001)
insert into review(id,rating,description,course_id) values(5002,'4','tc',1001)
insert into review(id,rating,description,course_id) values(5003,'3','ac',1003)
insert into student(id,name,passport_id) values(2001,'Ranga',4001)
insert into student(id,name,passport_id) values(2002,'Adam',4002)
insert into student(id,name,passport_id) values(2003,'Jane',4003)
insert into student_course(student_id,course_id) values(2001,1001)
insert into student_course(student_id,course_id) values(2001,1003)
insert into student_course(student_id,course_id) values(2002,1001)
insert into student_course(student_id,course_id) values(2003,1001)



