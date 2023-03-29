package com.boev.shop.user.service;

import com.boev.shop.user.dto.ProductDto;
import com.boev.shop.user.dto.PurchaseDto;
import com.boev.shop.user.dto.ReviewDto;

import java.util.List;

public interface UserProductService {

    PurchaseDto makeOrderByTitle(String title);

    void makeProductReview(ReviewDto reviewDto, String name);

    void refundPurchase(long id);

    List<ProductDto> getAllProducts();
}
