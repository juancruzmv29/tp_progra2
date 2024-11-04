package tp_progra2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
	}

	// recorre el costo de todos los pasajes de registroPasajeros
	public double obtenerCostoVuelo() {
		return 0;
	}
	
	// cancela pasaje de un pasajero, va a sacar el pasajero de registroPasajeros y se va a comunicar con la clase Pasaje
	public void cancelarPasaje(String dniPasajero, int nroAsiento) {
		
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
