package servico;

import servico.impl.AlbumServicoImpl;
import servico.impl.ArtistaServicoImpl;

public class ServicoFactory {

	public static AlbumServico criarAlbumServico() {
		return new AlbumServicoImpl();
	}
	
	public static ArtistaServico criarArtistaServico() {
		return new ArtistaServicoImpl();
	}
}
