package com.example.demo.mapper;

import com.example.demo.dto.StoreDto;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StoreRowMapper extends AbstractEmarketRowMapper<StoreDto> {
    @Override
    public StoreDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(getColumnNameWithPrefix("id"));
        String name = rs.getString(getColumnNameWithPrefix("name"));
        float rating = calculateRating(rs);
        return new StoreDto(id, name, rating);
    }

    @Override
    protected String getPrefix() {
        return "store_";
    }
}
