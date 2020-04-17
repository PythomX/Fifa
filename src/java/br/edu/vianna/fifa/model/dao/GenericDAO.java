/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author mateu
 */
public abstract class GenericDAO<C, K> {

    protected final EntityManager conexao;

    public GenericDAO() {
        conexao = Connection.getInstance().getConnection();
    }

    public C insert(C obj) throws SQLException {

        EntityTransaction transaction = conexao.getTransaction();

        transaction.begin();
        conexao.persist(obj);
        transaction.commit();

        return obj;
    }
    
    public C update(C obj) throws SQLException {

        EntityTransaction transaction = conexao.getTransaction();

        transaction.begin();
        conexao.merge(obj);
        transaction.commit();

        return obj;
    }
    
    public C delete(C obj) throws SQLException {

        EntityTransaction transaction = conexao.getTransaction();

        transaction.begin();
        conexao.remove(obj);
        transaction.commit();

        return obj;
    }
    
    public abstract C findById(K key) throws SQLException;
    
    public abstract C findAll(K key) throws SQLException;
    

}
