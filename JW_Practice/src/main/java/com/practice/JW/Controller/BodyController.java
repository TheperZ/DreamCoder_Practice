package com.practice.JW.Controller;

import com.practice.JW.Service.BodyService;
import com.practice.JW.dto.BodyRequestDto;
import com.practice.JW.dto.BodyResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BodyController {

    @Autowired
    private final BodyService bodyService;

    @PostMapping("/body")
    public ResponseEntity bodys(@RequestBody BodyRequestDto bodyRequestDto){
        BodyResponseDto bodyResponseDto = bodyService.create(bodyRequestDto.toBodyServiceDto());
        return ResponseEntity.ok().body(bodyResponseDto);
    }

}
