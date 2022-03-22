package com.management.salessystem

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class SalesSystemApplication extends SpringBootServletInitializer {

    static void main(String[] args) {
        SpringApplication.run(SalesSystemApplication, args)
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(SalesSystemApplication.class)
    }

}
