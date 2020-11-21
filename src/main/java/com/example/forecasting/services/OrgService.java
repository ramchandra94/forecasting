package com.example.forecasting.services;

public interface OrgService {

    public void createOrg(String orgName);

    public boolean orgExists(String orgName);

    public boolean orgEnabled(String orgName);

    public void disableOrg(String orgName);

    public void deleteOrg(String orgName);
}
