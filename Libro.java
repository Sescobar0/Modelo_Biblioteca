package biblioteca;

public class Libro {

	private long isbn;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	public Libro(){
	}
	
	public Libro(long isbn, String signatura, String titulo, String autor, String materia, String editorial) {
		this.isbn=isbn;
		this.signatura=signatura;
		this.titulo=titulo;
		this.autor=autor;
		this.materia=materia;
		this.editorial=editorial;
	}

	public long getISBN() {
		return isbn;
	}

	public void setISBN(long iSBN) {
		isbn = iSBN;
	}

	public String getSignatura() {
		return signatura;
	}

	public void setSignatura(String signatura) {
		this.signatura = signatura;
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

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (isbn != other.isbn)
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (signatura == null) {
			if (other.signatura != null)
				return false;
		} else if (!signatura.equals(other.signatura))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public String toString() {
		return "ISBN: "+isbn+"\nSignatura: "+signatura+"\nTítulo: "+titulo+"\nAutor: "+autor
				+"\nMateria: "+materia+"\nEditorial: "+editorial;
	}
}
