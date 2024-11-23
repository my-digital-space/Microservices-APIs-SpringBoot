package com.micro.ObjectMapper.addProp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdditionalPropertiesService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseObject getData() {
        ResponseObject responseObject = null;
        try {
            responseObject = restTemplate
                    .getForEntity("https://jsonplaceholder.typicode.com/posts/1", ResponseObject.class)
                    .getBody();
        } catch (Exception ex) {
            System.out.println("Exception occurred: " + ex);
        }
        return responseObject;
    }
}
