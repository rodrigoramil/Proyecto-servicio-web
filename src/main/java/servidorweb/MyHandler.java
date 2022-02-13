package servidorweb;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.text.Normalizer;
import java.util.ArrayList;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

class MyHandler implements HttpHandler{

	private static URI uri = null;
	private static OutputStream os = null;
	private static String respuesta = "";	
	private static String tipoMensaje = "";
	private static String mensajeLimpio = "";	
	private static ArrayList<String> listaDatos = null;
	private static String mensajeUsuario = "";
	private static int contador = 0;
	final static int CODIGO_RESPUESTA = 200;
	
	
	@Override
	public void handle(HttpExchange t) throws IOException {
		uri =t.getRequestURI();			
		setMensajeUsuario(uri.getQuery());
		tipoMensaje = uri.getPath();				
		setRespuesta(identificarMensaje(tipoMensaje));
		t.sendResponseHeaders(CODIGO_RESPUESTA, getRespuesta().length());
		os = t.getResponseBody();
		os.write(respuesta.getBytes());
		os.close();
	}
	
	/* Metodo que identifica el tipo de accion indicada por el usuario y llama a los metodos que realiza la accion apropiada */
	public static String identificarMensaje (String tipoMensaje) {
		
		if(getMensajeUsuario()!=null && getMensajeUsuario()!="") {		
			if (tipoMensaje.equals("/almacena")) {			
				AccesoFichero.escribirFichero(getMensajeUsuario());
				setRespuesta("Mensaje \"" + getMensajeUsuario() + "\" almacenado" + " -> ["+ CODIGO_RESPUESTA+"OK]");
				System.out.println(getRespuesta());
				
			} else if (tipoMensaje.equals("/consulta")) {
				setMensajeLimpio(limpiarDato(getMensajeUsuario()));
				setListaDatos(AccesoFichero.leerFichero());
				comrpobarMensaje (getListaDatos());
				setRespuesta("Mensaje \"" + getMensajeUsuario() + "\" -> ["+ CODIGO_RESPUESTA+"OK] "+ getContador() + " coincidencias");
				System.out.println(getRespuesta());
			} else {
				setRespuesta("La estructura del mensaje es incorrecto, debe introducir: \"/almacena?palabra\" o \"/consulta?palabra\"");
			}
		} else {
			setRespuesta("La estructura del mensaje es incorrecto, debe introducir el signo '?' segudo de la palabra que desea almacenar o consultar");
		}
		return getRespuesta();
	}
	
	// Metodo que contabiliza las coincidencias de la palabra introducida con las guardadas en el fichero
	public static void comrpobarMensaje (ArrayList<String> listaDatos) {
		String datoLimpio = "";
		setContador(0);
		if ((getMensajeLimpio() == "")) {
			setRespuesta("No ha introducido ninguna palabra para almacenar o consultar");
		} else {
			for (String datoUsuario : listaDatos) {
				datoLimpio=limpiarDato(datoUsuario);	
				if (datoLimpio.contains(getMensajeLimpio())) {
					setContador(getContador()+1);
				}
			}
		}

	}
	
	// Metodo que pasa las letras a minusculas y llama al metodo que elimina Tildes
	public static String limpiarDato(String dato) {
		String datoLimpio = borrarTilde(dato);
		datoLimpio=datoLimpio.toLowerCase();		
		return datoLimpio;		
	}
	
	// Metodo para eliminar las tildes
    public static String borrarTilde(String texto) {    	
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");        
        return texto;
    } 
    
    // Metodos GET y SET
	public static String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public static void setMensajeUsuario(String mensajeUsuario) {
		MyHandler.mensajeUsuario = mensajeUsuario;
	}

	public static String getRespuesta() {
		return respuesta;
	}

	public static void setRespuesta(String respuesta) {
		MyHandler.respuesta = respuesta;
	}

	public static String getMensajeLimpio() {
		return mensajeLimpio;
	}

	public static void setMensajeLimpio(String mensajeLimpio) {
		MyHandler.mensajeLimpio = mensajeLimpio;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		MyHandler.contador = contador;
	}
    
	public static ArrayList<String> getListaDatos() {
		return listaDatos;
	}

	public static void setListaDatos(ArrayList<String> listaDatos) {
		MyHandler.listaDatos = listaDatos;
	}
    
}
