/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mateu
 */
public class Connection {
    
    private static Connection INSTANCE;
    private final EntityManager conexao;

    private Connection() {
        conexao = Persistence.createEntityManagerFactory("FifaPU").createEntityManager();
    }
    
    public EntityManager getConnection(){
        return conexao;
    }
    
    public static synchronized Connection getInstance(){
        
        if (INSTANCE == null) {
            INSTANCE = new Connection();
        }
        return INSTANCE;
    }
    
    
    
}
