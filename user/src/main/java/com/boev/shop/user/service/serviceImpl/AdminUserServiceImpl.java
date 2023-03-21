package com.boev.shop.user.service.serviceImpl;

import com.boev.shop.user.dto.NotificationDto;
import com.boev.shop.user.dto.PurchaseDto;
import com.boev.shop.user.dto.UserInfo;
import com.boev.shop.user.entity.Account;
import com.boev.shop.user.entity.Notification;
import com.boev.shop.user.entity.Purchase;
import com.boev.shop.user.exception.AccountNotFoundException;
import com.boev.shop.user.repository.UserRepository;
import com.boev.shop.user.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addMoneyToBalance(long id, String amount) {

        Account account = userRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("No account with id: " + id));

        BigDecimal money = new BigDecimal(amount);

        account.setBalance(account.getBalance().add(money));
    }

    @Override
    public List<PurchaseDto> getAllUsersPurchasesById(long id) {

        Account account = userRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("No account with id: " + id));

        Function<Purchase, PurchaseDto> purchaseDtoFunction = purchase -> PurchaseDto.builder()
                .title(purchase.getTitle())
                .dateOfPurchase(purchase.getDateOfPurchase())
                .build();

        return account.getPurchases().stream()
                .map(purchaseDtoFunction)
                .toList();
    }

    @Override
    @Transactional
    public void sendNotification(long id, NotificationDto notificationDto) {

        Account account = userRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("No account with id: " + id));

        Notification notification = new Notification();
        notification.setHeader(notificationDto.getHeader());
        notification.setBody(notification.getBody());
        notification.setSendDate(LocalDate.now());

        notification.setAccount(account);
        account.addNotification(notification);
    }

    @Override
    public UserInfo getUserInfo(long id) {

        Account account = userRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("No account with id: " + id));

        return UserInfo.builder()
                .username(account.getUsername())
                .email(account.getEmail())
                .balance(account.getBalance())
                .build();
    }

    @Override
    @Transactional
    public void deleteAccount(long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void disableAccount(long id) {

        Account account = userRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("No account with id: " + id));

        account.setEnable(false);
    }
}
