package com.boev.shop.user.service;

import com.boev.shop.user.dto.NotificationDto;
import com.boev.shop.user.dto.PurchaseDto;
import com.boev.shop.user.dto.UserInfo;

import java.util.List;

public interface AdminUserService {

    void addMoneyToBalance(long id, String amount);

    List<PurchaseDto> getAllUsersPurchasesById(long id);

    void sendNotification(long id, NotificationDto notificationDto);

    UserInfo getUserInfo(long id);

    void deleteAccount(long id);

    void disableAccount(long id);
}
