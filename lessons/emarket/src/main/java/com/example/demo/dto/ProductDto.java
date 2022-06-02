package com.example.demo.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductDto {
    private final String model;
    private final String manufacturer;
    private final String description;
    private final Integer rating;
    private final Integer votes;
}
