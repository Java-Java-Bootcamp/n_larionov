package com.example.demo.service.impl;

import com.example.demo.converter.EntityToDtoConverter;
import com.example.demo.dto.ProductOfferDto;
import com.example.demo.exception.CartException;
import com.example.demo.service.api.CartService;
import com.example.demo.service.api.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final Map<String, Map<Long, Integer>> carts = new HashMap<>();
    private final DatabaseService databaseService;
    private final EntityToDtoConverter converter;

    @Override
    public void addOfferToCart(String userName, Long offerId, Integer amount) {
        if (!carts.containsKey(userName)) {
            carts.put(userName, new LinkedHashMap<>());
        }
        carts.get(userName).put(offerId, amount);
    }

    @Override
    public void updateAmountOfferInCart(String userName, Long offerId, Integer delta) {
        Map<Long, Integer> cart = carts.get(userName);
        if (cart == null) {
            return;
        }
        cart.computeIfPresent(offerId, (aLong, currentAmount) -> currentAmount + delta);
    }

    @Override
    @Transactional
    public List<ProductOfferDto> checkoutUserCart(String userName) {
        Map<Long, Integer> cart = carts.get(userName);
        if (cart == null || cart.isEmpty()) {
            throw new RuntimeException("You cart is empty");
        }
        List<ProductOfferDto> invalidProductOfferDto = databaseService.validateCart(cart).stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        if (!invalidProductOfferDto.isEmpty()) {
            return invalidProductOfferDto;
        }
        databaseService.decreaseProductOfferAmount(cart);
        carts.remove(userName);
        return null;
    }

    @Override
    public void removeOfferFromCart(String userName, Long offerId) {
        if (carts.containsKey(userName)) {
            carts.get(userName).remove(offerId);
        }
        throw new CartException("Cart is empty");
    }


    @Override
    public List<ProductOfferDto> getUserCart(String userName) {
        if (carts.containsKey(userName) && !carts.get(userName).isEmpty()) {
            return databaseService.getProductOfferInCart(carts.get(userName)).stream()
                    .map(converter::convert)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
