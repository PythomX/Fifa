package br.edu.vianna.fifa.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Time.class)
public abstract class Time_ {

	public static volatile ListAttribute<Time, Partida> partidaList;
	public static volatile ListAttribute<Time, Gol> golList;
	public static volatile ListAttribute<Time, Campeonato> campeonatoList;
	public static volatile SingularAttribute<Time, Usuario> idUsuario;
	public static volatile ListAttribute<Time, Partida> partidaList1;
	public static volatile SingularAttribute<Time, String> nome;
	public static volatile SingularAttribute<Time, Long> id;
	public static volatile ListAttribute<Time, Jogador> jogadorList;

}

