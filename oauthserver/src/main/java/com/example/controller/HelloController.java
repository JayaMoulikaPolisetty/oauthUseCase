package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/userHello")
	public String userHello()
	{
		return "Hello User";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/adminHello")
	public String adminHello()
	{
		return "Hello Admin";
	}
	
	@GetMapping("/tokenHello")
	public String tokenHello()
	{
		return "Token is valid";
	}

}
