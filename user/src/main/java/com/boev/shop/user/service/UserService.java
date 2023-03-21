package com.boev.shop.user.service;

import com.boev.shop.user.dto.NotificationDto;
import com.boev.shop.user.dto.ProductDto;
import com.boev.shop.user.dto.PurchaseDto;
import com.boev.shop.user.dto.UserInfo;

import java.util.List;

public interface UserService {

    void registerAccount(UserInfo userInfo);

    void registerOrganization();

    List<NotificationDto> getAllNotifications(long id);

    List<PurchaseDto> getAllPurchases(long id);

    void makeOrderByTitle(String title);

    List<ProductDto> getAllProducts();

    void makeProductReview(long id);

    void refundPurchase(long id);
}
