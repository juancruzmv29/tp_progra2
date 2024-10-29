package tp_progra2;

public class Pasaje {
	
	
	private int codPasaje;
	private String dniPasajero;
	private int codVuelo;
	private int nroAsiento;
	private Seccion seccion;
	private String destino;
	private double costoPasaje;
	
	public Pasaje(String dniPasajero, Seccion seccion, int nroAsiento, String destino) {
		this.dniPasajero = dniPasajero;
		this.seccion = seccion;
		this.nroAsiento = nroAsiento;
		this.destino = destino;
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
