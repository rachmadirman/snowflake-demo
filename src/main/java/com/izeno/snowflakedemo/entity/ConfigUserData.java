package com.izeno.snowflakedemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USER_DATA_CONFIG")
@Data
public class ConfigUserData {

    @Id
    @Column(name = "\"index\"")
    private String index;
    @Column(name = "\"column_name\"")
    private String column_name;
    @Column(name = "\"status\"")
    private String status;

}
