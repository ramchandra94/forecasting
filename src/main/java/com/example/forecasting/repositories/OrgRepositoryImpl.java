package com.example.forecasting.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.StatementEvent;
import java.sql.PreparedStatement;
import java.sql.Statement;


@Repository("jdbcOrgTemplateDao")
public class OrgRepositoryImpl implements OrgRepository {

    @Qualifier("walmart-postgres")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String ORG_CREATE_SQL = "insert into orgs_enabled (org_id, org_name) values (nextval('org_id_seq'), ?)";

    private static final String GET_ORG_ID = "select org_id from orgs_enabled where org_name = ?";

	@Override
	public void createOrg(String org_name){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(ORG_CREATE_SQL,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, org_name);
            return ps;
        }, keyHolder);

        Integer createdOrgId = (Integer) keyHolder.getKeys().get("org_id");
    }

	@Override
    public Integer getOrgId(String org_name){
        return jdbcTemplate.queryForObject(GET_ORG_ID, new Object[]{org_name}, orgIdMapper);
    }

    private RowMapper<Integer> orgIdMapper = ((rs, rowNum) -> {
        return new Integer(rs.getString("org_id"));
    });

    @Override
    public void disableOrg(String org_name){


	}

}