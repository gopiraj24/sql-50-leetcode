# Write your MySQL query statement below
with FirstOrders as(
    select d.customer_id,
    d.order_date,
    d.customer_pref_delivery_date
    from Delivery d 
    inner join(
         select customer_id,min(order_date) as first_order_date
 from Delivery 
    group by customer_id 
    )f 
    on d.customer_id = f.customer_id and d.order_date = f.first_order_date
)
select ROUND(100.0*SUM(CASE WHEN order_date=customer_pref_delivery_date then 1 else 0 end)
       /count(*),2
) as immediate_percentage
from FirstOrders;