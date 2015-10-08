package dao;

import java.util.List;
import dominio.Musica;

public interface MusicaDao {
	public void inserirAtualizar(Musica x);
	public void excluir(Musica x);
	public Musica buscar(int cod);
	public List<Musica> buscarTodos();
}
