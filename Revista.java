package biblioteca;

public class Revista {

	private long codrevista;
	private String signatura;
	private String nombre;
	private String materia;
	private GestionArticulos ga=new GestionArticulos();
	
	public Revista() {
		
	}
	
	public Revista(long codrevista, String signatura, String nombre, String materia) {
		this.codrevista=codrevista;
		this.signatura=signatura;
		this.nombre=nombre;
		this.materia=materia;
	}

	public void gestionArticulos() {
		ga.menu(this.nombre);
	}
	
	public long getCodrevista() {
		return codrevista;
	}

	public void setCodrevista(long codrevista) {
		this.codrevista = codrevista;
	}

	public String getSignatura() {
		return signatura;
	}

	public void setSignatura(String signatura) {
		this.signatura = signatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public GestionArticulos getGa() {
		return ga;
	}

	public void setGa(GestionArticulos ga) {
		this.ga = ga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codrevista ^ (codrevista >>> 32));
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((signatura == null) ? 0 : signatura.hashCode());
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
		Revista other = (Revista) obj;
		if (codrevista != other.codrevista)
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (signatura == null) {
			if (other.signatura != null)
				return false;
		} else if (!signatura.equals(other.signatura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Código de revista: "+codrevista+"\nSignatura: "+ signatura +"\nNombre: "+ nombre +"\nMateria: "
				+materia+"\nArtículos: "+this.ga;
	}
}
