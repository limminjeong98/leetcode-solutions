# https://leetcode.com/problems/delete-duplicate-emails
# Write your MySQL query statement below
DELETE 
FROM Person
WHERE id NOT IN (
    SELECT A.id
    FROM (
        SELECT MIN(id) as id, email
        FROM Person
        GROUP BY email
    ) A
);
