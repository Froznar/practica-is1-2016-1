package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Alumno;
import domain.Curso;
import domain.Matricula;
import repository.AlumnoRepositorio;
import repository.CursoRepositorio;
import repository.MatriculaRepositorio;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	AlumnoRepositorio alumnoRepositorio;
	CursoRepositorio cursoRepositorio;
	MatriculaRepositorio matriculaRepositorio;

	@Autowired
	public MatriculaServiceImpl(AlumnoRepositorio ar, CursoRepositorio cr,
			MatriculaRepositorio mr) {
		this.alumnoRepositorio = ar;
		this.matriculaRepositorio = mr;
		this.cursoRepositorio = cr;
	}

	@Transactional
	@Override
	public void matricular(Integer alumnoId, String codigoCurso) throws Exception {
		Alumno alumno = alumnoRepositorio.findOne(alumnoId);
		Curso curso = cursoRepositorio.findOne(codigoCurso);
		Matricula matricula = matriculaRepositorio.findByAlumnoAndCurso(alumno, curso);
		if (matricula != null) {
			throw new Exception("MAtricula ya existente");
		}
		matricula = new Matricula();
		matricula.setAlumno(alumno);
		matricula.setCurso(curso);
		matricula.setNota(null);
		
		matriculaRepositorio.save(matricula);
	}

	@Override
	public void retiroCurso(Integer alumnoId, String codigoCurso) {
		Alumno alumno = alumnoRepositorio.findOne(alumnoId);
		Curso curso = cursoRepositorio.findOne(codigoCurso);
		Matricula matricula = matriculaRepositorio.findByAlumnoAndCurso(alumno, curso);
		matriculaRepositorio.delete(matricula);
	}

}