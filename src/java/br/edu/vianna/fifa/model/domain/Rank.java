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
 * @author jeanv
 */
@Entity
@Table(catalog = "fifa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rank.findAll", query = "SELECT r FROM Rank r"),
    @NamedQuery(name = "Rank.findById", query = "SELECT r FROM Rank r WHERE r.id = :id"),
    @NamedQuery(name = "Rank.findByVitorias", query = "SELECT r FROM Rank r WHERE r.vitorias = :vitorias"),
    @NamedQuery(name = "Rank.findByDerrotas", query = "SELECT r FROM Rank r WHERE r.derrotas = :derrotas"),
    @NamedQuery(name = "Rank.findByEmpates", query = "SELECT r FROM Rank r WHERE r.empates = :empates"),
    @NamedQuery(name = "Rank.findByPontos", query = "SELECT r FROM Rank r WHERE r.pontos = :pontos"),
    @NamedQuery(name = "Rank.findByPartidas", query = "SELECT r FROM Rank r WHERE r.partidas = :partidas"),
    @NamedQuery(name = "Rank.findByIdChamp", query = "SELECT r FROM Rank r JOIN r.idChamp c WHERE c.id = :id ORDER BY r.pontos DESC"),
    @NamedQuery(name = "Rank.findByIdTimeAndChamp", query = "SELECT r FROM Rank r JOIN r.idTime t JOIN r.idChamp c "
            + " WHERE t.id = :idTime AND c.id = :idChamp"),
    @NamedQuery(name = "Rank.findByGolsTomado", query = "SELECT r FROM Rank r WHERE r.golsTomado = :golsTomado"),
    @NamedQuery(name = "Rank.findByGols", query = "SELECT r FROM Rank r WHERE r.gols = :gols")})
public class Rank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private int vitorias;
    @Basic(optional = false)
    @Column(nullable = false)
    private int derrotas;
    @Basic(optional = false)
    @Column(nullable = false)
    private int empates;
    @Basic(optional = false)
    @Column(nullable = false)
    private int pontos;
    @Basic(optional = false)
    @Column(nullable = false)
    private int partidas;
    @Basic(optional = false)
    @Column(nullable = false)
    private int golsTomado;
    @Basic(optional = false)
    @Column(nullable = false)
    private int gols;
    @JoinColumn(name = "idChamp", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Campeonato idChamp;
    @JoinColumn(name = "idTime", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Time idTime;

    public Rank() {
    }

    public Rank(Long id) {
        this.id = id;
    }

    public Rank(Long id, int vitorias, int derrotas, int empates, int pontos, int partidas, int golsTomado, int gols) {
        this.id = id;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.pontos = pontos;
        this.partidas = partidas;
        this.golsTomado = golsTomado;
        this.gols = gols;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public int getGolsTomado() {
        return golsTomado;
    }

    public void setGolsTomado(int golsTomado) {
        this.golsTomado = golsTomado;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rank)) {
            return false;
        }
        Rank other = (Rank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.vianna.fifa.model.domain.Rank[ id=" + id + " ]";
    }

}
