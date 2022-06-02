package com.example.demo.service;

public interface InternalService {
    void addProduct(String Model, String manufacturer,String description,
                    int votes,int rating);
    void addStore(String name, int rating,int votes);

//    boolean addProductToCart(String user, long userId, long productId, long amount);


}
