package com.ms.RetryPattern1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RetryPattern1Application {

	public static void main(String[] args) {
		SpringApplication.run(RetryPattern1Application.class, args);
	}

}
