package cibertec.pe;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import cibertec.pe.modelo.Alumno;
import cibertec.pe.modelo.Curso;
import cibertec.pe.repository.IAlumnoRepository;
import cibertec.pe.repository.ICursoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AlumnoRepositoryTest {
	
	@Autowired
	private IAlumnoRepository alu;
	
	@Autowired
	private ICursoRepository cur;
	
	@Test
	@Rollback (false)
	public void saveAlumno() 
	{
		Alumno alumno = new Alumno("Pancracio","Sandalio");
		alu.save(alumno);
	}
	
	@Test
	@Rollback (false)
	public void saveAlumno_Curso()
	{
		Curso curso = new Curso("Java");
		cur.save(curso);
		Curso curso2 = new Curso("C#");
		cur.save(curso2);
		
		List<Curso> listaCurso = new ArrayList();
		listaCurso.add(curso);
		listaCurso.add(curso2);
		
		Alumno alumno = new Alumno("Juan", "Perez", listaCurso);
		alu.save(alumno);
	}
}
