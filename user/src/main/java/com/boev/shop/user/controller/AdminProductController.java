package com.boev.shop.user.controller;

import com.boev.shop.user.dto.ProductDto;
import com.boev.shop.user.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {
    private final AdminProductService adminProductService;

    @PostMapping
    public ResponseEntity<Void> addNewProductToStock(@RequestBody ProductDto productDto) {
        adminProductService.addProduct(productDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto) {
        adminProductService.updateProduct(productDto);
        return ResponseEntity.ok().build();
    }
}
