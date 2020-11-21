package com.example.forecasting.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class PostgresDataSourceLoader implements ApplicationRunner {
    private final HikariDataSource hikariDataSource;

    @Autowired
    public PostgresDataSourceLoader(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws SQLException {
        Connection conn = hikariDataSource.getConnection();
        conn.close();
    }
}
