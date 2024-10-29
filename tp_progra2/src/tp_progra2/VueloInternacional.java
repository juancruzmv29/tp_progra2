package tp_progra2;

import java.util.Date;

public class VueloInternacional extends Vuelo{

	
	private int escalas;
	private String tipoVueloInternacional;
	private int cantRefrigerios;
	
	
	public VueloInternacional(String aeropuertoSalida, String aeropuertoLlegada, String destino, Date horaSalida,
			Date horaLlegada, int cantAsientos, int tripulantes, int escalas, String tipoVuelo,
			 int cantRefrigerios) {
		super(aeropuertoSalida, aeropuertoLlegada, destino, horaSalida, horaLlegada, cantAsientos, tripulantes);
		this.escalas = escalas;
		this.tipoVueloInternacional = tipoVuelo;
		this.cantRefrigerios = cantRefrigerios;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
