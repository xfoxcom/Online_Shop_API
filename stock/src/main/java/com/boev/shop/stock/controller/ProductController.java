package com.boev.shop.stock.controller;

import com.boev.shop.stock.dto.ProductDto;
import com.boev.shop.stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{title}")
    public ResponseEntity<ProductDto> getProductByTitle(@PathVariable String title) {
        return ResponseEntity.ok(productService.getProductByTitle(title));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllAvailableProducts() {
        return ResponseEntity.ok(productService.getAllAvailableProducts());
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8081/admin")
    public ResponseEntity<Void> addNewProductToStock(@RequestBody ProductDto productDto) {
        productService.addNewProduct(productDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8081/admin")
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @RequestBody ProductDto productDto) {
        productService.updateProduct(id, productDto);
        return ResponseEntity.ok().build();
    }
}
