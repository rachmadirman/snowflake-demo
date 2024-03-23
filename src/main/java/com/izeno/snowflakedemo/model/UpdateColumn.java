package com.izeno.snowflakedemo.model;

import lombok.Data;

import java.util.List;

@Data
public class UpdateColumn {

    private String status;
    private List<String> columnList;
}
