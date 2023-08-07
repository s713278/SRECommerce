INSERT INTO catalog (id, name) VALUES (1, 'NSR Organic Firm');
INSERT INTO category (id, name,catalog_id) VALUES (100, 'Dairy Products',1);
INSERT INTO category (id, name,catalog_id) VALUES (101, 'Fruits Fruits',1);
INSERT INTO category (id, name,catalog_id) VALUES (102, 'Pulses(Chemical Free)',1);
INSERT INTO category (id, name,catalog_id) VALUES (103, 'Fresh Vegtables',1);
INSERT INTO category (id, name,catalog_id) VALUES (104, 'Bakery Items & Breads',1);

INSERT INTO product (id, name,category_id) VALUES (1001, 'Cow Milk',100);
INSERT INTO product (id, name,category_id) VALUES (1002, 'Buffalo Milk',100);
INSERT INTO product (id, name,category_id) VALUES (1003, 'Desi Donedar Ghee',100);
INSERT INTO product (id, name,category_id) VALUES (1004, 'Buffalo Ghee',100);
INSERT INTO product (id, name,category_id) VALUES (1005, 'Thaza Paneer',100);
INSERT INTO product (id, name,category_id) VALUES (1006, 'Homestyle Curd',100);

INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10001, 'Buffalo Milk-1/2 Litre',48.00,42.00,38.00,1002);
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10002, 'Buffalo Milk-1 Litre',94.00,82.00,75.00,1002);
