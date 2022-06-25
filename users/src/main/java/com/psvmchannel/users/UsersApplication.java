package com.psvmchannel.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class UsersApplication {

    private final List<String> users = List.of("Вася", "Петя", "Оля");

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @GetMapping("/users")
    public List<String> getUsers() {
        return this.users;
    }

    @GetMapping("/users/{id}")
    public String userById(@PathVariable int id) {
        try {
            return users.get(id - 1);
        } catch (RuntimeException e) {
            return "Нет такого пользователя";
        }
    }

}
