package com.spring.base.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/date")
public class DateController {
	
	@GetMapping(path="/attuale")
	public LocalDateTime getDataAttuale() {
		return LocalDateTime.now();
	}
	
	@GetMapping(path="/custom")
	public LocalDateTime getDataCustom() {
		return LocalDateTime.of(2071, 01, 12, 18, 30);
	}
}
