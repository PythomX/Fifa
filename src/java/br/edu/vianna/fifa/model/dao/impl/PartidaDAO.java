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
public class PartidaDAO extends GenericDAO<PartidaDAO, Long>{

    @Override
    public PartidaDAO findById(Long key) throws SQLException {
        return conexao.find(PartidaDAO.class, key);
    }

    @Override
    public PartidaDAO findAll(Long key) throws SQLException {
        
        Query q = conexao.createNamedQuery("Partida.findAll");
        
        return (PartidaDAO) q.getResultList();
    }
    
}
