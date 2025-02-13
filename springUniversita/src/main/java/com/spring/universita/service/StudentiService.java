package com.spring.universita.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.universita.dao.DAOStudente;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.entity.Studente;
import com.spring.universita.utility.Conversioni;

public class StudentiService {
	// Sviluppa le seguenti funzionalità:
	
	// Inserisci nuovo studente
	// Cerca studente per matricola
	// Visualizza tutti gli studenti
	// Cancella uno studente (specificando la matricola)
	// Modifica indirizzo studente (specificando la matricola e il nuovo indirizzo)
	
	// Opzionali:
	// Visualizza l'elenco dei nomi degli studenti
	// Visualizza lo studente più giovane
	// Visualizza lo studente iscritto da più tempo
	
	private DAOStudente dao = new DAOStudente();
	
	public void inserisci (StudenteDTO dto) {
		Studente entity = Conversioni.daStudenteDTOAStudente(dto);
		dao.insert(entity);
	}
	
	public StudenteDTO cercaPerMatricola(int matricola) {
		Studente studente = dao.selectByMatricola(matricola);
		return Conversioni.daStudenteAStudenteDTO(studente);
	}
	
	public ArrayList<StudenteDTO> mostraTutti() {
		List<Studente> lista = dao.selectAll();
		ArrayList<StudenteDTO> listaDto = new ArrayList<>();
		for (Studente studente : lista) {
			StudenteDTO dto = Conversioni.daStudenteAStudenteDTO(studente);
			listaDto.add(dto);
		}
		return listaDto;
	}
	
	public void cancellaPerMatricola(int matricola) {
		dao.delete(matricola);
	}
	
	public StudenteDTO modificaIndirizzo(int matricola, String indirizzo) {
		Studente studente = dao.updateIndirizzo(matricola, indirizzo);
		if (studente != null) {
			return Conversioni.daStudenteAStudenteDTO(studente);
		}
		return null;
	}
	
	public String[] nomiStudenti() {
		List<Studente> lista = dao.selectAll();
		String[] nomi = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			nomi[i] = lista.get(i).getNome();
		}
		return nomi;
	}
	
	public StudenteDTO studentePiuGiovane() {
		List<Studente> lista = dao.selectAll();
		Studente studentePiuGiovane = lista.get(0);
		for (Studente studente : lista) {
			if (studente.getAnnoDiNascita() > studentePiuGiovane.getAnnoDiNascita()) {
				studentePiuGiovane = studente;
			}
		}
		return Conversioni.daStudenteAStudenteDTO(studentePiuGiovane);
	}
	
	public StudenteDTO studenteIscrittoDaPiuTempo() {
		List<Studente> lista = dao.selectAll();
		Studente studenteIscrittoDaPiuTempo = lista.get(0);
		for (Studente studente : lista) {
			if (studente.getAnnoDiImmatricolazione() < studenteIscrittoDaPiuTempo.getAnnoDiImmatricolazione()) {
				studenteIscrittoDaPiuTempo = studente;
			}
		}
		return Conversioni.daStudenteAStudenteDTO(studenteIscrittoDaPiuTempo);
	}
}
