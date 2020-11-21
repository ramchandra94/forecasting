package com.example.forecasting.repositories;


import com.example.forecasting.entities.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepository {

    public void createUser(String firstName, String lastName, String email, String password, Integer orgId);

    public Integer getCountByEmail(String email);

    public User validateUser(String email, String password);

}
