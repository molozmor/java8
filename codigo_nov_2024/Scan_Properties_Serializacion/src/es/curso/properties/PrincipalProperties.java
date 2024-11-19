package es.curso.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PrincipalProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Propiedades del Sistema");
		Properties prop = System.getProperties();
		Set<String> claves = prop.stringPropertyNames();
		prop.setProperty("user.name", "Antonio");
		
		for (String k : claves) {
			System.out.println(k + " ==> " + prop.getProperty(k));
		}		

		// Cargar un fichero de properties:
		FileInputStream fichero = null;		
		try {
			fichero = new FileInputStream("src/es/curso/properties/config.properties");		
			prop = new Properties();
			prop.load(fichero);
			System.out.println(prop.getProperty("usuario"));
			System.out.println(prop.getProperty("password"));					
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		// Modificar el fichero de properties:
		FileOutputStream fichero2 = null;
		try {
			fichero2 = new FileOutputStream("src/es/curso/properties/config.properties");	
			prop.setProperty("email", "webmaster@gmail.com");
			
			// Mejor store que save.
			prop.store(fichero2, "Comentarios de las propiedades");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			if (fichero2 != null) {
				try {
					fichero2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
	}

}
