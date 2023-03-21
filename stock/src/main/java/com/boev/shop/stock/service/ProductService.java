package com.boev.shop.stock.service;

import com.boev.shop.stock.dto.ProductDto;

import java.util.List;

public interface ProductService {

    void addNewProduct(ProductDto productDto);

    void updateProduct(long id, ProductDto productDto);

    List<ProductDto> getAllAvailableProducts();
}
