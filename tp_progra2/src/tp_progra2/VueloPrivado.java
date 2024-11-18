package tp_progra2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class VueloPrivado extends Vuelo {
	
	private double precioPorJet;
	private int cantJets;
	private double precioFijo;
	private HashMap<Integer, Cliente> clienteComprador;
	private HashMap<Integer, Cliente> acompaniantes;
	private int dniComprador;
	private double precio;
	private int[] cantAcompaniantes;
	
	
	
	public VueloPrivado(String origen, String destino, String fecha, int tripulantes, double precio, int dniComprador, int[] cantAcompaniantes) {
		super(origen, destino, fecha, tripulantes);
		this.precio = precio;
		this.dniComprador = dniComprador;
		this.cantAcompaniantes = cantAcompaniantes;
	}


	public void agregarComprador(Cliente c, int dniComprador) {
		clienteComprador.put(dniComprador, c);
	}
	
	public void agregarAcompaniantes(HashMap<Integer, Cliente> acompaniantes) {
		this.acompaniantes = acompaniantes;
	}


	/*
	@Override
	public void aniadirPasajeroAlVuelo(Integer asiento, Cliente c) {
		super.pasajerosVuelo.put(asiento, c);
	}*/

	public String obtenerCodigoVueloPrivado() {
		return this.obtenerCodigoVuelo() + "-PRI";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}





	@Override
	public double obtenerValorVuelo() {
		double monto = 0;
		if(this.cantAcompaniantes[0] > 15) {
			monto = precio * 2 + ((precio * 2) * 30 / 100);
		} else if(this.cantAcompaniantes[1] > 30) {
			monto = precio * 3 + ((precio * 3) * 30 / 100);
		} else if(this.cantAcompaniantes[2] > 45) {
			monto = precio * 4 + ((precio * 4) * 30 / 100);
		}
		else if(this.cantAcompaniantes[3] > 60) {
			monto = precio * 5 + ((precio * 5) * 30 / 100);
		} else {
			monto = precio + (precio * 30 / 100);
		}
		
		return monto;
	}











	

}
