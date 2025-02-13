package com.spring.universita.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.service.StudentiService;

@RestController
@RequestMapping(path="/servizistudenti")

public class StudentiController {
	private StudentiService service = new StudentiService();
	
	@GetMapping(path="/registra", consumes="application/json")
	public void registra(@RequestBody StudenteDTO dto) {
		service.inserisci(dto);
	}
	
	@GetMapping(path="/cerca/{matricola}", produces="application/json")
	public StudenteDTO cercaPerMatricola(@PathVariable int matricola) {
		return service.cercaPerMatricola(matricola);
	}
	
	@GetMapping(path="/mostraTutti", produces="application/json")
	public List<StudenteDTO> mostraTutti() {
		return service.mostraTutti();
	}
	
	@GetMapping(path="/elimina/{matricola}")
	public void elimina(@PathVariable int matricola) {
		service.cancellaPerMatricola(matricola);
	}
	
	@GetMapping(path="/modificaIndirizzo/{matricola}", produces="application/json")
	public StudenteDTO modificaIndirizzo(@PathVariable int matricola, String indirizzo) {
		return service.modificaIndirizzo(matricola, indirizzo);
	}
	
	@GetMapping(path="/nomiStudenti")
	public String[] nomiStudenti() {
		return service.nomiStudenti();
	}
	
	@GetMapping(path="/studentePiuGiovane", produces="application/json")
	public StudenteDTO studentePiuGiovane() {
		return service.studentePiuGiovane();
	}
	
	@GetMapping(path="/studenteIscrittoDaPiuTempo", produces="application/json")
	public StudenteDTO studenteIscrittoDaPiuTempo() {
		return service.studenteIscrittoDaPiuTempo();
	}
}
