package repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Curso;

public interface CursoRepositorio extends CrudRepository<Curso, String> {
	List<Curso> findAll();
	
	
	Curso findByCodigo(String cod);
}