/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.domain.e;

import java.util.EnumSet;

public enum EPosicao {

    Goleiro("Goleiro"), Zagueiro("Zagueiro"), Volante("Volante"),
    Meia("Meia"), Atacante("Atacante"), Lateral_D("Lateral D"), Lateral_E("Lateral E");

    private String posicao;

    private EPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public EnumSet<EPosicao> listarPosicoes() {
        return EnumSet.allOf(EPosicao.class);
    }

}
