package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.modelo.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {

}
