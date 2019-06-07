1.SELECT * FROM  product 
	WHERE(SELECT id FROM type WHERE type.name = "СЫР") = product.id;
2.SELECT * from product
	WHERE(product.name LIKE 'мороженое');
3.SELECT * FROM product
	WHERE(MONTH(expired_date)=MONTH(CURDATE));
4.SELECT * FROM product
	WHERE MAX(product.price);
5.SELECT product.quantity FROM product
	WHERE (SELECT id FROM type WHERE type.name = "СЫР") = product.id;
6.SELECT * FROM product
	WHERE (SELECT id FROM type WHERE type.name = "СЫР" OR type.name = 'МОЛОКО') = product.id;
7.SELECT type.name FROM type
	WHERE(SELECT id FROM product WHERE product.quantity < 10) = type.id;
8.SELECT * FROM product,type
	WHERE product.id = type.id;
