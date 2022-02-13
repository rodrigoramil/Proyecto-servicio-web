package servidorweb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class AccesoFichero {

	private static ArrayList<String> listaDatos;
	private static String archivo = "datos.txt";
	private static String rutaFichero = null;

	// Metodo que comprueba si el fichero existe, sino lo crea y alamacena en el la palabra introducida
	public static void escribirFichero(String mensaje) {
		FileWriter fichero = null;
		
		File f = new File(archivo);
		rutaFichero = f.getAbsolutePath();
		try {
			fichero =new FileWriter (rutaFichero, true);
		} 
		catch (IOException e){ 
			System.out.println("No se pudo acceder al fichero");
		}
		BufferedWriter buffer = new BufferedWriter(fichero);
		try {
			buffer.write(mensaje);
			buffer.newLine();
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero");
		}
		try {
			buffer.close();
			fichero.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el fichero");
		}
	}
	
	// Metodo que lee el fichero y almacena la informaci�n en un array
	public static ArrayList<String> leerFichero() {
		listaDatos = new ArrayList<String>();
		FileReader ficheroLectura = null;
		File f = new File(archivo);
		rutaFichero = f.getAbsolutePath();
		try {
			ficheroLectura = new FileReader(rutaFichero);
		} catch (IOException e) {
			System.out.println("No se puede abrir el fichero");
		}
		BufferedReader buffer = new BufferedReader(ficheroLectura);
		String linea="";
		try {
			linea = buffer.readLine();
			while (linea!=null) {
			listaDatos.add(linea);
			linea = buffer.readLine();			
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		}
		try {
			buffer.close();
			ficheroLectura.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el fichero");
		}
		return listaDatos;
	}
}
