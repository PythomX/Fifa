/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dto;

/**
 *
 * @author mateu
 */
public class JogadorArtilheiroDTO {
    
    private Long id;
    private String nome;
    private Long timeId;
    private String timeNome;
    private Long gols;

    public JogadorArtilheiroDTO(Long id, String nome, Long timeId, String timeNome, Long gols) {
        this.id = id;
        this.nome = nome;
        this.timeId = timeId;
        this.timeNome = timeNome;
        this.gols = gols;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTimeId() {
        return timeId;
    }

    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    public String getTimeNome() {
        return timeNome;
    }

    public void setTimeNome(String timeNome) {
        this.timeNome = timeNome;
    }

    public Long getGols() {
        return gols;
    }

    public void setGols(Long gols) {
        this.gols = gols;
    }
    
    
}
