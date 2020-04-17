/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewLoginAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewErroPopupAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewSucessPopupAction;
import br.edu.vianna.fifa.model.dao.impl.UsuarioDAO;
import br.edu.vianna.fifa.model.domain.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewSaveUserAction implements ICommanderAction {

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {

            Usuario usu = new Usuario(null,
                    request.getParameter("nome"),
                    request.getParameter("login"),
                    request.getParameter("senha"));

            UsuarioDAO usudao = new UsuarioDAO();

            usudao.insert(usu);

            new ViewSucessPopupAction().openPage(request, response);
            //new ViewLoginAction().openPage(request, response);

        } catch (Exception e) {
            new ViewErroPopupAction().openPage(request, response);
            new ViewLoginAction().openPage(request, response);
        }

    }

}
