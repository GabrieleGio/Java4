package com.spring.prodotti.entity;

public class Prodotto {

	private int id;
	private String marca;
	private String modello;
	private String descrizione;
	private double prezzocons;
	private double prezzomax;
	private int quantita;
	private String categoria;
	
	public Prodotto() {
	}
	
	public Prodotto(int id, String marca, String modello, String descrizione, double prezzocons, double prezzomax,
			int quantita, String categoria) {
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.prezzocons = prezzocons;
		this.prezzomax = prezzomax;
		this.quantita = quantita;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzocons() {
		return prezzocons;
	}

	public void setPrezzocons(double prezzocons) {
		this.prezzocons = prezzocons;
	}

	public double getPrezzomax() {
		return prezzomax;
	}

	public void setPrezzomax(double prezzomax) {
		this.prezzomax = prezzomax;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", marca=" + marca + ", modello=" + modello + ", descrizione=" + descrizione
				+ ", prezzocons=" + prezzocons + ", prezzomax=" + prezzomax + ", quantita=" + quantita + ", categoria="
				+ categoria + "]";
	}
	
	
	
}
