/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mateu
 */
@Entity
@Table(catalog = "fifa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Campeonato.findAll", query = "SELECT c FROM Campeonato c"),
    @NamedQuery(name = "Campeonato.findById", query = "SELECT c FROM Campeonato c WHERE c.id = :id"),
    @NamedQuery(name = "Campeonato.findAllForTable", query = "SELECT c FROM Campeonato c LEFT JOIN c.timeList t GROUP BY c.id"),
    @NamedQuery(name = "Campeonato.findByData", query = "SELECT c FROM Campeonato c WHERE c.data = :data"),
    @NamedQuery(name = "Campeonato.findByNome", query = "SELECT c FROM Campeonato c WHERE c.nome = :nome")})
public class Campeonato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @JoinTable(name = "camptimes", joinColumns = {
        @JoinColumn(name = "idCamp", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idTime", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Time> timeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChamp")
    private List<Rank> rankList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCampeonato")
    private List<Partida> partidaList;

    public Campeonato() {
    }

    public Campeonato(Long id) {
        this.id = id;
    }

    public Campeonato(Long id, Date data, String nome) {
        this.id = id;
        this.data = data;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }

    public List<Rank> getRankList() {
        return rankList;
    }

    public void setRankList(List<Rank> rankList) {
        this.rankList = rankList;
    }

    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
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
        if (!(object instanceof Campeonato)) {
            return false;
        }
        Campeonato other = (Campeonato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.vianna.fifa.model.domain.Campeonato[ id=" + id + " ]";
    }
    
}
