package tp_progra2;

import java.util.Date;

public class VueloInternacional extends Vuelo{
	
	private double valorRefrigerio;
	private int cantRefrigerios;
	private double precios[];
	public int cantAsientos[];
	private String[] escalas;
	

	
	public VueloInternacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, int cantRefrigerios, double precios[], 
			int[] cantAsientos, String[] escalas) {
		super(origen, destino, fecha, tripulantes);
		this.valorRefrigerio = valorRefrigerio;
		this.cantRefrigerios = cantRefrigerios;
		this.precios = precios;
		this.cantAsientos = cantAsientos;
		this.escalas = escalas;
	}
	
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}





	@Override
	public void aniadirPasajeroAlVuelo(Integer asiento, Cliente c) {
		super.pasajerosVuelo.put(asiento, c);
		
	}

}
