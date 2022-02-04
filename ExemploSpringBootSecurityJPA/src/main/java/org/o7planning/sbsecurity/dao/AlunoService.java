package org.o7planning.sbsecurity.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.o7planning.sbsecurity.entity.Aluno;

public class AlunoService implements DAO <Aluno> {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
		
	public AlunoService () {
    	this.entityManagerFactory = Persistence.createEntityManagerFactory("Academico-PU");
    	this.entityManager = entityManagerFactory.createEntityManager(); 
    }
    		
	public List<Aluno> selectIdade (int idade) {
		
		return null;
	}
	
	public List<Aluno> selectGenero (char genero ) {
		
		return null;
	}

	public void insert(Aluno inserido) {
	 	/*if (inserido.isNull()){
		//erro: nulo
		}
		if (inserido.getNome().isNull() || inserido.isEmpty()){
		//erro: nome vazio/invalido
		}
		//id definido automaticamente, n precisa tratar (i guess)
		if (inserido.getGenero().isNull() || inserido.getGenero().isEmpty()) {
		//erro: genero vazio/invalido
		}
		if (inserido.getIdade() < 0){
		//erro: idade invalida
		}
		if (inserido.getEndereco().isNull() || inserido.getEndereco().isEmpty()) {
		//erro: endere�o nulo/vazio
		}*/
		
		entityManager.getTransaction().begin();
		entityManager.persist(inserido);
		entityManager.getTransaction().commit();	
	}

	public Aluno delete(int ID) {
		//cm ver se a id ta no bd?
		
		Aluno excluido = entityManager.find(Aluno.class, ID);
		//if (!excluido.isNull() && !excluido.isEmpty()){
		entityManager.getTransaction().begin();
		entityManager.remove(excluido);
		entityManager.getTransaction().commit();
		return excluido;
	}

	
	public Aluno select(int ID) {
		//id fora do bd
		return entityManager.find(Aluno.class, ID);
				
	}

	public List<Aluno> selectAll() {
		
		return entityManager.createQuery("SELECT a FROM Aluno a").getResultList();
		
	}

	public List<Aluno> selectNOme(String nome) {
		
		
		
		return null;
	}

	public Aluno update(int ID, Aluno update) {
		Aluno antigo = entityManager.find(Aluno.class, ID);
		
		/*if (antigo.isNull()){
		//erro: nulo
		}
		if (antigo.getNome().isNull() || antigo.isEmpty()){
		//erro: nome vazio/invalido
		}
		//id definido automaticamente, n precisa tratar (i guess)
		if (antigo.getGenero().isNull() || antigo.getGenero().isEmpty()) {
		//erro: genero vazio/invalido
		}
		if (antigo.getIdade() < 0){
		//erro: idade invalida
		}
		if (antigo.getEndereco().isNull() || antigo.getEndereco().isEmpty()) {
		//erro: endere�o nulo/vazio
		}*/
		
		entityManager.getTransaction().begin();
		try {
			antigo.setGenero(update.getGenero());
		
		antigo.setEndereco(update.getEndereco());
		antigo.setIdade(update.getIdade());
		antigo.setNome(update.getNome());
		antigo = entityManager.merge(antigo);
		entityManager.getTransaction().commit();
		
		 return antigo;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	   
	}
}