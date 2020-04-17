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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Time.findByNome", query = "SELECT t FROM Time t WHERE t.nome = :nome")})
public class Time implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTime")
    private List<Gol> golList;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTime")
    private List<Campeonato> campeonatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTime")
    private List<Jogador> jogadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrimeiroTime")
    private List<Partida> partidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSegundoTime")
    private List<Partida> partidaList1;

    public Time() {
    }

    public Time(Integer id) {
        this.id = id;
    }

    public Time(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Gol> getGolList() {
        return golList;
    }

    public void setGolList(List<Gol> golList) {
        this.golList = golList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Campeonato> getCampeonatoList() {
        return campeonatoList;
    }

    public void setCampeonatoList(List<Campeonato> campeonatoList) {
        this.campeonatoList = campeonatoList;
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
