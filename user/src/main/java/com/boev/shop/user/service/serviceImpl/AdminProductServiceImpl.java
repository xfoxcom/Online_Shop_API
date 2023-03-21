package com.boev.shop.user.service.serviceImpl;

import com.boev.shop.user.dto.ProductDto;
import com.boev.shop.user.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {

    private final RestTemplateBuilder restTemplate;

    private final String url = "http://localhost:8082/products";

    @Override
    public void addProduct(ProductDto productDto) {

        HttpEntity<ProductDto> request = new HttpEntity<>(productDto);

        restTemplate.build().postForObject(url, request, ProductDto.class);
    }

    @Override
    public void updateProduct(ProductDto productDto) {

        HttpEntity<ProductDto> request = new HttpEntity<>(productDto);

        restTemplate.build().postForObject(url, request, ProductDto.class);

    }

    @Override
    public void addDiscount(List<ProductDto> productDtos) {

    }

    @Override
    public void updateDiscount() {

    }
}
