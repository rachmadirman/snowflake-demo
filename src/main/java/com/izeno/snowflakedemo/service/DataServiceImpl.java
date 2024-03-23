package com.izeno.snowflakedemo.service;

import com.izeno.snowflakedemo.entity.EntityData;
import com.izeno.snowflakedemo.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService{

    @Autowired
    DataRepository dataRepository;


    @Override
    public EntityData saveData(EntityData entityData) {
        return dataRepository.save(entityData);
    }

    @Override
    public List<EntityData> fetchListData() {
        return (List<EntityData>) dataRepository.findAll();
    }

    @Override
    public EntityData updateDepartment(EntityData department, int index) {
        return null;
    }

    @Override
    public void deletaById(int index) {
        dataRepository.deleteById(index);

    }

    @Override
    public void deleteAll() {
        dataRepository.deleteAll();
    }
}
