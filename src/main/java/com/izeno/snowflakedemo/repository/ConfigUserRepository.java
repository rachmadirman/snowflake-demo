package com.izeno.snowflakedemo.repository;

import com.izeno.snowflakedemo.entity.ConfigUserData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigUserRepository extends CrudRepository<ConfigUserData, Integer> {

    @Query(value = "SELECT \"column_name\"  FROM POC_SAPURA.API_INGESTION.USER_DATA_CONFIG WHERE \"status\" = 1", nativeQuery = true)
    List<String> getActiveColumn();

    @Query(value = "SELECT \"column_name\"  FROM POC_SAPURA.API_INGESTION.USER_DATA_CONFIG WHERE \"status\" = 1", nativeQuery = true)
    List<String> getActiveColumnName();

    @Query(value = "UPDATE POC_SAPURA.API_INGESTION.USER_DATA_CONFIG SET \"status\" = 1 WHERE \"column_name\" = :columnName", nativeQuery = true)
    int  updateColumn(String columnName);
}
