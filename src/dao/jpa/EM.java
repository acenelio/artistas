package dao.jpa;

import javax.persistence.EntityManager;

public class EM {
	private static ThreadLocal<EntityManager> localEm = new ThreadLocal<EntityManager>();

	public static synchronized EntityManager getLocalEm(){
		EntityManager em = localEm.get();
		if(em == null){
			em = EMF.get().createEntityManager();
			localEm.set(em);
		}		
		return em;
	}

	public static void closeLocalEm(){
		EntityManager em = localEm.get();
		if (em != null) {
			localEm.get().close();
			localEm.set(null);
		}
	}
}
