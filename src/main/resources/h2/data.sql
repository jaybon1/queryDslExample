INSERT INTO
    `PRODUCT_KIND` (`kind_name`)
VALUES
    ('아이스크림'),
    ('과자'),
    ('라면');

INSERT INTO
    `PRODUCT_MAKER` (`maker_name`)
VALUES
    ('해태'),
    ('롯데'),
    ('농심'),
    ('팔도');

INSERT INTO
    `ITEM` (`item_name`, `discount_yn`, `price`, `discount_price`, `product_kind`, `product_maker`, `stock`)
VALUES
    ('누가바', 'N', 1000, 500, 1, 1, 9),
    ('폴라포', 'Y', 1000, 500, 1, 1, 25),
    ('부라보콘', 'N', 1500, 1000, 1, 1, 15),

    ('죠스바', 'N', 1000, 500, 1, 2, 12),
    ('스크류바', 'N', 1000, 500, 1, 2, 16),
    ('월드콘', 'Y', 1500, 1000, 1, 2, 7),

    ('새우깡', 'N', 1100, 700, 2, 3, 5),
    ('오징어집', 'N', 1100, 800, 2, 3, 8),
    ('포스틱', 'Y', 1100, 900, 2, 3, 15),

    ('꼬깔콘', 'N', 900, 600, 2, 2, 9),
    ('콘칲', 'Y', 1000, 800, 2, 2, 20),
    ('치토스', 'N', 1100, 900, 2, 2, 6),

    ('신라면', 'N', 850, 480, 3, 3, 21),
    ('짜파게티', 'N', 900, 600, 3, 3, 25),
    ('너구리', 'Y', 850, 550, 3, 3, 51),

    ('해물라면', 'Y', 900, 510, 3, 4, 49),
    ('팔도비빔면', 'N', 750, 600, 3, 4, 16),
    ('참깨라면', 'N', 800, 550, 3, 4, 23),

    (null, 'Y', 900, 510, 1, 2, 0),
    (null, 'N', 750, 600, 2, 1, 0),
    (null, 'N', 800, 550, 3, 4, 0);



