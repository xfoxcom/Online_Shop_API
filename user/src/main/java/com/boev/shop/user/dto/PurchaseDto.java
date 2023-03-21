package com.boev.shop.user.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PurchaseDto {

    private String title;

    private LocalDateTime dateOfPurchase;
}
