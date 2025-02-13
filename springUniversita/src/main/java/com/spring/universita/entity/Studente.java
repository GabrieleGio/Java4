package com.spring.universita.entity;

public class Studente {
	private int matricola;
	private String nome;
	private String cognome;
	private String indirizzo;
	private int annoDiNascita;
	private int annoDiImmatricolazione;
	
	public Studente() {
	}
	
	public Studente(int matricola, String nome, String cognome, String indirizzo, int annoDiNascita,
			int annoDiImmatricolazione) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.annoDiNascita = annoDiNascita;
		this.annoDiImmatricolazione = annoDiImmatricolazione;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getAnnoDiNascita() {
		return annoDiNascita;
	}

	public void setAnnoDiNascita(int annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}

	public int getAnnoDiImmatricolazione() {
		return annoDiImmatricolazione;
	}

	public void setAnnoDiImmatricolazione(int annoDiImmatricolazione) {
		this.annoDiImmatricolazione = annoDiImmatricolazione;
	}
	
	
}
