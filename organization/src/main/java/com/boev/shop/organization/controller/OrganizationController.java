package com.boev.shop.organization.controller;

import com.boev.shop.organization.dto.OrgRequestDto;
import com.boev.shop.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request")
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<Void> makeRequestToRegisterOrg(@RequestBody OrgRequestDto orgRequestDto) {
        organizationService.makeRequest(orgRequestDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8081/admin")
    public ResponseEntity<Void> approveRequest(@PathVariable long id) {
        organizationService.approveOrgRequest(id);
        return ResponseEntity.ok().build();
    }
}
