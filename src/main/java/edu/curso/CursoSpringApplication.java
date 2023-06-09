package edu.curso;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import edu.curso.domain.Persona;
import edu.curso.models.PersonaRepository;


@SpringBootApplication
public class CursoSpringApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CursoSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}
	
	
	/**
	 * Metodo responsable de dejar disponible en el contexto de spring un bean de CommandLineRunner.
	 * CommandLineRunner nos permite ejecutar lógica en el startup de la aplicación 
	 * @param repo Repository de Ingredientes para persistir los ingredientes
	 * @return
	 */
	@Bean
	CommandLineRunner dataLoader(PersonaRepository repo) {
		return (args -> {
			
			repo.save(new Persona(1L, "Juan", "Larrayoz", 42, true));
			repo.save(new Persona(2L, "Jose", "Perez", 17, false));
			repo.save(new Persona(3L, "Sofia", "Larrayoz", 11, true));
			repo.save(new Persona(4L, "juan", "Rodriguez", 35, true));
			
			log.info("Metodo findPersonasByNombre(\"Juan\")");
			repo.findPersonasByNombre("Juan").forEach(System.out::println);
			
			log.info("Metodo findPersonasByNombre(\"juan\")");
			repo.findPersonasByNombre("juan").forEach(System.out::println);
			
			log.info("Metodo findPersonasByNombreIgnoringCase(\"jUaN\") no es camelcase");
			repo.findPersonasByNombreIgnoringCase("jUaN").forEach(System.out::println);
			
			log.info("findPersonasByNombreAndApellido");
			repo.findPersonasByNombreAndApellido("Sofia", "Larrayoz").forEach(System.out::println);
			
			
			log.info("findPersonasByNombreAndApellidoAllIgnoringCase");
			repo.findPersonasByNombreAndApellidoAllIgnoringCase("sOfIa", "LaRRaYoz").forEach(System.out::println);
			
			log.info("findByEdadBetween");
			repo.findByEdadBetween(11,17).forEach(System.out::println);
			
			log.info("obtenerPersonasApellidoLarrayoz");
			repo.obtenerPersonasApellidoLarrayoz().forEach(System.out::println);
			
			log.info("obtenerPersonasApellidoCustom");
			repo.obtenerPersonasApellidoCustom("Perez").forEach(System.out::println);
			
			log.info("obtenerFirstPersonasByApellido");
			repo.findFirstByApellido("Larrayoz").forEach(System.out::println);
			
			log.info("findAllByOrderByIdDesc");
			repo.findAllByOrderByIdDesc().forEach(System.out::println);
			
			log.info("Otro ejemplo del uso de Sort");
			repo.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(System.out::println);
		
		});
	}
}
