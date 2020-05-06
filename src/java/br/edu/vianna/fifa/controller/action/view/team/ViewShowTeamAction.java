/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.team;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.JogadorDAO;
import br.edu.vianna.fifa.model.dao.impl.TimeDAO;
import br.edu.vianna.fifa.model.domain.Jogador;
import br.edu.vianna.fifa.model.domain.Time;
import br.edu.vianna.fifa.model.domain.Usuario;
import br.edu.vianna.fifa.model.domain.e.EPosicao;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewShowTeamAction implements ICommanderAction{

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=showTeam");

        Usuario user = (Usuario) request.getSession().getAttribute("user");
        Time time = new TimeDAO().findByIdUser(user.getId());
        if (time != null) {
            
            List<Jogador> jogadores = new JogadorDAO().findAllByIdTime(time.getId());

            time.setJogadorList(jogadores);

            EPosicao[] posicoes = EPosicao.values();

            request.setAttribute("time", time);
            request.setAttribute("posicoes", posicoes);

            rd.forward(request, response);
            
        } else{
            
            request.setAttribute("erro", "Nenhum time cadastrado!");
            new ViewNewTeamAction().openPage(request, response);
            
        }
        
    }
    
}
