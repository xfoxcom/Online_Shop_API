package com.boev.shop.order.service;

import com.boev.shop.order.dto.OrderDto;

public interface OrderService {

    OrderDto getOrderFromUser(String title);
}
