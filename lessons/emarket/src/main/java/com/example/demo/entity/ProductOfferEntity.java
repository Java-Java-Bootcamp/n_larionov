package com.example.demo.entity;

import java.math.BigDecimal;

public record ProductOfferEntity(long id, long productId, long storeId, ProductEntity product, StoreEntity store, BigDecimal price, int amount) {
}
