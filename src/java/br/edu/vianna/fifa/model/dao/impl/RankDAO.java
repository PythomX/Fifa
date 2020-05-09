/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Rank;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author jeanv
 */
public class RankDAO extends GenericDAO<Rank, Long> {

    @Override
    public Rank findById(Long key) throws SQLException {
        return conexao.find(Rank.class, key);
    }

    @Override
    public List<Rank> findAll() throws SQLException {
        Query q = conexao.createNamedQuery("Rank.findAll");

        return (List<Rank>) q.getResultList();
    }

    public List<Rank> findByIdChamp(Long id) throws SQLException {

        Query q = conexao.createNamedQuery("Rank.findByIdChamp");
        
        q.setParameter("id", id);
        return q.getResultList();
        
    }

    public Rank findByIdTimeAndChamp(Long idTime, Long idChamp) {

        Query q = conexao.createNamedQuery("Rank.findByIdTimeAndChamp");
        
        q.setParameter("idTime", idTime);
        q.setParameter("idChamp", idChamp);
        return (Rank) q.getSingleResult();
        
    }

}
