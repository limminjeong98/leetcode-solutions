# https://leetcode.com/problems/students-and-examinations

select students.student_id, students.student_name, subjects.subject_name, coalesce(count(examinations.subject_name), 0) as attended_exams
from students join subjects left outer join examinations
on subjects.subject_name = examinations.subject_name
and students.student_id = examinations.student_id
group by students.student_id, subjects.subject_name
order by student_id, subject_name;
