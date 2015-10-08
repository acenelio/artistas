package aplicacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Album;
import dominio.Artista;

public class Principal {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int op;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
		EntityManager em = null;
		int cod;
		Album alb = null;
		Artista art = null;

		do {
			op = Tela.menu(sc);

			switch (op) {
			case 1:
				em = emf.createEntityManager();
				System.out.println("Digite o código de um álbum: ");
				cod = Integer.parseInt(sc.nextLine());
				alb = em.find(Album.class, cod);
				if (alb == null) {
					System.out.println("Código inexistente!");
				} else {
					System.out.println("Duração do álbum " + alb.getNome() + ": " + alb.duracao());
				}
				em.close();
				break;

			case 2:
				em = emf.createEntityManager();
				
				String s1 = "SELECT a FROM Album a";
				Query q1 = em.createQuery(s1);
				@SuppressWarnings("unchecked")
				List<Album> listAlbuns = q1.getResultList();

				System.out.println("Listagem de álbuns:");
				for (Album x : listAlbuns) {
					System.out.println(x.getNome()+", "+x.getAno()+" - "+x.getArtista().getNome());
				}
				
				em.close();
				break;

			case 3:
				em = emf.createEntityManager();

				String s2 = "SELECT a FROM Artista a";
				Query q2 = em.createQuery(s2);
				@SuppressWarnings("unchecked")
				List<Artista> listArtistas = q2.getResultList();
				System.out.println("Artistas existentes: ");
				for (Artista x : listArtistas) {
					System.out.println(x);
				}
				
				System.out.println("Digite o código do artista do novo álbum a ser inserido: ");
				int codArtista = Integer.parseInt(sc.nextLine());
				art = em.find(Artista.class, codArtista);

				if (art == null) {
					System.out.println("Código de artista inexistente!");
				}
				else {
					System.out.println("\nDigite o nome do novo álbum: ");
					String nome = sc.nextLine();
					System.out.println("Digite o ano do novo álbum: ");
					int ano = Integer.parseInt(sc.nextLine());
					alb = new Album(null, nome, ano, art);
					em.getTransaction().begin();
					try {
						em.persist(alb);
						em.getTransaction().commit();
						System.out.println("Álbum inserido! Código: " + alb.getCodAlbum());
					}
					catch (Exception e) {
						if (em.getTransaction().isActive()) {
							em.getTransaction().rollback();
						}
						System.out.println("Falha ao inserir álbum!");
					}
				}
				em.close();
				break;

			case 4:
				System.out.println("Fim do programa!");
				break;

			default:
				System.out.println("Opção inválida!");
			}

		} while (op != 4);

		emf.close();
		sc.close();
	}
}
