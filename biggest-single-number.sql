# https://leetcode.com/problems/biggest-single-number

SELECT MAX(num) as num
FROM (
    SELECT num, COUNT(num) AS count
    FROM MyNumbers
    GROUP BY num
    HAVING count = 1
) A;
