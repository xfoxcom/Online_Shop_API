package com.boev.shop.user.repository;

import com.boev.shop.user.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {
}
