# https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions

select a.customer_id, count(a.customer_id) as `count_no_trans` 
from 
(
    select v.customer_id
    from visits v
    where v.visit_id not in (
        select t.visit_id from transactions t
    )
) a
group by a.customer_id;
