package com.ioiox.dei.duc.admin;

import com.ioiox.dei.duc.springboot.autoconfig.EnableDUC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDUC
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
