package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

/* Postman 에서 Post 방식 선택한 뒤 아랫줄에 Body 버튼 클릭, 그 아랫줄에 맨 오른쪽 버튼을 json으로 변경하고 아래 예시 입력
{
    "account" : "abcd",
    "email" : "abcd@gmail.com",
}    */

public class PostBody {
	private String account;
	private String email;
	public String getAccount() {
		return account;
	}
	public String getEmail() {
		return email;
	}
}