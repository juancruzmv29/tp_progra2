package tp_progra2;

import java.util.HashMap;

public class Pasaje {
	
	
	private static int codPasaje = 0;
	private String codVuelo;
	private int nroAsiento;
	private String destino;
	private boolean aOcupar;
	private Cliente cliente;
	private double costo = 0;
	
	public Pasaje(Integer dniPasajero, String codVuelo, int nroAsiento, boolean aOcupar) {
		this.codPasaje += 1;
		this.codVuelo = codVuelo;
		this.nroAsiento = nroAsiento;
		this.aOcupar = aOcupar;
	}
	
	public void sacarPasajero() {
		this.cliente = null;
	}
	
	public void aniadirPasajeroAlPasaje(Cliente c) {
		this.cliente = c;
	}
	
	public boolean coincideDniCliente(int dni) {
		return this.cliente.estaDni(dni);
	}
	
	public Cliente obtenerCliente() {
		return this.cliente;
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
