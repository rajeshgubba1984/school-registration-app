create table student
(
    id          bigint primary key,
    first_name   text,
    last_name    text
);

create table course
(
    id          bigint primary key,
    name   		text
    
);

create table student_course
(
	id          		bigint AUTO_INCREMENT primary key,
    student_id          bigint not null,
    course_id   		bigint not null
);