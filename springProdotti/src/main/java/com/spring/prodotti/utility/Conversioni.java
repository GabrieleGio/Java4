package com.spring.prodotti.utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.dto.ReportDTO;
import com.spring.prodotti.entity.Prodotto;

public class Conversioni {
	
	public static Prodotto daProdottoDTOAProdotto(ProdottoDTO dto) {
		return new Prodotto(dto.getId(), dto.getMarca(), dto.getModello(), dto.getDescrizione(), dto.getPrezzocons(),
				dto.getPrezzomax(), dto.getQuantita(), dto.getCategoria());
	}
	
	public static ProdottoDTO daProdottoAProdottoDTO(Prodotto entity) {
		return new ProdottoDTO(entity.getId(), entity.getMarca(), entity.getModello(), entity.getDescrizione(),
				entity.getPrezzocons(), entity.getPrezzomax(), entity.getQuantita(), entity.getCategoria());
	}
	
	public static ReportDTO generaReportDaProdotti (Collection<Prodotto> prodotti) {
		// Questa classe conterrà:
		// Elenco delle descrizioni di tutti i prodotti -> List<String>
		// Numero di pezzi totali immagazzinati (somma delle quantità) -> int
		// Numero totale dei prodotti NON disponibili -> int	
		// La media di tutti i prezzi -> double
		// L'elenco dei nomi dei prodotti NON disponibili -> List<String>
		// L'elenco degli ID dei prodotti per ciascuna categoria presente -> Map<String, List<Integer>>
		
		List<String> descrizioni = new ArrayList<>();
		int pezziTotali = 0;
		List<Integer> prodottiNonDisponibili = new ArrayList<>();
		double sommaPrezzi = 0;
		double mediaPrezzi = 0;
		List<String> listaProdottiNonDisponibili = new ArrayList<>();
		Map<String, List<Integer>> listaIdProdottiXCategoria = new HashMap<>();
		
		for (Prodotto prodotto : prodotti) {
                   descrizioni.add(prodotto.getDescrizione());
                   pezziTotali += prodotto.getQuantita();
					if (prodotto.getQuantita() == 0) {
						prodottiNonDisponibili.add(prodotto.getId());
						listaProdottiNonDisponibili.add(prodotto.getMarca());
					}
					sommaPrezzi += prodotto.getPrezzocons();
					// Se la chiave c'è allora aggiungo un elemento, altrimenti creo la chiave da 0 e aggiungo un elemento
					if (listaIdProdottiXCategoria.containsKey(prodotto.getCategoria())) {
						listaIdProdottiXCategoria.get(prodotto.getCategoria()).add(prodotto.getId());
					} else {
						List<Integer> listaId = new ArrayList<>();
						listaId.add(prodotto.getId());
						listaIdProdottiXCategoria.put(prodotto.getCategoria(), listaId);
					}
			        }
		mediaPrezzi = sommaPrezzi / prodotti.size();
		return new ReportDTO(descrizioni, pezziTotali, prodottiNonDisponibili.size(), mediaPrezzi, listaProdottiNonDisponibili, listaIdProdottiXCategoria);
    }
	}

