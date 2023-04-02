package com.boev.shop.user.service.serviceImpl;

import com.boev.shop.user.dto.DiscountDto;
import com.boev.shop.user.dto.ProductDto;
import com.boev.shop.user.dto.PurchaseDto;
import com.boev.shop.user.dto.ReviewDto;
import com.boev.shop.user.entity.Account;
import com.boev.shop.user.exception.AccountNotFoundException;
import com.boev.shop.user.exception.NotEnoughMoneyException;
import com.boev.shop.user.exception.UserProductNotFound;
import com.boev.shop.user.repository.UserRepository;
import com.boev.shop.user.service.UserProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserProductServiceImpl implements UserProductService {

    private final RestTemplateBuilder restTemplate;

    private final UserRepository userRepository;

    private final String URL_STOCK = "http://localhost:8082/products";

    private final String URL_ORDER = "http://localhost:8083/order/{title}";

    @Override
    @Transactional
    public PurchaseDto makeOrderByTitle(String title, String username) {

        Map<String, String> params = new HashMap<>();

        params.put("title", title);

        PurchaseDto purchaseDtoResponseEntity = restTemplate.build().getForObject(URL_ORDER, PurchaseDto.class, params);

        Account account = userRepository.findByUsername(username)
                .orElseThrow(() -> new AccountNotFoundException("No account with username " + username));

        if (account.getBalance().compareTo(purchaseDtoResponseEntity.getPrice()) < 0)
            throw new NotEnoughMoneyException(title + " is too expensive for you");

        account.setBalance(account.getBalance().subtract(purchaseDtoResponseEntity.getPrice()));

        return purchaseDtoResponseEntity;
    }

    @Override
    public void makeProductReview(ReviewDto reviewDto, String username) {

        String productTitleForReview = reviewDto.getTitle();

        Account account = userRepository.findByUsername(username)
                .orElseThrow(() -> new AccountNotFoundException("No account with username " + username));

        boolean check = account.getPurchases().stream()
                .anyMatch(purchase -> purchase.getTitle().equals(productTitleForReview));

        if (check) {

            HttpEntity<ReviewDto> request = new HttpEntity<>(reviewDto);

            restTemplate.build().postForObject(URL_STOCK + "/review", request, ReviewDto.class);

        } else throw new UserProductNotFound("You have not bought it yet!");

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
