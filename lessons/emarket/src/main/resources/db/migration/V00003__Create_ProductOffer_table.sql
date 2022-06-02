CREATE TABLE product_offer
(
    id         serial PRIMARY KEY,
    quantity   int   NOT NULL DEFAULT 0,
    price      money NOT NULL DEFAULT 0.00,
    product_id int,
    store_id   int,
    CONSTRAINT fk_store FOREIGN KEY (store_id) REFERENCES store (id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (id)
);