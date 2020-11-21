package com.example.forecasting.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Org {

    @NotBlank(message = "org name cannot be blank")
    private String orgName;

    public Org(@JsonProperty(value = "org_name", required = true) String orgName){
        this.orgName = orgName;
    }

    public String getOrgName(){
        return orgName;
    }
}
