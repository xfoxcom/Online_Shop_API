package com.boev.shop.stock.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long organizationId;

    private String title;

    private String description;

    private byte[] logo;

    @OneToMany
    @JoinColumn(name = "organization")
    private Set<Product> products;
}
