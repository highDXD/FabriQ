/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.service.votoservice;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author FBQ-DEV2
 */
@Entity
@Table
public class Candidato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "votos")
    private int votos;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Candidato() {
    }

    public Candidato(Long id, String nome, int votos) {
        this.id = id;
        this.nome = nome;
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Candidato{" + "id=" + id + ", nome=" + nome + ", votos=" + votos + '}';
    }

}
