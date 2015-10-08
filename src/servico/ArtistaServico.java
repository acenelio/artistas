package servico;

import java.util.List;

import dominio.Artista;

public interface ArtistaServico {

	public void inserirAtualizar(Artista x);
	public void excluir(Artista x);
	public Artista buscar(int cod);
	public List<Artista> buscarTodos();
}
