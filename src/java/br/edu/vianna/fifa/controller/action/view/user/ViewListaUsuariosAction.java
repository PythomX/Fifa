/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.user;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.UsuarioDAO;
import br.edu.vianna.fifa.model.domain.Usuario;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeanv
 */
public class ViewListaUsuariosAction implements ICommanderAction{

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
         RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=listaUsuarios");
         
         List<Usuario> users = new UsuarioDAO().findAll();
         
         request.setAttribute("users", users);
         
         rd.forward(request, response);

    }
    
}
