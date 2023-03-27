package com.example.CH_Practice.controller;


import com.example.CH_Practice.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class BodyController {


    @PostMapping("/post-json")
    public UserDto response(@RequestBody UserDto user){
        log.info("name={},age={}", user.getName(), user.getAge());
        return user;
    }




}
