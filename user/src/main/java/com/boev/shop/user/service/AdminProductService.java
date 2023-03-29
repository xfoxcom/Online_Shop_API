package com.boev.shop.user.service;

import com.boev.shop.user.dto.DiscountDto;
import com.boev.shop.user.dto.ProductDto;

import java.util.List;

public interface AdminProductService {

    void addProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    void addDiscount(DiscountDto discountDto);

    void updateDiscount();
}
