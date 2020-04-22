/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao.impl;

import br.edu.vianna.fifa.model.dao.GenericDAO;
import br.edu.vianna.fifa.model.domain.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author mateu
 */
public class UsuarioDAO extends GenericDAO<Usuario, Long> {

    @Override
    public Usuario findById(Long key) throws SQLException {
        return conexao.find(Usuario.class, key);
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
        Query q = conexao.createNamedQuery("Usuario.findAll");

        return (List<Usuario>) q.getResultList();

    }

    public Usuario findLogin(String login) throws SQLException {

        Query q = conexao.createNamedQuery("Usuario.findByLogin");

        try {
            q.setParameter("login", login);
            return (Usuario) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }
    
    public Usuario findByAccount(String login, String senha) throws SQLException {

        Query q = conexao.createNamedQuery("Usuario.findByAccount");

        try {
            q.setParameter("login", login);
            q.setParameter("senha", senha);
            return (Usuario) q.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

}
