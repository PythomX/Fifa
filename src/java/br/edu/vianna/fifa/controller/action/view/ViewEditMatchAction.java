/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.GolDAO;
import br.edu.vianna.fifa.model.dao.impl.PartidaDAO;
import br.edu.vianna.fifa.model.domain.Gol;
import br.edu.vianna.fifa.model.domain.Partida;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewEditMatchAction implements ICommanderAction{

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

    RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=editMatch");
        
        Long id = Long.parseLong(request.getParameter("id"));
        Partida partida = new PartidaDAO().findById(id);
        
        List<Gol> first = new GolDAO().findByFirstTeam(partida.getId());
        
        List<Gol> second = new GolDAO().findBySecondTeam(partida.getId());
        
        request.setAttribute("partida", partida);
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        rd.forward(request, response);
    
    }
    
}
