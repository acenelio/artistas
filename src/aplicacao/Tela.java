package aplicacao;

import java.util.Scanner;

public class Tela {

	public static int menu(Scanner sc) {
		System.out.println("\n1 - Mostrar a duração total de um dado álbum");
		System.out.println("2 - Listar todos álbuns com seus artistas");
		System.out.println("3 - Cadastrar um novo álbum");
		System.out.println("4 - Sair");
		return Integer.parseInt(sc.nextLine());
	}
}
