package com.example.CH_Practice.controller;


import com.example.CH_Practice.dto.Repos;
import com.example.CH_Practice.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class BodyController {


    Repos repos=Repos.getInstance();

    @PostMapping("/post-json")
    public UserDto create(@RequestBody UserDto user){
        log.info("name={},age={}", user.getName(), user.getAge());
        repos.save(user);

        return user;
    }

    @GetMapping("/show-all")
    public String findAll(){
        List<UserDto> res = repos.findAll();

        return res.toString();

    }






}
