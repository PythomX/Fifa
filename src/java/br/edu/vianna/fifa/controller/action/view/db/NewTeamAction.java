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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class NewTeamAction implements ICommanderAction{

    @Override
    public boolean pageReleased() {
        return false;
    }

    
    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        try {
            
        Usuario user = new Usuario();
        request.getSession().setAttribute("user", user);
        
        String nome = request.getParameter("nomeTime");
        Time time = new Time(null, nome);
        time.setIdUsuario(user);
        
        new TimeDAO().insert(time);

        
        String nomeJogador = request.getParameter("nomeJogador");
        String posicao = request.getParameter("posicao");
        
        Jogador jogador = new Jogador(null, nomeJogador, posicao);
        jogador.setIdTime(time);
        
        new JogadorDAO().insert(jogador);
        
        } catch (Exception e) {
            request.setAttribute("err", "Login ou senha incorretos!");
            new ViewHomeAction().openPage(request, response);
        }
        
        
        
        
        
    }
    
}
