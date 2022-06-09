package com.example.demo.service.api;

import com.example.demo.dto.ProductOfferDto;
import com.example.demo.entity.ProductOfferEntity;

import java.util.List;
import java.util.Map;

public interface DatabaseService {
    List<ProductOfferEntity> getProductOfferList();

    List<ProductOfferEntity> validateCart(Map<Long, Integer> cartProductOfferIdAmount);

    void decreaseProductOfferAmount(Map<Long, Integer> cartProductOfferIdAmount);

    List<ProductOfferEntity> getProductOfferInCart(Map<Long, Integer> cartProductOfferIdAmount);

    void vote(String tableName, long id, int score);


}
