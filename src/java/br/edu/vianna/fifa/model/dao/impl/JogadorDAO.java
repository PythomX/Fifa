/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Jogador;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author mateu
 */
public class JogadorDAO extends GenericDAO<Jogador, Long>{

    @Override
    public Jogador findById(Long key) throws SQLException {
        return conexao.find(Jogador.class, key);
    }

    @Override
    public List<Jogador> findAll() throws SQLException {
        
        Query q = conexao.createNamedQuery("Jogador.findAll");
        
        return (List<Jogador>) q.getResultList();
    }
    
    public List<Jogador> findAllPosition() throws SQLException {
        
        Query q = conexao.createNamedQuery("Jogador.findAllPosition");
        
        return (List<Jogador>) q.getResultList();
    }
    
    public List<Jogador> findAllByIdTime(Long key) throws SQLException {
        
        Query q = conexao.createNamedQuery("Jogador.findAllByIdTime");
       
        q.setParameter("id", key);
        return (List<Jogador>) q.getResultList();
    }
    
}
