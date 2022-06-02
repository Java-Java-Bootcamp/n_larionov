package com.example.demo.service.api;

import com.example.demo.dto.ProductOfferDto;

import java.util.List;

public interface EmarketService {
    List<ProductOfferDto> getProductOfferList();

    void voteForProduct(long id, int score);

    void voteForStore(long id, int score);
}
