package com.example.demo.service.impl;

import com.example.demo.converter.EntityToDtoConverter;
import com.example.demo.dto.ProductOfferDto;
import com.example.demo.service.api.DatabaseService;
import com.example.demo.service.api.EmarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmarketServiceImpl implements EmarketService {
    private final DatabaseService databaseService;
    private final EntityToDtoConverter converter;

    @Override
    public List<ProductOfferDto> getProductOfferList() {
        return databaseService.getProductOfferList().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
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
