package com.gft.challange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class WebDirApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDirApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "index";
    }
}
