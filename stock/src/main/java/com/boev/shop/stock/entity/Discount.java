package com.boev.shop.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long organizationId;

    private int discount;

    private LocalDateTime expired;

    private Product product;
}
