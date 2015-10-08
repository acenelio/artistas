package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Album;
import dominio.Artista;
import dominio.Musica;

public class TesteMetodos {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
		EntityManager em = emf.createEntityManager();

		Artista art1 = em.find(Artista.class, 1);
		Album a1 = em.find(Album.class, 1);
		Musica aux = em.find(Musica.class, 2);

		System.out.println("Duração do álbum "+a1.getNome()+":"+a1.duracao());

		System.out.println("\nMaior música do álbum "+a1.getNome()+":");
		System.out.println(a1.maiorMusica());

		int ano = 2001;
		System.out.println("\nTempo de música do artista "+art1.getNome()+" no ano "+ano+": "+art1.tempoDeMusica(ano));
		
		System.out.println("\nÁlbuns de "+art1.getNome()+" anteriores a "+ano+": ");
		for (Album x : art1.albunsAnteriores(ano)) {
			System.out.println(x);
		}
		
		System.out.println("\nÁlbuns de "+art1.getNome()+" anteriores à música "+aux.getNome()+": ");
		for (Album x : art1.albunsAnteriores(aux)) {
			System.out.println(x);
		}
		
		em.close();
		emf.close();
	}
}
