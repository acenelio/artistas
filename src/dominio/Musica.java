package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_musicas")
public class Musica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codMusica;
	private String nome;
	private Integer duracao;
	
	@ManyToOne
	@JoinColumn(name="album")
	private Album album;

	public Musica() {
	}

	public Musica(Integer codMusica, String nome, Integer duracao, Album album) {
		this.codMusica = codMusica;
		this.nome = nome;
		this.duracao = duracao;
		this.album = album;
	}

	public Integer getCodMusica() {
		return codMusica;
	}

	public void setCodMusica(Integer codMusica) {
		this.codMusica = codMusica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMusica == null) ? 0 : codMusica.hashCode());
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
		Musica other = (Musica) obj;
		if (codMusica == null) {
			if (other.codMusica != null)
				return false;
		} else if (!codMusica.equals(other.codMusica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Musica [codMusica=" + codMusica + ", nome=" + nome + ", duracao=" + duracao + "]";
	}

}
