package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.modelo.Alumno;
import cibertec.pe.repository.IAlumnoRepository;

@Service
public class AlumnoImplement implements IAlumnoService{
	
	@Autowired
	private IAlumnoRepository aluRepo;
	
	@Override
	public List<Alumno> getAllAlumno() {
		return aluRepo.findAll();
	}

	@Override
	public Alumno createAlumn(Alumno alumno) {
		return aluRepo.save(alumno);
	}

	@Override
	public void deleteAlumno(int codigo) {
		aluRepo.deleteById(codigo);
	}

	@Override
	public Optional<Alumno> buscarAlumno(int codigo) {
		return aluRepo.findById(codigo);
	}
	
	
	
}
