CREATE DATABASE IF NOT EXISTS sb_mybatis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use sb_mybatis;


CREATE TABLE IF NOT EXISTS class(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(64) NOT NULL,
    name VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS student(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    gender VARCHAR(64) NOT NULL,
    class_id INT NOT NULL,
    CONSTRAINT fk_student_class FOREIGN KEY(class_id) REFERENCES class(id)
);

INSERT INTO class(id, code, name) value(1, '001', 'English A');
INSERT INTO class(id, code, name) value(2, '002', 'English B');
INSERT INTO class(id, code, name) value(3, '003', 'Chinese A');
INSERT INTO class(id, code, name) value(4, '004', 'Chinese B');
INSERT INTO class(id, code, name) value(5, '005', 'Math A');
INSERT INTO class(id, code, name) value(6, '006', 'Math B');


INSERT INTO student(id, name, gender, class_id) value(1, 'Student A', '女', 1);
INSERT INTO student(id, name, gender, class_id) value(2, 'Student B', '女', 1);
INSERT INTO student(id, name, gender, class_id) value(3, 'Student C', '女', 1);
INSERT INTO student(id, name, gender, class_id) value(4, 'Student D', '女', 2);
INSERT INTO student(id, name, gender, class_id) value(5, 'Student E', '女', 2);
INSERT INTO student(id, name, gender, class_id) value(6, 'Student F', '女', 3);
INSERT INTO student(id, name, gender, class_id) value(7, 'Student G', '女', 4);
INSERT INTO student(id, name, gender, class_id) value(8, 'Student H', '女', 4);
INSERT INTO student(id, name, gender, class_id) value(9, 'Student I', '女', 5);
INSERT INTO student(id, name, gender, class_id) value(10, 'Student J', '女', 5);
INSERT INTO student(id, name, gender, class_id) value(11, 'Student K', '女', 5);
INSERT INTO student(id, name, gender, class_id) value(12, 'Student L', '女', 6);