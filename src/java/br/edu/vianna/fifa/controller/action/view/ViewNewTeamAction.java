/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.JogadorDAO;
import br.edu.vianna.fifa.model.domain.Jogador;
import br.edu.vianna.fifa.model.domain.e.EPosicao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewNewTeamAction implements ICommanderAction{

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=newTeam");

        EPosicao[] posicoes = EPosicao.values();
        
        request.setAttribute("posicoes", posicoes);
        
        rd.forward(request, response);
    }
    
}
