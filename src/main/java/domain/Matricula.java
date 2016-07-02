package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

import domain.Alumno;
import domain.Curso;

@Entity
public class Matricula {
	@Id
	@SequenceGenerator(name = "Matricula_ID_GENERATOR", sequenceName = "Matricula_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Matricula_ID_GENERATOR")	
	private Long id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Curso curso;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Alumno alumno;

	private Double nota;

	private String semestre;

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Alumno getAlumno() {
			return alumno;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
	


