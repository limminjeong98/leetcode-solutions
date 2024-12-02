# https://leetcode.com/problems/user-activity-for-the-past-30-days-i

SELECT activity_date AS day, COUNT(DISTINCT user_id) as active_users
FROM Activity
WHERE activity_date BETWEEN DATE_SUB('2019-07-27', INTERVAL 29 DAY) AND '2019-07-28'
# WHERE DATEDIFF('2019-07-27', activity_date) < 30 AND DATEDIFF('2019-07-27', activity_date) >= 0
GROUP BY activity_date;
