package com.spring.prodotti.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.dto.ReportDTO;
import com.spring.prodotti.service.ProdottoService;

@RestController
@RequestMapping(path="/servizi")
public class ProdottoController {
	private ProdottoService service = new ProdottoService();
	
	@GetMapping(path="/registra", consumes="application/json")
	public void registra(@RequestBody ProdottoDTO dto) {
		service.registra(dto);
	}
	
	@GetMapping(path="/cerca/{id}", produces="application/json")
	public ProdottoDTO cercaPerId(@PathVariable int id) {
		return service.cercaPerId(id);
	}
	
	@GetMapping(path="/mostraTutti", produces="application/json")
	public List<ProdottoDTO> mostraTutti() {
		return service.mostraTutti();
	}
	
	@GetMapping(path="/report", produces="application/json")
	public ReportDTO generaReport() {
		return service.generaReport();
	}

}
