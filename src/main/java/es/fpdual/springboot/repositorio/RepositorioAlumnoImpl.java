package es.fpdual.springboot.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fpdual.springboot.modelo.Alumno;

@Repository
public class RepositorioAlumnoImpl implements RepositorioAlumno {

	private final List<Alumno> alumnos = new ArrayList<>();
	
	@Override
	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	@Override
	public Alumno altaAlumno(Alumno alumno) {
		alumnos.add(alumno);
		
		return alumno;
	}

	@Override
	public Integer getSiguienteId() {
		return this.alumnos.isEmpty() ? 1 : this.alumnos.get(this.alumnos.size()-1).getId() + 1;
	}

	@Override
	public void cargarAlumnos() {
		this.alumnos.add(new Alumno(this.getSiguienteId(), "Fran"));
		this.alumnos.add(new Alumno(this.getSiguienteId(), "Alvaro"));
		this.alumnos.add(new Alumno(this.getSiguienteId(), "Jesus"));
		this.alumnos.add(new Alumno(this.getSiguienteId(), "Miguel"));
	}

	@Override
	public Alumno getAlumnoPorId(Integer id) {
		return this.alumnos.stream().filter(alumno -> alumno.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public Alumno modificarAlumno(Alumno alumno) {
		
		final Alumno alumnoAModificar = this.getAlumnoPorId(alumno.getId());
		
		this.alumnos.set(alumnos.indexOf(alumnoAModificar), alumno);
		
		return alumno;
	}

	@Override
	public void eliminarAlumno(Integer id) {
		this.alumnos.remove(this.getAlumnoPorId(id));
	}

	@Override
	public Alumno getAlumnoPorNombre(String nombre) {
		return this.alumnos.stream().filter(alumno -> alumno.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
	}

}
