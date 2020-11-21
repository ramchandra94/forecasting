package com.example.forecasting.repositories;

public interface OrgRepository {

    public void createOrg(String org_name);

    public Integer getOrgId(String org_name);

    public void disableOrg(String org_name);

    
}
