package biblioteca;

import java.util.Vector;

public class GestionArticulos {
	private Vector <Articulo> gestionarticulos=new Vector <Articulo>();
	
	public void menu(String nombre) {
		int opcion=0;
		do {
			System.out.println("ARTÍCULOS DE LA REVISTA "+nombre.toUpperCase());
			System.out.println("--------------------------------------");
			System.out.println("1. Añadir artículo.");
			System.out.println("2. Eliminar artículo.");
			System.out.println("3. Modificar artículo.");
			System.out.println("4. Mostrar artículos.");
			System.out.println("0. Volver al menú principal.");
			opcion=PedirDatos.leerEntero("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				addArticulo();
				break;
			case 2:
				delArticulo();
				break;
			case 3:
				setArticulo();
				break;
			case 4:
				mostrarArticulo();
				break;
			case 0:
				System.out.println("Volviendo al menú principal...");
				System.out.println();
				break;
			default:
				System.out.println("Debe introducir una opción entre 0 y 4.");
				break;
			}
		} while (opcion!=0);
	}

	private void addArticulo() {
		long codarticulo=PedirDatos.leerLong("Introduzca el código del artículo que desea añadir.");
		if (buscarArticulo(codarticulo)!=-1) {
			System.out.println("No se puede añadir el artículo con el código "+codarticulo+" porque ya existe.");
			return;			
		}
		String titulo=PedirDatos.leerCadena("Introduzca el título del artículo");
		String autor=PedirDatos.leerCadena("Introduzca el autor del artículo");
		int numpaginas=PedirDatos.leerEntero("Introduzca el número de páginas del artículo");
		Articulo a=new Articulo(codarticulo, titulo, autor, numpaginas);
		this.gestionarticulos.addElement(a);
		System.out.println("El artículo con el código "+codarticulo+" se ha añadido correctamente.");
	}

	private void delArticulo() {
		if (this.gestionarticulos.isEmpty()) {
			System.out.println("No puede eliminar artículos porque no existe ninguno.");
			return;
		}
		long codarticulo=PedirDatos.leerLong("Introduzca el código del artículo que desea eliminar.");
		int pos=buscarArticulo(codarticulo);
		if (pos==-1) {
			System.out.println("No se puede eliminar el artículo con el código "+codarticulo+" porque no existe.");
			return;
		}
		this.gestionarticulos.remove(pos);
		System.out.println("El artículo con el código "+codarticulo+" ha sido eliminado correctamente.");
	}

	private void setArticulo() {
		if (this.gestionarticulos.isEmpty()) {
			System.out.println("No puede modificar artículos porque no existe ninguno.");
			return;
		}
		long codarticulo=PedirDatos.leerLong("Introduzca el código del artículo que desea modificar.");
		int pos=buscarArticulo(codarticulo);
		if (pos==-1) {
			System.out.println("No se puede modificar el artículo con el código "+codarticulo+" porque no existe.");
			return;
		}
		System.out.println("Los datos del artículo con el código "+codarticulo+" son:");
		System.out.println(this.gestionarticulos.elementAt(pos));
		String titulo=PedirDatos.leerCadena("Introduzca el nuevo título del artículo");
		String autor=PedirDatos.leerCadena("Introduzca el nuevo autor del artículo");
		int numpaginas=PedirDatos.leerEntero("Introduzca el nuevo número de páginas del artículo");
		Articulo a=new Articulo (codarticulo, titulo, autor, numpaginas);
		this.gestionarticulos.add(pos, a);
		System.out.println("El artículo con el código "+codarticulo+" ha sido modificado correctamente.");		
	}

	private void mostrarArticulo() {
		for (int i = 0; i < this.gestionarticulos.size(); i++) {
			System.out.println(this.gestionarticulos.elementAt(i));
			System.out.println("-------------------------");
		}
	}
	
	private int buscarArticulo(long codarticulo) {
		for (int i = 0; i < this.gestionarticulos.size(); i++) {
			if (this.gestionarticulos.elementAt(i).getCodarticulo()==codarticulo) {
				return i;
			}
		}
		return -1;
	}
	
	public String toString() {
		String ret="";
		for (int  i= 0; i < this.gestionarticulos.size(); i++) {
			ret+=this.gestionarticulos.elementAt(i)+"\n-------------------------\n";
		}
		return ret;
	}
}
