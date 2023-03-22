package com.boev.shop.stock.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String title;

    private String description;

    private long organizationId;

    private BigDecimal price;

    private long amount;

    @OneToOne
    @JoinColumn(name = "discountId")
    private Discount discount;

    private List<String> reviews;

    private Set<String> keywords;

    private String specification;

    private int rating;
}
