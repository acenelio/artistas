package aplicacao;

import java.util.Scanner;

public class Tela {

	public static int menu(Scanner sc) {
		System.out.println("\n1 - Mostrar a dura��o total de um dado �lbum");
		System.out.println("2 - Listar todos �lbuns com seus artistas");
		System.out.println("3 - Cadastrar um novo �lbum");
		System.out.println("4 - Sair");
		return Integer.parseInt(sc.nextLine());
	}
}
