package com.izeno.snowflakedemo.usecase;

import com.google.gson.Gson;
import com.izeno.snowflakedemo.entity.ConfigUserData;
import com.izeno.snowflakedemo.entity.EntityData;
import com.izeno.snowflakedemo.model.DataRq;
import com.izeno.snowflakedemo.model.PayloadRs;
import com.izeno.snowflakedemo.model.UpdateColumn;
import com.izeno.snowflakedemo.model.UserDataRs;
import com.izeno.snowflakedemo.repository.ConfigUserRepository;
import com.izeno.snowflakedemo.repository.DataRepository;
import com.izeno.snowflakedemo.service.DataServiceImpl;
import com.izeno.snowflakedemo.service.TalendService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BaseUsecase {

    @Autowired
    DataServiceImpl dataService;

    @Autowired
    ConfigUserRepository configUserRepository;

    @Autowired
    DataRepository dataRepository;

    @Autowired
    TalendService talendService;

    public PayloadRs forwardData(List<DataRq> dataRqs) throws Exception {

        PayloadRs payloadRs = new PayloadRs();
        try {

            for (DataRq dataRq : dataRqs){
                EntityData entityData = new EntityData();
                entityData.setIndex(dataRq.getIndex());
                entityData.setUser_id(dataRq.getUser_id());
                entityData.setFirst_name(dataRq.getFirst_name());
                entityData.setLast_name(dataRq.getLast_name());
                entityData.setSex(dataRq.getSex());
                entityData.setEmail(dataRq.getEmail());
                entityData.setPhone(dataRq.getPhone());
                entityData.setDate_of_birth(dataRq.getDate_of_birth());
                entityData.setJob_title(dataRq.getJob_title());
                entityData.setOrganization_id(dataRq.getOrganization_id());
                entityData.setCompany_name(dataRq.getCompany_name());
                entityData.setWebsite(dataRq.getWebsite());
                entityData.setCountry(dataRq.getCountry());
                entityData.setDescription(dataRq.getDescription());
                entityData.setFounded(dataRq.getFounded());
                entityData.setIndustry(dataRq.getIndustry());
                entityData.setNumber_of_employees(dataRq.getNumber_of_employees());
                entityData.setExtra_1(dataRq.getExtra_1());
                entityData.setExtra_2(dataRq.getExtra_2());
                entityData.setExtra_3(dataRq.getExtra_3());

                dataService.saveData(entityData);
            }

            payloadRs.setStatus("OK");
            payloadRs.setStatusCode(200);
            payloadRs.setStatusDescription("Success Insert to Snowflake");

            return  payloadRs;

        }catch (Exception e){
            e.printStackTrace();
            throw  new Exception();
        }
    }

    public List<EntityData> fetchAllData() throws Exception {
        try {
            return dataService.fetchListData();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();

        }
    }

    public List<ConfigUserData> getAllColumn() throws Exception {

        try {

            return configUserRepository.getActiveColumn();

        }catch (Exception e){
            throw new Exception();
        }

    }

    public PayloadRs updateColumn(UpdateColumn columnName) throws Exception {
        try {

            PayloadRs payloadRs = new PayloadRs();
            int status = Integer.parseInt(columnName.getStatus());
            List<String> columnNameList = columnName.getColumnList();

            for (String s : columnNameList){
                int rowupdated = configUserRepository.updateColumn(status, s);
            }

            payloadRs.setStatus("OK");
            payloadRs.setStatusCode(200);
            payloadRs.setStatusDescription("Success Update Column");

            return  payloadRs;

        }catch (Exception e){
            throw new Exception();
        }
    }


    public PayloadRs synchData() throws Exception {
        try {
            PayloadRs payloadRs = new PayloadRs();
            Gson gson = new Gson();

            String response = talendService.getData();
            UserDataRs[] userDataRsList = gson.fromJson(response, UserDataRs[].class);
            int size = userDataRsList.length;

            for (UserDataRs userDataRs : userDataRsList){
                EntityData entityData = new EntityData();
                if (!Objects.isNull(userDataRs.getIndex())){
                    entityData.setIndex(userDataRs.getIndex());;
                }
                entityData.setUser_id(userDataRs.getUser_id());
                entityData.setFirst_name(userDataRs.getFirst_name());
                entityData.setLast_name(userDataRs.getLast_name());
                entityData.setSex(userDataRs.getSex());
                entityData.setEmail(userDataRs.getEmail());
                entityData.setPhone(userDataRs.getPhone());
                entityData.setDate_of_birth(userDataRs.getDate_of_birth());
                entityData.setJob_title(userDataRs.getJob_title());
                entityData.setOrganization_id(userDataRs.getOrganization_id());
                entityData.setCompany_name(userDataRs.getCompany_name());
                entityData.setWebsite(userDataRs.getWebsite());
                entityData.setCountry(userDataRs.getCountry());
                entityData.setDescription(userDataRs.getDescription());
                if (!Objects.isNull(userDataRs.getFounded())){
                    entityData.setFounded(userDataRs.getFounded());
                }
                entityData.setIndustry(userDataRs.getIndustry());
                if (!Objects.isNull(userDataRs.getNumber_of_employees())){
                    entityData.setNumber_of_employees(userDataRs.getNumber_of_employees());
                }
                entityData.setExtra_1(userDataRs.getExtra_1());
                entityData.setExtra_2(userDataRs.getExtra_2());
                entityData.setExtra_3(userDataRs.getExtra_3());
                dataService.saveData(entityData);
            }


            payloadRs.setStatus("OK");
            payloadRs.setStatusCode(200);
            payloadRs.setStatusDescription("Success Synch All Data");

            return  payloadRs;


        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }


}
