use lms_test;

set FOREIGN_KEY_CHECKS = 0;
truncate table students;
TRUNCATE  TABLE  Klasses;
TRUNCATE TABLE teachers;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) values
  ('aaa@aol.com'),
  ('bbb@aol.com'),
  ('ccc@aol.com'),
  ('ddd@aol.com');


INSERT INTO teachers(name, age, gender) VALUES
  ('chyld',32,'MALE'),
  ('Andreas',30,'MALE');

INSERT INTO klasses (name,teacher_id,semester,credits,department,fee) VALUES
  ('sumit sir class',1,'2017-01-30', 2,'SCIENCE',3000.00 ),
  ('chyld sir class',1,'2017-01-20', 4,'SCIENCE',9120.00 ),
  ('rohit sir class',2,'2017-01-20', 4,'SCIENCE',9120.00 );
