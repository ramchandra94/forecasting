package com.example.forecasting.resources;


import com.example.forecasting.entities.User;
import com.example.forecasting.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/users/")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> userMap){

        return null;
    }

    @PostMapping("/register")
    public void registerUser(@Valid @NotNull @RequestBody User userMap) {
        userService.registerUser(userMap.getFirstName(),
                userMap.getLastName(),
                userMap.getEmail(),
                userMap.getPassword(),
                userMap.getOrgName());

    }
}
