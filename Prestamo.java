package biblioteca;

public class Prestamo {
	
	private long codusuario;
	private char tipomaterial;
	private long codmaterial;
	private String fechaprestamo;
	private String fechadevolucion;
	
	public Prestamo(long codusuario, char tipomaterial, long codmaterial, String fechaprestamo) {
		this.codusuario = codusuario;
		this.tipomaterial = tipomaterial;
		this.codmaterial = codmaterial;
		this.fechaprestamo = fechaprestamo;
	}	
	
	public Prestamo(long codusuario, char tipomaterial, long codmaterial, String fechaprestamo, String fechadevolucion) {
		this.codusuario = codusuario;
		this.tipomaterial = tipomaterial;
		this.codmaterial = codmaterial;
		this.fechaprestamo = fechaprestamo;
		this.fechadevolucion = fechadevolucion;
	}
	
	public long getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(long codusuario) {
		this.codusuario = codusuario;
	}

	public char getTipomaterial() {
		return tipomaterial;
	}

	public void setTipomaterial(char tipomaterial) {
		this.tipomaterial = tipomaterial;
	}

	public long getCodmaterial() {
		return codmaterial;
	}

	public void setCodmaterial(long codmaterial) {
		this.codmaterial = codmaterial;
	}

	public String getFechaprestamo() {
		return fechaprestamo;
	}

	public void setFechaprestamo(String fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}

	public String getFechadevolucion() {
		return fechadevolucion;
	}

	public void setFechadevolucion(String fechadevolucion) {
		this.fechadevolucion = fechadevolucion;
	}

	public String toString() {
		return "Préstamo realizado al usuario "+codusuario+":\nTipo de material: " + tipomaterial + "\nCódigo: " + codmaterial
				+ "\nFecha del préstamo: " + fechaprestamo + "\nFecha de devolución: " + fechadevolucion;
	}
}
