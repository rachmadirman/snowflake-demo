package com.izeno.snowflakedemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilterRs {

    private List<Integer> index;
    private List<String> user_id;
    private List<String> first_name;
    private List<String> last_name;
    private List<String> sex;
    private List<String> email;
    private List<String> phone;
    private List<String> date_of_birth;
    private List<String> job_title;
    private List<String> organization_id;
    private List<String> company_name;
    private List<String> website;
    private List<String> country;
    private List<String> description;
    private List<Integer> founded;
    private List<String> industry;
    private List<Integer> number_of_employees;
    private List<String> extra_1;
    private List<String> extra_2;
    private List<String> extra_3;

}
