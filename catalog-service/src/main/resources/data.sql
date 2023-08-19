INSERT INTO catalog (id, name) VALUES (1, 'NSR Organic Firm');
INSERT INTO catalog (id, name) VALUES (2, 'John Veg Matket');
INSERT INTO category (id, name,catalog_id) VALUES (100, 'Dailry & Eggs',1);
INSERT INTO category (id, name,catalog_id) VALUES (101, 'Fruits & Vegtables',1);
INSERT INTO category (id, name,catalog_id) VALUES (102, 'Honey',1);
INSERT INTO category (id, name,catalog_id) VALUES (103, 'Meats & Poultry',1);

INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1001, 'Raw Milk','Raw Milk','Raw Milk','',100);
INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1002, 'Whole Milk','Raw Milk','Raw Milk','',100);
INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1003, 'Large Pastured Eggs','Raw Milk','Raw Milk','',100);


INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1004, 'Veggie Bag','Veggie Bag Veggie Bag','Veggie Bag Veggie Bag Veggie Bag','',101);
INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1005, 'Raw Local Honey','Raw Local Honey Raw Local Honey','Raw Local HoneyRaw Local Honey','',102);


INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1006, 'Chicken Breast','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','',103);

INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1007, 'Boneless Chicken Thigh ','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','',103);
INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1008, 'Chicken Quarters ','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','',103);

INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1009, 'Chicken Drumsticks ','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','',103);

INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1010, 'Minced Chicken','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','',103);

INSERT INTO product (id, name,longName, description, largeImage, category_id) VALUES (1011, 'GOAT CUT UP','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','tray of chicken breast All Natural No Antibiotics No Added hormones No Added Steroids Zabiha Halal','',103);


/*1006's Skus*/
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10001, '2 LB',11.99,10.99,9.99,1006);
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10002, '1 LB',6.99,5.99,5.99,1006);

/*1007's Skus*/
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10003, '2 LB',11.99,10.99,9.99,1007);
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10004, '1 LB',6.99,5.99,5.99,1007);

/*1008's Skus*/
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10005, '2 LB',7.29,7.29,5.99,1008);
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10006, '1 LB',4.29,4.29,3.99,1008);

/*1004's Skus*/
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10007, '2 LB',11.99,10.99,9.99,1004);

/*1005's Skus*/
INSERT INTO sku (id, name,list_Price,sale_Price,wholesale_Price,product_id) VALUES (10008, '32 oz',18.99,17.99,15.99,1005);
