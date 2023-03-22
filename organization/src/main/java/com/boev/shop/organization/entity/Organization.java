package com.boev.shop.organization.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long organizationId;

    private String title;

    private String description;

    private byte[] logo;

    private boolean isEnable;

    private Set<Long> productId;
}
