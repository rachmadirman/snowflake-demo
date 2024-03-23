package com.izeno.snowflakedemo.repository;

import com.izeno.snowflakedemo.entity.EntityData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DataRepository extends CrudRepository<EntityData, Integer> {

    @Query(value = "SELECT COLUMN_NAME  FROM INFORMATION_SCHEMA.\"COLUMNS\"  WHERE TABLE_NAME = 'USER_DATA' ORDER BY ORDINAL_POSITION ASC ", nativeQuery = true)
    List<String> getAllColumn();


}
