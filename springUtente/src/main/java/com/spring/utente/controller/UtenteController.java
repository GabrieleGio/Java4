package com.spring.utente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.service.UtenteService;

@RestController
@RequestMapping(path="/servizi")
public class UtenteController {
	
	@Autowired
	private UtenteService service;
	
	@GetMapping(path="/registra", consumes="application/json")
	public void registra(@RequestBody UtenteDTO dto) {
		service.registra(dto);
	}
	
	@GetMapping(path="/cerca/{id}", produces="application/json")
	public UtenteDTO cercaPerId(@PathVariable int id) {
		return service.cercaPerId(id);
	}
	
	@GetMapping(path="/mostraTutti", produces="application/json")
	public List<UtenteDTO> mostraTutti(){
		return service.mostraTutti();
	}
	
	//new
	@GetMapping(path="/cancella/{id}")
	public void cancellaPerId(@PathVariable int id) {
		service.cancellaPerId(id);
	}
	
	//new (da sistemare?)
	@GetMapping(path="/modificaPassword/{id}", produces="application/json")
	public UtenteDTO modificaPassword(@PathVariable int id, String newPass) {
        return service.modificaPassword(id, newPass);
	}
	
	//new
	@GetMapping(path="/modificaUtente", consumes="application/json", produces="application/json")
	public UtenteDTO modificaUtente(@RequestBody UtenteDTO dto) {
		return service.modificaUtente(dto);
	}
	//new
	@GetMapping(path="/mostraNomi", produces="application/json")
	public List<String> mostraNomi() {
		return service.mostraNomi();
	}
	//new
	@GetMapping(path="/mostraNomiCognomi", produces="application/json")
	public List<String> mostraNomiCognomi() {
		return service.mostraNomiCognomi();
	}
}
