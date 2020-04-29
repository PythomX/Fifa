/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewHomeAction;
import br.edu.vianna.fifa.model.dao.impl.JogadorDAO;
import br.edu.vianna.fifa.model.dao.impl.TimeDAO;
import br.edu.vianna.fifa.model.domain.Jogador;
import br.edu.vianna.fifa.model.domain.Time;
import br.edu.vianna.fifa.model.domain.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class UpdateTeamAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Usuario user = (Usuario) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", user);

        String nome = request.getParameter("nomeTime");
        Time time = new TimeDAO().findByIdUser(user.getId());
        time.setNome(nome);
        time.setIdUsuario(user);

        new TimeDAO().update(time);

        String[] nomeJogador = request.getParameterValues("nomeJogador[]");
        String[] posicao = request.getParameterValues("posicaoJogador[]");

        List<Jogador> jogadores = new JogadorDAO().findAllByIdTime(time.getId());
        Jogador jogador = new Jogador();  
        JogadorDAO jdao = new JogadorDAO();
        jogador.setIdTime(time);
        for (int i = 0; i < jogadores.size() -1; i++) {

            String nomej = nomeJogador[i];
            String nomep = posicao[i];

            jogador = jogadores.get(i);
            jogador.setNome(nomej);
            jogador.setPosicao(nomep);
            jdao.update(jogador);

        }

        new ViewHomeAction().openPage(request, response);
    }

}
