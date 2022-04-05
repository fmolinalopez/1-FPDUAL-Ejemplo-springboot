package es.fpdual.springboot.controlador;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.springboot.modelo.Alumno;
import es.fpdual.springboot.servicio.ServicioAlumno;

@RestController
public class ControladorAlumno {

	private ServicioAlumno servicioAlumno;
	
	@Autowired
	public ControladorAlumno(ServicioAlumno servicioAlumno) {
		this.servicioAlumno = servicioAlumno;
	}
	
	@GetMapping("/cargarAlumnos")
	public void cargarAlumnos() {
		System.out.println(new Date() + " - Cargando lista de alumnos.");
		this.servicioAlumno.cargarAlumnos();
	}
	
	@GetMapping("/alumnos")
	public List<Alumno> getAlumnos() {
		System.out.println(new Date() + " - Obteniendo lista de alumnos.");
		return this.servicioAlumno.getAlumnos();
	}
	
	@GetMapping("/alumnos/id/{id}")
	public Alumno getAlumnoPorId(@PathVariable("id") Integer id) {
		System.out.println(new Date() + " - Obteniendo alumno con id: " + id);
		return this.servicioAlumno.getAlumnoPorId(id);
	}
	
	@GetMapping("/alumnos/nombre/{nombre}")
	public Alumno getAlumnoPorNombre(@PathVariable("nombre") String nombre) {
		System.out.println(new Date() + " - Obteniendo alumno con nombre: " + nombre);
		return this.servicioAlumno.getAlumnoPorNombre(nombre);
	}
	
	@PostMapping("/alumno")
	public void altaAlumno(@RequestBody AlumnoRequest alumnoRequest) {
		System.out.println(new Date() + " - Guardando alumno: " + alumnoRequest.getNombre());
		this.servicioAlumno.altaAlumno(AlumnoRequestMapper.toAlumno(alumnoRequest));
	}
	
	@PutMapping("/alumnos/{id}")
	public Alumno modificarAlumno(@RequestBody AlumnoRequest alumnoRequest,
			@PathVariable Integer id) {
		System.out.println(new Date() + " - Modificando alumno con id: " + id);
		return this.servicioAlumno.modificarAlumno(id, AlumnoRequestMapper.toAlumno(alumnoRequest));
	}
	
	@DeleteMapping("/alumnos/{id}")
	public void eliminarAlumno(@PathVariable Integer id) {
		System.out.println(new Date() + " - Eliminando alumno con id: " + id);
		this.servicioAlumno.eliminarAlumno(id);
	}
}
