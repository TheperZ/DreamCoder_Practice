package com.example.CH_Practice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public Long id;
    public String name;
    public int age;

    public UserDto(String name, int age){
        this.name=name;
        this.age=age;
    }

}
