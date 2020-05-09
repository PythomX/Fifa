/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.ranking;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.CampeonatoDAO;
import br.edu.vianna.fifa.model.dao.impl.RankDAO;
import br.edu.vianna.fifa.model.domain.Rank;
import br.edu.vianna.fifa.model.dto.JogadorArtilheiroDTO;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeanv
 */
public class ViewShowRankingAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=showRanking");

        String champId = request.getParameter("id");

        CampeonatoDAO champDAO = new CampeonatoDAO();
        JogadorArtilheiroDTO topScorer = champDAO.findTopScorer(Long.parseLong(champId));
        List<Rank> ranks = new RankDAO().findByIdChamp(Long.parseLong(champId));
        
        request.setAttribute("ranks", ranks);
        request.setAttribute("topScorer", topScorer);

        rd.forward(request, response);

    }

    

}
