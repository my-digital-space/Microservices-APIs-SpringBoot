package com.ms.RetryPattern1.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MyRetryService {

    private final RestTemplate restTemplate = new RestTemplate();
    private Integer count = 1;

    @Retryable(
            // Specify the exception(s) to retry on
            retryFor = {ResourceAccessException.class, RestClientException.class},
            // Maximum number of retry attempts
            maxAttempts = 5,
            // Exponential backoff: initial delay 2 seconds, doubles each time
            backoff = @Backoff(delay = 2000, multiplier = 2))
    public String getDataFromApp2() {
        String myData = null;
        try {
            printWithTimestamp("Retry count: " + count);
            count++;
            restTemplate.getForEntity("http://localhost:9292/dummy", String.class);
            return "Success!";
        } catch (Exception ex) {
            System.out.println("Exception occurred: " + ex);
            throw ex; // Rethrow to trigger retry
        }
    }

    public static void printWithTimestamp(String log) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println(LocalDateTime.now().format(formatter) + " " + log);
    }


}
