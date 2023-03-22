package com.practice.JW.Service;

import com.practice.JW.dto.ParamResponseDto;
import com.practice.JW.dto.ParamServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ParamService {

    public ParamResponseDto create(ParamServiceDto paramServiceDto){
        return new ParamResponseDto(paramServiceDto.getId(), paramServiceDto.getKeyword(), paramServiceDto.getPage());
    }

}
