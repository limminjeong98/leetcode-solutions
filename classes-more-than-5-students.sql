# https://leetcode.com/problems/classes-more-than-5-students

SELECT DISTINCT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;
