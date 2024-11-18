package tp_progra2;

import java.util.HashMap;
import java.util.Map;

public abstract class VueloPublico extends Vuelo{
	
	public HashMap<Integer, Pasaje> pasajesVuelo; // nroAsiento, Pasaje
	private double valorRefrigerio;
	private double[] precios;
	public int[] cantAsientos;

	public VueloPublico(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, double[] precios, int[] cantAsientos) {
		super(origen, destino, fecha, tripulantes);
		this.valorRefrigerio = valorRefrigerio;
		if(this.precios.length <= 1) {
			this.cantAsientos = cantAsientos;
		} else {
			new RuntimeException("Solo se pueden añadir dos precios");
		}
		if(this.cantAsientos.length <= 1) {
			this.cantAsientos = cantAsientos;
		} else {
			new RuntimeException("Solo se pueden añadir dos secciones");
		}
	}
	
	
	// cancela pasaje de un pasajero, va a sacar el pasajero de registroPasajeros y se va a comunicar con la clase Pasaje
		public void cancelarPasaje(int dniPasajero, int nroAsiento) {
			Pasaje pasaje = null;
			if(estaPasajero(dniPasajero)) {
				if(pasajesVuelo.containsKey(nroAsiento)) {
					pasaje = pasajesVuelo.get(nroAsiento);
					pasaje.sacarPasajero();
					pasajesVuelo.put(nroAsiento, null);
				}
			} else {
				new RuntimeException("El pasajero no se encuentra en el vuelo");
			}
		}
		
		// verifica que esté un pasajero en el vuelo
		private boolean estaPasajero(int dni) {
			for(Map.Entry<Integer, Pasaje> pasajes: this.pasajesVuelo.entrySet()) {
				if(pasajes.getValue().coincideDniCliente(dni)) {
					return true;
				}
			}
			return false;
		}
		
		// para agregar paajero y el numero de asiento
		public void aniadirPasajeroAlVuelo(Integer asiento, Cliente c) {
			pasajesVuelo.get(asiento).aniadirPasajeroAlPasaje(c);
		}
		
		// para verificar si un asiento esta ocupado
		public boolean asientoOcupado(int nroAsiento) {
			if(pasajesVuelo.get(nroAsiento) == null) {
				return false;
			}
			return true;
		}

}
