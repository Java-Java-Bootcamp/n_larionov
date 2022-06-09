package com.example.demo.converter;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductOfferDto;
import com.example.demo.dto.StoreDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.ProductOfferEntity;
import com.example.demo.entity.StoreEntity;
import org.springframework.stereotype.Service;

@Service
public class EntityToDtoConverter {
    public ProductDto convert(ProductEntity entity) {
        float rating = entity.votes() == 0 ? 0 : ((float) entity.score()) / entity.votes();
        return new ProductDto(entity.id(), entity.name(), entity.model(), entity.manufacturer(), entity.description(), rating);
    }

    public StoreDto convert(StoreEntity entity) {
        float rating = entity.votes() == 0 ? 0 : ((float) entity.score()) / entity.votes();
        return new StoreDto(entity.id(), entity.name(), rating);
    }

    public ProductOfferDto convert(ProductOfferEntity entity) {

        return new ProductOfferDto(entity.id(), convert(entity.product()), convert(entity.store()), entity.price(), entity.amount());
    }
}


