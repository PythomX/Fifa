package br.edu.vianna.fifa.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Campeonato.class)
public abstract class Campeonato_ {

	public static volatile ListAttribute<Campeonato, Partida> partidaList;
	public static volatile SingularAttribute<Campeonato, Gol> idGols;
	public static volatile SingularAttribute<Campeonato, Partida> idPartidas;
	public static volatile SingularAttribute<Campeonato, Integer> id;
	public static volatile SingularAttribute<Campeonato, Time> idTimes;

}

