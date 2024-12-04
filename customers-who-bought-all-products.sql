# https://leetcode.com/problems/customers-who-bought-all-products

SELECT customer_id
FROM (
    SELECT customer_id, COUNT(DISTINCT product_key) AS cnt
    FROM Customer
    GROUP BY customer_id
) A
WHERE A.cnt = (SELECT COUNT(*) FROM Product);
