package com.practice.JW.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BodyRequestDto {

    int id;
    String nickname;
    String gender;

    public BodyServiceDto toBodyServiceDto(){
        return new BodyServiceDto(this.id,this.nickname,this.gender);
    }

}
