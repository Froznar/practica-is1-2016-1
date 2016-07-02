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
import javax.persistence.SequenceGenerator;

@Entity
public class Alumno{
	@Id
	@SequenceGenerator(name = "Alumno_ID_GENERATOR", sequenceName = "Alumno_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Alumno_ID_GENERATOR")	
	private Long alumno_id;

	private String nombres;
	
	private String apellidoPaterno;

	private String apellidoMaterno;
	
	private String DNI;
	private Integer promedio;


	public Alumno() {
	}
	
	public Alumno(String nombres, String apellidoPaterno, Integer promedio) {
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.promedio = promedio;
	}

}
