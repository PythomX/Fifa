/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mateu
 */
@Entity
@Table(catalog = "fifa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t"),
    @NamedQuery(name = "Time.findById", query = "SELECT t FROM Time t WHERE t.id = :id"),
    @NamedQuery(name = "Time.findByIdUser", query = "SELECT t FROM Time t WHERE t.id = :id"),
    @NamedQuery(name = "Time.findAllByChamp", query = "SELECT t FROM Time t JOIN t.campeonatoList c WHERE c.id = :id"),
    @NamedQuery(name = "Time.findByNome", query = "SELECT t FROM Time t WHERE t.nome = :nome")})
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @ManyToMany(mappedBy = "timeList")
    private List<Campeonato> campeonatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTime")
    private List<Rank> rankList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTime")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTime")
    private List<Jogador> jogadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrimeiroTime")
    private List<Partida> partidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSegundoTime")
    private List<Partida> partidaList1;

    public Time() {
    }

    public Time(Long id) {
        this.id = id;
    }

    public Time(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Campeonato> getCampeonatoList() {
        return campeonatoList;
    }

    public void setCampeonatoList(List<Campeonato> campeonatoList) {
        this.campeonatoList = campeonatoList;
    }

    public List<Rank> getRankList() {
        return rankList;
    }

    public void setRankList(List<Rank> rankList) {
        this.rankList = rankList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Jogador> getJogadorList() {
        return jogadorList;
    }

    public void setJogadorList(List<Jogador> jogadorList) {
        this.jogadorList = jogadorList;
    }

    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    public List<Partida> getPartidaList1() {
        return partidaList1;
    }

    public void setPartidaList1(List<Partida> partidaList1) {
        this.partidaList1 = partidaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.vianna.fifa.model.domain.Time[ id=" + id + " ]";
    }

}
