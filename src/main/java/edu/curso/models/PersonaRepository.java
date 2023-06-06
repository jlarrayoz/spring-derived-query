package edu.curso.models;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.curso.domain.Persona;

public interface PersonaRepository extends ListCrudRepository<Persona, Long>, PagingAndSortingRepository<Persona, Long>{
	
	//Metodos para buscar por nombre
	List<Persona> findPersonasByNombre(String nombre);
	List<Persona> findPersonasByNombreIgnoringCase(String nombre);
	
	//Busca por nombre y apellido
	List<Persona> findPersonasByNombreAndApellido(String nombre, String apellido);
	List<Persona> findPersonasByNombreAndApellidoAllIgnoringCase(String nombre, String apellido);
	
	//Busca por edad
	List<Persona> findByEdadBetween(int edadInicio, int edadFin);
	
	//Custom query
	@Query("select p from Persona p where p.apellido = 'Larrayoz'")
	List<Persona> obtenerPersonasApellidoLarrayoz();
	
	
	//Custom query con parametro
	@Query("select p from Persona p where p.apellido = :apellido")
	List<Persona> obtenerPersonasApellidoCustom(@Param("apellido") String apellido);
	
	
	//Limit o Top (son equivalentes)
	List<Persona> findFirstByApellido(String apellido);
	
	//Order By - Devuelve todos los registros ordenados por Id desc
	List<Persona> findAllByOrderByIdDesc();
	

}
