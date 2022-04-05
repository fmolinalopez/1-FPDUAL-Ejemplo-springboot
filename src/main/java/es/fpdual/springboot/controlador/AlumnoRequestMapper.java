package es.fpdual.springboot.controlador;

import es.fpdual.springboot.modelo.Alumno;

public class AlumnoRequestMapper {

	public static Alumno toAlumno(AlumnoRequest alumnoRequest) {
		return new Alumno(alumnoRequest.getNombre());
	}
}
