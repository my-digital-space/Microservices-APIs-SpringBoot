package com.micro.ObjectMapper.addProp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addProp")
public class AdditionalPropertiesController {

    private AdditionalPropertiesService addPropSvc;

    public AdditionalPropertiesController(AdditionalPropertiesService addPropSvc) {
        this.addPropSvc = addPropSvc;
    }

    @GetMapping("/getData1")
    public ResponseEntity<ResponseObject> getData1(){
        ResponseObject myData = addPropSvc.getData();
        return new ResponseEntity<>(myData, HttpStatus.OK);
    }

}
