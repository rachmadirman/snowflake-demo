package com.izeno.snowflakedemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UpdateColumn {

    @JsonProperty("update_column")
    private List<String> columnList;
}
