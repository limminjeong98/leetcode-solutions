# https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier

select ei.unique_id, e.name
from employees e left outer join employeeuni ei
on e.id = ei.id;
