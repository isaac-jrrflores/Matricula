package cibertec.pe.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "tbl_curso")
public class Curso {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cod_Curso")
	private int codigo;
	
	@Column (name = "nombre_Curso", nullable = false, length = 30)
	private String nombre;
	
	@ManyToMany(mappedBy = "cursoList")
	private List<Alumno> alumnos;

	public Curso() {}

	public Curso(int codigo, String nombre, List<Alumno> alumnos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public Curso(String nombre, List<Alumno> alumnos) {
		this.nombre = nombre;
		this.alumnos = alumnos;
	}
		
	public Curso(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
