# https://leetcode.com/problems/rising-temperature

select today.id
from weather as today, weather as yesterday
where DATEDIFF(today.recordDate, yesterday.recordDate) = 1 
and today.temperature > yesterday.temperature;
