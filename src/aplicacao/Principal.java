package aplicacao;

import java.util.List;
import java.util.Scanner;

import dao.AlbumDao;
import dao.ArtistaDao;
import dao.Conexao;
import dao.DaoFactory;
import dominio.Album;
import dominio.Artista;

public class Principal {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int op;
		int cod;
		Conexao conn = null;
		Album alb = null;
		Artista art = null;
		AlbumDao albumDao = null;
		ArtistaDao artistaDao = null;

		do {
			op = Tela.menu(sc);

			switch (op) {
			case 1:
				conn = DaoFactory.criarConexao();
				System.out.println("Digite o código de um álbum: ");
				cod = Integer.parseInt(sc.nextLine());
				albumDao = DaoFactory.criarAlbumDao(conn);
				alb = albumDao.buscar(cod);
				if (alb == null) {
					System.out.println("Código inexistente!");
				} else {
					System.out.println("Duração do álbum " + alb.getNome() + ": " + alb.duracao());
				}
				conn.fecharConexao();
				break;

			case 2:
				conn = DaoFactory.criarConexao();
				
				albumDao = DaoFactory.criarAlbumDao(conn);
				List<Album> listAlbuns = albumDao.buscarTodos();

				System.out.println("Listagem de álbuns:");
				for (Album x : listAlbuns) {
					System.out.println(x.getNome()+", "+x.getAno()+" - "+x.getArtista().getNome());
				}
				
				conn.fecharConexao();
				break;

			case 3:
				conn = DaoFactory.criarConexao();

				artistaDao = DaoFactory.criarArtistaDao(conn);
				List<Artista> listArtistas = artistaDao.buscarTodos();
				System.out.println("Artistas existentes: ");
				for (Artista x : listArtistas) {
					System.out.println(x);
				}
				
				System.out.println("Digite o código do artista do novo álbum a ser inserido: ");
				int codArtista = Integer.parseInt(sc.nextLine());
				art = artistaDao.buscar(codArtista);

				if (art == null) {
					System.out.println("Código de artista inexistente!");
				}
				else {
					System.out.println("\nDigite o nome do novo álbum: ");
					String nome = sc.nextLine();
					System.out.println("Digite o ano do novo álbum: ");
					int ano = Integer.parseInt(sc.nextLine());
					alb = new Album(null, nome, ano, art);
					conn.iniciarTransacao();
					albumDao = DaoFactory.criarAlbumDao(conn);
					try {
						albumDao.inserirAtualizar(alb);
						conn.commit();
						System.out.println("Álbum inserido! Código: " + alb.getCodAlbum());
					}
					catch (Exception e) {
						if (conn.transacaoAtiva()) {
							conn.rollback();
						}
						System.out.println("Falha ao inserir álbum!");
					}
				}
				conn.fecharConexao();
				break;

			case 4:
				System.out.println("Fim do programa!");
				break;

			default:
				System.out.println("Opção inválida!");
			}

		} while (op != 4);

		sc.close();
	}
}
