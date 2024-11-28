# https://leetcode.com/problems/queries-quality-and-percentage

select query_name, 
round(sum(rating / position) / count(*), 2) as quality, 
round(100 * sum(case when rating < 3 then 1 else 0 end) / count(*), 2) as poor_query_percentage
from queries
where query_name is not null
group by query_name;
