package com.example.forecasting.repositories;

import com.example.forecasting.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;


@Repository("jdbcTemplateDao")
public class jdbcUserRepositoryImpl implements UserRepository {

    @Qualifier("walmart-postgres")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_CREATE = "insert into users (user_id, first_name, last_name, email, password, org_id) values (uuid_generate_v4(), ?, ?, ?, ?, ?)";

    @Override
    public void createUser(String firstName, String lastName, String email, String password, Integer orgId) {
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setInt(5, orgId);
            return ps;
        });
    }

    @Override
    public Integer getCountByEmail(String email) {
        return null;
    }

    @Override
    public User validateUser(String email, String password) {
        return null;
    }
}
