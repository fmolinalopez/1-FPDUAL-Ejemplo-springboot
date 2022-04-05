package es.fpdual.springboot.modelo;

public class Alumno {

	private final Integer id;
	
	private final String nombre;

	public Alumno(String nombre) {
		this(null, nombre);
	}
	
	public Alumno(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}
