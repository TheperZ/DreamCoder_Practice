package com.practice.JW.Service;
import com.practice.JW.dto.BodyResponseDto;
import com.practice.JW.dto.BodyServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BodyService {

    public BodyResponseDto create(BodyServiceDto bodyServiceDto){
        return new BodyResponseDto(bodyServiceDto.getId(), bodyServiceDto.getNickname(), bodyServiceDto.getGender());
    }

}
