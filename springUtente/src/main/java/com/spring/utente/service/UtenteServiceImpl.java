package com.spring.utente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.utente.dao.DAOUtente;
import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.entity.Utente;
import com.spring.utente.utility.Conversioni;
// da aggiungere:
// cancellazione utente tramite id
// modifica password tramite id
// modifica totale di un utente, passando l'utente per intero
// mostra i nomi di tutti gli utenti
// mostra nomi e cognomi di tutti gli utenti
@Service
public class UtenteServiceImpl implements UtenteService{
	
	// questo costruttore crea la mappa vuota di utenti
	
	@Autowired
	private DAOUtente dao;
	
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
	
	//new
	public void cancellaPerId(int id) {
		dao.delete(id);
	}
	//new
	public UtenteDTO modificaPassword(int id, String newPass) {
		Utente utente = dao.updatePassword(id, newPass);
		if (utente != null) {
			return Conversioni.daUtenteAUtenteDTO(utente);
		}
		return null;
	}
	//new
	public UtenteDTO modificaUtente(UtenteDTO dto) {
		// trasformo
		Utente utente = Conversioni.daUtenteDTOAUtente(dto);
		// aggiorno
		utente = dao.update(utente);
		if (utente != null) {
			// trasformo di nuovo
			return Conversioni.daUtenteAUtenteDTO(utente);
		}
		return null;
	}
	//new
	public List<String> mostraNomi() {
		List<Utente> lista = dao.selectAll();
		List<String> nomi = new ArrayList<>();
		for (Utente utente : lista) {
			nomi.add(utente.getNome());
		}
		return nomi;
	}
	//new
	public List<String> mostraNomiCognomi() {
		List<Utente> lista = dao.selectAll();
		List<String> nomiCognomi = new ArrayList<>();
		for (Utente utente : lista) {
			nomiCognomi.add(utente.getNome() + " " + utente.getCognome());
		}
		return nomiCognomi;
	}
}
