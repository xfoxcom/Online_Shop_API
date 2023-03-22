package com.boev.shop.organization.service;

import com.boev.shop.organization.dto.OrgRequestDto;

public interface OrganizationService {

    void makeRequest(OrgRequestDto orgRequestDto);

    void approveOrgRequest(long id);
}
