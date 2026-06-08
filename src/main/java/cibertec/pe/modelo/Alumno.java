	package cibertec.pe.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_Alumno")
public class Alumno {
	@Id
	@Column(name = "cod_Alumno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name = "nombre_Alumno", nullable = false, length = 20)
	private String nombre;
	
	@Column(name = "apellido_Alumno", unique = true)
	private String apellido;
	
	@Column(name = "ema_Alumno", unique = true)
	private String email;
	
	@ManyToMany
	@JoinTable(
			name = "tbl_alumno_curso",
			joinColumns = @JoinColumn(name = "cod_Alumno"),
			inverseJoinColumns = @JoinColumn(name = "cod_Curso")
	)	
	
	private List<Curso> cursoList;
	
	public Alumno() {}

	public Alumno(int codigo, String nombre, String apellido, String email) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public Alumno(String nombre, String apellido, List<Curso> cursoList) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cursoList = cursoList;
	}

	public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Curso> getCursoList() {
		return cursoList;
	}

	public void setCursoList(List<Curso> cursoList) {
		this.cursoList = cursoList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
