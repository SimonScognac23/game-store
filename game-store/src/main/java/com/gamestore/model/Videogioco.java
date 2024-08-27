package com.gamestore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videogioco")
public class Videogioco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videogioco")
    private int idVideogioco;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "prezzo")
    private BigDecimal prezzo;

    @ManyToOne
    @JoinColumn(name = "tipologia_id")
    private Tipologia tipologia;

    @ManyToOne
    @JoinColumn(name = "genere_id")
    private Genere genere;

    // Getters and Setters

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

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
