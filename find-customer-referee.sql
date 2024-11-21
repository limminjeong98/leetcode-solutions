# https://leetcode.com/problems/find-customer-referee

# select name from customer where referee_id is null or referee_id != 2;
# <>가 훨씬 빠름, null인 경우 따로 체크해줘야함

select name from customer where referee_id is null or referee_id <> 2;
