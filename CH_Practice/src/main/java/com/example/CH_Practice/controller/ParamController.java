package com.example.CH_Practice.controller;

import com.example.CH_Practice.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class ParamController {

    @GetMapping("/get-json")
    public UserDto response(@RequestParam("name") String name, @RequestParam("age") int age){
        UserDto user = new UserDto(name, age);
        log.info("name={}, age={}", user.getName(), user.getAge());
        return user;

    }
}
