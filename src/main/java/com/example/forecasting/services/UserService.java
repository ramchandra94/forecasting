package com.example.forecasting.services;

import com.example.forecasting.entities.User;
import com.example.forecasting.exceptions.ResourceAlreadyExists;

import java.sql.SQLDataException;

public interface UserService {

    User validateUser(String email, String password, String org_name);

    void registerUser(String firstName,
                      String lastName,
                      String email,
                      String password,
                      String org_name);

}
