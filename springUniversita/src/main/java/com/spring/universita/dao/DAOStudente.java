package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Studente;

public class DAOStudente {
	private Map<Integer, Studente> mappa = new HashMap<>();

	public boolean insert(Studente studente) {
		if(!mappa.containsKey(studente.getMatricola())) {
			mappa.put(studente.getMatricola(), studente);
			return true;
		}
		throw new RuntimeException("utente giÃ presente " + studente.getMatricola());
	}
	
	public boolean delete(int matricola) {
		if(mappa.get(matricola)!= null) {
			mappa.remove(matricola);
			return true;
		}
		return false;
	}

	public List<Studente> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Studente selectByMatricola(int matricola) {
		return mappa.get(matricola);
	}
	// new
	public Studente updateIndirizzo(Integer matricolaStudente, String newIndirizzo) {
		if (!mappa.containsKey(matricolaStudente)) {
			return null;
		}
		mappa.get(matricolaStudente).setIndirizzo(newIndirizzo);
		return mappa.get(matricolaStudente);
	}
}
