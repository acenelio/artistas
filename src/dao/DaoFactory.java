package dao;

import dao.jpa.AlbumDaoImpl;
import dao.jpa.ArtistaDaoImpl;
import dao.jpa.ConexaoImpl;
import dao.jpa.MusicaDaoImpl;

public class DaoFactory {

	public static Conexao criarConexao() {
		return new ConexaoImpl();
	}

	public static AlbumDao criarAlbumDao(Conexao conn) {
		return new AlbumDaoImpl(conn);
	}
	
	public static ArtistaDao criarArtistaDao(Conexao conn) {
		return new ArtistaDaoImpl(conn);
	}
	
	public static MusicaDao criarMusicaDao(Conexao conn) {
		return new MusicaDaoImpl(conn);
	}
}
