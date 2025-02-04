package com.spring.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.base.entity.Utente;

@RestController
@RequestMapping(path="/gestioneUtenti")
public class UtenteController {
	
	// Diciamo al metodo che esso accetta solo json, usiamo consumes
	@GetMapping(path="/carica", consumes = "application/json")
	public boolean registra(@RequestBody Utente utente) {
		System.out.println("ho registrato " + utente);
		return true;
	}
	
	@GetMapping(path="/cerca/{id}", produces = "application/json")
	public Utente cerca(@PathVariable int id) {
		return new Utente(id,"anna","bianchi","anna","111",1998);
	}
	
	
}
