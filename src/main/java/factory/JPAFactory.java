package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastroprodutos");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
