package biblioteca;

import java.util.Vector;

public class GestionBiblioteca {
	private GestionLibros gl=new GestionLibros();
	private GestionRevistas gr=new GestionRevistas();
	private GestionCdrom gc=new GestionCdrom();
	private GestionUsuarios gu=new GestionUsuarios();
	
	private Vector <Prestamo> prestamos=new Vector<Prestamo>();
	
	public void menu() {
		int opcion=0;
		do {
			System.out.println("BIBLIOTECA DEL I.E.S. POLÍGONO SUR");
			System.out.println("----------------------------------");
			System.out.println("1. Gestión de libros.");
			System.out.println("2. Gestión de revistas.");
			System.out.println("3. Gestión de CD-ROM.");
			System.out.println("4. Gestión de usuarios.");
			System.out.println("5. Realizar préstamo.");
			System.out.println("6. Devolver préstamo.");
			System.out.println("7. Mostrar préstamos.");
			System.out.println("0. Salir.");
			opcion=PedirDatos.leerEntero("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				gestionLibros();
				break;
			case 2:
				gestionRevistas();
				break;
			case 3:
				gestionCdrom();
				break;
			case 4:
				gestionUsuarios();
				break;
			case 5:
				realizarPrestamo();
				break;
			case 6:
				devolverPrestamo();
				break;
			case 7:
				mostrarPrestamos();
				break;
			case 0:
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("Debe introducir una opción entre 0 y 7.");
				break;
			}
		} while (opcion!=0);
	}

	private void gestionLibros() {
		gl.menu();
	}

	private void gestionRevistas() {
		gr.menu();
	}

	private void gestionCdrom() {
		gc.menu();
	}

	private void gestionUsuarios() {
		gu.menu();
	}
	
	public void realizarPrestamo() {
		long codusuario=PedirDatos.leerLong("Introduzca el código del usuario que desea solicitar un préstamo.");
		int pos=gu.buscarUsuario(codusuario);
		if (pos==-1) {
			System.out.println("El usuario con el código "+codusuario+" no existe.");
			return;
		}
		char tipomaterial=PedirDatos.leerCaracter("Introduzca el tipo de material que desea. (L = Libro | R = Revista | C = CD-ROM)");
		while (tipomaterial!='L'&&tipomaterial!='R'&&tipomaterial!='C') {
			tipomaterial=PedirDatos.leerCaracter("Valor incorrecto. Introduzca el tipo de material que desea. (L = Libro | R = Revista | C = CD-ROM)");			
		}
		long codmaterial=0;
		switch (tipomaterial) {
		case 'L':
			codmaterial=PedirDatos.leerLong("Introduzca el ISBN del libro que desea sacar.");
			pos=gl.buscarLibro(codmaterial);
			if (pos==-1) {
				System.out.println("El libro con el ISBN "+codmaterial+" no existe.");
				return;
			}
			break;
		case 'R':
			codmaterial=PedirDatos.leerLong("Introduzca el código de la revista que desea sacar.");
			pos=gr.buscarRevista(codmaterial);
			if (pos==-1) {
				System.out.println("La revista con el código "+codmaterial+" no existe.");
				return;
			}
			break;
		case 'C':
			codmaterial=PedirDatos.leerLong("Introduzca el código del CD-ROM que desea sacar.");
			pos=gc.buscarCdrom(codmaterial);
			if (pos==-1) {
				System.out.println("El CR-ROM con el código "+codmaterial+" no existe.");
				return;
			}
			break;
		}
		if (buscarPrestamo(tipomaterial, codmaterial)!=-1) {
			System.out.println("El material que desea pedir se encuentra prestado actualmente.");
			return;
		}
		String fechaprestamo=PedirDatos.leerCadena("Introduzca la fecha del préstamo (DD/MM/AAAA).");
		Prestamo p=new Prestamo(codusuario, tipomaterial, codmaterial, fechaprestamo);
		this.prestamos.addElement(p);
		System.out.println("Préstamo realizado correctamente.");
	}
	
	public void devolverPrestamo() {
		if (this.prestamos.isEmpty()) {
			System.out.println("No se pueden devolver préstamos porque todavía no se ha realizado ninguno.");
			return;
		}
		long codusuario=PedirDatos.leerLong("Introduzca el código de usuario que realizó el préstamo.");
		char tipomaterial=PedirDatos.leerCaracter("Introduzca el tipo de material que se prestó.");
		long codmaterial=PedirDatos.leerLong("Introduzca el código del material que se prestó.");
		int pos=buscarPrestamo(codusuario, tipomaterial, codmaterial);
		if (pos==-1) {
			System.out.println("No existe ningún préstamo con los datos introducidos.");
			return;
		}
		String fechadevolucion=PedirDatos.leerCadena("Introduzca la fecha de devolución (DD/MM/AAAA).");
		this.prestamos.elementAt(pos).setFechadevolucion(fechadevolucion);
		System.out.println("Se ha devuelto el siguiente préstamo:\nCódigo del préstamo: "+(pos+1)+"\n"+this.prestamos.elementAt(pos));
	}
	
	public void mostrarPrestamos() {
		for (int i = 0; i < this.prestamos.size(); i++) {
			System.out.println(this.prestamos.elementAt(i));
			System.out.println("-------------------------");
		}
	}
	
	//Método de búsqueda para los préstamos
	private int buscarPrestamo(char tipomaterial, long codmaterial) {
		for (int i = 0; i < this.prestamos.size(); i++) {
			if (tipomaterial==this.prestamos.elementAt(i).getCodmaterial()&&codmaterial==this.prestamos.elementAt(i).getCodmaterial()&&
					this.prestamos.elementAt(i).getFechadevolucion()==null) {
				return i;
			}
		}
		return -1;
	}
	
	//Método de búsqueda para las devoluciones
	private int buscarPrestamo(long codusuario, char tipomaterial, long codmaterial) {
		for (int i = 0; i < this.prestamos.size(); i++) {
			if (codusuario==this.prestamos.elementAt(i).getCodusuario()&&tipomaterial==this.prestamos.elementAt(i).getCodmaterial()&&
					codmaterial==this.prestamos.elementAt(i).getCodmaterial()&&this.prestamos.elementAt(i).getFechadevolucion()==null) {
				return i;
			}
		}
		return -1;
	}
}
