package com.boev.shop.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    private String username;

    private String email;

    private String password;

    private BigDecimal balance;

    private boolean isEnable;

    private String roles;

    @OneToMany
    @JoinColumn(name = "account")
    @Fetch(FetchMode.SUBSELECT)
    private List<Purchase> purchases;

    @OneToMany
    @JoinColumn(name = "account")
    @Fetch(FetchMode.SUBSELECT)
    private List<Notification> notifications;

    private Set<String> organizations;

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }
}
