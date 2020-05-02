/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.model.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mateu
 */
@Entity
@Table(catalog = "fifa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rank.findAll", query = "SELECT r FROM Rank r"),
    @NamedQuery(name = "Rank.findByIdRank", query = "SELECT r FROM Rank r WHERE r.idRank = :idRank")})
public class Rank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idRank;
    @JoinColumn(name = "idChamp", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Campeonato idChamp;
    @JoinColumn(name = "idTime", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Time idTime;

    public Rank() {
    }

    public Rank(Long idRank) {
        this.idRank = idRank;
    }

    public Long getIdRank() {
        return idRank;
    }

    public void setIdRank(Long idRank) {
        this.idRank = idRank;
    }

    public Campeonato getIdChamp() {
        return idChamp;
    }

    public void setIdChamp(Campeonato idChamp) {
        this.idChamp = idChamp;
    }

    public Time getIdTime() {
        return idTime;
    }

    public void setIdTime(Time idTime) {
        this.idTime = idTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRank != null ? idRank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rank)) {
            return false;
        }
        Rank other = (Rank) object;
        if ((this.idRank == null && other.idRank != null) || (this.idRank != null && !this.idRank.equals(other.idRank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.vianna.fifa.model.domain.Rank[ idRank=" + idRank + " ]";
    }
    
}
