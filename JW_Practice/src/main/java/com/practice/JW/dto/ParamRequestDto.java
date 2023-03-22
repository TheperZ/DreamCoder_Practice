package com.practice.JW.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParamRequestDto {

    private int id;
    private String keyword;
    private int page;

    public ParamServiceDto toServiceDto(){
        return new ParamServiceDto(this.id, this.keyword, this.page);
    }
}
