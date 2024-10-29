package tp_progra2;

import java.util.Date;

public class VueloNacional extends Vuelo {

	private int maxPasajerosPorSeccion;
	
	
	public VueloNacional(String aeropuertoSalida, String aeropuertoLlegada, String destino, Date horaSalida,
			Date horaLlegada, int cantAsientos, int tripulantes, int maxPasajerosPorSeccion) {
		super(aeropuertoSalida, aeropuertoLlegada, destino, horaSalida, horaLlegada, cantAsientos, tripulantes);
		this.maxPasajerosPorSeccion = maxPasajerosPorSeccion;
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
