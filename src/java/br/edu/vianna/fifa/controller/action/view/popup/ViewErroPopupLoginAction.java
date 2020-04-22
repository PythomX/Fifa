/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.popup;

import br.edu.vianna.fifa.controller.ICommanderAction;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewErroPopupLoginAction implements ICommanderAction{

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher rd = request.getRequestDispatcher("pages/popup/erroPopupLogin.jsp");
        rd.forward(request, response);
        
    }
    
}
