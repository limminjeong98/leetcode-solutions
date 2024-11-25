# https://leetcode.com/problems/product-sales-analysis-i

select p.product_name, s.year, s.price
from sales s left outer join product p
on s.product_id = p.product_id;
