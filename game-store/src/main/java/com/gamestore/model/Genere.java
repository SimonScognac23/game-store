

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
@Table(name = "genere")
public class Genere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genere")
    private int idGenere;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "genere")
    private Set<Videogioco> videogiochi;

    // Getters and Setters

    public int getIdGenere() {
        return idGenere;
    }

    public void setIdGenere(int idGenere) {
        this.idGenere = idGenere;
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
