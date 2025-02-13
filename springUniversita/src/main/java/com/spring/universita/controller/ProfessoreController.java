package com.spring.universita.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.service.ProfessoriService;

@RestController
@RequestMapping(path="/serviziprofessori")
public class ProfessoreController {
	private ProfessoriService service = new ProfessoriService();
	
	@GetMapping(path="/registra", consumes="application/json")
	public void registra(@RequestBody ProfessoreDTO dto) {
		service.inserisci(dto);
	}
	
	@GetMapping(path="/cerca/{id}", produces="application/json")
	public ProfessoreDTO cercaPerId(@PathVariable int id) {
		return service.cercaPerId(id);
	}
	
	@GetMapping(path="/mostraTutti", produces="application/json")
	public List<ProfessoreDTO> mostraTutti() {
		return service.mostraTutti();
	}
	
	@GetMapping(path="/elimina/{id}")
	public void elimina(@PathVariable int id) {
		service.cancellaPerId(id);
	}
	
	@GetMapping(path="/modificaMateria/{id}", produces="application/json")
	public ProfessoreDTO modificaMateria(@PathVariable int id, String materia) {
		return service.modificaMateria(id, materia);
	}
	
	@GetMapping(path="/cognomiProfessori")
	public String[] cognomiProfessori() {
		return service.cognomiProfessori();
	}
	
	@GetMapping(path="/professoriPerMateria")
	public List<ProfessoreDTO> professoriPerMateria(String materia) {
		return service.mostraPerMateria(materia);
	}
	
	@GetMapping(path="/professoriOrdinatiPerCognome")
	public List<ProfessoreDTO> professoriOrdinatiPerCognome() {
		return service.professoriOrdinatiPerCognome();
	}

}
