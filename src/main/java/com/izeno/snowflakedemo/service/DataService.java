package com.izeno.snowflakedemo.service;

import com.izeno.snowflakedemo.entity.EntityData;

import java.util.List;

public interface DataService {

    // save operation
    EntityData saveData(EntityData entityData);

    // read operation
    List<EntityData> fetchListData();

    // update operation
    EntityData updateDepartment(EntityData department, int index);

    // delete operation
    void deletaById(int  index);

    void deleteAll();

}
