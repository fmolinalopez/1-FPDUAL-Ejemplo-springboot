package es.fpdual.springboot.controlador;

public class AlumnoRequest {

	private String nombre;

	public AlumnoRequest() {
		super();
	}

	public AlumnoRequest(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
