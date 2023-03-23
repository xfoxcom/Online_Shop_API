package com.boev.shop.user.service;

import com.boev.shop.user.dto.*;

import java.util.List;

public interface UserService {

    String registerAccount(UserInfo userInfo);

    void registerOrganization(OrgRequestDto orgRequestDto);

    List<NotificationDto> getAllNotifications(long id);

    List<PurchaseDto> getAllPurchases(long id);
}
