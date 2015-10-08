package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tb_albuns")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codAlbum;
	private String nome;
	private Integer ano;
	
	@ManyToOne
	@JoinColumn(name="artista")
	private Artista artista;
	
	@OneToMany(mappedBy="album")
	private List<Musica> musicas;

	public Album() {
		musicas = new ArrayList<>();
	}

	public Album(Integer codAlbum, String nome, Integer ano, Artista artista) {
		this.codAlbum = codAlbum;
		this.nome = nome;
		this.ano = ano;
		this.artista = artista;
		musicas = new ArrayList<>();
	}

	public Integer getCodAlbum() {
		return codAlbum;
	}

	public void setCodAlbum(Integer codAlbum) {
		this.codAlbum = codAlbum;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public void addMusica(Musica x) {
		this.musicas.add(x);
	}
	
	public void removeMusica(Musica x) {
		this.musicas.remove(x);
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAlbum == null) ? 0 : codAlbum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (codAlbum == null) {
			if (other.codAlbum != null)
				return false;
		} else if (!codAlbum.equals(other.codAlbum))
			return false;
		return true;
	}	
	
	@Override
	public String toString() {
		return "Album [codAlbum=" + codAlbum + ", nome=" + nome + ", ano=" + ano + "]";
	}

	public int duracao() {
		int soma = 0;
		for (Musica m : musicas) {
			soma = soma + m.getDuracao();
		}
		return soma;
	}

	public Musica maiorMusica() {
		Musica maior = musicas.get(0);
		for (Musica m : musicas) {
			if (m.getDuracao() > maior.getDuracao()) {
				maior = m;
			}
		}
		return maior;
	}

}
