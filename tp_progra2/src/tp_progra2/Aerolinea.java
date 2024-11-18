package tp_progra2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.text.*;
import java.util.Date;

public class Aerolinea {

	private String nombre;
	private String cuit;
	private HashMap<Integer, Cliente> clientes; // dni y objeto cliente
	private HashMap<String, Vuelo> vuelos; // codVuelo y objeto vuelo
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
			double[] precios, int[] cantAsientos, int maxPasajerosPorSeccion) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaFormateada = formato.parse(fecha);
		Date fechaHoy = new Date();
		
		if(fechaFormateada.before(fechaHoy)) {
			new RuntimeException("La fecha es anterior a la fecha de hoy... Intente de nuevo");
		}
		
		if(aeropuertos.containsKey(origen) || aeropuertos.containsKey(destino)) {
			new RuntimeException("La aerolinea por ahora no opera en esta ubicación...");
		}
		
		
		VueloPublicoNacional vueloNacional = new VueloPublicoNacional(origen, destino, fecha, tripulantes, valorRefrigerio, precios, cantAsientos, maxPasajerosPorSeccion);
		String codVuelo = vueloNacional.obtenerCodigoVueloPublico();
		
		vuelos.put(codVuelo, vueloNacional);
		
		return codVuelo;
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
		
		VueloPublicoInternacional vueloInternacional = new VueloPublicoInternacional(origen, destino, fecha, tripulantes, valorRefrigerio, precios, cantAsientos, escalas);
		String codVuelo = vueloInternacional.obtenerCodigoVueloInternacional();
		
		return codVuelo;
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
		
		VueloPrivado vueloPrivado = new VueloPrivado(origen, destino, fecha, tripulantes, precio, dniComprador, acompaniantes);
		String codVuelo = vueloPrivado.obtenerCodigoVueloPrivado();
		
		return codVuelo;
	}
	
	// ASIENTOS DISPONIBLES DE UN VUELO
	public Map<Integer, String> asientosDisponibles(String codVuelo) {
		VueloPublico vuelo = buscarVuelo(codVuelo);
		Map<Integer, String> asientosDisponibles = new HashMap<>();
		String clase = null;
		
		// Si no se encontró vuelo da una excepcion
		if(vuelo == null) {
			new RuntimeException("El vuelo buscado no existe... Por favor intente de nuevo");
		}
		
		// Recorre los pasajes de un vuelo
		for(Integer nroAsiento : vuelo.pasajesVuelo.keySet()) {
			if(vuelo instanceof VueloPublicoNacional) {
				Pasaje pasaje = vuelo.pasajesVuelo.get(nroAsiento); // obtiene si hay un pasaje en el diccionario dado su numero de asiento
				if(pasaje == null) {
					if(nroAsiento > vuelo.cantAsientos[0]) {
						clase = "Ejecutiva";
					}
				} else if(nroAsiento > vuelo.cantAsientos[1]) {
					clase = "Primera clase";
					asientosDisponibles.put(nroAsiento, clase);
				} else {
					clase = "Turista";
					asientosDisponibles.put(nroAsiento, clase);
				}
			}
			
			if(vuelo instanceof VueloPublicoInternacional) {
				Pasaje pasaje = vuelo.pasajesVuelo.get(nroAsiento);
				if(pasaje == null) {
					if(nroAsiento > vuelo.cantAsientos[0]) {
						clase = "Ejecutiva";
					}
				} else if(nroAsiento > vuelo.cantAsientos[1]) {
					clase = "Primera clase";
					asientosDisponibles.put(nroAsiento, clase);
				} else {
					clase = "Turista";
					asientosDisponibles.put(nroAsiento, clase);
				}
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
		//pasaje.aniadirPasajeroAlPasaje(cliente);
		
		if(vuelo instanceof VueloPublicoNacional) {
			VueloPublicoNacional vueloNacional = (VueloPublicoNacional) vuelo;
			if(vueloNacional.asientoOcupado(nroAsiento)) {
				new RuntimeException("El asiento esta ocupado... intente con otro asiento");
			}
			vueloNacional.aniadirPasajeroAlVuelo(nroAsiento, cliente);
		}
		
		if(vuelo instanceof VueloPublicoInternacional) {
			VueloPublicoInternacional vueloInternacional = (VueloPublicoInternacional) vuelo;
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
		
		for(Map.Entry<String, Vuelo> entrada : vuelos.entrySet()) {
			String codigoVuelo = entrada.getKey();
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
		
		VueloPublico vueloBuscado = buscarVuelo(codVuelo);;
		vueloBuscado.cancelarPasaje(dni, nroAsiento);
		
	}
	
	// CANCELACION DE VUELO
	public List<String> cancelarVuelo(String codVuelo) {
		
		List<String> lista = null;
		
		VueloPublico vueloBuscado = buscarVuelo(codVuelo);
		
		for(Map.Entry<Integer, Pasaje> pasajes : vueloBuscado.pasajesVuelo.entrySet()) {
			Cliente cliente = null;
			cliente = pasajes.getValue().obtenerCliente();
			lista.add(cliente.toString() + " -  CANCELADO");
		}
		
		return lista;
	}
	
	// RECORRE LOS VUELOS DE AEROLINEA POR DESTINO Y DEVUELVE UN RECAUDO DE DINERO
	public double totalRecaudado(String destino) {
		
		double recaudado = 0;
		
		for(Entry<String, Vuelo> vuelos : vuelos.entrySet()) {
			if(vuelos.getValue().obtenerDestino().equalsIgnoreCase(destino)) {
				recaudado += vuelos.getValue().obtenerValorVuelo();
			}
		}
		
		return recaudado;
	}
	
	
	
	public boolean buscarAeropuerto(String provincia) {
		for(Entry<String, Aeropuerto> pro : aeropuertos.entrySet()) {
			if(pro.getKey().equalsIgnoreCase(provincia)) {
				return true;
			}
		}
		return false;
	}
	
	public VueloPublico buscarVuelo(String codVuelo) {
		VueloPublico vuelo = null;
		for(String codigo : vuelos.keySet()) {
			vuelo = (VueloPublico) vuelos.get(codigo);
		}
		return vuelo;
	}
	
	
	
	
	
}
