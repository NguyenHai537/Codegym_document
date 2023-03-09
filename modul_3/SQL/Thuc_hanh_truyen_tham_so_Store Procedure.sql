use northwind;

delimiter //
create procedure getCusID ( in cusID varchar(10))
begin
select * from customers where customer_id = cusID;
end //
delimiter ;

call getCusID("BOTTM");

delimiter //
create procedure getCusCountByCity( in in_city varchar(50), out total int)
begin
select count(customer_id)
into total
from customers
where city = in_city;
end //
delimiter ;
drop procedure getCusCountByCity;

call getCusCountByCity("London",@total);

select count(customer_id)

from customers
where city = "London";

select @total;

delimiter //
create procedure Setcity( inout CT varchar(50), in inct varchar(50))
begin
set CT = concat(CT , inct);
end //
delimiter ;

drop procedure Setcity;
set@CT = "Tphcm";
call Setcity(@CT, "PhuNhuan");
call Setcity(@CT, "21KNguyenVantroi");
select @CT;
