package com.boev.shop.stock.entity;

import com.boev.shop.stock.dto.DiscountDto;
import jakarta.persistence.*;
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
    private long discountId;

    private int discount;

    private LocalDateTime expired;

    @OneToOne(mappedBy = "discount")
    private Product product;

    public Discount(DiscountDto discountDto) {
        discount = discountDto.getDiscount();
        expired = discountDto.getExpired();
    }
}
