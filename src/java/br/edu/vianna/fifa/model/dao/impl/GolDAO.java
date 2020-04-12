/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Gol;
import java.sql.SQLException;
import javax.persistence.Query;

/**
 *
 * @author mateu
 */
public class GolDAO extends GenericDAO<Gol, Long>{

    @Override
    public Gol findById(Long key) throws SQLException {
        return conexao.find(Gol.class, key);
    }

    @Override
    public Gol findAll(Long key) throws SQLException {
        
        Query q = conexao.createNamedQuery("Gol.findAll");
        
        return (Gol) q.getResultList();
    }
    
}
