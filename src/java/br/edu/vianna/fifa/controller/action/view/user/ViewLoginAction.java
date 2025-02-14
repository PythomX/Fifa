/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.user;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewHomeAction;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewLoginAction implements ICommanderAction {

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        if (request.getSession().getAttribute("user") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");

        rd.forward(request, response);
        } else {
            new ViewHomeAction().openPage(request, response);
        }
        
    }

    @Override
    public boolean pageReleased() {
        return true;
    }


}
