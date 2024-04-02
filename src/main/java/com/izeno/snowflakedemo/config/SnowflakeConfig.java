package com.izeno.snowflakedemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class SnowflakeConfig {

    @Bean
    public DataSource snowflakeDataSource() throws SQLException {

        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUsername("XXX");
        dataSourceProperties.setPassword("XXX");
        //dataSourceProperties.setUrl("jdbc:snowflake://br00321.ap-southeast-1.snowflakecomputing.com/?useSSL=false&requireSSL=false&user=XXXX&warehouse=COMPUTE_WH&db=POC_SAPURA&schema=API_INGESTION&role=SNOWPARK_ROLE&tracing=ALL");
        dataSourceProperties.setUrl("jdbc:snowflake://br00321.ap-southeast-1.snowflakecomputing.com?useSSL=false&user=XXXX&password=XXXX&warehouse=COMPUTE_WH&db=POC_SAPURA&schema=API_INGESTION&role=SNOWPARK_ROLE&tracing=ALL&CLIENT_SESSION_KEEP_ALIVE=true");
        //dataSourceProperties.setUrl("jdbc:snowflake://54.151.170.173:443/?useSSL=false&requireSSL=false&user=XXXX&warehouse=COMPUTE_WH&db=POC_SAPURA&schema=API_INGESTION&role=SNOWPARK_ROLE&tracing=ALL");
        dataSourceProperties.setDriverClassName("net.snowflake.client.jdbc.SnowflakeDriver");

        HikariDataSource hikariObj = (HikariDataSource) dataSourceProperties.initializeDataSourceBuilder().build();
        hikariObj.setMaximumPoolSize(10);
        hikariObj.setConnectionTimeout(250);
        hikariObj.setMinimumIdle(5);
        hikariObj.setLoginTimeout(30000);
        hikariObj.setIdleTimeout(10000);
        //hikariObj.setConnectionTestQuery("values 1");

        return hikariObj;
    }

    @Bean
    public JdbcTemplate snowflakeJdbcTemplate(@Qualifier("snowflakeDataSource") DataSource snowflakeDataSource){
        return new JdbcTemplate(snowflakeDataSource);
    }
}
