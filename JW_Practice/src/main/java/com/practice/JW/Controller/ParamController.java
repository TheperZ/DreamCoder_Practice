package com.practice.JW.Controller;


import com.practice.JW.Service.ParamService;
import com.practice.JW.dto.ParamRequestDto;
import com.practice.JW.dto.ParamResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor

public class ParamController {

    private final ParamService paramService;

    @GetMapping("/params")
    public ResponseEntity params(ParamRequestDto paramRequestDto){
        ParamResponseDto paramResponseDto = paramService.create(paramRequestDto.toServiceDto());
        return ResponseEntity.ok().body(paramResponseDto);
    }

}
