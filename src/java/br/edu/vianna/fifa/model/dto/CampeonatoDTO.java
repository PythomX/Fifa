/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dto;

import br.edu.vianna.fifa.model.domain.Time;
import java.util.Date;

/**
 *
 * @author mateu
 */
public class CampeonatoDTO {
 
    private int id;
    private Date data;
    private int times;

    public CampeonatoDTO() {
    }

    public CampeonatoDTO(int id, Date data, int time) {
        this.id = id;
        this.data = data;
        this.times = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTime() {
        return times;
    }

    public void setTime(int time) {
        this.times = time;
    }

    
    
    
    
}
