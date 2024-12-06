# https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee

SELECT e1.employee_id, e1.name, COUNT(*) AS reports_count, ROUND(AVG(e2.age)) AS average_age
FROM Employees e1 INNER JOIN Employees e2
ON e1.employee_id = e2.reports_to AND e2.reports_to IS NOT NULL
GROUP BY e1.employee_id
ORDER BY e1.employee_id;
