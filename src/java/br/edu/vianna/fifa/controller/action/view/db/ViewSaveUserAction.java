/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewErroPopupAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewSucessPopupAction;
import br.edu.vianna.fifa.model.dao.impl.UsuarioDAO;
import br.edu.vianna.fifa.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewSaveUserAction implements ICommanderAction {

    private Usuario usu;

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {

            UsuarioDAO usudao = new UsuarioDAO();

            usu = usudao.findLogin(request.getParameter("login"));

            if (usu == null) {
                usu = new Usuario();
                usu.setNome(request.getParameter("nome"));
                usu.setLogin(request.getParameter("login"));
                usu.setSenha(request.getParameter("senha"));

                usudao.insert(usu);

                new ViewSucessPopupAction().openPage(request, response);
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            new ViewErroPopupAction().openPage(request, response);
        }

    }

}
