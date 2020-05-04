/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dto;

import br.edu.vianna.fifa.model.domain.Time;
import java.sql.Timestamp;

/**
 *
 * @author mateu
 */
public class PartidaDTO {
    
    private Long id;
    private Timestamp dataHora;
    private Time primeiro;
    private Time segundo;

    public PartidaDTO(Long id, Timestamp dataHora, Time primeiro, Time segundo) {
        this.id = id;
        this.dataHora = dataHora;
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    public PartidaDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public Time getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Time primeiro) {
        this.primeiro = primeiro;
    }

    public Time getSegundo() {
        return segundo;
    }

    public void setSegundo(Time segundo) {
        this.segundo = segundo;
    }
    
    
    
    
}
