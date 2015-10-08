package aplicacao;

import java.util.List;
import java.util.Scanner;

import dominio.Album;
import servico.AlbumServico;
import servico.ArtistaServico;
import servico.ServicoFactory;

public class Principal {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int op;
		AlbumServico albumServico = ServicoFactory.criarAlbumServico();
		ArtistaServico artistaServico = ServicoFactory.criarArtistaServico();

		do {
			op = Tela.menu(sc);

			switch (op) {
			case 1:
				System.out.println("Caso de uso ainda não implementado");
				break;

			case 2:
				System.out.println("UC02: Pesquisar álbuns");
				System.out.println("Digite o ano do álbum: ");
				String anoString = sc.nextLine();
				Integer ano = null;
				if (!anoString.equals(""))
					ano = Integer.parseInt(anoString);
				System.out.println("Digite um trecho do nome do álbum: ");
				String trechoNome = sc.nextLine();
				if (trechoNome.equals(""))
					trechoNome = null;

				List<Album> lista = albumServico.buscarPorAnoNome(ano, trechoNome);
				System.out.println("Resultado da pesquisa:");
				for (Album x : lista) {
					System.out.println(x.getNome()+", "+x.getAno()+", "+x.getArtista().getNome());
				}
				
				break;

			case 3:
				System.out.println("Caso de uso ainda não implementado");
				break;

			case 4:
				System.out.println("Caso de uso ainda não implementado");
				break;

			case 5:
				System.out.println("Caso de uso ainda não implementado");
				break;

			case 6:
				System.out.println("Fim do programa!");
				break;

			default:
				System.out.println("Opção inválida!");
			}

		} while (op != 6);

		sc.close();
	}
}
