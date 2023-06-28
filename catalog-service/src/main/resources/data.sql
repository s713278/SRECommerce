INSERT INTO catalog (id, name) VALUES (1, 'NSR Firm');
INSERT INTO category (id, name,catalog_id) VALUES (100, 'Dairy Products',1);
INSERT INTO category (id, name,catalog_id) VALUES (101, 'Fruits & Vegtables',1);
INSERT INTO product (id, name,category_id) VALUES (1001, 'Cow Milk',100);
INSERT INTO product (id, name,category_id) VALUES (1002, 'Buffalo Milk',100);

INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10001, 'Buffalo Milk-1/2 Litre',48.00,42.00,38.00,1002);
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10002, 'Buffalo Milk-1 Litre',94.00,82.00,75.00,1002);
