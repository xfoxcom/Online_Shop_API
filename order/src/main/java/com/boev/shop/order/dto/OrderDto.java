package com.boev.shop.order.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDto {

    private String title;

    private LocalDateTime dateOfPurchase;
}
