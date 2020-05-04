/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.CampeonatoDAO;
import br.edu.vianna.fifa.model.domain.Campeonato;
import br.edu.vianna.fifa.model.domain.Partida;
import br.edu.vianna.fifa.model.domain.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class PlayChampionshipAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Long id = Long.parseLong(request.getParameter("id"));
        Campeonato champ = new CampeonatoDAO().findById(id);
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(timestamp.getTime());

        List<Time> times = new ArrayList<>(champ.getTimeList());
        List<Partida> partidas = new ArrayList<>();

        Time primeiro, segundo;
        int t = times.size();
        int p = times.size() / 2;

        for (int i = 0; i < t - 1; i++) {
            for (int j = 0; j < p; j++) {

                Partida partida = new Partida();
                partida.setDataHora(new Date());
                partida.setIdCampeonato(champ);
                if (j % 2 == 1 || i % 2 == 1 && j == 0) {
                    primeiro = times.get(t - j - 1);
                    segundo = times.get(j);
                } else {
                    segundo = times.get(j);
                    primeiro = times.get(t - j - 1);
                }

                partida.setIdPrimeiroTime(primeiro);
                partida.setIdSegundoTime(segundo);
                partidas.add(partida);
            }
            times.add(1, times.remove(times.size() - 1));
        }
        champ.setPartidaList(partidas);
        
        new CampeonatoDAO().insert(champ);

        response.sendRedirect("fifa?page=editChamp&id=" + champ.getId());

    }

}
