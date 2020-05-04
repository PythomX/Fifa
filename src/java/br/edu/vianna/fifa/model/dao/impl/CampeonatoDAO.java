/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Campeonato;
import br.edu.vianna.fifa.model.dto.CampeonatoDTO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author mateu
 */
public class CampeonatoDAO extends GenericDAO<Campeonato, Long>{

    @Override
    public Campeonato findById(Long key) throws SQLException {
        return conexao.find(Campeonato.class, key);
    }

    @Override
    public List<Campeonato> findAll() throws SQLException {

        Query q = conexao.createNamedQuery("Campeonato.findAll");
        
        return (List<Campeonato>) q.getResultList();
    }
    
    public List<Campeonato> findAllForTable() throws SQLException{
       
        Query q = conexao.createNamedQuery("Campeonato.findAllForTable");
        
        return (List<Campeonato>) q.getResultList();
        
    }
    
    
    public List<CampeonatoDTO> findAmountTimesForTable() throws SQLException{
       
        Query q = conexao.createQuery("SELECT NEW br.edu.vianna.fifa.model.dto.CampeonatoDTO"
                + " (c.id, count(t)) FROM Campeonato c LEFT JOIN c.timeList t GROUP BY c.id");
        
        return q.getResultList();
        
    }
    
    public CampeonatoDTO findAmountTimesByChamp(Long id) throws SQLException{
       
        Query q = conexao.createQuery("SELECT NEW br.edu.vianna.fifa.model.dto.CampeonatoDTO"
                + " (c.id, count(t)) FROM Campeonato c LEFT JOIN c.timeList t WHERE c.id = :id GROUP BY c.id");
        
        q.setParameter("id", id);
        return (CampeonatoDTO) q.getSingleResult();
        
    }
    
    
}
