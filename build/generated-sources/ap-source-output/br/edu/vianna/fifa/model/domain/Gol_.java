package br.edu.vianna.fifa.model.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Gol.class)
public abstract class Gol_ {

	public static volatile SingularAttribute<Gol, Partida> idPartida;
	public static volatile ListAttribute<Gol, Campeonato> campeonatoList;
	public static volatile SingularAttribute<Gol, Jogador> idJogador;
	public static volatile SingularAttribute<Gol, Integer> id;
	public static volatile SingularAttribute<Gol, Date> dataHora;

}

