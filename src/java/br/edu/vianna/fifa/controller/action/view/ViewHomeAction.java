/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.JogadorDAO;
import br.edu.vianna.fifa.model.domain.Jogador;
import br.edu.vianna.fifa.model.domain.Usuario;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewHomeAction implements ICommanderAction {

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=home");
        
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        List<Jogador> jogadores = new JogadorDAO().findAllByIdTime(user.getIdTime().getId());

        request.setAttribute("jogadores", jogadores);
        
        
        rd.forward(request, response);
    }

    @Override
    public boolean pageReleased() {
        return false;
    }

}
