package com.boev.shop.user.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiscountDto {

    private int discount;

    private LocalDateTime expired;

    private List<String> titles;
}
