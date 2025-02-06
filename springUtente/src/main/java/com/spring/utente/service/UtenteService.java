package com.spring.utente.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.utente.dao.DAOUtente;
import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.entity.Utente;
import com.spring.utente.utility.Conversioni;

public class UtenteService {
	
	// questo costruttore crea la mappa vuota di utenti
	private DAOUtente dao = new DAOUtente();
	
	public void registra(UtenteDTO dto) {
		// trasformo da dto a entity
		Utente entity = Conversioni.daUtenteDTOAUtente(dto);
		
		// chiamo il dao per inserire
		dao.insert(entity);
	}
	
	public UtenteDTO cercaPerId(int id) {
		 // chiamo il dao
		Utente utente = dao.selectById(id);
		
		// trasformo da entity a dto
		return Conversioni.daUtenteAUtenteDTO(utente);
	}
	
	public List<UtenteDTO> mostraTutti() {
		// chiamo il dao
		List<Utente> lista = dao.selectAll();
		
		// trasformo
		List<UtenteDTO> listaDto = new ArrayList<>();
		for (Utente utente : lista) {
			UtenteDTO dto = Conversioni.daUtenteAUtenteDTO(utente);
			listaDto.add(dto);
		}
		return listaDto;
	}
}
