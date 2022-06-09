package com.example.demo.mapper;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.ProductOfferEntity;
import com.example.demo.entity.StoreEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class ProductOfferRowMapper extends AbstractEmarketRowMapper<ProductOfferEntity> {
    private final ProductRowMapper productRowMapper;
    private final StoreRowMapper storeRowMapper;


    @Override
    public ProductOfferEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt(getColumnNameWithPrefix("id"));
        int amount = rs.getInt(getColumnNameWithPrefix("quantity"));
        int productId = rs.getInt(getColumnNameWithPrefix("product_id"));
        int storeId = rs.getInt(getColumnNameWithPrefix("store_id"));
        BigDecimal price = new BigDecimal(rs.getString(getColumnNameWithPrefix("price")));
        ProductEntity productEntity = productRowMapper.mapRow(rs, rowNum);
        StoreEntity storeEntity = storeRowMapper.mapRow(rs, rowNum);
        return new ProductOfferEntity(id, productId, storeId, productEntity, storeEntity, price, amount);
    }

    @Override
    protected String getPrefix() {
        return "product_offer_";
    }
}
