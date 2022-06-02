CREATE TABLE product_offer (quantity int, product_id int, store_id int,
                            PRIMARY KEY (product_id, store_id),
                            CONSTRAINT fk_store FOREIGN KEY(store_id) REFERENCES store(id),
                            CONSTRAINT fk_product FOREIGN KEY(product_id) REFERENCES product(id));