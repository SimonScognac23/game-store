package com.gamestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;





import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;






@Entity
@Table(name = "dipendente")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Dipendente")
    private int idDipendente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @ManyToOne
    @JoinColumn(name = "titolare_id")
    private Titolare titolare;

    // Getters and Setters

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

    public Titolare getTitolare() {
        return titolare;
    }

    public void setTitolare(Titolare titolare) {
        this.titolare = titolare;
    }
}
