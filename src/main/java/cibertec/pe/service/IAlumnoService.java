package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.modelo.Alumno;

public interface IAlumnoService {
	public List<Alumno> 	getAllAlumno();
	public Alumno 			createAlumn(Alumno alumno);
	public void 			deleteAlumno(int codigo);
	public Optional<Alumno> buscarAlumno(int codigo);
}
