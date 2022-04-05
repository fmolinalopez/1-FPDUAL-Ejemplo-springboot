package es.fpdual.springboot.servicio;

import java.util.List;

import es.fpdual.springboot.modelo.Alumno;

public interface ServicioAlumno {

	public List<Alumno> getAlumnos();
	
	public Alumno getAlumnoPorId(Integer id);
	
	public Alumno getAlumnoPorNombre(String nombre);
	
	public void cargarAlumnos();
	
	public void eliminarAlumno(Integer id);
	
	public Alumno altaAlumno(Alumno alumno);
	
	public Alumno modificarAlumno(Integer idAlumno, Alumno alumno);
}
