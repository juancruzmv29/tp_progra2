package tp_progra2;

import java.util.Date;
import java.util.List;

public class VueloPrivado extends Vuelo {
	
	private double precioPorJet;
	private int cantJets;
	private double precioFijo;
	private int dniComprador;
	private int[] acompaniantes;
	
	
	
	public VueloPrivado(String origen, String destino, String fecha, int tripulantes, int dniComprador, int[] acompaniantes) {
		super(origen, destino, fecha, tripulantes);
		this.dniComprador = dniComprador;
		this.acompaniantes = acompaniantes;
	}





	@Override
	public void aniadirPasajeroAlVuelo(Integer asiento, Cliente c) {
		super.pasajerosVuelo.put(asiento, c);
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}









	

}
