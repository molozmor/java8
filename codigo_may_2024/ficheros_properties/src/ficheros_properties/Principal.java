package ficheros_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Principal {

	public static void main(String[] args) {
		Properties properties;
		
		properties = new Properties();
		try {
			properties.load(new FileInputStream("src/config.properties"));
			System.out.println(properties.getProperty("path_origen"));
			System.out.println(properties.getProperty("path_destino"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
