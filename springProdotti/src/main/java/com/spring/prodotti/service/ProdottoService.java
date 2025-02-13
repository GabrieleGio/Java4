package com.spring.prodotti.service;

import java.util.ArrayList;
// caricamento prodotto
// visualizzazione prodotti senza id
// visualizzazione prodotti con id
// visualizzazione di un report sui prodotti caricati con la classe ReportDTO
import java.util.List;

import com.spring.prodotti.dao.DAOProdotto;
import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.dto.ReportDTO;
import com.spring.prodotti.entity.Prodotto;
import com.spring.prodotti.utility.Conversioni;

public class ProdottoService {
	private DAOProdotto dao = new DAOProdotto();
	
	public void registra(ProdottoDTO dto) {
		Prodotto entity = Conversioni.daProdottoDTOAProdotto(dto);
		dao.insert(entity);
	}
	
	public ProdottoDTO cercaPerId(int id) {
		Prodotto prodotto = dao.selectById(id);
		return Conversioni.daProdottoAProdottoDTO(prodotto);
	}
	
	public ArrayList<ProdottoDTO> mostraTutti() {
		List<Prodotto> lista = dao.selectAll();
		ArrayList<ProdottoDTO> listaDto = new ArrayList<>();
		for (Prodotto prodotto : lista) {
			ProdottoDTO dto = Conversioni.daProdottoAProdottoDTO(prodotto);
			listaDto.add(dto);
		}
		return listaDto;
	}
	
	public ReportDTO generaReport() {
		List<Prodotto> lista = dao.selectAll();
		return Conversioni.generaReportDaProdotti(lista);
	}
	
	
	
	
}
