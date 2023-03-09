use northwind;

delimiter //
create procedure findAllCustomers()
begin
select * from customers;
end //
delimiter ;

call findAllCustomers();

delimiter //
drop procedure if exists findAllCustomers //
create procedure findAllCustomers()
begin
select * from customers where customer_id = 'ANATR';
end //
delimiter ;

call findAllCustomers();
