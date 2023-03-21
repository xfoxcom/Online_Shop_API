package com.boev.shop.user.dto;

import com.boev.shop.stock.entity.Organization;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class ProductDto {

    private String title;

    private String description;

    private Organization organization;

    private BigDecimal price;

    private long amount;

    private Set<String> keywords;

    private String specification;
}
