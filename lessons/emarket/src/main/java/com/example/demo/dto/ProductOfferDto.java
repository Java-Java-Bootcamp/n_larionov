package com.example.demo.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductOfferDto {
    private final ProductDto product;
    private final StoreDto store;
    private final int amount;
}
