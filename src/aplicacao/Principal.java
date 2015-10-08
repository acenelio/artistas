package aplicacao;

import java.util.List;
import java.util.Scanner;

import dominio.Album;
import dominio.Artista;
import servico.AlbumServico;
import servico.ArtistaServico;
import servico.ServicoException;
import servico.ServicoFactory;

public class Principal {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int op;
		int cod;
		Album alb = null;
		Artista art = null;
		AlbumServico albumServico = ServicoFactory.criarAlbumServico();
		ArtistaServico artistaServico = ServicoFactory.criarArtistaServico();

		do {
			op = Tela.menu(sc);

			switch (op) {
			case 1:
				System.out.println("Digite o código de um álbum: ");
				cod = Integer.parseInt(sc.nextLine());
				
				alb = albumServico.buscar(cod); // novo
				
				if (alb == null) {
					System.out.println("Código inexistente!");
				} else {
					System.out.println("Duração do álbum " + alb.getNome() + ": " + alb.duracao());
				}
				break;

			case 2:
				List<Album> listAlbuns = albumServico.buscarTodos();

				System.out.println("Listagem de álbuns:");
				for (Album x : listAlbuns) {
					System.out.println(x.getNome()+", "+x.getAno()+" - "+x.getArtista().getNome());
				}
				
				break;

			case 3:
				List<Artista> listArtistas = artistaServico.buscarTodos();
				System.out.println("Artistas existentes: ");
				for (Artista x : listArtistas) {
					System.out.println(x);
				}
				
				System.out.println("Digite o código do artista do novo álbum a ser inserido: ");
				int codArtista = Integer.parseInt(sc.nextLine());
				art = artistaServico.buscar(codArtista);

				if (art == null) {
					System.out.println("Código de artista inexistente!");
				}
				else {
					System.out.println("\nDigite o nome do novo álbum: ");
					String nome = sc.nextLine();
					System.out.println("Digite o ano do novo álbum: ");
					int ano = Integer.parseInt(sc.nextLine());
					alb = new Album(null, nome, ano, art);
					try {
						albumServico.inserirAlbum(alb);
						System.out.println("Álbum inserido com sucesso! Código: " + alb.getCodAlbum());
					} catch (ServicoException e) {
						System.out.println("Erro ao inserir o álbum: " + e.getMessage());
					}
				}
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
