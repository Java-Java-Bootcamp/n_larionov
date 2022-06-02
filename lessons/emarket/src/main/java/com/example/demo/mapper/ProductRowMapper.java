package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper extends  AbstractEmarketRowMapper<ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(getColumnNameWithPrefix("id"));
        String name = rs.getString(getColumnNameWithPrefix("name"));
        String model = rs.getString(getColumnNameWithPrefix("model"));
        String manufacturer = rs.getString(getColumnNameWithPrefix("manufacturer"));
        String description = rs.getString(getColumnNameWithPrefix("description"));
        float rating = calculateRating(rs);
        return new ProductDto(id, name, model, manufacturer, description, rating);
    }

    @Override
    protected String getPrefix() {
        return "product_";
    }
}
