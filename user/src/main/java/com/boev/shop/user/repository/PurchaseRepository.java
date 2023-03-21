package com.boev.shop.user.repository;

import com.boev.shop.user.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
