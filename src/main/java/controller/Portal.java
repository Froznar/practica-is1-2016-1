package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import domain.Curso;
import domain.Alumno;
import repository.CursoRepositorio;
import repository.AlumnoRepositorio;


@RestController
public class Portal {
	
	@Autowired
	AlumnoRepositorio alumnoRepositorio;
	
	@Autowired
	CursoRepositorio cursoRepositorio;
	
	@RequestMapping("/alumnos")
	@ResponseBody
	public List<Alumno> alumnos() {
		return alumnoRepositorio.findAll();
	}
	
	@RequestMapping("/cursos")
	@ResponseBody
	public List<Curso> cursos() {
		return cursoRepositorio.findAll();
	}
}
