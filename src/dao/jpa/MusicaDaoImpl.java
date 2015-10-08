package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.MusicaDao;
import dominio.Musica;

public class MusicaDaoImpl implements MusicaDao {

	private EntityManager em;
	
	public MusicaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Musica x) {
		if (x.getCodMusica() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Musica x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Musica buscar(int cod) {
		return em.find(Musica.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musica> buscarTodos() {
		String jpql = "SELECT x FROM Musica x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
