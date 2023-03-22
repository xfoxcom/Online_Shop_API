package com.boev.shop.organization.repository;

import com.boev.shop.organization.entity.OrgRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<OrgRequest, Long> {
}
