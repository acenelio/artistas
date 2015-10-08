package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Album;
import dominio.Artista;
import dominio.Musica;

public class Instanciacao {

	public static void main(String args[]) {

		Artista art1 = new Artista(null, "Caetano",  "BR");
		Artista art2 = new Artista(null, "Bon Jovi",  "EUA");

		Album a1 = new Album(null, "Noites do Norte", 2001, art1);
		art1.addAlbum(a1);
		Album a2 = new Album(null, "Prenda Minha", 1999, art1);
		art1.addAlbum(a2);
		Album a3 = new Album(null, "One Wild Night Live", 2001, art2);
		art2.addAlbum(a3);
		Album a4 = new Album(null, "Crush", 2000, art2);
		art2.addAlbum(a4);

		Musica m1 = new Musica(null, "Cantiga de Boi", 150, a1);
		a1.addMusica(m1);
		Musica m2 = new Musica(null, "Meu Rio", 140, a1);
		a1.addMusica(m2);
		Musica m3 = new Musica(null, "Meditação", 190, a2);
		a2.addMusica(m3);
		Musica m4 = new Musica(null, "Sozinho", 200, a2);
		a2.addMusica(m4);
		Musica m5 = new Musica(null, "It's My Life", 210, a3);
		a3.addMusica(m5);
		Musica m6 = new Musica(null, "Living on a Prayer", 180, a3);
		a3.addMusica(m6);
		Musica m7 = new Musica(null, "Just Older", 180, a4);
		a4.addMusica(m7);
		Musica m8 = new Musica(null, "Mystery Train", 150, a4);
		a4.addMusica(m8);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(art1);
		em.persist(art2);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(m4);
		em.persist(m5);
		em.persist(m6);
		em.persist(m7);
		em.persist(m8);
		
		em.getTransaction().commit();

		System.out.println("Pronto!");
		
		em.close();
		emf.close();
	}
}
