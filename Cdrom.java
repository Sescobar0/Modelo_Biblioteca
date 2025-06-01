package biblioteca;

public class Cdrom {
	
	private long codcdrom;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	public Cdrom() {
		
	}
	
	public Cdrom(long codcdrom, String signatura, String titulo, String autor, String materia, String editorial){
		this.codcdrom=codcdrom;
		this.signatura=signatura;
		this.titulo=titulo;
		this.autor=autor;
		this.materia=materia;
		this.editorial=editorial;
	}

	public long getCodcdrom() {
		return codcdrom;
	}

	public void setCodcdrom(long codcdrom) {
		this.codcdrom = codcdrom;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + (int) (codcdrom ^ (codcdrom >>> 32));
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + ((signatura == null) ? 0 : signatura.hashCode());
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
		Cdrom other = (Cdrom) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (codcdrom != other.codcdrom)
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

	@Override
	public String toString() {
		return "Código de CD-ROM: " + codcdrom + "\nSignatura: " + signatura + "\nTítulo: " + titulo + "\nAutor: " + autor
				+ "\nMateria: " + materia + "\nEditorial: " + editorial;
	}
	
	
}
