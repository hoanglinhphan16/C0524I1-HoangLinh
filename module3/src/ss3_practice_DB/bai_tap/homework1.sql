use quanlysinhvien;

select * from student where StudentName like "h%";
select * from class where StartDate like "%-12-%";
select * from class where extract(month from startDate) = 12;

set sql_safe_updates = 0;
update student set ClassId = 2 where StudentName = "Hung";

select student.StudentName, subject.SubName, mark.Mark from student join mark on student.StudentId = mark.StudentId join subject on subject.SubId = mark.SubId order by mark.Mark DESC, student.StudentName ASC;