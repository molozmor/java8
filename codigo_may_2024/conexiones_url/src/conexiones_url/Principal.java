package conexiones_url;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SitioWeb web;
		
		try {
			web = new SitioWeb("https://www.tesuva.edu.co/phocadownloadpap/Fundamentos%20de%20programcion%20en%20Java.pdf");
			System.out.println(web.info());
			web.download("fichero.pdf");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
