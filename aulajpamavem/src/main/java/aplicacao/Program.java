package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Anna Maria", "anna@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2); // Busca na TABELA COM JPA
		
		//remover no DB com JPA
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		//entidade monitotada, Ou ela precisa ter sido inserida ou recuperada do DB antes de fechada a ENTITYMANAGER.
		
		System.out.println("Pronto");
		em.close();
		emf.close();
	}
}
