package com.spring.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/saluto")
public class SalutoController {
	
	public SalutoController() {
		System.out.println("spring crea salutocontroller");
	}
	
	@GetMapping(path="/generico")
	public String helloworld() {
		return "Hello world!";
		//per provarlo: http://localhost:8080/saluto/generico
	}
	
	@GetMapping(path="/personalizzato")
	public String hello(String nome) {
		return "Hello " + nome + "!";
		//per provarlo: http://localhost:8080/saluto/personalizzato?nome=Gabriele
	}
}
