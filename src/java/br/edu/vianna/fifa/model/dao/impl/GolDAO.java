/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Gol;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author jeanv
 */
public class GolDAO extends GenericDAO<Gol, Long>{

    @Override
    public Gol findById(Long key) throws SQLException {
        return conexao.find(Gol.class, key);
    }

    @Override
    public List<Gol> findAll() throws SQLException {
        
        Query q = conexao.createNamedQuery("Gol.findAll");
        
        return (List<Gol>) q.getResultList();
    }
    
    public List<Gol> findByFirstTeam(Long idPartida) throws SQLException{
        
        Query q = conexao.createNamedQuery("Gol.findByFirstTeam");
        
        q.setParameter("idPartida", idPartida);
        return q.getResultList();
        
    }
    
    public List<Gol> findBySecondTeam(Long idPartida) throws SQLException{
        
        Query q = conexao.createNamedQuery("Gol.findBySecondTeam");
        
        q.setParameter("idPartida", idPartida);
        return q.getResultList();
        
    }
    
    public List<Gol> findAllByMatch(Long idPartida) throws SQLException{
        
        Query q = conexao.createNamedQuery("Gol.findAllByMatch");
        
        q.setParameter("id", idPartida);
        return q.getResultList();
        
    }
}
