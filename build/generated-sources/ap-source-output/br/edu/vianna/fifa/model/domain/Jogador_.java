package br.edu.vianna.fifa.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Jogador.class)
public abstract class Jogador_ {

	public static volatile ListAttribute<Jogador, Gol> golList;
	public static volatile SingularAttribute<Jogador, String> posicao;
	public static volatile SingularAttribute<Jogador, String> nome;
	public static volatile SingularAttribute<Jogador, Integer> id;
	public static volatile SingularAttribute<Jogador, Time> idTime;

}

