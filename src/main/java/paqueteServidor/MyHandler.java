package paqueteServidor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.text.Normalizer;
import java.util.ArrayList;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

class MyHandler implements HttpHandler{
	
	private static ArrayList<String> listaDatos;
	private static URI uri = null;
	private static OutputStream os = null;
	private static String tipoMensaje = "";
	private static String mensajeUsuario = "";
	private static String respuesta = "";
	private static String mensajeLimpio = "";
	private static int contador = 0;
	final static int CODIGO_RESPUESTA = 200;
	
	@Override
	public void handle(HttpExchange t) throws IOException {
		uri =t.getRequestURI();		
		mensajeUsuario = uri.getQuery();
		tipoMensaje = uri.getPath();
		listaDatos = new ArrayList<String>();		
		identificarMensaje(tipoMensaje);
		t.sendResponseHeaders(CODIGO_RESPUESTA, respuesta.length());
		os = t.getResponseBody();
		os.write(respuesta.getBytes());
		os.close();
	}
	
	/* Metodo que identifica el tipo de accion indicada por el usuario y llama a los metodos que realiza la accion apropiada */
	public static String identificarMensaje (String tipoMensaje) {
		if(mensajeUsuario!=null) {		
			if (tipoMensaje.equals("/almacena")) {			
				AccesoFichero.escribirFichero(mensajeUsuario);
				respuesta = "Mensaje \"" + mensajeUsuario + "\" almacenado" + " -> ["+ CODIGO_RESPUESTA+"OK]";
				
			} else if (tipoMensaje.equals("/consulta")) {
				mensajeLimpio = limpiarDato(mensajeUsuario);
				listaDatos = AccesoFichero.leerFichero();
				comrpobarMensaje (listaDatos);
				respuesta = "Mensaje \"" + mensajeUsuario + "\" -> ["+ CODIGO_RESPUESTA+"OK] "+ contador + " coincidencias";
			}
		} else {
			respuesta = "La estructura del mensaje es incorrecta, debe introducir: \"/almacena?palabra\" o \"/consulta?palabra\"";
		}
		System.out.println(respuesta);
		return respuesta;
	}
	
	// Metodo que contabiliza las coincidencias de la palabra introducida con las guardadas en el fichero
	public static void comrpobarMensaje (ArrayList<String> listaDatos) {
		String datoLimpio = "";
		contador = 0;
		for (String datoUsuario : listaDatos) {
			datoLimpio=limpiarDato(datoUsuario);	
			if (datoLimpio.equals(mensajeLimpio)) {
				contador++;
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
}
