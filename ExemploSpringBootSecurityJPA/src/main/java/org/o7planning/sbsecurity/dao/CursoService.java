package org.o7planning.sbsecurity.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.o7planning.sbsecurity.entity.Curso;

public class CursoService implements DAO<Curso> {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public CursoService() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("Academico-PU");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public List<Curso> selectDuracao(int duracao) {

		return null;
	}

	public List<Curso> selectPeriodo(String curso) {

		return null;
	}

	public void insert(Curso inserido) {
		/*
		 * if (inserido.isNull()){ //erro: nulo } if (inserido.getNome().isNull() ||
		 * inserido.isEmpty()){ //erro: nome vazio/invalido } //id definido
		 * automaticamente, n precisa tratar (i guess) if
		 * (inserido.getPeriodo().isNull() || inserido.getPeriodo().isEmpty()) { //erro:
		 * periodo vazio/invalido } if (inserido.getDuracao() < 1){ //erro: tempo
		 * invalido }
		 */
		entityManager.getTransaction().begin();
		entityManager.persist(inserido);
		entityManager.getTransaction().commit();
	}

	public Curso delete(int ID) {
		// cm ver se a id ta no bd?
		Curso excluido = entityManager.find(Curso.class, ID);
		// if (!excluido.isNull() && !excluido.isEmpty()){
		entityManager.getTransaction().begin();
		entityManager.remove(excluido);
		entityManager.getTransaction().commit();
		return excluido;
		// }

	}

	// public Curso update(int ID) { comentado, tinha um update com outro curso de
	// referencia em baixo e nesse nada,
	// deve ser antigo e deixado pra tras
	// return null;
	// }

	public Curso select(int ID) {
		// id fora do bd? (linka com a duvida de cima)
		return entityManager.find(Curso.class, ID);
	}

	public List<Curso> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Curso> selectNOme(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public Curso update(int ID, Curso update) {
		try {
			Curso antigo = entityManager.find(Curso.class, ID);
			if (antigo != null ) {
				
			
			entityManager.getTransaction().begin();
			antigo.setPeriodo(update.getPeriodo());
			antigo.setDuracao(update.getDuracao());
			antigo.setNome(update.getNome());
			antigo = entityManager.merge(antigo);
			entityManager.getTransaction().commit();

			return antigo;
			}
			throw new Exception ("Identificador n�o encontrado"); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
