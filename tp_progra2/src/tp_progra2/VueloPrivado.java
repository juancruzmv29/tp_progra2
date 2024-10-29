package tp_progra2;

import java.util.Date;
import java.util.List;

public class VueloPrivado extends Vuelo {
	
	
	private double precioPorJet;
	private Pasajero pasajeroComprador;
	private List<Pasajero> pasajerosAcompañantes;
	private int cantJets;
	private double precioFijo;
	

	public VueloPrivado(String aeropuertoSalida, String aeropuertoLlegada, String destino, Date horaSalida,
			Date horaLlegada, int cantAsientos, int tripulantes, double precioXJet, int cantJets
			, double precioFijo) {
		super(aeropuertoSalida, aeropuertoLlegada, destino, horaSalida, horaLlegada, cantAsientos, tripulantes);
		this.precioPorJet = precioXJet;
		this.cantJets = cantJets;
		this.precioFijo = precioFijo;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
