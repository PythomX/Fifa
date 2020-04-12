/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Partida;
import java.sql.SQLException;
import javax.persistence.Query;

/**
 *
 * @author mateu
 */
public class PartidaDAO extends GenericDAO<Partida, Long>{

    @Override
    public Partida findById(Long key) throws SQLException {
        return conexao.find(Partida.class, key);
    }

    @Override
    public Partida findAll(Long key) throws SQLException {
        
        Query q = conexao.createNamedQuery("Partida.findAll");
        
        return (Partida) q.getResultList();
    }
    
}
