package com.boev.shop.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;

    private String header;

    private LocalDate sendDate;

    private String body;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
}
