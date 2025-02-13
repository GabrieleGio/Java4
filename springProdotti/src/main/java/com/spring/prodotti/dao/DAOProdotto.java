package com.spring.prodotti.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.prodotti.entity.Prodotto;

public class DAOProdotto {
	
	private Map<Integer, Prodotto> mappa = new HashMap<>();

	public boolean insert(Prodotto prodotto) {
		if(!mappa.containsKey(prodotto.getId())) {
			mappa.put(prodotto.getId(), prodotto);
			return true;
		}
		return false;
	}
	
	public boolean delete(int id) {
		if(mappa.get(id)!= null) {
			mappa.remove(id);
			return true;
		}
		return false;
	}

	public List<Prodotto> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Prodotto selectById(int id) {
		return mappa.get(id);
	}

}