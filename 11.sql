1.SELECT * FROM  product 
	WHERE(SELECT id FROM type WHERE type.name = "СЫР") = id;
2.SELECT * from product
	WHERE(product.name LIKE '%мороженое%');
3.select * from product
	where expiried_date between 'today' and expiried_date + interval '1 month';
4. select * from product
	where (select max(price) from product) = price;
5.select quantity from product
	where(select id from type where name='сыр')=type_id;
6. select * from product
	where (select id from type where name ='молоко') = type_id or (select id from type where name ='сыр') = type_id;
7. select name from type
	where id in (select type_id from product where quantity < 10);
8.select *,type.name from product,type
	where product.type_id = type.id;
