package com.boev.shop.user.controller;

import com.boev.shop.user.dto.NotificationDto;
import com.boev.shop.user.dto.PurchaseDto;
import com.boev.shop.user.dto.UserInfo;
import com.boev.shop.user.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable long id) {
        return ResponseEntity.ok(adminUserService.getUserInfo(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PurchaseDto>> getAllUsersPurchases(@PathVariable long id) {
        return ResponseEntity.ok(adminUserService.getAllUsersPurchasesById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> sendNotification(@PathVariable long id, @RequestBody NotificationDto notificationDto) {
        adminUserService.sendNotification(id, notificationDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> addMoneyToAccount(@PathVariable long id, @RequestParam String amount) {
        adminUserService.addMoneyToBalance(id, amount);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> disableAccount(@PathVariable long id) {
        adminUserService.disableAccount(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id) {
        adminUserService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
