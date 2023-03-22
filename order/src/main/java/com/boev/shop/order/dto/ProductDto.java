package com.boev.shop.order.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class ProductDto {

    private String title;

    private String description;

    private long organizationId;

    private BigDecimal price;

    private long amount;

    private List<String> reviews;

    private Set<String> keywords;

    private String specification;

    private int rating;
}
