package tp_progra2;

import java.util.Date;

public class VueloNacional extends Vuelo {
	
	private double valorRefrigerio;
	private double[] precios;
	public int[] cantAsientos;
	

	public VueloNacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, double[] precios, int[] cantAsientos) {
		super(origen, destino, fecha, tripulantes);
		this.valorRefrigerio = valorRefrigerio;
		this.precios = precios;
		this.cantAsientos = cantAsientos;
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



	/*

	@Override
	public String obtenerClase(int nroAsiento) {
		String clase = "";
		for(Integer nroAsiento1 : cantAsientos) {
			if(nroAsiento > this.cantAsientos[0]) {
				clase = "Ejecutiva";
			} else if(nroAsiento > this.cantAsientos[1]) {
				clase = "Primera clase";
			} else {
				clase = "Turista";
			}
		}
		return clase;
	}*/


	public String obtenerCodigoVueloPublico() {
		return this.obtenerCodigoVuelo() + "-PUB";
	}
}
