package com.boev.shop.user.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserInfo {

    private String username;

    private String email;

    private String password;

    private BigDecimal balance;
}
