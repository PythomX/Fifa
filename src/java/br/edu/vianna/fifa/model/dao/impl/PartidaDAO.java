/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Partida;
import br.edu.vianna.fifa.model.dto.PartidaDTO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author mateu
 */
public class PartidaDAO extends GenericDAO<Partida, Long> {

    @Override
    public Partida findById(Long key) throws SQLException {
        return conexao.find(Partida.class, key);
    }

    @Override
    public List<Partida> findAll() throws SQLException {

        Query q = conexao.createNamedQuery("Partida.findAll");

        return (List<Partida>) q.getResultList();
    }


    public List<Partida> findMatchByChamp(Long id) throws SQLException {

        Query q = conexao.createNamedQuery("Partida.findMatchByChamp");

        q.setParameter("id", id);
        return (List<Partida>) q.getResultList();

    }

    public List<Partida> findAllByTeam(Long id) throws SQLException{

        Query q = conexao.createNamedQuery("Partida.findAllByTeam");
        
        q.setParameter("id", id);
        return q.getResultList();
    
    }

}
