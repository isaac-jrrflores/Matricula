package cibertec.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cibertec.pe.modelo.Alumno;
import cibertec.pe.modelo.Curso;
import cibertec.pe.service.AlumnoImplement;
import cibertec.pe.service.CursoImplement;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoImplement aluImpl;
	
	@Autowired 
	private CursoImplement curImpl;
	
	@GetMapping("/listAllAlumnos")
	public String listarAlumnos(Model modelo)
	{
		modelo.addAttribute("alumnoss", aluImpl.getAllAlumno());
		return "alumnos";
	}
	
	@GetMapping("/newAlumn")
	public String formularioAlumno(Model modelo)
	{
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		modelo.addAttribute("alumno", alumno);
		modelo.addAttribute("curso", curso);
		return "formularioNewAlumno";
	}
	
	@GetMapping("/")
	public String Index()
	{
		return "index";
	}
	
	@PostMapping("/saveAlumno")
	public String guardarAlumno(Alumno alumno)
	{
		aluImpl.createAlumn(alumno);
		return "redirect:/listAllAlumnos";
	}
	
	@GetMapping("/eliminarAlumno/{codigo}")
	public String eliminarAlumno(@PathVariable int codigo)
	{
		aluImpl.deleteAlumno(codigo);
		return "redirect:/listAllAlumnos";
	}
	
	@GetMapping("/editarAlumno/{codigo}")
	public String editarAlumno(@PathVariable int codigo, Model modelo)
	{
		modelo.addAttribute("alumno", aluImpl.buscarAlumno(codigo));
		return ("formularioNewAlumno");
	}
}
