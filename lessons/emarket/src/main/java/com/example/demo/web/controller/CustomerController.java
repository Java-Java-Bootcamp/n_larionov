package com.example.demo.web.controller;

import com.example.demo.dto.ProductOfferDto;
import com.example.demo.service.api.CartService;
import com.example.demo.service.api.EmarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/api")
@RequiredArgsConstructor
public class CustomerController {
    private final CartService cartService;
    private final EmarketService emarketService;

    // catalog and vote api

    @GetMapping("/catalog")
    public List<ProductOfferDto> getProductOffers() {
        return emarketService.getProductOfferList();
    }

    @PutMapping("/vote/store")
    public ResponseEntity<Object> storeVote(@RequestParam("id") long storeId, @RequestParam("score") int score) {
        emarketService.voteForStore(storeId, score);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/vote/product")
    public ResponseEntity<Object> productVote(@RequestParam("id") long productId, @RequestParam("score") int score) {
        emarketService.voteForProduct(productId, score);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    //Cart api

    @PutMapping("/cart/{userName}/{productOfferId}")
    public ResponseEntity<Object> addProductToCart(@PathVariable("userName") String userName,
                                                   @PathVariable("productOfferId") long productOfferId,
                                                   @RequestParam("amount") int amount) {
        cartService.addOfferToCart(userName, productOfferId, amount);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping("/cart/{userName}/{productOfferId}")
    public ResponseEntity<Object> updateAmountOfProductInCart(@PathVariable("userName") String userName,
                                            @PathVariable("productOfferId") long productOfferId,
                                            @RequestParam("amount") int delta) {
        cartService.updateAmountOfferInCart(userName, productOfferId, delta);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/cart/{userName}/{productOfferId}")
    public ResponseEntity<Object> removeProductFromCart(@PathVariable("userName") String userName,
                                                        @PathVariable("productOfferId") long productOfferId) {
        cartService.removeOfferFromCart(userName, productOfferId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/cart/{userName}")
    public List<ProductOfferDto> getUserCart(@PathVariable("userName") String userName) {
        return cartService.getUserCart(userName);
    }

    @PostMapping("/cart/{userName}/checkout")
    public ResponseEntity<Object> userCartCheckout(@PathVariable("userName") String userName) {
        userCartCheckout(userName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
