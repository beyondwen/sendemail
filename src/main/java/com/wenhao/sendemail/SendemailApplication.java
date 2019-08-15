package com.wenhao.sendemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SendemailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendemailApplication.class, args);
    }

}
