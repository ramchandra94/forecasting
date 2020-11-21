package com.example.forecasting.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

@Configuration
public class PostgresDataSource {

    @Autowired
    private Environment environment;

    @Bean
    @ConfigurationProperties("app.postgresource")
    public HikariDataSource hikariDataSource(){
        System.out.println("My Own Spring Bean of Data Source is Created ");
        HikariDataSource hds = DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();

        Integer maxPoolSize = Integer.parseInt(environment.getProperty("app.postgresource.maxPoolSize"));
        hds.setJdbcUrl(environment.getProperty("app.postgresource.jdbcUrl"));
        hds.setUsername(environment.getProperty("app.postgresource.username"));
        hds.setPassword(environment.getProperty("app.postgresource.password"));
        hds.setMaximumPoolSize(maxPoolSize);
        return hds;
    }

    @Bean("walmart-postgres")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(hikariDataSource());
    }
}
