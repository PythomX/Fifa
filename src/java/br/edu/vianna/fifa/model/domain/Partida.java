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
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p"),
    @NamedQuery(name = "Partida.findById", query = "SELECT p FROM Partida p WHERE p.id = :id"),
    @NamedQuery(name = "Partida.findByLocalTime", query = "SELECT p FROM Partida p WHERE p.localTime = :localTime")})
public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date localTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartida")
    private List<Gol> golList;
    @JoinColumn(name = "idCampeonato", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Campeonato idCampeonato;
    @JoinColumn(name = "idPrimeiroTime", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Time idPrimeiroTime;
    @JoinColumn(name = "idSegundoTime", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Time idSegundoTime;

    public Partida() {
    }

    public Partida(Integer id) {
        this.id = id;
    }

    public Partida(Integer id, Date localTime) {
        this.id = id;
        this.localTime = localTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLocalTime() {
        return localTime;
    }

    public void setLocalTime(Date localTime) {
        this.localTime = localTime;
    }

    public List<Gol> getGolList() {
        return golList;
    }

    public void setGolList(List<Gol> golList) {
        this.golList = golList;
    }

    public Campeonato getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Campeonato idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public Time getIdPrimeiroTime() {
        return idPrimeiroTime;
    }

    public void setIdPrimeiroTime(Time idPrimeiroTime) {
        this.idPrimeiroTime = idPrimeiroTime;
    }

    public Time getIdSegundoTime() {
        return idSegundoTime;
    }

    public void setIdSegundoTime(Time idSegundoTime) {
        this.idSegundoTime = idSegundoTime;
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
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.vianna.fifa.model.domain2.Partida[ id=" + id + " ]";
    }
    
}
