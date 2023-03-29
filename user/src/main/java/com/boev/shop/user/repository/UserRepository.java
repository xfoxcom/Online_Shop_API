package com.boev.shop.user.repository;

import com.boev.shop.user.entity.Account;
import com.boev.shop.user.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);

    @Query("SELECT a FROM ACCOUNT a")
    List<String> getUserPurchasesTitles();
}
