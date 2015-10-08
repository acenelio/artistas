package servico;

import java.util.List;

import dominio.Album;

public interface AlbumServico {

	public void inserirAlbum(Album x) throws ServicoException;
	public void excluir(Album x);
	public Album buscar(int cod);
	public List<Album> buscarTodos();
}
