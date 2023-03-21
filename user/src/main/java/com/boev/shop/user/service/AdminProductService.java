package com.boev.shop.user.service;

import com.boev.shop.user.dto.ProductDto;

import java.util.List;

public interface AdminProductService {

    void addProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    void addDiscount(List<ProductDto> productDtos);

    void updateDiscount();
}
