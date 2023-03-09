use northwind;
select * from customers
where contact_name ='Aria Cruz';

explain select * from customers
where contact_name ='Aria Cruz';

alter table customers add index idx_customerName(contact_name);

alter table customers add index idx_full_name(company_name,contact_name);

explain select * from customers 
where company_name = 'Simons bistro' or company_name ='Split Rail Beer & Ale';

alter table customers drop index idx_full_name;


