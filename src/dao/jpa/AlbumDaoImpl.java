package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AlbumDao;
import dao.Conexao;
import dominio.Album;

public class AlbumDaoImpl implements AlbumDao {

	private EntityManager em;
	
	public AlbumDaoImpl(Conexao conn) {
		ConexaoImpl aux = (ConexaoImpl) conn;
		this.em = aux.getEm();
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

}
