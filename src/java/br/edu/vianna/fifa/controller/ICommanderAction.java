/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public interface ICommanderAction {
 
    public boolean pageReleased();
    
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
}
