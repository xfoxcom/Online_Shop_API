package com.boev.shop.stock.dto;

import com.boev.shop.stock.entity.Discount;
import com.boev.shop.stock.entity.Organization;
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

    private Organization organization;

    private BigDecimal price;

    private long amount;

    private Discount discount;

    private List<String> reviews;

    private Set<String> keywords;

    private String specification;

    private int rating;
}
