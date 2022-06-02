package com.example.demo.service.api;

import com.example.demo.dto.ProductOfferDto;

import java.util.List;
import java.util.Map;

public interface DatabaseService {
    List<ProductOfferDto> getProductOfferList();

    List<ProductOfferDto> validateCart(Map<Long, Integer> cartProductOfferIdAmount);

    void decreaseProductOfferAmount(Map<Long, Integer> cartProductOfferIdAmount);

    List<ProductOfferDto> getProductOfferInCart(Map<Long, Integer> cartProductOfferIdAmount);

    void vote(String tableName, long id, int score);


}
