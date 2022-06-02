package com.example.demo.dto;

import java.math.BigDecimal;

public record ProductOfferDto(long id, ProductDto product, StoreDto store, BigDecimal price, int amount) {
}
