package com.izeno.snowflakedemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDataRs {

    private Integer index;

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

    private Integer founded;

    private String industry;

    private Integer number_of_employees;

    private String extra_1;

    private String extra_2;

    private String extra_3;


}
