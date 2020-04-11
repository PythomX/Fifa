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
    @NamedQuery(name = "Campeonato.findAll", query = "SELECT c FROM Campeonato c"),
    @NamedQuery(name = "Campeonato.findById", query = "SELECT c FROM Campeonato c WHERE c.id = :id")})
public class Campeonato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "idGols", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Gol idGols;
    @JoinColumn(name = "idPartidas", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Partida idPartidas;
    @JoinColumn(name = "idTimes", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Time idTimes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCampeonato")
    private List<Partida> partidaList;

    public Campeonato() {
    }

    public Campeonato(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gol getIdGols() {
        return idGols;
    }

    public void setIdGols(Gol idGols) {
        this.idGols = idGols;
    }

    public Partida getIdPartidas() {
        return idPartidas;
    }

    public void setIdPartidas(Partida idPartidas) {
        this.idPartidas = idPartidas;
    }

    public Time getIdTimes() {
        return idTimes;
    }

    public void setIdTimes(Time idTimes) {
        this.idTimes = idTimes;
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
