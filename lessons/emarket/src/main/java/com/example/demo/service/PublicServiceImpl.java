package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

public class PublicServiceImpl implements PublicService {

    private final Map<String, Map<Long,Integer>> carts = new HashMap<>();

    @Override
    public void addOfferToCart(String userName, Long offerId, Integer amount) {

    }

    @Override
    public void updateCart(String userName, Long offerId, Integer amount) {

    }

    @Override
    public void checkoutCart(String userName) {

    }

    @Override
    public void removeOfferFromChart(String userName, Long offerId) {

    }

    @Override
    public List<ProductOffer> getProductOfferList() {
        return null;
    }
}
