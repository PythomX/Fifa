/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewListaUsuariosAction;
import br.edu.vianna.fifa.model.dao.impl.UsuarioDAO;
import br.edu.vianna.fifa.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class DeleteUserAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Long id = Long.parseLong(request.getParameter("id"));
        Usuario user = new UsuarioDAO().findById(id);
        
        new UsuarioDAO().delete(user);

        response.sendRedirect("fifa?page=listaUsuarios");

    }

}
