/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db.user;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.user.ViewLoginAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewErroPopupAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewSucessPopupAction;
import br.edu.vianna.fifa.model.dao.impl.TimeDAO;
import br.edu.vianna.fifa.model.dao.impl.UsuarioDAO;
import br.edu.vianna.fifa.model.domain.Time;
import br.edu.vianna.fifa.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class SaveUserAction implements ICommanderAction {

    private Usuario user;

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UsuarioDAO usudao = new UsuarioDAO();

        user = usudao.findLogin(request.getParameter("login"));

        if (user == null) {
            
            String nomeTime = request.getParameter("nomeTime");
            Time time = new Time(null, nomeTime);
            new TimeDAO().insert(time);
            
            
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            user = new Usuario(null, nome, login, senha, false);
            user.setIdTime(time);

            usudao.insert(user);
            new ViewSucessPopupAction().openPage(request, response);

        } else {
            new ViewErroPopupAction().openPage(request, response);
        }

    }

    @Override
    public boolean pageReleased() {
        return true;
    }

}
