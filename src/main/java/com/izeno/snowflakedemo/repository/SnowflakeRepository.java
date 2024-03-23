package com.izeno.snowflakedemo.repository;

import com.izeno.snowflakedemo.model.UserDataRs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SnowflakeRepository {

    @Autowired
    @Qualifier("snowflakeJdbcTemplate")
    JdbcTemplate jdbcTemplate;


    public List<UserDataRs> fetchAllData(String param) throws Exception {
        String Query = "SELECT [PARAM] FROM POC_SAPURA.API_INGESTION.USER_DATA".replace("[PARAM]", param);


        try {
            List<UserDataRs> result = jdbcTemplate.query(Query, new BeanPropertyRowMapper<>(UserDataRs.class));
            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }

    }
}
