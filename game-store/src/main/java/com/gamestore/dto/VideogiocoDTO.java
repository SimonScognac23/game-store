package com.gamestore.dto;

import java.math.BigDecimal;

public class VideogiocoDTO {
	
	
	    private int idVideogioco;

	
	    private String titolo;


	    private BigDecimal prezzo;


    public int getIdVideogioco() {
        return idVideogioco;
    }

    public void setIdVideogioco(int idVideogioco) {
        this.idVideogioco = idVideogioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

}
