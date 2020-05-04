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

    public CampeonatoDTO(Long id, Long times) {
        this.id = id;
        this.times = times;
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
    
    

    
    
    
    
}
