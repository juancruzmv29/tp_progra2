package tp_progra2;

import java.util.HashMap;

public class Pasaje {
	
	
	private static int codPasaje = 0;
	private int dniPasajero;
	private String codVuelo;
	private int nroAsiento;
	private Seccion seccion;
	private String destino;
	private double costoPasaje;
	private boolean aOcupar;
	private HashMap<Integer, Cliente> datosCliente;
	
	public Pasaje(Integer dniPasajero, String codVuelo, int nroAsiento, boolean aOcupar) {
		this.codPasaje += 1;
		this.dniPasajero = dniPasajero;
		this.codVuelo = codVuelo;
		this.nroAsiento = nroAsiento;
		this.aOcupar = aOcupar;
	}
	
	public int obtenerCodigoPasaje() {
		return this.codPasaje;
	}
 	
	public double obtenerCostoPasaje() {
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
