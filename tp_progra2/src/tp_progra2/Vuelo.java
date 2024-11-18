package tp_progra2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Vuelo {
	
	private static int codVuelo = 0;
	private String origen;
	private String destino;
	private String fecha;
	private int tripulantes;
	
	
	
	public Vuelo(String origen, String destino, String fecha, int tripulantes) {
		this.codVuelo += 1;
		this.origen = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.tripulantes = tripulantes;
	}
	
	
	
	
	
	
	public String obtenerFecha() {
		return this.fecha;
	}
	
	public String obtenerOrigen() {
		return this.origen;
	}
	
	public String obtenerDestino() {
		return this.destino;
	}
	
	
	public Integer obtenerCodigoVuelo() {
		return this.codVuelo;
	}
	
	
	
	public abstract double obtenerValorVuelo();

	public String detalleVuelo() {
		return "Vuelo codVuelo: " + codVuelo + ", origen: " + origen + " destino: " + destino + " fecha: " + fecha
				+ " tripulantes: " + tripulantes + " valorImpuestos: " + " registroPasajeros:";
	}
	
 	
	
}
