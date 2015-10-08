package dao;

import java.util.List;
import dominio.Album;

public interface AlbumDao {
	public void inserirAtualizar(Album x);
	public void excluir(Album x);
	public Album buscar(int cod);
	public List<Album> buscarTodos();

	public List<Album> buscarPorAnoNome(Integer ano, String trechoNome);
}
