/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dto;

import java.util.Date;

/**
 *
 * @author mateu
 */
public class CampeonatoDTO {
 
    private Long id;
    private Long times;
    private Date data;
    private String nome;

    public CampeonatoDTO() {
    }

    public CampeonatoDTO(Long id, Long times, Date data, String nome) {
        this.id = id;
        this.times = times;
        this.data = data;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    

    
    
    
    
}
