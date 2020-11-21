package com.example.forecasting.services;

import com.example.forecasting.entities.User;
import com.example.forecasting.exceptions.ResourceAlreadyExists;
import com.example.forecasting.repositories.OrgRepository;
import com.example.forecasting.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private OrgRepository orgRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("jdbcTemplateDao") UserRepository userRepository,
                           @Qualifier("jdbcOrgTemplateDao") OrgRepository orgRepository){
        this.userRepository = userRepository;
        this.orgRepository = orgRepository;
    }

    @Override
    public User validateUser(String email,
                             String password,
                             String org_name){

        return null;
    }

    @Override
    public void registerUser(String firstName,
                             String lastName,
                             String email,
                             String password,
                             String org_name) {

        Integer orgId = orgRepository.getOrgId(org_name);

        userRepository.createUser(firstName, lastName, email, password, orgId);
    }
}
