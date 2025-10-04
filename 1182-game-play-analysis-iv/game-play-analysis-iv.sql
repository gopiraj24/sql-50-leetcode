# Write your MySQL query statement below
select ROUND(COUNT(DISTINCT T.player_id)/COUNT(DISTINCT a.player_id),2) as fraction
FROM Activity a 
left join 
(SELECT player_id, MIN(event_date) as FLD
FROM Activity
GROUP BY player_id ) T
on a.player_id =T.player_id and DATE_SUB(a.event_date,INTERVAL 1 DAY) = T.FLD;

