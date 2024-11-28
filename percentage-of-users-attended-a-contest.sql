# https://leetcode.com/problems/percentage-of-users-attended-a-contest

select r.contest_id, round(100 * count(r.user_id) / (select count(user_id) from users), 2) as percentage
from register r
group by r.contest_id
order by percentage desc, r.contest_id asc;
