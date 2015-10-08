package dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("meujpa");
	
	public static EntityManagerFactory get() {
		return emf;
	}
}
