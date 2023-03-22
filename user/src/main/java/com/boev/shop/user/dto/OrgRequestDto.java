package com.boev.shop.user.dto;

import lombok.Data;

@Data
public class OrgRequestDto {

    private String title;

    private String description;

    private byte[] logo;
}
