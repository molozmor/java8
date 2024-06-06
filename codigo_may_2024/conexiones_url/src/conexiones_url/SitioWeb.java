package conexiones_url;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class SitioWeb {
	
	private String web;
	private URL url;
	private URLConnection con;

	public SitioWeb(String web) throws IOException {
		super();
		this.web = web;
		this.url = new URL(web);
		this.con = this.url.openConnection();
	}
			
	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}




	public URL getUrl() {
		return url;
	}




	public void setUrl(URL url) {
		this.url = url;
	}




	/**
	 * Devuelve información del sitio web
	 * @return
	 */
	public String info() {
		
		String resul = this.web+"\n";
		resul += "Content-type: "+this.con.getContentType()+"\n";
		resul += "Content-length: "+this.con.getContentLength()+"\n";
		resul += "Fecha: " + (new Date(this.con.getDate())).toString()+"\n";
		resul += "Fichero: "+this.url.getFile()+"\n";
		return resul;
	}


	/**
	 * Descarga la url a un fichero local
	 * @param pathLocal
	 */
	public void download(String pathLocal) {
		FileOutputStream fichero = null;
		InputStream is;
		int c;
		File f;
		
		try {
			
			is = this.con.getInputStream();
			f = new File(this.url.getFile());
			System.out.println(f.getPath());
			
			fichero = new FileOutputStream(pathLocal);
			
			while ((c=is.read())!= -1) {
				fichero.write(c);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		} finally {
			if (fichero != null)
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
