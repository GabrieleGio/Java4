package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Professore;

public class DAOProfessore {
	private Map<Integer, Professore> mappa = new HashMap<>();

	public boolean insert(Professore professore) {
		if(!mappa.containsKey(professore.getId())) {
			mappa.put(professore.getId(), professore);
			return true;
		}
		throw new RuntimeException("utente giÃ presente " + professore.getId());
	}
	
	public boolean delete(int id) {
		if(mappa.get(id)!= null) {
			mappa.remove(id);
			return true;
		}
		return false;
	}

	public List<Professore> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Professore selectById(int id) {
		return mappa.get(id);
	}

	public Professore updateMateria(int id, String materia) {
		if (!mappa.containsKey(id)) {
			return null;
		}
		mappa.get(id).setMateria(materia);
		return mappa.get(id);
	}
}
