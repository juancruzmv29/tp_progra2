package tp_progra2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.*;
import java.util.Date;

public class Aerolinea {

	private String nombre;
	private String cuit;
	private HashMap<Integer, Cliente> clientes; // dni y objeto cliente
	private HashMap<Integer, Vuelo> vuelos; // codVuelo y objeto vuelo
	private HashMap<String, Aeropuerto> aeropuertos; // provincia, aeropuerto
	private StringBuilder sb;
	
	
	public Aerolinea(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	// REGISTRO DE CLIENTE
	public void registrarCliente(int dni, String nombre, String telefono) {
		if(clientes.containsKey(dni)) {
			new RuntimeException("El Dni ya se encuentra registrado");
		}
		Cliente cliente = new Cliente(dni, nombre, telefono);
		clientes.put(dni, cliente);
	}
	
	// REGISTRO DE AEROPUERTO
	public void registrarAeropuerto(String nombre, String pais, String provincia, String direccion) {
		if(aeropuertos.containsKey(provincia)) {
			new RuntimeException("El aeropuerto ya se encuentra registrado");
		}
		Aeropuerto aeropuerto = new Aeropuerto(nombre, pais, provincia, direccion);
		aeropuertos.put(provincia, aeropuerto);
	}
	
	// REGISTRO DE VUELO NACIONAL
	public String registrarVueloPublicoNacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, 
			double[] precios, int[] cantAsientos) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaFormateada = formato.parse(fecha);
		Date fechaHoy = new Date();
		
		if(fechaFormateada.before(fechaHoy)) {
			new RuntimeException("La fecha es anterior a la fecha de hoy... Intente de nuevo");
		}
		
		if(aeropuertos.containsKey(origen) || aeropuertos.containsKey(destino)) {
			new RuntimeException("La aerolinea por ahora no opera en esta ubicación...");
		}
		
		
		VueloNacional vueloNacional = new VueloNacional(origen, destino, fecha, tripulantes, valorRefrigerio, precios, cantAsientos);
		int codVuelo = vueloNacional.obtenerCodigoVuelo();
		
		vuelos.put(codVuelo, vueloNacional);
		
		return codVuelo + "-PUB";
	}
	
	// REGISTRO DE VUELO INTERNACIONAL
	public String registrarVueloPublicoInternacional(String origen, String destino, String fecha, int tripulantes, double valorRefrigerio, 
			int cantRefrigerios, double[] precios,  int[] cantAsientos,  String[] escalas) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaFormateada = formato.parse(fecha);
		Date fechaHoy = new Date();
		
		if(fechaFormateada.before(fechaHoy)) {
			new RuntimeException("La fecha es anterior a la fecha de hoy... Intente de nuevo");
		}
		
		if(aeropuertos.containsKey(origen) || aeropuertos.containsKey(destino)) {
			new RuntimeException("La aerolinea por ahora no opera en esta ubicación...");
		}
		
		VueloInternacional vueloInternacional = new VueloInternacional(origen, destino, fecha, tripulantes, valorRefrigerio, cantRefrigerios, precios, cantAsientos, escalas);
		Integer codVuelo = vueloInternacional.obtenerCodigoVuelo();
		
		return codVuelo +"-PUB";
	}
	
	// VENTA DE VUELOS PRIVADOS
	public String VenderVueloPrivado(String origen, String destino, String fecha, int tripulantes, double precio,  int dniComprador, int[] acompaniantes) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaFormateada = formato.parse(fecha);
		Date fechaHoy = new Date();
		
		if(fechaFormateada.before(fechaHoy)) {
			new RuntimeException("La fecha es anterior a la fecha de hoy... Intente de nuevo");
		}
		
		if(aeropuertos.containsKey(origen) || aeropuertos.containsKey(destino)) {
			new RuntimeException("La aerolinea por ahora no opera en esta ubicación...");
		}
		
		VueloPrivado vueloPrivado = new VueloPrivado(origen, destino, fecha, tripulantes, dniComprador, acompaniantes);
		Integer codVuelo = vueloPrivado.obtenerCodigoVuelo();
		
		return codVuelo + "-PRI";
	}
	
	// ASIENTOS DISPONIBLES DE UN VUELO
	public Map<Integer, String> asientosDisponibles(String codVuelo) {
		Vuelo vuelo = buscarVuelo(codVuelo);
		Map<Integer, String> asientosDisponibles = new HashMap<>();
		String clase = null;
		
		// Si no se encontró vuelo da una excepcion
		if(vuelo == null) {
			new RuntimeException("El vuelo buscado no existe... Por favor intente de nuevo");
		}
		
		// Recorre el diccionario donde estan los asientos y los clientes
		for(Integer nroAsiento : vuelo.pasajerosVuelo.keySet()) {
			// Si vuelo es una instancia de VueloNacional 
			if(vuelo instanceof VueloNacional) {
				VueloNacional vueloNacional = (VueloNacional) vuelo;
				if(nroAsiento > vueloNacional.cantAsientos[0]) {
					clase = "Ejecutiva";
					asientosDisponibles.put(nroAsiento, clase);
				} else if(nroAsiento > vueloNacional.cantAsientos[1]) {
					clase = "Primera clase";
					asientosDisponibles.put(nroAsiento, clase);
				} else {
					clase = "Turista";
					asientosDisponibles.put(nroAsiento, clase);
				}
			}
			
			// Si vuelo es una instancia de VueloInternacional
			if(vuelo instanceof VueloInternacional) {
				VueloInternacional vueloInternacional = (VueloInternacional) vuelo;
				if(nroAsiento > vueloInternacional.cantAsientos[0]) {
					clase = "Ejecutiva";
					asientosDisponibles.put(nroAsiento, clase);
				} else if(nroAsiento > vueloInternacional.cantAsientos[1]) {
					clase = "Primera clase";
					asientosDisponibles.put(nroAsiento, clase);
				} else {
					clase = "Turista";
					asientosDisponibles.put(nroAsiento, clase);
				}
			}
			// Si vuelo es una instancia de vuelo privado, lanza una excepcion
			if(vuelo instanceof VueloPrivado) {
				new RuntimeException("El vuelo es privado... prueba con un vuelo público o privado");
			}
		}
		
		return asientosDisponibles;
	}
	
	// VENTA DE PASAJE
	public int venderPasaje(int dni, String codVuelo, int nroAsiento, boolean aOcupar) {
		Cliente cliente = null;
		
		if(!clientes.containsKey(dni)) {
			new RuntimeException("El dni ingresado no esta registrado como cliente... Para comprar un pasaje tiene que ser cliente");
		} 
		
		for(Integer dniCliente : clientes.keySet()) {
			cliente = clientes.get(dniCliente);
		}
		
		Vuelo vuelo = buscarVuelo(codVuelo);
		
		// Si no se encontró vuelo da una excepcion
		if(vuelo == null) {
			new RuntimeException("El vuelo buscado no existe... Por favor intente de nuevo");
		}
		
		if(vuelo instanceof VueloPrivado) {
			new RuntimeException("El vuelo es privado... prueba con un vuelo público o privado");
		}
		
		Pasaje pasaje = new Pasaje(dni, codVuelo, nroAsiento, aOcupar);
		
		if(vuelo instanceof VueloNacional) {
			VueloNacional vueloNacional = (VueloNacional) vuelo;
			if(vueloNacional.asientoOcupado(nroAsiento)) {
				new RuntimeException("El asiento esta ocupado... intente con otro asiento");
			}
			vueloNacional.aniadirPasajeroAlVuelo(nroAsiento, cliente);
		}
		
		if(vuelo instanceof VueloInternacional) {
			VueloInternacional vueloInternacional = (VueloInternacional) vuelo;
			if(vueloInternacional.asientoOcupado(nroAsiento)) {
				new RuntimeException("El asiento esta ocupado... intente con otro asiento");
			}
			vueloInternacional.aniadirPasajeroAlVuelo(nroAsiento, cliente);
		}
		
		
		
		
		
		
		return pasaje.obtenerCodigoPasaje();
	}
	
	
	// LISTA DE CODIGOS DE VUELOS QUE ESTEN ENTRE UNA FECHA Y SEMANA DESPUES
	public List<String> consultarVuelosSimilares(String origen, String destino, String fecha) throws ParseException {
		List<String> lista = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaFormateada = formato.parse(fecha);
		
		for(Map.Entry<Integer, Vuelo> entrada : vuelos.entrySet()) {
			Integer codigoVuelo = entrada.getKey();
			Vuelo vuelo = entrada.getValue();
			
			if(vuelo.obtenerOrigen().equalsIgnoreCase(origen) && vuelo.obtenerDestino().equalsIgnoreCase(destino)) {
				if(formato.parse(vuelo.obtenerFecha()).after(fechaFormateada)) {
					lista.add(" " + codigoVuelo + "");
				}
			}
		} 
		
		return lista;
	}
	
	// CANCELACION DE PASAJE DADO EL CODIGO DE PASAJE
	public void cancelarPasaje(int dni, String codVuelo, int nroAsiento) {
		
		Vuelo vueloBuscado = buscarVuelo(codVuelo);;
		vueloBuscado.cancelarPasaje(dni, nroAsiento);
		
	}
	
	// CANCELACION DE VUELO
	public List<String> cancelarVuelo(String codVuelo) {
		
		List<String> lista = null;
		
		Vuelo vueloBuscado = buscarVuelo(codVuelo);
		
		for(Map.Entry<Integer, Cliente> pasajerosVuelo : vueloBuscado.pasajerosVuelo.entrySet()) {
			lista.add(pasajerosVuelo.getValue().toString() + " " + codVuelo);
		}
		
		return lista;
	}
	
	
	public double totalRecaudado(String destino) {
		return 0;
	}
	
	
	
	public boolean buscarAeropuerto(String provincia) {
		return true;
	}
	
	public Vuelo buscarVuelo(String codVuelo) {
		Vuelo vuelo = null;
		for(int codigo : vuelos.keySet()) {
			vuelo = vuelos.get(codigo);
		}
		return vuelo;
	}
	
	public String detalleVuelo(String codVuelo) {
		return "";
	}
	
	
	
	
}
