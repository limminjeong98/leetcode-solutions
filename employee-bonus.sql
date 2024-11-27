# https://leetcode.com/problems/employee-bonus

select employee.name, bonus.bonus
from employee left outer join bonus
on employee.empId = bonus.empId 
where bonus.bonus is null or bonus.bonus < 1000;
