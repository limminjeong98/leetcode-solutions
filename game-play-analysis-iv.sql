# https://leetcode.com/problems/game-play-analysis-iv

SELECT ROUND(SUM(first_login) / COUNT(DISTINCT player_id), 2) AS fraction
FROM (
    SELECT player_id,
    DATEDIFF(event_date, MIN(event_date) OVER(PARTITION BY player_id)) = 1 AS first_login
    FROM Activity
) A;
