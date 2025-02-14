/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db.team;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewHomeAction;
import br.edu.vianna.fifa.model.dao.impl.JogadorDAO;
import br.edu.vianna.fifa.model.dao.impl.TimeDAO;
import br.edu.vianna.fifa.model.domain.Jogador;
import br.edu.vianna.fifa.model.domain.Time;
import br.edu.vianna.fifa.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class NewTeamAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

            Usuario user = (Usuario) request.getSession().getAttribute("user");
            request.getSession().setAttribute("user", user);

            Time time = new TimeDAO().findByIdUser(user.getIdTime().getId());
            
            
            String[] nomeJogador = request.getParameterValues("nomeJogador[]");
            String[] posicao = request.getParameterValues("posicaoJogador[]");

            for (int i = 0; i < nomeJogador.length; i++) {
                String nomej = nomeJogador[i];
                String nomep = posicao[i];

                Jogador jogador = new Jogador(null, nomej, nomep);

                jogador.setIdTime(time);
                new JogadorDAO().insert(jogador);
            }

            new ViewHomeAction().openPage(request, response);

       

    }

}
