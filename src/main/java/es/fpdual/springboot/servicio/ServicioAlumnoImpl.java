package es.fpdual.springboot.servicio;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.springboot.modelo.Alumno;
import es.fpdual.springboot.repositorio.RepositorioAlumno;

@Service
public class ServicioAlumnoImpl implements ServicioAlumno {

	private RepositorioAlumno repositorio;
	
	@Autowired
	public ServicioAlumnoImpl(RepositorioAlumno repositorioAlumno) {
		this.repositorio = repositorioAlumno;
	}
	
	@Override
	public List<Alumno> getAlumnos() {
		return this.repositorio.getAlumnos();
	}

	@Override
	public Alumno altaAlumno(Alumno alumno) {
		
		final Alumno alumnoAInsertar = new Alumno(this.repositorio.getSiguienteId(), alumno.getNombre());
		
		return this.repositorio.altaAlumno(alumnoAInsertar);
	}

	@Override
	public void cargarAlumnos() {
		this.repositorio.cargarAlumnos();
	}

	@Override
	public Alumno getAlumnoPorId(Integer id) {
		return this.repositorio.getAlumnoPorId(id);
	}

	@Override
	public Alumno modificarAlumno(Integer idAlumno, Alumno alumno) {
		
		final Alumno alumnoAModificar = this.repositorio.getAlumnoPorId(idAlumno);
		
		if (Objects.nonNull(alumnoAModificar)) {
			return this.repositorio.modificarAlumno(new Alumno(idAlumno, alumno.getNombre()));
		}
		
		return null;
	}

	@Override
	public void eliminarAlumno(Integer id) {
		this.repositorio.eliminarAlumno(id);
	}

	@Override
	public Alumno getAlumnoPorNombre(String nombre) {
		return this.repositorio.getAlumnoPorNombre(nombre);
	}

}
