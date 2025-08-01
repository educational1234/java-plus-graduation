package ru.practicum.category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CategoryServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(CategoryServiceApp.class, args);
    }
}