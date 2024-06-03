package serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {
	
	private static final String PATH_FICHERO = "ficheros/persona.dat";

	public static void main(String[] args) {
		
		Persona persona = new Persona("Jose Miguel", 34, 1.8, true);
		System.out.println(persona);
		
		Principal principal = new Principal();
		
		principal.serializar(persona);
		Persona persona2 = principal.deserializar();
		
		System.out.println(persona2);
		System.out.println("compareTo: "+persona.compareTo(persona2));
	}

	private Persona deserializar() {
		FileInputStream fichero = null;
		ObjectInputStream obj = null;
		Persona persona = null;
		
		try {
			fichero = new FileInputStream(PATH_FICHERO);
			obj = new ObjectInputStream(fichero);
			persona = (Persona) obj.readObject();		
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		} finally {
			if (obj != null) {
				try {
					obj.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return persona;
	}

	private void serializar(Persona persona) {
		FileOutputStream fichero = null;
		ObjectOutputStream obj = null;
		
		try {
			fichero = new FileOutputStream(PATH_FICHERO);
			obj = new ObjectOutputStream(fichero);
			obj.writeObject(persona);		
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		} finally {
			if (obj != null) {
				try {
					obj.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
