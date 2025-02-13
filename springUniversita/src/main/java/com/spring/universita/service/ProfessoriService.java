package com.spring.universita.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.universita.dao.DAOProfessore;
import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.entity.Professore;
import com.spring.universita.utility.Conversioni;

public class ProfessoriService {
	// Sviluppa le seguenti funzionalità:
	
	// Inserisci nuovo professore
	// Cerca professore per id
	// Visualizza tutti i professori
	// Cancella un professore (specificando l'id)
	// Modifica la materia insegnata dal professore (specificando l'id del prof e la nuova materia)
	
	// Opzionali:
	// Visualizza i cognomi dei professori
	// Visualizza tutti i professori che insegnano una materia specificata
	// Visualizza i professori ordinati per cognome
	
	private DAOProfessore dao = new DAOProfessore();
	
	public void inserisci(ProfessoreDTO dto) {
		Professore entity = Conversioni.daProfessoreDTOAProfessore(dto);
		dao.insert(entity);
	}
	
	public ProfessoreDTO cercaPerId(int id) {
		Professore professore = dao.selectById(id);
		return Conversioni.daProfessoreAProfessoreDTO(professore);
	}
	
	public ArrayList<ProfessoreDTO> mostraTutti() {
		List<Professore> lista = dao.selectAll();
		ArrayList<ProfessoreDTO> listaDto = new ArrayList<>();
		for (Professore professore : lista) {
			ProfessoreDTO dto = Conversioni.daProfessoreAProfessoreDTO(professore);
			listaDto.add(dto);
		}
		return listaDto;
	}
	
	public void cancellaPerId(int id) {
		dao.delete(id);
	}
	
	public ProfessoreDTO modificaMateria(int id, String materia) {
		Professore professore = dao.updateMateria(id, materia);
		if (professore != null) {
			return Conversioni.daProfessoreAProfessoreDTO(professore);
		}
		return null;
	}
	
	public String[] cognomiProfessori() {
		List<Professore> lista = dao.selectAll();
		String[] cognomi = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			cognomi[i] = lista.get(i).getCognome();
		}
		return cognomi;
	}
	
	public ArrayList<ProfessoreDTO> mostraPerMateria(String materia) {
		List<Professore> lista = dao.selectAll();
		ArrayList<ProfessoreDTO> listaDto = new ArrayList<>();
		for (Professore professore : lista) {
			if (professore.getMateria().equals(materia)) {
				ProfessoreDTO dto = Conversioni.daProfessoreAProfessoreDTO(professore);
				listaDto.add(dto);
			}
		}
		return listaDto;
	}
	
	public ArrayList<ProfessoreDTO> professoriOrdinatiPerCognome() {
		List<Professore> lista = dao.selectAll();
		lista.sort((p1, p2) -> p1.getCognome().compareTo(p2.getCognome()));
		ArrayList<ProfessoreDTO> listaDto = new ArrayList<>();
		for (Professore professore : lista) {
			ProfessoreDTO dto = Conversioni.daProfessoreAProfessoreDTO(professore);
			listaDto.add(dto);
		}
		return listaDto;
	}
	
	
	
	
}
