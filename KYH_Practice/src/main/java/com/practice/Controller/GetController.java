package com.practice.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

/*  Get 방식 url 주소
    http://localhost:8080/api/getParam?id=user1234&password=12345678   */

public class GetController {
	@GetMapping("/getParam")
	public String getParam(@RequestParam String id, @RequestParam(name = "password") String pw) {
		String password = "aaaa";
		
		System.out.println("id: " + id);
		System.out.println("password: " + pw);
		
		return id + pw;
	}

}
