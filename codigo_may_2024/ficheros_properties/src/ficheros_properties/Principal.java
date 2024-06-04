package ficheros_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		Properties properties;
		
		
		properties = new Properties();
		try {
			properties.load(new FileInputStream("src/config.properties"));
			System.out.println(properties.getProperty("path_origen"));
			System.out.println(properties.getProperty("path_destino"));
			
			// Cargar propiedades del sistema:
			properties = System.getProperties();
			Enumeration<Object> claves = properties.keys();
			String clave;
						
			while (claves.hasMoreElements()) {
				clave = (String) claves.nextElement();
				System.out.println(clave + " ==> " + properties.get(clave));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
