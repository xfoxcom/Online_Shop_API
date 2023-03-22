package com.boev.shop.organization.dto;

import lombok.Data;

@Data
public class OrgRequestDto {

    private String title;

    private String description;

    private byte[] logo;
}
