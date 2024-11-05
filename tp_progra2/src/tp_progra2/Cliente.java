package tp_progra2;

public class Cliente {
	
	private int dni;
	private String nombre;
	private String telefono;
	
	
	public Cliente(int dni, String nombre, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public boolean estaDni(int dni) {
		return this.dni == dni;
	}

	@Override
	public String toString() {
		return "Dni: " + dni + " nombre: " + nombre + " telefono: " + telefono + " \n";
	}
	
	
	
}
