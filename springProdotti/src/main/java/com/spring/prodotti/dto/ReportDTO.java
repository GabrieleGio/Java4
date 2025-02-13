package com.spring.prodotti.dto;

import java.util.List;
import java.util.Map;

public class ReportDTO {
	// Questa classe conterrà:
	// Elenco delle descrizioni di tutti i prodotti -> List<String>
	// Numero di pezzi totali immagazzinati (somma delle quantità) -> int
	// Numero totale dei prodotti NON disponibili -> int	
	// La media di tutti i prezzi -> double
	// L'elenco dei nomi dei prodotti NON disponibili -> List<String>
	// L'elenco degli ID dei prodotti per ciascuna categoria presente -> Map<String, List<Integer>>
	
	private List<String> descrizioni;
	private int pezziTotali;
	private int nProdottiNonDisponibili;
	private double mediaPrezzi;
	private List<String> listaProdottiNonDisponibili;
	private Map<String, List<Integer>> listaIdProdottiXCategoria;
	
	public ReportDTO() {
		super();
	}
	
	public ReportDTO(List<String> descrizioni, int pezziTotali, int nProdottiNonDisponibili, double mediaPrezzi,
			List<String> listaProdottiNonDisponibili, Map<String, List<Integer>> listaIdProdottiXCategoria) {
		super();
		this.descrizioni = descrizioni;
		this.pezziTotali = pezziTotali;
		this.nProdottiNonDisponibili = nProdottiNonDisponibili;
		this.mediaPrezzi = mediaPrezzi;
		this.listaProdottiNonDisponibili = listaProdottiNonDisponibili;
		this.listaIdProdottiXCategoria = listaIdProdottiXCategoria;
	}

	public List<String> getDescrizioni() {
		return descrizioni;
	}

	public void setDescrizioni(List<String> descrizioni) {
		this.descrizioni = descrizioni;
	}

	public int getPezziTotali() {
		return pezziTotali;
	}

	public void setPezziTotali(int pezziTotali) {
		this.pezziTotali = pezziTotali;
	}

	public int getnProdottiNonDisponibili() {
		return nProdottiNonDisponibili;
	}

	public void setnProdottiNonDisponibili(int nProdottiNonDisponibili) {
		this.nProdottiNonDisponibili = nProdottiNonDisponibili;
	}

	public double getMediaPrezzi() {
		return mediaPrezzi;
	}

	public void setMediaPrezzi(double mediaPrezzi) {
		this.mediaPrezzi = mediaPrezzi;
	}

	public List<String> getListaProdottiNonDisponibili() {
		return listaProdottiNonDisponibili;
	}

	public void setListaProdottiNonDisponibili(List<String> listaProdottiNonDisponibili) {
		this.listaProdottiNonDisponibili = listaProdottiNonDisponibili;
	}

	public Map<String, List<Integer>> getListaIdProdottiXCategoria() {
		return listaIdProdottiXCategoria;
	}

	public void setListaIdProdottiXCategoria(Map<String, List<Integer>> listaIdProdottiXCategoria) {
		this.listaIdProdottiXCategoria = listaIdProdottiXCategoria;
	}

	
	
	

}
