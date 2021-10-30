package com.reef.demo_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("private.properties")
@SpringBootApplication
public class OnlineStoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineStoreDemoApplication.class, args);
    }

}
