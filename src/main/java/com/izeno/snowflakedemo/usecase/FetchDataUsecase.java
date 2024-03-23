package com.izeno.snowflakedemo.usecase;


import com.izeno.snowflakedemo.entity.EntityData;
import com.izeno.snowflakedemo.model.UserDataRs;
import com.izeno.snowflakedemo.repository.ConfigUserRepository;
import com.izeno.snowflakedemo.repository.DataRepository;
import com.izeno.snowflakedemo.repository.SnowflakeRepository;
import com.izeno.snowflakedemo.service.DataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class FetchDataUsecase {

    @Autowired
    ConfigUserRepository configUserRepository;

    @Autowired
    SnowflakeRepository snowflakeRepository;


    public List<UserDataRs> fetchAllDataV2() throws Exception {


        StringBuilder str = new StringBuilder();

        try {
            List<String> stringList = configUserRepository.getActiveColumnName();
            int size = stringList.size();
            for (int i = 0; i<size; i++){

                if (i == size-1){
                    str.append("\"").append(stringList.get(i)).append("\" ");
                }else {
                    str.append("\"").append(stringList.get(i)).append("\", ");
                }

            }
            String parameter = str.toString();
            List<UserDataRs> userDataRsList = snowflakeRepository.fetchAllData(parameter);

            return userDataRsList;

        } catch (Exception e) {
            throw new Exception(e);
        }

    }


}
