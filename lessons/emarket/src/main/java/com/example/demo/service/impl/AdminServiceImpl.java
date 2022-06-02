package com.example.demo.service.impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.StoreDto;
import com.example.demo.exception.AdminException;
import com.example.demo.service.api.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final static String INSERT_PRODUCT = "INSERT INTO product(name, model,manufacturer,description)\n" +
            "VALUES(:name, :model, :manufacturer, :description) ON CONFLICT DO NOTHING;";
    private final static String UPDATE_PRODUCT = "UPDATE product SET name=:name, model=:model," +
            "manufacturer=:manufacturer,description=:description WHERE id=:id;";
    private final static String DELETE_PRODUCT_OFFER_BY_PRODUCT_ID = "DELETE FROM product_offer WHERE product_id=:id;";
    private final static String DELETE_PRODUCT = "DELETE FROM product WHERE id=:id;";
    private final static String INSERT_STORE = "INSERT INTO store(name) VALUES(:name) ON CONFLICT DO NOTHING;";

    private final static String UPDATE_STORE = "UPDATE store SET name=:name WHERE id=:id;";
    private final static String DELETE_PRODUCT_OFFER_BY_STORE_ID = "DELETE FROM product_offer WHERE store_id=:id;";
    private final static String DELETE_STORE = "DELETE FROM store WHERE id=:id;";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public int addProduct(ProductDto productDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("name", productDto.name())
                .addValue("model", productDto.model())
                .addValue("manufacturer", productDto.manufacturer())
                .addValue("description", productDto.description());
        jdbcTemplate.update(INSERT_PRODUCT, sps, keyHolder);
        if (keyHolder.getKeys() == null || keyHolder.getKeys().get("id") == null) {
            throw new AdminException("In table exist duplicate of product");
        }
        return (int) keyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateProduct(long productId, ProductDto productDto) {
        final SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("name", productDto.name())
                .addValue("model", productDto.model())
                .addValue("manufacturer", productDto.manufacturer())
                .addValue("description", productDto.description())
                .addValue("id", productId);
        if (jdbcTemplate.update(UPDATE_PRODUCT, sps) == 0) {
            throw new AdminException(String.format("Product with this id=%s out of table", productId));
        }
    }

    @Override
    @Transactional
    public void deleteProduct(long productId) {
        final SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("id", productId);
        jdbcTemplate.update(DELETE_PRODUCT_OFFER_BY_PRODUCT_ID, sps);
        if (jdbcTemplate.update(DELETE_PRODUCT, sps) == 0) {
            throw new AdminException(String.format("Product with id=%s absent in table", productId));
        }
    }

    @Override
    public int addStore(StoreDto storeDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("name", storeDto.name());
        jdbcTemplate.update(INSERT_STORE, sps, keyHolder);
        if (keyHolder.getKeys() == null || keyHolder.getKeys().get("id") == null) {
            throw new AdminException("In table exist store with same name ");
        }
        return (int) keyHolder.getKeys().get("id");
    }

    @Override
    public void updateStore(long storeId, StoreDto storeDto) {
        final SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("name", storeDto.name())
                .addValue("id", storeId);

        if (jdbcTemplate.update(UPDATE_STORE, sps) == 0) {
            throw new AdminException("In table exist store with same name");
        }
    }

    @Override
    public void deleteStore(long storeId) {
        final SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("id", storeId);
        jdbcTemplate.update(DELETE_PRODUCT_OFFER_BY_STORE_ID, sps);
        if (jdbcTemplate.update(DELETE_STORE, sps) == 0) {
            throw new AdminException(String.format("Store with id=%s absent in table", storeId));
        }
    }
}
