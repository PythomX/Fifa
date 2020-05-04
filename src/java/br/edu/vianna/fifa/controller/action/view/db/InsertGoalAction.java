/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewEditChampionshipAction;
import br.edu.vianna.fifa.model.dao.impl.GolDAO;
import br.edu.vianna.fifa.model.dao.impl.JogadorDAO;
import br.edu.vianna.fifa.model.dao.impl.PartidaDAO;
import br.edu.vianna.fifa.model.domain.Gol;
import br.edu.vianna.fifa.model.domain.Jogador;
import br.edu.vianna.fifa.model.domain.Partida;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class InsertGoalAction implements ICommanderAction{

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Long idPartida = Long.parseLong(request.getParameter("matchId"));
        Long jogadorId = Long.parseLong(request.getParameter("jogadorId"));
        String tempo = request.getParameter("tempo");

        Partida partida = new PartidaDAO().findById(idPartida);
        Jogador jogador = new JogadorDAO().findById(jogadorId);
        
        Gol gol = new Gol();
        gol.setIdJogador(jogador);
        gol.setIdPartida(partida);
        gol.setTempo(tempo);
        
        
        new GolDAO().insert(gol);
        
        response.sendRedirect("fifa?page=editMatch&id="+partida.getId());
    
    }
    
}
