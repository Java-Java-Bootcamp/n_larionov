package com.example.demo.mapper;

import com.example.demo.entity.StoreEntity;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StoreRowMapper extends AbstractEmarketRowMapper<StoreEntity> {
    @Override
    public StoreEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(getColumnNameWithPrefix("id"));
        String name = rs.getString(getColumnNameWithPrefix("name"));
        int score = rs.getInt(getColumnNameWithPrefix("score"));
        int votes = rs.getInt(getColumnNameWithPrefix("votes"));
        return new StoreEntity(id, name, score, votes);
    }

    @Override
    protected String getPrefix() {
        return "store_";
    }
}
