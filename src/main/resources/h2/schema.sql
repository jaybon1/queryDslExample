DROP TABLE IF EXISTS ITEM;
CREATE TABLE ITEM (
    idx INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) NULL,
    discount_yn VARCHAR(1) NOT NULL DEFAULT 'N',
    price INT NOT NULL,
    discount_price INT NOT NULL,
    product_kind INT NOT NULL DEFAULT 0,
    product_maker INT NOT NULL DEFAULT 0,
    stock INT NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS PRODUCT_KIND;
CREATE TABLE PRODUCT_KIND (
    idx INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    kind_name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS PRODUCT_MAKER;
CREATE TABLE PRODUCT_MAKER (
    idx INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    maker_name VARCHAR(255) NOT NULL
);