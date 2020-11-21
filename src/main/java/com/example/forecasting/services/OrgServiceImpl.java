package com.example.forecasting.services;

import com.example.forecasting.repositories.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrgServiceImpl implements OrgService{
    private OrgRepository orgRepository;

    public OrgServiceImpl(@Qualifier("jdbcOrgTemplateDao") OrgRepository orgRepository){
        this.orgRepository = orgRepository;
    }

    @Override
    public void createOrg(String orgName) {
        orgRepository.createOrg(orgName);
    }

    @Override
    public boolean orgExists(String orgName) {
        return false;
    }

    @Override
    public boolean orgEnabled(String orgName) {
        return false;
    }

    @Override
    public void disableOrg(String orgName) {

    }

    @Override
    public void deleteOrg(String orgName) {

    }
}
