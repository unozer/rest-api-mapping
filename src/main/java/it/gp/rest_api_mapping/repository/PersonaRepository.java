package it.gp.rest_api_mapping.repository;

import it.gp.rest_api_mapping.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
