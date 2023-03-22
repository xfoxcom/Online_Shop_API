package com.boev.shop.order.controller;

import com.boev.shop.order.dto.OrderDto;
import com.boev.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{title}")
    public ResponseEntity<OrderDto> makeOrder(@PathVariable String title) {
        return ResponseEntity.ok(orderService.getOrderFromUser(title));
    }
}
