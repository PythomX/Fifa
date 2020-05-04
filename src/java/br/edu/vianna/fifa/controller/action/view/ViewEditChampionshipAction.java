/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.CampeonatoDAO;
import br.edu.vianna.fifa.model.dao.impl.GolDAO;
import br.edu.vianna.fifa.model.dao.impl.PartidaDAO;
import br.edu.vianna.fifa.model.dao.impl.TimeDAO;
import br.edu.vianna.fifa.model.domain.Campeonato;
import br.edu.vianna.fifa.model.domain.Gol;
import br.edu.vianna.fifa.model.domain.Partida;
import br.edu.vianna.fifa.model.dto.CampeonatoDTO;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class ViewEditChampionshipAction implements ICommanderAction{

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=editChamp");
        
        Long id = Long.parseLong(request.getParameter("id"));
        Campeonato champ = new CampeonatoDAO().findById(id);
        List<Partida> partidas = new PartidaDAO().findMatchByChamp(champ.getId());
        CampeonatoDTO quantidade = new CampeonatoDAO().findAmountTimesByChamp(id);
        
        //List<Gol> gols = new GolDAO();
        /*
        for (Partida partida : partidas) {
            Partida match = new PartidaDAO().findById(partida.getId());
            Gol gol = new Gol();
            
            gol.setIdPartida(partida);
        }*/
        
        request.setAttribute("partidas", partidas);
        request.setAttribute("quantidade", quantidade);
        request.setAttribute("champ", champ);
        rd.forward(request, response);
        
    }
    
}
