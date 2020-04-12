/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Time;
import java.sql.SQLException;
import javax.persistence.Query;

/**
 *
 * @author mateu
 */
public class TimeDAO extends GenericDAO<Time, Long>{

    @Override
    public Time findById(Long key) throws SQLException {
        return conexao.find(Time.class, key);
    }

    @Override
    public Time findAll(Long key) throws SQLException {
        
        Query q = conexao.createNamedQuery("Time.findAll");
        
        return (Time) q.getResultList();
    }
    
}
