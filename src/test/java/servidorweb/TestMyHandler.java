package servidorweb;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class TestMyHandler {

	@Test
	public void test_identificar_mensaje_nulo_o_vacio () {
		Assert.assertEquals(MyHandler.identificarMensaje(""), ("La estructura del mensaje es incorrecto, debe introducir el signo '?' segudo de la palabra que desea almacenar o consultar"));
		Assert.assertEquals(MyHandler.identificarMensaje(null), ("La estructura del mensaje es incorrecto, debe introducir el signo '?' segudo de la palabra que desea almacenar o consultar"));
	}
	
	
	@Test
	public void test_identificar_mensaje_erroneo () {
		MyHandler.setMensajeUsuario("/otro?HolaMundo");
		Assert.assertEquals(MyHandler.identificarMensaje("/otro"), ("La estructura del mensaje es incorrecto, debe introducir: \"/almacena?palabra\" o \"/consulta?palabra\""));

	}
	
	
	@Test
	public void test_identificar_mensaje_almacena () {
		MyHandler.setMensajeUsuario("/almacena?HolaMundo");
		Assert.assertEquals(MyHandler.identificarMensaje("/almacena"), ("Mensaje \"" + MyHandler.getMensajeUsuario() + "\" almacenado" + " -> ["+ MyHandler.CODIGO_RESPUESTA+"OK]"));

	}
	
	@Test
	public void test_identificar_mensaje_consulta () {
		MyHandler.setMensajeUsuario("/consulta?HolaMundo");
		Assert.assertEquals(MyHandler.identificarMensaje("/consulta"), ("Mensaje \"" + MyHandler.getMensajeUsuario() + "\" -> ["+ MyHandler.CODIGO_RESPUESTA +"OK] "+ MyHandler.getContador() + " coincidencias"));
	}
	
	
	@Test
	public void test_comprobar_mensaje_vacio () {
		ArrayList<String> listaDatos = new ArrayList<String>();
		MyHandler.setMensajeLimpio("");
		MyHandler.comrpobarMensaje(listaDatos);
		Assert.assertEquals(MyHandler.getContador(), 0);
	}	
	
	
	@Test
	public void test_limpiar_datos_minusculas () {
		Assert.assertEquals(MyHandler.limpiarDato("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), "abcdefghijklmnopqrstuvwxyz");
	}
	
	
	@Test
	public void test_limpiar_datos_minusculas_y_numeros () {
		Assert.assertEquals(MyHandler.limpiarDato("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"), "abcdefghijklmnopqrstuvwxyz1234567890");
	}
	
	
	@Test
	public void test_limpiar_datos_minusculas_numeros_signos () {
		Assert.assertEquals(MyHandler.limpiarDato("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890=!¿'?%&#"), "abcdefghijklmnopqrstuvwxyz1234567890=!¿'?%&#");
	}
	
	
	@Test
	public void test_borrar_tildes_mayusculas () {
		Assert.assertEquals(MyHandler.borrarTilde("ÁÉÍÓÚ"), "AEIOU");
	}
	
	@Test
	public void test_borrar_tildes_minusculas () {
		Assert.assertEquals(MyHandler.borrarTilde("áéíóú"), "aeiou");
	}
	
	@Test
	public void test_borrar_tildes_mayusculas_y_numeros () {
		Assert.assertEquals(MyHandler.borrarTilde("ÁÉÍÓÚ1234567890"), "AEIOU1234567890");
	}
	
	
	@Test
	public void test_borrar_tildes_minusculas_y_numeros () {
		Assert.assertEquals(MyHandler.borrarTilde("áéíóú1234567890"), "aeiou1234567890");
	}
	
	@Test
	public void test_borrar_tildes_mayusculas_numeros_y_signos () {
		Assert.assertEquals(MyHandler.borrarTilde("ÁÉÍÓÚ1234567890=!¿'?%&#"), "AEIOU1234567890=!¿'?%&#");
	}
	
	
	@Test
	public void test_borrar_tildes_minusculas_numeros_y_signos () {
		Assert.assertEquals(MyHandler.borrarTilde("áéíóú1234567890=!¿'?%&#"), "aeiou1234567890=!¿'?%&#");
	}

}
