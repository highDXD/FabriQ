/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.votacao.relatorioservice;

/**
 *
 * @author FBQ-DEV2
 */
public class Candidato {

    private String nome;
    private Long id;
    private int votos;

    public Candidato() {
    }

    public Candidato(String nome, Long id, int votos) {
        this.nome = nome;
        this.id = id;
        this.votos = votos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

}
