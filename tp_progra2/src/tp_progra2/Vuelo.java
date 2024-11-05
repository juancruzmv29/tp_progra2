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
	private double valorImpuestos;
	public HashMap<Integer, Cliente> pasajerosVuelo; // nroAsiento, Cliente
	
	
	public Vuelo(String origen, String destino, String fecha, int tripulantes) {
		this.codVuelo += 1;
		this.origen = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.tripulantes = tripulantes;
		this.pasajerosVuelo = new HashMap<Integer, Cliente>();
	}

	// recorre el costo de todos los pasajes de registroPasajeros
	public double obtenerCostoVuelo() {
		return 0;
	}
	
	// cancela pasaje de un pasajero, va a sacar el pasajero de registroPasajeros y se va a comunicar con la clase Pasaje
	public void cancelarPasaje(int dniPasajero, int nroAsiento) {
		if(estaPasajero(dniPasajero)) {
			if(pasajerosVuelo.containsKey(nroAsiento)) {
				pasajerosVuelo.put(null, null);
			}
		}
	}
	
	// verifica que esté un pasajero en el vuelo
	private boolean estaPasajero(int dni) {
		for(Map.Entry<Integer, Cliente> pasajero : pasajerosVuelo.entrySet()) {
			if(!pasajero.getValue().estaDni(dni)) {
				return false;
			}
		}
		return true;
	}
	
	// para agregar paajero y el numero de asiento
	public abstract void aniadirPasajeroAlVuelo(Integer asiento, Cliente c);
	
	// para verificar si un asiento esta ocupado
	public boolean asientoOcupado(int nroAsiento) {
		if(pasajerosVuelo.get(nroAsiento) == null) {
			return false;
		}
		return true;
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
	
	public int obtenerCodigoVuelo() {
		return this.codVuelo;
	}
	
	// va a reprogramar los pasajes del vuelo completo
	public void reprogramarPasajes() {
		
	}

	@Override
	public String toString() {
		return "Vuelo codVuelo: " + codVuelo + ", origen: " + origen + " destino: " + destino + " fecha: " + fecha
				+ " tripulantes: " + tripulantes + " valorImpuestos: " + valorImpuestos + " registroPasajeros:"
				+ pasajerosVuelo;
	}
	
 	
	
}
