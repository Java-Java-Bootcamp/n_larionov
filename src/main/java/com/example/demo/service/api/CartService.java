package com.example.demo.service.api;

import com.example.demo.dto.ProductOfferDto;

import java.util.List;

public interface CartService {
    void addOfferToCart(String userName, Long offerId, Integer amount);

    void updateAmountOfferInCart(String userName, Long offerId, Integer delta);

    void removeOfferFromCart(String userName, Long offerId);

    List<ProductOfferDto> getUserCart(String userName);

    List<ProductOfferDto> checkoutUserCart(String userName);

}
