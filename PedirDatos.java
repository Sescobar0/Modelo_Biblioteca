package biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PedirDatos {
	static private Scanner teclado=new Scanner(System.in);

	static int leerEntero(String frase){
		int entero=0;
		boolean seguir=true;
		
		do {
			try {
				System.out.println(frase);
				entero=teclado.nextInt();
				seguir=false;
				teclado.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(teclado.nextLine()+" no es un número.");
			}
		}while(seguir);
		return entero;
	}

	static long leerLong(String frase){
		long num=0;
		boolean seguir=true;
		
		do {
			try {
				System.out.println(frase);
				num=teclado.nextInt();
				seguir=false;
				teclado.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(teclado.nextLine()+" no es un número.");
			}
		}while(seguir);
		return num;
	}
	
	static double leerDouble(String frase) {
		double decimal=0;
		boolean seguir=true;
		do {
			try {
				System.out.println(frase);
				decimal=teclado.nextDouble();
				teclado.nextLine();
				seguir=false;
			} catch (InputMismatchException e) {
				teclado.nextLine();
				System.out.println("Debe introducir un número.");
			}
		} while (seguir);
		return decimal;
	}
	
	static String leerCadena(String frase) {
		String cadena="";
		System.out.println(frase);
		cadena=teclado.nextLine();
		return cadena;
	}
	
	static char leerCaracter(String frase) {
		char car;
		String cadena="";
		do {
			cadena=leerCadena(frase);
			if(cadena.length()!=1) {
				System.out.println("Debe introducir un único caracter.");
			}
		}while(cadena.length()!=1);
		car=cadena.charAt(0);
		return car;
	}
}
