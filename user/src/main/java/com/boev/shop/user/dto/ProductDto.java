package com.boev.shop.user.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class ProductDto {

    private String title;

    private String description;

    private BigDecimal price;

    private long amount;

    private Set<String> keywords;

    private String specification;
}
