package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import domain.Alumno;
import domain.Curso;

public interface AlumnoRepositorio extends CrudRepository<Alumno, Integer> {
	List<Alumno> findAll();
	
	
}

