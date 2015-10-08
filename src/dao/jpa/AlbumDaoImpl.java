package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AlbumDao;
import dominio.Album;

public class AlbumDaoImpl implements AlbumDao {

	private EntityManager em;
	
	public AlbumDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Album x) {
		if (x.getCodAlbum() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Album x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Album buscar(int cod) {
		return em.find(Album.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> buscarTodos() {
		String jpql = "SELECT x FROM Album x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> buscarPorAnoNome(Integer ano, String trechoNome) {
		
		String s = "SELECT a FROM Album a WHERE 1=1";
		
		if (ano != null)
			s = s + " AND a.ano = :p1";
		if (trechoNome != null)
			s = s + " AND a.nome LIKE :p2";

		Query query = em.createQuery(s);

		if (ano != null)
			query.setParameter("p1", ano);
		if (trechoNome != null)
			query.setParameter("p2", "%"+trechoNome+"%");
		
		return query.getResultList();
	}

}
