package com.practice.Controller;

import org.springframework.web.bind.annotation.*;
import com.practice.dto.PostBody;

@RestController
@RequestMapping("/api")

/*  Post방식 url 주소
    http://localhost:8080/api/post   */

public class PostController {
	@PostMapping("/post")
	public PostBody post(@RequestBody PostBody postBody) {
		System.out.println("account: " + postBody.getAccount());
        System.out.println("email: " + postBody.getEmail());
		return postBody;
	}
}
