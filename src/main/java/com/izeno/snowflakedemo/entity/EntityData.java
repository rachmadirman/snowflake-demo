package com.izeno.snowflakedemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name = "user_data")
@Data
public class EntityData implements Serializable {

    @Id
    @Column(name = "\"index\"")
    private int index;

    @Column(name = "\"user_id\"")
    private String user_id;

    @Column(name = "\"first_name\"")
    private String first_name;

    @Column(name = "\"last_name\"")
    private String last_name;

    @Column(name = "\"sex\"")
    private String sex;

    @Column(name = "\"email\"")
    private String email;

    @Column(name = "\"phone\"")
    private String phone;

    @Column(name = "\"date_of_birth\"")
    private String date_of_birth;

    @Column(name = "\"job_title\"")
    private String job_title;

    @Column(name = "\"organization_id\"")
    private String organization_id;

    @Column(name = "\"company_name\"")
    private String company_name;

    @Column(name = "\"website\"")
    private String website;

    @Column(name = "\"country\"")
    private String country;

    @Column(name = "\"description\"")
    private String description;

    @Column(name = "\"founded\"")
    private int founded;

    @Column(name = "\"industry\"")
    private String industry;

    @Column(name = "\"number_of_employees\"")
    private int number_of_employees;

    @Column(name = "\"extra_1\"")
    private String extra_1;

    @Column(name = "\"extra_2\"")
    private String extra_2;

    @Column(name = "\"extra_3\"")
    private String extra_3;

}
