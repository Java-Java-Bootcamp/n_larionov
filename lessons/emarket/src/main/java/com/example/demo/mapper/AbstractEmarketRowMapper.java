package com.example.demo.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

abstract class AbstractEmarketRowMapper<T> implements RowMapper<T> {
    public float calculateRating(ResultSet rs) throws SQLException {
        int votes = rs.getInt(getColumnNameWithPrefix("votes"));
        if (votes == 0) {
            return 0;
        }
        long score = rs.getLong(getColumnNameWithPrefix("score"));
        return ((float) score) / votes;
    }

    public String getColumnNameWithPrefix(String columnName) {

        return getPrefix() + columnName;
    }

    protected abstract String getPrefix();
}
