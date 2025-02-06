package com.spring.utente.controller;

import java.util.List;

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
	
	private UtenteService service = new UtenteService();
	
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
}
