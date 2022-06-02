package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductOfferDto;
import com.example.demo.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class ProductOfferRowMapper extends AbstractEmarketRowMapper<ProductOfferDto> {
    private final ProductRowMapper productRowMapper;
    private final StoreRowMapper storeRowMapper;


    @Override
    public ProductOfferDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(getColumnNameWithPrefix("id"));
        int amount = rs.getInt(getColumnNameWithPrefix("quantity"));
        BigDecimal price = new BigDecimal(rs.getString(getColumnNameWithPrefix("price")));
        ProductDto productDto = productRowMapper.mapRow(rs, rowNum);
        StoreDto storeDto = storeRowMapper.mapRow(rs, rowNum);
        return new ProductOfferDto(id, productDto, storeDto, price, amount);
    }

    @Override
    protected String getPrefix() {
        return "product_offer_";
    }
}
