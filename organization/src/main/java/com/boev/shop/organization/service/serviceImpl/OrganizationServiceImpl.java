package com.boev.shop.organization.service.serviceImpl;

import com.boev.shop.organization.dto.OrgRequestDto;
import com.boev.shop.organization.entity.OrgRequest;
import com.boev.shop.organization.entity.Organization;
import com.boev.shop.organization.exception.OrgRequestNotFound;
import com.boev.shop.organization.repository.OrganizationRepository;
import com.boev.shop.organization.repository.RequestRepository;
import com.boev.shop.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final RequestRepository requestRepository;

    private final OrganizationRepository organizationRepository;

    @Override
    @Transactional
    public void makeRequest(OrgRequestDto orgRequestDto) {

        OrgRequest orgRequest = OrgRequest.builder()
                .title(orgRequestDto.getTitle())
                .description(orgRequestDto.getDescription())
                .logo(orgRequestDto.getLogo())
                .build();

        requestRepository.save(orgRequest);
    }

    @Override
    @Transactional
    public void approveOrgRequest(long id) {

        OrgRequest orgRequest = requestRepository.findById(id)
                .orElseThrow(() -> new OrgRequestNotFound("No request with id: " + id));

        Organization organization = Organization.builder()
                .title(orgRequest.getTitle())
                .description(orgRequest.getDescription())
                .isEnable(true)
                .logo(orgRequest.getLogo())
                .build();

        organizationRepository.save(organization);
        requestRepository.delete(orgRequest);
    }
}
