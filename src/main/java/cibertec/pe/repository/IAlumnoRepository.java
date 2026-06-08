package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.modelo.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {
	
}
