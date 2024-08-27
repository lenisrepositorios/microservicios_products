package com.example.microservicios_product;

import org.springframework.boot.SpringApplication;

public class TestMicroserviciosProductApplication {

    public static void main(String[] args) {
        SpringApplication.from(MicroserviciosProductApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
