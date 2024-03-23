package com.izeno.snowflakedemo.model;

import lombok.Data;

import java.util.List;

@Data
public class DataRq {

    private int index;
    private String user_id;
    private String first_name;
    private String last_name;
    private String sex;
    private String email;
    private String phone;
    private String date_of_birth;
    private String job_title;
    private String organization_id;
    private String company_name;
    private String website;
    private String country;
    private String description;
    private int founded;
    private String industry;
    private int number_of_employees;
    private String extra_1;
    private String extra_2;
    private String extra_3;

}
