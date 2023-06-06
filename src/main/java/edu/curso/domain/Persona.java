package edu.curso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Entity
public class Persona {

	@Id
	private Long id;
	
	private String nombre;
	private String apellido;
	private int edad;
	private boolean activo;

}
