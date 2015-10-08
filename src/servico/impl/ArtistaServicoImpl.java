package servico.impl;

import java.util.List;

import dao.ArtistaDao;
import dao.DaoFactory;
import dao.jpa.EM;
import dominio.Artista;
import servico.ArtistaServico;

public class ArtistaServicoImpl implements ArtistaServico {

	private ArtistaDao dao;
	
	public ArtistaServicoImpl() {
		dao = DaoFactory.criarArtistaDao();
	}
	
	@Override
	public void inserirAtualizar(Artista x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().begin();
	}

	@Override
	public void excluir(Artista x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public Artista buscar(int cod) {
		return dao.buscar(cod);
	}

	@Override
	public List<Artista> buscarTodos() {
		return dao.buscarTodos();
	}

}
