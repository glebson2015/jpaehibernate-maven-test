package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		//Objetos Salvos na Base de Dados
		/*		
		Pessoa p1 = new Pessoa (null, "Jo�o Carlos", "jc@gmail.com");
		Pessoa p2 = new Pessoa  (null, "Camila Pessoa", "cp@gmail.com");
		Pessoa p3 =  new Pessoa (null, "Luiz Paulo", "lp@gmail.com");
		*/
		
		//Abaixo instanciamos o EntityManagerFactory com as configura��es de conex�o
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		//Com essa instancia��o temos toda a conex�o com o BD e todo ocontexto de Persist�ncia implementada		
		EntityManager em = emf.createEntityManager();
		
		//O M�todo Persiste pega o obejto e sava no Banco de Dados		
		//em.getTransaction().begin();//Inicia a transa��o com o BD
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		//em.getTransaction().commit();//Confirma as altera��es feitas no BD
		
		//Recupeando Dados na Base de Dados
		/*Pessoa p = em.find(Pessoa.class, 2);
		
		System.out.println(p);*/
		
		//Apagando um Objeto do Banco de Dados - Sempre que for fazer uma oper���o que n�o � uma consulta
		//colocar Transaction
		em.getTransaction().begin();
		Pessoa p = em.find(Pessoa.class, 2);//Entidade Monitorado = Recuperada do BD ou Acabou de ser criada
		
		em.remove(p);
		em.getTransaction().commit();
		
		
		System.out.println("Finalizado com sucesso!");
		em.close();
		emf.close();
		

	}

}
