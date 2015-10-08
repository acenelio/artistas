package dao;

import dao.jpa.AlbumDaoImpl;
import dao.jpa.ArtistaDaoImpl;
import dao.jpa.MusicaDaoImpl;

public class DaoFactory {

	public static AlbumDao criarAlbumDao() {
		return new AlbumDaoImpl();
	}
	
	public static ArtistaDao criarArtistaDao() {
		return new ArtistaDaoImpl();
	}
	
	public static MusicaDao criarMusicaDao() {
		return new MusicaDaoImpl();
	}
}
