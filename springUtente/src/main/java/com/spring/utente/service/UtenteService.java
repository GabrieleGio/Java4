package com.spring.utente.service;

import java.util.List;

import com.spring.utente.dto.UtenteDTO;

public interface UtenteService {
	// occhio che sono disordinati
	public void registra(UtenteDTO dto);
	public UtenteDTO cercaPerId(int id);
	public void cancellaPerId(int id);
	public UtenteDTO modificaPassword(int id, String newPass);
	public UtenteDTO modificaUtente(UtenteDTO dto);
	public List<String> mostraNomi();
	public List<UtenteDTO> mostraTutti();
	public List<String> mostraNomiCognomi();
}
