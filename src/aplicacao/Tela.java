package aplicacao;

import java.util.Scanner;

public class Tela {

	public static int menu(Scanner sc) {
		System.out.println("\n1 - UC01: Cadastrar artista");
		System.out.println("2 - UC02: Pesquisar �lbuns");
		System.out.println("3 - UC03: Manter �lbuns");
		System.out.println("4 - UC04: Manter m�sicas");
		System.out.println("5 - UC05: Visualizar tempo de m�sica");
		System.out.println("6 - Sair");
		return Integer.parseInt(sc.nextLine());
	}
}
