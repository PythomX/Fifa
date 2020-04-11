package br.edu.vianna.fifa.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Partida.class)
public abstract class Partida_ {

	public static volatile SingularAttribute<Partida, Time> idSegundoTime;
	public static volatile ListAttribute<Partida, Gol> golList;
	public static volatile ListAttribute<Partida, Campeonato> campeonatoList;
	public static volatile SingularAttribute<Partida, Campeonato> idCampeonato;
	public static volatile SingularAttribute<Partida, Time> idPrimeiroTime;
	public static volatile SingularAttribute<Partida, Integer> id;

}

