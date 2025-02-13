package com.spring.utente.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.utente.entity.Utente;


@Repository
public class DAOUtenteImpl implements DAOUtente {

private Map<Integer, Utente> mappa = new HashMap<>();

public void insert(Utente utente) {
if(mappa.containsKey(utente.getId()))
throw new RuntimeException("utente giÃ presente " + utente.getId());

mappa.put(utente.getId(), utente);

}

public boolean delete(Integer idUtente) {
Utente utente = mappa.remove(idUtente);
if(utente!=null)
return true;
else
return false;
}


public Utente updatePassword(Integer idUtente, String newPass) {
if(!mappa.containsKey(idUtente)) {
return null;
}
mappa.get(idUtente).setPassword(newPass);
return mappa.get(idUtente);
}


public List<Utente> selectAll(){
return new ArrayList<>(mappa.values());}


public Utente selectById(Integer idUtente) {
return mappa.get(idUtente);
}


public Utente update(Utente utente) {
if(!mappa.containsKey(utente.getId())) {
return null;
}
mappa.put(utente.getId(), utente);
return mappa.get(utente.getId());
}




}