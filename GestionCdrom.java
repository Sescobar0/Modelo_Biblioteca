package biblioteca;

import java.util.Vector;

public class GestionCdrom {
	
	private Vector <Cdrom> gestioncdrom=new Vector <Cdrom>();
	
	public void menu() {
		int opcion=0;
		do {
			System.out.println("GESTIÓN DE CD-ROM");
			System.out.println("-----------------");
			System.out.println("1. Añadir CD-ROM.");
			System.out.println("2. Eliminar CD-ROM.");
			System.out.println("3. Modificar CD-ROM.");
			System.out.println("4. Mostrar CD-ROM.");
			System.out.println("0. Volver al menú principal.");
			opcion=PedirDatos.leerEntero("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				addCdrom();
				break;
			case 2:
				delCdrom();
				break;
			case 3:
				setCdrom();
				break;
			case 4:
				mostrarCdrom();
				break;
			case 0:
				System.out.println("Volviendo al menú principal...");
				System.out.println();
				break;
			default:
				System.out.println("Debe introduir un número entre 0 y 4.");
				break;
			}
		} while (opcion!=0);
	}

	private void addCdrom() {
		long codcdrom=PedirDatos.leerLong("Introduzca el código del CD-ROM que desea añadir.");
		if (buscarCdrom(codcdrom)!=-1) {
			System.out.println("No se puede añadir el CD-ROM con el código "+codcdrom+" porque ya existe.");
			return;
		}
		String signatura=PedirDatos.leerCadena("Introduzca la signatura del CD-ROM.");
		String titulo=PedirDatos.leerCadena("Introduzca el título del CD-ROM.");
		String autor=PedirDatos.leerCadena("Introduzca el autor del CD-ROM.");
		String materia=PedirDatos.leerCadena("Introduzca la materia del CD-ROM.");
		String editorial=PedirDatos.leerCadena("Introduzca la editorial del CD-ROM.");
		Cdrom c=new Cdrom(codcdrom, signatura, titulo, autor, materia, editorial);
		this.gestioncdrom.addElement(c);
		System.out.println("El CD-ROM con el código "+codcdrom+" se ha añadido correctamente.");
	}

	private void delCdrom() {
		if (this.gestioncdrom.isEmpty()) {
			System.out.println("No puede eliminar CD-ROM porque no existe ninguno.");
			return;
		}
		long codcdrom=PedirDatos.leerLong("Introduzca el código del CD-ROM que desea eliminar.");
		int pos=buscarCdrom(codcdrom);
		if (pos==-1) {
			System.out.println("No se puede eliminar el CD-ROM con el código "+codcdrom+" porque no existe.");
			return;
		}
		this.gestioncdrom.remove(pos);
		System.out.println("El CD-ROM con el código "+codcdrom+" ha sido eliminado correctamente.");
	}

	private void setCdrom() {
		if (this.gestioncdrom.isEmpty()) {
			System.out.println("No puede eliminar CD-ROM porque no existe ninguno.");
			return;
		}
		long codcdrom=PedirDatos.leerLong("Introduzca el código del CD-ROM que desea modificar");
		int pos=buscarCdrom(codcdrom);
		if (pos==-1) {
			System.out.println("No se puede modificar el CD-ROM con el código "+codcdrom+" porque no existe.");
			return;
		}
		System.out.println("Los datos del CD-ROM con el código "+codcdrom+" son:");
		System.out.println(this.gestioncdrom.elementAt(pos));
		String signatura=PedirDatos.leerCadena("Introduzca la nueva signatura del CD-ROM.");
		String titulo=PedirDatos.leerCadena("Introduzca el nuevo título del CD-ROM.");
		String autor=PedirDatos.leerCadena("Introduzca el nuevo autor del CD-ROM.");
		String materia=PedirDatos.leerCadena("Introduzca la nueva materia del CD-ROM.");
		String editorial=PedirDatos.leerCadena("Introduzca la nueva editorial del CD-ROM.");
		Cdrom c=new Cdrom(codcdrom, signatura, titulo, autor, materia, editorial);
		this.gestioncdrom.add(pos, c);
		System.out.println("El CD-ROM con el código "+codcdrom+" ha sido modificado correctamente.");
	}
	
	private void mostrarCdrom() {
		for (int i = 0; i < this.gestioncdrom.size(); i++) {
			System.out.println(this.gestioncdrom.elementAt(i));
			System.out.println("-------------------------");
		}
	}
	
	public int buscarCdrom(long codcdrom) {
		for (int i = 0; i < this.gestioncdrom.size(); i++) {
			if (this.gestioncdrom.elementAt(i).getCodcdrom()==codcdrom) {
				return i;
			}
		}
		return -1;
	}
}