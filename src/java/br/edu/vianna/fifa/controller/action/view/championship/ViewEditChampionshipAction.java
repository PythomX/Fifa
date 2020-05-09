/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.championship;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.CampeonatoDAO;
import br.edu.vianna.fifa.model.dao.impl.GolDAO;
import br.edu.vianna.fifa.model.dao.impl.PartidaDAO;
import br.edu.vianna.fifa.model.domain.Campeonato;
import br.edu.vianna.fifa.model.domain.Gol;
import br.edu.vianna.fifa.model.domain.Partida;
import br.edu.vianna.fifa.model.domain.Time;
import br.edu.vianna.fifa.model.dto.CampeonatoDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeanv
 */
public class ViewEditChampionshipAction implements ICommanderAction {

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

        
        Map<Partida, Pair <Integer, Integer>> matchGoals = new HashMap<>();
        
        Integer firstTeamGoals, secondTeamGoals;
        for (Partida partida : partidas) {
            if (!partida.getFinalizado()) {
                continue;
            }
            
            Time first = partida.getIdPrimeiroTime();
            List<Gol> gols = new GolDAO().findAllByMatch(partida.getId());
            firstTeamGoals = 0;
            secondTeamGoals = 0;
            for (Gol gol : gols) {
                if (gol.getIdJogador().getIdTime().equals(first)) {
                    firstTeamGoals++;
                } else{
                    secondTeamGoals++;
                }
            }
            matchGoals.put(partida, new Pair(firstTeamGoals, secondTeamGoals));
            
        }
        
        request.setAttribute("partidas", partidas);
        request.setAttribute("quantidade", quantidade);
        request.setAttribute("matchGoals", matchGoals);
        request.setAttribute("champ", champ);
        rd.forward(request, response);

    }

}
