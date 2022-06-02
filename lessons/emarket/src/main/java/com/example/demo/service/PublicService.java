package com.example.demo.service;

public interface PublicService {
    void addOfferToCart(String userName, Long offerId, Integer amount);
    void updateCart(String userName, Long offerId, Integer amount);
    void checkoutCart(String userName);
    void removeOfferFromChart(String userName, Long offerId);
    List<ProductOffer> getProductOfferList(); //TODO: Need Extend by filtering

}
