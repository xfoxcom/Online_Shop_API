package com.boev.shop.user.controller;

import com.boev.shop.user.dto.ProductDto;
import com.boev.shop.user.dto.PurchaseDto;
import com.boev.shop.user.dto.ReviewDto;
import com.boev.shop.user.service.UserProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class UserProductController {

    private final UserProductService userProductService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(userProductService.getAllProducts());
    }

    @GetMapping("/{title}")
    public ResponseEntity<PurchaseDto> makeOrder(@PathVariable String title, Principal principal) {
        return ResponseEntity.ok(userProductService.makeOrderByTitle(title, principal.getName()));
    }

    @PostMapping
    public ResponseEntity<Void> makeReview(@RequestBody ReviewDto reviewDto, Principal principal) {
        userProductService.makeProductReview(reviewDto, principal.getName());
        return ResponseEntity.ok().build();
    }
}
