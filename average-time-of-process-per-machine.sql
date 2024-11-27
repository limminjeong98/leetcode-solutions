# https://leetcode.com/problems/average-time-of-process-per-machine

select start.machine_id, round(avg(end.timestamp - start.timestamp), 3) as processing_time
from activity start inner join activity end
on start.machine_id = end.machine_id
and start.process_id = end.process_id
and start.activity_type = 'start'
and end.activity_type = 'end'
group by start.machine_id;
