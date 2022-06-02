package com.example.demo.service;

import com.example.demo.dto.ProductOfferDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@RequiredArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<ProductOfferDto> getProductOffers() {
         return jdbcTemplate.query("select quantity,\n" +
                 "p.model, p.manufacturer, p.description, p.rating as productRaiting," +
                 " p.votes as productVotes, s.name, s.rating as storeRaiting, s.votes as storeVotes\n" +
                 "from emarket.product_offer po\n" +
                 "join emarket.product p on p.id = po.product_id\n" +
                 "join emarket.store s on s.id = po.store_id", ) //TODO: написать rowMapper
    }
}
