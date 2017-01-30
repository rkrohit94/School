use lms_test;

set FOREIGN_KEY_CHECKS = 0;
truncate table students;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) values
  ('aaa@aol.com'),
  ('bbb@aol.com'),
  ('ccc@aol.com'),
  ('ddd@aol.com');

TRUNCATE  TABLE  Klasses;

INSERT INTO klasses (name,semester,credits,department,fee) VALUES
  ('sumit sir class','2017-01-30', 2,'SCIENCE',3000.00 ),
  ('chyld sir class','2017-01-20', 4,'SCIENCE',9120.00 ),
  ('rohit sir class','2017-01-20', 4,'SCIENCE',9120.00 );

TRUNCATE TABLE teachers;

INSERT INTO teachers(name, age, sex) VALUES
  ('chyld',32,'MALE');