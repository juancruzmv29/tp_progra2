package tp_progra2;

import java.util.Date;
import java.util.Map.Entry;

public class VueloPublicoNacional extends VueloPublico {
	
	private int maxPasajerosPorSeccion;
	
	
	public VueloPublicoNacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, double[] precios, int[] cantAsientos, 
			int maxPasajerosPorSeccion) {
		super(origen, destino, fecha, tripulantes, valorRefrigerio, precios, cantAsientos);
		this.maxPasajerosPorSeccion = maxPasajerosPorSeccion;
		
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




	public String obtenerCodigoVueloPublico() {
		return this.obtenerCodigoVuelo() + "-PUB";
	}




	@Override
	public double obtenerValorVuelo() {
		double monto = 0;
		for(Entry<Integer, Cliente> pasajeros : this.pasajerosVuelo.entrySet()) {
			if(pasajeros.getKey() > cantAsientos[0] && pasajeros.getValue() != null) {
				// se calcula el precio de cada pasaje + el 20% de impuestos
				monto += precios[1] + (precios[1] * 20 / 100);
			} else if(pasajeros.getKey() < cantAsientos[1] && pasajeros.getValue() != null) {
				monto += precios[0] + (precios[0] * 20 / 100) ;
			}
		}
		
		return monto + valorRefrigerio;
	}




	
}
