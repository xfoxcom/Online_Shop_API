package com.boev.shop.user.controller;

import com.boev.shop.user.dto.*;
import com.boev.shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/notifications")
    public ResponseEntity<List<NotificationDto>> getAllNotifications(@PathVariable long id) {
        return ResponseEntity.ok(userService.getAllNotifications(id));
    }

    @GetMapping("/purchases")
    public ResponseEntity<List<PurchaseDto>> getAllPurchases(@PathVariable long id) {
        return ResponseEntity.ok(userService.getAllPurchases(id));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerNewAccount(@RequestBody UserInfo userInfo) {
        return ResponseEntity.ok(userService.registerAccount(userInfo) + " registered!");
    }

    @PostMapping("/organization")
    public ResponseEntity<Void> newOrganizationRequest(@RequestBody OrgRequestDto orgRequestDto) {
        userService.registerOrganization(orgRequestDto);
        return ResponseEntity.ok().build();
    }
}
