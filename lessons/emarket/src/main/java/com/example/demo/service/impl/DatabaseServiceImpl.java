package com.example.demo.service.impl;

import com.example.demo.dto.ProductOfferDto;
import com.example.demo.entity.ProductOfferEntity;
import com.example.demo.exception.NotFoundEmarketException;
import com.example.demo.mapper.ProductOfferRowMapper;
import com.example.demo.service.api.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {
    public static final String SELECT_PRODUCT_OFFER_ID = "select id from product_offer where id = %d and quantity < %d";
    public static final String UNION = "\nunion\n";
    public static final String UPDATE_PRODUCT_OFFER_AMOUNT = "update product_offer set amount = amount - ? where id = ?";
    public static final String NOT_FOUND_ROW_FORE_UPDATE_RATING_MESSAGE = "Not found row fore update rating inside %s table by id = %d";
    private final static String GET_PRODUCT_OFFER = "select po.id as product_offer_id, \n" +
            "po.quantity as product_offer_quantity, po.price as product_offer_price, po.product_id, p.name as product_name,\n" +
            "p.model as product_model, p.manufacturer as product_manufacturer, p.description as product_description,\n" +
            "p.score as product_score, p.votes as product_votes, po.store_id, s.name as store_name, \n" +
            "s.score as store_score, s.votes as store_votes\n" +
            "from product_offer po\n" +
            "join product p on p.id = po.product_id\n" +
            "join store s on s.id = po.store_id";
    private final static String GET_PRODUCTOFFER_BY_IDS = GET_PRODUCT_OFFER + "\n" +
            "where po.id in (?)";
    private final static String UPDATE_VOTE = "update %s set score = score + %d, votes = votes + 1 where id = %d";
    private final JdbcTemplate jdbcTemplate;
    private final ProductOfferRowMapper rowMapper;

    @Override
    public List<ProductOfferEntity> getProductOfferList() {
        return jdbcTemplate.query(GET_PRODUCT_OFFER, rowMapper);
    }

    @Override
    @Transactional
    public List<ProductOfferEntity> validateCart(Map<Long, Integer> cartProductOfferIdAmount) {
        String sql = cartProductOfferIdAmount.entrySet().stream()
                .map(entry -> String.format(SELECT_PRODUCT_OFFER_ID, entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(UNION));
        List<Long> productOfferIds = jdbcTemplate.queryForList(sql, Long.class);
        return jdbcTemplate.query(GET_PRODUCTOFFER_BY_IDS, rowMapper, productOfferIds);
    }

    @Override
    @Transactional
    public void decreaseProductOfferAmount(Map<Long, Integer> cartProductOfferIdAmount) {
        final List<Map.Entry<Long, Integer>> entries = cartProductOfferIdAmount.entrySet().stream().toList();

        jdbcTemplate.batchUpdate(UPDATE_PRODUCT_OFFER_AMOUNT,
                new BatchPreparedStatementSetter() {

                    public void setValues(PreparedStatement ps, int i)
                            throws SQLException {
                        ps.setInt(1, entries.get(i).getValue());
                        ps.setLong(2, entries.get(i).getKey());
                    }
                    public int getBatchSize() {
                        return entries.size();
                    }

                });
    }

    @Override
    public List<ProductOfferEntity> getProductOfferInCart(Map<Long, Integer> cartProductOfferIdAmount) {
        return jdbcTemplate.query(GET_PRODUCTOFFER_BY_IDS, rowMapper, cartProductOfferIdAmount.keySet()).stream()
                .filter(productOfferEntity -> cartProductOfferIdAmount.containsKey(productOfferEntity.id()))
                .map(productOfferEntity -> {
                    Integer amount = cartProductOfferIdAmount.get(productOfferEntity.id());
                    if (amount < productOfferEntity.amount()) {
                       return new ProductOfferEntity(productOfferEntity.id(), productOfferEntity.productId(),
                               productOfferEntity.storeId(), productOfferEntity.product(), productOfferEntity.store(),
                               productOfferEntity.price(), productOfferEntity.amount());
                    } else {
                        return productOfferEntity;
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void vote(String tableName, long id, int score) {
        if (jdbcTemplate.update(String.format(UPDATE_VOTE, tableName, score, id)) == 0) {
            throw new NotFoundEmarketException(String.format(NOT_FOUND_ROW_FORE_UPDATE_RATING_MESSAGE, tableName, id));
        }

    }
}