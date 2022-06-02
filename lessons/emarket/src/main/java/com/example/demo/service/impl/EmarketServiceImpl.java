package com.example.demo.service.impl;

import com.example.demo.dto.ProductOfferDto;
import com.example.demo.service.api.DatabaseService;
import com.example.demo.service.api.EmarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmarketServiceImpl implements EmarketService {
    private final DatabaseService databaseService;

    @Override
    public List<ProductOfferDto> getProductOfferList() {
        return databaseService.getProductOfferList();
    }

    @Override
    public void voteForProduct(long id, int score) {
        databaseService.vote("product", id, score);
    }

    @Override
    public void voteForStore(long id, int score) {
        databaseService.vote("store", id, score);
    }
}
