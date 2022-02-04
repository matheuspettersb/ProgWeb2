import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroCliente {
  public static void main(String... args) {
    EntityManagerFactory entityManagerFactory 
        = Persistence.createEntityManagerFactory("Clientes-PU");
    	//relaciona com o persistance unit do persistence.xml
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    //codigo aqui
    Cliente cliente = entityManager.find(Cliente.class, 2);
    cliente = entityManager.merge(cliente);
   
    entityManager.getTransaction().begin();
    cliente.setNome("Autopeças Rodovia");
    entityManager.getTransaction().commit();
    //

    entityManager.close();
    entityManagerFactory.close();
  }
}
//Para criar registros novos (n precisa por id pq seta automaticamente)
		//Cliente cliente = new Cliente();
		//cliente.setNome("Agropesca Jacaré");
		//
		//entityManager.getTransaction().begin();
		//entityManager.persist(cliente);
		//entityManager.getTransaction().commit();

//Para remover
		//Cliente cliente = entityManager.find(Cliente.class, 2); >>seleciona o objeto da classe cliente na posição 2
		//
		//entityManager.getTransaction().begin();
		//entityManager.remove(cliente);
		//entityManager.getTransaction().commit();

//Para realizar alteração
//		Cliente cliente = entityManager.find(Cliente.class, 1);
//		
//		entityManager.getTransaction().begin();
//		cliente.setNome("Autopeças Rodovia");
//		entityManager.getTransaction().commit();

//Exemplo de merge, o objeto no id 2 tinha sido detached, agr voltaria com o merge
//Cliente cliente = entityManager.find(Cliente.class, 2);
//cliente = entityManager.merge(cliente);
//
//entityManager.getTransaction().begin();
//cliente.setNome("Autopeças Rodovia");
//entityManager.getTransaction().commit();

//Estados de CLiente
	// new ou transient, managed, removed e detached
	// new ou transient = acabou de ser criado ("new classe")
	// managed = passou pelo entitymanager pelo persist ou pelo merge
	// removed = passou pelo remove
	// detached = passou pelo detach, desanexado, mas ainda pode voltar a ser gerenciado por um merge

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	