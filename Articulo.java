package biblioteca;

import java.util.Vector;

public class Articulo {
	
	private long codarticulo;
	private String titulo;
	private String autor;
	private int numpaginas;
	Vector keywords;
	
	public Articulo() {
		
	}
	
	public Articulo(long codarticulo, String titulo, String autor, int numpaginas) {
		this.codarticulo=codarticulo;
		this.titulo=titulo;
		this.autor=autor;
		this.numpaginas=numpaginas;
	}
	
	/*public Articulo(long codarticulo, String titulo, String autor, int numpaginas, Vector keywords) {
		this.codarticulo=codarticulo;
		this.titulo=titulo;
		this.autor=autor;
		this.numpaginas=numpaginas;
		this.keywords=keywords;
	}*/

	public long getCodarticulo() {
		return codarticulo;
	}

	public void setCodarticulo(long codarticulo) {
		this.codarticulo = codarticulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumpaginas() {
		return numpaginas;
	}

	public void setNumpaginas(int numpaginas) {
		this.numpaginas = numpaginas;
	}

	public Vector getKeywords() {
		return keywords;
	}

	public void setKeywords(Vector keywords) {
		this.keywords = keywords;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + (int) (codarticulo ^ (codarticulo >>> 32));
		result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + numpaginas;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Articulo other = (Articulo) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (codarticulo != other.codarticulo)
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (numpaginas != other.numpaginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Código de artículo: " + codarticulo + "\nTitulo: " + titulo + "\nAutor: " + autor + "\nNumpaginas: "
				+ numpaginas + "\n Palabras clave: " + keywords;
	}
	
	
	
}
