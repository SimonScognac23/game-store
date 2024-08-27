package com.gamestore.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "titolare")
public class Titolare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titolare")
    private int idTitolare;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @OneToMany(mappedBy = "titolare")
    private Set<Dipendente> dipendenti;

    // Getters and Setters

    public int getIdTitolare() {
        return idTitolare;
    }

    public void setIdTitolare(int idTitolare) {
        this.idTitolare = idTitolare;
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

    public Set<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(Set<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }
}