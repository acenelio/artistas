package servico.impl;

import java.util.List;

import dao.AlbumDao;
import dao.ArtistaDao;
import dao.DaoFactory;
import dao.jpa.EM;
import dominio.Album;
import dominio.Artista;
import servico.AlbumServico;
import servico.ServicoException;

public class AlbumServicoImpl implements AlbumServico {

	private AlbumDao dao;
	
	public AlbumServicoImpl() {
		dao = DaoFactory.criarAlbumDao();
	}
	
	@Override
	public void inserirAlbum(Album x) throws ServicoException {
		
		ArtistaDao artistaDao = DaoFactory.criarArtistaDao();
		Artista art = artistaDao.buscar(x.getArtista().getCodArtista());
		
		for (Album alb : art.getAlbuns()) {
			if (alb.getNome().equals(x.getNome())) {
				throw new ServicoException("Nome de álbum já existe para este artista!", 1);
			}
		}
		
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public void excluir(Album x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public Album buscar(int cod) {
		return dao.buscar(cod);
	}

	@Override
	public List<Album> buscarTodos() {
		return dao.buscarTodos();
	}

}
