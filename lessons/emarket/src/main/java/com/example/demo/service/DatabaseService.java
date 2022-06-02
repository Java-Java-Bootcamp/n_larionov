package com.example.demo.service;

import com.example.demo.dto.ProductOfferDto;

import java.util.List;

public interface DatabaseService {
    List<ProductOfferDto> getProductOffers();

}
