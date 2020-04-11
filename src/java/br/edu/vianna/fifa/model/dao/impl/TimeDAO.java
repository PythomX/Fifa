/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import java.sql.SQLException;
import javax.persistence.Query;

/**
 *
 * @author mateu
 */
public class TimeDAO extends GenericDAO<TimeDAO, Long>{

    @Override
    public TimeDAO findById(Long key) throws SQLException {
        return conexao.find(TimeDAO.class, key);
    }

    @Override
    public TimeDAO findAll(Long key) throws SQLException {
        
        Query q = conexao.createNamedQuery("Time.findAll");
        
        return (TimeDAO) q.getResultList();
    }
    
}
