package cibertec.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.modelo.Curso;
import cibertec.pe.repository.ICursoRepository;

@Service
public class CursoImplement implements ICursoService {

	@Autowired
	private ICursoRepository cursoRepo;
	
	@Override
	public List<Curso> listarCursos() {
		return cursoRepo.findAll();
	}

}
