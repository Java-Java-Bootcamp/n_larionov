package com.example.demo.mapper;

import org.springframework.jdbc.core.RowMapper;

abstract class AbstractEmarketRowMapper<T> implements RowMapper<T> {
    public String getColumnNameWithPrefix(String columnName) {

        return getPrefix() + columnName;
    }

    protected abstract String getPrefix();
}
