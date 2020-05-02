/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewChampionshipAction;
import br.edu.vianna.fifa.model.dao.impl.CampeonatoDAO;
import br.edu.vianna.fifa.model.dao.impl.TimeDAO;
import br.edu.vianna.fifa.model.domain.Campeonato;
import br.edu.vianna.fifa.model.domain.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class NewChampAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String nomeChamp = request.getParameter("nomeChamp");
        String[] id = request.getParameterValues("id[]");

        List<Time> listaTimes = new ArrayList<>();
        List<Campeonato> listaChamps = new ArrayList<>();
        
        Time time = new Time();
        Campeonato champ = new Campeonato();
        
        champ.setData(new Date());
        champ.setNome(nomeChamp);
        
        listaChamps.add(champ);
        time.setCampeonatoList(listaChamps);
        
        for (int i = 0; i < id.length; i++) {

            Long idUser = Long.parseLong(id[i]);
            time = new TimeDAO().findByIdUser(idUser);
            listaTimes.add(time);
        }
            champ.setTimeList(listaTimes);
            
            new CampeonatoDAO().insert(champ);
            new ViewChampionshipAction().openPage(request, response);
            
            
            

    }

}
