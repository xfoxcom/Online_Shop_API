package com.boev.shop.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationDto {

    private String header;

    private String body;
}
