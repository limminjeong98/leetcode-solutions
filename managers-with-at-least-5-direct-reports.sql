# https://leetcode.com/problems/managers-with-at-least-5-direct-reports
  
select e1.name
from employee e1 left outer join employee e2
on e1.id = e2.managerId
group by e1.id
having count(e2.managerId) >= 5;
