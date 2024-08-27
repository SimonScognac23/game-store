package com.gamestore.model;


import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "tipologia")
public class Tipologia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipologia")
    private int idTipologia;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "tipologia")
    private Set<Videogioco> videogiochi;

    // Getters and Setters

    public int getIdTipologia() {
        return idTipologia;
    }

    public void setIdTipologia(int idTipologia) {
        this.idTipologia = idTipologia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Videogioco> getVideogiochi() {
        return videogiochi;
    }

    public void setVideogiochi(Set<Videogioco> videogiochi) {
        this.videogiochi = videogiochi;
    }
}
