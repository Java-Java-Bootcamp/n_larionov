package com.example.demo.service;

import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Data
@Service

public class InternalServiceImpl implements InternalService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void addProduct(String model, String manufacturer,String description,
                           int votes,int rating) {
        jdbcTemplate.update("INSERT INTO product(model,manufacturer,description,rating,votes) VALUES(?,?,?,?,?)", model,manufacturer,description,rating,votes);
    }
    @Override
    public void addStore(String name, int votes,int rating) {
        jdbcTemplate.update("INSERT INTO store(name ,rating,votes) VALUES(?,?,?)", name,rating,votes);
    }
}
