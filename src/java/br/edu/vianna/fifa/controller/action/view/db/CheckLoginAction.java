/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewHomeAction;
import br.edu.vianna.fifa.controller.action.view.ViewLoginAction;
import br.edu.vianna.fifa.model.dao.impl.UsuarioDAO;
import br.edu.vianna.fifa.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class CheckLoginAction implements ICommanderAction {
    
    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Usuario user = new UsuarioDAO().findByAccount(login, senha);

        if (user != null) {
            
        request.getSession().setAttribute("user", user);
        request.setAttribute("user", user);
        new ViewHomeAction().openPage(request, response);
        } else{
            request.setAttribute("err", "Login ou senha incorretos!");
            new ViewLoginAction().openPage(request, response);
        }

    }

    @Override
    public boolean pageReleased() {
        return true;
    }


}
