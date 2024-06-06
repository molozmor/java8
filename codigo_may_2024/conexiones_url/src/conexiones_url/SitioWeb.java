package conexiones_url;

import java.io.IOException;
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
		return resul;
	}


	/**
	 * Descarga la url a un fichero local
	 * @param pathLocal
	 */
	public void download(String pathLocal) {
		
	}

}
