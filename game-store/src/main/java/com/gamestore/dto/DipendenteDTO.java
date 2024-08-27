package com.gamestore.dto;


public class DipendenteDTO {
	
	// dto è un oggetto usato per trasportare dati tra diverse parti di un applicazione
	
	   
	    private int idDipendente;	 
	    private String nome;
	    private String cognome;
	  	
	    public int getIdDipendente() {
	        return idDipendente;
	    }

	    public void setIdDipendente(int idDipendente) {
	        this.idDipendente = idDipendente;
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

	
	}