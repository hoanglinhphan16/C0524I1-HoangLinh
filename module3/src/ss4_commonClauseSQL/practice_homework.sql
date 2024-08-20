use quanlysinhvien;

select student.Address, count(student.StudentId)
from student
group by student.Address;

select student.StudentId,student.StudentName, AVG(mark.Mark) as AVG
from student
right join mark on student.StudentId = mark.StudentId
group by student.StudentId,student.StudentName;

select student.StudentId,student.StudentName, AVG(mark.Mark) as AVG
from student
right join mark on student.StudentId = mark.StudentId
group by student.StudentId,student.StudentName
having AVG(Mark) > 15;

select student.StudentId,student.StudentName, Max(mark.Mark) as Max_Mark
from student
join mark on student.StudentId = mark.StudentId
group by student.StudentId,student.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);

select subject.SubId, subject.SubName
from subject
group by subject.SubId, subject.SubName
having Max(Credit) >= ALL(select Credit From subject group by subject.SubId);

select subject.SubId, subject.SubName
from subject
join mark on subject.SubId = mark.SubId
group by subject.SubId, subject.SubName
having Max(Mark) >= ALL (select Mark from mark group by mark.SubId);

select student.StudentName, AVG(Mark) as AVG_Mark
from student
join mark on student.StudentId = mark.StudentId
group by student.StudentName
order by AVG(Mark) DESC;