/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewAcessoNegado;
import br.edu.vianna.fifa.controller.action.view.ViewListaJogadoresAction;
import br.edu.vianna.fifa.model.dao.impl.UsuarioDAO;
import br.edu.vianna.fifa.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class UpdateUserAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        
            Long id = Long.parseLong(request.getParameter("id"));
            Usuario user = new UsuarioDAO().findById(id);

            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String nivelAcesso = request.getParameter("nivelAcesso");
            
            if (nivelAcesso.equals("Administrador")) {
                user.setNivelAcesso(true);
            } else if(nivelAcesso.equals("Player")){
                user.setNivelAcesso(false);
            } else{
                throw new Exception();
            }
                Usuario usuario = new Usuario(user.getId(), nome, login, senha, user.getNivelAcesso());
                new UsuarioDAO().update(usuario);
                new ViewListaJogadoresAction().openPage(request, response);

        
    }

}
