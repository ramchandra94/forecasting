package com.example.forecasting.resources;

import com.example.forecasting.entities.Org;
import com.example.forecasting.services.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/orgs/")
public class OrgResource {

    @Autowired
    private OrgService orgService;

    @PostMapping(value = "/register_org")
    public void registerOrg(@Valid @NotNull @RequestBody Org orgBody) {
        orgService.createOrg(orgBody.getOrgName());
    }
}
