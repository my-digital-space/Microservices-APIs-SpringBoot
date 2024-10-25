package com.ms.RetryPattern1.controller;

import com.ms.RetryPattern1.service.MyRetryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retry")
public class MyRetryController {

    private MyRetryService myRetryService;

    public MyRetryController(MyRetryService myRetryService) {
        this.myRetryService = myRetryService;
    }

    @GetMapping("/exponentialBackoff")
    public ResponseEntity<String> exponentialBackoff(){
        String myData = myRetryService.getDataFromApp2();
        return new ResponseEntity<>(myData,HttpStatus.OK);
    }

}
