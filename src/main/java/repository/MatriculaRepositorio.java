package repository;

import org.springframework.data.repository.CrudRepository;

import domain.Alumno;
import domain.Curso;
import domain.Matricula;

public interface MatriculaRepositorio extends CrudRepository<Matricula, Long>{

	Matricula findByAlumnoAndCurso(Alumno alumno, Curso curso);
}

