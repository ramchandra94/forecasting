package com.example.forecasting.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@JsonIgnoreProperties(value = {"id"})
public class User {

    private final UUID id;
    @NotBlank(message = "First Name cannot be blank.")
    private final String firstName;
    // TODO implement a custom validator
    @Nullable
    private final String lastName;
    @NotBlank(message = "email cannot be blank.")
    private final String email;
    @NotBlank(message = "password cannot be blank.")
    private final String password;
    // TODO implement a custom validator
    private final String orgName;


    public User(UUID id,
                @JsonProperty(value = "first_name", required = true) String firstName,
                @Nullable @JsonProperty("last_name") String lastName,
                @JsonProperty(value = "email", required = true) String email,
                @JsonProperty(value = "password",
                        access = JsonProperty.Access.WRITE_ONLY,
                        required = true) String password,
                @JsonProperty(value = "org_name", required = true) String orgName)
    {

        System.out.println("id is " + id);
        System.out.println("first name is " + firstName);
        System.out.println("last name is " + lastName);
        System.out.println("email is " + email);
        System.out.println("password is " + password);
        System.out.println("org name is " + orgName);

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.orgName = orgName;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
