package com.example.demo.service.api;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.StoreDto;

public interface AdminService {
    int addProduct(ProductDto productDto);
    void updateProduct(long productId, ProductDto productDto);
    void deleteProduct(long productId);

    int addStore(StoreDto storeDto);
    void updateStore(long storeId, StoreDto storeDto);
    void deleteStore(long storeId);

//    boolean addProductToCart(String user, long userId, long productId, long amount);


}
