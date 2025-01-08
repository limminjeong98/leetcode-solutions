# https://leetcode.com/problems/triangle-judgement
SELECT x, y, z,
CASE WHEN x + y > z && x + z > y && y + z > x THEN 'Yes' ELSE 'No' END AS 'triangle'
FROM Triangle;

# 내가 풀었던 풀이
-- SELECT x, y, z, 
--     CASE 
--         WHEN z >= x && z >= y && x + y > z THEN 'Yes' 
--         WHEN y >= x && y >= z && x + z > y THEN 'Yes' 
--         WHEN x >= y && x >= z && y + z > x THEN 'Yes' 
--         ELSE 'No' 
--     END AS `triangle`
-- FROM Triangle;
