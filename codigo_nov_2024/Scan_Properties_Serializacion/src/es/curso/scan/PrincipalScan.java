package es.curso.scan;

import java.util.Scanner;

public class PrincipalScan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Teclear frase:");
		//String frase = scan.next(); // Corta en el espacio
		String frase = scan.nextLine();
		System.out.println(frase);
		System.out.println("Teclear entero: ");
		int numero = scan.nextInt();
		System.out.println("numero: "+numero);
		scan.close();
		
		System.out.println("Scanner con String");
		scan = new Scanner("hola que tal");
		while (scan.hasNext()) {
			frase = scan.next();
			System.out.println(frase);
		}
		scan.close();

	}

}
