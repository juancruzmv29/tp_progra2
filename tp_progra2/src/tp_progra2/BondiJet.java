package tp_progra2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BondiJet {
	
	
	private String nombre;
	private String cuit;
	private HashMap<Integer, Integer> clientes; // dniCliente, codVuelo 
	private List<Aeropuerto> aeropuertos; 
	private HashMap<Integer, Date> vuelos; // codVuelo, fecha
	private HashMap<Integer, String> registroVuelosPrivados; // codVuelo, dniPasajeroComprador
	
	// Crea la Aerolinea
	public BondiJet(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	
	// registra clientes con nomnre, telefono, dni y los pone en la lista
	public void registrarCliente(String nombre, String telefono, String dni) {
		
	}
	
	// registra un aeropuerto y lo guarda en la lista
	public void registrarAeropuerto(String nombre, String ubicacion, String direccion) {
		
	}
	
	// crea un vuelo nacional y lo adjunta en la tupla vuelos
	public void crearVueloNacional(String destino, int cantAsientos, int totalTripulantes, Date horaSalida
			, Date horaLlegada, String aeropuertoSalida, String aeropuertoLlegada, int maxPasajerosSeccion) {
		
	}
	
	// crea un vuelo internacional y lo adjunta en la tupla vuelos
	public void crearVueloInternacional(String destino, int cantAsientos, int totalTripulantes, Date horaSalida, 
			Date horaLlegada, String aeropuertoSalida, String aeropuertoLlegada, String tipoVueloInt, int maxPasajeros, 
			int escalas) {
		
	}
	
	// crea un vuelo privado y lo adjunta en la tupla vuelos
	public void crearVueloPrivado(String destino, int cantAsientos, int totalTripulantes, Date horaSalida, Date horaLlegada, 
			String aeropuertoSalida, String aeropuertoLlegada, int cantJets, double precioXJet, String dniCliente, 
			List<Pasajero> listaAcompañantes) {
		
	}
	
	// registra un vuelo privado y lo guarda en registroVueloPrivado
	public void registrarVueloPrivado(String dniCliente, List listaAcompañantes, String destino, Date horaSalida, 
			Date horaLlegada, String aeropuertoSalida, String aeropuertoLlegada, List<Seccion> secciones) {
		
	}
	
	// retorna la cantidad de asientos disponibles por codigo de vuelo
	public int consultarAsientosDisponibles(int codigoVuelo) {
		return 0;
	}
	
	// vende un pasaje nacional a un pasajero que tiene que ser cliente.
	public void venderPasajeNacional(String dniPasajero, int codigoVuelo, int nroAsiento) {
		
	}
	
	// vende un pasaje internacional a un pasajero que tiene que ser cliente
	public void venderPasajeInternacional(String dniPasajero, int codigoVuelo, int nroAsiento, Seccion seccion) {
		
	}
	
	// vende un pasaje de vuelo privado a un pasajero cliente
	public void venderVueloPrivado(String dniPasajeroComprador, List<Pasajero> listaPasajeros) {
		
	}
	
	// devuelve la lista de vuelos a un determinado destino
	public List<Vuelo> consultarVuelos(String origen, String destino, Date fecha) {
		 List<Vuelo> vuelos = null;
		
		return vuelos;
	}
	
	// cancela el pasaje de un cliente
	public void cancelarPasaje(String dniPasajero, int codigoVuelo, int nroAsiento) {
		
	}
	
	// devuelve el total recaudado de un determinado destino
	public double totalRecaudado(String destino) {
		return 0;
	}
	
	// retorna un pasajero (cliente) de la lista
	public Pasajero consultarPasajero(String dniCliente) {
		
		Pasajero pasajero = null;
		
		return pasajero;
	}
	
	// retorna un vuelo a partir de un codigo de vuelo
	public Vuelo consultarVuelo(int codigoVuelo) {
		Vuelo vuelo = null;
		
		return vuelo;
	}
	
	// consulta si la aerolinea opera en tal ubicacion
	public boolean consultarAeropuerto(String ubicacion) {
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	
}
