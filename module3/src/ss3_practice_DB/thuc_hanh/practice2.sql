use quanlysinhvien;

SELECT * FROM student;

SELECT * FROM student WHERE Status = true;

select * FROM subject WHERE Credit < 10;

SELECT student.StudentName, class.ClassName, class.ClassID
FROM student INNER JOIN class ON student.ClassId = class.ClassID WHERE class.ClassName = "A1";

SELECT S.StudentName, S.StudentId, Sub.SubId, M.Mark from student S join mark M ON S.StudentId = M.StudentId join subject Sub ON M.SubId = Sub.SubId Where Sub.SubName = "CF";