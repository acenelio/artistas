package dao;

import java.util.List;
import dominio.Artista;

public interface ArtistaDao {
	public void inserirAtualizar(Artista x);
	public void excluir(Artista x);
	public Artista buscar(int cod);
	public List<Artista> buscarTodos();
}
