package com.example.demo.controller;

import com.example.demo.service.InternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api")
@RequiredArgsConstructor
public class AdminController {
    private final InternalService internalService;

    @PostMapping("/add/products")
    public void addProduct(@RequestParam(name = "model") String model,
                        @RequestParam(name = "manufacturer") String manufacturer,
                        @RequestParam(name = "description") String description,
                        @RequestParam(name = "votes") int votes,
                        @RequestParam(name = "rating") int rating) {
        internalService.addProduct(model, manufacturer, description, votes, rating);
    }
    // add new product to the product list by store
    @PostMapping("/add/product")
    public void addProduct() {
        internalService.addProduct("test", "test", "test", 1, 1);
    }
    // add new store to the store list by marketplace administrator
    @PostMapping("/add/store")
    public void addStore() {
        internalService.addStore("yandex",4,1);
    }
}




