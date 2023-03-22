package com.boev.shop.order.service.serviceImpl;

import com.boev.shop.order.dto.OrderDto;
import com.boev.shop.order.dto.ProductDto;
import com.boev.shop.order.entity.Order;
import com.boev.shop.order.exception.ProductNotFound;
import com.boev.shop.order.repository.OrderRepository;
import com.boev.shop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RestTemplateBuilder restTemplate;

    private final String URL = "http://localhost:8082/products/{title}";

    private final OrderRepository orderRepository;

    @Override
    public OrderDto getOrderFromUser(String title) {

        Map<String, String> params = new HashMap<>();

        params.put("title", title);

        try {

            restTemplate.build()
                    .getForEntity(URL, ProductDto.class, params);

        } catch (Exception e) {

            throw new ProductNotFound("No product with title " + title);

        }

        Order order = Order.builder()
                .title(title)
                .dateOfPurchase(LocalDateTime.now())
                .build();

        orderRepository.save(order);

        return OrderDto.builder()
                .title(title)
                .dateOfPurchase(LocalDateTime.now())
                .build();
    }
}
