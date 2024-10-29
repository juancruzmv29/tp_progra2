package tp_progra2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public abstract class Vuelo {
	
	private int codVuelo;
	private String aeropuertoSalida;
	private String aeropuertoLlegada;
	private String destino;
	private Date horaSalida;
	private Date horaLlegada;
	private int cantAsientos;
	private int tripulantes;
	private List<Seccion> secciones;
	private List<Refrigerio> refrigerios;
	private double valorImpuestos;
	private HashMap<Pasaje, Pasajero> registroPasajeros;
	
	public Vuelo(String aeropuertoSalida, String aeropuertoLlegada, String destino, 
			Date horaSalida, Date horaLlegada, int cantAsientos, int tripulantes) {
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.destino = destino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.cantAsientos = cantAsientos;
		this.tripulantes = tripulantes;
	}
	
	// recorre el costo de todos los pasajes de registroPasajeros
	public double obtenerCostoVuelo() {
		return 0;
	}
	
	// cancela pasaje de un pasajero, va a sacar el pasajero de registroPasajeros y se va a comunicar con la clase Pasaje
	public void cancelarPasaje(String dniPasajero, int nroAsiento) {
		
	}
	
	// va a reprogramar los pasajes del vuelo completo
	public void reprogramarPasajes() {
		
	}
	
	
}
