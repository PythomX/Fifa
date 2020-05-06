/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.ranking;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.CampeonatoDAO;
import br.edu.vianna.fifa.model.dao.impl.PartidaDAO;
import br.edu.vianna.fifa.model.domain.Campeonato;
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
public class ViewRankingAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=ranking");

        List<Campeonato> champs = new CampeonatoDAO().findAllForTable();

        List<CampeonatoDTO> quantidades = new CampeonatoDAO().findAmountTimesForTable();
        
        int i = 0;
        for (Campeonato champ : champs) {
        List<Partida> partidas = new PartidaDAO().findMatchByChamp(champs.get(i).getId());
            champ.setPartidaList(partidas);
            i++;
        }
            
        request.setAttribute("champs", champs);
        request.setAttribute("quantidades", quantidades);

        rd.forward(request, response);
        
    }

}
