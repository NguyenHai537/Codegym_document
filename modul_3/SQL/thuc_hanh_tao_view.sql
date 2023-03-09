use northwind;
create view customer_view as
select customer_id ,company_name,contact_name,city
from customers;

create or replace view customer_view as
select customer_id ,company_name,contact_name,city
from customers
where city = "London";

drop view customer_view;