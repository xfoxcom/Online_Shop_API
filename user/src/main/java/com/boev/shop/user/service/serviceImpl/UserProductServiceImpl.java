package com.boev.shop.user.service.serviceImpl;

import com.boev.shop.user.dto.ProductDto;
import com.boev.shop.user.dto.PurchaseDto;
import com.boev.shop.user.service.UserProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserProductServiceImpl implements UserProductService {

    private final RestTemplateBuilder restTemplate;

    private final String URL_STOCK = "http://localhost:8082/products";

    private final String URL_ORDER = "http://localhost:8083/order/{title}";

    @Override
    public PurchaseDto makeOrderByTitle(String title) {

        Map<String, String> params = new HashMap<>();

        params.put("title", title);

        return restTemplate.build().getForObject(URL_ORDER, PurchaseDto.class, params);
    }

    @Override
    public void makeProductReview(long id) {

    }

    @Override
    public void refundPurchase(long id) {

    }

    @Override
    public List<ProductDto> getAllProducts() {

        ProductDto[] productDtos = restTemplate.build().getForEntity(URL_STOCK, ProductDto[].class).getBody();

        if (productDtos == null) return List.of();

        return List.of(productDtos);
    }
}
