package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper extends  AbstractEmarketRowMapper<ProductEntity> {
    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(getColumnNameWithPrefix("id"));
        String name = rs.getString(getColumnNameWithPrefix("name"));
        String model = rs.getString(getColumnNameWithPrefix("model"));
        String manufacturer = rs.getString(getColumnNameWithPrefix("manufacturer"));
        String description = rs.getString(getColumnNameWithPrefix("description"));
        int score = rs.getInt(getColumnNameWithPrefix("score"));
        int votes = rs.getInt(getColumnNameWithPrefix("votes"));
        return new ProductEntity(id, name, model, manufacturer, description, score, votes);
    }

    @Override
    protected String getPrefix() {
        return "product_";
    }
}
