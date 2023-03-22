package com.practice.JW.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class ParamResponseDto {

    private int id;
    private String keyword;
    private int page;

}
