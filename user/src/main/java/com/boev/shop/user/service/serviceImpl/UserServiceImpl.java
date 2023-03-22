package com.boev.shop.user.service.serviceImpl;

import com.boev.shop.user.dto.*;
import com.boev.shop.user.entity.Notification;
import com.boev.shop.user.entity.Account;
import com.boev.shop.user.entity.Purchase;
import com.boev.shop.user.exception.AccountNotFoundException;
import com.boev.shop.user.repository.UserRepository;
import com.boev.shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplateBuilder restTemplate;

    private final String URL = "http://localhost:8084/request";

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void registerAccount(UserInfo userInfo) {

        Account account = new Account();
        account.setUsername(userInfo.getUsername());
        account.setEmail(userInfo.getEmail());
        account.setPassword(userInfo.getPassword()); // TODO: 20.03.2023 Encode password
        account.setEnable(true);
        account.setBalance(BigDecimal.ZERO);

        userRepository.save(account);
    }

    @Override
    public void registerOrganization(OrgRequestDto orgRequestDto) {

        HttpEntity<OrgRequestDto> request = new HttpEntity<>(orgRequestDto);

        restTemplate.build().postForObject(URL, request, OrgRequestDto.class);
    }

    @Override
    public List<NotificationDto> getAllNotifications(long id) {

        Account account = userRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("No account with id: " + id));

        Function<Notification, NotificationDto> mapper = notification -> NotificationDto.builder()
                .header(notification.getHeader())
                .body(notification.getBody())
                .build();

        return account.getNotifications().stream()
                .map(mapper)
                .toList();
    }

    @Override
    public List<PurchaseDto> getAllPurchases(long id) {

        Account account = userRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("No account with id: " + id));

        Function<Purchase, PurchaseDto> mapper = purchase -> PurchaseDto.builder()
                .title(purchase.getTitle())
                .dateOfPurchase(purchase.getDateOfPurchase())
                .build();

        return account.getPurchases().stream()
                .map(mapper)
                .toList();
    }
}
