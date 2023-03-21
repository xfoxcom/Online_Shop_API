package com.boev.shop.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long purchaseId;

    private String title;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    private LocalDateTime dateOfPurchase;
}
