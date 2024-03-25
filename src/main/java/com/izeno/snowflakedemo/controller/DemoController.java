package com.izeno.snowflakedemo.controller;

import com.izeno.snowflakedemo.entity.ConfigUserData;
import com.izeno.snowflakedemo.model.*;
import com.izeno.snowflakedemo.usecase.BaseUsecase;
import com.izeno.snowflakedemo.usecase.FetchDataUsecase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("demo/sapura")
public class DemoController {

    @Autowired
    BaseUsecase baseUsecase;

    @Autowired
    FetchDataUsecase fetchDataUsecase;


    @PostMapping(value = "/forward")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> forwardData(@Valid @RequestBody List<DataRq> dataRq,
                                         HttpServletRequest httpServletRequest) throws Exception {

        PayloadRs response = baseUsecase.forwardData(dataRq);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping(value = "/update/column")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> updateColumn(@Valid @RequestBody UpdateColumn req,
                                         HttpServletRequest httpServletRequest) throws Exception {

        PayloadRs response = baseUsecase.updateColumn(req);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(value = "/fetch/all")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getAllData(HttpServletRequest httpServletRequest) throws Exception {

        return ResponseEntity.status(HttpStatus.OK)
                .body(baseUsecase.fetchAllData());
    }


    @GetMapping(value = "/fetchv2/all")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getAllDataV2(HttpServletRequest httpServletRequest) throws Exception {

        return ResponseEntity.status(HttpStatus.OK)
                .body(fetchDataUsecase.fetchAllDataV2());
    }

    @GetMapping(value = "/active/column")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getAllColumn(HttpServletRequest httpServletRequest) throws Exception {

        ActiveColumnRs response = baseUsecase.getAllColumn();

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @GetMapping(value = "/synch")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> synchData() throws Exception {

        PayloadRs payloadRs = baseUsecase.synchData();

        return ResponseEntity.status(HttpStatus.OK)
                .body(payloadRs);
    }

    @GetMapping(value = "/testapi")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> testApi(){

        return ResponseEntity.status(HttpStatus.OK)
                .body("Success connect to API");
    }

}
